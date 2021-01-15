package com.example.demo.cookie.model;

import java.io.Serializable;
import java.util.Date;

public class AcUser implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.origin
     *
     * @mbg.generated
     */
    private String origin;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.username
     *
     * @mbg.generated
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.passkey
     *
     * @mbg.generated
     */
    private String passkey;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.realname
     *
     * @mbg.generated
     */
    private String realname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.email
     *
     * @mbg.generated
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.moto_email
     *
     * @mbg.generated
     */
    private String motoEmail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.phone
     *
     * @mbg.generated
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.manager
     *
     * @mbg.generated
     */
    private String manager;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.hashing
     *
     * @mbg.generated
     */
    private String hashing;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.company
     *
     * @mbg.generated
     */
    private String company;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.organization
     *
     * @mbg.generated
     */
    private String organization;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.memo
     *
     * @mbg.generated
     */
    private String memo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.lastmodified
     *
     * @mbg.generated
     */
    private Date lastmodified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.created
     *
     * @mbg.generated
     */
    private Date created;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.state
     *
     * @mbg.generated
     */
    private Integer state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.state_desc
     *
     * @mbg.generated
     */
    private String stateDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.is_deleted
     *
     * @mbg.generated
     */
    private Byte isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.last_login_time
     *
     * @mbg.generated
     */
    private Date lastLoginTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.account_type
     *
     * @mbg.generated
     */
    private Byte accountType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.user_type
     *
     * @mbg.generated
     */
    private Byte userType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.user_type_desc
     *
     * @mbg.generated
     */
    private String userTypeDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.department
     *
     * @mbg.generated
     */
    private String department;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.portrait
     *
     * @mbg.generated
     */
    private String portrait;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.supplier_name
     *
     * @mbg.generated
     */
    private String supplierName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.is_agreed
     *
     * @mbg.generated
     */
    private Byte isAgreed;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.gmt_create
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.gmt_modified
     *
     * @mbg.generated
     */
    private Date gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ac_user.supplier_parts
     *
     * @mbg.generated
     */
    private String supplierParts;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ac_user
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.id
     *
     * @return the value of ac_user.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.id
     *
     * @param id the value for ac_user.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.origin
     *
     * @return the value of ac_user.origin
     *
     * @mbg.generated
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.origin
     *
     * @param origin the value for ac_user.origin
     *
     * @mbg.generated
     */
    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.username
     *
     * @return the value of ac_user.username
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.username
     *
     * @param username the value for ac_user.username
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.passkey
     *
     * @return the value of ac_user.passkey
     *
     * @mbg.generated
     */
    public String getPasskey() {
        return passkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.passkey
     *
     * @param passkey the value for ac_user.passkey
     *
     * @mbg.generated
     */
    public void setPasskey(String passkey) {
        this.passkey = passkey == null ? null : passkey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.realname
     *
     * @return the value of ac_user.realname
     *
     * @mbg.generated
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.realname
     *
     * @param realname the value for ac_user.realname
     *
     * @mbg.generated
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.email
     *
     * @return the value of ac_user.email
     *
     * @mbg.generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.email
     *
     * @param email the value for ac_user.email
     *
     * @mbg.generated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.moto_email
     *
     * @return the value of ac_user.moto_email
     *
     * @mbg.generated
     */
    public String getMotoEmail() {
        return motoEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.moto_email
     *
     * @param motoEmail the value for ac_user.moto_email
     *
     * @mbg.generated
     */
    public void setMotoEmail(String motoEmail) {
        this.motoEmail = motoEmail == null ? null : motoEmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.phone
     *
     * @return the value of ac_user.phone
     *
     * @mbg.generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.phone
     *
     * @param phone the value for ac_user.phone
     *
     * @mbg.generated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.manager
     *
     * @return the value of ac_user.manager
     *
     * @mbg.generated
     */
    public String getManager() {
        return manager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.manager
     *
     * @param manager the value for ac_user.manager
     *
     * @mbg.generated
     */
    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.hashing
     *
     * @return the value of ac_user.hashing
     *
     * @mbg.generated
     */
    public String getHashing() {
        return hashing;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.hashing
     *
     * @param hashing the value for ac_user.hashing
     *
     * @mbg.generated
     */
    public void setHashing(String hashing) {
        this.hashing = hashing == null ? null : hashing.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.company
     *
     * @return the value of ac_user.company
     *
     * @mbg.generated
     */
    public String getCompany() {
        return company;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.company
     *
     * @param company the value for ac_user.company
     *
     * @mbg.generated
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.organization
     *
     * @return the value of ac_user.organization
     *
     * @mbg.generated
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.organization
     *
     * @param organization the value for ac_user.organization
     *
     * @mbg.generated
     */
    public void setOrganization(String organization) {
        this.organization = organization == null ? null : organization.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.memo
     *
     * @return the value of ac_user.memo
     *
     * @mbg.generated
     */
    public String getMemo() {
        return memo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.memo
     *
     * @param memo the value for ac_user.memo
     *
     * @mbg.generated
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.lastmodified
     *
     * @return the value of ac_user.lastmodified
     *
     * @mbg.generated
     */
    public Date getLastmodified() {
        return lastmodified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.lastmodified
     *
     * @param lastmodified the value for ac_user.lastmodified
     *
     * @mbg.generated
     */
    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.created
     *
     * @return the value of ac_user.created
     *
     * @mbg.generated
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.created
     *
     * @param created the value for ac_user.created
     *
     * @mbg.generated
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.state
     *
     * @return the value of ac_user.state
     *
     * @mbg.generated
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.state
     *
     * @param state the value for ac_user.state
     *
     * @mbg.generated
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.state_desc
     *
     * @return the value of ac_user.state_desc
     *
     * @mbg.generated
     */
    public String getStateDesc() {
        return stateDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.state_desc
     *
     * @param stateDesc the value for ac_user.state_desc
     *
     * @mbg.generated
     */
    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc == null ? null : stateDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.is_deleted
     *
     * @return the value of ac_user.is_deleted
     *
     * @mbg.generated
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.is_deleted
     *
     * @param isDeleted the value for ac_user.is_deleted
     *
     * @mbg.generated
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.last_login_time
     *
     * @return the value of ac_user.last_login_time
     *
     * @mbg.generated
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.last_login_time
     *
     * @param lastLoginTime the value for ac_user.last_login_time
     *
     * @mbg.generated
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.account_type
     *
     * @return the value of ac_user.account_type
     *
     * @mbg.generated
     */
    public Byte getAccountType() {
        return accountType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.account_type
     *
     * @param accountType the value for ac_user.account_type
     *
     * @mbg.generated
     */
    public void setAccountType(Byte accountType) {
        this.accountType = accountType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.user_type
     *
     * @return the value of ac_user.user_type
     *
     * @mbg.generated
     */
    public Byte getUserType() {
        return userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.user_type
     *
     * @param userType the value for ac_user.user_type
     *
     * @mbg.generated
     */
    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.user_type_desc
     *
     * @return the value of ac_user.user_type_desc
     *
     * @mbg.generated
     */
    public String getUserTypeDesc() {
        return userTypeDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.user_type_desc
     *
     * @param userTypeDesc the value for ac_user.user_type_desc
     *
     * @mbg.generated
     */
    public void setUserTypeDesc(String userTypeDesc) {
        this.userTypeDesc = userTypeDesc == null ? null : userTypeDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.department
     *
     * @return the value of ac_user.department
     *
     * @mbg.generated
     */
    public String getDepartment() {
        return department;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.department
     *
     * @param department the value for ac_user.department
     *
     * @mbg.generated
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.portrait
     *
     * @return the value of ac_user.portrait
     *
     * @mbg.generated
     */
    public String getPortrait() {
        return portrait;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.portrait
     *
     * @param portrait the value for ac_user.portrait
     *
     * @mbg.generated
     */
    public void setPortrait(String portrait) {
        this.portrait = portrait == null ? null : portrait.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.supplier_name
     *
     * @return the value of ac_user.supplier_name
     *
     * @mbg.generated
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.supplier_name
     *
     * @param supplierName the value for ac_user.supplier_name
     *
     * @mbg.generated
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.is_agreed
     *
     * @return the value of ac_user.is_agreed
     *
     * @mbg.generated
     */
    public Byte getIsAgreed() {
        return isAgreed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.is_agreed
     *
     * @param isAgreed the value for ac_user.is_agreed
     *
     * @mbg.generated
     */
    public void setIsAgreed(Byte isAgreed) {
        this.isAgreed = isAgreed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.gmt_create
     *
     * @return the value of ac_user.gmt_create
     *
     * @mbg.generated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.gmt_create
     *
     * @param gmtCreate the value for ac_user.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.gmt_modified
     *
     * @return the value of ac_user.gmt_modified
     *
     * @mbg.generated
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.gmt_modified
     *
     * @param gmtModified the value for ac_user.gmt_modified
     *
     * @mbg.generated
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ac_user.supplier_parts
     *
     * @return the value of ac_user.supplier_parts
     *
     * @mbg.generated
     */
    public String getSupplierParts() {
        return supplierParts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ac_user.supplier_parts
     *
     * @param supplierParts the value for ac_user.supplier_parts
     *
     * @mbg.generated
     */
    public void setSupplierParts(String supplierParts) {
        this.supplierParts = supplierParts == null ? null : supplierParts.trim();
    }
}