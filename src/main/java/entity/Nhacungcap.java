package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nhacungcap")
public class Nhacungcap implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ma_ncc")
	private String id;
	@Column(name = "ten_ncc")
	private String tenNhaCC;
	private String diachi;
	@OneToMany(mappedBy = "nhacungcap", fetch = FetchType.LAZY)
	private List<Sanpham> dsSanpham;
	public Nhacungcap() {
		// TODO Auto-generated constructor stub
	}

	public Nhacungcap(String id, String tenNhaCC, String diachi) {
		super();
		this.id = id;
		this.tenNhaCC = tenNhaCC;
		this.diachi = diachi;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenNhaCC() {
		return tenNhaCC;
	}

	public void setTenNhaCC(String tenNhaCC) {
		this.tenNhaCC = tenNhaCC;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	@Override
	public String toString() {
		return "Nhacungcap [id=" + id + ", tenNhaCC=" + tenNhaCC + ", diachi=" + diachi + "]";
	}
	
	
	
	
}
