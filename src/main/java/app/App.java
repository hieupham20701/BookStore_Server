package app;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dao.HoadonDao;
import dao.SanphamDao;
import service.HoadonService;
import service.SanphamService;

public class App {
	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}

		try {
			LocateRegistry.createRegistry(1099);

			SanphamService sanphamService = new SanphamDao();
			Naming.bind("rmi://192.168.1.4:1099/sanphamService", sanphamService);
			HoadonService hoadonService = new HoadonDao();
			Naming.bind("rmi://192.168.1.4:1099/sanphamService", hoadonService);

			System.out.println("Server bound in RMIRegistry");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
