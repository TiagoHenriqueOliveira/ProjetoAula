-- MySQL Script generated by MySQL Workbench
-- 11/02/15 16:21:35
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `tb_Pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_Pais` (
  `idPais` INT NOT NULL AUTO_INCREMENT,
  `nomePais` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idPais`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tb_UF`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_UF` (
  `idUF` INT NOT NULL AUTO_INCREMENT,
  `nomeUF` VARCHAR(100) NOT NULL,
  `idPais` INT NOT NULL,
  PRIMARY KEY (`idUF`),
  INDEX `fk_tb_UF_tb_Pais_idx` (`idPais` ASC),
  CONSTRAINT `fk_tb_UF_tb_Pais`
    FOREIGN KEY (`idPais`)
    REFERENCES `tb_Pais` (`idPais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tb_Cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_Cidade` (
  `idCidade` INT NOT NULL AUTO_INCREMENT,
  `nomeCidade` VARCHAR(100) NOT NULL,
  `idUF` INT NOT NULL,
  PRIMARY KEY (`idCidade`),
  INDEX `fk_tb_Cidade_tb_UF1_idx` (`idUF` ASC),
  CONSTRAINT `fk_tb_Cidade_tb_UF1`
    FOREIGN KEY (`idUF`)
    REFERENCES `tb_UF` (`idUF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tb_Empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_Empresa` (
  `idEmpresa` INT NOT NULL AUTO_INCREMENT,
  `razaoSocialEmpresa` VARCHAR(100) NOT NULL,
  `nomeFantasiaEmpresa` VARCHAR(100) NOT NULL,
  `cnpjEmpresa` VARCHAR(19) NOT NULL,
  `inscricaoEstadualEmpresa` VARCHAR(17) NULL,
  `inscricaoMunicipalEmpresa` VARCHAR(17) NULL,
  `enderecoEmpresa` VARCHAR(100) NOT NULL,
  `bairroEmpresa` VARCHAR(100) NOT NULL,
  `numeroEmpresa` INT NOT NULL,
  `telefoneComercialEmpresa` VARCHAR(12) NULL,
  `telefoneCelularEmpresa` VARCHAR(12) NULL,
  `faxEmpresa` VARCHAR(12) NULL,
  `emailEmpresa` VARCHAR(100) NOT NULL,
  `regimeTributario` INT NOT NULL,
  `empresaForaUso` TINYINT(1) NOT NULL,
  `dataAlteracaoEmpresa` DATE NOT NULL,
  `idCidade` INT NOT NULL,
  PRIMARY KEY (`idEmpresa`),
  UNIQUE INDEX `cnpjEmpresa_UNIQUE` (`cnpjEmpresa` ASC),
  UNIQUE INDEX `inscricaoEstadualEmpresa_UNIQUE` (`inscricaoEstadualEmpresa` ASC),
  UNIQUE INDEX `inscricaoMunicipalEmpresa_UNIQUE` (`inscricaoMunicipalEmpresa` ASC),
  INDEX `fk_tb_Empresa_tb_Cidade1_idx` (`idCidade` ASC),
  CONSTRAINT `fk_tb_Empresa_tb_Cidade1`
    FOREIGN KEY (`idCidade`)
    REFERENCES `tb_Cidade` (`idCidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tb_Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nomeUsuario` VARCHAR(100) NOT NULL,
  `loginUsuario` VARCHAR(100) NOT NULL,
  `senhaUsuario` VARCHAR(15) NOT NULL,
  `usuarioForaUso` TINYINT(1) NOT NULL,
  `dataAlteracaoUsuario` DATE NOT NULL,
  `idEmpresa` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `loginUsuario_UNIQUE` (`loginUsuario` ASC),
  INDEX `fk_tb_Usuario_tb_Empresa1_idx` (`idEmpresa` ASC),
  CONSTRAINT `fk_tb_Usuario_tb_Empresa1`
    FOREIGN KEY (`idEmpresa`)
    REFERENCES `tb_Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tb_TipoServico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_TipoServico` (
  `id_TipoServico` INT NOT NULL AUTO_INCREMENT,
  `nomeTipoServico` VARCHAR(100) NOT NULL,
  `valorTipoServico` DOUBLE(10,2) NOT NULL,
  `tipoServicoForaUso` TINYINT(1) NOT NULL,
  `dataAltercacaoTipoServico` DATE NOT NULL,
  PRIMARY KEY (`id_TipoServico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tb_Marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_Marca` (
  `idMarca` INT NOT NULL AUTO_INCREMENT,
  `nomeMarca` VARCHAR(100) NOT NULL,
  `marcaForaUso` TINYINT(1) NOT NULL,
  `dataAlteracaoMarca` DATE NOT NULL,
  PRIMARY KEY (`idMarca`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tb_Modelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_Modelo` (
  `idModelo` INT NOT NULL AUTO_INCREMENT,
  `nomeModelo` VARCHAR(100) NOT NULL,
  `modeloForaUso` TINYINT(1) NOT NULL,
  `dataAlteracaoModelo` DATE NOT NULL,
  `idMarca` INT NOT NULL,
  PRIMARY KEY (`idModelo`),
  INDEX `fk_tb_Modelo_tb_Marca1_idx` (`idMarca` ASC),
  CONSTRAINT `fk_tb_Modelo_tb_Marca1`
    FOREIGN KEY (`idMarca`)
    REFERENCES `tb_Marca` (`idMarca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tb_Carro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_Carro` (
  `idCarro` INT NOT NULL AUTO_INCREMENT,
  `nomeCarro` VARCHAR(100) NOT NULL,
  `placaCarro` VARCHAR(8) NOT NULL,
  `CarroForaUso` TINYINT(1) NOT NULL,
  `dataAlteracaoCarro` DATE NOT NULL,
  `idModelo` INT NOT NULL,
  PRIMARY KEY (`idCarro`),
  UNIQUE INDEX `placaCarro_UNIQUE` (`placaCarro` ASC),
  INDEX `fk_tb_Carro_tb_Modelo1_idx` (`idModelo` ASC),
  CONSTRAINT `fk_tb_Carro_tb_Modelo1`
    FOREIGN KEY (`idModelo`)
    REFERENCES `tb_Modelo` (`idModelo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tb_Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `enderecoCliente` VARCHAR(100) NOT NULL,
  `bairroCliente` VARCHAR(100) NOT NULL,
  `numeroCliente` INT NOT NULL,
  `telefoneComercialCliente` VARCHAR(12) NULL,
  `telefoneCelularCliente` VARCHAR(12) NULL,
  `emailCliente` VARCHAR(100) NOT NULL,
  `ClienteForaUso` TINYINT(1) NOT NULL,
  `dataAlteracaoCliente` DATE NOT NULL,
  `idCidade` INT NOT NULL,
  `idEmpresa` INT NOT NULL,
  `idCarro` INT NOT NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `fk_tb_Cliente_tb_Cidade1_idx` (`idCidade` ASC),
  INDEX `fk_tb_Cliente_tb_Empresa1_idx` (`idEmpresa` ASC),
  INDEX `fk_tb_Cliente_tb_Carro1_idx` (`idCarro` ASC),
  CONSTRAINT `fk_tb_Cliente_tb_Cidade1`
    FOREIGN KEY (`idCidade`)
    REFERENCES `tb_Cidade` (`idCidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_Cliente_tb_Empresa1`
    FOREIGN KEY (`idEmpresa`)
    REFERENCES `tb_Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_Cliente_tb_Carro1`
    FOREIGN KEY (`idCarro`)
    REFERENCES `tb_Carro` (`idCarro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tb_OrdemServico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_OrdemServico` (
  `idOrdemServico` INT NOT NULL AUTO_INCREMENT,
  `valorTotalOrdemServico` DOUBLE(10,2) NOT NULL,
  `OrdemServicoCancelada` TINYINT(1) NOT NULL,
  `dataAgendamentoOrdemServico` DATE NOT NULL,
  `dataAlteracaoOrdemServico` DATE NOT NULL,
  `idCliente` INT NOT NULL,
  PRIMARY KEY (`idOrdemServico`),
  INDEX `fk_tb_OrdemServico_tb_Cliente1_idx` (`idCliente` ASC),
  CONSTRAINT `fk_tb_OrdemServico_tb_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `tb_Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tb_ItemOrdemServico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_ItemOrdemServico` (
  `idItemOrdemServico` INT NOT NULL AUTO_INCREMENT,
  `idOrdemServico` INT NOT NULL,
  `idTipoServico` INT NOT NULL,
  `valorUnitarioItemOrdemServico` DOUBLE(10,2) NOT NULL,
  `quantidadeItemOrdemServico` INT NOT NULL,
  `observacaoItemOrdemServico` VARCHAR(500) NULL,
  PRIMARY KEY (`idItemOrdemServico`, `idOrdemServico`, `idTipoServico`),
  INDEX `fk_tb_OrdemServico_has_tb_TipoServico_tb_TipoServico1_idx` (`idTipoServico` ASC),
  INDEX `fk_tb_OrdemServico_has_tb_TipoServico_tb_OrdemServico1_idx` (`idOrdemServico` ASC),
  CONSTRAINT `fk_tb_OrdemServico_has_tb_TipoServico_tb_OrdemServico1`
    FOREIGN KEY (`idOrdemServico`)
    REFERENCES `tb_OrdemServico` (`idOrdemServico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_OrdemServico_has_tb_TipoServico_tb_TipoServico1`
    FOREIGN KEY (`idTipoServico`)
    REFERENCES `tb_TipoServico` (`id_TipoServico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tb_PessoaFisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_PessoaFisica` (
  `nomeCliente` VARCHAR(100) NOT NULL,
  `cpfCliente` VARCHAR(14) NOT NULL,
  `rgCliente` VARCHAR(12) NOT NULL,
  `idCliente` INT NOT NULL,
  UNIQUE INDEX `rgCliente_UNIQUE` (`rgCliente` ASC),
  UNIQUE INDEX `cpfCliente_UNIQUE` (`cpfCliente` ASC),
  INDEX `fk_tb_PessoaFisica_tb_Cliente1_idx` (`idCliente` ASC),
  CONSTRAINT `fk_tb_PessoaFisica_tb_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `tb_Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tb_PessoaJuridica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_PessoaJuridica` (
  `razaoSocialCliente` VARCHAR(100) NOT NULL,
  `nomeFantasiaCliente` VARCHAR(100) NOT NULL,
  `cnpjCliente` VARCHAR(19) NOT NULL,
  `inscricaoEstadualCliente` VARCHAR(17) NULL,
  `inscricaoMunicipalCliente` VARCHAR(17) NULL,
  `idCliente` INT NOT NULL,
  UNIQUE INDEX `cnpjCliente_UNIQUE` (`cnpjCliente` ASC),
  UNIQUE INDEX `inscricaoEstadualCliente_UNIQUE` (`inscricaoEstadualCliente` ASC),
  UNIQUE INDEX `inscricaoMunicipalCliente_UNIQUE` (`inscricaoMunicipalCliente` ASC),
  INDEX `fk_tb_PessoaJuridica_tb_Cliente1_idx` (`idCliente` ASC),
  CONSTRAINT `fk_tb_PessoaJuridica_tb_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `tb_Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
