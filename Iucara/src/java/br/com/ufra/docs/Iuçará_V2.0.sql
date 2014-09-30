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
-- Table `cadeia_iucara`.`perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`perfil` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` INT NOT NULL,
  `descricao` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`bairro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`bairro` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`atravessador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`atravessador` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `loggin` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(12) NOT NULL,
  `perfil` INT NOT NULL,
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
  `perfil` INT NOT NULL,
  `bairro` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`Localidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`Localidade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `agricultor` VARCHAR(255) NOT NULL,
  `coordenadas` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`cesto_acai`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`cesto_acai` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `origem` VARCHAR(100) NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `Localidade` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`compras` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `atravessador` INT NOT NULL,
  `batedor` INT NOT NULL,
  `cestoAcai` INT NOT NULL,
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
  `categoria` INT NOT NULL,
  `cesto_acai` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantidade` INT NOT NULL,
  `processar` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `contato` VARCHAR(100) NOT NULL,
  `bairro` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`venda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `preco` DOUBLE NOT NULL,
  `total` DOUBLE NOT NULL,
  `cliente` INT NOT NULL,
  `batedor` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`itens_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`itens_produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantidade` DOUBLE NOT NULL,
  `venda` INT NOT NULL,
  `produto` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
