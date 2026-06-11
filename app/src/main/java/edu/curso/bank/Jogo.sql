CREATE DATABASE jogomaria
USE jogomaria

CREATE TABLE desenvolvedormaria (

ID INT NOT NULL,
nomeEmpresa VARCHAR(50) NOT NULL,
cnpjcpf VARCHAR(14) NOT NULL,
email VARCHAR(50) NOT NULL,
telefone VARCHAR(11) NOT NULL,
dataNasc DATE NOT NULL,
senhaConta VARCHAR(20) NOT NULL,

PRIMARY KEY (ID)

);

CREATE TABLE jogomaria (

ID INT NOT NULL,
nome VARCHAR(50) NOT NULL,
preco DECIMAL(5,2) NOT NULL,
dataLancamento DATE NOT NULL,
espacoGB DECIMAL(3,1) NOT NULL,
genero VARCHAR(30) NOT NULL,
descricao VARCHAR(255) NULL,

PRIMARY KEY (ID)

);

INSERT INTO desenvolvedor VALUES
(1,'Pixel Games','12345678000101','pixel1@email.com','11911111111','1990-01-15','senha001'),
(2,'Nova Studio','12345678000102','nova2@email.com','11911111112','1991-02-16','senha002'),
(3,'FireSoft','12345678000103','fire3@email.com','11911111113','1992-03-17','senha003'),
(4,'BlueWorks','12345678000104','blue4@email.com','11911111114','1993-04-18','senha004'),
(5,'GameForge','12345678000105','forge5@email.com','11911111115','1994-05-19','senha005'),
(6,'SkyDev','12345678000106','sky6@email.com','11911111116','1995-06-20','senha006'),
(7,'IronCode','12345678000107','iron7@email.com','11911111117','1996-07-21','senha007'),
(8,'DreamPlay','12345678000108','dream8@email.com','11911111118','1997-08-22','senha008'),
(9,'EpicLab','12345678000109','epic9@email.com','11911111119','1998-09-23','senha009'),
(10,'VisionSoft','12345678000110','vision10@email.com','11911111120','1999-10-24','senha010'),
(11,'MegaGames','12345678000111','mega11@email.com','11911111121','1988-11-25','senha011'),
(12,'CoreDev','12345678000112','core12@email.com','11911111122','1987-12-26','senha012'),
(13,'PixelArt','12345678000113','pixel13@email.com','11911111123','1986-01-27','senha013'),
(14,'BrightCode','12345678000114','bright14@email.com','11911111124','1985-02-28','senha014'),
(15,'AlphaSoft','12345678000115','alpha15@email.com','11911111125','1984-03-10','senha015'),
(16,'BetaGames','12345678000116','beta16@email.com','11911111126','1983-04-11','senha016'),
(17,'GammaDev','12345678000117','gamma17@email.com','11911111127','1982-05-12','senha017'),
(18,'DeltaPlay','12345678000118','delta18@email.com','11911111128','1981-06-13','senha018'),
(19,'OmegaSoft','12345678000119','omega19@email.com','11911111129','1980-07-14','senha019'),
(20,'FusionLab','12345678000120','fusion20@email.com','11911111130','1979-08-15','senha020'),
(21,'QuantumDev','12345678000121','quantum21@email.com','11911111131','1978-09-16','senha021'),
(22,'RocketGames','12345678000122','rocket22@email.com','11911111132','1977-10-17','senha022'),
(23,'TitanSoft','12345678000123','titan23@email.com','11911111133','1976-11-18','senha023'),
(24,'PhoenixDev','12345678000124','phoenix24@email.com','11911111134','1975-12-19','senha024'),
(25,'CrystalPlay','12345678000125','crystal25@email.com','11911111135','1974-01-20','senha025'),
(26,'ShadowCode','12345678000126','shadow26@email.com','11911111136','1973-02-21','senha026'),
(27,'StormSoft','12345678000127','storm27@email.com','11911111137','1972-03-22','senha027'),
(28,'MagicGames','12345678000128','magic28@email.com','11911111138','1971-04-23','senha028'),
(29,'CyberLab','12345678000129','cyber29@email.com','11911111139','1970-05-24','senha029'),
(30,'InfinityDev','12345678000130','infinity30@email.com','11911111140','1969-06-25','senha030');

INSERT INTO jogo VALUES
(1,'Space Quest',49.90,'2020-01-15',15.5,'Aventura','Exploracao espacial'),
(2,'Dragon Arena',39.90,'2020-02-20',20.0,'RPG','Batalhas medievais'),
(3,'Speed Racer',29.90,'2020-03-10',8.5,'Corrida','Corridas urbanas'),
(4,'Zombie Night',19.90,'2020-04-12',12.0,'Terror','Sobrevivencia zumbi'),
(5,'Castle Wars',59.90,'2020-05-14',25.0,'Estrategia','Conquista de reinos'),
(6,'Ocean World',24.90,'2020-06-18',10.5,'Simulacao','Vida marinha'),
(7,'Sky Heroes',34.90,'2020-07-21',18.0,'Acao','Combate aereo'),
(8,'Mystic Land',44.90,'2020-08-23',22.5,'RPG','Magia e aventuras'),
(9,'Battle Zone',54.90,'2020-09-25',30.0,'FPS','Guerra moderna'),
(10,'Farm Life',14.90,'2020-10-27',5.0,'Simulacao','Gerencie uma fazenda'),
(11,'Cyber City',64.90,'2021-01-15',28.5,'Acao','Cidade futurista'),
(12,'Jungle Run',18.90,'2021-02-16',7.0,'Plataforma','Aventura na selva'),
(13,'Kingdom Rise',49.50,'2021-03-17',21.0,'Estrategia','Expansao de imperio'),
(14,'Galaxy War',69.90,'2021-04-18',35.0,'FPS','Conflitos galacticos'),
(15,'Magic School',32.90,'2021-05-19',11.5,'RPG','Academia de magia'),
(16,'Street Fighter X',45.00,'2021-06-20',13.0,'Luta','Combates intensos'),
(17,'Desert Storm',38.50,'2021-07-21',17.5,'Acao','Missao militar'),
(18,'Snow Adventure',22.90,'2021-08-22',9.0,'Aventura','Exploracao gelada'),
(19,'Robot Attack',57.90,'2021-09-23',24.0,'FPS','Invasao de robos'),
(20,'Pirate Sea',27.90,'2021-10-24',14.5,'Aventura','Tesouros piratas'),
(21,'Monster Clash',41.90,'2022-01-11',19.0,'RPG','Criaturas lendarias'),
(22,'Soccer Pro',36.90,'2022-02-12',16.0,'Esporte','Futebol competitivo'),
(23,'Basket Stars',33.90,'2022-03-13',15.0,'Esporte','Basquete profissional'),
(24,'City Builder',52.90,'2022-04-14',27.5,'Simulacao','Construcao urbana'),
(25,'Alien Escape',26.90,'2022-05-15',10.0,'Terror','Fuga alienigena'),
(26,'War Legends',58.90,'2022-06-16',29.0,'Estrategia','Grandes batalhas'),
(27,'Treasure Hunt',17.90,'2022-07-17',6.5,'Aventura','Busca por tesouros'),
(28,'Ninja Shadow',42.90,'2022-08-18',18.5,'Acao','Missoes furtivas'),
(29,'Future Race',31.90,'2022-09-19',12.5,'Corrida','Corridas futuristas'),
(30,'Empire Age',63.90,'2022-10-20',31.0,'Estrategia','Construa seu imperio');