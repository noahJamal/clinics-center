package com.clinicCenter.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.bean.AdmainBusinessBeanRemote;
import model.entity.ClinicCenter;
import model.entity.MedicalCheck;

public class adminMedCheckClass {
	private MedicalCheck addMedChk;
	private MedicalCheck updatesMedChk;
	private MedicalCheck deletesMedChk;
	private long medChkID;
	private MedicalCheck selectMedChkID;
	private String medChkNames;
	private List<MedicalCheck> selectMedChkName;
	private List<MedicalCheck> selectAllMedChk;
	
	
	
	

	public List<MedicalCheck> getSelectAllMedChk() {
		return selectAllMedChk;
	}

	public void setSelectAllMedChk(List<MedicalCheck> selectAllMedChk) {
		this.selectAllMedChk = selectAllMedChk;
	}

	public String getMedChkNames() {
		return medChkNames;
	}

	public void setMedChkNames(String medChkNames) {
		this.medChkNames = medChkNames;
	}

	public List<MedicalCheck> getSelectMedChkName() {
		return selectMedChkName;
	}

	public void setSelectMedChkName(List<MedicalCheck> selectMedChkName) {
		this.selectMedChkName = selectMedChkName;
	}

	public long getMedChkID() {
		return medChkID;
	}

	public void setMedChkID(long medChkID) {
		this.medChkID = medChkID;
	}

	public MedicalCheck getSelectMedChkID() {
		return selectMedChkID;
	}

	public void setSelectMedChkID(MedicalCheck selectMedChkID) {
		this.selectMedChkID = selectMedChkID;
	}

	public MedicalCheck getUpdatesMedChk() {
		return updatesMedChk;
	}

	public void setUpdatesMedChk(MedicalCheck updatesMedChk) {
		this.updatesMedChk = updatesMedChk;
	}

	public MedicalCheck getDeletesMedChk() {
		return deletesMedChk;
	}

	public void setDeletesMedChk(MedicalCheck deletesMedChk) {
		this.deletesMedChk = deletesMedChk;
	}

	public MedicalCheck getAddMedChk() {
		return addMedChk;
	}

	public void setAddMedChk(MedicalCheck addMedChk) {
		this.addMedChk = addMedChk;
	}
	
	@PostConstruct
	public void init()
	{
		addMedChk=new MedicalCheck();
		addMedChk.setClinicCenter(new ClinicCenter());
		chosenAllMedicalCheck();
	}
	
	public String insertMedicalCheck()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.addMedicalCheck(addMedChk);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String editMedicalCheck(MedicalCheck data)
	{
		this.updatesMedChk=data;
		return null;
	}
	
	public String updateMedicalCheck()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.updateMedicalCheck(updatesMedChk);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String removeMedicalCheck(MedicalCheck data)
	{
		this.deletesMedChk=data;
		return null;
	}
	
	public String deleteMedicalCheck()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.delMedicalCheck(deletesMedChk);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String chosenMedicalCheckId()
	{
		InitialContext ic;
		try {
			selectMedChkID=new MedicalCheck();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectMedChkID=hp.selectMedicalCheckById(medChkID);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String chosenMedicalCheckName()
	{
		InitialContext ic;
		try {
			selectMedChkName=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectMedChkName=hp.selectByMedCheckName(medChkNames);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String chosenAllMedicalCheck()
	{
		InitialContext ic;
		try {
			selectAllMedChk=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectAllMedChk=hp.selectAllMedicalCheck();
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	

}
