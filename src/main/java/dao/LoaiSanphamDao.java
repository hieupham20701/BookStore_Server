package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
	
}
