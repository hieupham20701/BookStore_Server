package entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Set;

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
@Table(name = "sanpham")
public class Sanpham implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name ="ma_sanpham")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "ten_sp")
	private String tenSanpham;
	@Column(name = "dongia")
	private double dongia;
	@Column(name = "soluongton")
	private int soluongton;
	@Column(name = "trangthai")
	private String trangthai;	
	@Column(name = "hinhanh")
	private byte[] hinhanh;
	@Column(name  ="ten_tacgia")
	private String tenTacgia;
	@Column(name = "sotrang")
	private int sotrang;
	@Column(name = "nhaxuatban")
	private String nhaxuatban;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_loaisp")
	private LoaiSanpham loaisanpham;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_ncc")
	private Nhacungcap nhacungcap;

	
	@OneToMany(mappedBy = "sanpham")
	private Set<ChitietHoadon> chitiethoadon;
	
	public Sanpham() {
		
	}
	public Sanpham(int id, String tenSanpham, double dongia, int soluongton, String trangthai,
			String tenTacgia, int sotrang, String nhaxuatban) {
		super();
		this.id = id;
		this.tenSanpham = tenSanpham;
		this.dongia = dongia;
		this.soluongton = soluongton;
		this.trangthai = trangthai;
		this.tenTacgia = tenTacgia;
		this.sotrang = sotrang;
		this.nhaxuatban = nhaxuatban;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenSanpham() {
		return tenSanpham;
	}
	public void setTenSanpham(String tenSanpham) {
		this.tenSanpham = tenSanpham;
	}
	public double getDongia() {
		return dongia;
	}
	public void setDongia(double dongia) {
		this.dongia = dongia;
	}
	public int getSoluongton() {
		return soluongton;
	}
	public void setSoluongton(int soluongton) {
		this.soluongton = soluongton;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public String getTenTacgia() {
		return tenTacgia;
	}
	public void setTenTacgia(String tenTacgia) {
		this.tenTacgia = tenTacgia;
	}
	public int getSotrang() {
		return sotrang;
	}
	public void setSotrang(int sotrang) {
		this.sotrang = sotrang;
	}
	public String getNhaxuatban() {
		return nhaxuatban;
	}
	public void setNhaxuatban(String nhaxuatban) {
		this.nhaxuatban = nhaxuatban;
	}
	public LoaiSanpham getLoaisanpham() {
		return loaisanpham;
	}
	public void setLoaisanpham(LoaiSanpham loaisanpham) {
		this.loaisanpham = loaisanpham;
	}
	public Nhacungcap getNhacungcap() {
		return nhacungcap;
	}
	public void setNhacungcap(Nhacungcap nhacungcap) {
		this.nhacungcap = nhacungcap;
	}


	
	public byte[] getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(byte[] hinhanh) {
		this.hinhanh = hinhanh;
	}
	@Override
	public String toString() {
		return "Sanpham [tenSanpham=" + tenSanpham + ", dongia=" + dongia + ", soluongton=" + soluongton
				+ ", trangthai=" + trangthai + ", hinhanh=" + hinhanh + ", tenTacgia=" + tenTacgia + ", sotrang="
				+ sotrang + ", nhaxuatban=" + nhaxuatban + ", id=" + id + "]";
	}
	
	 	
	
}
