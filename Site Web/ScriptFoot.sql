drop table traductioncategorie;
drop table traductionproduit;
drop table ligneproduit;
drop table produit;
drop table categorie;
drop table langue;
drop table promo;
drop table commande;
drop table customer;
drop table adresse;


create table Customer(
	NumeroClient int AUTO_INCREMENT,
	Nom VARCHAR(50) NOT NULL,
	Prenom VARCHAR(50) NOT NULL,
	Email VARCHAR(100) NOT NULL,
	MotDePasse VARCHAR(20) NOT NULL,
	Telephone NUMERIC(10),
	DateNaissance DATE,
	Civilite VARCHAR(4) NOT NULL,
	Localite int NOT NULL,
	constraint Client_ID PRIMARY KEY (NumeroClient)
);

create table Adresse(
	IDAdresse int AUTO_INCREMENT,
	Pays VARCHAR(50) NOT NULL,
	Ville VARCHAR(50) NOT NULL,
	CodePosal NUMERIC(4) NOT NULL,
	Rue VARCHAR(30) NOT NULL,
	Numero NUMERIC(3) NOT NULL,
	BoitePostal VARCHAR(4),
	constraint Adresse_ID PRIMARY KEY(IDAdresse)
);

create table Commande(
	Reference NUMERIC(5) NOT NULL,
	DateCommande DATE NOT NULL,
	MontantReduction NUMERIC(5,2) NOT NULL check(MontantReduction > 0),
	NumeroCli int NOT NULL,
	constraint Commande_ID PRIMARY KEY(Reference)
);

create table Produit(
	Reference NUMERIC(5) NOT NULL,
	UrlImage VARCHAR(150) NOT NULL,
	PrixUnitaire NUMERIC(5,2) NOT NULL check(PrixUnitaire > 0),
	ReferencePromo NUMERIC(5),
    ReferenceCategorie int NOT NULL,
	constraint Produit_ID PRIMARY KEY(Reference)
);

create table LigneProduit(
	Quantite NUMERIC(5) NOT NULL check(Quantite > 0),
	PrixReel NUMERIC(8,2) NOT NULL check(PrixReel > 0),
	RefCommande NUMERIC(5) NOT NULL,
	RefProduit NUMERIC(5) NOT NULL,
	constraint LigneProduit_ID PRIMARY KEY(RefCommande,RefProduit)
);

create table Promo(
	Reference NUMERIC(5) NOT NULL,
	Pourcentage NUMERIC(2,2) NOT NULL check(Pourcentage between 0 and 100),
	DateDebut DATE NOT NULL,
	DateFin DATE NOT NULL,
	constraint Promo_ID PRIMARY KEY(Reference)
);

create table Langue(
	IdLangue VARCHAR(20) PRIMARY KEY
);

create table TraductionProduit(
	Libelle VARCHAR(30) NOT NULL,
    RefProduit NUMERIC(5),
    RefLangue VARCHAR(20),
    constraint TradPro_ID PRIMARY KEY(RefProduit,RefLangue)
);

create table Categorie(
	IdCategorie int AUTO_INCREMENT PRIMARY KEY
);

create table TraductionCategorie(
	Libelle VARCHAR(30) NOT NULL,
    RefCategorie int,
    RefLangue VARCHAR(20),
    constraint TradCat_ID PRIMARY KEY(RefCategorie,RefLangue)
);

alter table Customer add constraint REF_Cli_Adr_FK
		FOREIGN KEY(Localite)
		REFERENCES Adresse(IDAdresse);
        
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
			FOREIGN KEY(ReferencePromo)
            REFERENCES Promo(Reference);
            
alter table Produit add constraint Categorie_Prod_FK
			FOREIGN KEY(ReferenceCategorie)
            REFERENCES Categorie(IdCategorie);
            
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
