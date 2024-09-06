package com.revshop.Entity;

public class UserEntity implements Entity {

	private int userId;
	private String firstName;
	private String lastName;
	private String gender;
	private String mobile;
	private String email;
	private String pincode;
	private String billingAddress;
	private String shippingAddress;
	private String bankAccountNo;
	private String ifsc;
	private String companyName;
	private String gstNumber;
	private String websiteUrl;
	private String productType;
	private String panNumber;
//	private String kycStatus;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

//	public String getKycStatus() {
//		return kycStatus;
//	}
//
//	public void setKycStatus(String kycStatus) {
//		this.kycStatus = kycStatus;
//	}

	public UserEntity(int userId, String firstName, String lastName, String gender, String mobile, String email,
			String pincode, String billingAddress, String shippingAddress, String bankAccountNo, String ifsc,
			String companyName, String gstNumber, String websiteUrl, String productType, String panNumber
			) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.pincode = pincode;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
		this.bankAccountNo = bankAccountNo;
		this.ifsc = ifsc;
		this.companyName = companyName;
		this.gstNumber = gstNumber;
		this.websiteUrl = websiteUrl;
		this.productType = productType;
		this.panNumber = panNumber;
	}

	public UserEntity() {
		super();
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", mobile=" + mobile + ", email=" + email + ", pincode=" + pincode + ", billingAddress="
				+ billingAddress + ", shippingAddress=" + shippingAddress + ", bankAccountNo=" + bankAccountNo
				+ ", ifsc=" + ifsc + ", companyName=" + companyName + ", gstNumber=" + gstNumber + ", websiteUrl="
				+ websiteUrl + ", productType=" + productType + ", panNumber=" + panNumber +"]";
	}

}
