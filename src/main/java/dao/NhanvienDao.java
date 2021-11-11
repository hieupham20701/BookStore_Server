package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Nhanvien;
import service.NhanvienService;
import utils.HibernateUtils;

public class NhanvienDao implements NhanvienService{

	private EntityManager em;
	
	public NhanvienDao() {
		this.em = HibernateUtils.getInstance().getEntityManager();
	}

	public Nhanvien getNhanvienById(String id) {
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
