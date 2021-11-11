package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Sanpham;
import service.SanphamService;
import utils.HibernateUtils;

public class SanphamDao  extends UnicastRemoteObject implements SanphamService{
	private EntityManager em;

	public SanphamDao() throws RemoteException {
		this.em = HibernateUtils.getInstance().getEntityManager();
	}

	public Sanpham getSanphamById(int id) {
		
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

	@Override
	public List<Sanpham> getSanpham() throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction transaction = em.getTransaction();
		List<Sanpham> sanphams = new ArrayList<Sanpham>();
		String sql = "Select * from sanpham";
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

	
}
