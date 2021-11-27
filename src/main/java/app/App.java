package app;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dao.CalamDao;
import dao.ChitietCalamDao;
import dao.ChitietHoadonDao;
import dao.HoadonDao;
import dao.KhachhangDao;
import dao.LoaiSanphamDao;
import dao.LoginDao;
import dao.NhacungcapDao;
import dao.NhanvienDao;
import dao.SanphamDao;
import dao.ThongKeDao;
import dao.TimKiemDao;
import io.github.cdimascio.dotenv.Dotenv;
import service.CalamService;
import service.ChitietCalamService;
import service.ChitietHoadonService;
import service.HoadonService;
import service.KhachhangService;
import service.LoaiSanphamService;
import service.LoginServiece;
import service.NhacungcapService;
import service.NhanvienService;
import service.SanphamService;
import service.ThongKeService;
import service.TimKiemService;

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
			String url = dotenv.get("URL");
			LocateRegistry.createRegistry(1099);
			//SanphamService
			SanphamService sanphamService = new SanphamDao();
			Naming.bind(url + "/sanphamService", sanphamService);
			//HoadonService
			HoadonService hoadonService = new HoadonDao();
			Naming.bind(url + "/hoadonService", hoadonService);
			//CalamService
			CalamService calamService = new CalamDao();
			Naming.bind(url + "/calamService", calamService);
			//ChitietCalamService
			ChitietCalamService chitietCalamService = new ChitietCalamDao();
			Naming.bind(url + "/chitietCalamService", chitietCalamService);
			//ChitietHoadonService
			ChitietHoadonService chitietHoadonService = new ChitietHoadonDao();
			Naming.bind(url + "/chitietHoadonService", chitietHoadonService);
			//KhachhangService
			KhachhangService khachhangService = new KhachhangDao();
			Naming.bind(url + "/khachhangService", khachhangService);
			//LoaiSanphamService
			LoaiSanphamService loaiSanphamService = new LoaiSanphamDao();
			Naming.bind(url + "/loaiSanphamService", loaiSanphamService);
			//Nhacungcapservice
			NhacungcapService nhacungcapService = new NhacungcapDao();
			Naming.bind(url + "/nhacungcapService", nhacungcapService);
			//NhanvienService
			NhanvienService nhanvienService = new NhanvienDao();
			Naming.bind(url +"/nhanvienService", nhanvienService);
			
			TimKiemService timkiemService = new TimKiemDao();
			Naming.bind(url +"/timkiemService", timkiemService);
			
			ThongKeService thongkeService = new ThongKeDao();
			Naming.bind(url +"/thongkeService", thongkeService);
			
			//LoginService
			LoginServiece loginServiece=new LoginDao();
			Naming.bind(url +"/loginServiece", loginServiece);
			System.out.println("Server bound in RMIRegistry");
 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
