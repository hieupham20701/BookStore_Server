package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Calam;

public interface CalamService extends Remote{
	public Calam getCalamById(String id) throws RemoteException;
	public Calam getCalam() throws RemoteException;
}
