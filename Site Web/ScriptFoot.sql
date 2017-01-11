drop table traductioncategorie;
drop table traductionproduit;
drop table ligneproduit;
drop table produit;
drop table categorie;
drop table langue;
drop table promo;
drop table commande;
drop table customer;

CREATE TABLE Customer (
    Numeroclient INT AUTO_INCREMENT,
    Nom VARCHAR(50) NOT NULL,
    Prenom VARCHAR(50) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Motdepasse VARCHAR(50) NOT NULL,
    Confirmpw VARCHAR(50) NOT NULL,
    Telephone VARCHAR(10),
    Datenaissance DATE,
    Civilite VARCHAR(4) NOT NULL,
    Pays VARCHAR(50) NOT NULL,
    Ville VARCHAR(50) NOT NULL,
    Codepostal NUMERIC(4) NOT NULL,
    Rue VARCHAR(30) NOT NULL,
    Numero VARCHAR(5) NOT NULL,
    Boite VARCHAR(4),
    CONSTRAINT Client_ID PRIMARY KEY (NumeroClient)
);

CREATE TABLE Commande (
    Reference INT(15) AUTO_INCREMENT NOT NULL,
    Datecommande DATE NOT NULL,
    Montantreduction NUMERIC(5 , 2 ) NOT NULL CHECK (MontantReduction > 0),
    Numerocli INT NOT NULL,
    CONSTRAINT Commande_ID PRIMARY KEY (Reference)
);

CREATE TABLE Produit (
    Reference VARCHAR(15) NOT NULL,
    Urlimage VARCHAR(150) NOT NULL,
    Prixunitaire NUMERIC(5 , 2 ) NOT NULL CHECK (PrixUnitaire > 0),
    Referencepromo NUMERIC(5),
    Referencecategorie INT NOT NULL,
    CONSTRAINT Produit_ID PRIMARY KEY (Reference)
);

CREATE TABLE LigneProduit (
    Idproduit INT(6) PRIMARY KEY AUTO_INCREMENT,
    Quantite NUMERIC(5) NOT NULL CHECK (Quantite > 0),
    Prixreel NUMERIC(8 , 2 ) NOT NULL CHECK (PrixReel > 0),
    Refcommande INT(15) NOT NULL,
    Refproduit VARCHAR(15) NOT NULL
);

CREATE TABLE Promo (
    Reference NUMERIC(5) NOT NULL,
    Pourcentage NUMERIC(3 ,0 ) NOT NULL CHECK (Pourcentage BETWEEN 0 AND 100),
    Datedebut DATE NOT NULL,
    Datefin DATE NOT NULL,
    CONSTRAINT Promo_ID PRIMARY KEY (Reference)
);

CREATE TABLE Langue (
    Idlangue VARCHAR(20) PRIMARY KEY
);

CREATE TABLE TraductionProduit (
    IdTradProd INT(6) PRIMARY KEY AUTO_INCREMENT,
    Libelle VARCHAR(80) NOT NULL,
    Refproduit VARCHAR(15),
    Reflangue VARCHAR(20)
);

CREATE TABLE Categorie (
    Idcategorie INT PRIMARY KEY
);

CREATE TABLE TraductionCategorie (
    IdTradCat INT(6) AUTO_INCREMENT PRIMARY KEY,
    Libelle VARCHAR(30) NOT NULL,
    Refcategorie INT,
    Reflangue VARCHAR(20)
);
        
alter table Commande add constraint REF_Com_Cli_FK
		FOREIGN KEY(NumeroCli)
		REFERENCES Customer(NumeroClient);

alter table LigneProduit add constraint REF_Lp_Com_FK
			FOREIGN KEY(RefCommande)
			REFERENCES Commande(Reference);
		
alter table LigneProduit add constraint REF_Lp_Prod_FK
			FOREIGN KEY(RefProduit)
			REFERENCES Produit(Reference);

alter table Produit add constraint REF_refPromo_FK
			FOREIGN KEY(Referencepromo)
            REFERENCES Promo(Reference);
            
alter table Produit add constraint Categorie_Prod_FK
			FOREIGN KEY(Referencecategorie)
            REFERENCES Categorie(Idcategorie);
            
alter table TraductionProduit add constraint REF_Id_langue_FK
			FOREIGN KEY(RefLangue)
            REFERENCES Langue(IdLangue);
            
alter table TraductionProduit add constraint REF_Id_Produit_FK
			FOREIGN KEY(RefProduit)
            REFERENCES Produit(Reference);

alter table TraductionCategorie add constraint Categorie_FK
			FOREIGN KEY(RefCategorie)
			REFERENCES Categorie(IdCategorie);
            
alter table TraductionCategorie add constraint Langue_FK
			FOREIGN KEY(RefLangue)
            REFERENCES Langue(IdLangue);
