ALTER TABLE conta_produto ADD CONSTRAINT fk_id_conta_produto
FOREIGN KEY (id_conta) REFERENCES conta(id);