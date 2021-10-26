
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `uuid` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `dt_insert` DATETIME NOT NULL,
  `dt_update` DATETIME NULL 
) ;