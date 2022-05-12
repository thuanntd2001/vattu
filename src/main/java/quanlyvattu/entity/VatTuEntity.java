package quanlyvattu.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="VatTu")

public class VatTuEntity {
	@Id

	@Column(name="MAVT")
	private String maVT;
	@Column(name="TENVT")
	private String tenVT;
	@Column(name="DONVITINH")
	private String donViTinh;
	
	@OneToMany(mappedBy = "vatTu", fetch = FetchType.EAGER)
	List<CTDDHEntity> CTDDHs = new ArrayList<CTDDHEntity>();
	
	@OneToMany(mappedBy = "vatTu", fetch = FetchType.EAGER)
	List<CTPNEntity> CTPNs = new ArrayList<CTPNEntity>();
	
	@OneToMany(mappedBy = "vatTu", fetch = FetchType.EAGER)
	List<CTPXEntity> CTPXs = new ArrayList<CTPXEntity>();
	
	public String getMaVT() {
		return maVT;
	}
	public void setMaVT(String maVT) {
		this.maVT = maVT;
	}
	public String getTenVT() {
		return tenVT;
	}
	public void setTenVT(String tenVT) {
		this.tenVT = tenVT;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	
}
