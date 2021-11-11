package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Nhacungcap;
import service.NhacungcapService;
import utils.HibernateUtils;

public class NhacungcapDao implements NhacungcapService{

	private EntityManager em;
	public NhacungcapDao() {
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
