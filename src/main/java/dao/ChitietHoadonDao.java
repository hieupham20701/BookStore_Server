package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.ChitietHoadon;
import service.ChitietHoadonService;
import utils.HibernateUtils;

public class ChitietHoadonDao extends UnicastRemoteObject implements ChitietHoadonService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	public ChitietHoadonDao() throws RemoteException {
		// TODO Auto-generated constructor stub
		this.em = HibernateUtils.getInstance().getEntityManager();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ChitietHoadon> getChitietHoadonById(int id) throws RemoteException {
		List<ChitietHoadon> cthd = new ArrayList<ChitietHoadon>();
		String sql = "Select * from chitiethoadon where mahd = "+id;
		try {
			cthd = em.createNativeQuery(sql, ChitietHoadon.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cthd;
	}
	@Override
	public boolean insertChitietHoadon(ChitietHoadon chitietHoadon) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(chitietHoadon);
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
		}
		return false;
	}
	
}
