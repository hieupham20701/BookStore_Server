package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Hoadon;
import entity.Sanpham;
import service.ThongKeService;
import utils.HibernateUtils;

public class ThongKeDao extends UnicastRemoteObject implements ThongKeService{
	private static final long serialVersionUID = 1L;
	private static final Double[] Double = null;
	private EntityManager em;
	public ThongKeDao() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		this.em = HibernateUtils.getInstance().getEntityManager();
	}
	@Override
	public List<Hoadon> searchHDTheoNgay(String batdau, String ketthuc) throws RemoteException {
		String sql = "select * from hoadon where ngaylap_hd  between '"+batdau + "' and '"+ketthuc+"'";
		List<Hoadon> list = new ArrayList<Hoadon>();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			list = em.createNativeQuery(sql, Hoadon.class).getResultList();
			tran.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
		return list;
	}
	@Override
	public List<Sanpham> getSanPham() throws RemoteException {
		String sql = "select * from sanpham";
		List<Sanpham> list = new ArrayList<Sanpham>();
		EntityTransaction tran =em.getTransaction();
		try {
			tran.begin();
			list = em.createNativeQuery(sql, Sanpham.class).getResultList();
			tran.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
		return list;
	}
	@Override
	public Map<Integer, Integer> getCountSP(List<String> list, String datebatdau, String dateketthuc) throws RemoteException {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		EntityTransaction tran = em.getTransaction();
		for(String i: list) {
			try {
				String sql = "select sp.ma_sanpham, sum(soluong) as tong from sanpham as sp join chitiethoadon as cthd on sp.ma_sanpham = cthd.masp join hoadon as hd on hd.mahd= cthd.mahd where sp.ma_sanpham = "+i+" and (ngaylap_hd between '"+datebatdau+"' and '"+dateketthuc+"') group by sp.ma_sanpham";
				tran.begin();
				List<?> res = em.createNativeQuery(sql).getResultList();
				for(Object obj: res) {
					Object[] o = (Object[]) obj;
					Integer num = (Integer) o[1];
					map.put((Integer) o[0], (Integer) o[1]);
				}
				tran.commit();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				tran.rollback();
			}
		}
		return map;
	}
	@Override
	public Map<Date, Double> getthongkeHDtheongay(String datebatdau, String dateketthuc) throws RemoteException {
		String sql = "select sum(tongtien) as tong,ngaylap_hd from hoadon where ngaylap_hd between '"+datebatdau+"' and '"+dateketthuc+"' "
				+ "group by ngaylap_hd"
				+ " ORDER BY ngaylap_hd ASC";
		Map<Date, Double> map = new HashMap<Date, Double>();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			List<?> res = em.createNativeQuery(sql).getResultList();
			for(Object obj: res) {
				Object[] o = (Object[]) obj;
				map.put((Date) o[1], (Double) o[0]);
			}
			tran.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
		return map;
	}

}
