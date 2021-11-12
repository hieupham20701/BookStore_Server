package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Nhacungcap;

public interface NhacungcapService extends Remote {
	public Nhacungcap getNhaCCById(String id) throws RemoteException;
}
