package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entity.Calam;
import service.CalamService;
import utils.HibernateUtils;

public class CalamDao implements CalamService {
	
	private EntityManager em;
	public CalamDao() {
		// TODO Auto-generated constructor stub
		this.em = HibernateUtils.getInstance().getEntityManager();
	}
	public Calam getCalamById(String id) {
		// TODO Auto-generated method stub
		Calam calam = null;
		String sql ="select * from chitietcalam ctcl join calam cl \r\n"
				+ "on ctcl.macalam = cl.macalam\r\n"
				+ "where cl.macalam = '"+id+"'";
		
		try {
			calam = (Calam) em.createNativeQuery(sql, Calam.class)
					.getSingleResult();
					
		} catch (Exception e) {
			// TODO: handle exception
		}
				
		return calam;
	}

	@Override
	public Calam getCalam() {
		// TODO Auto-generated method stub
		return null;
	}

}
