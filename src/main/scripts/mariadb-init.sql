DROP DATABASE IF EXISTS diecast_finder_catalog;
DROP USER IF EXISTS `diecast_finder_catalog`@`%`;
CREATE DATABASE IF NOT EXISTS diecast_finder_catalog CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `diecast_finder_catalog`@`%` IDENTIFIED BY 'password_cat';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
    CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `diecast_finder_catalog`.* TO `diecast_finder_catalog`@`%`;
FLUSH PRIVILEGES;