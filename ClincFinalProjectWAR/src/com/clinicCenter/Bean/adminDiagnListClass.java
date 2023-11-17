package com.clinicCenter.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.bean.AdmainBusinessBeanRemote;
import model.entity.ClinicCenter;
import model.entity.DiagnList;
import model.entity.Diagnosi;
import model.entity.Patient;
import model.entity.PatientVisit;

public class adminDiagnListClass {
	
	private DiagnList addDiagnList;
	private DiagnList updatesDiagnList;
	private DiagnList deletesDiagnList;
	private long  diagListId;
	private DiagnList selectDiagListId;
	private List<DiagnList> selectAllDigList;
	private List<DiagnList> selectDigListPatName;
	private String patFFName;
	private String patMMName;
	private String patLLName;
	private long fVisitIdDigList;
	private List<DiagnList> selectFVisitIdDigList;
	
	


	public long getfVisitIdDigList() {
		return fVisitIdDigList;
	}

	public void setfVisitIdDigList(long fVisitIdDigList) {
		this.fVisitIdDigList = fVisitIdDigList;
	}

	public List<DiagnList> getSelectFVisitIdDigList() {
		return selectFVisitIdDigList;
	}

	public void setSelectFVisitIdDigList(List<DiagnList> selectFVisitIdDigList) {
		this.selectFVisitIdDigList = selectFVisitIdDigList;
	}

	public List<DiagnList> getSelectDigListPatName() {
		return selectDigListPatName;
	}

	public void setSelectDigListPatName(List<DiagnList> selectDigListPatName) {
		this.selectDigListPatName = selectDigListPatName;
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

	public List<DiagnList> getSelectAllDigList() {
		return selectAllDigList;
	}

	public void setSelectAllDigList(List<DiagnList> selectAllDigList) {
		this.selectAllDigList = selectAllDigList;
	}

	public long getDiagListId() {
		return diagListId;
	}

	public void setDiagListId(long diagListId) {
		this.diagListId = diagListId;
	}

	public DiagnList getSelectDiagListId() {
		return selectDiagListId;
	}

	public void setSelectDiagListId(DiagnList selectDiagListId) {
		this.selectDiagListId = selectDiagListId;
	}

	public DiagnList getUpdatesDiagnList() {
		return updatesDiagnList;
	}

	public void setUpdatesDiagnList(DiagnList updatesDiagnList) {
		this.updatesDiagnList = updatesDiagnList;
	}

	public DiagnList getDeletesDiagnList() {
		return deletesDiagnList;
	}

	public void setDeletesDiagnList(DiagnList deletesDiagnList) {
		this.deletesDiagnList = deletesDiagnList;
	}

	public DiagnList getAddDiagnList() {
		return addDiagnList;
	}

	public void setAddDiagnList(DiagnList addDiagnList) {
		this.addDiagnList = addDiagnList;
	}
	
	@PostConstruct
	public void init()
	{
		addDiagnList=new DiagnList();
		addDiagnList.setClinicCenter(new ClinicCenter());
		addDiagnList.setPatient(new Patient());
		addDiagnList.setPatientVisit(new PatientVisit());
		addDiagnList.setDiagnosi(new Diagnosi());
		chosenAllDiagnLists();
		
	}
	
	public String insertDiagnList()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.addDiagnList(addDiagnList);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String editDiagnList(DiagnList data)
	{
		this.updatesDiagnList=data;
		return null;
	}
	
	public String updateDiagnLists()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.updateDiagnList(updatesDiagnList);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String removeDiagnList(DiagnList data)
	{
		this.deletesDiagnList=data;
		return null;
	}
	
	public String deleteDiagnLists()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.delDiagnList(deletesDiagnList);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String chosenDiagnListId()
	{
		InitialContext ic;
		try {
			selectDiagListId=new DiagnList();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectDiagListId=hp.selectDiagnListById(diagListId);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public String chosenAllDiagnLists()
	{
		InitialContext ic;
		try {
			selectAllDigList=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectAllDigList=hp.selectAllDiagnList();
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String chosenDiagnListsPatName()
	{
		InitialContext ic;
		try {
			selectDigListPatName=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectDigListPatName=hp.selectDiagnListByPatientName(patFFName, patMMName, patLLName);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String chosenDiagnListsFVisitId()
	{
		InitialContext ic;
		try {
			selectFVisitIdDigList=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectFVisitIdDigList=hp.selectDiagnListByPatientVisit(fVisitIdDigList);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
