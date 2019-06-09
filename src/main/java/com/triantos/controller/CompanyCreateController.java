package com.triantos.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.triantos.bean.Suppliers;
import com.triantos.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CompanyCreateController {

    Gson gson = new GsonBuilder().create();


    @Autowired
    private SuppliersService suppliersService;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestParam(name = "companyName") String companyName,
                      @RequestParam(name = "firstName", required = false) String firstName,
                      @RequestParam(name = "lastName", required = false) String lastName,
                      @RequestParam(name = "vatNumber") Integer vatNumber,
                      @RequestParam(name = "irsOffice", required = false) Integer irsOffice,
                      @RequestParam(name = "address", required = false) String address,
                      @RequestParam(name = "zipCode", required = false) Integer zipCode,
                      @RequestParam(name = "city", required = false) String city,
                      @RequestParam(name = "country", required = false) String country) {
        Suppliers n = new Suppliers();
        if (firstName != null)
            n.setFirstName(firstName);
        if (lastName != null)
            n.setLastName(lastName);
        if (irsOffice != null)
            n.setIrsOffice(irsOffice);
        if (address != null)
            n.setAddress(address);
        if (zipCode != null)
            n.setZipCode(zipCode);
        if (city != null)
            n.setCity(city);
        if (country != null)
            n.setCountry(country);

        n.setVatNumber(vatNumber);
        n.setCompanyName(companyName);
        return gson.toJson(suppliersService.saveCompanyName(n));
    }


}
