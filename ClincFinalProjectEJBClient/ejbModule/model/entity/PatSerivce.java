package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PAT_SERIVCE database table.
 * 
 */
@Entity
@Table(name="PAT_SERIVCE")
@NamedQuery(name="PatSerivce.findAll", query="SELECT p FROM PatSerivce p")
public class PatSerivce implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SER_ID")
	private long serId;

	@Column(name="SER_CODE")
	private BigDecimal serCode;

	@Column(name="SER_NAME")
	private String serName;

	@Column(name="SER_NOTE")
	private String serNote;

	@Column(name="SER_PRICE")
	private BigDecimal serPrice;

	@Column(name="SER_TYPE")
	private String serType;

	//bi-directional many-to-one association to DiscretionSer
	@OneToMany(mappedBy="patSerivce")
	private List<DiscretionSer> discretionSers;

	//bi-directional many-to-one association to ClinicCenter
	@ManyToOne
	@JoinColumn(name="CLI_ID")
	private ClinicCenter clinicCenter;

	public PatSerivce() {
	}

	public long getSerId() {
		return this.serId;
	}

	public void setSerId(long serId) {
		this.serId = serId;
	}

	public BigDecimal getSerCode() {
		return this.serCode;
	}

	public void setSerCode(BigDecimal serCode) {
		this.serCode = serCode;
	}

	public String getSerName() {
		return this.serName;
	}

	public void setSerName(String serName) {
		this.serName = serName;
	}

	public String getSerNote() {
		return this.serNote;
	}

	public void setSerNote(String serNote) {
		this.serNote = serNote;
	}

	public BigDecimal getSerPrice() {
		return this.serPrice;
	}

	public void setSerPrice(BigDecimal serPrice) {
		this.serPrice = serPrice;
	}

	public String getSerType() {
		return this.serType;
	}

	public void setSerType(String serType) {
		this.serType = serType;
	}

	public List<DiscretionSer> getDiscretionSers() {
		return this.discretionSers;
	}

	public void setDiscretionSers(List<DiscretionSer> discretionSers) {
		this.discretionSers = discretionSers;
	}

	public DiscretionSer addDiscretionSer(DiscretionSer discretionSer) {
		getDiscretionSers().add(discretionSer);
		discretionSer.setPatSerivce(this);

		return discretionSer;
	}

	public DiscretionSer removeDiscretionSer(DiscretionSer discretionSer) {
		getDiscretionSers().remove(discretionSer);
		discretionSer.setPatSerivce(null);

		return discretionSer;
	}

	public ClinicCenter getClinicCenter() {
		return this.clinicCenter;
	}

	public void setClinicCenter(ClinicCenter clinicCenter) {
		this.clinicCenter = clinicCenter;
	}

}