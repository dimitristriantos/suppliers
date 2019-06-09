package com.triantos.controller;

import com.triantos.bean.Suppliers;
import com.triantos.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CompanyUpdateControllerByCompanyName {

    @Autowired
    private SuppliersService suppliersService;

    @PostMapping(path = "/updateByCompanyName")
    public @ResponseBody
    String updateByCompanyName(@RequestParam(name = "oldName") String oldCompanyName,
                      @RequestParam(name = "newName") String newCompanyName) {

        Iterable<Suppliers> old = suppliersService.SuppliersList();
        return suppliersService.updateByCompanyName(old, oldCompanyName, newCompanyName);
    }



    @PostMapping(path = "/updateCityByCompanyName")
    public @ResponseBody
    String updateCityByCompanyName(@RequestParam(name = "companyName") String companyName,
                      @RequestParam(name = "city") String city) {

        return suppliersService.updateCityByCompanyName(companyName, city);
    }



    @PostMapping(path = "/updateCountryByCompanyName")
    public @ResponseBody
    String updateCountryByCompanyName(@RequestParam(name = "companyName") String companyName,
                      @RequestParam(name = "city") String country) {

        return suppliersService.updateCountryByCompanyName(companyName, country);
    }



    @PostMapping(path = "/updateAddressByCompanyName")
    public @ResponseBody
    String updateAddressByCompanyName(@RequestParam(name = "companyName") String companyName,
                      @RequestParam(name = "address") String address) {

        return suppliersService.updateAddressByCompanyName(companyName, address);
    }

    @PostMapping(path = "/updateFirstNameByCompanyName")
    public @ResponseBody
    String updateFirstNameByCompanyName(@RequestParam(name = "companyName") String companyName,
                                      @RequestParam(name = "firstname") String firstname) {

        return suppliersService.updateFirstNameByCompanyName(companyName, firstname);
    }
    @PostMapping(path = "/updateLastNameByCompanyName")
    public @ResponseBody
    String updateLastNameByCompanyName(@RequestParam(name = "companyName") String companyName,
                                      @RequestParam(name = "lastname") String lastname) {

        return suppliersService.updateLastNameByCompanyName(companyName, lastname);
    }

    @PostMapping(path = "/updateIrsOfficeByCompanyName")
    public @ResponseBody
    String updateIrsOfficeByCompanyName(@RequestParam(name = "companyName") String companyName,
                                       @RequestParam(name = "irsoffice") Integer irsoffice) {

        return suppliersService.updateIrsOfficeByCompanyName(companyName, irsoffice);
    }


    @PostMapping(path = "/updateZipCodeByCompanyName")
    public @ResponseBody
    String updateZipCodeByCompanyName(@RequestParam(name = "companyName") String companyName,
                                       @RequestParam(name = "zipcode") Integer zipcode) {

        return suppliersService.updateZipCodeByCompanyName(companyName, zipcode);
    }
}
