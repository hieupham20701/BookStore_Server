package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.query.Query;
import org.hibernate.result.ResultSetOutput;

import entity.ChitietHoadon;
import entity.Hoadon;
import entity.LoaiSanpham;
import entity.Nhacungcap;
import entity.Sanpham;
import service.TimKiemService;
import utils.HibernateUtils;

public class TimKiemDao extends UnicastRemoteObject implements TimKiemService{

	private static final long serialVersionUID = 1L;
	private EntityManager em;
	public TimKiemDao() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		this.em = HibernateUtils.getInstance().getEntityManager();
	}

	/**
	 * 
	 */

	@Override
	public List<LoaiSanpham> searchLoaiSP(Map<String, String> mapTK) throws RemoteException {
		String sql = "select * from loaisanpham where ";
		ArrayList<String> list = new ArrayList<String>();
		Set<String> set = mapTK.keySet();
		for(String key: set) {
			list.add(" " + key + " like N'%" + mapTK.get(key) + "%'");
		}
		String[] arr = new String[list.size()];
		list.toArray(arr);
		sql = sql + String.join(" and ", arr);
		List<LoaiSanpham> dslsp = new ArrayList<LoaiSanpham>();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			dslsp =  em.createNativeQuery(sql,LoaiSanpham.class).getResultList();
			tran.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
		return dslsp;
	}

	@Override
	public List<Nhacungcap> searchNhaCC(Map<String, String> mapTK) throws RemoteException {
		String sql = "select * from nhacungcap where ";
		ArrayList<String> list = new ArrayList<String>();
		Set<String> set = mapTK.keySet();
		for(String key: set) {
			list.add(" " + key + " like N'%" + mapTK.get(key) + "%'");
		}
		String[] arr = new String[list.size()];
		list.toArray(arr);
		sql = sql + String.join(" and ", arr);
		List<Nhacungcap> dsncc = new ArrayList<Nhacungcap>();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			dsncc =  em.createNativeQuery(sql,Nhacungcap.class).getResultList();
			tran.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
		return dsncc;
	}

	@Override
	public List<Hoadon> searchHoaDon(Map<String, String> mapTK) throws RemoteException {
		ArrayList<String> list = new ArrayList<String>();
		String sql =  "select mahd,manv,makh,tongtien,ngaylap_hd,sotiennhan,sotientralai from nhanvien as nv join  hoadon as hd on hd.manv = nv.ma_nv join khachhang as kh on kh.ma_kh = hd.makh where ";
		Set<String> set  = mapTK.keySet();
		for(String key: set) {
			if(key.equals("mahd") || key.equals("sodienthoai")) {
				list.add(" " + key + " = " + mapTK.get(key));
			}else {
				list.add(" " + key + " like N'%"+ mapTK.get(key) + "%'");
			}
		}
		String[] arr = new String[list.size()];
		list.toArray(arr);
		sql = sql + String.join(" and ", arr);
		List<Hoadon> ds = new ArrayList<Hoadon>();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			ds = em.createNativeQuery(sql,Hoadon.class).getResultList();
			tran.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
		return ds;
	}

	@Override
	public List<List<String>> getDanhSachSP(String mahd) throws RemoteException {
		String sql = "select masp, ten_sp, sp.dongia, soluong from chitiethoadon as cthd join sanpham as sp on cthd.masp = sp.ma_sanpham where mahd = "+mahd;
		List<List<String>> list  = new ArrayList<List<String>>();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			List<?> res = em.createNativeQuery(sql).getResultList();
			for(Object obj: res) {
				Object[] o = (Object[]) obj;
				List<String> item = new ArrayList<String>();
				item.add(o[0].toString());
				item.add(o[1].toString());
				item.add(o[2].toString());
				item.add(o[3].toString());
				list.add(item);
			}
			tran.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
		return list;
	}

	@Override
	public List<Sanpham> searchSanPhamSach(Map<String, String> mapTK) throws RemoteException {
		String sql = "select * from sanpham where ma_loaisp = 'SA' and ";
		ArrayList<String> list= new ArrayList<>();
		Set<String> set = mapTK.keySet();
		for(String key: set) {
			if(key.equals("ma_sanpham")) {
				list.add(" " + key + " = " + mapTK.get(key));
			}else {
				list.add(" " + key + " like N'%"+ mapTK.get(key) + "%'");
			}
		}
		String[] arr = new String[list.size()];
		list.toArray(arr);
		sql = sql + String.join(" and ", arr);
		List<Sanpham> ds = new ArrayList<Sanpham>();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			ds = em.createNativeQuery(sql,Sanpham.class).getResultList();
			tran.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
		return ds;
	}

	@Override
	public List<Sanpham> searchSanPhamDDHT(Map<String, String> mapTK) throws RemoteException {
		String sql = "select * from sanpham where ma_loaisp != 'SA' and ";
		ArrayList<String> list= new ArrayList<>();
		Set<String> set = mapTK.keySet();
		for(String key: set) {
			if(key.equals("ma_sanpham")) {
				list.add(" " + key + " = " + mapTK.get(key));
			}else {
				list.add(" " + key + " like N'%"+ mapTK.get(key) + "%'");
			}
		}
		String[] arr = new String[list.size()];
		list.toArray(arr);
		sql = sql + String.join(" and ", arr);
		List<Sanpham> ds = new ArrayList<Sanpham>();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			ds = em.createNativeQuery(sql,Sanpham.class).getResultList();
			tran.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
		return ds;
	}

	
	
}
