package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChitietHoadon;
import entity.Hoadon;
import entity.Sanpham;

public interface ChitietHoadonService extends Remote {

	public List<ChitietHoadon> getChitietHoadonById(int id) throws RemoteException;
	public boolean insertChitietHoadon(ChitietHoadon chitietHoadon) throws RemoteException;
}
