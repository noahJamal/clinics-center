package com.clinicCenter.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.bean.AdmainBusinessBeanRemote;
import model.entity.CardInsurance;
import model.entity.ClinicCenter;
import model.entity.InsuranceCompany;

public class adminCardInsurClass {
	private CardInsurance addCard;
	private CardInsurance deletesCardInsur;
	private CardInsurance updatesCardInsur;
	private long CardInsurId;
	private CardInsurance selectCardInsur;
	private String selectCardName;
	private List<CardInsurance>  selectCardNameInfo;
	private List<CardInsurance> selectAllCards;
	
	
	
	

	public List<CardInsurance> getSelectAllCards() {
		return selectAllCards;
	}

	public void setSelectAllCards(List<CardInsurance> selectAllCards) {
		this.selectAllCards = selectAllCards;
	}

	public String getSelectCardName() {
		return selectCardName;
	}

	public void setSelectCardName(String selectCardName) {
		this.selectCardName = selectCardName;
	}

	public List<CardInsurance> getSelectCardNameInfo() {
		return selectCardNameInfo;
	}

	public void setSelectCardNameInfo(List<CardInsurance> selectCardNameInfo) {
		this.selectCardNameInfo = selectCardNameInfo;
	}

	public CardInsurance getSelectCardInsur() {
		return selectCardInsur;
	}

	public void setSelectCardInsur(CardInsurance selectCardInsur) {
		this.selectCardInsur = selectCardInsur;
	}

	public long getCardInsurId() {
		return CardInsurId;
	}

	public void setCardInsurId(long cardInsurId) {
		CardInsurId = cardInsurId;
	}

	public CardInsurance getUpdatesCardInsur() {
		return updatesCardInsur;
	}

	public void setUpdatesCardInsur(CardInsurance updatesCardInsur) {
		this.updatesCardInsur = updatesCardInsur;
	}

	public CardInsurance getDeletesCardInsur() {
		return deletesCardInsur;
	}

	public void setDeletesCardInsur(CardInsurance deletesCardInsur) {
		this.deletesCardInsur = deletesCardInsur;
	}

	public CardInsurance getAddCard() {
		return addCard;
	}

	public void setAddCard(CardInsurance addCard) {
		this.addCard = addCard;
	}
	
	@PostConstruct
	public void init()
	{
		addCard=new CardInsurance();
		//addCard.setClinicCenter(new ClinicCenter());
		addCard.setInsuranceCompany(new InsuranceCompany());
		chosenAllCardInsur();
	}
	
	public String insertCardInsur()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.addInsCard(addCard);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String removeCardInsur(CardInsurance data)
	{
		this.deletesCardInsur=data;
		return null;
	}
	public String deleteCardInsur()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.delInsCard(deletesCardInsur);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public String editCardInsur(CardInsurance data)
	{
		this.updatesCardInsur=data;
		return null;}
	
	public String updateCardInsur()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.updateInsCard(updatesCardInsur);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		}
	public String chosenCardInsur()
	{ 
		InitialContext ic;
		try {
			selectCardInsur=new CardInsurance();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectCardInsur=hp.selectInsCardById(CardInsurId);
			return null;
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;}

	public String chosenCardInsurName()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			selectCardNameInfo=new ArrayList<>();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectCardNameInfo=hp.selectCardByname(selectCardName);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public String chosenAllCardInsur()
	{
		InitialContext ic;
		
		try {
			ic=new InitialContext();
			selectAllCards=new ArrayList<>();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectAllCards=hp.selectAllCardIns();	
			
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
