drop table hopital;
drop table medecin;
drop table numerourgence;
drop table pharmarcie;
drop table postedegarde;
drop table conge;
drop table postegarde_conge;
drop table medecin_conge;
drop table pharmacie_conge;

create table Hopital(
	NumTva varchar(12) primary key,
    UrlSiteWeb varchar(30),
    TelUrgence varchar(9),
	Nom varchar(80) not null,
    NumTel varchar(12) not null,
    Email varchar(25),
    Fax varchar(9),
    Rue varchar(25) not null,
    Numero numeric(4) not null,
    CodePostal numeric(4) not null,
    Ville varchar(25) not null,
    Pays varchar(20) not null,
    Longitude numeric(10,7) not null,
    Latitude numeric(10,7) not null
);

create table Medecin(
	NumTva varchar(12) primary key,
    Prénom varchar(20) not null,
    HeureOuverture numeric(4) not null,
    HeureFermeture numeric(4) not null,
    Nom varchar(20) not null,
    NumTel varchar(12) not null,
    Email varchar(25),
    Fax varchar(9),
    Rue varchar(25) not null,
    Numero numeric(4) not null,
    CodePostal numeric(4) not null,
    Ville varchar(25) not null,
    Pays varchar(20) not null,
    Longitude numeric(10,7) not null,
    Latitude numeric(10,7) not null
);

create table Pharmarcie(
	NumTva varchar(12) primary key,
    DeGarde boolean not null,
    UrlSiteWeb varchar(30),
    HeureOuverture numeric(4) not null,
    HeureFermeture numeric(4) not null,
    Nom varchar(20) not null,
    NumTel varchar(12) not null,
    Email varchar(25),
    Fax varchar(9),
    Rue varchar(25) not null,
    Numero numeric(4) not null,
    CodePostal numeric(4) not null,
    Ville varchar(25) not null,
    Pays varchar(20) not null,
    Longitude numeric(10,7) not null,
    Latitude numeric(10,7) not null
);

create table PosteDeGarde(
	Numero int auto_increment primary key,
	HeureOuverture numeric(4) not null,
    HeureFermeture numeric(4) not null,	
    Nom varchar(20) not null,
    NumTel varchar(12) not null,
    Email varchar(25),
    Fax varchar(9),
    Rue varchar(25) not null,
    Numero numeric(4) not null,
    CodePostal numeric(4) not null,
    Ville varchar(25) not null,
    Pays varchar(20) not null,
    Longitude numeric(10,7) not null,
    Latitude numeric(10,7) not null
);

create table NumeroUrgence(
	NumTel varchar(12) primary key,
    Label varchar(30) not null,
	UrlSiteWeb varchar(30)
);

create table Conge(
	Id int auto_increment primary key,
    DateDebut date not null,
    DateFin date not null,
    Libelle varchar(45) not null
);

create table Pharmacie_Conge(
	IdPharConge int,
    Numtva varchar(12),
    constraint NumTvaPharmacie_fk foreign key(Numtva) references Pharmacie(NumTva),
    constraint IdCongePharmacie_fk foreign key(IdPharConge) references Conge(Id)
);

create table PosteGarde_Conge(
	IdPosteGarde int,
    IdPosteGardeConge int,
	constraint IdPosteGarde_fk foreign key(IdPosteGarde) references PosteDeGarde(Id),
    constraint IdCongePosteGarde_fk foreign key(IdPosteGardeConge) references Conge(Id)
);

create table Medecin_Conge(
	NumTva varchar(12), 
	IdMedecinConge int,
    constraint NumTvaMedecin_fk foreign key (NumTva) references Medecin(NumTva),
    constraint IdCongeMedecin_fk foreign key (IdMedecinConge) references Conge(Id)
);