package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Nhanvien;
import service.NhanvienService;
import utils.HibernateUtils;

public class NhanvienDao extends UnicastRemoteObject implements NhanvienService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	public NhanvienDao() throws RemoteException{
		this.em = HibernateUtils.getInstance().getEntityManager();
	}

	public Nhanvien getNhanvienById(String id) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			Nhanvien nhanvien = em.find(Nhanvien.class, id);
			trans.commit();
			return nhanvien;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}
		return null;
	}

}
