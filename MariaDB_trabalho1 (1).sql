--modo de uso, primeiro cria as tabelas, depois adiciona as informações/inserts, 
--e utiliza o select para apresentar as informações bonitinhas.

--**TABELAS**

CREATE TABLE MetodoPagamento ( 
  id_metodo_pagamento INTEGER PRIMARY KEY AUTO_INCREMENT, 
  metodo VARCHAR(30), 
  numero_parcela INTEGER
);

CREATE TABLE Produto ( 
  id_produto INTEGER PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(40),
  descricao TEXT
);

CREATE TABLE Desconto ( 
  id_desconto INTEGER PRIMARY KEY AUTO_INCREMENT,
  produto_id INTEGER,
  desconto_geral DOUBLE,
  desconto_metodo DOUBLE,
  metodo_pagamento_id INTEGER,
  FOREIGN KEY (metodo_pagamento_id) REFERENCES MetodoPagamento(id_metodo_pagamento),
  FOREIGN KEY (produto_id) REFERENCES Produto(id_produto)
);

CREATE TABLE Preco ( 
  id_preco INTEGER PRIMARY KEY AUTO_INCREMENT,
  id_produto INTEGER,
  valor DOUBLE,
  valor_final DOUBLE,
  desconto_id INTEGER,
  metodo_pagamento_id INTEGER,
  FOREIGN KEY (desconto_id) REFERENCES Desconto(id_desconto),
  FOREIGN KEY (metodo_pagamento_id) REFERENCES MetodoPagamento(id_metodo_pagamento),
  FOREIGN KEY (id_produto) REFERENCES Produto(id_produto)
);

CREATE TABLE Usuario (
  id_usuario INTEGER PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(14) UNIQUE NOT NULL
);

CREATE TABLE Avaliacao (
  id_avaliacao INTEGER PRIMARY KEY AUTO_INCREMENT,
  usuario_id INTEGER NOT NULL,
  produto_id INTEGER NOT NULL,
  comentario TEXT,
  nota DOUBLE NOT NULL CHECK (nota >= 0 AND nota <= 10),
  media_avaliacao DOUBLE,
  FOREIGN KEY (usuario_id) REFERENCES Usuario(id_usuario),
  FOREIGN KEY (produto_id) REFERENCES Produto(id_produto)
);

--**INSERTS**

INSERT INTO MetodoPagamento (metodo, numero_parcela) VALUES
('Cartão de Crédito', 12),
('Boleto', 1),
('Pix', 1);

INSERT INTO Produto (nome, descricao) VALUES
('Celular', 'Smartphone de última geração com câmera de alta qualidade'),
('Notebook', 'Laptop potente para trabalho e jogos'),
('Fone de Ouvido', 'Fone sem fio com cancelamento de ruído');

INSERT INTO Desconto (produto_id, desconto_geral, desconto_metodo, metodo_pagamento_id) VALUES
(1, 0.10, 0.05, 3), -- 10% de desconto geral e 5% extra no Pix para o Celular
(2, 0.15, 0.03, 1), -- 15% de desconto geral e 3% no Cartão de Crédito para o Notebook
(3, 0.05, 0.02, 2); -- 5% de desconto geral e 2% no Boleto para o Fone

INSERT INTO Preco (id_produto, valor, valor_final, desconto_id, metodo_pagamento_id) VALUES
(1, 5000, 4500, 1, 3), -- Celular com desconto aplicado
(2, 8000, 6720, 2, 1), -- Notebook com desconto aplicado
(3, 500, 475, 3, 2); -- Fone com desconto aplicado

INSERT INTO Usuario (nome, cpf) VALUES
('João Silva', '12345678900'),
('Maria Oliveira', '98765432100'),
('Carlos Souza', '11122233344');

INSERT INTO Avaliacao (usuario_id, produto_id, comentario, nota, media_avaliacao) VALUES
(1, 1, 'Ótimo celular, muito rápido!', 9.5, 9.5),
(2, 2, 'Notebook excelente, mas poderia ter mais bateria.', 8.0, 8.0),
(3, 3, 'Fone de ouvido confortável e com bom som.', 9.0, 9.0);

--**Query para consulta dos produtos, com os valores correspondentes, no caso nome produto, valor, desconto, etc**

SELECT 
    Produto.id_produto, 
    Produto.nome AS nome_produto, 
    Preco.valor AS preco_original,
    Preco.valor_final AS preco_com_desconto,
    MetodoPagamento.metodo AS metodo_pagamento,
    MetodoPagamento.numero_parcela AS parcelas,
    Desconto.desconto_geral AS desconto_total,
    Avaliacao.nota AS nota_avaliacao,
    Avaliacao.comentario AS avaliacao_produto
FROM Preco Preco
LEFT JOIN Produto Produto ON Preco.id_produto = Produto.id_produto
LEFT JOIN MetodoPagamento MetodoPagamento ON Preco.metodo_pagamento_id = MetodoPagamento.id_metodo_pagamento
LEFT JOIN Desconto Desconto ON Preco.desconto_id = Desconto.id_desconto
LEFT JOIN Avaliacao Avaliacao ON Produto.id_produto = Avaliacao.produto_id;