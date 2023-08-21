-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 16, 2023 at 06:08 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `book_keeper`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `admin_fname` varchar(15) NOT NULL,
  `admin_lname` varchar(15) NOT NULL,
  `admin_email` varchar(50) NOT NULL,
  `admin_position` varchar(15) NOT NULL,
  `admin_password` varchar(300) NOT NULL,
  `admin_status` varchar(20) NOT NULL,
  `admin_contact` varchar(11) NOT NULL,
  `admin_address` varchar(200) NOT NULL,
  `admin_formatted_id` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_fname`, `admin_lname`, `admin_email`, `admin_position`, `admin_password`, `admin_status`, `admin_contact`, `admin_address`, `admin_formatted_id`) VALUES
(1, 'Arthur', 'Artugue', 'admin1@gmail.com', 'Admin', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'Active', '09953653123', 'San Pedro Laguna', 'bkad-00000001'),
(2, 'Leila Jane', 'Montemayor', 'admin2@gmail.com', 'Admin', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'Active', '09493337935', '121b, Milkweed, Rizal, Makati', 'bkad-00000002'),
(3, 'Juden Mikel', 'Rey', 'jude@gmail.com', 'Employee', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'Active', '09998887654', '123, J.P. Rizal Extension, West Rembo, Makati', 'bkad-00000003'),
(4, 'Aaron', 'Villamento', 'aaron@gmail.com', 'Employee', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'Active', '09128674936', '132, J.P. Rizal Extension, West Rembo, Taguig City', 'bkad-00000004'),
(5, 'Mark', 'Toralde', 'mark@gmail.com', 'Employee', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'Active', '09176295342', '123, J.P. Rizal Extension, West Bicutan, Taguig City', 'bkad-00000005');

--
-- Triggers `admin`
--
DELIMITER $$
CREATE TRIGGER `generate_admin_formatted_id` BEFORE INSERT ON `admin` FOR EACH ROW BEGIN
    SET @next_id = (SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'admin');
    SET NEW.admin_formatted_id = CONCAT('bkad-', LPAD(@next_id, 8, '0'));
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trg_admin_auto_generate_id` BEFORE INSERT ON `admin` FOR EACH ROW BEGIN
  IF NEW.admin_formatted_id = '' OR NEW.admin_formatted_id IS NULL THEN
    SET NEW.admin_formatted_id = CONCAT('bkad-', LPAD(NEW.admin_id, 8, '0'));
  END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `book_id` int(11) NOT NULL,
  `book_title` varchar(50) NOT NULL,
  `author_name` varchar(30) NOT NULL,
  `genre_name` varchar(20) NOT NULL,
  `book_publication_date` date NOT NULL,
  `book_publisher` varchar(50) NOT NULL,
  `book_status` varchar(50) NOT NULL,
  `ISBN` varchar(14) NOT NULL,
  `aisle_number` int(11) NOT NULL,
  `shelf_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_id`, `book_title`, `author_name`, `genre_name`, `book_publication_date`, `book_publisher`, `book_status`, `ISBN`, `aisle_number`, `shelf_number`) VALUES
(4, 'Harry Potter and the Chamber of Secrets', 'J.K. Rowling', 'Fantasy', '1998-07-02', 'Bloomsbury Publishing', 'Available', '9780747532743', 3, 4),
(5, 'Harry Potter and the Prisoner of Azkaban', 'J.K. Rowling', 'Fantasy', '1999-07-08', 'Bloomsbury Publishing', 'Available', '9780747538493', 3, 4),
(6, 'Harry Potter and the Goblet of Fire', 'J.K. Rowling', 'Fantasy', '2000-07-08', 'Bloomsbury Publishing', 'Available', '9780747542155', 3, 4),
(7, 'To Kill a Mockingbird', 'Harper Lee', 'Novel', '1960-07-11', 'J. B. Lippincott & Co.', 'Available', '9780061120084', 10, 20),
(8, 'The Great Gatsby', 'F. Scott Fitzgerald', 'Classic', '1925-04-10', 'Charles Scribner\'s Sons', 'Available', '9780743273565', 1, 20),
(9, 'Pride and Prejudice', 'Jane Austen', 'Classic', '1813-01-28', 'T. Egerton, Whitehall', 'Available', '9780141439518', 1, 15),
(10, 'To the Lighthouse', 'Virginia Woolf', 'Fiction', '1927-05-05', 'Hogarth Press', 'Available', '9780156030471', 5, 20),
(11, 'Brave New World', 'Aldous Huxley', 'Science Fiction', '1932-10-27', 'Chatto & Windus', 'Available', '9780060929879', 13, 2),
(12, 'The Catcher in the Rye', 'J.D. Salinger', 'Fiction', '1951-07-16', 'Little, Brown and Company', 'Available', '9780316769174', 5, 20),
(13, 'Moby-Dick', 'Herman Melville', 'Fiction', '1851-10-18', 'Harper & Brothers', 'Available', '9780060920081', 5, 10),
(14, 'The Lord of the Rings', 'J.R.R. Tolkien', 'Fantasy', '1954-07-29', 'Allen & Unwin', 'Available', '9780618640157', 3, 7),
(15, 'To the Lighthouse', 'Virginia Woolf', 'Fiction', '1927-05-05', 'Hogarth Press', 'Available', '9780156030471', 5, 20),
(16, 'The Picture of Dorian Gray', 'Oscar Wilde', 'Fiction', '1890-07-01', 'Ward, Lock and Company', 'Available', '9780198189698', 5, 15),
(17, 'The Odyssey', 'Homer', 'Epic Poetry', '1890-07-05', 'Unknown', 'Available', '9780199536788', 3, 6),
(18, 'Frankenstein', 'Mary Shelley', 'Gothic Fiction', '1818-01-01', 'Lackington, Hughes, Harding, Mavor & Jones', 'Available', '9780199535774', 6, 6),
(19, 'Don Quixote', 'Miguel de Cervantes', 'Novel', '1605-01-16', 'Francisco de Robles', 'Available', '9788420603699', 10, 4),
(20, 'The Hobbit', 'J.R.R. Tolkien', 'Fantasy', '1937-09-21', 'George Allen & Unwin', 'Available', '9780547928227', 3, 6),
(21, '1984', 'George Orwell', 'Dystopian', '1949-06-08', 'Secker & Warburg', 'Borrowed', '9780452284234', 2, 1),
(22, 'The Chronicles of Narnia', 'C.S. Lewis', 'Fantasy', '1950-10-16', 'Geoffrey Bles', 'Available', '9780007117307', 3, 6),
(23, 'The Alchemist', 'Paulo Coelho', 'Fiction', '1988-01-01', 'HarperCollins', 'Available', '9780061122415', 1, 2),
(24, 'The Da Vinci Code', 'Dan Brown', 'Thriller', '2003-03-18', 'Doubleday', 'Available', '9780385504201', 16, 20),
(25, 'Battle Royale', 'Koushun Takami', 'Dystopian', '2003-02-26', 'Ohta Publishing', 'Borrowed', '9781569317785', 2, 13),
(26, 'The Girl on the Train', 'Paula Hawkins', 'Mystery', '2015-01-15', 'Transworld Publishers', 'Available', '9781594634024', 9, 20),
(27, 'Gone Girl', 'Gillian Flynn', 'Thriller', '2012-06-05', 'Crown Publishing Group', 'Available', '9780307588371', 16, 7),
(28, 'The Fault in Our Stars', 'John Green', 'Classic', '2012-01-10', 'Dutton Books', 'Available', '9780525426004', 17, 20),
(29, 'The Help', 'Kathryn Stockett', 'Historical Fiction', '2009-02-10', 'Penguin Group', 'Available', '9780399155345', 7, 20),
(30, 'The Shining', 'Stephen King', 'Horror', '1977-01-28', 'Doubleday', 'Available', '9780385121675', 8, 20),
(31, 'IT', 'Stephen King', 'Horror', '1986-09-15', 'Viking Press', 'Available', '9780670813025', 8, 9),
(32, 'Crime and Punishment', 'Fyodor Dostoyevsky', 'Classic', '1866-12-25', 'Simon & Schuster', 'Available', '9780486415871', 1, 1),
(33, 'The Good Earth', 'Pearl S. Buck', 'Classic', '1931-03-02', 'The John Day Company', 'Available', '9781416500186', 1, 2),
(34, 'A Doll\'s House and Other Plays', 'Henrik Ibsen', 'Classic', '2016-02-13', 'Penguin Classics', 'Available', '9780141194561', 1, 1),
(35, 'Snells', 'Efraem', 'Science', '2023-05-23', 'Efraem', 'Available', '9780000000004', 14, 19),
(36, 'The Hunger Games', 'Suzanne Collins', 'Dystopian', '2008-09-14', 'Scholastic', 'Available', '9780439023481', 2, 5),
(37, 'Fahrenheit 451', 'Ray Bradbury', 'Dystopian', '1953-10-19', 'Simon & Schuster', 'Available', '9781451673319', 2, 34),
(38, 'Holes', 'Louis Sachar', 'Classic', '1998-08-20', 'Farrar, Strau and Giroux', 'Available', '9780440414803', 1, 2),
(39, 'The Clue in the Crumbling Wall', 'Carolyn Keene', 'Classic', '1945-02-01', 'The Putnam and Grosset Group', 'Available', '0448095220', 1, 2),
(40, 'The Handmaid\'s Tale', 'Margaret Atwood', 'Dystopian', '1985-08-18', 'McClelland and Stewart Houghton Mifflin Harcourt ', 'Available', '9783125776920', 2, 10),
(41, 'Blindness', 'José Saramago', 'Dystopian', '1998-09-01', 'Caminho', 'Available', '9781860466854', 2, 6),
(42, 'Beowulf', 'Unknown', 'Epic Poetry', '2005-07-01', 'Simon & Schuster ', 'Available', '9780374111199', 3, 2),
(43, 'Inferno', 'Dante Alighieri', 'Epic Poetry', '1472-04-11', 'Dante Publisher', 'Available', '9781593083311', 3, 6),
(44, 'The Epic of Gilgamesh', 'Sin-Leqi-Unninni', 'Epic Poetry', '1960-12-30', '‎Penguin Classics', 'Available', '9780140441000', 3, 6),
(45, 'The Divine Comedy', 'Dante Alighieri', 'Epic Poetry', '1472-04-11', 'Dante Publisher', 'Available', '9780451192912', 3, 5),
(46, 'Mahabharata', 'Ved Vyasa', 'Epic Poetry', '1951-01-01', '‎Penguin Classics', 'Borrowed', '9780140446814', 3, 4),
(47, 'The Tale of Desperaux', 'Kate DiCamillo', 'Fantasy', '2003-08-25', 'Candlewick Press', 'Available', '9780763625291', 4, 8),
(48, 'Ravensong', 'TJ Klune', 'Fantasy', '2019-09-21', '‎Bowker', 'Borrowed', '9781732399976', 4, 5),
(49, 'He Who Drowned the World', 'Shelley Parker-Chan', 'Fantasy', '2022-08-22', '‎Tor Books', 'Available', '9781250900913', 4, 3),
(50, 'A Hero Born', 'Jin Yong', 'Fantasy', '1957-01-01', 'St. Martin\'s Press', 'Available', '9781250220622', 4, 1),
(51, 'A Game of Thrones', 'George R.R. Martin', 'Fantasy', '1996-08-01', 'Bantam', 'Available', '9780553593716', 4, 1),
(52, 'Kapitan Sino', 'Bob Ong', 'Fiction', '1905-07-01', 'Visual Print Enterprises', 'Available', '9710545019', 5, 8),
(53, 'Unchanged', 'Regina Alison De Luna', 'Fiction', '1905-06-29', 'Giraffe Books', 'Borrowed', '9789710362554', 5, 9),
(54, 'The Boxcar Children', 'Gertrude Chandler Warner', 'Fiction', '1905-04-07', 'General Publishing', 'Available', '8075920720', 5, 9),
(55, 'From the Mixed-up Files of Mrs. Frankweiler', 'E.L. Konigsburg', 'Fiction', '1967-01-01', 'Dell Publishing Company', 'Available', '4404318018', 5, 6),
(56, 'Owl Friends', 'Carla M. Pacis', 'Fiction', '1997-01-01', 'Cacho Publishing House', 'Available', '9711902044', 5, 10),
(57, 'The Little Stranger', 'Sarah Waters', 'Gothic Fiction', '2010-05-04', 'Riverhead Books', 'Available', '9781594484469', 6, 20),
(58, 'The Castle of Otranto', 'Horace Walpole', 'Gothic Fiction', '1764-12-24', 'Macmillan Publishing Company', 'Available', '9780198704447', 6, 20),
(59, 'Dracula', 'Bram Stoker', 'Gothic Fiction', '2019-01-24', 'CreateSpace Independent', 'Available', '9781503261389', 6, 4),
(60, 'The Strange Case of Dr. Jekyll and Mr. Hyde', 'Robert Louis Stevenson', 'Gothic Fiction', '1886-01-05', '‎CreateSpace Independent', 'Available', '9781505234510', 6, 20),
(61, 'Island of the Blue Dophins', 'Scott O\'Dell', 'Historical Fiction', '1960-09-09', 'Bantam Doubleday Dell Books', 'Available', '4404398847', 7, 9),
(62, 'Secret of the Andes', 'Ann Nolan Clark', 'Historical Fiction', '1952-01-01', 'Penguin Group', 'Available', '1403092681', 7, 19),
(63, 'The Pearl', 'John Steinbeck', 'Historical Fiction', '1947-01-01', 'Penguin Group', 'Available', '9780140177374', 7, 20),
(64, 'Noli Me Tángere', 'José Rizal', 'Historical Fiction', '1887-02-21', 'Digireads Publishing', 'Available', '9780143039693', 7, 14),
(65, 'Ilustrado: A Novel', 'Miguel Syjuco', 'Historical Fiction', '2010-04-27', '‎Farrar, Straus and Giroux', 'Available', '9780374174781', 7, 9),
(66, 'Hell House', 'Richard Matheson', 'Horror', '1999-10-13', 'Tor Publishing Group', 'Available', '9780312868857', 8, 8),
(67, 'Coraline', 'Neil Gaiman', 'Horror', '2002-07-02', 'Bloomsbury Publishing', 'Available', '9780380791712', 8, 3),
(68, 'Ring', 'Koji Suzuki', 'Horror', '2004-04-25', 'Kadokawa Shoten, Vertical, Inc.', 'Available', '9781932234411', 8, 13),
(69, 'Interview with the Vampire', 'Anne Rice', 'Horror', '1991-09-13', 'Ballantine Books', 'Available', '9780340919408', 8, 8),
(70, 'Gone Girl', 'Gillian Flynn', 'Mystery', '2012-06-15', 'Crown Publishing Group', 'Available', '9780307477477', 9, 7),
(71, 'The Da Vinci Code', 'Dan Brown', 'Mystery', '2003-03-18', 'Doubleday', 'Available', '9780274808328', 9, 20),
(72, 'The Cuckoo\'s Calling', 'Robert Galbraith', 'Mystery', '2013-04-30', 'Mulholland Books', 'Available', '9780316348648', 9, 20),
(73, 'A Good Girl\'s Guide to Murder', 'Holly Jackson', 'Mystery', '2020-02-04', 'Random House Children\'s Books', 'Available', '9781984896360', 9, 1),
(74, 'The Adventures of Sherlock Holmes', 'Arthur Conan Doyle', 'Mystery', '2015-06-21', 'George Newnes', 'Available', '9781514639047', 9, 20),
(75, 'Velocity', 'Kristin McCloy', 'Novel', '1988-09-12', 'Random House Inc.Random House Inc.', 'Available', '5170564619', 10, 21),
(76, 'House on Fire', 'Arch Oboler', 'Novel', '1969-09-01', 'Bartholomew House ', 'Available', '7579433610', 10, 8),
(77, 'The Great Gatsby', 'F. Scott Fitzgerald', 'Novel', '2004-09-30', 'Scribner', 'Available', '9780743273565', 10, 20),
(78, 'Chinese Cinderella', 'Adeline Yen Mah', 'Non-Fiction', '1999-08-02', 'Delacorte Press', 'Available', '9780385740074', 11, 3),
(79, 'The Subtle Art Of Not Giving A F*ck', 'Mark Manson', 'Non-Fiction', '2016-09-13', 'HarperOne', 'Available', '9780062457714', 11, 20),
(80, 'The Wimpy Kid Movie Diary', 'Jeff Kinney', 'Non-Fiction', '2010-01-01', 'Amulet Books', 'Available', '9780810996168', 11, 20),
(81, 'Chicken Soup for the College Soul', 'Jack Canfield', 'Non-Fiction', '1999-01-01', 'Health Communications Inc.', 'Available', '1558747036', 11, 3),
(82, 'Call Me By Your Name', 'André Aciman', 'Romance', '2007-01-23', 'Farrar, Straus and Giroux', 'Available', '9781786495259', 12, 3),
(83, 'Love and Gelato', 'Jenna Evans Welch', 'Romance', '2016-05-03', 'Simon Pulse', 'Available', '9781481432559', 12, 7),
(84, 'The Notebook', 'Nicholas Sparks', 'Romance', '2004-02-01', 'Warner Books', 'Available', '9780446605236', 12, 20),
(85, 'It Ends with Us', 'Colleen Hoover', 'Romance', '2016-08-02', 'Atria Books', 'Available', '9781501106910', 12, 8),
(86, 'The Hitchhiker\'s Guide to the Galaxy', 'Douglas Adams', 'Science Fiction', '2002-04-30', '‎Del Rey', 'Available', '9780345391803', 13, 20),
(87, 'Journey to the Center of the Earth', 'Jules Verne', 'Science Fiction', '1864-11-25', 'Pierre-Jules Hetzel', 'Available', '9781514640609', 13, 10),
(88, 'Dune', 'Frank Herbert', 'Science Fiction', '1990-09-01', 'Ace', 'Available', '9780441013593', 13, 4),
(89, 'The Stand', 'Stephen King', 'Science Fiction', '2011-06-28', ' ‎Anchor', 'Available', '9780307743688', 13, 20),
(90, 'I, Robot', 'Isaac Asimov', 'Science Fiction', '1991-11-01', 'Spectra', 'Available', '9780553294385', 13, 7),
(91, 'The Immortal Life of Henrietta Lacks', 'Rebecca Skloot', 'Science', '2011-03-08', '‎Crown', 'Available', '9781400052189', 14, 20),
(92, 'Cosmos', 'Carl Sagan', 'Science', '2002-05-07', '‎Ballantine Books', 'Available', '9780345539434', 14, 3),
(93, 'On the Origin of Species', 'Charles Darwin', 'Science', '1859-11-24', 'Avenel', 'Available', '9780451529060', 14, 10),
(94, 'The Gene: An Intimate History', 'Siddhartha Mukherjee', 'Science', '2017-04-18', 'Large Print Press', 'Available', '9780099584575', 14, 20),
(95, 'Packing for Mars', 'Mary Roach', 'Science', '2010-08-02', '‎W. W. Norton & Company', 'Available', '9780393068474', 14, 11),
(96, 'Julie of the Wolves', 'Jean Craighead George', 'Survival', '2019-07-02', '‎HarperCollins', 'Available', '9780064400589', 15, 9),
(97, 'Mockingjay', 'Suzanne Collins', 'Survival', '2014-02-25', 'Scholastic Press', 'Available', '9780545663267', 15, 13),
(98, 'The Road', 'Cormac McCarthy', 'Survival', '2006-09-26', 'Alfred A. Knopf', 'Available', '9780307387899', 15, 20),
(99, 'Catching Fire', 'Suzanne Collins', 'Survival', '2013-06-04', 'Scholastic Press', 'Available', '9780545586177', 15, 3),
(100, 'The Couple Next Door', 'Shari Lapena', 'Thriller', '2022-12-06', 'Penguin Publishing Group', 'Available', '9780593511497', 16, 20),
(101, 'Wrong Place Wrong Time', 'Gillian McAllister', 'Thriller', '2023-05-23', 'HarperCollins Publishers', 'Available', '9780063252356', 16, 22),
(102, 'The Maid', 'Nita Prose', 'Thriller', '2023-01-03', 'Random House Publishing Group', 'Available', '9780593356173', 16, 20),
(103, 'Hidden Bodies', 'Caroline Kepnes', 'Thriller', '2016-02-23', 'Atria/Emily Bestler Books', 'Available', '9781476785639', 16, 20),
(104, 'The Woman in Cabin 10', 'Ruth Ware', 'Thriller', '2017-04-11', 'Gallery/Scout Press', 'Available', '9781501131639', 16, 20),
(105, 'My Side of the Mountain', 'Jean Craighead George', 'Young adult', '1959-01-01', 'Penguin Group', 'Available', '1413124245', 17, 12),
(106, 'Hoot', 'Carl Hiaasen', 'Young adult', '2002-09-10', 'Yearling', 'Available', '9780440419396', 17, 8),
(107, 'Banana Heart Summer', 'Merlinda Bobis', 'Young adult', '2005-05-20', 'Pier 9', 'Available', '9712717399', 17, 2),
(108, 'Tall Story', 'Candy Gourlay', 'Young adult', '2010-05-27', 'Cacho Publishing House', 'Available', '9789711903008', 17, 18),
(109, 'The Fault in Our Stars', 'John Green', 'Young adult', '2012-01-10', 'Dutton Books', 'Available', '9780142424179', 17, 20);

-- --------------------------------------------------------

--
-- Table structure for table `borrowed_book`
--

CREATE TABLE `borrowed_book` (
  `borrow_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `borrowed_date` date NOT NULL,
  `borrowed_due_date` date NOT NULL,
  `borrow_status` varchar(10) NOT NULL,
  `returned_date` date DEFAULT NULL,
  `patron_id` varchar(13) NOT NULL,
  `borrow_time` time DEFAULT NULL,
  `penalizedOrNot` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `borrowed_book`
--

INSERT INTO `borrowed_book` (`borrow_id`, `book_id`, `borrowed_date`, `borrowed_due_date`, `borrow_status`, `returned_date`, `patron_id`, `borrow_time`, `penalizedOrNot`) VALUES
(1, 21, '2023-08-13', '2023-09-04', 'Returned', '2023-08-13', 'bkpa-00000012', '20:01:28', 'No'),
(2, 11, '2023-08-13', '2023-09-04', 'Returned', '2023-08-15', 'bkpa-00000013', '20:08:03', 'No'),
(3, 19, '2023-08-13', '2023-09-04', 'Returned', '2023-08-13', 'bkpa-00000014', '20:11:05', 'No'),
(4, 11, '2023-08-13', '2023-09-04', 'Out', NULL, 'bkpa-00000013', '20:49:26', 'No'),
(5, 18, '2023-08-14', '2023-09-05', 'Returned', '2023-08-15', 'bkpa-00000013', '22:17:54', 'No'),
(6, 33, '2023-08-14', '2023-09-05', 'Returned', '2023-08-15', 'bkpa-00000013', '22:18:24', 'No'),
(7, 19, '2023-08-15', '2023-09-06', 'Returned', '2023-08-15', 'bkpa-00000013', '01:12:27', 'No'),
(8, 27, '2023-08-15', '2023-09-06', 'Returned', '2023-08-15', 'bkpa-00000013', '01:18:46', 'No'),
(9, 4, '2023-08-15', '2023-09-06', 'Returned', '2023-08-15', 'bkpa-00000013', '01:19:02', 'No'),
(10, 5, '2023-08-15', '2023-09-06', 'Returned', '2023-08-16', 'bkpa-00000013', '01:19:22', 'No'),
(11, 31, '2023-08-15', '2023-09-06', 'Returned', '2023-08-16', 'bkpa-00000013', '01:19:44', 'No'),
(12, 13, '2023-08-15', '2023-09-06', 'Returned', '2023-08-16', 'bkpa-00000013', '01:19:56', 'No'),
(13, 38, '2023-08-15', '2023-09-06', 'Returned', '2023-08-15', 'bkpa-00000013', '01:20:23', 'No'),
(14, 39, '2023-08-15', '2023-09-06', 'Returned', '2023-08-15', 'bkpa-00000013', '01:20:36', 'No'),
(16, 48, '2023-08-16', '2023-08-17', 'Out', NULL, 'bkpa-00000013', '19:20:07', 'No'),
(17, 21, '2023-08-16', '2023-08-17', 'Out', NULL, 'bkpa-00000037', '23:32:26', 'No'),
(18, 25, '2023-08-16', '2023-08-17', 'Out', NULL, 'bkpa-00000012', '23:32:49', 'No'),
(19, 46, '2023-08-16', '2023-08-17', 'Out', NULL, 'bkpa-00000025', '23:33:40', 'No'),
(20, 53, '2023-08-16', '2023-08-17', 'Out', NULL, 'bkpa-00000028', '23:34:14', 'No');

-- --------------------------------------------------------

--
-- Table structure for table `patron`
--

CREATE TABLE `patron` (
  `patron_id` int(11) NOT NULL,
  `formatted_id` varchar(13) NOT NULL,
  `patron_fname` varchar(15) NOT NULL,
  `patron_lname` varchar(15) NOT NULL,
  `patron_email` varchar(50) NOT NULL,
  `patron_contact` varchar(12) NOT NULL,
  `patron_address` varchar(200) NOT NULL,
  `patron_password` varchar(300) NOT NULL,
  `patron_status` varchar(20) NOT NULL,
  `penalty` int(1) NOT NULL,
  `num_of_reserved` int(1) NOT NULL,
  `num_of_borrowed` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patron`
--

INSERT INTO `patron` (`patron_id`, `formatted_id`, `patron_fname`, `patron_lname`, `patron_email`, `patron_contact`, `patron_address`, `patron_password`, `patron_status`, `penalty`, `num_of_reserved`, `num_of_borrowed`) VALUES
(12, 'bkpa-00000012', 'Arthur', 'Artugue', 'arthur@gmail.com', '09953653123', 'Blk 8 lot 6a, Gladiola, Cuyab, San Pedro City', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'Active', 0, 0, 0),
(13, 'bkpa-00000013', 'Leila', 'Montemayor', 'leila@gmail.com', '09493337935', '121-b Makati Homes II, Milkweed, Rizal, Makati', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'Active', 0, 0, 1),
(14, 'bkpa-00000014', 'Claire', 'Estoque', 'claire@gmail.com', '09150780562', '807, Mader, Post Proper Southside, Makati', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'Active', 0, 3, 0),
(15, 'bkpa-00000015', 'Elgin Barett', 'Sales', 'elgin@gmail.com', '09155430717', 'Pasig City', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'Active', 0, 0, 0),
(16, 'bkpa-00000016', 'Faith', 'Del Rosario', 'faith@gmail.com', '09345678912', '678, di ko alam, di ko din alam, San Pedro City', 'AAECAwQFBgcICQoLDA0ODwbYhT1TZ5mM8J/eztGx49g=', 'Active', 0, 0, 0),
(18, 'bkpa-00000018', 'Mark', 'Toralde', 'mark@gmail.com', '09876546329', 'Block 2 Lot 18, Molave, North Signal, Taguig', 'AAECAwQFBgcICQoLDA0OD3EwDrBfjIUlmMNGHSX1Jyo=', 'Active', 0, 0, 0),
(19, 'bkpa-00000019', 'Pole', 'Buendia', 'pole@gmail.com', '09102341463', '430, Acacia, Comembo, Makati', 'AAECAwQFBgcICQoLDA0OD4W33EfgzMvosTUrishriNE=', 'Active', 0, 0, 0),
(20, 'bkpa-00000020', 'Jenny', 'Bersamina', 'jenny@gmail.com', '09764268554', '477, Anahaw, Comembo, Makati', 'AAECAwQFBgcICQoLDA0ODySHIus92nlufcwzoZsBI5U=', 'Active', 0, 0, 0),
(21, 'bkpa-00000021', 'Aaron', 'Villamento', 'aaron@gmail.com', '09123681778', '03-G, E. Aguinaldo, West Rembo, Makati', 'AAECAwQFBgcICQoLDA0OD3Q5FHGVxsx6hnkAc2ka280=', 'Active', 0, 0, 0),
(22, 'bkpa-00000022', 'Jude Mikel', 'Rey', 'jude@gmail.com', '09957736812', '123, G.L. Jaena, West Rembo, Makati', 'AAECAwQFBgcICQoLDA0OD+Mo9/7oQ4gv6I8USvezRG0=', 'Active', 0, 0, 0),
(23, 'bkpa-00000023', 'John Howard', 'Agustin', 'john@gmail.com', '09492831172', '123, Goldilocks, Comembo, Makati', 'AAECAwQFBgcICQoLDA0OD9bWeb5lv7Qd5OgzVHGiJ94=', 'Active', 0, 0, 0),
(24, 'bkpa-00000024', 'Eufredo', 'Alto', 'eufredo@gmail.com', '09281235447', '123, Red Ribbon, Pembo, Makati', 'AAECAwQFBgcICQoLDA0ODyGur0h7lON8wDVhTnqSmA8=', 'Active', 0, 0, 0),
(25, 'bkpa-00000025', 'Adam Jay', 'Balona', 'adam@gmail.com', '09784441252', '234, blueberry, Rizal, Makati', 'AAECAwQFBgcICQoLDA0OD6vlhGlXgpqAYnGM8pI01F4=', 'Active', 0, 0, 1),
(26, 'bkpa-00000026', 'Jao Nicholas', 'Benedicto', 'jao@gmail.com', '09125348765', '210-b Makati Homes II, Milkweed, Rizal, Makati', 'AAECAwQFBgcICQoLDA0ODxjyozq1Rom7r9d19sXp7eo=', 'Active', 0, 0, 0),
(27, 'bkpa-00000027', 'Reigne Rhexell', 'Cabral', 'reign@gmail.com', '09786431121', 'Blk 10 Lot 1, Gladiola, Rizal, Makati', 'AAECAwQFBgcICQoLDA0OD1AcTkVu845NDyB3+oAAX6g=', 'Active', 0, 0, 0),
(28, 'bkpa-00000028', 'Nicole', 'Candelaria', 'nicole@gmail.com', '09565771234', '472, Escuela, Guadalupe Nuevo, Makati', 'AAECAwQFBgcICQoLDA0OD5diVA5s7QAtqi8zMXa8BQs=', 'Inactive', 0, 0, 1),
(29, 'bkpa-00000029', 'Von Andrew', 'Castillo', 'von@gmail.com', '09568883456', '125, Orchid Avenue, Guadalupe Nuevo, Makati', 'AAECAwQFBgcICQoLDA0OD3D5HO2qAnuMuuqXbguBVQE=', 'Active', 0, 0, 0),
(30, 'bkpa-00000030', 'James', 'Castro', 'james@gmail.com', '09325565789', 'Blk 7 Lot 4, Sapphire, Pio Del Pilar, Makati', 'AAECAwQFBgcICQoLDA0OD5l81g4OL1zMV8xJpIUPUvc=', 'Active', 0, 0, 0),
(31, 'bkpa-00000031', 'Jeremiah', 'Dela Vega', 'jeremiah@gmail.com', '09673234556', '256, Emerald, San Lorenzo, Makati', 'AAECAwQFBgcICQoLDA0OD3gbyq9K7VOuESWQPRRAJIk=', 'Active', 0, 0, 0),
(32, 'bkpa-00000032', 'Christian', 'Delos Santos', 'christian@gmail.com', '09231239762', '256, Anahaw, Pembo, Makati', 'AAECAwQFBgcICQoLDA0ODwoipCeocQkv5x6Iqpt0ZgU=', 'Active', 0, 0, 0),
(33, 'bkpa-00000033', 'Llenard', 'Diama', 'llenard@gmail.com', '07899237896', '546, hotdog, East Rembo, Makati', 'AAECAwQFBgcICQoLDA0ODzFwq9z94k0v3IakUe2oQIQ=', 'Active', 0, 0, 0),
(34, 'bkpa-00000034', 'Karl Manuel', 'Diata', 'karl@gmail.com', '09378961253', '786, Dela Rosa, Poblacion, Makati', 'AAECAwQFBgcICQoLDA0ODxgAs68ku6bxOBkQxg4Hvd0=', 'Active', 0, 0, 0),
(35, 'bkpa-00000035', 'Jerine Carl', 'Diaz', 'jerine@gmail.com', '09568881325', '123, Sampaguita, Cembo, Makati', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'Active', 0, 0, 0),
(36, 'bkpa-00000036', 'Mica', 'Fuentes', 'mica@gmail.com', '09231679876', 'Blk 66 Lot 10, Acacia, Cembo, Makati', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'Active', 0, 0, 0),
(37, 'bkpa-00000037', 'Elcarlwen', 'Guirhem', 'elcarlwen@gmail.com', '09678537421', '977, Camia, Cembo, Makati', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'Active', 0, 0, 1);

--
-- Triggers `patron`
--
DELIMITER $$
CREATE TRIGGER `generate_formatted_id` BEFORE INSERT ON `patron` FOR EACH ROW BEGIN
    SET @next_id = (SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'patron');
    SET NEW.formatted_id = CONCAT('bkpa-', LPAD(@next_id, 8, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `reserved_book`
--

CREATE TABLE `reserved_book` (
  `reservation_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `reservation_date` date NOT NULL,
  `reservation_status` varchar(10) NOT NULL,
  `patron_id` varchar(13) NOT NULL,
  `reservation_time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reserved_book`
--

INSERT INTO `reserved_book` (`reservation_id`, `book_id`, `reservation_date`, `reservation_status`, `patron_id`, `reservation_time`) VALUES
(1, 11, '2023-08-14', 'in que', 'bkpa-00000014', '22:10:52'),
(2, 18, '2023-08-14', 'in que', 'bkpa-00000014', '22:21:15'),
(3, 33, '2023-08-14', 'in que', 'bkpa-00000014', '22:21:28');

-- --------------------------------------------------------

--
-- Table structure for table `setting`
--

CREATE TABLE `setting` (
  `setting_id` int(11) NOT NULL,
  `borrow_limit` int(11) NOT NULL,
  `reserve_limit` int(11) NOT NULL,
  `borrow_duration` int(11) NOT NULL,
  `penalty_limit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `setting`
--

INSERT INTO `setting` (`setting_id`, `borrow_limit`, `reserve_limit`, `borrow_duration`, `penalty_limit`) VALUES
(1, 10, 9, 1, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `borrowed_book`
--
ALTER TABLE `borrowed_book`
  ADD PRIMARY KEY (`borrow_id`),
  ADD KEY `fk_book` (`book_id`),
  ADD KEY `fk_borrowed_book_patron` (`patron_id`);

--
-- Indexes for table `patron`
--
ALTER TABLE `patron`
  ADD PRIMARY KEY (`patron_id`),
  ADD KEY `idx_formatted_id` (`formatted_id`);

--
-- Indexes for table `reserved_book`
--
ALTER TABLE `reserved_book`
  ADD PRIMARY KEY (`reservation_id`),
  ADD KEY `fk_book_2` (`book_id`),
  ADD KEY `fk_reserved_book_patron` (`patron_id`);

--
-- Indexes for table `setting`
--
ALTER TABLE `setting`
  ADD PRIMARY KEY (`setting_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=110;

--
-- AUTO_INCREMENT for table `borrowed_book`
--
ALTER TABLE `borrowed_book`
  MODIFY `borrow_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `patron`
--
ALTER TABLE `patron`
  MODIFY `patron_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `reserved_book`
--
ALTER TABLE `reserved_book`
  MODIFY `reservation_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `setting`
--
ALTER TABLE `setting`
  MODIFY `setting_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `borrowed_book`
--
ALTER TABLE `borrowed_book`
  ADD CONSTRAINT `fk_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`),
  ADD CONSTRAINT `fk_borrowed_book_patron` FOREIGN KEY (`patron_id`) REFERENCES `patron` (`formatted_id`);

--
-- Constraints for table `reserved_book`
--
ALTER TABLE `reserved_book`
  ADD CONSTRAINT `fk_book_2` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`),
  ADD CONSTRAINT `fk_reserved_book_patron` FOREIGN KEY (`patron_id`) REFERENCES `patron` (`formatted_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
