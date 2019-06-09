package com.triantos.service;

import com.triantos.bean.Suppliers;
import org.springframework.stereotype.Service;

@Service
public interface SuppliersService {


    public String saveCompanyName(Suppliers suppliers) ;

    public Suppliers findCompanyName(String name);
    public Suppliers findVatNumber(int vatNumber);

    public Iterable<Suppliers> SuppliersList();

    public String deleteByCompanyName(String name);
    public String deleteByVatNumber(Integer name);
    public String deleteAll(Iterable<Suppliers> list);

    public String updateByCompanyName(Iterable<Suppliers> list, String oldName, String newName);
    public String updateCityByCompanyName(String companyName, String city);
    public String updateCountryByCompanyName(String companyName, String country);
    public String updateAddressByCompanyName(String companyName, String address);
    public String updateFirstNameByCompanyName(String companyName, String address);
    public String updateLastNameByCompanyName(String companyName, String address);
    public String updateIrsOfficeByCompanyName(String companyName, Integer irsoffice);
    public String updateZipCodeByCompanyName(String companyName, Integer zipcode);

    public String updateByVatNumber(Iterable<Suppliers> list, Integer oldVatNumber, Integer newVatNumber);
    public String updateCityByVatNumber(Integer vatNumber, String city);
    public String updateCountryByVatNumber(Integer vatNumber, String country);
    public String updateFirstNameByVatNumber(Integer vatNumber, String firstname);
    public String updateLastNameByVatNumber(Integer vatNumber, String lastname);
    public String updateAddressNameByVatNumber(Integer vatNumber, String address);
    public String updateIrsOfficeByVatNumber(Integer vatNumber, Integer irsoffice);
    public String updateZipCodeByVatNumber(Integer vatNumber, Integer zipcode);

}

