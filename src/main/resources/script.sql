insert into Usuario(cpf, dataNascimento, endereco, login, nome, senha, idUsuario) 
values('222-222-222-22', parsedatetime('17-09-2012', 'dd-MM-yyyy'), 'rua b', 'admin', 'Administrador', 'admin', nextval('USUARIO_SEQ'));

insert into Comerciante (cnpj, nomeLoja, razaoSocial, idUsuario) 
values('222-222-222-22', 'Loja-geral', 'Loja-geral_Ltda', 1);

insert into Usuario(cpf, dataNascimento, endereco, login, nome, senha, idUsuario) 
values('111-111-111-11', parsedatetime('23-07-1991', 'dd-MM-yyyy'), 'rua b', 'meri', 'Meridiane', 'teste', nextval('USUARIO_SEQ'));

insert into Cliente(idUsuario) 
values(2);

insert into Produto (idProduto, imagem, cor, dimensoes, nome, precoProduto, tipo, idComerciante)
VALUES(nextval('PRODUTO_SEQ'), 'https://static.lojasaopaulomagazine.com.br/public/saopaulomagazine/imagens/produtos/kit-toalha-de-banho-e-rosto-algodao-egipcio-rosa-buddemeyer-2315.jpg', 'Rosa', '100x200', 'Kit de Toalhas', 49.90, 'Cama Mesa e Banho', 1);

insert into Produto (idProduto, imagem, cor, dimensoes, nome, precoProduto, tipo, idComerciante)
VALUES(nextval('PRODUTO_SEQ'), 'https://images.tcdn.com.br/img/img_prod/581440/jogo_de_lencol_casal_estampado_180_fios_4_pecas_poa_rosa_2442_1_20180724112425.jpg', 'Lilás', '100x200', 'Lençol Estampado', 60, 'Cama Mesa e Banho', 1);

insert into Produto (idProduto, imagem, cor, dimensoes, nome, precoProduto, tipo, idComerciante)
VALUES(nextval('PRODUTO_SEQ'), 'https://www.efacil.com.br/wcsstore/ExtendedSitesCatalogAssetStore/Imagens/1000/2217326_01.jpg', 'Preto', '100x200', 'Secador de Cabelo', 99.99, 'Eletro eletrônicos', 1);

insert into Produto (idProduto, imagem,  cor, dimensoes, nome, precoProduto, tipo, idComerciante)
VALUES(nextval('PRODUTO_SEQ'), 'https://static.lojasmm.com/lojasmm/5fd0ca87af9f520201209130055_1.jpeg',  'Preto', '190x190', 'Televisão Smart', 789.99, 'Eletro eletrônicos', 1);

insert into Produto (idProduto, imagem, cor, dimensoes, nome, precoProduto, tipo, idComerciante)
VALUES(nextval('PRODUTO_SEQ'), 'https://sunhouse.vteximg.com.br/arquivos/ids/186556-1000-1000/Office-Viseu-Baixa---Preta---2--Fundo-Branco.jpg?v=636567949406730000', 'Preto', '90x90', 'Cadeira Escritório', 249.99, 'Escritório', 1);

insert into Produto (idProduto, imagem, cor, dimensoes, nome, precoProduto, tipo, idComerciante)
VALUES(nextval('PRODUTO_SEQ'), 'https://www.millenamoveiseeletro.com.br/image/cache/catalog/17377%20-%20Arm%C3%A1rio%20para%20cozinha%203%20Portas%20100%20MDF%20Ronipa%20Napoli-1000x1000.png', 'Branco', '90x90', 'Armário Aéreo Cozinha', 449.99, 'Móveis', 1);

insert into Produto (idProduto, imagem, cor, dimensoes, nome, precoProduto, tipo, idComerciante)
VALUES(nextval('PRODUTO_SEQ'), 'https://a-static.mlcdn.com.br/1500x1500/cortina-blackout-caqui-em-tecido-com-voil-5-metros-cantinho-de-lar/boavistaenxovais/311p/a26d6e3fbf3e8ae7befcfd6032c3a4b1.jpg', 'Caqui', '120x100', 'Cortina', 249.99, 'Cama mesa e banho', 1);

insert into Produto (idProduto, imagem, cor, dimensoes, nome, precoProduto, tipo, idComerciante)
VALUES(nextval('PRODUTO_SEQ'), 'https://electrolux.vteximg.com.br/arquivos/ids/204702/Fogao_FC5VP_KLM_Frontal_Continental--1000x1000-.png?v=637692267366330000', 'Preto', '120x100', 'Fogão', 329.99, 'Cozinha', 1);

insert into Produto (idProduto, imagem, cor, dimensoes, nome, precoProduto, tipo, idComerciante)
VALUES(nextval('PRODUTO_SEQ'), 'https://a-static.mlcdn.com.br/1500x1500/beliche-madeira-macica-italia-castanho-quarta-divisao/bembaratomoveis-online/b3vbgptyg/85a2f835c47010c11bb8995767aafe67.jpg', 'Castanho', '1200x1000', 'Beliche', 789.99, 'Cama mesa e banho', 1);

