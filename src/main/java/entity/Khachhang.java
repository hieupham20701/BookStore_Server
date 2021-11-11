package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "khachhang")
public class Khachhang implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ma_kh")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tenkh;
	private String sodienthoai;
	private String diachi;
	private String email;
	
	@OneToMany(mappedBy = "khachhang")
	private List<Hoadon> hoadon;
	public Khachhang() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Khachhang(int id, String tenkh, String sodienthoai, String diachi, String email) {
		super();
		this.id = id;
		this.tenkh = tenkh;
		this.sodienthoai = sodienthoai;
		this.diachi = diachi;
		this.email = email;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	public String getSodienthoai() {
		return sodienthoai;
	}
	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
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


	@Override
	public String toString() {
		return "Khachhang [id=" + id + ", tenkh=" + tenkh + ", sodienthoai=" + sodienthoai + ", diachi=" + diachi
				+ ", email=" + email + "]";
	}

}
