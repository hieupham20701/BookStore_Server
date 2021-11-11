package entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class ChitietHoadonPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int hoadon;
	private int sanpham;
	
	public ChitietHoadonPK() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(hoadon, sanpham);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChitietHoadonPK other = (ChitietHoadonPK) obj;
		return hoadon == other.hoadon && sanpham == other.sanpham;
	}
	
}
