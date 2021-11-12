package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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

}
