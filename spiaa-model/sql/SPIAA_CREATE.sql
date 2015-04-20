-- Bairro
CREATE TABLE bairro(
id BIGSERIAL NOT NULL,
nome VARCHAR(60),
coordenadas TEXT,
PRIMARY KEY (id)
);

--Denuncia
CREATE TABLE denuncia(
id bigserial NOT NULL,
endereco character varying(50),
numero character varying(20),
telefone character varying(20),
irregularidade TEXT,
observacao TEXT,
conclusao TEXT,
status varchar(10),
bairro_fk bigint NOT NULL,
primary key (id)
);

ALTER TABLE  denuncia ADD CONSTRAINT denuncia_bairro_fk
FOREIGN KEY(bairro_fk)REFERENCES bairro(id); 

--Estrato
CREATE TABLE quarteirao(
id BIGSERIAL NOT NULL,
Descricao VARCHAR (10),
bairro_fk bigint NOT NULL,
PRIMARY KEY (id)
);

ALTER TABLE  quarteirao ADD CONSTRAINT quarteirao_bairro_fk
FOREIGN KEY(bairro_fk)REFERENCES bairro(id); 

--Estrato
CREATE TABLE estrato(
id BIGSERIAL NOT NULL,
nome VARCHAR (30),
PRIMARY KEY (id)
);

--Bairro Estrato
CREATE TABLE bairro_estrato(
bairro_fk BIGINT NOT NULL,
estrato_Fk BIGINT NOT NULL,
codigo integer,
armazem integer,
residencia integer ,
imovel integer ,
comercio integer ,
predio integer,
terreno_baldio integer,
habitante integer,
outros integer,
ultima_atualizacao TIMESTAMP
);

ALTER TABLE  bairro_estrato ADD CONSTRAINT bairro_estrato_bairro_fk
FOREIGN KEY(bairro_fk)REFERENCES bairro(id); 

ALTER TABLE  bairro_estrato ADD CONSTRAINT bairro_estrato_estrato_fk
FOREIGN KEY(estrato_fk)REFERENCES estrato(id);  

-- liraa
CREATE TABLE liraa(
id BIGSERIAL NOT NULL,
data_inicio DATE NOT NULL,
data_fim DATE NOT NULL, 
PRIMARY KEY (id)
);

--Consolidacao Dados
CREATE TABLE consolidacao_dados(
id BIGSERIAL NOT NULL,
programados INT NOT NULL,
inspecionados  INT NOT NULL,
terreno_baldio INT NOT NULL,
outros INT NOT NULL,
estrato_fk BIGINT NOT NULL,
liraa_fk BIGINT NOT NULL,
PRIMARY KEY (id)
);

ALTER TABLE  consolidacao_dados ADD CONSTRAINT consolidacao_dados_lira_fk
FOREIGN KEY(liraa_fk)REFERENCES liraa(id); 

ALTER TABLE consolidacao_dados ADD CONSTRAINT conslidacao_dados_estrato_fk
FOREIGN KEY(estrato_fk)REFERENCES estrato(id); 

--Criadouro
CREATE TABLE criadouro(
id BIGSERIAL NOT NULL,
grupo VARCHAR(5),
recipiente TEXT,
PRIMARY KEY (id)
);

-- Consolidacao_criadouro
CREATE TABLE consolidacao_criadouro(
consolidacao_fk bigserial NOT NULL,
criadouro_fk bigserial NOT NULL,
quantidade integer
);

ALTER TABLE  consolidacao_criadouro ADD CONSTRAINT consolidacao_criadouro_consolidacao_fk
FOREIGN KEY(consolidacao_fk)REFERENCES consolidacao_dados(id);  

ALTER TABLE  consolidacao_criadouro ADD CONSTRAINT consolidacao_criadouro_criadouro_fk
FOREIGN KEY(criadouro_fk)REFERENCES criadouro(id); 

-- USUARIO
CREATE TABLE usuario(
id bigserial not null,
nome varchar(100) not null,
usuario varchar(100) not null,
senha varchar(50) not null,
email varchar(200) not null,
tipo varchar(3) not null,
primary key (id)
);


--boletim Diario
CREATE TABLE boletim_diario(
id BIGSERIAL NOT NULL,
data_boletim DATE NOT NULL,
numero VARCHAR(10),
semana_epidemiologica varchar(10),
numero_atividade varchar(6),
tipo_atividade varchar(6),
turma varchar(10),
usuario_fk BIGINT NOT NULL,
bairro_fk BIGINT NOT NULL,
PRIMARY KEY (id)
);

ALTER TABLE  boletim_diario ADD CONSTRAINT boletim_diario_bairro_fk
FOREIGN KEY(bairro_fk)REFERENCES bairro(id); 

ALTER TABLE  boletim_diario ADD CONSTRAINT boletim_diario_agente_fk
FOREIGN KEY(usuario_fk)REFERENCES usuario(id); 


--Tipo de imovel
CREATE TABLE tipo_imovel(
id BIGSERIAL NOT NULL,
sigla VARCHAR(5),
descricao VARCHAR (30),
PRIMARY KEY (id)
);

--Inseticida
CREATE TABLE inseticida(
id BIGSERIAL NOT NULL,
nome VARCHAR (30),
PRIMARY KEY (id)
);

--Atividade
CREATE TABLE atividade(
id BIGSERIAL NOT NULL,
rua varchar(80),
numero VARCHAR(10),
observacao VARCHAR(15),
inspecionado Integer,
tipo_imovel_fk BIGINT NOT NULL,
boletim_fk BIGINT NOT NULL,
quarteirao_fk bigint NOT NULL,
PRIMARY KEY (id)
);
ALTER TABLE  atividade ADD CONSTRAINT atividade_boletim_fk
FOREIGN KEY(boletim_fk)REFERENCES boletim_diario(id); 

ALTER TABLE  atividade ADD CONSTRAINT atividade_tipo_imovel_fk
FOREIGN KEY(tipo_imovel_fk)REFERENCES tipo_imovel(id); 

ALTER TABLE  atividade ADD CONSTRAINT atividade_quarteirao_fk
FOREIGN KEY(quarteirao_fk)REFERENCES quarteirao(id); 

--Atividade Criadouro
CREATE TABLE atividade_criadouro(
atividade_fk bigserial NOT NULL,
criadouro_fk bigserial NOT NULL,
quantidade integer
);

ALTER TABLE  atividade_criadouro ADD CONSTRAINT atividade_boletim_fk
FOREIGN KEY(atividade_fk)REFERENCES atividade(id); 

ALTER TABLE  atividade_criadouro ADD CONSTRAINT atividade_tipo_imovel_fk
FOREIGN KEY(criadouro_fk)REFERENCES criadouro(id); 

-- Atividade Inseticida
CREATE TABLE atividade_inseticida(
atividade_fk bigserial NOT NULL,
inseticida_fk bigserial NOT NULL,
quantidade integer
);
ALTER TABLE  atividade_inseticida ADD CONSTRAINT atividade_inseticida_atividade_fk
FOREIGN KEY(atividade_fk)REFERENCES atividade(id); 

ALTER TABLE  atividade_inseticida ADD CONSTRAINT atividade_inseticida_inseticida_fk
FOREIGN KEY(inseticida_fk)REFERENCES inseticida(id); 
