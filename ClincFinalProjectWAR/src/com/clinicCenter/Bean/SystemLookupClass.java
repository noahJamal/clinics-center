package com.clinicCenter.Bean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.bean.AdmainBusinessBeanRemote;
import model.bean.SystemLookupBeanRemote;
import model.entity.SystemLookup;

public class SystemLookupClass {
	List<SystemLookup> userType;
	Map<String,String> selectUsersType;
	Map<String,String> selectClinicName;
	List<SystemLookup> clinicName;
    List<SystemLookup> docMajor;
    Map<String,String> selectDocMajor;
    List<SystemLookup> diagnosisType;
    Map<String,String> selectdiagnosisType;
    
    
	

	


	public List<SystemLookup> getDiagnosisType() {
		return diagnosisType;
	}

	public void setDiagnosisType(List<SystemLookup> diagnosisType) {
		this.diagnosisType = diagnosisType;
	}

	public Map<String, String> getSelectdiagnosisType() {
		return selectdiagnosisType;
	}

	public void setSelectdiagnosisType(Map<String, String> selectdiagnosisType) {
		this.selectdiagnosisType = selectdiagnosisType;
	}

	public List<SystemLookup> getMajorId() {
		return docMajor;
	}

	public void setMajorId(List<SystemLookup> majorId) {
		docMajor = majorId;
	}

	public Map<String, String> getSelectDetails() {
		return selectDocMajor;
	}

	public void setSelectDetails(Map<String, String> selectDetails) {
		this.selectDocMajor = selectDetails;
	}

	public List<SystemLookup> getClinicName() {
		return clinicName;
	}

	public void setClinicName(List<SystemLookup> clinicName) {
		this.clinicName = clinicName;
	}

	public Map<String, String> getSelectClinicName() {
		return selectClinicName;
	}

	public void setSelectClinicName(Map<String, String> selectClinicName) {
		this.selectClinicName = selectClinicName;
	}

	public Map<String, String> getSelectUsersType() {
		return selectUsersType;
	}

	public void setSelectUsersType(Map<String, String> selectUsersType) {
		this.selectUsersType = selectUsersType;
	}

	public List<SystemLookup> getUserType() {
		return userType;
	}

	public void setUserType(List<SystemLookup> userType) {
		this.userType = userType;
	}
	
	@PostConstruct
	public void init()
	{
		chosenSystemLookup(""+1);
		chosenSystemLookupClinic(""+2);
		
		
		chosenSystemLookupDocMajorByMajorId(""+3);
		chosenSystemLookupDiagnosisType(""+4);
	}
	
	public List<SystemLookup> chosenSystemLookup(String id)
	{
		InitialContext ic;
		try {

			ic=new InitialContext();
			SystemLookupBeanRemote hp=(SystemLookupBeanRemote) ic.lookup("model.bean.SystemLookupBeanRemote");
			userType=hp.selectLookupBasedMajorID(Integer.parseInt(id));
			selectUsersType=new LinkedHashMap<>();
			for(SystemLookup userId : userType)
			{
				selectUsersType.put(userId.getLookupDescription(),""+ userId.getLookupId());
			}
			return null;
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<SystemLookup> chosenSystemLookupClinic(String id)
	{
		InitialContext ic;
		try {

			ic=new InitialContext();
			SystemLookupBeanRemote hp=(SystemLookupBeanRemote) ic.lookup("model.bean.SystemLookupBeanRemote");
			clinicName=hp.selectLookupBasedMajorID(Integer.parseInt(id));
			selectClinicName=new LinkedHashMap<>();
			for(SystemLookup clinicId : clinicName)
			{
				selectClinicName.put(clinicId.getLookupDescription(),""+ clinicId.getLookupId());
			}
			return null;
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public List<SystemLookup> chosenSystemLookupDocMajorByMajorId(String id)
	{
		
		InitialContext ic;
		try{
			docMajor=new ArrayList<>();
			selectDocMajor=new  LinkedHashMap<>();
			
			ic=new InitialContext();
			SystemLookupBeanRemote hp=(SystemLookupBeanRemote) ic.lookup("model.bean.SystemLookupBeanRemote");
			docMajor=hp.selectLookupBasedMajorID(Integer.parseInt(id));
			for(SystemLookup sysMajId: docMajor)
			{
				selectDocMajor.put(sysMajId.getLookupDescription(), ""+sysMajId.getLookupId());
			}
			return null;
			
			
		}
		catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	public List<SystemLookup> chosenSystemLookupDiagnosisType(String id)
	{
		InitialContext ic;
		try{
			diagnosisType=new ArrayList<>();
			selectdiagnosisType=new  LinkedHashMap<>();
			
			ic=new InitialContext();
			SystemLookupBeanRemote hp=(SystemLookupBeanRemote) ic.lookup("model.bean.SystemLookupBeanRemote");
			diagnosisType=hp.selectLookupBasedMajorID(Integer.parseInt(id));
			for(SystemLookup sysMajId: diagnosisType)
			{
				selectdiagnosisType.put(sysMajId.getLookupDescription(), ""+sysMajId.getLookupId());
			}
			return null;
			
			
		}
		catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
}
