package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.SessionFactory;

import entity.LoaiSanpham;
import service.LoaiSanphamService;
import utils.HibernateUtils;

public class LoaiSanphamDao extends UnicastRemoteObject implements LoaiSanphamService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	public LoaiSanphamDao() throws RemoteException {
		super();
		this.em = HibernateUtils.getInstance().getEntityManager();
	}


	public LoaiSanpham getLoaiSanphamById(String id) throws RemoteException {
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			LoaiSanpham loaisp = em.find(LoaiSanpham.class, id);
			trans.commit();
			return loaisp;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
			return null;
		}

	}
	
	@Override
	public List<LoaiSanpham> getLoaiSP() throws RemoteException {
		EntityTransaction tran = em.getTransaction();
		List<LoaiSanpham> listlsp = new ArrayList<LoaiSanpham>();
		String sql = "select * from loaisanpham";
		try {
			tran.begin();
			listlsp = em.createNativeQuery(sql,LoaiSanpham.class).getResultList();
			tran.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
		return listlsp;
	}


	@Override
	public boolean insertLoaiSP(LoaiSanpham loaisp) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.persist(loaisp);
			tran.commit();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
			return false;
		}
	}


	@Override
	public boolean updateLoaiSP(LoaiSanpham loaisp) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.merge(loaisp);
			tran.commit();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
			return false;
		}
		
	}


	@Override
	public boolean deleteLoaiSP(String maloaisp) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.remove(em.find(LoaiSanpham.class, maloaisp));
			tran.commit();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
			return false;
		}
	}
	
}
