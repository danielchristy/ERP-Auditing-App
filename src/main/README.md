# ERP INVENTORY AUDITING APPLICATION
## BCCA UNIT 8 PROJECT

---

## Table of Contents
1. [About](#about)
2. [Project Requirements](#project-requirements)
   - [Module 1](#module-1)
   - [Module 2](#module-2)
3. [Database Schema](#database-schema)
4. [REST API Endpoints](#rest-api-endpoints)
5. [Looking Forward](#looking-forward)


--- 

## About

This ERP (Enterprise Resource Planning) software system centralizes data and automates financial/accounting processes related to
inventory tracking across vendors, stores, warehouses, and invoices.

### Core Functionalities
- Centralized inventory and financial data
- CRUD operations for vendors, items, stores, warehouses, invoices
- Reports and analytics on vendors, invoices, and inventory
- Support for backlogged inventory

--- 

## Project Requirements

### Module 1
>* Data is stored in a Postgresql database
>* Data access is implemented with a Spring Data JPA Repository
>* Request/Response is handled with a Spring Web MVC RestController
>* Required endpoints: 
>  - `GET` the collection of all entries
>  - `POST` a new entry
>  - `GET` a single entry
>  - `PUT` a single entry
>  - `DELETE` a single entry

### Module 2

>* Data is stored in a Postgresql database
>* Data access is implemented with a Spring Data JPA Repository
>* Request/Response is handled with a Spring Web MVC RestController
>* At least three resources
>* At least one Many-to-Many relationship
>* At least on Many-to-One / One-To-Many relationship
>* Required endpoints:  
>  - At least two endpoints supporting `GET` to retrieve the collection of all entries of a resource 
>  - At least two endpoints supporting `POST` to create a new entry of a resource
>  - At least two endpoints supporting `GET` to retrieve a single entry of a resource
>  - At least two endpoints supporting `PUT` to update a single entry of a resource
>  - At least two endpoints supporting `DELETE` to delete a single entry of a resource

___

## Database Schema

### Company
| Column                     | Type                 |
|----------------------------|----------------------|
| ID                         | Primary Key (PK)     |
| EMPLOYER IDENTIFICATION NUMBER (EIN) | String (12-3456789) |
| NAME                       | String               |
| TOTAL ASSETS               | Decimal/Numeric      |

### User
| Column       | Type              | Notes                                  |
|-------------|------------------|----------------------------------------|
| ID          | Primary Key (PK)  |                                        |
| EMPLOYEE ID | String (DEPT-12345) |            |
| PASSWORD    | String            |                     |
| FIRST NAME  | String            |                                        |
| LAST NAME   | String            |                                        |
| EMAIL       | String            |                                        |
| PHONE       | String (1-123-456-7890) |                                      |
| COMPANY ID  | Foreign Key (FK)  | References Company(ID)                |
| ROLE        | Enum              | Controller, Manager, Supervisor, Accountant, Bookkeeper |

### Stores
| Column        | Type              | Notes                   |
|--------------|------------------|-------------------------|
| ID           | Primary Key (PK)  |                         |
| COMPANY ID   | Foreign Key (FK)  | References Company(ID)  |
| LOCATION ID  | String (ST-USA-STATE-CITY-STORE#) | Unique Store Identifier |
| LOCATION COUNTRY | String        |                         |
| LOCATION STATE   | String        |                         |
| LOCATION CITY    | String        |                         |
| STORE NUMBER    | Integer        |                         |

### Store Inventory
| Column           | Type              | Notes                           |
|-----------------|------------------|---------------------------------|
| STORE LOCATION ID | Foreign Key (FK) | References Stores(LOCATION ID)  |
| ITEM ID         | Foreign Key (FK)  | References Items(ID)            |
| QUANTITY        | Integer           |                   |

### Warehouses
| Column        | Type              | Notes                       |
|--------------|------------------|-----------------------------|
| ID           | Primary Key (PK)  |                             |
| COMPANY ID   | Foreign Key (FK)  | References Company(ID)      |
| LOCATION ID  | String (WH-USA-STATE-CITY-WAREHOUSE#) | Unique Warehouse Identifier |
| LOCATION COUNTRY | String        |                             |
| LOCATION STATE   | String        |                             |
| LOCATION CITY    | String        |                             |
| WAREHOUSE NUMBER | Integer       |                             |

### Warehouse Inventory
| Column              | Type              | Notes                           |
|--------------------|------------------|---------------------------------|
| WAREHOUSE LOCATION ID | Foreign Key (FK) | References Warehouses(LOCATION ID) |
| ITEM ID           | Foreign Key (FK)  | References Items(ID)            |
| QUANTITY         | Integer           | Stock quantity                  |

### Vendors
| Column       | Type              | Notes                    |
|-------------|------------------|--------------------------|
| ID          | Primary Key (PK)  |                          |
| VENDOR ID   | String (VND-12345) | Unique Vendor Identifier |
| NAME        | String            | Vendor name              |
| COUNTRY     | String            |                          |
| STATE       | String            |                          |
| CITY        | String            |                          |
| CONTACT NAME | String           |                          |
| CONTACT INFO | String           |                          |

### Items
| Column            | Type              | Notes                               |
|------------------|------------------|-------------------------------------|
| ID               | Primary Key (PK)  |                                     |
| VENDOR ID        | Foreign Key (FK)  | References Vendors(ID)              |
| INVOICE NUMBER   | Foreign Key (FK)  | References Invoices(INVOICE NUMBER) |
| ITEM RECEIVED DATE | Date            |                                     |
| ITEM CATEGORY    | Enum              | Kitchen, Merchandise, Storage, etc. |
| ITEM DESCRIPTION | String            | Fryer, Safe, Shelve, etc.           |
| ITEM COST        | Decimal/Numeric   |                                     |
| SERIAL NUMBER    | String            |                                     |
| TRANSFER #       | String            |                                     |
| TRANSFER DATE    | Date              |                                     |

### Invoices
| Column               | Type              | Notes                              |
|---------------------|------------------|------------------------------------|
| ID                 | Primary Key (PK)  |                                    |
| INVOICE NUMBER     | String (DATE-0123456789) | Unique invoice identifier     |
| INVOICE PURCHASE DATE | Date            |                                    |
| VENDOR ID          | Foreign Key (FK)  | References Vendors(ID)            |
| TAX               | Decimal/Numeric   |                                    |
| DELIVERY FEE      | Decimal/Numeric   |                                    |
| INVOICE TOTAL     | Decimal/Numeric   |                                    |
| PAYMENT STATUS    | Enum              | Pending, Paid, Overdue            |

---

## REST API Endpoints:

### Company Controller
- **GET** `/companies` – Retrieve all companies
- **POST** `/companies` – Create a new company
- **GET** `/companies/{id}` – Retrieve a specific company by ID
- **PUT** `/companies/{id}` – Update a specific company
- **DELETE** `/companies/{id}` – Delete a specific company

### Store Controller
- **GET** `/stores` – Retrieve all stores
- **POST** `/stores` – Create a new store
- **GET** `/stores/{id}` – Retrieve a specific store by ID
- **PUT** `/stores/{id}` – Update a specific store
- **DELETE** `/stores/{id}` – Delete a specific store

### Warehouse Controller
- **GET** `/warehouses` – Retrieve all warehouses
- **POST** `/warehouses` – Create a new warehouse
- **GET** `/warehouses/{id}` – Retrieve a specific warehouse by ID
- **PUT** `/warehouses/{id}` – Update a specific warehouse
- **DELETE** `/warehouses/{id}` – Delete a specific warehouse

### Vendor Controller
- **GET** `/vendors` – Retrieve all vendors
- **POST** `/vendors` – Create a new vendor
- **GET** `/vendors/{id}` – Retrieve a specific vendor by ID
- **PUT** `/vendors/{id}` – Update a specific vendor
- **DELETE** `/vendors/{id}` – Delete a specific vendor

### Item Controller
- **GET** `/items` – Retrieve all items
- **POST** `/items` – Create a new item
- **GET** `/items/{id}` – Retrieve a specific item by ID
- **PUT** `/items/{id}` – Update a specific item
- **DELETE** `/items/{id}` – Delete a specific item

### Invoice Controller
- **GET** `/invoices` – Retrieve all invoices
- **POST** `/invoices` – Create a new invoice
- **GET** `/invoices/{id}` – Retrieve a specific invoice by ID
- **PUT** `/invoices/{id}` – Update a specific invoice
- **DELETE** `/invoices/{id}` – Delete a specific invoice

---

## Looking Forward

- **Reporting Features**: Implement automation for generating reports.
- **Improve Search Features**: Implement filtering through various criteria.
- **Audit Logging**: Implement the ability to track financial and inventory changes for compliance.
- **Security/authorization**: Implement authentication and role-based access control.

---

