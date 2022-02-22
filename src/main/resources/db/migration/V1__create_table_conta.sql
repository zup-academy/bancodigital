CREATE TABLE conta (
  id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  documento_titular varchar(11),
  nome_titular varchar(120),
  agencia int ,
  numero bigint,
  saldo double,
  data_criacao timestamp
);
