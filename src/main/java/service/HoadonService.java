package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Hoadon;

public interface HoadonService extends Remote{
	
	public Hoadon getHoadonbyId(int id) throws RemoteException;
	public Hoadon getHoadonMoi() throws RemoteException;
	public boolean insertHoadon(Hoadon hoadon) throws RemoteException; 
}
