-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema clientmanager
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema clientmanager
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `clientmanager` DEFAULT CHARACTER SET utf8 ;
USE `clientmanager` ;

-- -----------------------------------------------------
-- Table `clientmanager`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clientmanager`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `company` VARCHAR(45) NULL,
  `created` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clientmanager`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clientmanager`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NOT NULL,
  `street_number` VARCHAR(45) NULL,
  `zip` SMALLINT(10) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `client_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `client_id_idx` (`client_id` ASC),
  CONSTRAINT `client_address`
    FOREIGN KEY (`client_id`)
    REFERENCES `clientmanager`.`client` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clientmanager`.`contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clientmanager`.`contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `sort` VARCHAR(45) NOT NULL,
  `value` VARCHAR(45) NOT NULL,
  `client_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `client_id_idx` (`client_id` ASC),
  CONSTRAINT `client_id`
    FOREIGN KEY (`client_id`)
    REFERENCES `clientmanager`.`client` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
