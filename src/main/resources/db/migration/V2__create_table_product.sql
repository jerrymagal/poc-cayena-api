
CREATE TABLE IF NOT EXISTS `product` (
  `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `uuid` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `stock_quantity` int NOT NULL,
  `unit_price` DECIMAL NOT NULL,
  `dt_insert` DATETIME NOT NULL,
  `dt_update` DATETIME NULL,
  `supplier_id` INT,
  FOREIGN KEY (supplier_id) REFERENCES supplier(id)
) ;