CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome_completo VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    celular VARCHAR(25) UNIQUE,
    data_nascimento DATE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    primeiro_login INT NOT NULL DEFAULT 0,
    ativo INT NOT NULL DEFAULT 1,
    email_verificado INT NOT NULL DEFAULT 0
);

CREATE TABLE endereco (
    id INT PRIMARY KEY AUTO_INCREMENT,
    estado VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    bairro VARCHAR(255),
    numero VARCHAR(255) NOT NULL,
    complemento VARCHAR(255),
    cep VARCHAR(255) NOT NULL,
    id_usuario INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

CREATE TABLE cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo_contrato INT NOT NULL DEFAULT 0,
    id_usuario INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

CREATE TABLE funcionario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    rgcpf VARCHAR(25) NOT NULL UNIQUE,
    data_contratado DATE NOT NULL,
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

CREATE TABLE roles (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO roles (nome) VALUES ('CLIENTE');
INSERT INTO roles (nome) VALUES ('FUNCIONARIO');
INSERT INTO roles (nome) VALUES ('ADMIN');

CREATE TABLE usuarios_roles (
    id_role INT,
    id_usuario INT,
    PRIMARY KEY (id_role, id_usuario) -- adicionado PRIMARY KEY para definir a chave primária composta
);

CREATE TABLE consultas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT,
    id_funcionario INT NOT NULL,
    data_consulta DATE NOT NULL,
    remarcada INT NOT NULL DEFAULT 0,
    ativo INT NOT NULL DEFAULT 1,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id), -- id_cliente referencia a tabela cliente
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id) -- id_funcionario referencia a tabela funcionario
);

CREATE TABLE especialidade (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE funcionarios_especialidade (
    id_especialidade INT,
    id_funcionario INT,
    PRIMARY KEY (id_especialidade, id_funcionario) -- adicionado PRIMARY KEY para definir a chave primária composta
);

ALTER TABLE usuarios_roles
    ADD FOREIGN KEY(id_role) REFERENCES roles(id), -- id_role referencia a tabela roles
    ADD FOREIGN KEY(id_usuario) REFERENCES usuarios(id);

ALTER TABLE consultas
    ADD FOREIGN KEY(id_cliente) REFERENCES cliente(id), -- id_cliente referencia a tabela cliente
    ADD FOREIGN KEY(id_funcionario) REFERENCES funcionario(id); -- id_funcionario referencia a tabela funcionario

ALTER TABLE funcionarios_especialidade
    ADD FOREIGN KEY(id_especialidade) REFERENCES especialidade(id), -- id_especialidade referencia a tabela especialidade
    ADD FOREIGN KEY(id_funcionario) REFERENCES funcionario(id); -- id_funcionario referencia a tabela funcionario
