package com.clinicCenter.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.bean.AdmainBusinessBeanRemote;
import model.entity.Dose;
import model.entity.Medicine;
import model.entity.Patient;
import model.entity.PatientVisit;
import model.entity.Prescription;

public class adminPrescriptionClass {

	private Prescription addPres;
    private Prescription updatesPres;
    private Prescription deletesPres;
    private long prescriptId;
    private Prescription selectPresId;
    private List<Prescription> selectAllPres;
    private String presName;
    private List<Prescription> selectPresName;
    private String patFFName;
    private String patMMName;
    private String patLLName;
    private List<Prescription> selectPresPatient;
    private Date visitPatDate;
    private List<Prescription> selectPresPatDate;
    
    

	public Date getVisitPatDate() {
		return visitPatDate;
	}

	public void setVisitPatDate(Date visitPatDate) {
		this.visitPatDate = visitPatDate;
	}

	public List<Prescription> getSelectPresPatDate() {
		return selectPresPatDate;
	}

	public void setSelectPresPatDate(List<Prescription> selectPresPatDate) {
		this.selectPresPatDate = selectPresPatDate;
	}

	public String getPatFFName() {
		return patFFName;
	}

	public void setPatFFName(String patFFName) {
		this.patFFName = patFFName;
	}

	public String getPatMMName() {
		return patMMName;
	}

	public void setPatMMName(String patMMName) {
		this.patMMName = patMMName;
	}

	public String getPatLLName() {
		return patLLName;
	}

	public void setPatLLName(String patLLName) {
		this.patLLName = patLLName;
	}

	public List<Prescription> getSelectPresPatient() {
		return selectPresPatient;
	}

	public void setSelectPresPatient(List<Prescription> selectPresPatient) {
		this.selectPresPatient = selectPresPatient;
	}

	public String getPresName() {
		return presName;
	}

	public void setPresName(String presName) {
		this.presName = presName;
	}

	public List<Prescription> getSelectPresName() {
		return selectPresName;
	}

	public void setSelectPresName(List<Prescription> selectPresName) {
		this.selectPresName = selectPresName;
	}

	public List<Prescription> getSelectAllPres() {
		return selectAllPres;
	}

	public void setSelectAllPres(List<Prescription> selectAllPres) {
		this.selectAllPres = selectAllPres;
	}

	public long getPrescriptId() {
		return prescriptId;
	}

	public void setPrescriptId(long prescriptId) {
		this.prescriptId = prescriptId;
	}

	public Prescription getSelectPresId() {
		return selectPresId;
	}

	public void setSelectPresId(Prescription selectPresId) {
		this.selectPresId = selectPresId;
	}

	public Prescription getUpdatesPres() {
		return updatesPres;
	}

	public void setUpdatesPres(Prescription updatesPres) {
		this.updatesPres = updatesPres;
	}

	public Prescription getDeletesPres() {
		return deletesPres;
	}

	public void setDeletesPres(Prescription deletesPres) {
		this.deletesPres = deletesPres;
	}

	public Prescription getAddPres() {
		return addPres;
	}

	public void setAddPres(Prescription addPres) {
		this.addPres = addPres;
	}
	
	@PostConstruct
	public void init()
	{
		addPres=new Prescription();
		addPres.setDose(new Dose());
		addPres.setMedicine(new Medicine());
		addPres.setPatient(new Patient());
		addPres.setPatientVisit(new PatientVisit());
		selectAllPrescriptions();
	}
	
	public String insertPrescription()
	{
		InitialContext ic;
		
		try {
		ic=new InitialContext();
		AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
		hp.addPrescription(addPres);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String editPrescription(Prescription data)
	{
		this.updatesPres=data;
		return null;
	}
	
	public String updatePrescription()
	{
		InitialContext ic;
		
		try {
		ic=new InitialContext();
		AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
		hp.updatePrescription(updatesPres);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String removePrescription(Prescription data)
	{
		this.deletesPres=data;
		return null;
	}
	
	public String deletePrescription()
	{
		InitialContext ic;
		
		try {
		ic=new InitialContext();
		AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
		hp.delPrescription(deletesPres);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String selectPrescriptionId()
	{

		InitialContext ic;
		
		try {
	    selectPresId=new Prescription();
		ic=new InitialContext();
		AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
		selectPresId=hp.selectPrescriptionById(prescriptId);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public String selectAllPrescriptions()
	{

		InitialContext ic;
		
		try {
        selectAllPres=new ArrayList<>();
        ic=new InitialContext();
		AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
		selectAllPres=hp.selectAllPrescription();
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String selectPrescriptionName()
	{

		InitialContext ic;
		
		try {
        selectPresName=new ArrayList<>();
        ic=new InitialContext();
		AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
		selectPresName=hp.selectPrescriptionByName(presName);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String selectPrescriptionPatientName()
	{

		InitialContext ic;
		
		try {
        selectPresPatient=new ArrayList<>();
        ic=new InitialContext();
		AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
		selectPresPatient=hp.selectPrescriptionByPatientName(patFFName, patMMName, patLLName);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String selectPrescriptionVisitDate()
	{

		InitialContext ic;
		
		try {
        selectPresPatDate=new ArrayList<>();
        ic=new InitialContext();
		AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
		selectPresPatDate=hp.selectPrescriptionByVisitDate(visitPatDate);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
}
