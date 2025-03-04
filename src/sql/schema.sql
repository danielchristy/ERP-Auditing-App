DROP TABLE IF EXISTS warehouse_inventory, store_inventory, invoices, items,
    vendors, warehouses, stores, users, company CASCADE;


CREATE TABLE company (
                         id SERIAL PRIMARY KEY,
                         ein VARCHAR(10) UNIQUE NOT NULL CHECK (ein ~ '^[0-9]{2}-[0-9]{7}$'),
                         name VARCHAR(255) NOT NULL,
                         total_assets DECIMAL(18,2) DEFAULT 0
);

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       employee_id VARCHAR(20) UNIQUE NOT NULL CHECK (employee_id ~ '^[A-Z]+-[0-9]+$'),
                       password VARCHAR(255) NOT NULL,
                       first_name VARCHAR(255) NOT NULL,
                       last_name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL CHECK (email ~ '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$'),
                       phone VARCHAR(15) CHECK (phone ~ '^[0-9-]+$'),
                       company_id INT NOT NULL,
                       role VARCHAR(20) CHECK (role IN ('Controller', 'Manager', 'Supervisor',
                                                        'Accountant', 'Bookkeeper')),
                       FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE CASCADE
);

CREATE TABLE stores (
                        id SERIAL PRIMARY KEY,
                        company_id INT NOT NULL,
                        location_id VARCHAR(255) UNIQUE NOT NULL,
                        country VARCHAR(255) NOT NULL,
                        state VARCHAR(255) NOT NULL,
                        city VARCHAR(255) NOT NULL,
                        store_number INT NOT NULL CHECK (store_number > 0),
                        FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE CASCADE
);

CREATE TABLE store_inventory (
                         store_location_id VARCHAR(50) NOT NULL,
                         item_id INT NOT NULL,
                         quantity INT NOT NULL CHECK (quantity >= 0),
                         PRIMARY KEY (store_location_id, item_id),
                         FOREIGN KEY (store_location_id) REFERENCES stores(location_id) ON DELETE CASCADE,
                         FOREIGN KEY (item_id) REFERENCES items(id) ON DELETE CASCADE
);

CREATE TABLE warehouses (
                        id SERIAL PRIMARY KEY,
                        company_id INT NOT NULL,
                        location_id VARCHAR(50) UNIQUE NOT NULL,
                        country VARCHAR(255) NOT NULL,
                        state VARCHAR(255) NOT NULL,
                        city VARCHAR(255) NOT NULL,
                        warehouse_number INT NOT NULL CHECK (warehouse_number > 0),
                        FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE CASCADE
);

CREATE TABLE warehouse_inventory (
                        warehouse_location_id VARCHAR(50) NOT NULL,
                        item_id INT NOT NULL,
                        quantity INT NOT NULL CHECK (quantity >= 0),
                        PRIMARY KEY (warehouse_location_id, item_id),
                        FOREIGN KEY (warehouse_location_id) REFERENCES warehouses(location_id) ON DELETE CASCADE,
                        FOREIGN KEY (item_id) REFERENCES items(id) ON DELETE CASCADE
);

CREATE TABLE vendors (
                        id SERIAL PRIMARY KEY,
                        vendor_id VARCHAR(20) UNIQUE NOT NULL CHECK (vendor_id ~ '^VND-[0-9]+$'),
                        name VARCHAR(255) NOT NULL,
                        country VARCHAR(255) NOT NULL,
                        state VARCHAR(255) NOT NULL,
                        city VARCHAR(255) NOT NULL,
                        contact_name VARCHAR(255) NOT NULL,
                        contact_info VARCHAR(255) NOT NULL
);

CREATE TABLE items (
                        id SERIAL PRIMARY KEY,
                        vendor_id INT NOT NULL,
                        invoice_number VARCHAR(50),
                        item_received_date DATE NOT NULL,
                        item_category VARCHAR(255),
                        item_description VARCHAR(255) NOT NULL,
                        item_cost DECIMAL(18,2) NOT NULL CHECK (item_cost >= 0),
                        serial_number VARCHAR(50) UNIQUE NOT NULL,
                        transfer_number VARCHAR(50),
                        transfer_date DATE,
                        FOREIGN KEY (vendor_id) REFERENCES vendors(id) ON DELETE CASCADE,
                        FOREIGN KEY (invoice_number) REFERENCES invoices(invoice_number) ON DELETE SET NULL
);

CREATE TABLE invoices (
                        id SERIAL PRIMARY KEY,
                        invoice_number VARCHAR(20) UNIQUE NOT NULL CHECK (invoice_number ~ '^[0-9]{8}-[0-9]+$'),
                        invoice_purchase_date DATE NOT NULL,
                        vendor_id INT NOT NULL,
                        tax DECIMAL(18,2) DEFAULT 0 CHECK (tax >= 0),
                        delivery_fee DECIMAL(18,2) DEFAULT 0 CHECK (delivery_fee >= 0),
                        invoice_total DECIMAL(18,2) NOT NULL CHECK (invoice_total >= 0),
                        payment_status VARCHAR(20) CHECK (payment_status IN ('Pending', 'Paid', 'Overdue')),
                        FOREIGN KEY (vendor_id) REFERENCES vendors(id) ON DELETE CASCADE
);
