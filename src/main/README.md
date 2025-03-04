# *ERP / INVENTORY AUDIT APP*
## BCCA UNIT 8 MODULE 1 PROJECT

--- 

REQUIREMENTS:
Data is stored in a Postgresql database
Data access is implemented with a Spring Data JPA Repository
Request/Response is handled with a Spring Web MVC RestController
Required endpoints
- GET the collection of all entries
- POST a new entry
- GET a single entry
- PUT a single entry
- DELETE a single entry

---

## ABOUT

This ERP (Enterprise Resource Planning) software system centralizes data and automates financial/accounting processes related to
inventory tracking across vendors, stores, warehouses, and invoices.

### Core Functionalities
- Centralized inventory and financial data
- CRUD operations for vendors, items, stores, warehouses, invoices
- Reports and analytics on vendors, invoices, and inventory
- Support for backlogged inventory

___

## DATABASE SCHEMA


### Entities
* __Company__
    - ID [PK]
    - EMPLOYER IDENTIFICATION NUMBER (EIN) [12-3456789]
    - NAME
    - TOTAL ASSETS


* __User__
    - ID [PK]
    - EMPLOYEE ID [DEPT-12345]
    - PASSWORD
    - FIRST NAME
    - LAST NAME
    - EMAIL
    - PHONE [1-123-456-7890]
    - COMPANY ID [FK]
    - ROLE (Controller, Manager, Supervisor, Accountant, Bookkeeper)


* __Stores__
    - ID [PK]
    - COMPANY ID [FK]
    - LOCATION ID [ST-USA-STATE-CITY-STORE#]
    - LOCATION COUNTRY
    - LOCATION STATE
    - LOCATION CITY
    - STORE NUMBER


* __Store Inventory__
    - STORE LOCATION ID [FK]
    - ITEM ID [FK]
    - QUANTITY


* __Warehouses__
    - ID [PK]
    - COMPANY ID [FK]
    - LOCATION ID [WH-USA-STATE-CITY-WAREHOUSE#]
    - LOCATION COUNTRY
    - LOCATION STATE
    - LOCATION CITY
    - WAREHOUSE NUMBER


* __Warehouse Inventory__
    - WAREHOUSE LOCATION ID [FK]
    - ITEM ID [FK]
    - QUANTITY


* __Vendors__
    - ID [PK]
    - VENDOR ID [VND-12345]
    - NAME
    - COUNTRY
    - STATE
    - CITY
    - CONTACT NAME
    - CONTACT INFO


* __Items__
    - ID [PK]
    - VENDOR ID [FK]
    - INVOICE NUMBER [FK]
    - ITEM RECEIVED DATE
    - ITEM CATEGORY (Kitchen, Merchandise, Storage)
    - ITEM DESCRIPTION (Fryer, Safe, Shelve)
    - ITEM COST
    - SERIAL NUMBER
    - TRANSFER #
    - TRANSFER DATE


* __Invoices__
    - ID [PK]
    - INVOICE NUMBER [DATE-0123456789]
    - INVOICE PURCHASE DATE
    - VENDOR ID [FK]
    - TAX
    - DELIVERY FEE
    - INVOICE TOTAL
    - PAYMENT STATUS (Pending, Paid, Overdue)


---

### REST API ENDPOINTS:

__Company Controller__
* GET, POST COMPANY
* GET{id}, PUT{id}, DELETE{id}

__Store Controller__
* GET, POST STORES
* GET{id}, PUT{id}, DELETE{id}

__Warehouse Controller__
* GET, POST WAREHOUSE
* GET{id}, PUT{id}, DELETE{id}

__Vendor Controller__
* GET, POST VENDOR
* GET{id}, PUT{id}, DELETE{id}

__Item Controller__
* GET, POST ITEM
* GET{id}, PUT{id}, DELETE{id}

__Invoice Controller__
* GET, POST Controller
* GET{id}, PUT{id}, DELETE{id}

---

__ADD IF I HAVE TIME:__

- Reporting Features
- Security/authorization

---

