-- USUARIO
CREATE TABLE usuario(
id bigserial NOT NULL,
  nome character varying(100) NOT NULL,
  usuario character varying(100) NOT NULL,
  senha character varying(50) NOT NULL,
  email character varying(200) NOT NULL,
  tipo character varying(3) NOT NULL,
  numero character varying(10),
  turma character varying(10),
  CONSTRAINT usuario_pkey PRIMARY KEY (id),
  CONSTRAINT usuario_usuario_uk UNIQUE (usuario)
);
-- Bairro
CREATE TABLE bairro
(
 id bigserial NOT NULL,
 nome character varying(60),
 coordenadas text,
 CONSTRAINT bairro_pkey PRIMARY KEY (id)
);

--Denuncia
CREATE TABLE denuncia
(
  id bigserial NOT NULL,
  endereco character varying(50),
  numero character varying(20),
  telefone character varying(20),
  irregularidade text,
  observacao text,
  conclusao text,
  status character varying(10),
  bairro_fk bigint NOT NULL,
  usuario_fk bigint,
  CONSTRAINT denuncia_pkey PRIMARY KEY (id)
);

ALTER TABLE  denuncia ADD CONSTRAINT denuncia_bairro_fk FOREIGN KEY(bairro_fk)REFERENCES bairro(id); 
ALTER TABLE  denuncia ADD CONSTRAINT denuncia_usuario_fk FOREIGN KEY(usuario_fk)REFERENCES usuario(id); 


--quarteirao
CREATE TABLE quarteirao
(
  id bigserial NOT NULL,
  descricao character varying(10),
  bairro_fk bigint NOT NULL,
  CONSTRAINT quarteirao_pkey PRIMARY KEY (id)
);

ALTER TABLE  quarteirao ADD CONSTRAINT quarteirao_bairro_fk FOREIGN KEY(bairro_fk)REFERENCES bairro(id); 

--Estrato
CREATE TABLE estrato(
id BIGSERIAL NOT NULL,
nome VARCHAR (30),
periodo_tratamento_fk bigint,
PRIMARY KEY (id)
);

ALTER TABLE estrato ADD CONSTRAINT estrato_periodo_tratamento_fk  FOREIGN KEY(periodo_tratamento_fk)REFERENCES periodo_tratamento(id); 

--Bairro Estrato
CREATE TABLE bairro_estrato
(
  bairro_fk bigint NOT NULL,
  estrato_fk bigint NOT NULL,
  codigo integer,
  armazem integer,
  residencia integer,
  imovel integer,
  comercio integer,
  predio integer,
  terreno_baldio integer,
  habitante integer,
  outros integer,
  ultima_atualizacao timestamp without time zone
);

ALTER TABLE  bairro_estrato ADD CONSTRAINT bairro_estrato_bairro_fk FOREIGN KEY(bairro_fk)REFERENCES bairro(id); 
ALTER TABLE  bairro_estrato ADD CONSTRAINT bairro_estrato_estrato_fk FOREIGN KEY(estrato_fk)REFERENCES estrato(id);  

--Criadouro
CREATE TABLE criadouro(
id BIGSERIAL NOT NULL,
grupo VARCHAR(5),
recipiente TEXT,
PRIMARY KEY (id)
);


--Tratamento Anti vetorial
CREATE TABLE tratamento_antivetorial(
id bigserial NOT NULL,
data_boletim date NOT NULL,
numero character varying(10),
semana_epidemiologica character varying(10),
numero_atividade character varying(6),
tipo_atividade character varying(6),
turma character varying(10),
usuario_fk bigint NOT NULL,
bairro_fk bigint NOT NULL,
 CONSTRAINT tratamento_antivetorial_pkey PRIMARY KEY (id)
);

ALTER TABLE  tratamento_antivetorial ADD CONSTRAINT tratamento_antivetorial_bairro_fk
FOREIGN KEY(bairro_fk)REFERENCES bairro(id); 

ALTER TABLE  tratamento_antivetorial ADD CONSTRAINT tratamento_antivetorial_agente_fk
FOREIGN KEY(usuario_fk)REFERENCES usuario(id); 

--Tipo de imovel
CREATE TABLE tipo_imovel(
id BIGSERIAL NOT NULL,
sigla VARCHAR(5),
descricao VARCHAR (30),
CONSTRAINT tipo_imovel_pkey PRIMARY KEY (id)
);

--Inseticida
CREATE TABLE inseticida(
 id bigserial NOT NULL,
 nome character varying(30),
 unidade character varying,
 CONSTRAINT inseticida_pkey PRIMARY KEY (id)
);

--Atividade
CREATE TABLE atividade(
 id bigserial NOT NULL,
 endereco character varying(80),
 numero character varying(10),
 observacao character varying(15),
 inspecionado integer,
 tipo_imovel_fk bigint NOT NULL,
 tratamento_antivetorial_fk bigint NOT NULL,
 quarteirao_fk bigint NOT NULL,
CONSTRAINT atividade_pkey PRIMARY KEY (id)
);

ALTER TABLE  atividade ADD CONSTRAINT atividade_quarteirao_fk
FOREIGN KEY(quarteirao_fk)REFERENCES quarteirao(id); 

ALTER TABLE  atividade ADD CONSTRAINT atividade_tratamento_antivetorial_fk
FOREIGN KEY(tratamento_antivetorial_fk)REFERENCES tratamento_antivetorial(id); 

ALTER TABLE  atividade ADD CONSTRAINT atividade_tipo_imovel_fk
FOREIGN KEY(tipo_imovel_fk)REFERENCES tipo_imovel(id); 

--Atividade Criadouro
CREATE TABLE atividade_criadouro(
atividade_fk bigserial NOT NULL,
criadouro_fk bigserial NOT NULL,
quantidade integer
);

ALTER TABLE  atividade_criadouro ADD CONSTRAINT atividade_criadouro_atividade_fk
FOREIGN KEY(atividade_fk)REFERENCES atividade(id); 

ALTER TABLE  atividade_criadouro ADD CONSTRAINT atividade_criaoduro_criadouro_fk
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

--Ponto Estratégico
CREATE TABLE ponto_estrategico
(
  id bigserial NOT NULL,
  rua character varying,
  numero character varying,
  complemento character varying,
  bairro_fk bigint NOT NULL,
  cidade character varying,
  estado character varying,
  usuario_fk bigint,
  latitude character varying,
  longitude character varying,
  ramo_atividade character varying,
  cep character varying,
  CONSTRAINT pontoestrategico_id_pk PRIMARY KEY (id)
);

ALTER TABLE  ponto_estrategico ADD CONSTRAINT ponto_estrategico_usuario_fk
FOREIGN KEY(usuario_fk)REFERENCES usuario(id); 

ALTER TABLE  ponto_estrategico ADD CONSTRAINT ponto_estrategico_bairro_fk
FOREIGN KEY(bairro_fk)REFERENCES bairro(id); 

CREATE TABLE recupera_senha
(
  id bigserial NOT NULL,
  usuario_fk bigint NOT NULL,
  email character varying NOT NULL,
  token character varying NOT NULL,
  data_pedido timestamp with time zone,
  CONSTRAINT recuperar_senha_id_pk PRIMARY KEY (id)
);

--usuario_bairro
CREATE TABLE usuario_bairro(
usuario_fk bigserial NOT NULL,
bairro_fk bigserial NOT NULL
);

ALTER TABLE  usuario_bairro ADD CONSTRAINT usuario_bairroo_usuario_fk
FOREIGN KEY(usuario_fk)REFERENCES usuario(id); 

ALTER TABLE  usuario_bairro ADD CONSTRAINT usuario_bairro_bairro_fk
FOREIGN KEY(bairro_fk)REFERENCES bairro(id); 

-- parametros
CREATE TABLE parametros(
id bigserial NOT NULL,
hostname character varying  NOT NULL,
porta integer  NOT NULL,
email character varying  NOT NULL,
senha character varying  NOT NULL,
CONSTRAINT parametros_id_pk PRIMARY KEY (id)
);

-- periodo_tratamento
CREATE TABLE periodo_tratamento(
id bigserial NOT NULL,
ano Date NOT NULL,
 CONSTRAINT periodo_tratamento_id_pk PRIMARY KEY (id)
);