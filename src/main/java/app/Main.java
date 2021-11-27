package app;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dao.LoaiSanphamDao;
import dao.NhacungcapDao;
import dao.ThongKeDao;
import dao.TimKiemDao;
import entity.Hoadon;
import entity.LoaiSanpham;
import entity.Nhacungcap;
import entity.Sanpham;
import io.github.cdimascio.dotenv.Dotenv;
import service.LoaiSanphamService;
import service.NhacungcapService;
import service.ThongKeService;
import service.TimKiemService;



public class Main {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		TimKiemService dao = new TimKiemDao();
		Map<String, String> map = new HashMap<String, String>();
		map.put("ma_sanpham", "1004");
		List<Sanpham> list = dao.searchSanPhamDDHT(map);
		for(Sanpham item: list) {
			System.out.println(item.getId());
		}
	}

}
