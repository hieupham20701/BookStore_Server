package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.LoaiSanpham;

public interface LoaiSanphamService extends Remote{
	public LoaiSanpham getLoaiSanphamById(String id) throws RemoteException;
	public List<LoaiSanpham> getLoaiSP() throws RemoteException;
	public boolean insertLoaiSP(LoaiSanpham loaisp) throws RemoteException;
	public boolean updateLoaiSP(LoaiSanpham loaisp) throws RemoteException;
	public boolean deleteLoaiSP(String maloaisp) throws RemoteException;
}
