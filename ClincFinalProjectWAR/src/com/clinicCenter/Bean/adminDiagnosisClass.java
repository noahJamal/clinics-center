package com.clinicCenter.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.bean.AdmainBusinessBeanRemote;
import model.entity.ClinicCenter;
import model.entity.Diagnosi;

public class adminDiagnosisClass {
	
	private Diagnosi addDiags;
	private Diagnosi updatesDiags;
	private Diagnosi deletesDiags;
	private Diagnosi selectDiagsId;
    private long diagsId;
    private String diagsName;
    private List<Diagnosi> selectdiagsName;
    private List<Diagnosi> selectAllDiags;
    private List<Diagnosi> selectedDiagnosisDelete;
    
    
	

	public List<Diagnosi> getSelectedDiagnosisDelete() {
		return selectedDiagnosisDelete;
	}

	public void setSelectedDiagnosisDelete(List<Diagnosi> selectedDiagnosisDelete) {
		this.selectedDiagnosisDelete = selectedDiagnosisDelete;
	}

	public List<Diagnosi> getSelectAllDiags() {
		return selectAllDiags;
	}

	public void setSelectAllDiags(List<Diagnosi> selectAllDiags) {
		this.selectAllDiags = selectAllDiags;
	}

	public String getDiagsName() {
		return diagsName;
	}

	public void setDiagsName(String diagsName) {
		this.diagsName = diagsName;
	}

	public List<Diagnosi> getSelectdiagsName() {
		return selectdiagsName;
	}

	public void setSelectdiagsName(List<Diagnosi> selectdiagsName) {
		this.selectdiagsName = selectdiagsName;
	}

	public Diagnosi getSelectDiagsId() {
		return selectDiagsId;
	}

	public void setSelectDiagsId(Diagnosi selectDiagsId) {
		this.selectDiagsId = selectDiagsId;
	}

	public long getDiagsId() {
		return diagsId;
	}

	public void setDiagsId(long diagsId) {
		this.diagsId = diagsId;
	}

	public Diagnosi getDeletesDiags() {
		return deletesDiags;
	}

	public void setDeletesDiags(Diagnosi deletesDiags) {
		this.deletesDiags = deletesDiags;
	}

	public Diagnosi getUpdatesDiags() {
		return updatesDiags;
	}

	public void setUpdatesDiags(Diagnosi updatesDiags) {
		this.updatesDiags = updatesDiags;
	}

	public Diagnosi getAddDiags() {
		return addDiags;
	}

	public void setAddDiags(Diagnosi addDiags) {
		this.addDiags = addDiags;
	}
	
	@PostConstruct
	public void init()
	{
		addDiags=new Diagnosi();
		addDiags.setClinicCenter(new ClinicCenter());
		chosenAllDiags();
		selectedDiagnosisDelete=new ArrayList<>();
	}
	
	public String insertDiagnosis()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.addDiagnosis(addDiags);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String editDaigs(Diagnosi data)
	{
		this.updatesDiags=data;
		return null;
	}
	public String updateDaigs()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.updateDiagnosis(updatesDiags);
			chosenAllDiags();
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	public String getDeleteButtonMessage()
	{
		if(hasSelectedDiagnosis())
		{
			int size=this.selectedDiagnosisDelete.size();
			return size>1 ? size+" Diagnosis selected." : "1 Diagnosis selected.";
			
		}
		return "delete";
	}
	public boolean hasSelectedDiagnosis()
	{
		return this.selectedDiagnosisDelete != null && !this.selectedDiagnosisDelete.isEmpty();
	}
	
	public String removeDaigs(Diagnosi data)
	{
		this.deletesDiags=data;
		return null;
	}
	public String deleteDaigs()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.delDiagnosis(deletesDiags);
			chosenAllDiags();
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String deleteDaigsList()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.deleteDiagnosisCheckbox(selectedDiagnosisDelete);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	private String chosenDiagsId()
	{
		InitialContext ic;
		try {
			selectDiagsId=new Diagnosi();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectDiagsId=hp.selectDiagnosisById(diagsId);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String chosenDiagsName()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			selectdiagsName=new ArrayList<>();

			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectdiagsName=hp.selectByDiagnosisName(diagsName);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String chosenAllDiags()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			selectAllDiags=new ArrayList<>();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectAllDiags=hp.selectDiagnosis();
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

}
