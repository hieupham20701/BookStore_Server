package app;

import java.rmi.RemoteException;
import java.util.List;

import dao.LoaiSanphamDao;
import dao.NhacungcapDao;
import entity.LoaiSanpham;
import entity.Nhacungcap;
import io.github.cdimascio.dotenv.Dotenv;
import service.LoaiSanphamService;
import service.NhacungcapService;



public class Main {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
//		LoaiSanphamService dao = new LoaiSanphamDao();
//		List<LoaiSanpham> list = dao.getLoaiSP();
//		list.forEach(item -> {
//			System.out.println(item.toString());
//		});
//		dao.deleteLoaiSP("TT");
		NhacungcapService dao = new NhacungcapDao();
		List<Nhacungcap> list = dao.getNhaCungCap();
		list.forEach(item -> {
			System.out.println(item.toString());
		});
	}

}
