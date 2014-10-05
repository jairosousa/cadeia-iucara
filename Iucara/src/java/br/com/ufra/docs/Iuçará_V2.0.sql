SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cadeia_iucara
-- -----------------------------------------------------
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
  INDEX `fk_distribuidor_bairro1_idx` (`bairro` ASC),
  CONSTRAINT `fk_distribuidor_bairro1`
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
-- Table `cadeia_iucara`.`compra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadeia_iucara`.`compra` ;

CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`compra` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `distribuidor` INT NOT NULL,
  `batedor` INT NOT NULL,
  `data` DATE NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_compras_distribuidor1_idx` (`distribuidor` ASC),
  INDEX `fk_compras_batedor1_idx` (`batedor` ASC),
  CONSTRAINT `fk_compras_distribuidor1`
    FOREIGN KEY (`distribuidor`)
    REFERENCES `cadeia_iucara`.`distribuidor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compras_batedor1`
    FOREIGN KEY (`batedor`)
    REFERENCES `cadeia_iucara`.`batedor` (`id`)
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
-- Table `cadeia_iucara`.`Cesto_distribuidor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadeia_iucara`.`Cesto_distribuidor` ;

CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`Cesto_distribuidor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `capacidade` DOUBLE NOT NULL,
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
  `Cesto_distribuidor` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_processamento_batedor1_idx` (`batedor` ASC),
  INDEX `fk_processamento_Cesto_distribuidor1_idx` (`Cesto_distribuidor` ASC),
  CONSTRAINT `fk_processamento_batedor1`
    FOREIGN KEY (`batedor`)
    REFERENCES `cadeia_iucara`.`batedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_processamento_Cesto_distribuidor1`
    FOREIGN KEY (`Cesto_distribuidor`)
    REFERENCES `cadeia_iucara`.`Cesto_distribuidor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadeia_iucara`.`cliente` ;

CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `contato` VARCHAR(100) NOT NULL,
  `bairro` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cliente_bairro1_idx` (`bairro` ASC),
  CONSTRAINT `fk_cliente_bairro1`
    FOREIGN KEY (`bairro`)
    REFERENCES `cadeia_iucara`.`bairro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`armazenamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadeia_iucara`.`armazenamento` ;

CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`armazenamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `distribuidor` INT NOT NULL,
  `Cesto_distribuidor` INT NOT NULL,
  `data` DATE NOT NULL COMMENT 'Tabela fara armazenamento do distribuidor que pode comprar varios cestos de varios atravessador.',
  `quantidade` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_armazenamento_distribuidor1_idx` (`distribuidor` ASC),
  INDEX `fk_armazenamento_Cesto_distribuidor1_idx` (`Cesto_distribuidor` ASC),
  CONSTRAINT `fk_armazenamento_distribuidor1`
    FOREIGN KEY (`distribuidor`)
    REFERENCES `cadeia_iucara`.`distribuidor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_armazenamento_Cesto_distribuidor1`
    FOREIGN KEY (`Cesto_distribuidor`)
    REFERENCES `cadeia_iucara`.`Cesto_distribuidor` (`id`)
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
  INDEX `fk_cesto_acai_has_armazenamento_armazenamento1_idx` (`armazenamento` ASC),
  INDEX `fk_cesto_acai_has_armazenamento_cesto_acai_idx` (`cesto_acai` ASC),
  CONSTRAINT `fk_cesto_acai_has_armazenamento_cesto_acai`
    FOREIGN KEY (`cesto_acai`)
    REFERENCES `cadeia_iucara`.`cesto_acai` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cesto_acai_has_armazenamento_armazenamento1`
    FOREIGN KEY (`armazenamento`)
    REFERENCES `cadeia_iucara`.`armazenamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`itens_cesto_distribuidor_compras`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadeia_iucara`.`itens_cesto_distribuidor_compras` ;

CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`itens_cesto_distribuidor_compras` (
  `Cesto_distribuidor` INT NOT NULL,
  `compra` INT NOT NULL,
  PRIMARY KEY (`Cesto_distribuidor`, `compra`),
  INDEX `fk_Cesto_distribuidor_has_compras_compras1_idx` (`compra` ASC),
  INDEX `fk_Cesto_distribuidor_has_compras_Cesto_distribuidor1_idx` (`Cesto_distribuidor` ASC),
  CONSTRAINT `fk_Cesto_distribuidor_has_compras_Cesto_distribuidor1`
    FOREIGN KEY (`Cesto_distribuidor`)
    REFERENCES `cadeia_iucara`.`Cesto_distribuidor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cesto_distribuidor_has_compras_compras1`
    FOREIGN KEY (`compra`)
    REFERENCES `cadeia_iucara`.`compra` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`Vinho_embalado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadeia_iucara`.`Vinho_embalado` ;

CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`Vinho_embalado` (
  `processamento` INT NOT NULL,
  `categoria` INT NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  INDEX `fk_embalagem_processamento1_idx` (`processamento` ASC),
  INDEX `fk_embalagem_categoria1_idx` (`categoria` ASC),
  PRIMARY KEY (`processamento`),
  CONSTRAINT `fk_embalagem_processamento1`
    FOREIGN KEY (`processamento`)
    REFERENCES `cadeia_iucara`.`processamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_embalagem_categoria1`
    FOREIGN KEY (`categoria`)
    REFERENCES `cadeia_iucara`.`categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`venda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadeia_iucara`.`venda` ;

CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`venda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `cliente` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_venda_cliente1_idx` (`cliente` ASC),
  CONSTRAINT `fk_venda_cliente1`
    FOREIGN KEY (`cliente`)
    REFERENCES `cadeia_iucara`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadeia_iucara`.`itens_venda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadeia_iucara`.`itens_venda` ;

CREATE TABLE IF NOT EXISTS `cadeia_iucara`.`itens_venda` (
  `venda` INT NOT NULL,
  `procesamento` INT NOT NULL,
  INDEX `fk_itens_venda_venda1_idx` (`venda` ASC),
  INDEX `fk_itens_venda_Vinho_embalado1_idx` (`procesamento` ASC),
  CONSTRAINT `fk_itens_venda_venda1`
    FOREIGN KEY (`venda`)
    REFERENCES `cadeia_iucara`.`venda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itens_venda_Vinho_embalado1`
    FOREIGN KEY (`procesamento`)
    REFERENCES `cadeia_iucara`.`Vinho_embalado` (`processamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
