
package com.clinicCenter.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.bean.AdmainBusinessBeanRemote;
import model.entity.ClinicCenter;
import model.entity.Dose;

public class adminDoseClass {
	private Dose addDose;
	private Dose updatesDose;
	private Dose deletesDose;
	private Long doseID;
	private Dose selectDoseId;
	private String dosesName;
	private List<Dose> selectDosesName;
	private List<Dose> SelectAllDoses;
	private List<Object[]> selectOneClincName;
	private Map<String,Long> mapSelectClinicNameID=new HashMap<>();;
	 
	
	
	

	

	

	public Map<String, Long> getMapSelectClinicNameID() {
		return mapSelectClinicNameID;
	}

	public void setMapSelectClinicNameID(Map<String, Long> mapSelectClinicNameID) {
		this.mapSelectClinicNameID = mapSelectClinicNameID;
	}

	public List<Object[]> getSelectOneClincName() {
		return selectOneClincName;
	}

	public void setSelectOneClincName(List<Object[]> selectOneClincName) {
		this.selectOneClincName = selectOneClincName;
	}

	public List<Dose> getSelectAllDoses() {
		return SelectAllDoses;
	}

	public void setSelectAllDoses(List<Dose> selectAllDoses) {
		SelectAllDoses = selectAllDoses;
	}

	public String getDosesName() {
		return dosesName;
	}

	public void setDosesName(String dosesName) {
		this.dosesName = dosesName;
	}

	public List<Dose> getSelectDosesName() {
		return selectDosesName;
	}

	public void setSelectDosesName(List<Dose> selectDosesName) {
		this.selectDosesName = selectDosesName;
	}

	public Dose getSelectDoseId() {
		return selectDoseId;
	}

	public void setSelectDoseId(Dose selectDoseId) {
		this.selectDoseId = selectDoseId;
	}

	

	
	public Long getDoseID() {
		return doseID;
	}

	public void setDoseID(Long doseID) {
		this.doseID = doseID;
	}

	public Dose getUpdatesDose() {
		return updatesDose;
	}

	public void setUpdatesDose(Dose updatesDose) {
		this.updatesDose = updatesDose;
	}

	public Dose getDeletesDose() {
		return deletesDose;
	}

	public void setDeletesDose(Dose deletesDose) {
		this.deletesDose = deletesDose;
	}

	public Dose getAddDose() {
		return addDose;
	}

	public void setAddDose(Dose addDose) {
		this.addDose = addDose;
		
	}
	
	
	

	@PostConstruct
	public void init()
	{
		addDose=new Dose();
		addDose.setClinicCenter(new ClinicCenter());
		chosenAllDose();
		chosenClinicNameAndID();
		

	}
	public String insertDose()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.addDose(addDose);
			chosenAllDose();
			displayMessage(addDose.getDoesName()+"  :  updated");
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
	        
	        clear();
	        
	    }
		return null;
	}
	public String editDose(Dose data)
	{
		this.updatesDose=data;
		return null;
	}
	public String updateDose()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.updateDose(updatesDose);
			chosenAllDose();
			displayMessage(updatesDose.getDoesName()+"  :  updated");
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	public String deleteDose()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.delDose(deletesDose);
			chosenAllDose();
			displayMessage(""+deletesDose.getDoesName()+"  : deleted");
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
	        
	        clear();
	        
	    }
		return null;
	}
	
	public String chosenDoseId()
	{
		InitialContext ic;
		try {
			selectDoseId=new Dose();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			SelectAllDoses=hp.selectDoseById(doseID);
			

			
			
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String chosenDoseName()
	{
		InitialContext ic;
		try {
            selectDosesName=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			SelectAllDoses=hp.selectByDoseName(dosesName);
			
			
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void chosenClinicNameAndID()
	{
		
		InitialContext ic;
		try {
			selectOneClincName=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectOneClincName=hp.selectClinicNameAndID();
			mapSelectClinicNameID=new HashMap<>();
			
			for(Object[] o : selectOneClincName)
			{
				mapSelectClinicNameID.put(o[1].toString(),Long.parseLong(o[0].toString()) );
			}
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public String chosenAllDose()
	{
		InitialContext ic;
		try {
			SelectAllDoses=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			SelectAllDoses=hp.selectAllDose();
			
			
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public List<String> completeTextName(String doseNameComplete)
	{
		InitialContext ic;
		try {
           List<String> selectDosesNameAuto=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectDosesNameAuto=hp.selectByDoseNameAutoComplate(doseNameComplete);
			return selectDosesNameAuto;
			
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void displayMessage(String message)
	{
		FacesContext fct=FacesContext.getCurrentInstance();
		fct.addMessage(null, new FacesMessage(message));
	}
	
	public void clear(){
	
		addDose.setDoesCode(null);
		addDose.setDoesName(null);
		addDose.setDoesCoun(null);
		addDose.setDoesNote(null);
		addDose.setDoesSize(null);
		addDose.setDoesTime(null);
		
	    
	}
	
	public String goToDosePage() {
	    // ...
	    return "doseClinic.xhtml?faces-redirect=true";
	}

}
