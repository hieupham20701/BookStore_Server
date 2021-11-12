package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Nhanvien;

public interface NhanvienService extends Remote {
	public Nhanvien getNhanvienById(String id) throws RemoteException;
}
