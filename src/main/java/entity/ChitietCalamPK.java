package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class ChitietCalamPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String calam;
	private String nhanvien;
	private Date ngaylam;
	public ChitietCalamPK() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(calam, ngaylam, nhanvien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChitietCalamPK other = (ChitietCalamPK) obj;
		return Objects.equals(calam, other.calam) && Objects.equals(ngaylam, other.ngaylam)
				&& Objects.equals(nhanvien, other.nhanvien);
	}

}
