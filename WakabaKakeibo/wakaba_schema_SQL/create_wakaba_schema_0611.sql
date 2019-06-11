-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema wakaba_schema
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `wakaba_schema` ;

-- -----------------------------------------------------
-- Schema wakaba_schema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `wakaba_schema` DEFAULT CHARACTER SET utf8 ;
USE `wakaba_schema` ;

-- -----------------------------------------------------
-- Table `wakaba_schema`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wakaba_schema`.`Users` ;

CREATE TABLE IF NOT EXISTS `wakaba_schema`.`Users` (
  `UserID` INT NOT NULL,
  `Password` VARCHAR(15) NULL,
  `UserName` VARCHAR(30) NULL,
  `Sex` VARCHAR(10) NULL,
  `Birthday` DATE NULL,
  `TargetAmount` INT NULL,
  `PresentAmount` INT NULL,
  `LastLogin` DATE NULL,
  `RunningDays` INT NULL,
  `FeelingLevel` INT NULL,
  `Honorific` VARCHAR(10) NULL,
  `UserIcon` VARCHAR(80) NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE INDEX `idUsers_UNIQUE` (`UserID` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wakaba_schema`.`Products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wakaba_schema`.`Products` ;

CREATE TABLE IF NOT EXISTS `wakaba_schema`.`Products` (
  `ProductID` INT NOT NULL,
  `ProductName` VARCHAR(50) NULL,
  PRIMARY KEY (`ProductID`),
  UNIQUE INDEX `ProductID_UNIQUE` (`ProductID` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wakaba_schema`.`MoneyCategorys`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wakaba_schema`.`MoneyCategorys` ;

CREATE TABLE IF NOT EXISTS `wakaba_schema`.`MoneyCategorys` (
  `MoneyCategorysID` INT NOT NULL,
  `CategoryName` VARCHAR(50) NULL,
  PRIMARY KEY (`MoneyCategorysID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wakaba_schema`.`MoneyNotes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wakaba_schema`.`MoneyNotes` ;

CREATE TABLE IF NOT EXISTS `wakaba_schema`.`MoneyNotes` (
  `MoneyNoteID` INT NOT NULL,
  `UserID` INT NULL,
  `PurchaseDate` DATE NULL,
  `Type` VARCHAR(20) NULL,
  `ProductID` INT NULL,
  `CategoryID` INT NULL,
  `NumberOfPurchase` INT NULL,
  `Amount` INT NULL,
  `PurchaseIntervalDays` INT NULL,
  PRIMARY KEY (`MoneyNoteID`),
  UNIQUE INDEX `MoneyNoteID_UNIQUE` (`MoneyNoteID` ASC) VISIBLE,
  INDEX `ProductID_idx` (`ProductID` ASC) VISIBLE,
  INDEX `UserID_idx` (`UserID` ASC) VISIBLE,
  INDEX `fk_moneynotes_moneycategoryid_idx` (`CategoryID` ASC) VISIBLE,
  CONSTRAINT `ProductID`
    FOREIGN KEY (`ProductID`)
    REFERENCES `wakaba_schema`.`Products` (`ProductID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `UserID`
    FOREIGN KEY (`UserID`)
    REFERENCES `wakaba_schema`.`Users` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_moneynotes_moneycategoryid`
    FOREIGN KEY (`CategoryID`)
    REFERENCES `wakaba_schema`.`MoneyCategorys` (`MoneyCategorysID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wakaba_schema`.`Messages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wakaba_schema`.`Messages` ;

CREATE TABLE IF NOT EXISTS `wakaba_schema`.`Messages` (
  `MessageID` INT NOT NULL,
  `MessageContent` VARCHAR(200) NULL,
  `MessageType` VARCHAR(20) NULL,
  `EventType` VARCHAR(20) NULL,
  PRIMARY KEY (`MessageID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wakaba_schema`.`Blogs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wakaba_schema`.`Blogs` ;

CREATE TABLE IF NOT EXISTS `wakaba_schema`.`Blogs` (
  `BlogID` INT NOT NULL,
  `UserID` INT NULL,
  `CreateDate` DATETIME NULL,
  `Title` VARCHAR(40) NULL,
  `Content` VARCHAR(400) NULL,
  `Category` VARCHAR(30) NULL,
  `Image1` VARCHAR(80) NULL,
  `Image2` VARCHAR(80) NULL,
  `ReblogID` INT NULL,
  PRIMARY KEY (`BlogID`),
  INDEX `UserID_idx` (`UserID` ASC) VISIBLE,
  INDEX `fk_blog_reblogID_idx` (`ReblogID` ASC) VISIBLE,
  CONSTRAINT `fk_blog_UserID`
    FOREIGN KEY (`UserID`)
    REFERENCES `wakaba_schema`.`Users` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_blog_reblogID`
    FOREIGN KEY (`ReblogID`)
    REFERENCES `wakaba_schema`.`Blogs` (`BlogID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wakaba_schema`.`BlogLikes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wakaba_schema`.`BlogLikes` ;

CREATE TABLE IF NOT EXISTS `wakaba_schema`.`BlogLikes` (
  `LikeID` INT NOT NULL,
  `UserID` INT NULL,
  `BlogID` INT NULL,
  `LikeDate` DATETIME NULL,
  PRIMARY KEY (`LikeID`),
  INDEX `fk_BlogLikes_blogID_idx` (`BlogID` ASC) VISIBLE,
  INDEX `fk_BlogLikes_userID_idx` (`UserID` ASC) VISIBLE,
  CONSTRAINT `fk_BlogLikes_blogID`
    FOREIGN KEY (`BlogID`)
    REFERENCES `wakaba_schema`.`Blogs` (`BlogID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BlogLikes_userID`
    FOREIGN KEY (`UserID`)
    REFERENCES `wakaba_schema`.`Users` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wakaba_schema`.`BlogComments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wakaba_schema`.`BlogComments` ;

CREATE TABLE IF NOT EXISTS `wakaba_schema`.`BlogComments` (
  `CommentID` INT NOT NULL,
  `UserID` INT NULL,
  `BlogID` INT NULL,
  `CommentDate` DATETIME NULL,
  `Content` VARCHAR(100) NULL,
  PRIMARY KEY (`CommentID`),
  INDEX `fk_BlogComments_usrID_idx` (`UserID` ASC) VISIBLE,
  INDEX `fk_BlogComments_blogID_idx` (`BlogID` ASC) VISIBLE,
  CONSTRAINT `fk_BlogComments_usrID`
    FOREIGN KEY (`UserID`)
    REFERENCES `wakaba_schema`.`Users` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BlogComments_blogID`
    FOREIGN KEY (`BlogID`)
    REFERENCES `wakaba_schema`.`Blogs` (`BlogID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wakaba_schema`.`PurchasePatterns`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wakaba_schema`.`PurchasePatterns` ;

CREATE TABLE IF NOT EXISTS `wakaba_schema`.`PurchasePatterns` (
  `PurchasePatternID` INT NOT NULL,
  `UserID` INT NULL,
  `ProductID` INT NULL,
  `DatePatternType` VARCHAR(20) NULL,
  `LastPurchaseDate` DATE NULL,
  `NumberPattern` INT NULL,
  `AmountPattern` INT NULL,
  PRIMARY KEY (`PurchasePatternID`),
  INDEX `fk_PurcheasePattern_userID_idx` (`UserID` ASC) VISIBLE,
  INDEX `fk_PurcheasePattern_productID_idx` (`ProductID` ASC) VISIBLE,
  CONSTRAINT `fk_PurcheasePattern_userID`
    FOREIGN KEY (`UserID`)
    REFERENCES `wakaba_schema`.`Users` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PurcheasePattern_productID`
    FOREIGN KEY (`ProductID`)
    REFERENCES `wakaba_schema`.`Products` (`ProductID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wakaba_schema`.`FavoriteUsers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wakaba_schema`.`FavoriteUsers` ;

CREATE TABLE IF NOT EXISTS `wakaba_schema`.`FavoriteUsers` (
  `FavoriteUsersID` INT NOT NULL,
  `RegistrationUserID` INT NULL,
  `RegisteredUserID` INT NULL,
  PRIMARY KEY (`FavoriteUsersID`),
  INDEX `fk_FavoriteUsers_reg_idx` (`RegistrationUserID` ASC) VISIBLE,
  INDEX `fk_FavoriteUsers_reged_idx` (`RegisteredUserID` ASC) VISIBLE,
  CONSTRAINT `fk_FavoriteUsers_reg`
    FOREIGN KEY (`RegistrationUserID`)
    REFERENCES `wakaba_schema`.`Users` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FavoriteUsers_reged`
    FOREIGN KEY (`RegisteredUserID`)
    REFERENCES `wakaba_schema`.`Users` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wakaba_schema`.`QuoteNotes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wakaba_schema`.`QuoteNotes` ;

CREATE TABLE IF NOT EXISTS `wakaba_schema`.`QuoteNotes` (
  `QuoteNoteID` INT NOT NULL,
  `BlogID` INT NULL,
  `NoteID` INT NULL,
  PRIMARY KEY (`QuoteNoteID`),
  INDEX `fk_QuoteNote_blogID_idx` (`BlogID` ASC) VISIBLE,
  INDEX `fk_QuoteNote_noteID_idx` (`NoteID` ASC) VISIBLE,
  CONSTRAINT `fk_QuoteNote_blogID`
    FOREIGN KEY (`BlogID`)
    REFERENCES `wakaba_schema`.`Blogs` (`BlogID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_QuoteNote_noteID`
    FOREIGN KEY (`NoteID`)
    REFERENCES `wakaba_schema`.`MoneyNotes` (`MoneyNoteID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wakaba_schema`.`Deposits`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wakaba_schema`.`Deposits` ;

CREATE TABLE IF NOT EXISTS `wakaba_schema`.`Deposits` (
  `DepositID` INT NOT NULL,
  `Date` DATE NULL,
  `Balance` INT NULL,
  `UserID` INT NULL,
  PRIMARY KEY (`DepositID`),
  INDEX `fk_Deposits_userID_idx` (`UserID` ASC) VISIBLE,
  CONSTRAINT `fk_Deposits_userID`
    FOREIGN KEY (`UserID`)
    REFERENCES `wakaba_schema`.`Users` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
