CREATE TABLE personagem (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(30),
    nacionalidade VARCHAR(30),
    classe VARCHAR(30),
    avatar VARCHAR(100)
);

CREATE TABLE detalhes_personagem (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(30),
    descricao VARCHAR(300),
    fk_personagem_id BIGINT,
    FOREIGN KEY (fk_personagem_id) REFERENCES Personagem (id) ON DELETE CASCADE
);