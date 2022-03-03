CREATE TABLE produto (
  id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  nome varchar(120),
  valor double,
  tipo_cobranca varchar(30),
  data_criacao timestamp
);