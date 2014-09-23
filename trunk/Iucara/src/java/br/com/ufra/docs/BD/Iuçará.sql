SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema iucara
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `iucara` ;
CREATE SCHEMA IF NOT EXISTS `iucara` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `iucara` ;

-- -----------------------------------------------------
-- Table `iucara`.`comerciante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `iucara`.`comerciante` ;

CREATE TABLE IF NOT EXISTS `iucara`.`comerciante` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `iucara`.`batedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `iucara`.`batedor` ;

CREATE TABLE IF NOT EXISTS `iucara`.`batedor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `iucara`.`acai`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `iucara`.`acai` ;

CREATE TABLE IF NOT EXISTS `iucara`.`acai` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `origem` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `iucara`.`compra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `iucara`.`compra` ;

CREATE TABLE IF NOT EXISTS `iucara`.`compra` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `comerciante` INT NOT NULL,
  `batedor` INT NOT NULL,
  `acai` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_compra_comerciante_idx` (`comerciante` ASC),
  INDEX `fk_compra_batedor1_idx` (`batedor` ASC),
  INDEX `fk_compra_acai1_idx` (`acai` ASC),
  CONSTRAINT `fk_compra_comerciante`
    FOREIGN KEY (`comerciante`)
    REFERENCES `iucara`.`comerciante` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_batedor1`
    FOREIGN KEY (`batedor`)
    REFERENCES `iucara`.`batedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_acai1`
    FOREIGN KEY (`acai`)
    REFERENCES `iucara`.`acai` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `iucara`.`categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `iucara`.`categoria` ;

CREATE TABLE IF NOT EXISTS `iucara`.`categoria` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `iucara`.`processar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `iucara`.`processar` ;

CREATE TABLE IF NOT EXISTS `iucara`.`processar` (
  `id` INT NOT NULL,
  `data` DATE NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `batedor` INT NOT NULL,
  `categoria` INT NOT NULL,
  `acai` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_processar_batedor1_idx` (`batedor` ASC),
  INDEX `fk_processar_categoria1_idx` (`categoria` ASC),
  INDEX `fk_processar_acai1_idx` (`acai` ASC),
  CONSTRAINT `fk_processar_batedor1`
    FOREIGN KEY (`batedor`)
    REFERENCES `iucara`.`batedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_processar_categoria1`
    FOREIGN KEY (`categoria`)
    REFERENCES `iucara`.`categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_processar_acai1`
    FOREIGN KEY (`acai`)
    REFERENCES `iucara`.`acai` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `iucara`.`produto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `iucara`.`produto` ;

CREATE TABLE IF NOT EXISTS `iucara`.`produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `preco` VARCHAR(45) NOT NULL,
  `quantidade` VARCHAR(45) NOT NULL,
  `processar` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_produto_processar1_idx` (`processar` ASC),
  CONSTRAINT `fk_produto_processar1`
    FOREIGN KEY (`processar`)
    REFERENCES `iucara`.`processar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `iucara`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `iucara`.`cliente` ;

CREATE TABLE IF NOT EXISTS `iucara`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `contato` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `iucara`.`venda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `iucara`.`venda` ;

CREATE TABLE IF NOT EXISTS `iucara`.`venda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `preco` DOUBLE NOT NULL,
  `total` DOUBLE NOT NULL,
  `produto` INT NOT NULL,
  `cliente` INT NOT NULL,
  `batedor` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_venda_produto1_idx` (`produto` ASC),
  INDEX `fk_venda_cliente1_idx` (`cliente` ASC),
  INDEX `fk_venda_batedor1_idx` (`batedor` ASC),
  CONSTRAINT `fk_venda_produto1`
    FOREIGN KEY (`produto`)
    REFERENCES `iucara`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_cliente1`
    FOREIGN KEY (`cliente`)
    REFERENCES `iucara`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_batedor1`
    FOREIGN KEY (`batedor`)
    REFERENCES `iucara`.`batedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
