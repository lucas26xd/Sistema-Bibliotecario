-- MySQL Script generated by MySQL Workbench
-- seg 29 out 2018 15:28:04 -03
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema equipe378981
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `equipe378981` ;

-- -----------------------------------------------------
-- Schema equipe378981
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `equipe378981` ;
USE `equipe378981` ;

-- -----------------------------------------------------
-- Table `equipe378981`.`autores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipe378981`.`autores` ;

CREATE TABLE IF NOT EXISTS `equipe378981`.`autores` (
  `nome` VARCHAR(45) NOT NULL,
  `CPF` CHAR(11) NOT NULL,
  `nacionalidade` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CPF`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipe378981`.`categorias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipe378981`.`categorias` ;

CREATE TABLE IF NOT EXISTS `equipe378981`.`categorias` (
  `codigo` INT NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipe378981`.`livros`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipe378981`.`livros` ;

CREATE TABLE IF NOT EXISTS `equipe378981`.`livros` (
  `isbn` BIGINT(13) NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `ano_lancamento` INT(4) NOT NULL,
  `editora` VARCHAR(45) NOT NULL,
  `qtd_copias` INT NOT NULL,
  `codigo_categoria` INT NOT NULL,
  PRIMARY KEY (`isbn`),
  INDEX `fk_livros_categorias1_idx` (`codigo_categoria` ASC) ,
  CONSTRAINT `fk_livros_categorias1`
    FOREIGN KEY (`codigo_categoria`)
    REFERENCES `equipe378981`.`categorias` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipe378981`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipe378981`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `equipe378981`.`usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `endereço` VARCHAR(45) NOT NULL,
  `tipo_usuario` ENUM("administrador", "bibliotecario", "alunos", "professores", "funcionarios") NOT NULL,
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) ,
  UNIQUE INDEX `endereço_UNIQUE` (`endereço` ASC) ,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipe378981`.`curso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipe378981`.`curso` ;

CREATE TABLE IF NOT EXISTS `equipe378981`.`curso` (
  `cod_curso` INT NOT NULL,
  `nome_curso` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cod_curso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipe378981`.`alunos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipe378981`.`alunos` ;

CREATE TABLE IF NOT EXISTS `equipe378981`.`alunos` (
  `matricula` INT NOT NULL,
  `data_ingresso` DATE NOT NULL,
  `data_conclusao` DATE NOT NULL,
  `cod_curso` INT NOT NULL,
  `id_usuario` INT NOT NULL,
  INDEX `fk_alunos_curso1_idx` (`cod_curso` ASC) ,
  UNIQUE INDEX `matricula_UNIQUE` (`matricula` ASC) ,
  PRIMARY KEY (`id_usuario`),
  INDEX `fk_alunos_usuarios1_idx` (`id_usuario` ASC) ,
  CONSTRAINT `fk_alunos_curso1`
    FOREIGN KEY (`cod_curso`)
    REFERENCES `equipe378981`.`curso` (`cod_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alunos_usuarios1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `equipe378981`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipe378981`.`professsores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipe378981`.`professsores` ;

CREATE TABLE IF NOT EXISTS `equipe378981`.`professsores` (
  `mat_siape` INT NOT NULL,
  `telefone_celular` VARCHAR(11) NOT NULL,
  `regime_trabalho` ENUM("20h", "40h", "DE") NOT NULL,
  `data_contratacao` DATE NOT NULL,
  `cod_curso` INT NOT NULL,
  `id_usuario` INT NOT NULL,
  INDEX `fk_professsores_curso1_idx` (`cod_curso` ASC) ,
  UNIQUE INDEX `mat_siape_UNIQUE` (`mat_siape` ASC) ,
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `fk_professsores_curso1`
    FOREIGN KEY (`cod_curso`)
    REFERENCES `equipe378981`.`curso` (`cod_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_professsores_usuarios1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `equipe378981`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipe378981`.`funcionarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipe378981`.`funcionarios` ;

CREATE TABLE IF NOT EXISTS `equipe378981`.`funcionarios` (
  `matricula` INT NOT NULL,
  `id_usuario` INT NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `matricula_UNIQUE` (`matricula` ASC) ,
  INDEX `fk_funcionarios_usuarios1_idx` (`id_usuario` ASC) ,
  CONSTRAINT `fk_funcionarios_usuarios1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `equipe378981`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipe378981`.`telefones_funcionarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipe378981`.`telefones_funcionarios` ;

CREATE TABLE IF NOT EXISTS `equipe378981`.`telefones_funcionarios` (
  `telefone_funcionario` VARCHAR(11) NOT NULL,
  `id_funcionario` INT NOT NULL,
  PRIMARY KEY (`telefone_funcionario`, `id_funcionario`),
  INDEX `fk_telefones_funcionarios_funcionarios1_idx` (`id_funcionario` ASC) ,
  CONSTRAINT `fk_telefones_funcionarios_funcionarios1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `equipe378981`.`funcionarios` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipe378981`.`telefones_alunos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipe378981`.`telefones_alunos` ;

CREATE TABLE IF NOT EXISTS `equipe378981`.`telefones_alunos` (
  `telefone_aluno` VARCHAR(11) NOT NULL,
  `id_aluno` INT NOT NULL,
  PRIMARY KEY (`telefone_aluno`, `id_aluno`),
  INDEX `fk_telefones_alunos_alunos1_idx` (`id_aluno` ASC) ,
  CONSTRAINT `fk_telefones_alunos_alunos1`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `equipe378981`.`alunos` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipe378981`.`livros_tem_autores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipe378981`.`livros_tem_autores` ;

CREATE TABLE IF NOT EXISTS `equipe378981`.`livros_tem_autores` (
  `isbn_livro` BIGINT(13) NOT NULL,
  `CPF_autor` CHAR(11) NOT NULL,
  PRIMARY KEY (`isbn_livro`, `CPF_autor`),
  INDEX `fk_autores_has_livros_livros1_idx` (`isbn_livro` ASC) ,
  INDEX `fk_autores_has_livros_autores1_idx` (`CPF_autor` ASC) ,
  CONSTRAINT `fk_autores_has_livros_autores1`
    FOREIGN KEY (`CPF_autor`)
    REFERENCES `equipe378981`.`autores` (`CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_autores_has_livros_livros1`
    FOREIGN KEY (`isbn_livro`)
    REFERENCES `equipe378981`.`livros` (`isbn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipe378981`.`reserva`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipe378981`.`reserva` ;

CREATE TABLE IF NOT EXISTS `equipe378981`.`reserva` (
  `usuarios_id` INT NOT NULL,
  `isbn_livro` BIGINT(13) NOT NULL,
  `data` DATE NOT NULL,
  `data_entrega` DATE NOT NULL,
  PRIMARY KEY (`usuarios_id`, `isbn_livro`, `data`),
  INDEX `fk_usuarios_has_livros_livros1_idx` (`isbn_livro` ASC) ,
  INDEX `fk_reserva_usuarios1_idx` (`usuarios_id` ASC) ,
  CONSTRAINT `fk_usuarios_has_livros_livros1`
    FOREIGN KEY (`isbn_livro`)
    REFERENCES `equipe378981`.`livros` (`isbn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_usuarios1`
    FOREIGN KEY (`usuarios_id`)
    REFERENCES `equipe378981`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `equipe378981`.`autores`
-- -----------------------------------------------------
START TRANSACTION;
USE `equipe378981`;
INSERT INTO `equipe378981`.`autores` (`nome`, `CPF`, `nacionalidade`) VALUES ('Rafael C. Gonzalez', '34587698809', 'Colombiano');

COMMIT;


-- -----------------------------------------------------
-- Data for table `equipe378981`.`categorias`
-- -----------------------------------------------------
START TRANSACTION;
USE `equipe378981`;
INSERT INTO `equipe378981`.`categorias` (`codigo`, `descricao`) VALUES (01, 'Computação');
INSERT INTO `equipe378981`.`categorias` (`codigo`, `descricao`) VALUES (02, 'Elétrica');
INSERT INTO `equipe378981`.`categorias` (`codigo`, `descricao`) VALUES (03, 'Música');
INSERT INTO `equipe378981`.`categorias` (`codigo`, `descricao`) VALUES (04, 'Psicologia');
INSERT INTO `equipe378981`.`categorias` (`codigo`, `descricao`) VALUES (05, 'Medicina');

COMMIT;


-- -----------------------------------------------------
-- Data for table `equipe378981`.`livros`
-- -----------------------------------------------------
START TRANSACTION;
USE `equipe378981`;
INSERT INTO `equipe378981`.`livros` (`isbn`, `titulo`, `ano_lancamento`, `editora`, `qtd_copias`, `codigo_categoria`) VALUES (8673409846112, 'Processamento Digital de Imagens', 2010, 'Pearson', 7, 01);

COMMIT;


-- -----------------------------------------------------
-- Data for table `equipe378981`.`usuarios`
-- -----------------------------------------------------
START TRANSACTION;
USE `equipe378981`;
INSERT INTO `equipe378981`.`usuarios` (`id`, `login`, `senha`, `nome`, `endereço`, `tipo_usuario`) VALUES (1, 'Admin', 'e96857c58f716104caead648ee6aa61ab8e41cdc', 'Josivaldo Sousa', 'Rua Carlos Andrade, 12', 'administrador');
INSERT INTO `equipe378981`.`usuarios` (`id`, `login`, `senha`, `nome`, `endereço`, `tipo_usuario`) VALUES (2, 'carmemC', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'Carmem Lucia', 'Rua Alberto Nobrega, 14', 'bibliotecario');
INSERT INTO `equipe378981`.`usuarios` (`id`, `login`, `senha`, `nome`, `endereço`, `tipo_usuario`) VALUES (3, 'angelam', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'Angela Magalhães', 'Av. Dr. Guarany, 2', 'alunos');
INSERT INTO `equipe378981`.`usuarios` (`id`, `login`, `senha`, `nome`, `endereço`, `tipo_usuario`) VALUES (4, 'fernandoR', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'Fernando Rodrigues', 'Rua José Alberto, 500', 'professores');
INSERT INTO `equipe378981`.`usuarios` (`id`, `login`, `senha`, `nome`, `endereço`, `tipo_usuario`) VALUES (5, 'michelleM', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'Michelle Sousa', 'Av. Dom José, 32', 'funcionarios');

COMMIT;


-- -----------------------------------------------------
-- Data for table `equipe378981`.`curso`
-- -----------------------------------------------------
START TRANSACTION;
USE `equipe378981`;
INSERT INTO `equipe378981`.`curso` (`cod_curso`, `nome_curso`) VALUES (0001, 'Engenharia da Computação');
INSERT INTO `equipe378981`.`curso` (`cod_curso`, `nome_curso`) VALUES (0002, 'Engenharia Elétrica');
INSERT INTO `equipe378981`.`curso` (`cod_curso`, `nome_curso`) VALUES (0003, 'Música');
INSERT INTO `equipe378981`.`curso` (`cod_curso`, `nome_curso`) VALUES (0004, 'Psicologia');
INSERT INTO `equipe378981`.`curso` (`cod_curso`, `nome_curso`) VALUES (0005, 'Medicina');

COMMIT;


-- -----------------------------------------------------
-- Data for table `equipe378981`.`alunos`
-- -----------------------------------------------------
START TRANSACTION;
USE `equipe378981`;
INSERT INTO `equipe378981`.`alunos` (`matricula`, `data_ingresso`, `data_conclusao`, `cod_curso`, `id_usuario`) VALUES (378981, '2015-03-08', '2020-03-08', 0001, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `equipe378981`.`professsores`
-- -----------------------------------------------------
START TRANSACTION;
USE `equipe378981`;
INSERT INTO `equipe378981`.`professsores` (`mat_siape`, `telefone_celular`, `regime_trabalho`, `data_contratacao`, `cod_curso`, `id_usuario`) VALUES (45673, '88999112233', '40h', '2007-12-01', 0001, 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `equipe378981`.`funcionarios`
-- -----------------------------------------------------
START TRANSACTION;
USE `equipe378981`;
INSERT INTO `equipe378981`.`funcionarios` (`matricula`, `id_usuario`) VALUES (43267, 5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `equipe378981`.`telefones_funcionarios`
-- -----------------------------------------------------
START TRANSACTION;
USE `equipe378981`;
INSERT INTO `equipe378981`.`telefones_funcionarios` (`telefone_funcionario`, `id_funcionario`) VALUES ('88996633445', 5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `equipe378981`.`telefones_alunos`
-- -----------------------------------------------------
START TRANSACTION;
USE `equipe378981`;
INSERT INTO `equipe378981`.`telefones_alunos` (`telefone_aluno`, `id_aluno`) VALUES ('88999203298', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `equipe378981`.`livros_tem_autores`
-- -----------------------------------------------------
START TRANSACTION;
USE `equipe378981`;
INSERT INTO `equipe378981`.`livros_tem_autores` (`isbn_livro`, `CPF_autor`) VALUES (8673409846112, '34587698809');

COMMIT;


-- -----------------------------------------------------
-- Data for table `equipe378981`.`reserva`
-- -----------------------------------------------------
START TRANSACTION;
USE `equipe378981`;
INSERT INTO `equipe378981`.`reserva` (`usuarios_id`, `isbn_livro`, `data`, `data_entrega`) VALUES (3, 8673409846112, '2018-03-10', '2018-11-11');

COMMIT;
