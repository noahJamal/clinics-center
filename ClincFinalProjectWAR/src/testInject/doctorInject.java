package testInject;

import com.clinicCenter.Bean.adminOperationDoctorClass;

import model.entity.Doctor;

public class doctorInject {

	private String homeNumber ;
	private String streetName;
	private String cityName;
	private String countryName;
	private String ZipCode;
	
	public doctorInject (){
	adminOperationDoctorClass c=new adminOperationDoctorClass();
	Doctor d=new Doctor();
	d.setDocAddress(homeNumber);
	c.setUpdatesDoctors(d);
	}
	
	
	
	public String getHomeNumber() {
		return homeNumber;
	}
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getZipCode() {
		return ZipCode;
	}
	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}
	
	
	
}
