create sequence empresa_seq;
create sequence funcionario_seq;
create sequence lancamento_seq;

CREATE TABLE empresa (
  id bigint NOT NULL default nextval('empresa_seq'),
  cnpj character varying(255) NOT NULL,
  data_atualizacao timestamp NOT NULL,
  data_criacao timestamp NOT NULL,
  razao_social character varying(255) NOT NULL,
  CONSTRAINT pk_empresa primary key (id)
) ;

CREATE TABLE funcionario (
  id bigint NOT NULL default nextval('funcionario_seq'),
  cpf character varying(255) NOT NULL,
  data_atualizacao timestamp NOT NULL,
  data_criacao timestamp NOT NULL,
  email character varying(255) NOT NULL,
  nome character varying(255) NOT NULL,
  perfil character varying(255) NOT NULL,
  qtd_horas_almoco float DEFAULT NULL,
  qtd_horas_trabalho_dia float DEFAULT NULL,
  senha character varying(255) NOT NULL,
  valor_hora decimal(19,2) DEFAULT NULL,
  empresa_id bigint DEFAULT NULL,
  CONSTRAINT pk_funcionario primary key (id),
  CONSTRAINT fk_func_empresa foreign key (empresa_id) references empresa (id) on update no action on delete no action
) ;

CREATE TABLE lancamento (
  id bigint NOT NULL default nextval('lancamento_seq'),
  data timestamp NOT NULL,
  data_atualizacao timestamp NOT NULL,
  data_criacao timestamp NOT NULL,
  descricao character varying(255) DEFAULT NULL,
  localizacao character varying(255) DEFAULT NULL,
  tipo character varying(255) NOT NULL,
  funcionario_id bigint DEFAULT NULL,
  CONSTRAINT pk_lancamento primary key (id),
  CONSTRAINT fk_lanc_func foreign key (funcionario_id) references funcionario (id) on update no action on delete no action
) ;
