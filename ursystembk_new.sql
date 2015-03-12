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

CREATE TABLE IF NOT EXISTS `term` (
  `id` int NOT NULL,
  `name` enum ('Spring', 'Fall', 'Summer', 'Winter') NOT NULL,
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

 INSERT INTO `term`(`id`, `name`) VALUES 
 (1, 'Spring'),
 (2, 'Fall'),
 (3, 'Summer'),
 (4, 'Winter');

CREATE TABLE IF NOT EXISTS `course` (
  `id` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `department` varchar(50) NOT NULL,
  `prerequisite` varchar(10) DEFAULT NULL,
  `value` double DEFAULT NULL,
  `idTerm` int NOT NULL,
  `year` varchar(4),
  `status` enum('open','canceled','full') NOT NULL,
  PRIMARY KEY (`id`), FOREIGN KEY (`idTerm`) REFERENCES `term`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Extraindo dados da tabela `course`
--

INSERT INTO `course` (`id`, `name`, `department`, `prerequisite`, `value`, `idTerm`, `year`,  `status`) VALUES
('BI101', 'General Biology', 'Biology', NULL, 3000, '1','2015', 'open'),
('BI104', 'Biiological Foundations', 'Biology', NULL, 3000, '1','2015', 'open'),
('BI105', 'Biomedical Terminology', 'Biology', NULL, 3000, '1','2015', 'open'),
('BI112', 'Botany', 'Biology', 'BI104 BI10', 3000, '1','2015', 'open'),
('BI216', 'Zoology', 'Biology', 'BI104 / BI', 3000, '1','2015', 'open'),
('BI225', 'Comparative Anatomy', 'Biology', 'BI216', 3000, '1','2015', 'open'),
('BI253', 'Introducy Microbiology', 'Biology', 'BI104', 3000, '1','2015', 'open'),
('BI330', 'SCell Biology', 'Biology', 'BI253', 3000, '1','2015', 'open'),
('CS180', 'Introdution do Computers', 'Computer Science', NULL, 3000, '1','2015', 'open'),
('CS211', 'Computer Programming', 'Computer Science', NULL, 3000, '1','2015', 'open'),
('CS231', 'Computer Science', 'Computer Science', NULL, 3000, '1','2015', 'open'),
('CS331', 'Data Structures and Algoritms', 'Computer Science', 'CS231', 3000, '1','2015', 'open'),
('CS372', 'Software Engineering', 'Computer Science', 'CS211', 3000, '1','2015', 'open'),
('CS414', 'Computer ARchitecture', 'Computer Science', 'CS331', 3000, '1','2015', 'open'),
('CS453', 'Artificial Intelligence', 'Computer Science', 'CS331', 3000, '1','2015', 'open'),
('CS454', 'Robotics', 'Computer Science', 'CS331', 3000, '1','2015', 'open'),
('PS111', 'General Chemistry and Analysis', 'Physical Science', NULL, 3000, '1','2015', 'open'),
('PS135', 'Consumber Chemistry', 'Physical Science', NULL, 3000, '1','2015', 'open'),
('PS152', 'Introdution to Organic and Biological Chemistry', 'Physical Science', NULL, 3000, '1','2015', 'open'),
('PS343', 'Organic Chemistry', 'Physical Science', 'PS152', 3000, '1','2015', 'open'),
('PS352', 'Biochemistry', 'Physical Science', 'PS343', 3000, '1','2015', 'open'),
('PS355', 'Intrdution to Quantum Mechanics', 'Physical Science', 'PS111', 3000, '1','2015', 'open'),
('PS421', 'Intrumental Analysis', 'Physical Science', 'PS343', 3000, '1','2015', 'open'),
('PS447', 'Physical Chemistry', 'Physical Science', 'PS343', 3000, '1','2015', 'open'),
('SO201', 'INtrodution to Sociology', 'Biology', NULL, 3000, '1','2015', 'open'),
('SO307', 'Race and Ethnicity', 'Biology', 'SO201', 3000, '1','2015', 'open'),
('SO370', 'Social Psychology', 'Biology', NULL, 3000, '1','2015', 'open'),
('SO433', 'Sociological Theory', 'Biology', NULL, 3000, '1','2015', 'open'),
('SO500', 'Perspective Consciousness', 'Biology', 'SO433', 3000, '1','2015', 'open'),
('SO501', 'Social Problems', 'Biology', 'SO201', 3000, '1','2015', 'open'),
('SO503', 'Theories of Deviance', 'Biology', 'SO500', 3000, '1','2015', 'open'),
('SO505', 'Sociology of Violence', 'Biology', 'SO501', 3000, '1','2015', 'open');

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
CREATE TABLE IF NOT EXISTS `professorxcourse` (
  `idProfessor` int NOT NULL,
  `idCourse` varchar(10) NOT NULL,
  PRIMARY KEY (`idProfessor`,`idCourse`),
  FOREIGN KEY (`idProfessor`) REFERENCES professor(`id`),
  FOREIGN KEY (`idCourse`) REFERENCES course(`id`)
);

INSERT INTO `professorxcourse` (`idCourse`, `idProfessor`) VALUES
('CS180',101),
('CS211',101),
('CS231',102),
('CS372',102),
('CS331',103),
('CS453',103),
('CS414',104),
('CS454',105),
('PS111',106),
('PS135',107),
('PS152',107),
('PS343',108),
('PS352',108),
('PS355',109),
('PS421',109),
('PS447',109),
('BI104',110),
('BI101',111),
('BI105',111),
('BI112',112),
('BI216',112),
('BI225',113),
('BI253',114),
('BI330',114),
('SO201',115),
('SO370',115),
('SO433',115),
('SO307',116),
('SO500',116),
('SO501',117),
('SO503',118),
('SO505',118);

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
  `idStudent` int NOT NULL DEFAULT '0',
  `idCourse` varchar(10) NOT NULL DEFAULT '',
  `idTerm` int,
  `year` varchar (4), 
  PRIMARY KEY (`idStudent`,`idCourse`),
  KEY `idCourse` (`idCourse`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `studentxcourse`
--

INSERT INTO `studentxcourse` (`idStudent`, `idCourse`,`idTerm`,`year`) VALUES
(10000, 'CS180', 2, '2014'),
(10000, 'CS211', 2, '2014'),
(10000, 'CS231', 2, '2014'),
(10000, 'BI101', 2, '2014'),
(10002, 'CS180', 2, '2014'),
(10002, 'CS211', 2, '2014'),
(10002, 'CS231', 2, '2014'),
(10002, 'BI101', 2, '2014'),
(10003, 'CS180', 2, '2014'),
(10003, 'CS211', 2, '2014'),
(10003, 'CS231', 2, '2014'),
(10003, 'BI101', 2, '2014'),
(10004, 'CS180', 2, '2014'),
(10004, 'CS211', 2, '2014'),
(10004, 'CS231', 2, '2014'),
(10004, 'BI101', 2, '2014'),
(10001, 'CS180', 2, '2014'),
(10001, 'CS211', 2, '2014'),
(10001, 'CS231', 2, '2014'),
(10001, 'BI101', 2, '2014'),
(10000, 'CS372', 1, '2015'),
(10000, 'CS331', 1, '2015'),
(10000, 'SO201', 1, '2015'),
(10000, 'BI104', 1, '2015'),
(10001, 'CS372', 1, '2015'),
(10001, 'CS331', 1, '2015'),
(10001, 'SO201', 1, '2015'),
(10001, 'BI104', 1, '2015'),
(10002, 'CS372', 1, '2015'),
(10002, 'CS331', 1, '2015'),
(10002, 'SO201', 1, '2015'),
(10002, 'BI104', 1, '2015'),
(10003, 'CS372', 1, '2015'),
(10003, 'CS331', 1, '2015'),
(10003, 'SO201', 1, '2015'),
(10003, 'BI104', 1, '2015'),
(10004, 'CS372', 1, '2015'),
(10004, 'CS331', 1, '2015'),
(10004, 'SO201', 1, '2015'),
(10004, 'BI104', 1, '2015'),
(10005, 'BI104', 2, '2014'),
(10005, 'PS111', 2, '2014'),
(10005, 'BI105', 2, '2014'),
(10005, 'CS180', 2, '2014'),
(10006, 'BI104', 2, '2014'),
(10006, 'PS111', 2, '2014'),
(10006, 'BI105', 2, '2014'),
(10006, 'CS180', 2, '2014'),
(10007, 'BI104', 2, '2014'),
(10007, 'PS111', 2, '2014'),
(10007, 'BI105', 2, '2014'),
(10007, 'CS180', 2, '2014'),
(10008, 'BI104', 2, '2014'),
(10008, 'PS111', 2, '2014'),
(10008, 'BI105', 2, '2014'),
(10008, 'CS180', 2, '2014'),
(10009, 'BI104', 2, '2014'),
(10009, 'PS111', 2, '2014'),
(10009, 'BI105', 2, '2014'),
(10009, 'CS180', 2, '2014'),
(10005, 'BI112', 1, '2015'),
(10005, 'BI216', 1, '2015'),
(10005, 'SO201', 1, '2015'),
(10005, 'BI101', 1, '2015'),
(10006, 'BI112', 1, '2015'),
(10006, 'BI216', 1, '2015'),
(10006, 'SO201', 1, '2015'),
(10006, 'BI101', 1, '2015'),
(10007, 'BI112', 1, '2015'),
(10007, 'BI216', 1, '2015'),
(10007, 'SO201', 1, '2015'),
(10007, 'BI101', 1, '2015'),
(10008, 'BI112', 1, '2015'),
(10008, 'BI216', 1, '2015'),
(10008, 'SO201', 1, '2015'),
(10008, 'BI101', 1, '2015'),
(10009, 'BI112', 1, '2015'),
(10009, 'BI216', 1, '2015'),
(10009, 'SO201', 1, '2015'),
(10009, 'BI101', 1, '2015'),
(10010, 'SO201', 2, '2014'),
(10010, 'SO370', 2, '2014'),
(10010, 'SO433', 2, '2014'),
(10010, 'PS152', 2, '2014'),
(10011, 'SO201', 2, '2014'),
(10011, 'SO370', 2, '2014'),
(10011, 'SO433', 2, '2014'),
(10011, 'PS152', 2, '2014'),
(10012, 'SO201', 2, '2014'),
(10012, 'SO370', 2, '2014'),
(10012, 'SO433', 2, '2014'),
(10012, 'PS152', 2, '2014'),
(10013, 'SO201', 2, '2014'),
(10013, 'SO370', 2, '2014'),
(10013, 'SO433', 2, '2014'),
(10013, 'PS152', 2, '2014'),
(10014, 'SO201', 2, '2014'),
(10014, 'SO370', 2, '2014'),
(10014, 'SO433', 2, '2014'),
(10014, 'PS152', 2, '2014'),
(10010, 'SO307', 1, '2015'),
(10010, 'SO500', 1, '2015'),
(10010, 'SO501', 1, '2015'),
(10010, 'CS180', 1, '2015'),
(10011, 'SO307', 1, '2015'),
(10011, 'SO500', 1, '2015'),
(10011, 'SO501', 1, '2015'),
(10011, 'CS180', 1, '2015'),
(10012, 'SO307', 1, '2015'),
(10012, 'SO500', 1, '2015'),
(10012, 'SO501', 1, '2015'),
(10012, 'CS180', 1, '2015'),
(10013, 'SO307', 1, '2015'),
(10013, 'SO500', 1, '2015'),
(10013, 'SO501', 1, '2015'),
(10013, 'CS180', 1, '2015'),
(10014, 'SO307', 1, '2015'),
(10014, 'SO500', 1, '2015'),
(10014, 'SO501', 1, '2015'),
(10014, 'CS180', 1, '2015'),
(10015, 'PS111', 2, '2014'),
(10015, 'PS135', 2, '2014'),
(10015, 'PS152', 2, '2014'),
(10015, 'BI101', 2, '2014'),
(10016, 'PS111', 2, '2014'),
(10016, 'PS135', 2, '2014'),
(10016, 'PS152', 2, '2014'),
(10016, 'BI101', 2, '2014'),
(10017, 'PS111', 2, '2014'),
(10017, 'PS135', 2, '2014'),
(10017, 'PS152', 2, '2014'),
(10017, 'BI101', 2, '2014'),
(10018, 'PS111', 2, '2014'),
(10018, 'PS135', 2, '2014'),
(10018, 'PS152', 2, '2014'),
(10018, 'BI101', 2, '2014'),
(10019, 'PS111', 2, '2014'),
(10019, 'PS135', 2, '2014'),
(10019, 'PS152', 2, '2014'),
(10019, 'BI101', 2, '2014'),
(10015, 'PS343', 1, '2015'),
(10015, 'BI104', 1, '2015'),
(10015, 'CS180', 1, '2015'),
(10015, 'CS211', 1, '2015'),
(10016, 'PS343', 1, '2015'),
(10016, 'BI104', 1, '2015'),
(10016, 'CS180', 1, '2015'),
(10016, 'CS211', 1, '2015'),
(10017, 'PS343', 1, '2015'),
(10017, 'BI104', 1, '2015'),
(10017, 'CS180', 1, '2015'),
(10017, 'CS211', 1, '2015'),
(10018, 'PS343', 1, '2015'),
(10018, 'BI104', 1, '2015'),
(10018, 'CS180', 1, '2015'),
(10018, 'CS211', 1, '2015'),
(10019, 'PS343', 1, '2015'),
(10019, 'BI104', 1, '2015'),
(10019, 'CS180', 1, '2015'),
(10019, 'CS211', 1, '2015');

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `studentxcourse`
--
ALTER TABLE `studentxcourse`
  ADD CONSTRAINT `studentxcourse_ibfk_1` FOREIGN KEY (`idStudent`) REFERENCES `student` (`id`),
  ADD CONSTRAINT `studentxcourse_ibfk_2` FOREIGN KEY (`idCourse`) REFERENCES `course` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
