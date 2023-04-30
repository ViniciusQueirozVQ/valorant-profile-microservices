CREATE TABLE Personagem (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(30),
    nacionalidade VARCHAR(30),
    classe VARCHAR(30),
    avatar VARCHAR(100)
);

CREATE TABLE DetalhesPersonagem (
    id BIGSERIAL PRIMARY KEY,
    descricao VARCHAR(100),
    fk_personagem_id BIGINT,
    FOREIGN KEY (fk_personagem_id) REFERENCES Personagem (id) ON DELETE CASCADE
);