package app;

import java.rmi.RemoteException;

import dao.HoadonDao;
import entity.Hoadon;
import service.HoadonService;

public class Test {
	public static void main(String[] args) throws RemoteException {
		HoadonService hoadonService = new HoadonDao();
		
		Hoadon hoadon = hoadonService.getHoadonbyId(88);
		System.out.println(hoadon.toString());
	}
}
