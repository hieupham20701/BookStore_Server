package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Khachhang;

public interface KhachhangService extends Remote{
	public Khachhang getKhachhangById(int id) throws RemoteException;
	public boolean insertKhachhang(Khachhang khachhang) throws RemoteException; 
	public Khachhang getKhachhang(Khachhang khachhang) throws RemoteException;

}
