package com.clinicCenter.Bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.primefaces.event.SelectEvent;

import model.bean.AdmainBusinessBeanRemote;
import model.entity.ClinicCenter;
import model.entity.InsuranceCompany;

public class adminInsuranceComClass implements Serializable {  
	   private static final long serialVersionUID = 1L; 
	
	/**
	 * 
	 */
	/**
	 * 
	 */
	private InsuranceCompany addCompany;
	private InsuranceCompany updatesCompany=new InsuranceCompany();


	private InsuranceCompany deletesCompany;
	private Long insuranceCompId;
	private InsuranceCompany selectCompId;
	private List<InsuranceCompany> selectCompName;
	private String companiesNmae;
	private List<InsuranceCompany> selectAllCompaenies;
	
	

	public List<InsuranceCompany> getSelectAllCompaenies() {
		return selectAllCompaenies;
	}

	public void setSelectAllCompaenies(List<InsuranceCompany> selectAllCompaenies) {
		this.selectAllCompaenies = selectAllCompaenies;
	}

	public List<InsuranceCompany> getSelectCompName() {
		return selectCompName;
	}

	public void setSelectCompName(List<InsuranceCompany> selectCompName) {
		this.selectCompName = selectCompName;
	}

	public String getCompaniesNmae() {
		return companiesNmae;
	}

	public void setCompaniesNmae(String companiesNmae) {
		this.companiesNmae = companiesNmae;
	}

	public InsuranceCompany getSelectCompId() {
		return selectCompId;
	}

	public void setSelectCompId(InsuranceCompany selectCompId) {
		this.selectCompId = selectCompId;
	}

	
	

	

	public Long getInsuranceCompId() {
		return insuranceCompId;
	}

	public void setInsuranceCompId(Long insuranceCompId) {
		this.insuranceCompId = insuranceCompId;
	}

	public InsuranceCompany getDeletesCompany() {
		return deletesCompany;
	}

	public void setDeletesCompany(InsuranceCompany deletesCompany) {
		this.deletesCompany = deletesCompany;
	}

	public InsuranceCompany getUpdatesCompany() {
		return updatesCompany;
	}

	public void setUpdatesCompany(InsuranceCompany updatesCompany) {
	
		
		this.updatesCompany = updatesCompany;
	}

	public InsuranceCompany getAddCompany() {
		return addCompany;
	}

	public void setAddCompany(InsuranceCompany addCompany) {
		this.addCompany = addCompany;
	}
	
	@PostConstruct
	public void init()
	{  
		addCompany=new InsuranceCompany();
		addCompany.setClinicCenter(new ClinicCenter());
		chosenAllInsuranceComp();
	}
	public String insertInsuranceCompany()
	{
		InitialContext ic;

		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.addCompany(addCompany);
			displayMessage(addCompany.getCompName()+" company added");

			return null;
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public String editeCompany(InsuranceCompany data)
	{  

//		InsuranceCompany d=new InsuranceCompany();
//		
//		d=data;
		;

		this.updatesCompany=data;
		return "kkk";
		
	}
    
	

	
	public String updateInsuranceComp()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.updateCompany(updatesCompany);
			displayMessage(updatesCompany.getCompName()+" company edited ");

		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String removeInsuranceComp(InsuranceCompany data)
	{   
		this.deletesCompany=data;
		return null;
	}
	
	public String deleteInsuranceComp(InsuranceCompany data)
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.delCompany(data);
			displayMessage(data.getCompName()+" company deleted ");

		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String chosenInsuranceCompID()
	{ InitialContext ic;
//	if(insuranceCompId ==null)
//		
//	{     // adminInsuranceComClass x=new adminInsuranceComClass ();
//		
//		x.chosenAllInsuranceComp();
//	}
//	else
//     {
	
	try { 
	
		     selectAllCompaenies=new ArrayList<>();
		     ic=new InitialContext();
		     AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
		     selectAllCompaenies=hp.selectCompanyById(insuranceCompId);
	}
	
	
	catch (NamingException e) {
		// TODO: handle exception
		e.printStackTrace();
	}//}
		return null;
	}
	public String chosenInsuranceCompName()
	{
		InitialContext ic;
		try {
			selectCompName=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectCompName=hp.selectCompanyByName(companiesNmae);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public String chosenAllInsuranceComp()
	{
		InitialContext ic;
		try {
			selectAllCompaenies=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectAllCompaenies=hp.selectAllCompany();
	} catch (NamingException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		return null;
	}
	
//	public void onSelectRow(SelectEvent event)
//	{
//		updatesCompany=(InsuranceCompany) event.getObject();
//		
//		
//	}
//	

	public void displayMessage(String message)
	{
	   FacesContext fc=FacesContext.getCurrentInstance();
	   fc.addMessage(null, new FacesMessage(message));
	}
	
}
