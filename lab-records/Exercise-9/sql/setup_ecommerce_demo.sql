-- setup_ecommerce_demo.sql
-- Run this script in MySQL Workbench (or any MySQL client) to create a demo
-- database, a products table and some sample data for the JDBC exercises.
--
-- Usage in MySQL Workbench:
-- 1) Open MySQL Workbench and connect as a user that can create databases (for example `root`).
-- 2) Create a new SQL tab and paste or open this file.
-- 3) Review and adjust usernames/passwords/hosts below as needed.
-- 4) Click the lightning bolt (execute) to run the script.

-- ==============================================================
-- Configuration: change these values if you want a custom user
-- ==============================================================
-- NOTE: The CREATE USER / GRANT section is optional. If you prefer
-- to use the existing `root` user, skip the CREATE USER / GRANT block.
-- Uncomment it if you want to create a dedicated application user.

-- Database and schema
CREATE DATABASE IF NOT EXISTS `ecommerce_demo` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `ecommerce_demo`;

-- Products table: basic fields used by the demo apps
CREATE TABLE IF NOT EXISTS `products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` TEXT DEFAULT NULL,
  `price` DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Sample data
INSERT INTO `products` (`name`, `description`, `price`) VALUES
  ('Sample Product A', 'A short description for product A.', 19.99),
  ('Sample Product B', 'A short description for product B.', 29.95),
  ('Sample Product C', 'A short description for product C.', 9.50)
ON DUPLICATE KEY UPDATE name=VALUES(name);

-- Optional: create a dedicated app user (uncomment to use)
-- Replace 'AppUserPass1!' with a strong password of your choice.
-- If your MySQL server uses a remote host, change 'localhost' to the client host
-- or use '%' (less secure) to allow connections from any host.
--
-- CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'AppUserPass1!';
-- GRANT ALL PRIVILEGES ON `ecommerce_demo`.* TO 'appuser'@'localhost';
-- FLUSH PRIVILEGES;

-- Quick verification queries (run after the script finishes):
-- SHOW DATABASES;
-- USE ecommerce_demo;
-- SELECT COUNT(*) FROM products;
-- SELECT * FROM products LIMIT 10;

-- End of script
