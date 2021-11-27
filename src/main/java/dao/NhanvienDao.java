package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

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
	public boolean updateTK(Nhanvien nv) throws RemoteException{
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			em.merge(nv);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Nhanvien> getdsNV(){
		EntityTransaction tr=em.getTransaction();
		List<Nhanvien> dsnv=new ArrayList<Nhanvien>();
		String sql="select * from nhanvien";
		try {
			tr.begin();
			dsnv=em.createNativeQuery(sql,Nhanvien.class).getResultList();
			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		 return dsnv;
	}
	  public boolean insert(Nhanvien nv) {
		  EntityTransaction tr=em.getTransaction();
		 // String sql = "insert into nhanvien (ma_nv,ten__nv,sodienthoai,chucvu,diachi,email,matkhau) values (?,?,?,?,?,?,?) ";
		  try {
				tr.begin();
				em.persist(nv);
				tr.commit();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				tr.rollback();
			}
		  return false;
	  }
	  public boolean delete(String manv) {
		  EntityTransaction tr=em.getTransaction();
		  try {
			tr.begin();
			em.remove(em.find(Nhanvien.class, manv));
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		  return false;
	  }
	  public boolean update(Nhanvien nv) {
		  EntityTransaction tr=em.getTransaction();
		  try {
			tr.begin();
			em.merge(nv);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		  return false;
	  }
	  public String getMK(String manv) {
		  EntityTransaction tr=em.getTransaction();
		  String sql="select matkhau from nhanvien where ma_nv='" + manv + "'";
		  String mk;
		  try {
			tr.begin();
			mk=(String) em.createNativeQuery(sql).getSingleResult();
			tr.commit();
			return mk;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
			return null;
			
		}
	  }
	  public String getChucVu(String manv) {
		  EntityTransaction tr=em.getTransaction();
		  String sql="select chucvu from nhanvien where ma_nv='"+manv+"'";
		  String chucvu = null;
		  try {
			tr.begin();
			chucvu=(String) em.createNativeQuery(sql).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
			
		}
		  return chucvu;
	  }
	  
	  public String getTenNV(String manv) {
		  EntityTransaction tr=em.getTransaction();
		  String sql="select ten__nv from nhanvien where ma_nv='"+manv+"'";
		  String ten = null;
		  try {
			tr.begin();
			ten=(String) em.createNativeQuery(sql).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
			
		}
		  return ten;
	  }
	  
}
