-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 28-Jan-2015 às 04:26
-- Versão do servidor: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ursystembk`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `admin`
--

INSERT INTO `admin` (`id`, `password`) VALUES
(101, 'admin');

-- --------------------------------------------------------

--
-- Estrutura da tabela `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `id` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `department` varchar(50) NOT NULL,
  `prerequisite` varchar(10) DEFAULT NULL,
  `value` double DEFAULT NULL,
  `term` varchar(50) NOT NULL,
  `status` enum('open','canceled','full') NOT NULL,
  `idProfessor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idProfessor` (`idProfessor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `course`
--

INSERT INTO `course` (`id`, `name`, `department`, `prerequisite`, `value`, `term`, `status`, `idProfessor`) VALUES
('BI101', 'General Biology', 'Biology', NULL, 3000, 'Spring/2015', 'open', 111),
('BI104', 'Biiological Foundations', 'Biology', NULL, 3000, 'Spring/2015', 'open', 110),
('BI105', 'Biomedical Terminology', 'Biology', NULL, 3000, 'Spring/2015', 'open', 111),
('BI112', 'Botany', 'Biology', 'BI104 BI10', 3000, 'Spring/2015', 'open', 112),
('BI216', 'Zoology', 'Biology', 'BI104 / BI', 3000, 'Spring/2015', 'open', 112),
('BI225', 'Comparative Anatomy', 'Biology', 'BI216', 3000, 'Spring/2015', 'open', 113),
('BI253', 'Introducy Microbiology', 'Biology', 'BI104', 3000, 'Spring/2015', 'open', 114),
('BI330', 'SCell Biology', 'Biology', 'BI253', 3000, 'Spring/2015', 'open', 114),
('CS180', 'Introdution do Computers', 'Computer Science', NULL, 3000, 'Spring/2015', 'open', 101),
('CS211', 'Computer Programming', 'Computer Science', NULL, 3000, 'Spring/2015', 'open', 101),
('CS231', 'Computer Science', 'Computer Science', NULL, 3000, 'Spring/2015', 'open', 102),
('CS331', 'Data Structures and Algoritms', 'Computer Science', 'CS231', 3000, 'Spring/2015', 'open', 103),
('CS372', 'Software Engineering', 'Computer Science', 'CS211', 3000, 'Spring/2015', 'open', 102),
('CS414', 'Computer ARchitecture', 'Computer Science', 'CS331', 3000, 'Spring/2015', 'open', 104),
('CS453', 'Artificial Intelligence', 'Computer Science', 'CS331', 3000, 'Spring/2015', 'open', 103),
('CS454', 'Robotics', 'Computer Science', 'CS331', 3000, 'Spring/2015', 'open', 104),
('PS111', 'General Chemistry and Analysis', 'Physical Science', NULL, 3000, 'Spring/2015', 'open', 106),
('PS135', 'Consumber Chemistry', 'Physical Science', NULL, 3000, 'Spring/2015', 'open', 107),
('PS152', 'Introdution to Organic and Biological Chemistry', 'Physical Science', NULL, 3000, 'Spring/2015', 'open', 107),
('PS343', 'Organic Chemistry', 'Physical Science', 'PS152', 3000, 'Spring/2015', 'open', 108),
('PS352', 'Biochemistry', 'Physical Science', 'PS343', 3000, 'Spring/2015', 'open', 108),
('PS355', 'Intrdution to Quantum Mechanics', 'Physical Science', 'PS111', 3000, 'Spring/2015', 'open', 109),
('PS421', 'Intrumental Analysis', 'Physical Science', 'PS343', 3000, 'Spring/2015', 'open', 109),
('PS447', 'Physical Chemistry', 'Physical Science', 'PS343', 3000, 'Spring/2015', 'open', 109),
('SO201', 'INtrodution to Sociology', 'Biology', NULL, 3000, 'Spring/2015', 'open', 115),
('SO307', 'Race and Ethnicity', 'Biology', 'SO201', 3000, 'Spring/2015', 'open', 116),
('SO370', 'Social Psychology', 'Biology', NULL, 3000, 'Spring/2015', 'open', 115),
('SO433', 'Sociological Theory', 'Biology', NULL, 3000, 'Spring/2015', 'open', 115),
('SO500', 'Perspective Consciousness', 'Biology', 'SO433', 3000, 'Spring/2015', 'open', 116),
('SO501', 'Social Problems', 'Biology', 'SO201', 3000, 'Spring/2015', 'open', 117),
('SO503', 'Theories of Deviance', 'Biology', 'SO500', 3000, 'Spring/2015', 'open', 118),
('SO505', 'Sociology of Violence', 'Biology', 'SO501', 3000, 'Spring/2015', 'open', 118);

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE IF NOT EXISTS `professor` (
  `id` int(11) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(150) NOT NULL,
  `password` varchar(16) NOT NULL,
  `title` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`id`, `fname`, `lname`, `password`, `title`) VALUES
(101, 'Jordan', 'Smith', '67mousE', 'Doctor'),
(102, 'Katherine', 'Watson', 'StaY909', 'Doctor'),
(103, 'Madison', 'Gray', '100animalS', 'Doctor'),
(104, 'Matthew', 'Patterson', 'weekeNd41', 'Doctor'),
(105, 'David', 'Hamilton', '27Mirrors', 'Doctor'),
(106, 'Jacqueline', 'West', 'daRk899', 'Doctor'),
(107, 'Jennifer', 'Stephens', '350blaMe', 'Doctor'),
(108, 'Tanisha', 'Stephens', 'mAps671', 'Doctor'),
(109, 'Nicole', 'Carlson', 'jaggeR555', 'Doctor'),
(110, 'Julia', 'Franklin', '1moRenighT', 'Doctor'),
(111, 'Johnny', 'Wall', 'Sugar500', 'Doctor'),
(112, 'Thomas', 'Johnson', '34payPhone', 'Doctor'),
(113, 'George', 'Lewis', 'withoutYou40', 'Doctor'),
(114, 'Robert', 'Allen', '10playHard', 'Doctor'),
(115, 'Samuel', 'Scott', 'dangeroUs8', 'Doctor'),
(116, 'Steven', 'Jones', '999loUd', 'Doctor'),
(117, 'Michael', 'Adams', '7titaniuM', 'Doctor'),
(118, 'James', 'Collins', 'chAndelier3', 'Doctor');

-- --------------------------------------------------------

--
-- Estrutura da tabela `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(150) NOT NULL,
  `password` varchar(16) NOT NULL,
  `major` varchar(50) NOT NULL,
  `billing` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `student`
--

INSERT INTO `student` (`id`, `fname`, `lname`, `password`, `major`, `billing`) VALUES
(10000, 'Hanna', 'Marin', 'baiL123', 'Computer Science', NULL),
(10001, 'Aria', 'Montgomery', 'Pen2312', 'Computer Science', NULL),
(10002, 'Emily', 'Fields', 'compuTer08', 'Computer Science', NULL),
(10003, 'Spencer', 'Hastings', 'moNey3', 'Computer Science', NULL),
(10004, 'Ezra', 'Fitz', 'fAce754', 'Computer Science', NULL),
(10005, 'Caleb', 'Rivers', 'yellow2Red', 'Biology', NULL),
(10006, 'Toby', 'Cavanaugh', 'star1000', 'Biology', NULL),
(10007, 'Noel', 'Kahn', 'Rock99Roll', 'Biology', NULL),
(10008, 'Tyrion', 'Lannister', '234slEEp', 'Biology', NULL),
(10009, 'Daenerys', 'Targaryen', 'Help134mE', 'Biology', NULL),
(10010, 'Jon', 'Snow', 'dEsk98', 'Sociology', NULL),
(10011, 'Catelyn', 'Stark', '45troublE', 'Sociology', NULL),
(10012, 'Bran', 'Stark', '45troublE', 'Sociology', NULL),
(10013, 'Walter', 'White', 'spAce999', 'Sociology', NULL),
(10014, 'Jesse', 'Pinkman', '982youtube', 'Sociology', NULL),
(10015, 'Alison', 'DiLaurentis', '4myLife', 'Physical Science', NULL),
(10016, 'Bobby', 'Singer', 'icanFly0', 'Physical Science', NULL),
(10017, 'Jon', 'Winchester', 'dEsk98', 'Physical Science', NULL),
(10018, 'Dean', 'Winchester', 'proBlem9', 'Physical Science', NULL),
(10019, 'Hanna', 'Marin', 'balL123', 'Physical Science', NULL),
(21513, 'Aldeide', 'Brasil', 'asb123', 'Computer Science', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `studentxcourse`
--

CREATE TABLE IF NOT EXISTS `studentxcourse` (
  `idStudent` int(11) NOT NULL DEFAULT '0',
  `idCourse` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`idStudent`,`idCourse`),
  KEY `idCourse` (`idCourse`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `studentxcourse`
--

INSERT INTO `studentxcourse` (`idStudent`, `idCourse`) VALUES
(10000, 'BI101'),
(10004, 'BI101'),
(10005, 'BI101'),
(10006, 'BI101'),
(10007, 'BI101'),
(10008, 'BI101'),
(10009, 'BI101'),
(10011, 'BI101'),
(10012, 'BI101'),
(10013, 'BI101'),
(10016, 'BI101'),
(10019, 'BI101'),
(10001, 'BI104'),
(10002, 'BI104'),
(10003, 'BI104'),
(10005, 'BI104'),
(10007, 'BI104'),
(10008, 'BI104'),
(10012, 'BI104'),
(10014, 'BI104'),
(10017, 'BI104'),
(10018, 'BI104'),
(10005, 'BI105'),
(10008, 'BI105'),
(10013, 'BI105'),
(10014, 'BI105'),
(10015, 'BI105'),
(10005, 'BI112'),
(10006, 'BI112'),
(10007, 'BI112'),
(10009, 'BI112'),
(10006, 'BI216'),
(10008, 'BI216'),
(10009, 'BI216'),
(10006, 'BI225'),
(10008, 'BI225'),
(10000, 'CS180'),
(10001, 'CS180'),
(10002, 'CS180'),
(10003, 'CS180'),
(10004, 'CS180'),
(10006, 'CS180'),
(10010, 'CS180'),
(10011, 'CS180'),
(10013, 'CS180'),
(10015, 'CS180'),
(10017, 'CS180'),
(10018, 'CS180'),
(10019, 'CS180'),
(10000, 'CS211'),
(10002, 'CS211'),
(10003, 'CS211'),
(10004, 'CS211'),
(10007, 'CS211'),
(10008, 'CS211'),
(10015, 'CS211'),
(10000, 'CS231'),
(10001, 'CS231'),
(10003, 'CS231'),
(10005, 'CS231'),
(10009, 'CS231'),
(10014, 'CS231'),
(10016, 'CS231'),
(10001, 'CS331'),
(10009, 'CS331'),
(10000, 'CS372'),
(10002, 'CS372'),
(10004, 'CS372'),
(10005, 'CS372'),
(10001, 'CS453'),
(10000, 'PS111'),
(10004, 'PS111'),
(10008, 'PS111'),
(10010, 'PS111'),
(10011, 'PS111'),
(10012, 'PS111'),
(10015, 'PS111'),
(10017, 'PS111'),
(10018, 'PS111'),
(10019, 'PS111'),
(10002, 'PS135'),
(10003, 'PS135'),
(10013, 'PS135'),
(10014, 'PS135'),
(10015, 'PS135'),
(10019, 'PS135'),
(10001, 'PS152'),
(10002, 'PS152'),
(10003, 'PS152'),
(10004, 'PS152'),
(10007, 'PS152'),
(10009, 'PS152'),
(10015, 'PS152'),
(10016, 'PS152'),
(10018, 'PS152'),
(10019, 'PS152'),
(10007, 'PS343'),
(10009, 'PS343'),
(10010, 'PS343'),
(10015, 'PS343'),
(10016, 'PS343'),
(10018, 'PS343'),
(10019, 'PS343'),
(10016, 'PS352'),
(10017, 'PS352'),
(10017, 'PS355'),
(10018, 'PS355'),
(10016, 'PS421'),
(10000, 'SO201'),
(10004, 'SO201'),
(10005, 'SO201'),
(10006, 'SO201'),
(10010, 'SO201'),
(10011, 'SO201'),
(10012, 'SO201'),
(10013, 'SO201'),
(10017, 'SO201'),
(10018, 'SO201'),
(10019, 'SO201'),
(10006, 'SO307'),
(10010, 'SO307'),
(10011, 'SO307'),
(10012, 'SO307'),
(10014, 'SO307'),
(10010, 'SO370'),
(10013, 'SO370'),
(10016, 'SO370'),
(10017, 'SO370'),
(10001, 'SO433'),
(10002, 'SO433'),
(10003, 'SO433'),
(10007, 'SO433'),
(10010, 'SO433'),
(10011, 'SO433'),
(10013, 'SO433'),
(10014, 'SO433'),
(10011, 'SO500'),
(10012, 'SO501'),
(10014, 'SO501'),
(10012, 'SO505');

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`idProfessor`) REFERENCES `professor` (`id`);

--
-- Limitadores para a tabela `studentxcourse`
--
ALTER TABLE `studentxcourse`
  ADD CONSTRAINT `studentxcourse_ibfk_1` FOREIGN KEY (`idStudent`) REFERENCES `student` (`id`),
  ADD CONSTRAINT `studentxcourse_ibfk_2` FOREIGN KEY (`idCourse`) REFERENCES `course` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
