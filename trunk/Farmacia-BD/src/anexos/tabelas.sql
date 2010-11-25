/* a primeira vez que isto for corrido é normal que apresente erros nos drop,
 * visto que as tabelas ainda não existem 
 * o "MIGUEL" é o nome da vossa conta na base de dados 
*/

drop table "MIGUEL"."ADMINISTRACOES"          cascade constraints;
drop table "MIGUEL"."AREAS_TERAPEUTICAS"      cascade constraints;
drop table "MIGUEL"."CODIGOS_POSTAIS"         cascade constraints;
drop table "MIGUEL"."CONSTITUINTES"           cascade constraints;
drop table "MIGUEL"."CONTRAINDICACOES"        cascade constraints;
drop table "MIGUEL"."DISTRIBUIDORAS"          cascade constraints;
drop table "MIGUEL"."FABRICANTES"             cascade constraints;
drop table "MIGUEL"."FAIXAS_ETARIAS"          cascade constraints;
drop table "MIGUEL"."FORMATOS"                cascade constraints;
drop table "MIGUEL"."LISTA_CONSTITUINTES"     cascade constraints;
drop table "MIGUEL"."LISTA_CONTRAINDICACOES"  cascade constraints;
drop table "MIGUEL"."LOTES"                   cascade constraints;
drop table "MIGUEL"."PRODUTOS"                cascade constraints;
drop table "MIGUEL"."TEMPERATURAS"            cascade constraints;

CREATE TABLE contraindicacoes (
  contraindicacao   varchar2(8),
  nome              varchar2(100),
  descricao         varchar2(500),
  
  CONSTRAINT contraindicacoes_pk
    PRIMARY KEY (contraindicacao)
);

CREATE TABLE codigos_postais ( 
  codigo_postal     varchar2(8),
  localidade        varchar2(100),

  CONSTRAINT codigos_postais_pk
    PRIMARY KEY (codigo_postal)
);

CREATE TABLE constituintes (
  constituinte    varchar2(8),
  nome            varchar2(100),
  descricao       varchar2(500),

  CONSTRAINT constituintes_pk
    PRIMARY KEY (constituinte)
);

CREATE TABLE formatos (
  formato         varchar2(8),
  nome            varchar2(100),

  CONSTRAINT formatos_pk
    PRIMARY KEY (formato)
);

CREATE TABLE administracoes (
  administracao   varchar2(8),
  nome            varchar2(100),
  descricao       varchar2(500),

  CONSTRAINT administracoes_pk 
    PRIMARY KEY (administracao)
);

CREATE TABLE distribuidoras (
  distribuidora     varchar2(8),
  nome              varchar2(100),
  codigo_postal     varchar2(8),
  morada            varchar2(500),
  telefone          varchar2(8),

  CONSTRAINT disttribuidoras_pk
    PRIMARY KEY (distribuidora),
  CONSTRAINT distri_fk_codigo_postal
    FOREIGN KEY (codigo_postal)
    REFERENCES codigos_postais (codigo_postal)
);

CREATE TABLE areas_terapeuticas (
  areaterapeutica   varchar2(8),
  nome              varchar2(100),
  descricao         varchar2(500),

  CONSTRAINT areas_terapeuticas_pk
    PRIMARY KEY (areaterapeutica)
);

CREATE TABLE faixas_etarias (
  faixa_etaria    varchar2(8),
  nome            varchar2(100),
  descricao       varchar2(500),

  CONSTRAINT faixas_etarias_pk
    PRIMARY KEY (faixa_etaria)
);

CREATE TABLE temperaturas (
  temperatura     varchar2(8),
  nome            varchar2(100),

  CONSTRAINT temperaturas_pk
    PRIMARY KEY (temperatura)
);

CREATE TABLE lotes (
  lote            varchar2(8),
  validade        date,
  stock           varchar2(8),

  CONSTRAINT lotes_pk 
    PRIMARY KEY (lote)
);

CREATE TABLE fabricantes(
  fabricante    varchar2(8),
  nome          varchar2(100),
  codigo_postal varchar2(8),
  morada        varchar2(100),
  telefone      varchar2(10),

  CONSTRAINT fabricantes_pk 
    PRIMARY KEY (fabricante),
  CONSTRAINT fabricantes_fk_codigo_postal
    FOREIGN KEY (codigo_postal) 
    REFERENCES codigos_postais(codigo_postal)
);

CREATE TABLE produtos (
  produto                 varchar2(8),
  nome                    varchar2(100),
  quantidade              varchar2(20),
  faixa_etaria            varchar2(8),
  reg_infarmed            varchar2(8),
  area_terapeutica        varchar2(8),
  lote                    varchar2(8),
  dosagem                 varchar2(8),
  lista_contraindicacoes  varchar2(8), 
  temperatura             varchar2(8),
  preco                   float,
  administracao           varchar2(8),
  receita                 numeric(1),
  generico                numeric(1),
  formato                 varchar2(8),

  CONSTRAINT produtos_pk
    PRIMARY KEY (produto),
  CONSTRAINT produtos_fk_faixa_etaria
    FOREIGN KEY (faixa_etaria) 
    REFERENCES faixas_etarias (faixa_etaria),
  CONSTRAINT produtos_fk_area_terapeutica
    FOREIGN KEY (area_terapeutica)
    REFERENCES areas_terapeuticas(areaterapeutica),
  CONSTRAINT produtos_fk_lote
    FOREIGN KEY (lote)
    REFERENCES lotes(lote),
  CONSTRAINT produtos_fk_temperatura
    FOREIGN KEY (temperatura)
    REFERENCES temperaturas(temperatura),
  CONSTRAINT produtos_fk_administracao
    FOREIGN KEY (administracao)
    REFERENCES administracoes(administracao),
  CONSTRAINT produtos_fk_formato
    FOREIGN KEY (formato)
    REFERENCES formatos(formato)
);

CREATE TABLE lista_contraindicacoes (
  produto         varchar(8),
  contraindicacao varchar(8),

  CONSTRAINT list_contra_fk_contraindicacao
    FOREIGN KEY (contraindicacao)
    REFERENCES contraindicacoes(contraindicacao)
);

ALTER TABLE lista_contraindicacoes 
  ADD 
    CONSTRAINT lista_contra_fk_produto
    FOREIGN KEY (produto)
    REFERENCES produtos(produto)
;

CREATE TABLE lista_constituintes (
  produto         varchar(8),
  constituinte    varchar(8),
  
  CONSTRAINT lista_consti_fk_produto
    FOREIGN KEY (produto)
    REFERENCES produtos(produto),
  CONSTRAINT lista_consti_fk_constituinte
    FOREIGN KEY (constituinte)
    REFERENCES constituintes(constituinte)
);