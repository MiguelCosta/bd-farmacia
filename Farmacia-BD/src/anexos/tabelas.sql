
CREATE TABLE Contraindicacoes (
  contraindicacao   varchar(8),
  nome              varchar(100),
  descricao         varchar(500),
  
  CONSTRAINT contraindicacoes_pk
    PRIMARY KEY (contraindicacao)
);

CREATE TABLE CodigosPostais ( 
  cod_postal      varchar(8),
  localidade      varchar(100),

  CONSTRAINT codigospostais_pk
    PRIMARY KEY (cod_postal)
);

CREATE TABLE Constituintes (
  constituinte    varchar(8),
  nome            varchar(100),
  descricao       varchar(500),

  CONSTRAINT constituintes_pk
    PRIMARY KEY (constituinte)
);

CREATE TABLE Formatos (
  formato         varchar(8),
  nome            varchar(100),

  CONSTRAINT formatos_pk
    PRIMARY KEY (formato)
);

CREATE TABLE Administracoes (
  administracao   varchar(8),
  nome            varchar(100),
  descricao       varchar(500),

  CONSTRAINT administracoes_pk 
    PRIMARY KEY (administracao)
);

CREATE TABLE Distribuidoras (
  distribuidora     varchar(8),
  nome              varchar(100),
  cod_postal        varchar(8),
  morada            varchar(500),
  telefone          varchar(8),

  CONSTRAINT disttribuidoras_pk
    PRIMARY KEY (distribuidora),
  CONSTRAINT distribuidoras_fk_from_cod_postal
    FOREIGN KEY (cod_postal)
    REFERENCES CodigosPostais (cod_postal)
);

CREATE TABLE (


  CONSTRAINT 
    PRIMARY KEY ()
);


CREATE TABLE (


  CONSTRAINT 
    PRIMARY KEY ()
);

CREATE TABLE (


  CONSTRAINT 
    PRIMARY KEY ()
);