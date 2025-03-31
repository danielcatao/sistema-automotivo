CREATE TABLE modelo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    marca_id BIGINT,
    FOREIGN KEY (marca_id) REFERENCES marca(id)
);