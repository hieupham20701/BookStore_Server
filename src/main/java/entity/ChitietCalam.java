package entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chitietcalam")
@IdClass(ChitietCalamPK.class)
public class ChitietCalam implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name = "macalam")
	private Calam calam;
	@Id
	@ManyToOne
	@JoinColumn(name = "manv")
	private Nhanvien nhanvien;
	@Id
	private Date ngaylam;
	
	private String trangthai;
	public ChitietCalam() {
		// TODO Auto-generated constructor stub
	}

	public ChitietCalam(Calam calam, Nhanvien nhanvien, Date ngaylam, String trangthai) {
		super();
		this.calam = calam;
		this.nhanvien = nhanvien;
		this.ngaylam = ngaylam;
		this.trangthai = trangthai;
	}



	public Calam getCalam() {
		return calam;
	}

	public void setCalam(Calam calam) {
		this.calam = calam;
	}

	public Nhanvien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public Date getNgaylam() {
		return ngaylam;
	}

	public void setNgaylam(Date ngaylam) {
		this.ngaylam = ngaylam;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	@Override
	public String toString() {
		return "ChitietCalam [calam=" + calam + ", nhanvien=" + nhanvien + ", ngaylam=" + ngaylam + ", trangthai="
				+ trangthai + "]";
	}
}
