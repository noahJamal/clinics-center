package com.clinicCenter.Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.primefaces.model.FilterMeta;

import model.bean.AdmainBusinessBeanRemote;
import model.entity.ClinicCenter;
import model.entity.Medicine;

public class adminMedicineClass  {
	private Medicine addMed;
	private Medicine updatesMed;
	private Medicine deletesMes;
	private Long medicineId;
	private List<Medicine> selectMedId;
	private String medName;
	private List<Medicine> selectMedName;
	private String medScienceName;
	private List<Medicine> selectMedScienceName;
	private List<Medicine> selectAllMed;
	private List<Medicine> selectAllddd;
	
	
	
	
	
	



	public List<Medicine> getSelectAllddd() {
		return selectAllddd;
	}

	public void setSelectAllddd(List<Medicine> selectAllddd) {
		this.selectAllddd = selectAllddd;
	}

	public List<Medicine> getSelectAllMed() {
		return selectAllMed;
	}

	public void setSelectAllMed(List<Medicine> selectAllMed) {
		this.selectAllMed = selectAllMed;
	}

	public String getMedScienceName() {
		return medScienceName;
	}

	public void setMedScienceName(String medScienceName) {
		this.medScienceName = medScienceName;
	}

	public List<Medicine> getSelectMedScienceName() {
		return selectMedScienceName;
	}

	public void setSelectMedScienceName(List<Medicine> selectMedScienceName) {
		this.selectMedScienceName = selectMedScienceName;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public List<Medicine> getSelectMedName() {
		return selectMedName;
	}

	public void setSelectMedName(List<Medicine> selectMedName) {
		this.selectMedName = selectMedName;
	}



	public Long getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}



	public List<Medicine> getSelectMedId() {
		return selectMedId;
	}

	public void setSelectMedId(List<Medicine> selectMedId) {
		this.selectMedId = selectMedId;
	}

	public Medicine getDeletesMes() {
		return deletesMes;
	}

	public void setDeletesMes(Medicine deletesMes) {
		this.deletesMes = deletesMes;
	}

	public Medicine getUpdatesMed() {
		return updatesMed;
	}

	public void setUpdatesMed(Medicine updatesMed) {
		this.updatesMed = updatesMed;
	}

	public Medicine getAddMed() {
		return addMed;
	}

	public void setAddMed(Medicine addMed) {
		this.addMed = addMed;
	}
	
	@PostConstruct
	public void init()
	{
		addMed=new Medicine();
		addMed.setClinicCenter(new ClinicCenter());
		chosenAllMedicine();
		
		
	}
	public String insertMedicine()
	{
		InitialContext ic;
		
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.addMedicine(addMed);
			chosenAllMedicine();
			displayMessage(" Medicine ID: "+addMed.getMedId()+" has been added");

		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public String editMedicine(Medicine data)
	{
		this.updatesMed=data;
		
		return null;
	}
	public String updateMedicine(CellEditEvent event)
	{   
		DataTable dataTable=(DataTable) event.getSource();
		updatesMed=new Medicine();
		updatesMed=(Medicine) dataTable.getRowData();
		
		InitialContext ic;
		
		try {
			
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.updateMedicine(updatesMed);
			chosenAllMedicine();
			displayMessage(" Medicine ID: "+updatesMed.getMedId()+" has been adjustment");
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String removeMedicine(Medicine data)
	{
		this.deletesMes=data;
		
		return null;
	}
	public String deleteMedicine()
	{
		InitialContext ic;
		
		try {
			
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.delMedicine(deletesMes);
			chosenAllMedicine();
			displayMessage(" Medicine ID: "+deletesMes.getMedId()+" has been deleted");
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
public String SelectMedicineId()
{
	InitialContext ic;
	try {
		selectAllMed=new ArrayList<>();
		ic=new InitialContext();
		AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
		
		
		if(!hp.selectMedicineById(medicineId).contains(null))
		{
			selectAllMed=hp.selectMedicineById(medicineId);
			successDisplayMessage("Medicine ID : "+medicineId+" is exist. ");

		}
		else
		{
			errorDisplayMessage("Medicine ID : "+medicineId+" isn't exist. ");

		}
		
		
	} catch (NamingException e) {
		// TODO: handle exception
		e.printStackTrace();
	} 
	return null;}


public String chosenMedicineName()
{
	InitialContext ic;
	try {
		selectAllMed=new ArrayList<>();
		ic=new InitialContext();
		AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
		if(!hp.selectMedicineByMedName(medName).isEmpty())
		{
			selectAllMed=hp.selectMedicineByMedName(medName);
			successDisplayMessage("Medicine Name : "+medName+" is exist. ");

		}
		else
		{
			errorDisplayMessage("Medicine Name : "+medName+" isn't exist. ");

		}
		
	} catch (NamingException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return  null;
	}
public String chosenMedicineScienceName()
{
	InitialContext ic;
	try {
		selectAllMed=new ArrayList<>();
		ic=new InitialContext();
		AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
		
		if(!hp.selectMedicineByMedSName(medScienceName).isEmpty())
		{
			selectAllMed=hp.selectMedicineByMedSName(medScienceName);
			successDisplayMessage("Medicine Scientific Name : "+medScienceName+" is exist. ");

		}
		else
		{
			errorDisplayMessage("Medicine Scientific Name : "+medScienceName+" isn't exist. ");

		}
		
	} catch (NamingException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return  null;
	}
public String chosenAllMedicine()
{
	InitialContext ic;
try {

	selectAllMed=new ArrayList<>();
	ic=new InitialContext();
	AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
	selectAllMed=hp.selectAllMedicine();
	
} catch (NamingException e) {
	// TODO: handle exception
	e.printStackTrace();
}
	return null;}

public List<String> completeTextName(String medNameComplete)
{
	InitialContext ic;
	try {
		List<String> selectMedNameAuto=new ArrayList<>();
		ic=new InitialContext();
		AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
		selectMedNameAuto=hp.selectMedicineByMedNameAutoComp(medNameComplete);
		return selectMedNameAuto;
		
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}

public List<String> completeMedSName(String medSNameComplete)
{
	InitialContext ic;
	try {
		List<String> selectMedNameAuto=new ArrayList<>();
		ic=new InitialContext();
		AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
		selectMedNameAuto=hp.selectMedicineByMedSNameAutoComp(medSNameComplete);
		return selectMedNameAuto;
		
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}

public void displayMessage(String message)
{
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Success : ",message));	
}

public void successDisplayMessage(String message)
{
	FacesContext fc=FacesContext.getCurrentInstance();
	fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Success:",message));
	
	}

public void errorDisplayMessage(String message)
{
	FacesContext fc=FacesContext.getCurrentInstance();
	fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error:",message));
	
	}


public String goToMedicinesPage() {
    // ...
    return "medicineClinic.xhtml?faces-redirect=true";
}
}



