package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChitietHoadon;

public interface ChitietHoadonService extends Remote {

	List<ChitietHoadon> getChitietHoadonById(int id) throws RemoteException;
}
