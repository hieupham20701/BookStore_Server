package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Calam;
import entity.ChitietCalam;

public interface ChitietCalamService extends Remote{
	ChitietCalam getChitietCalamById(String id, Calam calam) throws RemoteException;
	
}
