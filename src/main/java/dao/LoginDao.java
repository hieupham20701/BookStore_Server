package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Nhanvien;
import service.LoginServiece;
import utils.HibernateUtils;

public class LoginDao extends UnicastRemoteObject implements LoginServiece  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;
    
    public LoginDao() throws RemoteException{
    	this.em=HibernateUtils.getInstance().getEntityManager();
    	
    }
    @SuppressWarnings("unchecked")
	public boolean checkLogin(String manv,String matkhau) {
    	EntityTransaction transaction=em.getTransaction();
    	//List<Nhanvien> nv=new ArrayList<Nhanvien>();
    	String sql="select * from nhanvien where ma_nv='"+manv+"' and matkhau='"+matkhau+"'";
    	try {
			transaction.begin();
           em.createNativeQuery(sql,Nhanvien.class).getResultList();
			transaction.commit();
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
    	
    }
}
