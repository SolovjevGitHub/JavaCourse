-- MySQL Workbench Synchronization
-- Generated: 2017-07-30 01:16
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Сирожа и Маха

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `autoparts_store` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

CREATE TABLE IF NOT EXISTS `autoparts_store`.`car_makes` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `autoparts_store`.`car_models` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `model` VARCHAR(45) NOT NULL COMMENT '',
  `body_code` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `engine_type` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `engine_capacit` FLOAT(11) NULL DEFAULT NULL COMMENT '',
  `power` INT(11) NULL DEFAULT NULL COMMENT '',
  `year_from` INT(11) NULL DEFAULT NULL COMMENT '',
  `year_to` INT(11) NULL DEFAULT NULL COMMENT '',
  `car_makes_id` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_car_models_car_makes_idx` (`car_makes_id` ASC)  COMMENT '',
  CONSTRAINT `fk_car_models_car_makes`
    FOREIGN KEY (`car_makes_id`)
    REFERENCES `autoparts_store`.`car_makes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `autoparts_store`.`autopart_brands` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `autoparts_store`.`autoparts` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `part_number` VARCHAR(45) NOT NULL COMMENT '',
  `note` TINYTEXT NULL DEFAULT NULL COMMENT '',
  `quantity_sold` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `warranty` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `price` FLOAT(11) NULL DEFAULT NULL COMMENT '',
  `autopart_brands_id` INT(11) NOT NULL COMMENT '',
  `part_categories_id` INT(11) NOT NULL COMMENT '',
  `car_models_id` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_autoparts_autopart_brands1_idx` (`autopart_brands_id` ASC)  COMMENT '',
  INDEX `fk_autoparts_part_categories1_idx` (`part_categories_id` ASC)  COMMENT '',
  INDEX `fk_autoparts_car_models1_idx` (`car_models_id` ASC)  COMMENT '',
  CONSTRAINT `fk_autoparts_autopart_brands1`
    FOREIGN KEY (`autopart_brands_id`)
    REFERENCES `autoparts_store`.`autopart_brands` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_autoparts_part_categories1`
    FOREIGN KEY (`part_categories_id`)
    REFERENCES `autoparts_store`.`part_categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_autoparts_car_models1`
    FOREIGN KEY (`car_models_id`)
    REFERENCES `autoparts_store`.`car_models` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `autoparts_store`.`part_categories` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `autoparts_store`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `first_name` VARCHAR(45) NOT NULL COMMENT '',
  `last_name` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `phone_number` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `email` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `unique_key` VARCHAR(45) NOT NULL COMMENT '',
  `user_roles_id` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_users_user_roles1_idx` (`user_roles_id` ASC)  COMMENT '',
  CONSTRAINT `fk_users_user_roles1`
    FOREIGN KEY (`user_roles_id`)
    REFERENCES `autoparts_store`.`user_roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `autoparts_store`.`user_roles` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `autoparts_store`.`orders` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `number` INT(11) NOT NULL COMMENT '',
  `date` DATETIME NULL DEFAULT NULL COMMENT '',
  `users_id` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_orders_users1_idx` (`users_id` ASC)  COMMENT '',
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `autoparts_store`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `autoparts_store`.`autoparts_has_orders` (
  `autoparts_id` INT(11) NOT NULL COMMENT '',
  `orders_id` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`autoparts_id`, `orders_id`)  COMMENT '',
  INDEX `fk_autoparts_has_orders_orders1_idx` (`orders_id` ASC)  COMMENT '',
  INDEX `fk_autoparts_has_orders_autoparts1_idx` (`autoparts_id` ASC)  COMMENT '',
  CONSTRAINT `fk_autoparts_has_orders_autoparts1`
    FOREIGN KEY (`autoparts_id`)
    REFERENCES `autoparts_store`.`autoparts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_autoparts_has_orders_orders1`
    FOREIGN KEY (`orders_id`)
    REFERENCES `autoparts_store`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
