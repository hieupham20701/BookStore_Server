package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Hoadon;
import service.HoadonService;
import utils.HibernateUtils;

public class HoadonDao extends UnicastRemoteObject implements HoadonService  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	public HoadonDao()  throws RemoteException{
		// TODO Auto-generated constructor stub
		this.em = HibernateUtils.getInstance().getEntityManager();
	}
	@Override
	public Hoadon getHoadonbyId(int id) throws RemoteException {
		// TODO Auto-generated method stub
		Hoadon hoadon = new Hoadon();
		
		try {
			hoadon = em.find(Hoadon.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return hoadon;
	}
	@Override
	public Hoadon getHoadonMoi() throws RemoteException {
		Hoadon hoadon = new Hoadon();
		EntityTransaction trans = em.getTransaction();
		String sql = "Select * from hoadon where mahd = (SELECT IDENT_CURRENT('hoadon'))";
		try {
			trans.begin();
			hoadon = (Hoadon) em.createNativeQuery(sql, Hoadon.class).getSingleResult();
			
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
		}
		return hoadon;
	}
	@Override
	public boolean insertHoadon(Hoadon hoadon) throws RemoteException {
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(hoadon);
			
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
		}
		return false;
	}

}
