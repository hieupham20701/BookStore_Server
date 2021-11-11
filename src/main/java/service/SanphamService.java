package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Sanpham;

public interface SanphamService extends Remote{
	public Sanpham getSanphamById(int id) throws RemoteException;
	public List<Sanpham> getSanpham() throws RemoteException;
}
