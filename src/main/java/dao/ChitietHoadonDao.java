package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import entity.ChitietHoadon;
import service.ChitietHoadonService;
import utils.HibernateUtils;

public class ChitietHoadonDao implements ChitietHoadonService{
	
	private EntityManager em;
	
	public ChitietHoadonDao() {
		// TODO Auto-generated constructor stub
		this.em = HibernateUtils.getInstance().getEntityManager();
	}
	@Override
	public List<ChitietHoadon> getChitietHoadonById(int id) {
		List<ChitietHoadon> cthd = new ArrayList<ChitietHoadon>();
		String sql = "Select * from chitiethoadon where mahd = "+id;
		try {
			cthd = em.createNativeQuery(sql, ChitietHoadon.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cthd;
	}
	
}
