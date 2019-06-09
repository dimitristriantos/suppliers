package com.triantos.service;

import com.triantos.bean.Suppliers;
import com.triantos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class SuppliersServiceImpl implements SuppliersService {

    @Autowired
    // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    //Save in database
    public String saveCompanyName(Suppliers suppliers) {
        Iterable<Suppliers> list = SuppliersList();
        for (Iterator<Suppliers> iterator = list.iterator(); iterator.hasNext(); ) {
            Suppliers role = (Suppliers) iterator.next();
            if (role.getCompanyName().equals(suppliers.getCompanyName())) {
                return "the Company already exists";
            }
            else if (role.getVatNumber() == suppliers.getVatNumber())
            {
                return "the Vat Number already exists";
            }
        }
        userRepository.save(suppliers);
        return "Saved";
    }

    public Iterable<Suppliers> SuppliersList() {
        Iterable<Suppliers> initialize;
        initialize = userRepository.findAll();
        return initialize;
    }

    public String deleteByCompanyName(String name) {

        Suppliers suppliers = userRepository.findByCompanyName(name);
        if (suppliers != null) {
            userRepository.delete(suppliers);
            return "You deleted the company name";
        }
        return "The company not found";
    }

    public String deleteByVatNumber(Integer vatNumber) {

        Suppliers suppliers = userRepository.findByVatNumber(vatNumber);
        if (suppliers != null) {
            userRepository.delete(suppliers);
            return "You deleted the company name with vatNumber " + vatNumber;
        }
        return "The company with vatNumber  not found ";
    }

    public String deleteAll(Iterable<Suppliers> list) {
        if (!list.iterator().hasNext()) {
            return "The database is already cleared";
        } else {
            userRepository.deleteAll(list);
            return "The database is now empty";
        }
    }

    public Suppliers findCompanyName(String name) {
        return userRepository.findByCompanyName(name);
    }

    public Suppliers findVatNumber(int vatNumber) {
        return userRepository.findByVatNumber(vatNumber);
    }

    public String updateByCompanyName(Iterable<Suppliers> suppliers, String old, String neo) {
        Iterable<Suppliers> list = SuppliersList();
        Suppliers suppliersFound = userRepository.findByCompanyName(old);
        if (suppliersFound == null)
            return "No such Company";

        for (Iterator<Suppliers> iterator = list.iterator(); iterator.hasNext(); ) {
            Suppliers role = (Suppliers) iterator.next();
            if (role.getCompanyName().equals(neo))
                return "The company you try to update is already exists";
        }

        suppliersFound.setCompanyName(neo);
        userRepository.save(suppliersFound);
        return "Saved";

    }

    public String updateCityByCompanyName(String companyName, String city) {

        Suppliers suppliersFound = userRepository.findByCompanyName(companyName);
        if (suppliersFound == null)
            return "No such Company";

        suppliersFound.setCity(city);
        userRepository.save(suppliersFound);
        return "Saved";

    }

    public String updateCountryByCompanyName(String companyName, String country) {

        Suppliers suppliersFound = userRepository.findByCompanyName(companyName);
        if (suppliersFound == null)
            return "No such Company";

        suppliersFound.setCountry(country);
        userRepository.save(suppliersFound);
        return "Saved";

    }

    public String updateAddressByCompanyName(String companyName, String address) {

        Suppliers suppliersFound = userRepository.findByCompanyName(companyName);
        if (suppliersFound == null)
            return "No such Company";

        suppliersFound.setAddress(address);
        userRepository.save(suppliersFound);
        return "Saved";

    }

    public String updateFirstNameByCompanyName(String companyName, String firstname) {

        Suppliers suppliersFound = userRepository.findByCompanyName(companyName);
        if (suppliersFound == null)
            return "No such Company";

        suppliersFound.setFirstName(firstname);
        userRepository.save(suppliersFound);
        return "Saved";

    }

    public String updateLastNameByCompanyName(String companyName, String lastname) {

        Suppliers suppliersFound = userRepository.findByCompanyName(companyName);
        if (suppliersFound == null)
            return "No such Company";

        suppliersFound.setLastName(lastname);
        userRepository.save(suppliersFound);
        return "Saved";

    }

    public String updateIrsOfficeByCompanyName(String companyName, Integer irsoffice) {

        Suppliers suppliersFound = userRepository.findByCompanyName(companyName);
        if (suppliersFound == null)
            return "No such Company";

        suppliersFound.setIrsOffice(irsoffice);
        userRepository.save(suppliersFound);
        return "Saved";

    }

    public String updateZipCodeByCompanyName(String companyName, Integer zipcode) {

        Suppliers suppliersFound = userRepository.findByCompanyName(companyName);
        if (suppliersFound == null)
            return "No such Company";

        suppliersFound.setZipCode(zipcode);
        userRepository.save(suppliersFound);
        return "Saved";

    }



    public String updateByVatNumber(Iterable<Suppliers> suppliers, Integer oldVatNumber, Integer newVatNumber) {
        Iterable<Suppliers> list = SuppliersList();
        Suppliers suppliersFound = userRepository.findByVatNumber(oldVatNumber);
        if (suppliersFound == null)
            return "No such VatNumber";

        for (Iterator<Suppliers> iterator = list.iterator(); iterator.hasNext(); ) {
            Suppliers role = (Suppliers) iterator.next();
            if (role.getVatNumber()==newVatNumber)
                return "The VatNumber you try to update is already exists";
        }

        suppliersFound.setVatNumber(newVatNumber);
        userRepository.save(suppliersFound);
        return "Saved";

    }

    public String updateCityByVatNumber(Integer vatNumber, String city) {

        Suppliers suppliersFound = userRepository.findByVatNumber(vatNumber);
        if (suppliersFound == null)
            return "No such VatNumber";

        suppliersFound.setCity(city);
        userRepository.save(suppliersFound);
        return "Saved";

    }

    public String updateCountryByVatNumber(Integer vatNumber, String country) {

        Suppliers suppliersFound = userRepository.findByVatNumber(vatNumber);
        if (suppliersFound == null)
            return "No such VatNumber";

        suppliersFound.setCountry(country);
        userRepository.save(suppliersFound);
        return "Saved";

    }

    public String updateFirstNameByVatNumber(Integer vatNumber, String firstname) {
        Suppliers suppliersFound = userRepository.findByVatNumber(vatNumber);
        if (suppliersFound == null)
            return "No such VatNumber";

        suppliersFound.setFirstName(firstname);
        userRepository.save(suppliersFound);
        return "Saved";

    }

    public String updateLastNameByVatNumber(Integer vatNumber, String lastname) {

        Suppliers suppliersFound = userRepository.findByVatNumber(vatNumber);
        if (suppliersFound == null)
            return "No such VatNumber";

        suppliersFound.setLastName(lastname);
        userRepository.save(suppliersFound);
        return "Saved";

    }

    public String updateAddressNameByVatNumber(Integer vatNumber, String address) {

        Suppliers suppliersFound = userRepository.findByVatNumber(vatNumber);
        if (suppliersFound == null)
            return "No such VatNumber";

        suppliersFound.setAddress(address);
        userRepository.save(suppliersFound);
        return "Saved";

    }

    public String updateIrsOfficeByVatNumber(Integer vatNumber, Integer irsoffice) {

        Suppliers suppliersFound = userRepository.findByVatNumber(vatNumber);
        if (suppliersFound == null)
            return "No such VatNumber";

        suppliersFound.setIrsOffice(irsoffice);
        userRepository.save(suppliersFound);
        return "Saved";

    }

    public String updateZipCodeByVatNumber(Integer vatNumber, Integer zipcode) {

        Suppliers suppliersFound = userRepository.findByVatNumber(vatNumber);
        if (suppliersFound == null)
            return "No such VatNumber";

        suppliersFound.setZipCode(zipcode);
        userRepository.save(suppliersFound);
        return "Saved";

    }

}
