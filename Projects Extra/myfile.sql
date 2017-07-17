-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.34 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for testing
CREATE DATABASE IF NOT EXISTS `testing` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `testing`;


-- Dumping structure for table testing.mappedproblems
CREATE TABLE IF NOT EXISTS `mappedproblems` (
  `PROBLEM_ID` int(11) NOT NULL,
  `PROBLEM_SET_ID` int(11) NOT NULL,
  PRIMARY KEY (`PROBLEM_ID`,`PROBLEM_SET_ID`),
  KEY `FK_1o539djbgrnbefccqknlmrrj3` (`PROBLEM_SET_ID`),
  CONSTRAINT `FK_1o539djbgrnbefccqknlmrrj3` FOREIGN KEY (`PROBLEM_SET_ID`) REFERENCES `problem_set` (`problem_set_id`),
  CONSTRAINT `FK_6ywdktxvwp49v5snrw3j1cj8h` FOREIGN KEY (`PROBLEM_ID`) REFERENCES `problem` (`problem_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table testing.mappedproblems: ~2 rows (approximately)
/*!40000 ALTER TABLE `mappedproblems` DISABLE KEYS */;
REPLACE INTO `mappedproblems` (`PROBLEM_ID`, `PROBLEM_SET_ID`) VALUES
	(100001, 1),
	(100002, 1);
/*!40000 ALTER TABLE `mappedproblems` ENABLE KEYS */;


-- Dumping structure for table testing.problem
CREATE TABLE IF NOT EXISTS `problem` (
  `problem_id` int(11) NOT NULL AUTO_INCREMENT,
  `difficulty` varchar(255) DEFAULT NULL,
  `problem_category` varchar(255) DEFAULT NULL,
  `problem_name` varchar(255) DEFAULT NULL,
  `problem_text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`problem_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100006 DEFAULT CHARSET=latin1;

-- Dumping data for table testing.problem: ~5 rows (approximately)
/*!40000 ALTER TABLE `problem` DISABLE KEYS */;
REPLACE INTO `problem` (`problem_id`, `difficulty`, `problem_category`, `problem_name`, `problem_text`) VALUES
	(100001, NULL, NULL, 'Thread Problem', 'WAP to create n threads.\r\n'),
	(100002, NULL, NULL, 'Iteration Problem', 'WAP to calculate sum of number from m to n.'),
	(100003, NULL, NULL, 'Pattern Problem', 'WAP to create star equilateral triangle'),
	(100004, NULL, NULL, 'String Problem', 'WAP to create 2 eqaul substrings from given string'),
	(100005, NULL, NULL, 'Array Problem', 'WAP to sort the given array');
/*!40000 ALTER TABLE `problem` ENABLE KEYS */;


-- Dumping structure for table testing.problem_set
CREATE TABLE IF NOT EXISTS `problem_set` (
  `problem_set_id` int(11) NOT NULL AUTO_INCREMENT,
  `duration` int(11) DEFAULT NULL,
  `problem_set_name` varchar(255) DEFAULT NULL,
  `shared_id` varchar(255) NOT NULL,
  PRIMARY KEY (`problem_set_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table testing.problem_set: ~1 rows (approximately)
/*!40000 ALTER TABLE `problem_set` DISABLE KEYS */;
REPLACE INTO `problem_set` (`problem_set_id`, `duration`, `problem_set_name`, `shared_id`) VALUES
	(1, 20, 'some name', 'yo');
/*!40000 ALTER TABLE `problem_set` ENABLE KEYS */;


-- Dumping structure for table testing.result
CREATE TABLE IF NOT EXISTS `result` (
  `result_number` int(11) NOT NULL AUTO_INCREMENT,
  `memory_used` double NOT NULL,
  `test_case_bit` int(11) NOT NULL,
  `time_taken` double NOT NULL,
  `userSubmission_submission_id` int(11) DEFAULT NULL,
  `testCase_test_case_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`result_number`),
  KEY `FK_npw9u8q5q41e2286gqm6bi3oa` (`userSubmission_submission_id`),
  KEY `FK_result_test_case` (`testCase_test_case_id`),
  CONSTRAINT `FK_result_test_case` FOREIGN KEY (`testCase_test_case_id`) REFERENCES `test_case` (`test_case_id`),
  CONSTRAINT `FK_npw9u8q5q41e2286gqm6bi3oa` FOREIGN KEY (`userSubmission_submission_id`) REFERENCES `submission` (`submission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table testing.result: ~0 rows (approximately)
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
/*!40000 ALTER TABLE `result` ENABLE KEYS */;


-- Dumping structure for table testing.submission
CREATE TABLE IF NOT EXISTS `submission` (
  `submission_id` int(11) NOT NULL AUTO_INCREMENT,
  `version_number` int(11) NOT NULL,
  `problem_problem_id` int(11) DEFAULT NULL,
  `userTest_user_test_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`submission_id`),
  KEY `FK_ie2b9b5gtjr3dd0ksj08ugylf` (`problem_problem_id`),
  KEY `FK_cwa4cnornrmro4nuvstndxg7s` (`userTest_user_test_id`),
  CONSTRAINT `FK_cwa4cnornrmro4nuvstndxg7s` FOREIGN KEY (`userTest_user_test_id`) REFERENCES `user_test` (`user_test_id`),
  CONSTRAINT `FK_ie2b9b5gtjr3dd0ksj08ugylf` FOREIGN KEY (`problem_problem_id`) REFERENCES `problem` (`problem_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table testing.submission: ~1 rows (approximately)
/*!40000 ALTER TABLE `submission` DISABLE KEYS */;
REPLACE INTO `submission` (`submission_id`, `version_number`, `problem_problem_id`, `userTest_user_test_id`) VALUES
	(1, 1, 100001, 32);
/*!40000 ALTER TABLE `submission` ENABLE KEYS */;


-- Dumping structure for table testing.submission_score
CREATE TABLE IF NOT EXISTS `submission_score` (
  `submission_score_id` int(11) NOT NULL,
  `userSubmission_submission_id` int(11) NOT NULL,
  `submission_score` int(11) NOT NULL,
  PRIMARY KEY (`submission_score_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table testing.submission_score: ~0 rows (approximately)
/*!40000 ALTER TABLE `submission_score` DISABLE KEYS */;
/*!40000 ALTER TABLE `submission_score` ENABLE KEYS */;


-- Dumping structure for table testing.test_case
CREATE TABLE IF NOT EXISTS `test_case` (
  `test_case_id` int(11) NOT NULL AUTO_INCREMENT,
  `input` varchar(255) DEFAULT NULL,
  `output` varchar(255) DEFAULT NULL,
  `test_case_difficulty` varchar(255) DEFAULT NULL,
  `problem_problem_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`test_case_id`),
  KEY `FK_fc6hwhsyoy64c1nxpslk3k7lo` (`problem_problem_id`),
  CONSTRAINT `FK_fc6hwhsyoy64c1nxpslk3k7lo` FOREIGN KEY (`problem_problem_id`) REFERENCES `problem` (`problem_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table testing.test_case: ~1 rows (approximately)
/*!40000 ALTER TABLE `test_case` DISABLE KEYS */;
REPLACE INTO `test_case` (`test_case_id`, `input`, `output`, `test_case_difficulty`, `problem_problem_id`) VALUES
	(1, '1', '1', '2', 100001);
/*!40000 ALTER TABLE `test_case` ENABLE KEYS */;


-- Dumping structure for table testing.user
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `dob` datetime DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile_number` bigint(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `registration_time` time DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table testing.user: ~2 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`user_id`, `dob`, `email`, `first_name`, `last_name`, `mobile_number`, `password`, `registration_time`, `user_role`) VALUES
	(2, '2017-01-10 00:00:00', 'ab@bc.cd', 'Adesh', 'Dsilva', 1234564561, '$2a$10$8WUjNyUCvMOpiZ7Gf7pZpOFP9oaTt46SMIvHnj4n54dkBU5yvKcDy', '13:17:48', 'ROLE_USER'),
	(3, '2016-09-28 16:01:21', 'admin@admin.com', 'Admin', 'Admin', 211231, '$2a$10$8WUjNyUCvMOpiZ7Gf7pZpOFP9oaTt46SMIvHnj4n54dkBU5yvKcDy', '16:01:36', 'ROLE_ADMIN');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Dumping structure for table testing.user_test
CREATE TABLE IF NOT EXISTS `user_test` (
  `user_test_id` int(11) NOT NULL AUTO_INCREMENT,
  `start_time` datetime DEFAULT NULL,
  `problemSet_problem_set_id` int(11) DEFAULT NULL,
  `user_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_test_id`),
  KEY `FK_ibeepxyq3ku7hd2afegsi3wg1` (`problemSet_problem_set_id`),
  KEY `FK_8g74gx81j0qrgybfngyvtg4p3` (`user_user_id`),
  CONSTRAINT `FK_8g74gx81j0qrgybfngyvtg4p3` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_ibeepxyq3ku7hd2afegsi3wg1` FOREIGN KEY (`problemSet_problem_set_id`) REFERENCES `problem_set` (`problem_set_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

-- Dumping data for table testing.user_test: ~1 rows (approximately)
/*!40000 ALTER TABLE `user_test` DISABLE KEYS */;
REPLACE INTO `user_test` (`user_test_id`, `start_time`, `problemSet_problem_set_id`, `user_user_id`) VALUES
	(32, '2016-09-30 10:26:08', 1, 2);
/*!40000 ALTER TABLE `user_test` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
