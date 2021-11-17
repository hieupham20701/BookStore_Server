package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Khachhang;
import service.KhachhangService;
import utils.HibernateUtils;

public class KhachhangDao extends UnicastRemoteObject implements KhachhangService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	public KhachhangDao() throws RemoteException{
		// TODO Auto-generated constructor stub
		em = HibernateUtils.getInstance().getEntityManager();
	}
	@Override
	public Khachhang getKhachhangById(int id) throws RemoteException{
		Khachhang khachhang = new Khachhang();
		String sql = "select * from khachhang where ma_kh = "+id;
		
		try {
			khachhang = (Khachhang) em.createNativeQuery(sql, Khachhang.class).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return khachhang;
	}
	@Override
	public boolean insertKhachhang(Khachhang khachhang) throws RemoteException {
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			em.persist(khachhang);
			trans.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}
		return false;
	}

}
