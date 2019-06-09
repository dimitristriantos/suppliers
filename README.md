#Project Suppliers

#Database
The name of database is : 
#suppliers_db

The database includes all the columns we had been 
asked and it is decided that **columns of company_name** and **vat_number** are **unique** 
 and **no duplicates** are allowed. the structure is :

-- auto-generated definition
create table suppliers
(
    id           int auto_increment
        primary key,
    company_name varchar(255) not null,
    first_name   varchar(255) null,
    last_name    varchar(255) null,
    vat_number   int          not null,
    irs_office   int(255)     null,
    address      varchar(255) null,
    zip_code     int(255)     null,
    city         varchar(255) null,
    country      varchar(255) null
);

To connect to database we use :

spring.datasource.username=root
spring.datasource.password

And we Run the SpringBootWebApplication.class

#Code Structure


We have a package com.triantos where we create all the packages we want.

#bean package
First we have the package bean that include Suppliers java class.
In that class we the variables we are going to use in the project and 
correspond them with the columns of the suppliers database.

#controller package
In that package we have the java classes that are responsible for the 
CRUD and Search API.

#CompanyCreateController
The first class, CompanyCreateController.java is responsible to make a 
new entry in database. It make checks if the required variables are not 
null,to be more specific if the company name and the vat number is 
already in the database, and then if everything is correct it stores in the database.
We do the checks we want through the method that it is created in the package
service in the SuppliersServiceImpl , and has the name **saveCompanyName**.
Here we create a list we all the database variables and make a search if 
the Vat Number or the Company Name is already existed. If not the we add the new information 
in the database.

#CompanyDeleteController
In that java class we give the opportunity to user to delete a row of the database by choosing 
the Company Name or the Vat Number, or if he wants he can delete all database.
For deleting a row of database depends on Company Name we call from CompanyDeleteController the 
class deleteByCompanyName, that it is in SuppliersServiceImpl, then through UserRepository we call
the class findByCompanyName to search in database if the company name that it is requested exist, and
if exists we delete it from database. The same way we make the delete of an entry of database for VatNumber
using the class deleteByVatNumber, and working in the same way. 
In the end to delete everything in the database we make a list of the information
that exist in database with the help of SuppliersList method,that exist in 
SuppliersServiceImpl.java, and creates a list of database with help of
userRepository.findAll that returns everything from database suppliers_db to a list. 


#CompanyReadController
In that java class we give the opportunity to user to search in database for information for a 
specific company Name or vat Number , or to see all database.
We do that by calling the findCompanyName method from CompanyReadController, and then with the help of 
userRepository interface we search the database to see if we have the company Name that it is requested 
in the list and if exists it returns all the information for that company. We work in the same way for request 
of Vat Number, by using the method findVatNumber from SuppliersServiceImpl , that calls findByVatNumber from 
UserRepository to search all database for the specific Vat Number.
Also user has the ability to see all database with the findAll choice, that create a list with all information of
database with the help of SuppliersList method.

#CompanyUpdateControllerByCompanyName and CompanyUpdateControlleByVatNumber
In these two classes we are making updates to the database depend on Company Name and Vat Number.
To be more specific , because these two variables are unique in the database suppliers_db, 
user must give one of the two and then choose which variable wants to update in the company he wants.
The user can update all the variables of the database even the unique ones, but there is a check if the 
company Name or the Vat Number is already exist in database.
For example in CompanyUpdateControllerByCompanyName, if user wants to update the company Name we call the 
updateByCompanyName method from SuppliersServiceImpl.java that first check if the company name user gave 
exist in database with the help of findByCompanyName of UserRepository Interface, if exists then continues 
to make another check, it checks if the new company name he wants to add to database already exists and we do that 
by creating a list with all information of database suppliers_db and search if the new company Name is in database.
If all the checks we have are clear then we update the database with the new company Name replacing the old one.
With the same way it works all the methods of updates  that exist in those two classes independently if we 
make an update with company name or vat number. We have to say also that except from the unique columns 
company name and vat number, that we check the new variable if is already exist in the database, in all other 
choices we make the chances without check for example if the city is already in another row, because all the other 
columns are not unique.

#repository package

This package contains the User Repository Interface that help us to search in the database suppliers_db
The two methods that are contained in that interface are findByCompanyName and findByVatNumber that help us to search 
database depend on Company Name and Vat Number.

#Service Package

This package contains the SuppliersServiceImpl class and the SuppliersService Interface , that contains the 
methods we use to succeed the CRUD and search API.

#How we make a request

All of the requests we have are POST method request expect from Find Request that are GET method requests.

#Create Request
To make a create request we press :  

**http://localhost:8080/add/?companyName=msc&vatNumber=22&city=manchester&zipCode=9**

It is important to say that companyName and vatNumber are unique columns , and error message is show up 
if they are missing.

#Delete Request
If the user want to delete everything in the database can press

**http://localhost:8080/deleteAll** 

and the database is cleared

If he wants to delete a specific company by company Name or by var Number the user press :

**http://localhost:8080//deleteByCompanyName/?companyName=msc**
OR 
**http://localhost:8080//deleteByVatNumber/?vatNumber=1**

#Find Request
Find request as we already said are GET requests. 
If the user wants to get all the database he press : 
**http://localhost:8080/findAll**

If he wants to find a company by company Name or by Vat Numberv he press : 

**http://localhost:8080/findByCompanyName/?name=msc**

OR

**http://localhost:8080/findByVatNumber/?vatNumber=1**

#Update Request
The choices the user to make an update in the database are a lot.
First he can update the database with the company name.
For example : 
If he wants to update the company Name of a company he has to press:

**http://localhost:8080/updateZipCodeByCompanyName/?companyName=msc&newName=msc1**

If he wants to update the zip code of a company based on company Name he has to press:

**http://localhost:8080/updateZipCodeByCompanyName/?companyName=msc&zipcode=123**

If he wants to update the city of a company based on company Name he has to press:

**http://localhost:8080/updateZipCodeByCompanyName/?companyName=msc&city=athens**

If he wants to update the country of a company based on company Name he has to press:

**http://localhost:8080/updateZipCodeByCompanyName/?companyName=msc&country=greece**

If he wants to update the first name  of a company based on company Name he has to press:

**http://localhost:8080/updateZipCodeByCompanyName/?companyName=msc&firstname==dimitris**

If he wants to update the last name  of a company based on company Name he has to press:

**http://localhost:8080/updateZipCodeByCompanyName/?companyName=msc&lastname==triantos**

If he wants to update the address  of a company based on company Name he has to press:

**http://localhost:8080/updateZipCodeByCompanyName/?companyName=msc&address==syntagma**

If he wants to update the irs office  of a company based on company Name he has to press:

**http://localhost:8080/updateZipCodeByCompanyName/?companyName=msc&irsoffice==123**

If he wants to update the **vat Number** of a company based on vat Number he has to press:

http://localhost:8080/updateByVatNumber/?vatNumber=19&irsoffice=80

All the request based on Vat Number are the same as company Name request 
with the only change  we use **/updateByVatNumber**

For example if we want to update Irs Office of a company depend on vat Number we have to press :

**http://localhost:8080/updateIrsOfficeByVatNumber/?vatNumber=19&irsoffice=80**





