 CREATE TABLE `device` (
   `device_id` varchar(50) DEFAULT NULL,
   `record_type` varchar(50) DEFAULT NULL,
   `event_date_time` datetime DEFAULT NULL,
   `fielda` int DEFAULT NULL,
   `fieldb` varchar(50) DEFAULT NULL,
   `fieldc` float DEFAULT NULL
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci