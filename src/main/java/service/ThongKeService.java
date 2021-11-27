package service;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import entity.Hoadon;
import entity.Sanpham;
public interface ThongKeService extends Remote {
	public List<Hoadon> searchHDTheoNgay(String batdau,String ketthuc) throws RemoteException;
	public List<Sanpham> getSanPham() throws RemoteException;
	public Map<Integer, Integer> getCountSP(List<String> list,String datebatdau,String dateketthuc) throws RemoteException;
	public Map<Date, Double> getthongkeHDtheongay(String datebatdau,String dateketthuc) throws RemoteException;
}
