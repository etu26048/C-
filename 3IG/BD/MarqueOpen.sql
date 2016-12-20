-- *********************************************
-- * Standard SQL generation                   
-- *--------------------------------------------
-- * DB-MAIN version: 9.3.0              
-- * Generator date: Feb 16 2016              
-- * Generation date: Tue Dec 13 22:06:19 2016 
-- * LUN file: C:\Users\dark-\Desktop\CoursGithub\3IG\BD\MarqueOpenRel.lun 
-- * Schema: MarqueOpen/SQL 
-- ********************************************* 


-- Database Section
-- ________________ 

create database MarqueOpen;


-- DBSpace Section
-- _______________


-- Tables Section
-- _____________ 

create table appartenance (
     IdPropriete numeric(5) not null,
     dateFin date,
     dateDeb date not null,
     plaqueMineralogique varchar(9) not null,
     DateImmatriculation date not null,
     idVehicule numeric(9) not null,
     id numeric(5) not null,
     constraint ID_appartenance_ID primary key (IdPropriete));

create table Concessionnaire (
     idConcessionnaire numeric(9) not null,
     nom varchar(50) not null,
     Adresse varchar(80) not null,
     constraint ID_Concessionnaire_ID primary key (idConcessionnaire));

create table Consommation (
     IdConso numeric(5) not null,
     Qte numeric(6) not null,
     PrixReel numeric(6,2) not null,
     Id numeric(5) not null,
     IdOperation numeric(5) not null,
     constraint ID_Consommation_ID primary key (IdConso));

create table Devis (
     date date not null,
     Numero numeric(6) not null,
     IdVisite numeric(6) not null,
     descriptif varchar(80) not null,
     IdPropriete numeric(5) not null,
     constraint ID_Devis_ID primary key (Numero),
     constraint SID_Devis_Visit_ID unique (IdVisite));

create table FactureImpaye (
     idFacture numeric(5) not null,
     IdVisite numeric(6) not null,
     date date not null,
     dateEcheance date not null,
     montantAccompte numeric(8,2) not null,
     solde numeric(8,2) not null,
     descriptif varchar(80) not null,
     montant numeric(8,2) not null,
     constraint ID_FactureImpaye_ID primary key (idFacture),
     constraint SID_Factu_Visit_ID unique (IdVisite));

create table Langue (
     CodeLangue numeric(5) not null,
     LibelleLangue varchar(50) not null,
     id numeric(5) not null,
     constraint ID_Langue_ID primary key (CodeLangue),
     constraint SID_Langue_ID unique (CodeLangue));

create table Ligne (
     idLigne numeric(5) not null,
     numeroOrdre numeric(5) not null,
     Numero numeric(6) not null,
     constraint ID_Ligne_ID primary key (idLigne));

create table LigneCommentaire (
     idLigne numeric(5) not null,
     texte varchar(100) not null,
     constraint ID_Ligne_Ligne_2_ID primary key (idLigne));

create table LigneConsommation (
     idLigne numeric(5) not null,
     quantite numeric(5) not null,
     PrixPieceEventuelle numeric(6,2) not null,
     Id numeric(5) not null,
     constraint ID_Ligne_Ligne_1_ID primary key (idLigne));

create table LigneOperation (
     idLigne numeric(5) not null,
     libelle varchar(80) not null,
     temps numeric(5) not null,
     coutHoraire numeric(3,2) not null,
     coutStandard numeric(3,2) not null,
     IdOperation numeric(5) not null,
     constraint ID_Ligne_Ligne_ID primary key (idLigne));

create table Marque (
     CodeMarque numeric(5) not null,
     LibelleMarque varchar(80) not null,
     constraint ID_Marque_ID primary key (CodeMarque));

create table Modele (
     idModel numeric(9) not null,
     motorisation varchar(50) not null,
     cylindree varchar(50) not null,
     CodeMarque numeric(5) not null,
     constraint ID_Modele_ID primary key (idModel));

create table Option (
     idOption numeric(5) not null,
     libelle varchar(80) not null,
     descriptif varchar(80) not null,
     constraint ID_Option_ID primary key (idOption));

create table optionNonSatandards (
     idOption numeric(5) not null,
     idVehicule numeric(9) not null,
     constraint ID_optionNonSatandards_ID primary key (idVehicule, idOption));

create table optionStandards (
     idModel numeric(9) not null,
     idOption numeric(5) not null,
     constraint ID_optionStandards_ID primary key (idModel, idOption));

create table Operation (
     IdOperation numeric(5) not null,
     n°ordre numeric(5) not null,
     dureeReelle varchar(15) not null,
     Code numeric(5) not null,
     IdVisite numeric(6) not null,
     constraint ID_Operation_ID primary key (IdOperation));

create table Ouvrier (
     matricule numeric(5) not null,
     nom varchar(50) not null,
     prenom varchar(50) not null,
     dateEntree date not null,
     CodeQualif numeric(5) not null,
     constraint ID_Ouvrier_ID primary key (matricule));

create table Piece (
     Id numeric(5) not null,
     prixCatalogue numeric(6,2) not null,
     constraint ID_Piece_ID primary key (Id));

create table Pro_tel (
     id numeric(5) not null,
     tel varchar(12) not null,
     constraint ID_Pro_tel_ID primary key (tel, id));

create table Proprietaire (
     id numeric(5) not null,
     nom varchar(80) not null,
     adr_ville varchar(50) not null,
     adr_cp numeric(5) not null,
     adr_rue varchar(30) not null,
     adr_numRue varchar(5) not null,
     mail varchar(35) not null,
     langue varchar(25) not null,
     constraint ID_Proprietaire_ID primary key (id));

create table Qualification (
     CodeQualif numeric(5) not null,
     LibelleQualif varchar(80) not null,
     constraint ID_Qualification_ID primary key (CodeQualif));

create table Stock (
     Id numeric(5) not null,
     codeStockage numeric(5) not null,
     QuantiteStock numeric(5) not null,
     DateDernierStock date not null,
     QteStockTheorique numeric(5) not null,
     constraint ID_Stock_ID primary key (Id, codeStockage));

create table Stockage (
     codeStockage numeric(5) not null,
     constraint ID_Stockage_ID primary key (codeStockage));

create table tel (
     matricule numeric(5) not null,
     tel varchar(12) not null,
     constraint ID_tel_ID primary key (matricule, tel));

create table tel_1 (
     tel varchar(12) not null,
     constraint ID_tel_1_ID primary key (tel));

create table TradLibPiece (
     IdTrad numeric(5) not null,
     LibellePiece varchar(80) not null,
     Id numeric(5) not null,
     CodeLangue numeric(5) not null,
     constraint ID_TradLibPiece_ID primary key (IdTrad));

create table TypeOperation (
     Code numeric(5) not null,
     descriptif varchar(80) not null,
     prixUnitaire numeric(6,2) not null,
     dureeTheorique varchar(15) not null,
     CodeLangue numeric(5) not null,
     constraint ID_TypeOperation_ID primary key (Code));

create table TypeOpOuv (
     matricule numeric(5) not null,
     Code numeric(5) not null,
     constraint ID_TypeOpOuv_ID primary key (matricule, Code));

create table Vehicule (
     idVehicule numeric(9) not null,
     NumeroChassis varchar(20) not null,
     description varchar(80) not null,
     couleur varchar(15) not null,
     chargeMax numeric(3,2),
     dateControle date,
     anneeFabrication date not null,
     typeJante varchar(30) not null,
     typeVehicule varchar(30) not null,
     idModel numeric(9) not null,
     idConcessionnaire numeric(9) not null,
     constraint ID_Vehicule_ID primary key (idVehicule),
     constraint SID_Vehicule_ID unique (NumeroChassis));

create table Visite (
     IdVisite numeric(6) not null,
     n°Visite numeric(6) not null,
     dateEntree date not null,
     dateSortie date not null,
     coutTotal numeric(8,2) not null,
     descriptif varchar(80),
     IdPropriete numeric(5) not null,
     constraint ID_Visite_ID primary key (IdVisite),
     constraint SID_Visite_ID unique (n°Visite, dateEntree));


-- Constraints Section
-- ___________________ 

alter table appartenance add constraint REF_appar_Vehic_FK
     foreign key (idVehicule)
     references Vehicule;

alter table appartenance add constraint REF_appar_Propr_FK
     foreign key (id)
     references Proprietaire;

alter table Consommation add constraint REF_Conso_Piece_FK
     foreign key (Id)
     references Piece;

alter table Consommation add constraint REF_Conso_Opera_FK
     foreign key (IdOperation)
     references Operation;

alter table Devis add constraint ID_Devis_CHK
     check(exists(select * from Ligne
                  where Ligne.Numero = Numero)); 

alter table Devis add constraint SID_Devis_Visit_FK
     foreign key (IdVisite)
     references Visite;

alter table Devis add constraint REF_Devis_appar_FK
     foreign key (IdPropriete)
     references appartenance;

alter table FactureImpaye add constraint SID_Factu_Visit_FK
     foreign key (IdVisite)
     references Visite;

alter table Langue add constraint REF_Langu_Propr_FK
     foreign key (id)
     references Proprietaire;

alter table Ligne add constraint EQU_Ligne_Devis_FK
     foreign key (Numero)
     references Devis;

alter table LigneCommentaire add constraint ID_Ligne_Ligne_2_FK
     foreign key (idLigne)
     references Ligne;

alter table LigneConsommation add constraint REF_Ligne_Piece_FK
     foreign key (Id)
     references Piece;

alter table LigneConsommation add constraint ID_Ligne_Ligne_1_FK
     foreign key (idLigne)
     references Ligne;

alter table LigneOperation add constraint REF_Ligne_Opera_FK
     foreign key (IdOperation)
     references Operation;

alter table LigneOperation add constraint ID_Ligne_Ligne_FK
     foreign key (idLigne)
     references Ligne;

alter table Modele add constraint REF_Model_Marqu_FK
     foreign key (CodeMarque)
     references Marque;

alter table optionNonSatandards add constraint REF_optio_Vehic
     foreign key (idVehicule)
     references Vehicule;

alter table optionNonSatandards add constraint REF_optio_Optio_1_FK
     foreign key (idOption)
     references Option;

alter table optionStandards add constraint REF_optio_Optio_FK
     foreign key (idOption)
     references Option;

alter table optionStandards add constraint REF_optio_Model
     foreign key (idModel)
     references Modele;

alter table Operation add constraint REF_Opera_TypeO_FK
     foreign key (Code)
     references TypeOperation;

alter table Operation add constraint REF_Opera_Visit_FK
     foreign key (IdVisite)
     references Visite;

alter table Ouvrier add constraint ID_Ouvrier_CHK
     check(exists(select * from tel
                  where tel.matricule = matricule)); 

alter table Ouvrier add constraint REF_Ouvri_Quali_FK
     foreign key (CodeQualif)
     references Qualification;

alter table Pro_tel add constraint EQU_P_t_tel_1
     foreign key (tel)
     references tel_1;

alter table Pro_tel add constraint EQU_P_t_Propr_FK
     foreign key (id)
     references Proprietaire;

alter table Proprietaire add constraint ID_Proprietaire_CHK
     check(exists(select * from Pro_tel
                  where Pro_tel.id = id)); 

alter table Stock add constraint REF_Stock_Stock_FK
     foreign key (codeStockage)
     references Stockage;

alter table Stock add constraint REF_Stock_Piece
     foreign key (Id)
     references Piece;

alter table tel add constraint EQU_tel_Ouvri
     foreign key (matricule)
     references Ouvrier;

alter table tel_1 add constraint ID_tel_1_CHK
     check(exists(select * from Pro_tel
                  where Pro_tel.tel = tel)); 

alter table TradLibPiece add constraint REF_TradL_Piece_FK
     foreign key (Id)
     references Piece;

alter table TradLibPiece add constraint REF_TradL_Langu_FK
     foreign key (CodeLangue)
     references Langue;

alter table TypeOperation add constraint REF_TypeO_Langu_FK
     foreign key (CodeLangue)
     references Langue;

alter table TypeOpOuv add constraint REF_TypeO_TypeO_FK
     foreign key (Code)
     references TypeOperation;

alter table TypeOpOuv add constraint REF_TypeO_Ouvri
     foreign key (matricule)
     references Ouvrier;

alter table Vehicule add constraint REF_Vehic_Model_FK
     foreign key (idModel)
     references Modele;

alter table Vehicule add constraint REF_Vehic_Conce_FK
     foreign key (idConcessionnaire)
     references Concessionnaire;

alter table Visite add constraint REF_Visit_appar_FK
     foreign key (IdPropriete)
     references appartenance;


-- Index Section
-- _____________ 

create unique index ID_appartenance_IND
     on appartenance (IdPropriete);

create index REF_appar_Vehic_IND
     on appartenance (idVehicule);

create index REF_appar_Propr_IND
     on appartenance (id);

create unique index ID_Concessionnaire_IND
     on Concessionnaire (idConcessionnaire);

create unique index ID_Consommation_IND
     on Consommation (IdConso);

create index REF_Conso_Piece_IND
     on Consommation (Id);

create index REF_Conso_Opera_IND
     on Consommation (IdOperation);

create unique index ID_Devis_IND
     on Devis (Numero);

create unique index SID_Devis_Visit_IND
     on Devis (IdVisite);

create index REF_Devis_appar_IND
     on Devis (IdPropriete);

create unique index ID_FactureImpaye_IND
     on FactureImpaye (idFacture);

create unique index SID_Factu_Visit_IND
     on FactureImpaye (IdVisite);

create unique index ID_Langue_IND
     on Langue (CodeLangue);

create unique index SID_Langue_IND
     on Langue (CodeLangue);

create index REF_Langu_Propr_IND
     on Langue (id);

create unique index ID_Ligne_IND
     on Ligne (idLigne);

create index EQU_Ligne_Devis_IND
     on Ligne (Numero);

create unique index ID_Ligne_Ligne_2_IND
     on LigneCommentaire (idLigne);

create index REF_Ligne_Piece_IND
     on LigneConsommation (Id);

create unique index ID_Ligne_Ligne_1_IND
     on LigneConsommation (idLigne);

create index REF_Ligne_Opera_IND
     on LigneOperation (IdOperation);

create unique index ID_Ligne_Ligne_IND
     on LigneOperation (idLigne);

create unique index ID_Marque_IND
     on Marque (CodeMarque);

create unique index ID_Modele_IND
     on Modele (idModel);

create index REF_Model_Marqu_IND
     on Modele (CodeMarque);

create unique index ID_Option_IND
     on Option (idOption);

create unique index ID_optionNonSatandards_IND
     on optionNonSatandards (idVehicule, idOption);

create index REF_optio_Optio_1_IND
     on optionNonSatandards (idOption);

create unique index ID_optionStandards_IND
     on optionStandards (idModel, idOption);

create index REF_optio_Optio_IND
     on optionStandards (idOption);

create unique index ID_Operation_IND
     on Operation (IdOperation);

create index REF_Opera_TypeO_IND
     on Operation (Code);

create index REF_Opera_Visit_IND
     on Operation (IdVisite);

create unique index ID_Ouvrier_IND
     on Ouvrier (matricule);

create index REF_Ouvri_Quali_IND
     on Ouvrier (CodeQualif);

create unique index ID_Piece_IND
     on Piece (Id);

create unique index ID_Pro_tel_IND
     on Pro_tel (tel, id);

create index EQU_P_t_Propr_IND
     on Pro_tel (id);

create unique index ID_Proprietaire_IND
     on Proprietaire (id);

create unique index ID_Qualification_IND
     on Qualification (CodeQualif);

create unique index ID_Stock_IND
     on Stock (Id, codeStockage);

create index REF_Stock_Stock_IND
     on Stock (codeStockage);

create unique index ID_Stockage_IND
     on Stockage (codeStockage);

create unique index ID_tel_IND
     on tel (matricule, tel);

create unique index ID_tel_1_IND
     on tel_1 (tel);

create unique index ID_TradLibPiece_IND
     on TradLibPiece (IdTrad);

create index REF_TradL_Piece_IND
     on TradLibPiece (Id);

create index REF_TradL_Langu_IND
     on TradLibPiece (CodeLangue);

create unique index ID_TypeOperation_IND
     on TypeOperation (Code);

create index REF_TypeO_Langu_IND
     on TypeOperation (CodeLangue);

create unique index ID_TypeOpOuv_IND
     on TypeOpOuv (matricule, Code);

create index REF_TypeO_TypeO_IND
     on TypeOpOuv (Code);

create unique index ID_Vehicule_IND
     on Vehicule (idVehicule);

create unique index SID_Vehicule_IND
     on Vehicule (NumeroChassis);

create index REF_Vehic_Model_IND
     on Vehicule (idModel);

create index REF_Vehic_Conce_IND
     on Vehicule (idConcessionnaire);

create unique index ID_Visite_IND
     on Visite (IdVisite);

create unique index SID_Visite_IND
     on Visite (n°Visite, dateEntree);

create index REF_Visit_appar_IND
     on Visite (IdPropriete);

