CREATE TABLE Hopital (
    NumTva VARCHAR(12) PRIMARY KEY,
    UrlSiteWeb VARCHAR(70),
    TelUrgence VARCHAR(9),
    Nom VARCHAR(80) NOT NULL,
    NumTel VARCHAR(12) NOT NULL,
    Email VARCHAR(25),
    Fax VARCHAR(9),
    Rue VARCHAR(25) NOT NULL,
    Numero NUMERIC(4) NOT NULL,
    CodePostal NUMERIC(4) NOT NULL,
    Ville VARCHAR(25) NOT NULL,
    Pays VARCHAR(20) NOT NULL,
    Longitude NUMERIC(10 , 7 ) NOT NULL,
    Latitude NUMERIC(10 , 7 ) NOT NULL
);

CREATE TABLE Medecin (
    IdMedecin INT IDENTITY(1,1) PRIMARY KEY,
    Prénom VARCHAR(20) NOT NULL,
    HeureOuverture NUMERIC(4) NOT NULL,
    HeureFermeture NUMERIC(4) NOT NULL,
    Nom VARCHAR(20) NOT NULL,
    NumTel VARCHAR(12) NOT NULL,
    Email VARCHAR(25),
    Fax VARCHAR(9),
    Rue VARCHAR(25) NOT NULL,
    Numero NUMERIC(4) NOT NULL,
    CodePostal NUMERIC(4) NOT NULL,
    Ville VARCHAR(25) NOT NULL,
    Pays VARCHAR(20) NOT NULL,
    Longitude NUMERIC(10 , 7 ) NOT NULL,
    Latitude NUMERIC(10 , 7 ) NOT NULL
) ;

CREATE TABLE Pharmacie (
    NumTva VARCHAR(12) PRIMARY KEY,
    DeGarde BIT NOT NULL,
    UrlSiteWeb VARCHAR(70),
    HeureOuverture NUMERIC(4) NOT NULL,
    HeureFermeture NUMERIC(4) NOT NULL,
    Nom VARCHAR(20) NOT NULL,
    NumTel VARCHAR(12) NOT NULL,
    Email VARCHAR(25),
    Fax VARCHAR(9),
    Rue VARCHAR(25) NOT NULL,
    Numero NUMERIC(4) NOT NULL,
    CodePostal NUMERIC(4) NOT NULL,
    Ville VARCHAR(25) NOT NULL,
    Pays VARCHAR(20) NOT NULL,
    Longitude NUMERIC(10 , 7 ) NOT NULL,
    Latitude NUMERIC(10 , 7 ) NOT NULL
);

CREATE TABLE PosteDeGarde (
    NumeroID INT IDENTITY(1,1) PRIMARY KEY,
    HeureOuverture NUMERIC(4) NOT NULL,
    HeureFermeture NUMERIC(4) NOT NULL,
    Nom VARCHAR(20) NOT NULL,
    NumTel VARCHAR(12) NOT NULL,
    Email VARCHAR(25),
    Fax VARCHAR(9),
    Rue VARCHAR(25) NOT NULL,
    Numero NUMERIC(4) NOT NULL,
    CodePostal NUMERIC(4) NOT NULL,
    Ville VARCHAR(25) NOT NULL,
    Pays VARCHAR(20) NOT NULL,
    Longitude NUMERIC(10 , 7 ) NOT NULL,
    Latitude NUMERIC(10 , 7 ) NOT NULL
);

CREATE TABLE NumeroUrgence (
    NumTel VARCHAR(12) PRIMARY KEY,
    Label VARCHAR(30) NOT NULL,
    UrlSiteWeb VARCHAR(70)
);

CREATE TABLE Conge (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    DateDebut DATE NOT NULL,
    DateFin DATE NOT NULL,
    Libelle VARCHAR(45) NOT NULL
);

CREATE TABLE PharmacieConge (
    IdPharConge INT,
    NumtvaPhar VARCHAR(12),
    CONSTRAINT NumTvaPharmacie_fk FOREIGN KEY (NumtvaPhar)
        REFERENCES Pharmacie (NumTva),
    CONSTRAINT IdCongePharmacie_fk FOREIGN KEY (IdPharConge)
        REFERENCES Conge (Id)
) ;


CREATE TABLE PosteGardeConge (
    IdPosteGarde INT,
    IdPosteGardeConge INT,
    CONSTRAINT IdPosteGarde_fk FOREIGN KEY (IdPosteGarde)
        REFERENCES PosteDeGarde (NumeroID),
    CONSTRAINT IdCongePosteGarde_fk FOREIGN KEY (IdPosteGardeConge)
        REFERENCES Conge (Id)
);

CREATE TABLE MedecinConge (
    NumTvaMed int,
    IdMedecinConge INT,
    CONSTRAINT NumTvaMedecin_fk FOREIGN KEY (NumTvaMed)
        REFERENCES Medecin (IdMedecin),
    CONSTRAINT IdCongeMedecin_fk FOREIGN KEY (IdMedecinConge)
        REFERENCES Conge (Id)
);