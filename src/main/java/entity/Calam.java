package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "calam")
public class Calam implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String macalam;
	private String tencalam;
	
	@OneToMany(mappedBy = "calam")
	private List<ChitietCalam> chitietCalam;
	public Calam() {
		// TODO Auto-generated constructor stub
	}
	public Calam(String macalam, String tencalam) {
		super();
		this.macalam = macalam;
		this.tencalam = tencalam;
	}
	public String getMacalam() {
		return macalam;
	}
	public void setMacalam(String macalam) {
		this.macalam = macalam;
	}
	public String getTencalam() {
		return tencalam;
	}
	public void setTencalam(String tencalam) {
		this.tencalam = tencalam;
	}
	@Override
	public String toString() {
		return "Calam [macalam=" + macalam + ", tencalam=" + tencalam + "]";
	}
	
	
}
