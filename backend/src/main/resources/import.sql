INSERT INTO TB_PRODUCTS (nome, preco, descricao, img_url, categoria) VALUES ('Camiseta Nike Legend 2.0 Masculina', 99.99, 'Treino & Academia', 'https://imgnike-a.akamaihd.net/1920x1920/000433ID.jpg', 1)
INSERT INTO TB_PRODUCTS (nome, preco, descricao, img_url, categoria) VALUES ('Camiseta Nike Dri-FIT Humor 1 Masculina', 149.99, 'Treino & Academia', 'https://imgnike-a.akamaihd.net/1920x1920/02510051.jpg', 1)
INSERT INTO TB_PRODUCTS (nome, preco, descricao, img_url, categoria) VALUES ('Camisa Nike Brasil I 2023/24 Torcedor Pro Masculina', 349.99 , 'Futebol', 'https://imgnike-a.akamaihd.net/1920x1920/0257510L.jpg', 1)
INSERT INTO TB_PRODUCTS (nome, preco, descricao, img_url, categoria) VALUES ('Jaqueta Nike Brasil Masculina', 499.99, 'Futebol', 'https://imgnike-a.akamaihd.net/1920x1920/025844ND.jpg', 2)
INSERT INTO TB_PRODUCTS (nome, preco, descricao, img_url, categoria) VALUES ('Blusão Nike Sportswear Club Masculino', 379.99, 'Casual', 'https://imgnike-a.akamaihd.net/1920x1920/0069057T.jpg', 2)
INSERT INTO TB_PRODUCTS (nome, preco, descricao, img_url, categoria) VALUES ('Calça Nike Club Fleece Masculina', 499.99, 'Casual', 'https://imgnike-a.akamaihd.net/1920x1920/025563ID.jpg', 3)
INSERT INTO TB_PRODUCTS (nome, preco, descricao, img_url, categoria) VALUES ('Calça Nike Club Woven Taper Masculina', 379.99, 'Casual', 'https://imgnike-a.akamaihd.net/1920x1920/024864ID.jpg', 3)
INSERT INTO TB_PRODUCTS (nome, preco, descricao, img_url, categoria) VALUES ('Shorts Nike Challenger Masculino', 179.99, 'Corrida', 'https://imgnike-a.akamaihd.net/1920x1920/024938ID.jpg', 4)

INSERT INTO TB_USERS (nome, sobrenome, cpf, data_de_nascimento, telefone, email, senha) VALUES ('João', 'Silva', '23212332143', '2003-06-26', '11987898789', 'joao@gmail.com', 'senha123')
INSERT INTO TB_USERS (nome, sobrenome, cpf, data_de_nascimento, telefone, email, senha) VALUES ('Arthur', 'Rodrigues', '38523478493', '2003-06-17', '11948572643', 'arthur@gmail.com', 'senha456')
INSERT INTO TB_USERS (nome, sobrenome, cpf, data_de_nascimento, telefone, email, senha) VALUES ('Mateus Henrique', 'Meira', '98237445673', '2004-08-17', '11987909846', 'henrique@gmail.com', 'senha789')

INSERT INTO TB_ORDERS (client_id, momento, status_pedido) VALUES (1, '2023-07-24T13:38:10Z', 2)
INSERT INTO TB_ORDERS (client_id, momento, status_pedido) VALUES (2, '2023-06-26T18:22:17Z', 1)
INSERT INTO TB_ORDERS (client_id, momento, status_pedido) VALUES (1, '2023-05-24T08:09:23Z', 2)

INSERT INTO TB_ITEM_PEDIDO (pedido_id, produto_id, quantidade, preco) VALUES (1, 1, 1, 99.99)