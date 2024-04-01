CREATE TABLE bank_user (
    id SERIAL PRIMARY KEY,
    name VARCHAR(32) NOT NULL,
    surname VARCHAR(32) NOT NULL,
    email VARCHAR(32) NOT NULL,
    password VARCHAR(32) NOT NULL
);

CREATE TABLE currency (
    id SERIAL PRIMARY KEY,
    name VARCHAR(32) NOT NULL,
    shortname VARCHAR(32) NOT NULL,
    symbol VARCHAR(1) NOT NULL
);

CREATE TABLE bank_account (
    id SERIAL PRIMARY KEY,
	user_id INT,
    FOREIGN KEY (user_id) REFERENCES bank_user(id),
    balance INT NOT NULL,
    account_type VARCHAR(32) NOT NULL
);

CREATE TABLE bank_account_currency (
	bank_account_id INT,
	currency_id INT,
    FOREIGN KEY (bank_account_id) REFERENCES bank_account(id),
    FOREIGN KEY (currency_id) REFERENCES currency(id)
);

CREATE TABLE bank_transaction (
    id SERIAL PRIMARY KEY,
	sender_id INT,
	recipient_id INT,
    FOREIGN KEY (sender_id) REFERENCES bank_account(id),
    FOREIGN KEY (recipient_id) REFERENCES bank_account(id),
    date DATE NOT NULL,
    time TIME NOT NULL,
    amount INT NOT NULL
);

CREATE TABLE currency_exchange (
    id SERIAL PRIMARY KEY,
	from_id INT,
	to_id INT,
    FOREIGN KEY (from_id) REFERENCES currency(id),
    FOREIGN KEY (to_id) REFERENCES currency(id),
    amount FLOAT NOT NULL
);

CREATE TABLE loan_application (
    id SERIAL PRIMARY KEY,
	bank_account_id INT,
    FOREIGN KEY (bank_account_id) REFERENCES bank_account(id),
    amount INT NOT NULL,
    interest INT NOT NULL,
    period_in_months INT NOT NULL
);