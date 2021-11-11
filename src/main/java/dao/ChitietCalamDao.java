package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entity.Calam;
import entity.ChitietCalam;
import entity.ChitietHoadon;
import service.ChitietHoadonService;
import utils.HibernateUtils;

public class ChitietCalamDao implements ChitietHoadonService {

	
	private EntityManager em;
	public ChitietCalamDao() {
		// TODO Auto-generated constructor stub
		this.em = HibernateUtils.getInstance().getEntityManager();
	}
	public ChitietCalam getChitietCalamById(String id, Calam calam) {
		// TODO Auto-generated method stub
		ChitietCalam chitietcalam = null;
	
		String sql = "select * from chitietcalam ctcl join calam cl\r\n"
				+ "on ctcl.macalam = cl.macalam\r\n"
				+ "where cl.macalam = '"+id+"'";
		
		try {
			chitietcalam = (ChitietCalam) em.createNativeQuery(sql, ChitietCalam.class)
					.getSingleResult();
			calam = (Calam) em.createNativeQuery(sql, Calam.class).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
				
		return chitietcalam;
	}

	@Override
	public List<ChitietHoadon> getChitietHoadonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
