package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.LoaiSanpham;
import service.LoaiSanphamService;

public class LoaiSanphamDao implements LoaiSanphamService {

	private SessionFactory sessionFactory;
	
	
	public LoaiSanphamDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}


	public LoaiSanpham getLoaiSanphamById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.getTransaction();
		
		try {
			trans.begin();
			LoaiSanpham loaisp = session.find(LoaiSanpham.class, id);
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
