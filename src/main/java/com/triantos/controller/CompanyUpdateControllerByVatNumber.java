package com.triantos.controller;

import com.triantos.bean.Suppliers;
import com.triantos.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CompanyUpdateControllerByVatNumber {

    @Autowired
    private SuppliersService suppliersService;

    @PostMapping(path = "/updateByVatNumber")
    public @ResponseBody
    String updateByVatNumber(@RequestParam(name = "oldVatNumber") Integer oldVatNumber,
                             @RequestParam(name = "newVatNumber") Integer newVatNumber) {

        Iterable<Suppliers> old = suppliersService.SuppliersList();
        return suppliersService.updateByVatNumber(old, oldVatNumber, newVatNumber);
    }


    @PostMapping(path = "/updateCityByVatNumber")
    public @ResponseBody
    String updateCityByVatNumber(@RequestParam(name = "vatNumber") Integer vatNumber,
                                 @RequestParam(name = "city") String city) {

        return suppliersService.updateCityByVatNumber(vatNumber, city);
    }

    @PostMapping(path = "/updateCountryByVatNumber")
    public @ResponseBody
    String updateCountryByVatNumber(@RequestParam(name = "vatNumber") Integer vatNumber,
                                    @RequestParam(name = "country") String country) {

        return suppliersService.updateCountryByVatNumber(vatNumber, country);
    }

    @PostMapping(path = "/updateFirstNameByVatNumber")
    public @ResponseBody
    String updateFirstNameByVatNumber(@RequestParam(name = "vatNumber") Integer vatNumber,
                                      @RequestParam(name = "firstname") String firstname) {

        return suppliersService.updateFirstNameByVatNumber(vatNumber, firstname);
    }

    @PostMapping(path = "/updateLastNameByVatNumber")
    public @ResponseBody
    String updateLastNameByVatNumber(@RequestParam(name = "vatNumber") Integer vatNumber,
                                     @RequestParam(name = "lastname") String lastname) {

        return suppliersService.updateLastNameByVatNumber(vatNumber, lastname);
    }


    @PostMapping(path = "/updateAddressByVatNumber")
    public @ResponseBody
    String updateAddressNameByVatNumber(@RequestParam(name = "vatNumber") Integer vatNumber,
                                        @RequestParam(name = "address") String address) {

        return suppliersService.updateAddressNameByVatNumber(vatNumber, address);
    }


    @PostMapping(path = "/updateIrsOfficeByVatNumber")
    public @ResponseBody
    String updateIrsOfficeByVatNumber(@RequestParam(name = "vatNumber") Integer vatNumber,
                                      @RequestParam(name = "irsoffice") Integer irsoffice) {

        return suppliersService.updateIrsOfficeByVatNumber(vatNumber, irsoffice);
    }


    @PostMapping(path = "/updateZipCodeByVatNumber")
    public @ResponseBody
    String updateZipCodeByVatNumber(@RequestParam(name = "vatNumber") Integer vatNumber,
                                    @RequestParam(name = "zipcode") Integer zipcode) {

        return suppliersService.updateZipCodeByVatNumber(vatNumber, zipcode);
    }
}