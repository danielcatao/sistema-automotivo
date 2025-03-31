ALTER TABLE veiculo
    DROP COLUMN marca,
    DROP COLUMN modelo,
    ADD COLUMN marca_id BIGINT,
    ADD COLUMN modelo_id BIGINT,
    ADD FOREIGN KEY (marca_id) REFERENCES marca(id),
    ADD FOREIGN KEY (modelo_id) REFERENCES modelo(id);