CREATE TABLE IF NOT EXISTS roles (
    id SERIAL PRIMARY KEY,
    role_name VARCHAR(25),
    description VARCHAR(250)
    );

CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    code_text VARCHAR(7),
    full_name VARCHAR(150),
    cedula INT NOT NULL,
    email VARCHAR(255),
    password VARCHAR(50),
    role_id INT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id)
    );

CREATE TABLE IF NOT EXISTS devices (
    id SERIAL PRIMARY KEY,
    code_text VARCHAR(7),
    location VARCHAR(150),
    creation_date TIMESTAMP,
    last_maintenance VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS containers (
    id SERIAL PRIMARY KEY,
    code_text VARCHAR(7),
    location VARCHAR(150),
    capacity INT NOT NULL,
    last_emptying TIMESTAMP NOT NULL,
    filling_weight DECIMAL(5,2),
    weight_check BOOLEAN NOT NULL,
    device_id INT NOT NULL,
    FOREIGN KEY (device_id) REFERENCES devices(id)
    );


CREATE TABLE IF NOT EXISTS userregistration (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    container_id INT NOT NULL,
    FOREIGN KEY (container_id) REFERENCES containers(id)
    );

CREATE TABLE IF NOT EXISTS dailyrecords (
    id SERIAL PRIMARY KEY,
    userregistration_id INT NOT NULL,
    FOREIGN KEY (userregistration_id) REFERENCES userregistration(id)
    );

CREATE TABLE IF NOT EXISTS monthly_records (
    id SERIAL PRIMARY KEY,
    dailyrecords_id INT NOT NULL,
    FOREIGN KEY (dailyrecords_id) REFERENCES dailyrecords(id)
    );
