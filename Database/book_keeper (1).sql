-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 05, 2023 at 01:17 PM
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
  `admin_id` varchar(9) NOT NULL,
  `admin_fname` varchar(15) NOT NULL,
  `admin_lname` varchar(15) NOT NULL,
  `admin_email` varchar(50) NOT NULL,
  `admin_position` varchar(15) NOT NULL,
  `admin_password` varchar(50) NOT NULL,
  `admin_status` varchar(20) NOT NULL,
  `admin_contact` varchar(11) NOT NULL,
  `admin_address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_fname`, `admin_lname`, `admin_email`, `admin_position`, `admin_password`, `admin_status`, `admin_contact`, `admin_address`) VALUES
('1', 'Admin', 'Admin', 'Admin', 'Admin', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'active', '09876532678', 'UNIVERSITY OF MAKATI'),
('fgcSNROn', 'Jude', 'Rey', 'jude@gmail.com', 'Employee', 'AAECAwQFBgcICQoLDA0OD6qreBVEBxvztv2IlbZ4ZaI=', 'active', '09876543456', 'Taguig City'),
('Rv0oC86N', 'Mark', 'Toralde', 'mark@gmail.com', 'Employee', 'AAECAwQFBgcICQoLDA0OD1klV0trngCbhAOKCO5gUxc=', 'active', '09876567898', 'Taguig City');

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `author_id` int(11) NOT NULL,
  `author_name` varchar(50) NOT NULL,
  `author_book` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `location_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_id`, `book_title`, `author_name`, `genre_name`, `book_publication_date`, `book_publisher`, `book_status`, `location_id`) VALUES
(4, 'Harry Potter and the Chamber of Secrets', 'J.K. Rowling', 'Fantasy', '1998-07-02', 'Bloomsbury Publishing', 'Available', 2),
(5, 'Harry Potter and the Prisoner of Azkaban', 'J.K. Rowling', 'Fantasy', '1999-07-08', 'Bloomsbury Publishing', 'Available', 3),
(6, 'Harry Potter and the Goblet of Fire', 'J.K. Rowling', 'Fantasy', '2000-07-08', 'Bloomsbury Publishing', 'Available', 7),
(7, 'To Kill a Mockingbird', 'Harper Lee', 'Classic', '1960-07-11', 'J. B. Lippincott & Co.', 'Available', 3),
(8, 'The Great Gatsby', 'F. Scott Fitzgerald', 'Classic', '1925-04-10', 'Charles Scribner\'s Sons', 'Available', 2),
(9, 'Pride and Prejudice', 'Jane Austen', 'Classic', '1813-01-28', 'T. Egerton, Whitehall', 'Available', 3),
(10, 'To the Lighthouse', 'Virginia Woolf', 'Fiction', '1927-05-05', 'Hogarth Press', 'Available', 4),
(11, 'Brave New World', 'Aldous Huxley', 'Science Fiction', '1932-10-27', 'Chatto & Windus', 'Available', 3),
(12, 'The Catcher in the Rye', 'J.D. Salinger', 'Fiction', '1951-07-16', 'Little, Brown and Company', 'Available', 2),
(13, 'Moby-Dick', 'Herman Melville', 'Fiction', '1851-10-18', 'Harper & Brothers', 'Available', 1),
(14, 'The Lord of the Rings', 'J.R.R. Tolkien', 'Fantasy', '1954-07-29', 'Allen & Unwin', 'Available', 3),
(15, 'To the Lighthouse', 'Virginia Woolf', 'Fiction', '1927-05-05', 'Hogarth Press', 'Available', 4),
(16, 'The Picture of Dorian Gray', 'Oscar Wilde', 'Fiction', '1890-07-01', 'Ward, Lock and Company', 'Available', 2),
(17, 'The Odyssey', 'Homer', 'Epic Poetry', '1890-07-05', 'Unknown', 'Available', 1),
(18, 'Frankenstein', 'Mary Shelley', 'Gothic Fiction', '1818-01-01', 'Lackington, Hughes, Harding, Mavor & Jones', 'Available', 3),
(19, 'Don Quixote', 'Miguel de Cervantes', 'Novel', '1605-01-16', 'Francisco de Robles', 'Available', 4),
(20, 'The Hobbit', 'J.R.R. Tolkien', 'Fantasy', '1937-09-21', 'George Allen & Unwin', 'Available', 2),
(21, '1984', 'George Orwell', 'Dystopian', '1949-06-08', 'Secker & Warburg', 'Available', 3),
(22, 'The Chronicles of Narnia', 'C.S. Lewis', 'Fantasy', '1950-10-16', 'Geoffrey Bles', 'Available', 1),
(23, 'The Alchemist', 'Paulo Coelho', 'Fiction', '1988-01-01', 'HarperCollins', 'Available', 3),
(24, 'The Da Vinci Code', 'Dan Brown', 'Thriller', '2003-03-18', 'Doubleday', 'Available', 4),
(25, 'The Hunger Games', 'Suzanne Collins', 'Young Adult', '2008-09-14', 'Scholastic Corporation', 'Available', 2),
(26, 'The Girl on the Train', 'Paula Hawkins', 'Mystery', '2015-01-15', 'Transworld Publishers', 'Available', 1),
(27, 'Gone Girl', 'Gillian Flynn', 'Thriller', '2012-06-05', 'Crown Publishing Group', 'Available', 3),
(28, 'The Fault in Our Stars', 'John Green', 'Young Adult', '2012-01-10', 'Dutton Books', 'Available', 4),
(29, 'The Help', 'Kathryn Stockett', 'Historical Fiction', '2009-02-10', 'Penguin Group', 'Available', 2),
(30, 'The Shining', 'Stephen King', 'Horror', '1977-01-28', 'Doubleday', 'Available', 13),
(31, 'IT', 'Stephen King', 'Horror', '1986-09-15', 'Viking Press', 'Available', 12),
(32, 'Test 4', 'Arthur', 'Classic', '2020-05-05', 'the publisher', 'Available', 15),
(33, 'How to survive Second Sem', 'Leila Montemayor', 'Survival', '2023-05-25', 'Umak4', 'Available', 12),
(34, 'Test 3', 'claire', 'Classic', '1998-07-02', 'ewan', 'Available', 16),
(35, 'Snells', 'Efraem', 'Science', '2023-05-23', 'Efraem', 'Available', 15),
(36, 'Test 6', 'Elgin', 'Fantasy', '2023-05-06', 'kahit sino', 'Available', 9),
(37, 'Test 9', 'Book Author', 'Classic', '1949-06-08', 'Arthur', 'Checked out', 13),
(38, 'Test 10', 'Arthur', 'Dystopian', '2023-01-01', 'Publisher', 'Available', 11),
(39, 'Test 11', 'Faith', 'Classic', '2023-05-05', 'kahit sino', 'Available', 4),
(40, 'Test 12', 'Arthur', 'Survival', '2023-05-25', 'jan lang', 'Available', 3),
(41, 'Test 13', 'Test 13', 'Fiction', '2023-04-23', 'kahit sino', 'Available', 14);

-- --------------------------------------------------------

--
-- Table structure for table `borrowed_book`
--

CREATE TABLE `borrowed_book` (
  `borrow_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `patron_id` varchar(9) NOT NULL,
  `borrowed_date` date NOT NULL,
  `borrowed_due_date` date NOT NULL,
  `borrow_status` varchar(10) NOT NULL,
  `returned_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `borrowed_book`
--

INSERT INTO `borrowed_book` (`borrow_id`, `book_id`, `patron_id`, `borrowed_date`, `borrowed_due_date`, `borrow_status`, `returned_date`) VALUES
(17, 5, 'j9u4voQL', '2023-06-04', '2023-06-25', 'returned', '2023-06-04'),
(18, 37, 'sDnSithP', '2023-06-04', '2023-06-25', 'out', NULL),
(19, 38, '1w3zbctC', '2023-06-05', '2023-06-26', 'returned', '2023-06-05'),
(20, 21, 'sDnSithP', '2023-06-05', '2023-06-26', 'returned', '2023-06-05'),
(21, 21, 'sDnSithP', '2023-06-05', '2023-06-26', 'out', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE `genre` (
  `genre_id` int(11) NOT NULL,
  `genre_name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `location_id` int(11) NOT NULL,
  `shelf_number` int(100) NOT NULL,
  `aisle_number` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`location_id`, `shelf_number`, `aisle_number`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 4, 1),
(5, 5, 1),
(6, 6, 1),
(7, 1, 2),
(8, 2, 2),
(9, 3, 2),
(10, 4, 2),
(11, 5, 2),
(12, 6, 2),
(13, 1, 3),
(14, 2, 3),
(15, 3, 3),
(16, 4, 3),
(17, 5, 3),
(18, 6, 3);

-- --------------------------------------------------------

--
-- Table structure for table `patron`
--

CREATE TABLE `patron` (
  `patron_id` varchar(9) NOT NULL,
  `patron_fname` varchar(15) NOT NULL,
  `patron_lname` varchar(15) NOT NULL,
  `patron_email` varchar(50) DEFAULT NULL,
  `patron_contact` varchar(11) DEFAULT NULL,
  `patron_address` varchar(50) NOT NULL,
  `patron_password` varchar(300) NOT NULL,
  `patron_status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patron`
--

INSERT INTO `patron` (`patron_id`, `patron_fname`, `patron_lname`, `patron_email`, `patron_contact`, `patron_address`, `patron_password`, `patron_status`) VALUES
('1w3zbctC', 'Aaron', 'Villamento', 'aaron@gmail.com', '09999887654', 'Taguig City', 'AAECAwQFBgcICQoLDA0ODwL88q6vUXyiwDkpUwQD6tE=', 'active'),
('G82NZx3v', 'Elgin ', 'Sales', 'elgin@gmail.com', '09999900009', 'sa tabi lang', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'active'),
('j9u4voQL', 'Arthur', 'Artugue', 'arthur@gmail.com', '09159999000', 'San Pedro Laguna', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'active'),
('OGVcK5xd', 'Claire ', 'Estoque', 'claire@gmail.com', '09999999999', 'Makati City', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'active'),
('prKdMYMb', 'Faith Ysabell', 'Del Rosario', 'faith@gmail.com', '09999999999', 'San Pedro Laguna', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'active'),
('sDnSithP', 'Leila', 'Montemayor', 'leila@gmail.com', '09999999999', 'Makati City', 'AAECAwQFBgcICQoLDA0ODylluTeod5rYdTb8UC8fEg0=', 'active'),
('UIUvJvKu', 'Pole Andrei', 'Buendia', 'pole@gmail.com', '09999923222', 'Taguig City', 'AAECAwQFBgcICQoLDA0OD1AGvjAvG9IZkPDr5ShDv6I=', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `reserved_book`
--

CREATE TABLE `reserved_book` (
  `reservation_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `patron_id` varchar(9) NOT NULL,
  `reservation_date` date NOT NULL,
  `reservation_status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reserved_book`
--

INSERT INTO `reserved_book` (`reservation_id`, `book_id`, `patron_id`, `reservation_date`, `reservation_status`) VALUES
(9, 21, 'sDnSithP', '2023-06-05', 'done'),
(10, 21, 'G82NZx3v', '2023-06-05', 'in que'),
(11, 21, 'OGVcK5xd', '2023-06-05', 'in que'),
(12, 21, 'j9u4voQL', '2023-06-05', 'in que');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`author_id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`book_id`),
  ADD KEY `fk_location` (`location_id`);

--
-- Indexes for table `borrowed_book`
--
ALTER TABLE `borrowed_book`
  ADD PRIMARY KEY (`borrow_id`),
  ADD KEY `fk_book` (`book_id`),
  ADD KEY `fk_patron` (`patron_id`);

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`genre_id`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`location_id`);

--
-- Indexes for table `patron`
--
ALTER TABLE `patron`
  ADD PRIMARY KEY (`patron_id`);

--
-- Indexes for table `reserved_book`
--
ALTER TABLE `reserved_book`
  ADD PRIMARY KEY (`reservation_id`),
  ADD KEY `fk_book_2` (`book_id`),
  ADD KEY `fk_patron_2` (`patron_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `author_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `borrowed_book`
--
ALTER TABLE `borrowed_book`
  MODIFY `borrow_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `genre`
--
ALTER TABLE `genre`
  MODIFY `genre_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `location_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `reserved_book`
--
ALTER TABLE `reserved_book`
  MODIFY `reservation_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `fk_location` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`);

--
-- Constraints for table `borrowed_book`
--
ALTER TABLE `borrowed_book`
  ADD CONSTRAINT `fk_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`),
  ADD CONSTRAINT `fk_patron` FOREIGN KEY (`patron_id`) REFERENCES `patron` (`patron_id`);

--
-- Constraints for table `reserved_book`
--
ALTER TABLE `reserved_book`
  ADD CONSTRAINT `fk_book_2` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`),
  ADD CONSTRAINT `fk_patron_2` FOREIGN KEY (`patron_id`) REFERENCES `patron` (`patron_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
