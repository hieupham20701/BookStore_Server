package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chitiethoadon")
@IdClass(ChitietHoadonPK.class)
public class ChitietHoadon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "mahd")
	private Hoadon hoadon;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "masp")
	private Sanpham sanpham;
	
	@Column(name = "dongia")
	private double dongia;
	@Column(name = "soluong")
	private int soluong;
	@Column(name = "thanhtien")
	private double thanhtien;
	
	public ChitietHoadon() {
		// TODO Auto-generated constructor stub
	}
	
	public ChitietHoadon(Hoadon hoadon, Sanpham sanpham, double dongia, int soluong) {
		super();
		this.hoadon = hoadon;
		this.sanpham = sanpham;
		this.dongia = dongia;
		this.soluong = soluong;
		this.thanhtien = this.dongia * this.soluong;
	}
	public Hoadon getHoadon() {
		return hoadon;
	}
	public void setHoadon(Hoadon hoadon) {
		this.hoadon = hoadon;
	}
	public Sanpham getSanpham() {
		return sanpham;
	}
	public void setSanpham(Sanpham sanpham) {
		this.sanpham = sanpham;
	}
	public double getDongia() {
		return dongia;
	}
	public void setDongia(double dongia) {
		this.dongia = dongia;
	}
	public double getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public double getThanhtien() {
		return thanhtien;
	}
	@Override
	public String toString() {
		return "ChitietHoadon [hoadon=" + hoadon + ", sanpham=" + sanpham + ", dongia=" + dongia + ", soluong="
				+ soluong + ", thanhtien=" + thanhtien + "]";
	}
}
