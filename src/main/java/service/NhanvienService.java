package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Nhanvien;

public interface NhanvienService extends Remote {
	public Nhanvien getNhanvienById(String id) throws RemoteException;
	public boolean updateTK(Nhanvien nv) throws RemoteException;
	public List<Nhanvien> getdsNV() throws RemoteException;
	public boolean insert(Nhanvien nv)throws RemoteException;
	public boolean delete(String manv) throws RemoteException;
	public boolean update(Nhanvien nv)throws RemoteException;
	public String getMK(String manv) throws RemoteException;
	public String getTenNV(String manv) throws RemoteException;
	 public String getChucVu(String manv) throws RemoteException;
}
