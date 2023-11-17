package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SYSTEM_LOOKUPS database table.
 * 
 */
@Entity
@Table(name="SYSTEM_LOOKUPS")
@NamedQuery(name="SystemLookup.findAll", query="SELECT s FROM SystemLookup s")
public class SystemLookup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LOOKUP_ID")
	private long lookupId;

	@Column(name="LOOKUP_DESCRIPTION")
	private String lookupDescription;

	@Column(name="LOOKUP_MAJOR_ID")
	private BigDecimal lookupMajorId;

	@Column(name="MINOR_ID")
	private BigDecimal minorId;

	public SystemLookup() {
	}

	public long getLookupId() {
		return this.lookupId;
	}

	public void setLookupId(long lookupId) {
		this.lookupId = lookupId;
	}

	public String getLookupDescription() {
		return this.lookupDescription;
	}

	public void setLookupDescription(String lookupDescription) {
		this.lookupDescription = lookupDescription;
	}

	public BigDecimal getLookupMajorId() {
		return this.lookupMajorId;
	}

	public void setLookupMajorId(BigDecimal lookupMajorId) {
		this.lookupMajorId = lookupMajorId;
	}

	public BigDecimal getMinorId() {
		return this.minorId;
	}

	public void setMinorId(BigDecimal minorId) {
		this.minorId = minorId;
	}

}