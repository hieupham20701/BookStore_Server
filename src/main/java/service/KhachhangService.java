package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Khachhang;

public interface KhachhangService extends Remote{
	public Khachhang getKhachhangById(int id) throws RemoteException;
}
