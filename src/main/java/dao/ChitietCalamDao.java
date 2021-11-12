package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.EntityManager;

import entity.Calam;
import entity.ChitietCalam;
import service.ChitietCalamService;
import utils.HibernateUtils;

public class ChitietCalamDao extends UnicastRemoteObject implements ChitietCalamService {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	public ChitietCalamDao() throws RemoteException {
		// TODO Auto-generated constructor stub
		this.em = HibernateUtils.getInstance().getEntityManager();
	}
	public ChitietCalam getChitietCalamById(String id, Calam calam) throws RemoteException{
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

}
