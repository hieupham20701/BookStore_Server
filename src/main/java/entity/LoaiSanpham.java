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
@Table(name = "loaisanpham")
public class LoaiSanpham implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ma_loaisp")
	private String id;
	private String tenloaisp;
	@OneToMany(mappedBy = "loaisanpham", fetch = FetchType.LAZY)
	private List<Sanpham> dsSanpham;
	public LoaiSanpham() {
		// TODO Auto-generated constructor stub
	}
	
	public LoaiSanpham(String id, String tenloaisp) {
		super();
		this.id = id;
		this.tenloaisp = tenloaisp;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTenloaisp() {
		return tenloaisp;
	}
	public void setTenloaisp(String tenloaisp) {
		this.tenloaisp = tenloaisp;
	}

	@Override
	public String toString() {
		return "LoaiSanpham [id=" + id + ", tenloaisp=" + tenloaisp + "]";
	}
	
	
}
