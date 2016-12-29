delete from promo;
delete from traductioncategorie;
delete from traductionproduit;
delete from langue;
delete from produit;
delete from categorie;

/*Insertion dans promo*/
/*INSERT INTO `sitefoot`.`promo`
(`Reference`,
`Pourcentage`,
`Datedebut`,
`Datefin`)
VALUES
(0,
25.00,
"17-10-2016",
"27-10-2017");

INSERT INTO `sitefoot`.`promo`
(`Reference`,
`Pourcentage`,
`Datedebut`,
`Datefin`)
VALUES
(1,
5.00,
"01-01-2017",
"08-01-2017");/

INSERT INTO `sitefoot`.`promo`
(`Reference`,
`Pourcentage`,
`Datedebut`,
`Datefin`)
VALUES
(2,
2.00,
"02-04-2017",
"02-04-2018");
/*----------------------------------------*/
/*Categorie*/
/*Chaussures*/
INSERT INTO `sitefoot`.`categorie`
(`Idcategorie`)
VALUES
(0);

/*Vêtements*/
INSERT INTO `sitefoot`.`categorie`
(`Idcategorie`)
VALUES
(1);

/*Ballons*/
INSERT INTO `sitefoot`.`categorie`
(`Idcategorie`)
VALUES
(2);
/*---------------------------------------*/
/*Insertion dans produit*/
/*Insertion des ballons*/
INSERT INTO `sitefoot`.`produit`
(`Reference`,`Urlimage`,`Prixunitaire`,`Referencepromo`,`Referencecategorie`)
VALUES
("P0001","/ballon1.png",22.50,null,2);

INSERT INTO `sitefoot`.`produit`
(`Reference`,`Urlimage`,`Prixunitaire`,`Referencepromo`,`Referencecategorie`)
VALUES
("P0002","/ballon2.png",19.50,null,2);

INSERT INTO `sitefoot`.`produit`
(`Reference`,`Urlimage`,`Prixunitaire`,`Referencepromo`,`Referencecategorie`)
VALUES
("P0003","/ballon3.png",22.50,null,2);

INSERT INTO `sitefoot`.`produit`
(`Reference`,`Urlimage`,`Prixunitaire`,`Referencepromo`,`Referencecategorie`)
VALUES
("P0004","/ballon4.png",10.50,null,2);

/*Insertion des vêtements*/
INSERT INTO `sitefoot`.`produit`
(`Reference`,`Urlimage`,`Prixunitaire`,`Referencepromo`,`Referencecategorie`)
VALUES
("P0008","/vetement1.png",55,null,1);

INSERT INTO `sitefoot`.`produit`
(`Reference`,`Urlimage`,`Prixunitaire`,`Referencepromo`,`Referencecategorie`)
VALUES
("P0009","/vetement2.png",64.50,null,1);

INSERT INTO `sitefoot`.`produit`
(`Reference`,`Urlimage`,`Prixunitaire`,`Referencepromo`,`Referencecategorie`)
VALUES
("P0010","/vetement3.png",31,null,1);

/*Insertion des chaussures*/
INSERT INTO `sitefoot`.`produit`
(`Reference`,`Urlimage`,`Prixunitaire`,`Referencepromo`,`Referencecategorie`)
VALUES
("P0011","/chaussure1.png", 350, null, 0);

INSERT INTO `sitefoot`.`produit`
(`Reference`,`Urlimage`,`Prixunitaire`,`Referencepromo`,`Referencecategorie`)
VALUES
("P0012","/chaussure2.png",270,null,0);

/*-----------------------------------------*/
/*Insertion dans langue*/
INSERT INTO `sitefoot`.`langue`
(`IdLangue`)
VALUES
("en");

INSERT INTO `sitefoot`.`langue`
(`IdLangue`)
VALUES
("fr");

/*---------------------------------------*/
/*Traduction du produit*/
INSERT INTO `sitefoot`.`traductionproduit`
(`Libelle`,`Refproduit`,`Reflangue`)
VALUES
("Ballon Nike React","P0001","fr");

INSERT INTO `sitefoot`.`traductionproduit`
(`Libelle`,`Refproduit`,`Reflangue`)
VALUES
("Nike React balls","P0001","en");

INSERT INTO `sitefoot`.`traductionproduit`
(`Libelle`,`Refproduit`,`Reflangue`)
VALUES
("Adidas white/black/yellow","P0002","en");

INSERT INTO `sitefoot`.`traductionproduit`
(`Libelle`,`Refproduit`,`Reflangue`)
VALUES
("Adidas blanc/jaune/noir","P0002","fr");

INSERT INTO `sitefoot`.`traductionproduit`
(`Libelle`,`Refproduit`,`Reflangue`)
VALUES
("Puma white/red/black","P0003","en");

INSERT INTO `sitefoot`.`traductionproduit`
(`Libelle`,`Refproduit`,`Reflangue`)
VALUES
("Puma blanc/rouge/noir","P0003","fr");

INSERT INTO `sitefoot`.`traductionproduit`
(`Libelle`,`Refproduit`,`Reflangue`)
VALUES
("Adidas world championship blue/white","P0004","en");

INSERT INTO `sitefoot`.`traductionproduit`
(`Libelle`,`Refproduit`,`Reflangue`)
VALUES
("Adidas bleu/blanc coupe du monde","P0004","fr");

INSERT INTO `sitefoot`.`traductionproduit`
(`Libelle`,`Refproduit`,`Reflangue`)
VALUES
("Nike Mercurial Ronaldo ","P0011","en");

INSERT INTO `sitefoot`.`traductionproduit`
(`Libelle`,`Refproduit`,`Reflangue`)
VALUES
("Nike Mercurial Ronaldo","P0011","fr");

INSERT INTO `sitefoot`.`traductionproduit`
(`Libelle`,`Refproduit`,`Reflangue`)
VALUES
("Nike bleu/noir","P0012","en");

INSERT INTO `sitefoot`.`traductionproduit`
(`Libelle`,`Refproduit`,`Reflangue`)
VALUES
("Nike blue/black","P0012","fr");
/*INSERT INTO `sitefoot`.`traductionproduit`
(
`Libelle`,
`Refproduit`,
`Reflangue`)
VALUES
();*/
/*---------------------------------------*/
/*Insertion traduction de la catégorie*/
INSERT INTO `sitefoot`.`traductioncategorie`
(
`Libelle`,
`Refcategorie`,
`Reflangue`)
VALUES
(
"Chaussures",
0,
"fr");

INSERT INTO `sitefoot`.`traductioncategorie`
(
`Libelle`,
`Refcategorie`,
`Reflangue`)
VALUES
(
"Shoes",
0,
"en");

INSERT INTO `sitefoot`.`traductioncategorie`
(
`Libelle`,
`Refcategorie`,
`Reflangue`)
VALUES
(
"Vêtements",
1,
"fr");

INSERT INTO `sitefoot`.`traductioncategorie`
(
`Libelle`,
`Refcategorie`,
`Reflangue`)
VALUES
(
"Clothes",
1,
"en");

INSERT INTO `sitefoot`.`traductioncategorie`
(
`Libelle`,
`Refcategorie`,
`Reflangue`)
VALUES
(
"Ballons",
2,
"fr");

INSERT INTO `sitefoot`.`traductioncategorie`
(
`Libelle`,
`Refcategorie`,
`Reflangue`)
VALUES
(
"Balls",
2,
"en");





