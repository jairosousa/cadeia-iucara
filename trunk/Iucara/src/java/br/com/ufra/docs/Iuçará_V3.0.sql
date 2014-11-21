-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cadeia_iucara
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cadeia_iucara
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cadeia_iucara` DEFAULT CHARACTER SET utf8 ;
USE `cadeia_iucara` ;

-- -----------------------------------------------------
-- Table `cadeia_iucara`.`bairro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`bairro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`distribuidor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`distribuidor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `loggin` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(12) NOT NULL,
  `bairro` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`batedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`batedor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `loggin` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(12) NOT NULL,
  `bairro` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`cesto_acai`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`cesto_acai` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `origem` VARCHAR(100) NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`cesto_distribuidor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`cesto_distribuidor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `capacidade` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`compra` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `batedor` INT NOT NULL,
  `distribuidor` INT NOT NULL,
  `cesto_distribuidor` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`processamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`processamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `batedor` INT NOT NULL,
  `Cesto_distribuidor` INT NOT NULL,
  `categoria` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`armazenamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`armazenamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `distribuidor` INT NOT NULL,
  `Cesto_distribuidor` INT NOT NULL,
  `data` DATE NOT NULL COMMENT 'Tabela fara armazenamento do distribuidor que pode comprar varios cestos de varios atravessador.',
  `quantidade` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`itens_armazenamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`itens_armazenamento` (
  `cesto_acai` INT NOT NULL,
  `armazenamento` INT NOT NULL,
  PRIMARY KEY (`cesto_acai`, `armazenamento`),
  INDEX `fk_cesto_acai_has_armazenamento_cesto_acai_idx` (`cesto_acai` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
