-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 06, 2023 at 06:52 AM
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
  `admin_password` varchar(50) NOT NULL,
  `admin_status` varchar(20) NOT NULL,
  `admin_contact` varchar(11) NOT NULL,
  `admin_address` varchar(50) NOT NULL,
  `admin_formatted_id` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_fname`, `admin_lname`, `admin_email`, `admin_position`, `admin_password`, `admin_status`, `admin_contact`, `admin_address`, `admin_formatted_id`) VALUES
(11, 'Arthur', 'Artugue', 'arthur@gmail.com', 'Admin', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'Active', '09150980561', 'San Pedro Laguna', 'bkad-00000011'),
(16, 'Leila', 'Montemayor', 'leila@gmail.com', 'Admin', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'Active', '09150980561', 'Barangay Rizal Taguig City', 'bkad-00000016'),
(17, 'Claire', 'Estoque', 'claire@gmail.com', 'Admin', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'Active', '09150780562', 'Barangay Rizal Taguig City', 'bkad-00000017'),
(18, 'Elgin', 'Sales', 'elgin@gmail.com', 'Admin', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'Active', '09150780562', 'Pasig City', 'bkad-00000018');

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
(4, 'Harry Potter and the Chamber of Secrets', 'J.K. Rowling', 'Fantasy', '1998-07-02', 'Bloomsbury Publishing', 'Available', '9780747532743', 0, 0),
(5, 'Harry Potter and the Prisoner of Azkaban', 'J.K. Rowling', 'Fantasy', '1999-07-08', 'Bloomsbury Publishing', 'Available', '9780747538493', 0, 0),
(6, 'Harry Potter and the Goblet of Fire', 'J.K. Rowling', 'Fantasy', '2000-07-08', 'Bloomsbury Publishing', 'Unavailable', '9780747542155', 0, 0),
(7, 'To Kill a Mockingbird', 'Harper Lee', 'Classic', '1960-07-11', 'J. B. Lippincott & Co.', 'Available', '9780061120084', 0, 0),
(8, 'The Great Gatsby', 'F. Scott Fitzgerald', 'Classic', '1925-04-10', 'Charles Scribner\'s Sons', 'Available', '9780743273565', 0, 0),
(9, 'Pride and Prejudice', 'Jane Austen', 'Classic', '1813-01-28', 'T. Egerton, Whitehall', 'Available', '9780141439518', 0, 0),
(10, 'To the Lighthouse', 'Virginia Woolf', 'Fiction', '1927-05-05', 'Hogarth Press', 'Available', '9780156030471', 0, 0),
(11, 'Brave New World', 'Aldous Huxley', 'Science Fiction', '1932-10-27', 'Chatto & Windus', 'Available', '9780060929879', 0, 0),
(12, 'The Catcher in the Rye', 'J.D. Salinger', 'Fiction', '1951-07-16', 'Little, Brown and Company', 'Available', '9780316769174', 0, 0),
(13, 'Moby-Dick', 'Herman Melville', 'Fiction', '1851-10-18', 'Harper & Brothers', 'Available', '9780060920081', 0, 0),
(14, 'The Lord of the Rings', 'J.R.R. Tolkien', 'Fantasy', '1954-07-29', 'Allen & Unwin', 'Available', '9780618640157', 0, 0),
(15, 'To the Lighthouse', 'Virginia Woolf', 'Fiction', '1927-05-05', 'Hogarth Press', 'Available', '9780156030471', 0, 0),
(16, 'The Picture of Dorian Gray', 'Oscar Wilde', 'Fiction', '1890-07-01', 'Ward, Lock and Company', 'Available', '9780198189698', 0, 0),
(17, 'The Odyssey', 'Homer', 'Epic Poetry', '1890-07-05', 'Unknown', 'Available', '9780199536788', 0, 0),
(18, 'Frankenstein', 'Mary Shelley', 'Gothic Fiction', '1818-01-01', 'Lackington, Hughes, Harding, Mavor & Jones', 'Available', '9780199535774', 0, 0),
(19, 'Don Quixote', 'Miguel de Cervantes', 'Novel', '1605-01-16', 'Francisco de Robles', 'Available', '9788420603699', 0, 0),
(20, 'The Hobbit', 'J.R.R. Tolkien', 'Fantasy', '1937-09-21', 'George Allen & Unwin', 'Available', '9780547928227', 0, 0),
(21, '1984', 'George Orwell', 'Dystopian', '1949-06-08', 'Secker & Warburg', 'Available', '9780452284234', 0, 0),
(22, 'The Chronicles of Narnia', 'C.S. Lewis', 'Fantasy', '1950-10-16', 'Geoffrey Bles', 'Available', '9780007117307', 0, 0),
(23, 'The Alchemist', 'Paulo Coelho', 'Fiction', '1988-01-01', 'HarperCollins', 'Available', '9780061122415', 0, 0),
(24, 'The Da Vinci Code', 'Dan Brown', 'Thriller', '2003-03-18', 'Doubleday', 'Available', '9780385504201', 0, 0),
(25, 'The Hunger Games', 'Suzanne Collins', 'Young Adult', '2008-09-14', 'Scholastic Corporation', 'Available', '9780439023528', 0, 0),
(26, 'The Girl on the Train', 'Paula Hawkins', 'Mystery', '2015-01-15', 'Transworld Publishers', 'Available', '9781594634024', 0, 0),
(27, 'Gone Girl', 'Gillian Flynn', 'Thriller', '2012-06-05', 'Crown Publishing Group', 'Available', '9780307588371', 0, 0),
(28, 'The Fault in Our Stars', 'John Green', 'Young Adult', '2012-01-10', 'Dutton Books', 'Available', '9780525426004', 0, 0),
(29, 'The Help', 'Kathryn Stockett', 'Historical Fiction', '2009-02-10', 'Penguin Group', 'Available', '9780399155345', 0, 0),
(30, 'The Shining', 'Stephen King', 'Horror', '1977-01-28', 'Doubleday', 'Available', '9780385121675', 0, 0),
(31, 'IT', 'Stephen King', 'Horror', '1986-09-15', 'Viking Press', 'Available', '9780670813025', 0, 0),
(32, 'Test 4', 'Arthur', 'Classic', '2020-05-05', 'the publisher', 'Available', '9780000000001', 0, 0),
(33, 'How to survive Second Sem', 'Leila Montemayor', 'Survival', '2023-05-25', 'Umak4', 'Available', '9780000000002', 0, 0),
(34, 'Test 3', 'claire', 'Classic', '1998-07-02', 'ewan', 'Available', '9780000000003', 0, 0),
(35, 'Snells', 'Efraem', 'Science', '2023-05-23', 'Efraem', 'Available', '9780000000004', 0, 0),
(36, 'Test 6', 'Elgin', 'Fantasy', '2023-05-06', 'kahit sino', 'Available', '9780000000005', 0, 0),
(37, 'Test 9', 'Book Author', 'Classic', '1949-06-08', 'Arthur', 'Available', '9780000000006', 0, 0),
(38, 'Test 10', 'Arthur', 'Dystopian', '2023-01-01', 'Publisher', 'Available', '9780000000007', 0, 0),
(39, 'Test 11', 'Faith', 'Classic', '2023-05-05', 'kahit sino', 'Available', '9780000000008', 0, 0),
(40, 'Test 12', 'Arthur', 'Survival', '2023-05-25', 'jan lang', 'Available', '9780000000009', 0, 0),
(41, 'Test 13', 'Test 13', 'Fiction', '2023-04-23', 'kahit sino', 'Available', '9780000000010', 0, 0),
(42, 'test 14', 'Aaron ', 'Classic', '2003-05-05', 'Rekto', 'Available', '9780000000011', 0, 0);

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
  `borrow_time` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `penalty` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patron`
--

INSERT INTO `patron` (`patron_id`, `formatted_id`, `patron_fname`, `patron_lname`, `patron_email`, `patron_contact`, `patron_address`, `patron_password`, `patron_status`, `penalty`) VALUES
(12, 'bkpa-00000012', 'Arthur', 'Artugue', 'arthur@gmail.com', '09953653123', 'Blk 8 Lot 6a, Gladiola St., Cuyab, San Pedro', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'active', 0),
(13, 'bkpa-00000013', 'Leila', 'Montemayor', 'leila@gmail.com', '09150980561', 'Rizal Taguig City', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'active', 0),
(14, 'bkpa-00000014', 'Claire', 'Estoque', 'claire@gmail.com', '09150780562', 'Barangay Rizal Taguig City', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'active', 0),
(15, 'bkpa-00000015', 'Elgin', 'Sales', 'elgin@gmail.com', '09150780562', 'Pasig City', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'active', 0);

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
(23, 6, '2023-08-04', 'in que', 'bkpa-00000012', '23:33:42'),
(24, 6, '2023-08-05', 'in que', 'bkpa-00000013', '00:26:24'),
(25, 6, '2023-08-05', 'in que', 'bkpa-00000014', '23:53:29');

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
(1, 8, 8, 21, 3);

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
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `borrowed_book`
--
ALTER TABLE `borrowed_book`
  MODIFY `borrow_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `patron`
--
ALTER TABLE `patron`
  MODIFY `patron_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `reserved_book`
--
ALTER TABLE `reserved_book`
  MODIFY `reservation_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

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
