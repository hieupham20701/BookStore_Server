package service;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import entity.Hoadon;
import entity.LoaiSanpham;
import entity.Nhacungcap;
import entity.Sanpham;

public interface TimKiemService extends Remote{
	public List<LoaiSanpham> searchLoaiSP(Map<String, String> mapTK) throws RemoteException;
	public List<Nhacungcap> searchNhaCC(Map<String, String> mapTK) throws RemoteException;
	public List<Hoadon> searchHoaDon(Map<String, String> mapTK) throws RemoteException;
	public List<List<String>> getDanhSachSP(String mahd) throws RemoteException;
	public List<Sanpham> searchSanPhamSach(Map<String, String> mapTK) throws RemoteException;
	public List<Sanpham> searchSanPhamDDHT(Map<String, String> mapTK) throws RemoteException;
}
