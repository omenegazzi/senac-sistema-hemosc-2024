CREATE DATABASE IF NOT EXISTS banco_sangue;
USE banco_sangue;

-- Criação da tabela `cidades`
CREATE TABLE IF NOT EXISTS cidades (
    id_cidade INT AUTO_INCREMENT PRIMARY KEY,
    codigo_ibge INT,
    descricao VARCHAR(100),
    uf CHAR(2)
);

-- Inserção de dados na tabela `cidades`
INSERT INTO cidades (codigo_ibge, descricao, uf) VALUES
(1234567, 'Cidade Exemplo 1', 'EX'),
(7654321, 'Cidade Exemplo 2', 'YZ');

-- Criação da tabela `tipos_sanguineos`
CREATE TABLE IF NOT EXISTS tipos_sanguineos (
    id_tipo_sanguineo INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(45),
    fator_rh VARCHAR(45),
    estoque INT,
    estoque_minimo INT
);

-- Inserção de dados na tabela `tipos_sanguineos`
INSERT INTO tipos_sanguineos (descricao, fator_rh, estoque, estoque_minimo) VALUES
('A', 'Positivo', 10, 5),
('B', 'Negativo', 5, 2);

-- Criação da tabela `doadores`
CREATE TABLE IF NOT EXISTS doadores (
    id_doador INT AUTO_INCREMENT PRIMARY KEY,
    id_cidade INT,
    id_tipo_sanguineo INT,
    nome VARCHAR(100),
    endereco VARCHAR(100),
    data_nascimento DATE,
    telefone VARCHAR(45),
    email VARCHAR(45),
    cpf VARCHAR(45),
    FOREIGN KEY (id_cidade) REFERENCES cidades(id_cidade),
    FOREIGN KEY (id_tipo_sanguineo) REFERENCES tipos_sanguineos(id_tipo_sanguineo)
);

-- Inserção de dados na tabela `doadores`
INSERT INTO doadores (id_cidade, id_tipo_sanguineo, nome, endereco, data_nascimento, telefone, email, cpf) VALUES
(1, 1, 'João Silva', 'Rua Exemplo 1', '1980-01-01', '123456789', 'joao@exemplo.com', '123.456.789-00'),
(2, 2, 'Maria Santos', 'Avenida Exemplo 2', '1990-02-02', '987654321', 'maria@exemplo.com', '987.654.321-00');

-- Criação da tabela `agendamento`
CREATE TABLE IF NOT EXISTS agendamento (
    id_agendamento INT AUTO_INCREMENT PRIMARY KEY,
    data DATE,
    hora TIME,
    id_doador INT,
    FOREIGN KEY (id_doador) REFERENCES doadores(id_doador)
);

-- Inserção de dados na tabela `agendamento`
INSERT INTO agendamento (data, hora, id_doador) VALUES
('2023-06-01', '08:00:00', 1),
('2023-06-02', '09:30:00', 2);

-- Criação da tabela `colaboradores`
CREATE TABLE IF NOT EXISTS colaboradores (
    id_colaborador INT AUTO_INCREMENT PRIMARY KEY,
    id_cidade INT,
    nome VARCHAR(100),
    endereco VARCHAR(100),
    funcao VARCHAR(45),
    FOREIGN KEY (id_cidade) REFERENCES cidades(id_cidade)
);

-- Inserção de dados na tabela `colaboradores`
INSERT INTO colaboradores (id_cidade, nome, endereco, funcao) VALUES
(1, 'Ana Souza', 'Rua Trabalho 1', 'Enfermeira'),
(2, 'Carlos Pereira', 'Avenida Trabalho 2', 'Recepcionista');

-- Criação da tabela `doacoes`
CREATE TABLE IF NOT EXISTS doacoes (
    id_doacao INT AUTO_INCREMENT PRIMARY KEY,
    data DATE,
    id_doador INT,
    id_tipo_sanguineo INT,
    id_colaborador INT,
    FOREIGN KEY (id_doador) REFERENCES doadores(id_doador),
    FOREIGN KEY (id_tipo_sanguineo) REFERENCES tipos_sanguineos(id_tipo_sanguineo),
    FOREIGN KEY (id_colaborador) REFERENCES colaboradores(id_colaborador)
);

-- Inserção de dados na tabela `doacoes`
INSERT INTO doacoes (data, id_doador, id_tipo_sanguineo, id_colaborador) VALUES
('2023-06-01', 1, 1, 1),
('2023-06-02', 2, 2, 2);

-- Criação da tabela `entidades`
CREATE TABLE IF NOT EXISTS entidades (
    id_entidade INT AUTO_INCREMENT PRIMARY KEY,
    id_cidade INT,
    nome VARCHAR(100),
    endereco VARCHAR(100),
    FOREIGN KEY (id_cidade) REFERENCES cidades(id_cidade)
);

-- Inserção de dados na tabela `entidades`
INSERT INTO entidades (id_cidade, nome, endereco) VALUES
(1, 'Hospital Exemplo 1', 'Rua Hospital 1'),
(2, 'Clinica Exemplo 2', 'Avenida Clinica 2');

-- Criação da tabela `saida_sangue`
CREATE TABLE IF NOT EXISTS saida_sangue (
    id_saida_sangue INT AUTO_INCREMENT PRIMARY KEY,
    id_entidade INT,
    id_tipo_sanguineo INT,
    data DATETIME,
    quantidade VARCHAR(45),
    FOREIGN KEY (id_entidade) REFERENCES entidades(id_entidade),
    FOREIGN KEY (id_tipo_sanguineo) REFERENCES tipos_sanguineos(id_tipo_sanguineo)
);

-- Inserção de dados na tabela `saida_sangue`
INSERT INTO saida_sangue (id_entidade, id_tipo_sanguineo, data, quantidade) VALUES
(1, 1, '2023-06-01 10:00:00', '2 litros'),
(2, 2, '2023-06-02 11:30:00', '3 litros');

-- Criação da tabela `campanha `
CREATE TABLE campanha (
    id_campanha INT PRIMARY KEY,
    nome VARCHAR(45),
    descricao TEXT,
    data_inicio DATE,
    data_fim DATE
);

-- Criação da tabela `perguntas`
CREATE TABLE IF NOT EXISTS perguntas (
    id_pergunta INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(100)
);

-- Criação da tabela `checklists`
CREATE TABLE IF NOT EXISTS checklists (
    id_checklist INT AUTO_INCREMENT PRIMARY KEY,
	fk_perguntas_id_pergunta INT,
	resposta tinyint,
    FOREIGN KEY (fk_perguntas_id_pergunta) REFERENCES perguntas(id_pergunta)
);

-- Criação da tabela `exames`
CREATE TABLE exames (
id_exame INT PRIMARY KEY ,
fk_doadores_id_doador INT,
doacoes VARCHAR(100),
tipo_exame VARCHAR(100),
resultado VARCHAR(100),
data_exame DATE,
FOREIGN KEY (fk_doadores_id_doador) REFERENCES doadores(id_doador));

INSERT INTO exames (id_exame, fk_doadores_id_doador, doacoes, tipo_exame, resultado, data_exame) VALUES
(1, 1, '0', 'Hemograma', 'Hematócrito, 38 a 52%', '2024-05-09'),
(2, 2, '0', 'Glicemia de jejum', 'Inferior a 99 mg/dL', '2024-06-30');

-- Verificação de tabelas criadas
SHOW TABLES;

-- Verificação de estrutura das tabelas
DESCRIBE cidades;
DESCRIBE doadores;
DESCRIBE tipos_sanguineos;
DESCRIBE agendamento;
DESCRIBE colaboradores;
DESCRIBE doacoes;
DESCRIBE entidades;
DESCRIBE perguntas;
DESCRIBE checklists;
DESCRIBE campanha;
