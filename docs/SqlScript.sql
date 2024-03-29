CREATE TABLE users(
id SERIAL PRIMARY KEY,
name VARCHAR(32) NOT NULL,
surname VARCHAR(32) NOT NULL,
email VARCHAR(32) NOT NULL,
password VARCHAR(32) NOT NULL
);

CREATE TABLE currencies(
id SERIAL PRIMARY KEY,
name VARCHAR(32) NOT NULL,
shortname VARCHAR(32) NOT NULL,
symbol VARCHAR(1) NOT NULL
);

CREATE TABLE account(
id SERIAL PRIMARY KEY,
user_id INT NOT NULL REFERENCES users(id),
type VARCHAR(32) NOT NULL
);

CREATE TABLE account_currency(
id SERIAL PRIMARY KEY,
account_id INT NOT NULL REFERENCES account(id),
currency_id INT NOT NULL REFERENCES currencies(id),
balance INT NOT NULL
);

CREATE TABLE transactions(
id SERIAL PRIMARY KEY,
sender_id INT NOT NULL REFERENCES account(id),
recipient_id INT NOT NULL REFERENCES account(id),
date DATE NOT NULL,
time TIME NOT NULL,
amount INT NOT NULL
);

CREATE TABLE beneficiaries(
id SERIAL PRIMARY KEY,
name INT NOT NULL,
account_id INT NOT NULL REFERENCES account(id)
);

CREATE TABLE currency_exchange(
id SERIAL PRIMARY KEY,
from_id INT NOT NULL REFERENCES currencies(id),
to_id INT NOT NULL REFERENCES currencies(id),
amount FLOAT NOT NULL
)