--------------------
-- TABLE: beneficiary
--------------------

CREATE TABLE beneficiary (
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(256) NOT NULL,
    cdi_number VARCHAR(256),
    account VARCHAR(32) NOT NULL,
    version INTEGER NOT NULL DEFAULT 0
);

CREATE INDEX idx_beneficiary_1 ON beneficiary(name);

INSERT INTO beneficiary (name, cdi_number, account) VALUES ('Uladzimir Radchuk', 'CDI00001', '3250000122');
INSERT INTO beneficiary (name, cdi_number, account) VALUES ('Rida Abraham',      'CDI00002', '4950008708');