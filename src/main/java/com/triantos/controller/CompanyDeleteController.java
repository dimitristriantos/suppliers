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
public class CompanyDeleteController {

    Gson gson = new GsonBuilder().create();


    @Autowired
    private SuppliersService suppliersService;


    @PostMapping(path = "/deleteByCompanyName")
    public @ResponseBody
    String deleteCompanyName(@RequestParam(name = "companyName") String name) {
        return gson.toJson(suppliersService.deleteByCompanyName(name));
    }

    @PostMapping(path = "/deleteByVatNumber")
    public @ResponseBody
    String deleteVatNumber(@RequestParam(name = "vatNumber") Integer vatNumber) {
        return gson.toJson(suppliersService.deleteByVatNumber(vatNumber));
    }

    @PostMapping(path = "/deleteAll")
    public @ResponseBody
    String deleteAll() {
        Iterable<Suppliers> list = suppliersService.SuppliersList();
        return suppliersService.deleteAll(list);
    }

}
