package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nhanvien")
public class Nhanvien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ma_nv")
	private String id;
	@Column(name = "ten__nv")
	private String tenNhanvien;
	private String sodienthoai;
	private String chucvu;
	private String diachi;
	private String email;
	private String matkhau;
	private double luongcoban;
	
	@OneToMany(mappedBy = "nhanvien")
	private List<ChitietCalam> chitietCalam;
	@OneToMany(mappedBy = "nhanvien")
	private List<Hoadon> hoadon;
	public Nhanvien() {
		// TODO Auto-generated constructor stub
	}
	public Nhanvien(String id, String tenNhanvien, String sodienthoai, String chucvu, String diachi, String email,
			String matkhau, double luongcoban) {
		super();
		this.id = id;
		this.tenNhanvien = tenNhanvien;
		this.sodienthoai = sodienthoai;
		this.chucvu = chucvu;
		this.diachi = diachi;
		this.email = email;
		this.matkhau = matkhau;
		this.luongcoban = luongcoban;
	}
	
	public Nhanvien(String id, String matkhau) {
		super();
		this.id = id;
		this.matkhau = matkhau;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTenNhanvien() {
		return tenNhanvien;
	}
	public void setTenNhanvien(String tenNhanvien) {
		this.tenNhanvien = tenNhanvien;
	}
	public String getSodienthoai() {
		return sodienthoai;
	}
	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public double getLuongcoban() {
		return luongcoban;
	}
	public void setLuongcoban(double luongcoban) {
		this.luongcoban = luongcoban;
	}
	@Override
	public String toString() {
		return "Nhanvien [id=" + id + ", tenNhanvien=" + tenNhanvien + ", sodienthoai=" + sodienthoai + ", chucvu="
				+ chucvu + ", diachi=" + diachi + ", email=" + email + ", matkhau=" + matkhau + ", luongcoban="
				+ luongcoban + "]";
	}
	public Nhanvien(String id, String tenNhanvien, String sodienthoai, String chucvu, String diachi, String email,
			String matkhau) {
		super();
		this.id = id;
		this.tenNhanvien = tenNhanvien;
		this.sodienthoai = sodienthoai;
		this.chucvu = chucvu;
		this.diachi = diachi;
		this.email = email;
		this.matkhau = matkhau;
	}
	public Nhanvien(String id, String tenNhanvien, String sodienthoai, String chucvu, String diachi, String email) {
		super();
		this.id = id;
		this.tenNhanvien = tenNhanvien;
		this.sodienthoai = sodienthoai;
		this.chucvu = chucvu;
		this.diachi = diachi;
		this.email = email;
	}
	
	
}
