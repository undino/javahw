-- MariaDB dump 10.17  Distrib 10.4.8-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: cinemadb
-- ------------------------------------------------------
-- Server version	10.4.8-MariaDB
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
--
-- Table structure for table `actors`
--
drop database if exists cinemadb;
create database if not exists cinemadb;
use cinemadb;
DROP TABLE IF EXISTS `actors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actors` (
  `ActorID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(20) NOT NULL CHECK (`FirstName` <> ''),
  `LastName` varchar(20) NOT NULL CHECK (`FirstName` <> ''),
  `Nationality` varbinary(20) NOT NULL CHECK (`Nationality` <> ''),
  `Birth` date NOT NULL,
  PRIMARY KEY (`ActorID`)
) ENGINE = InnoDB AUTO_INCREMENT = 6 DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `actors`
--
LOCK TABLES `actors` WRITE;
/*!40000 ALTER TABLE `actors` DISABLE KEYS */;
INSERT INTO `actors`
VALUES
  (1, 'Брэд', 'Питт', 'Американец', '1963-12-18'),(2, 'Брюс', 'Уиллис', 'Американец', '1955-03-19'),(3, 'Уилл', 'Смит', 'Американец', '1968-09-25'),(4, 'Том', 'Харди', 'Англичанин', '1963-12-18'),(5, 'Орди', 'Тоту', 'Французка', '1976-08-19');
  /*!40000 ALTER TABLE `actors` ENABLE KEYS */;
UNLOCK TABLES;
--
  -- Table structure for table `directors`
  --
  DROP TABLE IF EXISTS `directors`;
  /*!40101 SET @saved_cs_client     = @@character_set_client */;
  /*!40101 SET character_set_client = utf8 */;
CREATE TABLE `directors` (
    `DirectorID` int(11) NOT NULL AUTO_INCREMENT,
    `FirstName` varchar(20) NOT NULL CHECK (`FirstName` <> ''),
    `LastName` varchar(20) NOT NULL CHECK (`FirstName` <> ''),
    `Nationality` varbinary(20) NOT NULL CHECK (`Nationality` <> ''),
    `Birth` date NOT NULL,
    PRIMARY KEY (`DirectorID`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 9 DEFAULT CHARSET = utf8mb4;
  /*!40101 SET character_set_client = @saved_cs_client */;
--
  -- Dumping data for table `directors`
  --
  LOCK TABLES `directors` WRITE;
  /*!40000 ALTER TABLE `directors` DISABLE KEYS */;
INSERT INTO `directors`
VALUES
  (
    1,
    'Джерри',
    'Брукхаймер',
    'Американец',
    '1943-09-21'
  ),(2, 'Джордж', 'Лукач', 'Американец', '1944-05-14'),(
    3,
    'Аарон',
    'Спеллинг',
    'Американец',
    '1923-04-22'
  ),(
    4,
    'Чарльз',
    'Скорсезе',
    'Американец',
    '1942-11-17'
  ),(5, 'Тим', 'Бёртон', 'Американец', '1958-08-25'),(
    6,
    'Тимур',
    'Бекмамбетов',
    'Россиянин',
    '1961-06-25'
  ),(
    7,
    'Сергей',
    'Сельянов',
    'Россиянин',
    '1955-08-21'
  ),(8, 'Ридли', 'Скотт', 'Британец', '1937-11-30');
  /*!40000 ALTER TABLE `directors` ENABLE KEYS */;
UNLOCK TABLES;
--
  -- Table structure for table `genres`
  --
  DROP TABLE IF EXISTS `genres`;
  /*!40101 SET @saved_cs_client     = @@character_set_client */;
  /*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genres` (
    `GenreID` int(11) NOT NULL AUTO_INCREMENT,
    `GenreName` varchar(100) NOT NULL CHECK (`GenreName` <> ''),
    PRIMARY KEY (`GenreID`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 6 DEFAULT CHARSET = utf8mb4;
  /*!40101 SET character_set_client = @saved_cs_client */;
--
  -- Dumping data for table `genres`
  --
  LOCK TABLES `genres` WRITE;
  /*!40000 ALTER TABLE `genres` DISABLE KEYS */;
INSERT INTO `genres`
VALUES
  (1, 'Боевик'),(2, 'Вестерн'),(3, 'Драмма'),(4, 'Комедия'),(5, 'Детектив');
  /*!40000 ALTER TABLE `genres` ENABLE KEYS */;
UNLOCK TABLES;
--
  -- Table structure for table `movieactor`
  --
  DROP TABLE IF EXISTS `movieactor`;
  /*!40101 SET @saved_cs_client     = @@character_set_client */;
  /*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movieactor` (
    `MovieID` int(11) NOT NULL,
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `ActorID` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_MA_Movies` (`MovieID`),
    KEY `fk_MA_Actors` (`ActorID`),
    CONSTRAINT `fk_MA_Actors` FOREIGN KEY (`ActorID`) REFERENCES `actors` (`ActorID`),
    CONSTRAINT `fk_MA_Movies` FOREIGN KEY (`MovieID`) REFERENCES `movies` (`MovieID`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 31 DEFAULT CHARSET = utf8mb4;
  /*!40101 SET character_set_client = @saved_cs_client */;
--
  -- Dumping data for table `movieactor`
  --
  LOCK TABLES `movieactor` WRITE;
  /*!40000 ALTER TABLE `movieactor` DISABLE KEYS */;
INSERT INTO `movieactor`
VALUES
  (3, 1, 4),(4, 2, 4),(4, 3, 5),(5, 4, 2),(5, 5, 3),(5, 6, 5),(6, 7, 1),(6, 8, 3),(6, 9, 5),(6, 10, 4),(7, 11, 1),(7, 12, 3),(7, 13, 5),(7, 14, 2),(8, 15, 1),(8, 16, 3),(9, 17, 1),(9, 18, 3),(9, 19, 5),(9, 20, 2),(9, 21, 4),(1, 22, 5),(1, 23, 2),(1, 24, 4),(2, 25, 1),(2, 26, 5),(2, 27, 2),(2, 28, 4),(3, 29, 4),(4, 30, 1);
  /*!40000 ALTER TABLE `movieactor` ENABLE KEYS */;
UNLOCK TABLES;
--
  -- Table structure for table `moviegenres`
  --
  DROP TABLE IF EXISTS `moviegenres`;
  /*!40101 SET @saved_cs_client     = @@character_set_client */;
  /*!40101 SET character_set_client = utf8 */;
CREATE TABLE `moviegenres` (
    `MovieID` int(11) NOT NULL,
    `GenreID` int(11) NOT NULL,
    `id` int(11) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`),
    KEY `fk_MG_Genres` (`GenreID`),
    KEY `fk_MG_Movies` (`MovieID`),
    CONSTRAINT `fk_MG_Genres` FOREIGN KEY (`GenreID`) REFERENCES `genres` (`GenreID`),
    CONSTRAINT `fk_MG_Movies` FOREIGN KEY (`MovieID`) REFERENCES `movies` (`MovieID`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 11 DEFAULT CHARSET = utf8mb4;
  /*!40101 SET character_set_client = @saved_cs_client */;
--
  -- Dumping data for table `moviegenres`
  --
  LOCK TABLES `moviegenres` WRITE;
  /*!40000 ALTER TABLE `moviegenres` DISABLE KEYS */;
INSERT INTO `moviegenres`
VALUES
  (4, 3, 1),(5, 5, 3),(6, 3, 4),(7, 3, 5),(8, 3, 6),(9, 5, 7),(1, 1, 8),(2, 2, 9),(3, 4, 10);
  /*!40000 ALTER TABLE `moviegenres` ENABLE KEYS */;
UNLOCK TABLES;
--
  -- Table structure for table `movies`
  --
  DROP TABLE IF EXISTS `movies`;
  /*!40101 SET @saved_cs_client     = @@character_set_client */;
  /*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movies` (
    `MovieID` int(11) NOT NULL AUTO_INCREMENT,
    `DirectorID` int(11) NOT NULL CHECK (`DirectorID` <> ''),
    `Title` varchar(100) NOT NULL CHECK (`Title` <> ''),
    `ReleaseYear` int(11) NOT NULL CHECK (`ReleaseYear` <> ''),
    `Rating` int(11) NOT NULL CHECK (
      `Rating` >= 0
      and `Rating` <= 5
    ),
    `Plot` varchar(10000) NOT NULL CHECK (`Plot` <> ''),
    `MovieLength` time NOT NULL,
    PRIMARY KEY (`MovieID`),
    KEY `fk_Directors_Movies` (`DirectorID`),
    CONSTRAINT `fk_Directors_Movies` FOREIGN KEY (`DirectorID`) REFERENCES `directors` (`DirectorID`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 13 DEFAULT CHARSET = utf8mb4;
  /*!40101 SET character_set_client = @saved_cs_client */;
--
  -- Dumping data for table `movies`
  --
  LOCK TABLES `movies` WRITE;
  /*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies`
VALUES
  (
    1,
    1,
    'Одинокие рейнджеры',
    2013,
    4,
    'История блюстителя закона Джона Рейда, который с помощью индейца Тонто стал легендарным мстителем в маске',
    '02:09:23'
  ),(
    2,
    6,
    'Гермин',
    2019,
    5,
    'Генри Броган, первоклассный киллер, становится мишенью таинственного оперативника',
    '01:57:06'
  ),(
    3,
    2,
    'Такер',
    1988,
    4,
    'американский биографический фильм режиссёра Фрэнсиса Форда Копполы',
    '02:10:46'
  ),(
    4,
    7,
    'Ирландец',
    2019,
    5,
    'американский драматический фильм режиссёра Мартина Скорсезе по сценарию Стивена Заилляна',
    '03:30:20'
  ),(
    5,
    4,
    'Молчание',
    2016,
    4,
    'В XVII веке два священника-иезуита подвергаются насилию и преследованиям во время странствия по Японии',
    '02:41:12'
  ),(
    6,
    3,
    'Прометей',
    2012,
    5,
    'В поисках сакрального знания группа ученых отправляется в самые темные и неизведанные чертоги вселенной',
    '02:04:09'
  ),(
    7,
    3,
    'Груз 200',
    2007,
    5,
    '1984 год, советская глубинка. Маньяк похищает дочку секретаря райкома, чтобы на ней жениться.',
    '01:40:58'
  ),(
    8,
    8,
    'Дом странных детей',
    2016,
    5,
    'Детство Джейкоба прошло под рассказы дедушки о приюте для необычных детей',
    '02:08:07'
  ),(
    9,
    5,
    'Ночной дозор',
    2004,
    3,
    'Все знают, что на ночных улицах опасно. Но в данном случае речь идет не о преступниках и маньяках',
    '01:55:41'
  );
  /*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;
  /*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
  /*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
  /*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
  /*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
  /*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
  /*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
  /*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
  /*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
-- Dump completed on 2019-12-22  2:48:37