package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface LoginServiece extends Remote {
	public boolean checkLogin(String manv,String matkhau) throws RemoteException;
}
