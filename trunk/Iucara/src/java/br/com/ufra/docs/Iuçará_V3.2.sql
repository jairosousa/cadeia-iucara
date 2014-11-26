SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `cadeia_iucara` ;
CREATE SCHEMA IF NOT EXISTS `cadeia_iucara` DEFAULT CHARACTER SET utf8 ;
USE `cadeia_iucara` ;

-- -----------------------------------------------------
-- Table `cadeia_iucara`.`bairro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadeia_iucara`.`bairro` ;

CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`bairro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`distribuidor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadeia_iucara`.`distribuidor` ;

CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`distribuidor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `loggin` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(12) NOT NULL,
  `bairro` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_distribuidor_bairro_idx` (`bairro` ASC),
  CONSTRAINT `fk_distribuidor_bairro`
    FOREIGN KEY (`bairro`)
    REFERENCES `cadeia_iucara`.`bairro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`batedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadeia_iucara`.`batedor` ;

CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`batedor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `loggin` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(12) NOT NULL,
  `bairro` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_batedor_bairro1_idx` (`bairro` ASC),
  CONSTRAINT `fk_batedor_bairro1`
    FOREIGN KEY (`bairro`)
    REFERENCES `cadeia_iucara`.`bairro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`cesto_acai`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadeia_iucara`.`cesto_acai` ;

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
DROP TABLE IF EXISTS `cadeia_iucara`.`cesto_distribuidor` ;

CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`cesto_distribuidor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `capacidade` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`compra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadeia_iucara`.`compra` ;

CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`compra` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `distribuidor` INT NOT NULL,
  `batedor` INT NOT NULL,
  `cesto_distribuidor` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_compra_distribuidor1_idx` (`distribuidor` ASC),
  INDEX `fk_compra_batedor1_idx` (`batedor` ASC),
  INDEX `fk_compra_cesto_distribuidor1_idx` (`cesto_distribuidor` ASC),
  CONSTRAINT `fk_compra_distribuidor1`
    FOREIGN KEY (`distribuidor`)
    REFERENCES `cadeia_iucara`.`distribuidor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_batedor1`
    FOREIGN KEY (`batedor`)
    REFERENCES `cadeia_iucara`.`batedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_cesto_distribuidor1`
    FOREIGN KEY (`cesto_distribuidor`)
    REFERENCES `cadeia_iucara`.`cesto_distribuidor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadeia_iucara`.`categoria` ;

CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`processamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadeia_iucara`.`processamento` ;

CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`processamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `batedor` INT NOT NULL,
  `cesto_distribuidor` INT NOT NULL,
  `categoria` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_processamento_batedor1_idx` (`batedor` ASC),
  INDEX `fk_processamento_cesto_distribuidor1_idx` (`cesto_distribuidor` ASC),
  INDEX `fk_processamento_categoria1_idx` (`categoria` ASC),
  CONSTRAINT `fk_processamento_batedor1`
    FOREIGN KEY (`batedor`)
    REFERENCES `cadeia_iucara`.`batedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_processamento_cesto_distribuidor1`
    FOREIGN KEY (`cesto_distribuidor`)
    REFERENCES `cadeia_iucara`.`cesto_distribuidor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_processamento_categoria1`
    FOREIGN KEY (`categoria`)
    REFERENCES `cadeia_iucara`.`categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`armazenamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadeia_iucara`.`armazenamento` ;

CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`armazenamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL COMMENT 'Tabela fara armazenamento do distribuidor que pode comprar varios cestos de varios atravessador.',
  `quantidade` DOUBLE NULL,
  `distribuidor` INT NOT NULL,
  `cesto_distribuidor` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_armazenamento_distribuidor1_idx` (`distribuidor` ASC),
  INDEX `fk_armazenamento_cesto_distribuidor1_idx` (`cesto_distribuidor` ASC),
  CONSTRAINT `fk_armazenamento_distribuidor1`
    FOREIGN KEY (`distribuidor`)
    REFERENCES `cadeia_iucara`.`distribuidor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_armazenamento_cesto_distribuidor1`
    FOREIGN KEY (`cesto_distribuidor`)
    REFERENCES `cadeia_iucara`.`cesto_distribuidor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`itens_armazenamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadeia_iucara`.`itens_armazenamento` ;

CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`itens_armazenamento` (
  `cesto_acai` INT NOT NULL,
  `armazenamento` INT NOT NULL,
  PRIMARY KEY (`cesto_acai`, `armazenamento`),
  INDEX `fk_itens_armazenamento_cesto_acai1_idx` (`cesto_acai` ASC),
  INDEX `fk_itens_armazenamento_armazenamento1_idx` (`armazenamento` ASC),
  CONSTRAINT `fk_itens_armazenamento_cesto_acai1`
    FOREIGN KEY (`cesto_acai`)
    REFERENCES `cadeia_iucara`.`cesto_acai` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itens_armazenamento_armazenamento1`
    FOREIGN KEY (`armazenamento`)
    REFERENCES `cadeia_iucara`.`armazenamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
