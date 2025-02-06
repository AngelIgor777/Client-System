CREATE TABLE IF NOT EXISTS clients_system.contacts
(
    id        SERIAL PRIMARY KEY,
    client_id INT                                            NOT NULL,
    type      VARCHAR(50) CHECK (type IN ('PHONE', 'EMAIL')) NOT NULL,
    value     VARCHAR(255)                                   NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients_system.clients (id) ON DELETE CASCADE
);