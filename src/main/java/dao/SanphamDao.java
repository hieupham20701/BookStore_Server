package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.LoaiSanpham;
import entity.Nhacungcap;
import entity.Sanpham;
import service.SanphamService;
import utils.HibernateUtils;

public class SanphamDao  extends UnicastRemoteObject implements SanphamService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public SanphamDao() throws RemoteException {
		this.em = HibernateUtils.getInstance().getEntityManager();
	}

	public Sanpham getSanphamById(int id) throws RemoteException{
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			Sanpham sanpham = em.find(Sanpham.class, id);
			trans.commit();
			return sanpham;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sanpham> getSanpham() throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction transaction = em.getTransaction();
		List<Sanpham> sanphams = new ArrayList<Sanpham>();
		String sql = "Select * from sanpham where ma_loaisp != 'SA'";
		try {
			transaction.begin();
			sanphams = em.createNativeQuery(sql, Sanpham.class).getResultList();
			
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		return sanphams;
	}

	@Override
	public boolean insertSanpham(Sanpham sanpham) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			em.persist(sanpham);
			trans.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();		
			return false;
		}
		
	}

	@Override
	public boolean deleteSanpham(int id)throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			
			em.remove(em.find(Sanpham.class, id));
			trans.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();	
			return false;
		}

	}
	@Override
	public boolean updateSanpham(Sanpham sanpham) throws RemoteException {
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(sanpham);
			trans.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sanpham> getSach() throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction trans = em.getTransaction();
		String sql = "Select * from sanpham where ma_loaisp = 'SA'";
		List<Sanpham> sanphams = new ArrayList<Sanpham>();
		try {
			trans.begin();
			sanphams = em.createNativeQuery(sql, Sanpham.class).getResultList();
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}
		return sanphams;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoaiSanpham> getLoaiSanphams() throws RemoteException {
		EntityTransaction trans = em.getTransaction();
		List<LoaiSanpham> loaiSanphams = new ArrayList<LoaiSanpham>();
		String sql = "select * from loaisanpham";
		try {
			trans.begin();
			loaiSanphams = em.createNativeQuery(sql, LoaiSanpham.class).getResultList();
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}
		return loaiSanphams;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Nhacungcap> getNhacungcapServices() throws RemoteException {
		EntityTransaction trans = em.getTransaction();
		List<Nhacungcap> nhacungcaps = new ArrayList<Nhacungcap>();
		String sql = "select * from nhacungcap";
		try {
			trans.begin();
			nhacungcaps = em.createNativeQuery(sql, Nhacungcap.class).getResultList();
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}
		return nhacungcaps;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sanpham> getSanphamByName(String name) throws RemoteException {
		List<Sanpham> dsSanpham = new ArrayList<Sanpham>();
		EntityTransaction trans = em.getTransaction();
		String sql = "select * from sanpham where ma_loaisp = 'SA' and ten_sp like N'%"+ name+"%'";
		try {
			trans.begin();
			dsSanpham = em.createNativeQuery(sql, Sanpham.class).getResultList();
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}
		
		return dsSanpham; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sanpham> getDodunghoctap(String name) throws RemoteException {
		List<Sanpham> dsSanpham = new ArrayList<Sanpham>();
		EntityTransaction trans = em.getTransaction();
		String sql = "select * from sanpham where ma_loaisp != 'SA' and ten_sp like N'%"+ name+"%'";
		try {
			trans.begin();
			dsSanpham = em.createNativeQuery(sql, Sanpham.class).getResultList();
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}
		
		return dsSanpham; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sanpham> getSanphamByLoaiSP(String name) throws RemoteException {
		List<Sanpham> dsSanpham = new ArrayList<Sanpham>();
		EntityTransaction trans = em.getTransaction();
		String sql = "Select * from sanpham where ma_loaisp = '"+name+"'";
		try {
			trans.begin();
			dsSanpham = em.createNativeQuery(sql, Sanpham.class).getResultList();
			trans.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
		return dsSanpham;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sanpham> getSanphamAll() throws RemoteException {
		List<Sanpham> dsSanpham = new ArrayList<Sanpham>();
		EntityTransaction trans = em.getTransaction();
		String sql = "Select * from sanpham ";
		try {
			trans.begin();
			dsSanpham = em.createNativeQuery(sql, Sanpham.class).getResultList();
			trans.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
		return dsSanpham;
	}
}
