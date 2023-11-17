package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the DIAGNOSIS database table.
 * 
 */
@Entity
@Table(name="DIAGNOSIS")
@NamedQuery(name="Diagnosi.findAll", query="SELECT d FROM Diagnosi d")
public class Diagnosi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DIG_ID")
	private long digId;

	@Column(name="DIG_CODE")
	private BigDecimal digCode;

	@Column(name="DIG_NAME")
	private String digName;

	@Column(name="DIG_NOTE")
	private String digNote;

	@Column(name="DIG_TYPE")
	private String digType;

	//bi-directional many-to-one association to ClinicCenter
	@ManyToOne
	@JoinColumn(name="CLI_ID")
	private ClinicCenter clinicCenter;

	//bi-directional many-to-one association to DiagnList
	@OneToMany(mappedBy="diagnosi")
	private List<DiagnList> diagnLists;

	public Diagnosi() {
	}

	public long getDigId() {
		return this.digId;
	}

	public void setDigId(long digId) {
		this.digId = digId;
	}

	public BigDecimal getDigCode() {
		return this.digCode;
	}

	public void setDigCode(BigDecimal digCode) {
		this.digCode = digCode;
	}

	public String getDigName() {
		return this.digName;
	}

	public void setDigName(String digName) {
		this.digName = digName;
	}

	public String getDigNote() {
		return this.digNote;
	}

	public void setDigNote(String digNote) {
		this.digNote = digNote;
	}

	public String getDigType() {
		return this.digType;
	}

	public void setDigType(String digType) {
		this.digType = digType;
	}

	public ClinicCenter getClinicCenter() {
		return this.clinicCenter;
	}

	public void setClinicCenter(ClinicCenter clinicCenter) {
		this.clinicCenter = clinicCenter;
	}

	public List<DiagnList> getDiagnLists() {
		return this.diagnLists;
	}

	public void setDiagnLists(List<DiagnList> diagnLists) {
		this.diagnLists = diagnLists;
	}

	public DiagnList addDiagnList(DiagnList diagnList) {
		getDiagnLists().add(diagnList);
		diagnList.setDiagnosi(this);

		return diagnList;
	}

	public DiagnList removeDiagnList(DiagnList diagnList) {
		getDiagnLists().remove(diagnList);
		diagnList.setDiagnosi(null);

		return diagnList;
	}

}