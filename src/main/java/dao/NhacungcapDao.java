package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Nhacungcap;
import service.NhacungcapService;
import utils.HibernateUtils;

public class NhacungcapDao extends UnicastRemoteObject implements NhacungcapService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	public NhacungcapDao() throws RemoteException{
		// TODO Auto-generated constructor stub
		this.em = HibernateUtils.getInstance().getEntityManager();
	}
	public Nhacungcap getNhaCCById(String id) {
		
		EntityTransaction trans = em.getTransaction();

		try {
			trans.begin();
			Nhacungcap nhacungcap = em.find(Nhacungcap.class, id);
			trans.commit();
			return nhacungcap;
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			return null;

		}
		
	}
	@Override
	public List<Nhacungcap> getNhaCungCap() throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tran = em.getTransaction();
		List<Nhacungcap> list = new ArrayList<Nhacungcap>();
		String sql = "select * from nhacungcap";
		try {
			tran.begin();
			list = em.createNativeQuery(sql,Nhacungcap.class).getResultList();
			tran.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
		return list;
	}
	@Override
	public boolean insertNhaCungCap(Nhacungcap nhacc) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.persist(nhacc);
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
	public boolean updateNhaCungCap(Nhacungcap nhacc) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.merge(nhacc);
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
	public boolean deleteNhaCungCap(String mancc) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.remove(em.find(Nhacungcap.class, mancc));
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
