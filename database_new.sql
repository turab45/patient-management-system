
DROP TABLE IF EXISTS `complaint`;

CREATE TABLE `complaint` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `complaint` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `test_id` int(11) DEFAULT NULL,
  `drug_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_id` (`patient_id`),
  KEY `test_id` (`test_id`),
  KEY `drug_id` (`drug_id`),
  CONSTRAINT `complaint_ibfk_2` FOREIGN KEY (`test_id`) REFERENCES `test` (`id`),
  CONSTRAINT `complaint_ibfk_3` FOREIGN KEY (`drug_id`) REFERENCES `drug` (`id`),
  CONSTRAINT `complaint_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

insert  into `complaint`(`id`,`complaint`,`remarks`,`patient_id`,`test_id`,`drug_id`) values (1,'compalint 1','nothing',1,1,1);