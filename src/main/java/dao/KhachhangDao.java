package dao;

import javax.persistence.EntityManager;

import entity.Khachhang;
import service.KhachhangService;
import utils.HibernateUtils;

public class KhachhangDao implements KhachhangService {

	private EntityManager em;
	public KhachhangDao() {
		// TODO Auto-generated constructor stub
		em = HibernateUtils.getInstance().getEntityManager();
	}
	@Override
	public Khachhang getKhachhangById(int id) {
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

}
