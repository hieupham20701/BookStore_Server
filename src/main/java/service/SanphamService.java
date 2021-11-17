package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.LoaiSanpham;
import entity.Nhacungcap;
import entity.Sanpham;

public interface SanphamService extends Remote{
	public Sanpham getSanphamById(int id) throws RemoteException;
	public List<Sanpham> getSanpham() throws RemoteException;
	public boolean insertSanpham(Sanpham sanpham) throws RemoteException;
	public boolean deleteSanpham(int id) throws RemoteException;
	public boolean updateSanpham(Sanpham sanpham) throws RemoteException;
	public List<Sanpham> getSach() throws RemoteException;
	public List<LoaiSanpham> getLoaiSanphams() throws RemoteException;
	public List<Nhacungcap> getNhacungcapServices() throws RemoteException;
	public List<Sanpham> getSanphamByName(String name) throws RemoteException;
	public List<Sanpham> getDodunghoctap(String name) throws RemoteException;
	public List<Sanpham> getSanphamByLoaiSP(String name) throws RemoteException;
	public List<Sanpham> getSanphamAll() throws RemoteException;
}
