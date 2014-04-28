CREATE DATABASE pmm
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;

CREATE SEQUENCE seq_role
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE SEQUENCE seq_users
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE TABLE USERS(
  id integer NOT NULL DEFAULT nextval('seq_users'::regclass),
  name character varying(100) NOT NULL,
  password character varying(20) NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (id )
);

CREATE UNIQUE INDEX USERS_IDX ON USERS (name);

CREATE TABLE role(
  id integer NOT NULL DEFAULT nextval('seq_role'::regclass),
  permission character varying(100) NOT NULL,
  user_id integer NOT NULL,
  CONSTRAINT user_pkey PRIMARY KEY (id ),
  CONSTRAINT role_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

INSERT INTO USERS (ID,NAME,PASSWORD) VALUES (nextval('seq_users'),'henrique','henrique');
INSERT INTO ROLE (ID,PERMISSION,USER_ID) VALUES (nextval('seq_role'),'ROLE_USER',1);

INSERT INTO USERS (ID,NAME,PASSWORD) VALUES (nextval('seq_users'),'adm','adm');
INSERT INTO ROLE (ID,PERMISSION,USER_ID) VALUES (nextval('seq_role'),'ROLE_ADM',2);

CREATE SEQUENCE SEQ_PACKAGE
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  
CREATE TABLE PACKAGE
(
  id integer NOT NULL DEFAULT nextval('seq_package'::regclass),
  dtpostagem date NOT NULL,
  cepdeorigem character varying(30),
  cepdestino character varying(30),
  tppostagem character varying(30),
  nrpostagem character varying(50),
  pesopostagem character varying(50),
  postagemfaturadapor character varying(50),
  nomedestinatario character varying(50),
  codservico character varying(20),
  diadeentrega integer,
  tempomovimento integer,
  entregacasa boolean,
  entregasabado boolean,
  prazoentrega integer,
  CONSTRAINT us_pkey PRIMARY KEY (id )
);
	
CREATE SEQUENCE SEQ_EVENTO
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE TABLE EVENTO(
	id integer not null default nextval('seq_evento'::regclass),
	tipo varchar(50),
	status integer,
	data date,
	hora varchar(30),
	descricao varchar(50),
	recebedor varchar(50),
	postagemFaturadaPor varchar(50),
	local varchar(50),
	codigo varchar(50),
	cidade varchar(50),
	uf varchar(50),
	sto varchar(50),
	package_id integer,
 	CONSTRAINT usear_pkey PRIMARY KEY (id ),
  	CONSTRAINT role_user_id_fkey FOREIGN KEY (package_id)
     		 REFERENCES PACKAGE (id) MATCH SIMPLE
      		ON UPDATE NO ACTION ON DELETE NO ACTION
);
