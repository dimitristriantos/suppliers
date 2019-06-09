package com.triantos.repository;

import com.triantos.bean.Suppliers;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

 public interface UserRepository extends CrudRepository<Suppliers, String> {

  public Suppliers findByCompanyName(String CompanyName); //search if company Name is in Database

  public Suppliers findByVatNumber(Integer vatNumber); //search if vatNumber is in Database

  public Suppliers findByVatNumber(int vatNumber);

 }

