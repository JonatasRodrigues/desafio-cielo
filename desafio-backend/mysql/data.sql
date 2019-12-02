DROP SCHEMA IF EXISTS desafio_db;

CREATE SCHEMA IF NOT EXISTS desafio_db;
USE desafio_db;

CREATE TABLE domicilio_bancario(
dbo_id INT not null AUTO_INCREMENT,
dbo_nm_banco VARCHAR(100) NOT NULL,
dbo_num_agencia INT NOT NULL,
dbo_num_conta_corrente INT NOT NULL,
constraint pk_banco PRIMARY KEY (dbo_id));

CREATE TABLE tipo_operacao(
top_id INT not null AUTO_INCREMENT,
top_descricao VARCHAR(20) NOT NULL,
constraint pk_tipo_operacao PRIMARY KEY (top_id));

CREATE TABLE situacao_remessa(
sre_id INT not null AUTO_INCREMENT,
sre_descricao VARCHAR(20) NOT NULL,
constraint pk_situacao_remessa PRIMARY KEY (sre_id));

CREATE TABLE remessa(
rem_id INT not null AUTO_INCREMENT,
sre_id INT NOT NULL,
rem_num_remessa BIGINT NOT NULL,
rem_qtd_remessa INT NOT NULL,
rem_vlr_remessa DECIMAL(10, 2),
constraint pk_remessa PRIMARY KEY (rem_id),
constraint fk_situacao_remessa FOREIGN KEY (sre_id) REFERENCES situacao_remessa(sre_id));

CREATE TABLE cliente(
cli_id INT not null AUTO_INCREMENT,
cli_nm_raiz_cnpj VARCHAR(8) NULL,
cli_nm_sufixo_cnpj VARCHAR(4) NULL,
dbo_id INT not null,
constraint pk_cliente PRIMARY KEY (cli_id),
constraint fk_domicilio_bancario FOREIGN KEY (dbo_id) REFERENCES domicilio_bancario(dbo_id));

CREATE TABLE lancamento(
lan_id INT NOT NULL AUTO_INCREMENT,
cli_id INT NOT NULL,
top_id INT NOT NULL,
rem_id INT not null,
lan_num_evento BIGINT NOT NULL,
lan_desc_grupo_pagamento VARCHAR(100) NOT NULL,
lan_cod_unico VARCHAR(10) NULL,
lan_dt_efetiva DATE,
lan_dt_lancamento_conta_corrente DATE,
constraint pk_lancamento PRIMARY KEY (lan_id),
constraint fk_cliente FOREIGN KEY (cli_id) REFERENCES cliente(cli_id),
constraint fk_remessa FOREIGN KEY (rem_id) REFERENCES remessa(rem_id),
constraint fk_tipo_operacao FOREIGN KEY (top_id) REFERENCES tipo_operacao(top_id));

insert into domicilio_bancario values (1, "BANCO ABCD S.A.", 1, "00000000065470");

insert into tipo_operacao values (1, "Regular");
insert into tipo_operacao values (2, "Normal");

insert into situacao_remessa values (1, "Pendente");
insert into situacao_remessa values (2, "Pago");

insert into remessa values (1, 2, 64320236054, 22, 11499.1);
insert into remessa values (2, 2, 64320236054, 2, 1960);

insert into cliente values (1, "12996721", "1597", 1);
insert into cliente values (2, "12996721", "1597", 1);

insert into lancamento values (1, 1, 1, 1, 42236790, "LA-56", "1", STR_TO_DATE( "03/06/2016", "%d/%m/%Y" ),  STR_TO_DATE( "03/06/2016", "%d/%m/%Y" ));
insert into lancamento values (2, 2, 1, 2, 42236790, "LA-56", "25", STR_TO_DATE( "02/06/2016", "%d/%m/%Y" ),  STR_TO_DATE( "02/06/2016", "%d/%m/%Y" ));

COMMIT;