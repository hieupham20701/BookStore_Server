package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.LoaiSanpham;

public interface LoaiSanphamService extends Remote{
	public LoaiSanpham getLoaiSanphamById(String id) throws RemoteException;
}
