package com.triantos.bean;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="suppliers")
public class Suppliers {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    @Column(name="id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    //Company Name
    @Column(name="company_name")
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    //First Name
    @Column(name = "first_name")
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Last Name
    @Column(name = "last_name")
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    //Vat Number
    @Column(name = "vat_number")
    private int vatNumber;

    public int getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(int vatNumber) {
        this.vatNumber = vatNumber;
    }


    //Irs Office
    @Column(name= "irs_office")
    private Integer irsOffice;

    public Integer getIrsOffice() {
        return irsOffice;
    }

    public void setIrsOffice(Integer irsOffice) {
        this.irsOffice = irsOffice;
    }


    //Address
    @Column(name = "address")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    //Zip Code
    @Column(name = "zip_code")
    private int zipCode;

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }


    //City
    @Column(name = " city")
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    //Country
    @Column(name = " country")
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
