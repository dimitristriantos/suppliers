package com.triantos.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.triantos.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CompanyReadController {

    Gson gson = new GsonBuilder().create();

    @Autowired
    private SuppliersService suppliersService;

    @GetMapping(path = "/findAll")
    public @ResponseBody
    String findAll() {
        return gson.toJson(suppliersService.SuppliersList());
    }

    @GetMapping(path = "/findByCompanyName") // Map ONLY GET Requests
    public @ResponseBody
    String findCompany(@RequestParam(name = "name") String name) {

        if (suppliersService.findCompanyName(name) == null) {
            return "No such Company";
        }
        return gson.toJson(suppliersService.findCompanyName(name));

    }

    @GetMapping(path = "/findByVatNumber") // Map ONLY GET Requests
    public @ResponseBody
    String findVatNumber(@RequestParam(name = "vatNumber") int vatNumber) {

        if (suppliersService.findVatNumber(vatNumber) == null) {
            return "No such VatNumber";
        }
        return gson.toJson(suppliersService.findVatNumber(vatNumber));

    }

}
