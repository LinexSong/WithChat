-- MySQL dump 10.13  Distrib 9.0.1, for macos14.4 (arm64)
--
-- Host: 127.0.0.1    Database: with_chat
-- ------------------------------------------------------
-- Server version	9.0.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chat_admin`
--
create database if not exists `withchat`;
use `withchat`;

DROP TABLE IF EXISTS `chat_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat_admin` (
  `aid` int NOT NULL AUTO_INCREMENT COMMENT '管理员 ID',
  `a_name` varchar(50) NOT NULL COMMENT '管理员名称',
  `a_pwd` varchar(255) NOT NULL COMMENT '管理员密码',
  `disabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '账号是否启用 0-启用 1-停用',
  `resp_u` int NOT NULL DEFAULT '10' COMMENT '负责管理用户人数',
  `resp_g` int NOT NULL DEFAULT '10' COMMENT '负责管理群数',
  `resp_u_start` int NOT NULL DEFAULT '10000' COMMENT '管理用户起始编号',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_admin`
--

LOCK TABLES `chat_admin` WRITE;
/*!40000 ALTER TABLE `chat_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `chat_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat_single_msg`
--

DROP TABLE IF EXISTS `chat_single_msg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat_single_msg` (
  `msg_id` bigint NOT NULL AUTO_INCREMENT COMMENT '消息 ID',
  `send_uid` int NOT NULL COMMENT '消息发起者用户 ID',
  `des_uid` int NOT NULL COMMENT '目标用户 ID',
  `msg` text NOT NULL COMMENT '消息内容',
  `time` datetime NOT NULL COMMENT '消息发送时间',
  `msg_type` char(1) NOT NULL DEFAULT '0' COMMENT '消息类型 0-临时消息, 1-群临时消息, 2-好友消息',
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_single_msg`
--

LOCK TABLES `chat_single_msg` WRITE;
/*!40000 ALTER TABLE `chat_single_msg` DISABLE KEYS */;
/*!40000 ALTER TABLE `chat_single_msg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat_user`
--

DROP TABLE IF EXISTS `chat_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat_user` (
  `uid` int NOT NULL AUTO_INCREMENT COMMENT '用户 ID',
  `nickname` varchar(50) NOT NULL COMMENT '用户昵称',
  `u_sig` varchar(255) DEFAULT NULL COMMENT '用户个性签名',
  `u_avatar` varchar(255) DEFAULT NULL COMMENT '用户头像地址',
  `chat_mode` char(1) NOT NULL DEFAULT '0' COMMENT '聊天模式 0-任何人均可发起，1-可通过群发起，2-仅好友可发起',
  `u_pwd` varchar(255) NOT NULL COMMENT '用户密码',
  `disabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '账号是否启用 0-启用 1-停用',
  `unmanaged` tinyint(1) NOT NULL DEFAULT '0' COMMENT '账号是否受管理 0-是 1-否',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_user`
--

LOCK TABLES `chat_user` WRITE;
/*!40000 ALTER TABLE `chat_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `chat_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-20 20:24:12
