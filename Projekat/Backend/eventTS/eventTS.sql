-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `idUsera` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `lastName` VARCHAR(30) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `reported` TINYINT(1) NULL,
  `removed` TINYINT(1) NULL,
  `role` TINYINT(1) NULL,
  PRIMARY KEY (`idUsera`),
  UNIQUE INDEX `password_UNIQUE` (`password` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Event` (
  `idEventa` INT NOT NULL AUTO_INCREMENT,
  `voteDeadline` DATE NOT NULL,
  `reported` TINYINT(1) NULL,
  `removed` TINYINT(1) NULL,
  PRIMARY KEY (`idEventa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User_and_Event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User_and_Event` (
  `idUsera` INT NOT NULL,
  `idEventa` INT NOT NULL,
  PRIMARY KEY (`idUsera`, `idEventa`),
  INDEX `fk_User_has_Event_Event1_idx` (`idEventa` ASC),
  INDEX `fk_User_has_Event_User_idx` (`idUsera` ASC),
  CONSTRAINT `fk_User_has_Event_User`
    FOREIGN KEY (`idUsera`)
    REFERENCES `mydb`.`User` (`idUsera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Event_Event1`
    FOREIGN KEY (`idEventa`)
    REFERENCES `mydb`.`Event` (`idEventa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Message` (
  `idUsera` INT NOT NULL,
  `idEventa` INT NOT NULL,
  `text` VARCHAR(1000) NOT NULL,
  `time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`idUsera`, `idEventa`),
  INDEX `fk_User_has_Event1_Event1_idx` (`idEventa` ASC),
  INDEX `fk_User_has_Event1_User1_idx` (`idUsera` ASC),
  CONSTRAINT `fk_User_has_Event1_User1`
    FOREIGN KEY (`idUsera`)
    REFERENCES `mydb`.`User` (`idUsera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Event1_Event1`
    FOREIGN KEY (`idEventa`)
    REFERENCES `mydb`.`Event` (`idEventa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Detail` (
  `idDetail` INT NOT NULL AUTO_INCREMENT,
  `detailName` VARCHAR(60) NOT NULL,
  `detailDescription` VARCHAR(600) NULL,
  `idEventa` INT NOT NULL,
  PRIMARY KEY (`idDetail`, `idEventa`),
  INDEX `fk_Detail_Event1_idx` (`idEventa` ASC),
  CONSTRAINT `fk_Detail_Event1`
    FOREIGN KEY (`idEventa`)
    REFERENCES `mydb`.`Event` (`idEventa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Prijavljeni_Korisnici`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Prijavljeni_Korisnici` (
  `idUsera` INT NOT NULL,
  `opisPrijave` VARCHAR(300) NOT NULL,
  `slika` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idUsera`),
  CONSTRAINT `fk_Prijavljeni_Korisnici_User1`
    FOREIGN KEY (`idUsera`)
    REFERENCES `mydb`.`User` (`idUsera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Prijavljeni_Eventi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Prijavljeni_Eventi` (
  `idEventa` INT NOT NULL,
  `opisPrijave` VARCHAR(300) NOT NULL,
  `slika` VARCHAR(50) NULL,
  PRIMARY KEY (`idEventa`),
  CONSTRAINT `fk_Prijavljeni_Eventi_Event1`
    FOREIGN KEY (`idEventa`)
    REFERENCES `mydb`.`Event` (`idEventa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Options`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Options` (
  `idOption` INT NOT NULL,
  `text` VARCHAR(1000) NULL,
  `idDetail` INT NOT NULL,
  PRIMARY KEY (`idOption`, `idDetail`),
  INDEX `fk_Options_Detail1_idx` (`idDetail` ASC),
  CONSTRAINT `fk_Options_Detail1`
    FOREIGN KEY (`idDetail`)
    REFERENCES `mydb`.`Detail` (`idDetail`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User_and_Options`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User_and_Options` (
  `idUsera` INT NOT NULL,
  `idOption` INT NOT NULL,
  PRIMARY KEY (`idUsera`, `idOption`),
  INDEX `fk_User_has_Options_Options1_idx` (`idOption` ASC),
  INDEX `fk_User_has_Options_User1_idx` (`idUsera` ASC),
  CONSTRAINT `fk_User_has_Options_User1`
    FOREIGN KEY (`idUsera`)
    REFERENCES `mydb`.`User` (`idUsera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Options_Options1`
    FOREIGN KEY (`idOption`)
    REFERENCES `mydb`.`Options` (`idOption`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
