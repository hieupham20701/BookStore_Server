package app;

import java.rmi.RemoteException;
import java.util.List;

import dao.LoaiSanphamDao;
import entity.LoaiSanpham;
import io.github.cdimascio.dotenv.Dotenv;
import service.LoaiSanphamService;



public class Main {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
//		LoaiSanphamService dao = new LoaiSanphamDao();
//		List<LoaiSanpham> list = dao.getLoaiSP();
//		list.forEach(item -> {
//			System.out.println(item.toString());
//		});
//		dao.deleteLoaiSP("TT");
		Dotenv dotenv = Dotenv.configure()
				  .directory("assets\\.env")
				  .ignoreIfMalformed()
				  .ignoreIfMissing()
				  .load();
		System.out.print(dotenv.get("Test"));
	}

}
