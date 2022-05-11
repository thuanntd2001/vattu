package quanlyvattu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ChiNhanh")
public class ChiNhanhEntity {
	@Id

	@Column(name="MACN")
	private String maCN;
	@Column(name="ChiNhanh")
	private String chiNhanh;
	@Column(name="DIACHI")
	private String diaChi;
	@Column(name="SoDT")
	private String soDT;
	public String getMaCN() {
		return maCN;
	}
	public void setMaCN(String maCN) {
		this.maCN = maCN;
	}
	public String getChiNhanh() {
		return chiNhanh;
	}
	public void setChiNhanh(String chiNhanh) {
		this.chiNhanh = chiNhanh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

}
