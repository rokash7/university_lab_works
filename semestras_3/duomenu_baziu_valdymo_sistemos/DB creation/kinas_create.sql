--------KINAS--------

CREATE TABLE IF NOT EXISTS bilietas (
	Nr 					INTEGER NOT NULL CHECK (Nr>=0),
	Kaina 				FLOAT NOT NULL CHECK (Kaina>=0),
	Mokejimo_Budas 		VARCHAR(16)
						CHECK(Mokejimo_Budas IN('grynais','kortele'))
						DEFAULT 'grynais',
	Seanso_Nr 			INTEGER NOT NULL CHECK (Nr>=0),
	CONSTRAINT Kaina_grynaisiais
						CHECK(Kaina>=6 OR Mokejimo_Budas='kortele'),
	
	PRIMARY KEY(Nr)
);

CREATE TABLE IF NOT EXISTS seansas (
	Nr 					INTEGER NOT NULL CHECK (Nr>=0),
	Diena				DATE NOT NULL,
	Laikas 				TIME NOT NULL,
	Filmo_Pavadinimas 	VARCHAR(256) NOT NULL,
	Sales_Nr 			INTEGER NOT NULL CHECK (Sales_Nr>=0),
	--Laisvu_vietu_skaicius AS Laisvu_vietu_skaicius_,
		
	PRIMARY KEY(Nr)
);

CREATE TABLE IF NOT EXISTS filmas (
	Pavadinimas 		VARCHAR (256),
	Trukme 				TIME NOT NULL,
	Vertinimas			INTEGER
						CHECK (Vertinimas BETWEEN 0 AND 100)
						DEFAULT 0,
	
	PRIMARY KEY(Pavadinimas)
);

CREATE TABLE IF NOT EXISTS sale (
	Nr 					SERIAL,
	Vietu_skaicius 		INTEGER NOT NULL,
	
	PRIMARY KEY(Nr)
);
