CREATE SCHEMA IF NOT EXISTS clients_system;

CREATE TABLE IF NOT EXISTS clients_system.clients
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);