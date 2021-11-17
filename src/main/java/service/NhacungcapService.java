package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Nhacungcap;

public interface NhacungcapService extends Remote {
	public Nhacungcap getNhaCCById(String id) throws RemoteException;
	public List<Nhacungcap> getNhaCungCap() throws RemoteException;
	public boolean insertNhaCungCap(Nhacungcap nhacc) throws RemoteException;
	public boolean updateNhaCungCap(Nhacungcap nhacc) throws RemoteException;
	public boolean deleteNhaCungCap(String mancc) throws RemoteException;
}
