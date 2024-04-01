CREATE TABLE bank_user (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(32) NOT NULL,
    surname VARCHAR(32) NOT NULL,
    email VARCHAR(32) NOT NULL,
    password VARCHAR(32) NOT NULL
);

CREATE TABLE currency (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(32) NOT NULL,
    shortname VARCHAR(32) NOT NULL,
    symbol VARCHAR(1) NOT NULL
);

CREATE TABLE bank_account (
    id SERIAL PRIMARY KEY NOT NULL,
	id_user INT,
    balance INT NOT NULL,
    account_type VARCHAR(32) NOT NULL,

    CONSTRAINT fk_bank_user FOREIGN KEY (id_user) REFERENCES bank_user(id)
);

CREATE TABLE bank_account_currency (
	id_bank_account INT,
	id_currency INT,

    CONSTRAINT fk_bank_account FOREIGN KEY (id_bank_account) REFERENCES bank_account(id),
    CONSTRAINT fk_currency FOREIGN KEY (id_currency) REFERENCES currency(id),
    CONSTRAINT pk_bank_account_currency PRIMARY KEY(id_bank_account, id_currency)
);

CREATE TABLE bank_transaction (
    id SERIAL PRIMARY KEY NOT NULL,
	id_sender INT,
	id_recipient INT,
    date DATE NOT NULL,
    time TIME NOT NULL,
    amount INT NOT NULL,

    CONSTRAINT fk_bank_account_sender FOREIGN KEY (id_sender) REFERENCES bank_account(id),
    CONSTRAINT fk_bank_account_recipient FOREIGN KEY (id_recipient) REFERENCES bank_account(id)
);

CREATE TABLE currency_exchange (
    id SERIAL PRIMARY KEY NOT NULL,
	id_from INT,
	id_to INT,
    amount FLOAT NOT NULL,

    CONSTRAINT fk_currency_from FOREIGN KEY (id_from) REFERENCES currency(id),
    CONSTRAINT fk_currency_to FOREIGN KEY (id_to) REFERENCES currency(id)
);

CREATE TABLE loan_application (
    id SERIAL PRIMARY KEY NOT NULL,
	id_bank_account INT,
    amount INT NOT NULL,
    interest INT NOT NULL,
    period_in_months INT NOT NULL,

    CONSTRAINT fk_bank_account FOREIGN KEY (id_bank_account) REFERENCES bank_account(id)
);