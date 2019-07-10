
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema CarRent
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CarRent
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CarRent` DEFAULT CHARACTER SET utf8 ;
USE `CarRent` ;

-- -----------------------------------------------------
-- Table `CarRent`.`Employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarRent`.`Employee` ;

CREATE TABLE IF NOT EXISTS `CarRent`.`Employee` (
  `IRS Number` INT NOT NULL,
  `Social Security Number` INT NOT NULL,
  `Driver License` VARCHAR(45) NOT NULL,
  `First Name` VARCHAR(45) NOT NULL,
  `Last Name` VARCHAR(45) NOT NULL,
  `Street` VARCHAR(45) NOT NULL,
  `Street Number` INT NOT NULL,
  `Postal Code` INT NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`IRS Number`),
  UNIQUE INDEX `Social Security Number_UNIQUE` (`Social Security Number` ASC),
  UNIQUE INDEX `Driver License_UNIQUE` (`Driver License` ASC),
  UNIQUE INDEX `IRS Number_UNIQUE` (`IRS Number` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarRent`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarRent`.`Customer` ;

CREATE TABLE IF NOT EXISTS `CarRent`.`Customer` (
  `Customer ID` INT NOT NULL AUTO_INCREMENT,
  `IRS Number` INT NOT NULL,
  `Social Security Number` INT NOT NULL,
  `Last Name` VARCHAR(45) NOT NULL,
  `First Name` VARCHAR(45) NOT NULL,
  `Driver License` VARCHAR(45) NOT NULL,
  `First Registration` DATETIME NULL,
  `City` VARCHAR(45) NOT NULL,
  `Postal Code` INT NOT NULL,
  `Street` VARCHAR(45) NOT NULL,
  `Street Number` INT NOT NULL,
  PRIMARY KEY (`Customer ID`),
  UNIQUE INDEX `IRS Number_UNIQUE` (`IRS Number` ASC),
  UNIQUE INDEX `Social Security Number_UNIQUE` (`Social Security Number` ASC),
  UNIQUE INDEX `Driver License_UNIQUE` (`Driver License` ASC),
  UNIQUE INDEX `Customer ID_UNIQUE` (`Customer ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarRent`.`Store`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarRent`.`Store` ;

CREATE TABLE IF NOT EXISTS `CarRent`.`Store` (
  `Store ID` INT NOT NULL AUTO_INCREMENT,
  `Street` VARCHAR(45) NOT NULL,
  `Street Number` INT NOT NULL,
  `Postal Code` INT NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `Store ID_UNIQUE` (`Store ID` ASC),
  PRIMARY KEY (`Store ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarRent`.`Vehicle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarRent`.`Vehicle` ;

CREATE TABLE IF NOT EXISTS `CarRent`.`Vehicle` (
  `License Plate` VARCHAR(10) NOT NULL,
  `Model` VARCHAR(20) NOT NULL,
  `Type` VARCHAR(20) NOT NULL,
  `Make` VARCHAR(20) NOT NULL,
  `Year` INT NOT NULL DEFAULT 0,
  `Kilometers` INT NOT NULL DEFAULT 0,
  `Cylinder Capacity` INT NOT NULL,
  `Horse Power` INT NOT NULL,
  `Damages` VARCHAR(35) NOT NULL DEFAULT 'N/A',
  `Malfunctions` VARCHAR(35) NOT NULL DEFAULT 'N/A',
  `Next Service` DATE NULL,
  `Insurance Exp Date` DATE NULL,
  `Last Service` DATE NULL,
  `Store ID` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`License Plate`),
  UNIQUE INDEX `License Plate_UNIQUE` (`License Plate` ASC),
  INDEX `Stode ID_idx` (`Store ID` ASC),
  CONSTRAINT `Store ID Vehicle`
    FOREIGN KEY (`Store ID`)
    REFERENCES `CarRent`.`Store` (`Store ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarRent`.`Phone Number`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarRent`.`Phone Number` ;

CREATE TABLE IF NOT EXISTS `CarRent`.`Phone Number` (
  `Store ID` INT NOT NULL,
  `Phone Number` INT NOT NULL,
  UNIQUE INDEX `Store ID_UNIQUE` (`Store ID` ASC),
  PRIMARY KEY (`Store ID`),
  CONSTRAINT `Store ID Phone`
    FOREIGN KEY (`Store ID`)
    REFERENCES `CarRent`.`Store` (`Store ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarRent`.`Email Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarRent`.`Email Address` ;

CREATE TABLE IF NOT EXISTS `CarRent`.`Email Address` (
  `Store ID` INT NOT NULL,
  `Email_Address` VARCHAR(35) NOT NULL,
  UNIQUE INDEX `Store ID_UNIQUE` (`Store ID` ASC),
  PRIMARY KEY (`Store ID`),
  CONSTRAINT `Store ID Email Address`
    FOREIGN KEY (`Store ID`)
    REFERENCES `CarRent`.`Store` (`Store ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarRent`.`Fuel Type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarRent`.`Fuel Type` ;

CREATE TABLE IF NOT EXISTS `CarRent`.`Fuel Type` (
  `License Plate` VARCHAR(10) NOT NULL,
  `Fuel Type` VARCHAR(15) NOT NULL,
  UNIQUE INDEX `License Plate_UNIQUE` (`License Plate` ASC),
  PRIMARY KEY (`License Plate`),
  CONSTRAINT `License Plate Fuel Type`
    FOREIGN KEY (`License Plate`)
    REFERENCES `CarRent`.`Vehicle` (`License Plate`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarRent`.`Reserves`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarRent`.`Reserves` ;

CREATE TABLE IF NOT EXISTS `CarRent`.`Reserves` (
  `License Plate` VARCHAR(10) NOT NULL,
  `Start Date` DATE NOT NULL,
  `Start Location` VARCHAR(25) NOT NULL,
  `Finish Location` VARCHAR(25) NOT NULL,
  `Finish Date` VARCHAR(25) NOT NULL,
  `Paid` TINYINT(1) NOT NULL,
  `Customer ID` INT NOT NULL,
  PRIMARY KEY (`License Plate`, `Start Date`),
  UNIQUE INDEX `License Plate_UNIQUE` (`License Plate` ASC),
  UNIQUE INDEX `Start Date_UNIQUE` (`Start Date` ASC),
  INDEX `Customer ID_idx` (`Customer ID` ASC),
  CONSTRAINT `Customer ID Reserves`
    FOREIGN KEY (`Customer ID`)
    REFERENCES `CarRent`.`Customer` (`Customer ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `License Plate Reserves`
    FOREIGN KEY (`License Plate`)
    REFERENCES `CarRent`.`Vehicle` (`License Plate`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarRent`.`Works`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarRent`.`Works` ;

CREATE TABLE IF NOT EXISTS `CarRent`.`Works` (
  `IRS Number` INT NOT NULL,
  `Store ID` INT NOT NULL,
  `Start Date` DATE NOT NULL,
  `Finish Date` DATE NULL,
  `Position` VARCHAR(25) NULL,
  UNIQUE INDEX `IRS Number_UNIQUE` (`IRS Number` ASC),
  PRIMARY KEY (`IRS Number`, `Store ID`, `Start Date`),
  UNIQUE INDEX `Start Date_UNIQUE` (`Start Date` ASC),
  CONSTRAINT `IRS Number Works`
    FOREIGN KEY (`IRS Number`)
    REFERENCES `CarRent`.`Employee` (`IRS Number`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Store ID Works`
    FOREIGN KEY (`Store ID`)
    REFERENCES `CarRent`.`Store` (`Store ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarRent`.`Rents`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarRent`.`Rents` ;

CREATE TABLE IF NOT EXISTS `CarRent`.`Rents` (
  `License Plate` VARCHAR(10) NOT NULL,
  `Start Date` DATE NOT NULL,
  `Start Location` VARCHAR(25) NOT NULL,
  `Finish Location` VARCHAR(25) NOT NULL,
  `Finish Date` DATE NOT NULL,
  `Return State` VARCHAR(25) NOT NULL,
  `Customer ID` INT NOT NULL,
  `IRS Number` INT NOT NULL,
  UNIQUE INDEX `License Plate_UNIQUE` (`License Plate` ASC),
  PRIMARY KEY (`License Plate`, `Start Date`),
  UNIQUE INDEX `Start Date_UNIQUE` (`Start Date` ASC),
  INDEX `Customer ID_idx` (`Customer ID` ASC),
  INDEX `IRS Number_idx` (`IRS Number` ASC),
  CONSTRAINT `License Plate Rents`
    FOREIGN KEY (`License Plate`)
    REFERENCES `CarRent`.`Vehicle` (`License Plate`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Customer ID  Rents`
    FOREIGN KEY (`Customer ID`)
    REFERENCES `CarRent`.`Customer` (`Customer ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `IRS Number  Rents`
    FOREIGN KEY (`IRS Number`)
    REFERENCES `CarRent`.`Employee` (`IRS Number`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarRent`.`Payment Transaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarRent`.`Payment Transaction` ;

CREATE TABLE IF NOT EXISTS `CarRent`.`Payment Transaction` (
  `Start Date` DATE NOT NULL,
  `License Plate` VARCHAR(10) NOT NULL,
  `Payment Amount` INT NOT NULL,
  `Payment Method` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`Start Date`, `License Plate`),
  UNIQUE INDEX `Start Date_UNIQUE` (`Start Date` ASC),
  UNIQUE INDEX `License Plate_UNIQUE` (`License Plate` ASC),
  CONSTRAINT `Start Date Payment Transactions`
    FOREIGN KEY (`Start Date`)
    REFERENCES `CarRent`.`Rents` (`Start Date`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `License Plate  Payment Transactions`
    FOREIGN KEY (`License Plate`)
    REFERENCES `CarRent`.`Rents` (`License Plate`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
