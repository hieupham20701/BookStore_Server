package app;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dao.CalamDao;
import dao.ChitietCalamDao;
import dao.ChitietHoadonDao;
import dao.HoadonDao;
import dao.KhachhangDao;
import dao.LoaiSanphamDao;
import dao.NhacungcapDao;
import dao.NhanvienDao;
import dao.SanphamDao;
import io.github.cdimascio.dotenv.Dotenv;
import service.CalamService;
import service.ChitietCalamService;
import service.ChitietHoadonService;
import service.HoadonService;
import service.KhachhangService;
import service.LoaiSanphamService;
import service.NhacungcapService;
import service.NhanvienService;
import service.SanphamService;

public class App {
	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
//			String ip = "192.168.1.6";
			Dotenv dotenv = Dotenv.configure()
					  .directory("assets\\.env")
					  .ignoreIfMalformed()
					  .ignoreIfMissing()
					  .load();
			String ip = dotenv.get("Test");
			LocateRegistry.createRegistry(1099);
			//SanphamService
			SanphamService sanphamService = new SanphamDao();
			Naming.bind("rmi://"+ip+":1099/sanphamService", sanphamService);
			//HoadonService
			HoadonService hoadonService = new HoadonDao();
			Naming.bind("rmi://"+ip+":1099/hoadonService", hoadonService);
			//CalamService
			CalamService calamService = new CalamDao();
			Naming.bind("rmi://"+ip+":1099/calamService", calamService);
			//ChitietCalamService
			ChitietCalamService chitietCalamService = new ChitietCalamDao();
			Naming.bind("rmi://"+ip+":1099/chitietCalamService", chitietCalamService);
			//ChitietHoadonService
			ChitietHoadonService chitietHoadonService = new ChitietHoadonDao();
			Naming.bind("rmi://"+ip+":1099/chitietHoadonService", chitietHoadonService);
			//KhachhangService
			KhachhangService khachhangService = new KhachhangDao();
			Naming.bind("rmi://"+ip+":1099/khachhangService", khachhangService);
			//LoaiSanphamService
			LoaiSanphamService loaiSanphamService = new LoaiSanphamDao();
			Naming.bind("rmi://"+ip+":1099/loaiSanphamService", loaiSanphamService);
			//Nhacungcapservice
			NhacungcapService nhacungcapService = new NhacungcapDao();
			Naming.bind("rmi://"+ip+":1099/nhacungcapService", nhacungcapService);
			//NhanvienService
			NhanvienService nhanvienService = new NhanvienDao();
			Naming.bind("rmi://"+ip+":1099/nhanvienService", nhanvienService);
			
			System.out.println("Server bound in RMIRegistry");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
