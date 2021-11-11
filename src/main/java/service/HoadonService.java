package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Hoadon;

public interface HoadonService extends Remote{
	
	Hoadon getHoadonbyId(int id) throws RemoteException;
}
