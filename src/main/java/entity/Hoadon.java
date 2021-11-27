package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hoadon")
public class Hoadon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mahd;
	@ManyToOne
	@JoinColumn(name = "makh")
	private Khachhang khachhang;
	@ManyToOne
	@JoinColumn(name = "manv")
	private Nhanvien nhanvien;
	@Column(name = "ngaylap_hd")
	private Date ngaylapHd;
	private double tongtien;
	private double sotiennhan;
	private double sotientralai;
	
	@OneToMany(mappedBy = "hoadon")
	private List<ChitietHoadon> chitiethoadon;
	
	public Hoadon() {
		// TODO Auto-generated constructor stub
		this.chitiethoadon = new ArrayList<ChitietHoadon>();
	}
	
	public Hoadon(int mahd, Khachhang khachhang, Nhanvien nhanvien, Date ngaylapHd, double sotiennhan,
			double sotientralai) {
		super();
		this.mahd = mahd;
		this.khachhang = khachhang;
		this.nhanvien = nhanvien;
		this.ngaylapHd = ngaylapHd;
		this.sotiennhan = sotiennhan;
		this.sotientralai = sotientralai;
		this.chitiethoadon = new ArrayList<ChitietHoadon>();
	}
	public void addChitietHoadon(Hoadon hoadon, Sanpham sanpham, double dongia, int soluong) {
		ChitietHoadon cthd = new ChitietHoadon(hoadon, sanpham, dongia, soluong);
		chitiethoadon.add(cthd);
		this.tongtien += (cthd.getDongia()*cthd.getSoluong());
	}
	
	public void updateChitietHoadon(int i, int soluong) {
		double tientru = (chitiethoadon.get(i).getDongia() * chitiethoadon.get(i).getSoluong()) ;
		this.tongtien -= tientru;
		chitiethoadon.get(i).setSoluong(soluong);
		this.tongtien += (chitiethoadon.get(i).getDongia() * chitiethoadon.get(i).getSoluong()) ;
	}
	
	public void removeChitietHoadon(int i) {
		double tientru = (chitiethoadon.get(i).getDongia() * chitiethoadon.get(i).getSoluong()) ;
		chitiethoadon.remove(i);
		this.tongtien -= tientru;
	}
	public int getMahd() {
		return mahd;
	}
	public void setMahd(int mahd) {
		this.mahd = mahd;
	}
	public Khachhang getKhachhang() {
		return khachhang;
	}
	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}
	public Nhanvien getNhanvien() {
		return nhanvien;
	}
	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}
	public Date getNgaylapHd() {
		return ngaylapHd;
	}
	public void setNgaylapHd(Date ngaylapHd) {
		this.ngaylapHd = ngaylapHd;
	}
	public double getSotiennhan() {
		return sotiennhan;
	}
	public void setSotiennhan(double sotiennhan) {
		this.sotiennhan = sotiennhan;
	}
	public double getSotientralai() {
		return sotientralai;
	}
	public void setSotientra(double sotientralai) {
		this.sotientralai = sotientralai;
	}
	public double getTongtien() {
		return tongtien;
	}

	public List<ChitietHoadon> getChitiethoadon() {
		return chitiethoadon;
	}

	public void setSotientralai(double sotientralai) {
		this.sotientralai = sotientralai;
	}

	@Override
	public String toString() {
		return "Hoadon [mahd=" + mahd + ", khachhang=" + khachhang + ", nhanvien=" + nhanvien + ", ngaylapHd="
				+ ngaylapHd + ", tongtien=" + tongtien + ", sotiennhan=" + sotiennhan + ", sotientralai=" + sotientralai
				+ "]";
	}

}
