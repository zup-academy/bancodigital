CREATE TABLE conta_produto (
  id_conta bigint ,
  id_produto bigint ,
  data_criacao timestamp null default current_timestamp ,
  constraint pk_conta_produto primary key (id_conta, id_produto)
);