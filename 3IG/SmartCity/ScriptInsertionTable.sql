/*Insertion d'Hôpitals*/
delete from schedules;
delete from hospitals;
delete from doctors;
delete from localities;
delete from EmergencyCalls;

/*Insertion des localités*/
insert into localities
values('Namur',5000);
insert into localities
values('Salzinnes',5000);
insert into localities
values('Beez',5000);
insert into localities
values('Belgrade',5001);
insert into localities
values('Saint-servais',5002);
insert into localities
values('Bouge',5004);
insert into localities
values('Flawinne',5020);
insert into localities
values('Malonne',5020);
insert into localities
values('Jambes',5100);
insert into localities
values('Wépion',5100);
insert into localities
values('Dave',5100);
insert into localities
values('Erpent',5101);

/*Insertion des numéros d'urgence*/
insert into EmergencyCalls
values('090010500','Pharmacie de garde','http://www.pharmacie.be/');
insert into EmergencyCalls
values('070245245','Centre antoipoisons','http://www.poisoncentre.be/');
insert into EmergencyCalls
values('0800 32123','Centre de prévention du suicide','http://www.preventionsuicide.be/');
insert into EmergencyCalls
values('0071448000','Centre des brûlés',null);
insert into EmergencyCalls
values('116000','Child focus (disparition et exploitation sexuelle d''enfants)','http://www.childfocus.be/fr/accueil');
insert into EmergencyCalls
values('105','Croix rouge',null);
insert into EmergencyCalls
values('103','Ecoute enfants',null);
insert into EmergencyCalls
values('078154422','Ecoute jeunes',null);
insert into EmergencyCalls
values('0043411099','Parents-secours',null);
insert into EmergencyCalls
values('101','Police fédérale','http://www.polfed.be/');
insert into EmergencyCalls
values('081246611','Police locale Namur',null);
insert into EmergencyCalls
values('081249911','Police locale Saint-servais',null);
insert into EmergencyCalls
values('112','Pompiers Chaussée de Liège 55 5100 Namur','http://www.namur.be/vivre-a-namur/zone-nage.be');
insert into EmergencyCalls
values('081307810','SOS coupure-électricité',null);
insert into EmergencyCalls
values('070233001','SOS pollution',null);
insert into EmergencyCalls
values('025489808','SOS solitude',null);
insert into EmergencyCalls
values('023543636','SOS viol',null);
insert into EmergencyCalls
values('080012420','Urgences sociales',null);

/*-----------------------------------Hôpitaux-----------------------------*/
insert into Hospitals([URLWebSite]
           ,[EmergencyPhone]
           ,[Name]
           ,[PhoneNumber]
           ,[Fax]
           ,[Email]
           ,[Street]
           ,[Number]
		   ,[longitude]
           ,[latitude]
           ,[Locality_City]
           ,[Locality_PostalCode])
values(
	'https://www.chrn.be/',
	'081726707',
	'Centre hospitalier regional de namur et maternite - CHRN',
	'081726111',
	'081726805',
	'direction@chrnamur.be',
	'Avenue Albert 1er',
	'185',
	4.88616,
	50.46708,
	'Namur',
	5000
);

insert into Hospitals([URLWebSite]
           ,[EmergencyPhone]
           ,[Name]
           ,[PhoneNumber]
           ,[Fax]
           ,[Email]
           ,[Street]
           ,[Number]
		   ,[longitude]
           ,[latitude]
           ,[Locality_City]
           ,[Locality_PostalCode])
values(
	'http://www.cmsenamur.be',
	'081720409',
	'Clinique et maternité sainte-elisabeth - cmsenamur',
	'081720411',
	'081720431',
	'info@csenamur.be',
	'Place Louise Godin',
	'15',
	 4.84313,
	50.46012,
	'Namur',
	5000
);

insert into Hospitals([URLWebSite]
           ,[EmergencyPhone]
           ,[Name]
           ,[PhoneNumber]
           ,[Fax]
           ,[Email]
           ,[Street]
           ,[Number]
		   ,[longitude]
           ,[latitude]
           ,[Locality_City]
           ,[Locality_PostalCode])
values(
	null,
	'081209100',
	'Clinique Saint-Luc',
	'081209111',
	'081209198',
	'stluc.bouge@skynet.be',
	'Rue Saint-Luc',
	'8',
	 4.88372,
	50.47665,
	'Bouge',
	5004
);

insert into Hospitals([URLWebSite]
           ,[EmergencyPhone]
           ,[Name]
           ,[PhoneNumber]
           ,[Fax]
           ,[Email]
           ,[Street]
           ,[Number]
		   ,[longitude]
           ,[latitude]
           ,[Locality_City]
           ,[Locality_PostalCode])
values(
	null,
	null,
	'Clinique Saint-Martin',
	'081302886',
	'081306479',
	null,
	'Rue Sait-Hubert',
	'84',
	 4.87553,
	50.42943,
	'Dave',
	5100
);

insert into Hospitals([URLWebSite]
           ,[EmergencyPhone]
           ,[Name]
           ,[PhoneNumber]
           ,[Fax]
           ,[Email]
           ,[Street]
           ,[Number]
		   ,[longitude]
           ,[latitude]
           ,[Locality_City]
           ,[Locality_PostalCode])
values(
	'http://www.foyersaintfrancois.be',
	null,
	'Foyer Saint-François (Soins palliatifs)',
	'081741300',
	'081732412',
	'direction@foyersaintfrancois.be',
	'Rue Louis Loiseau',
	'39A',
	 4.83852,
	50.456854,
	'Namur',
	5000
);

insert into Hospitals([URLWebSite]
           ,[EmergencyPhone]
           ,[Name]
           ,[PhoneNumber]
           ,[Fax]
           ,[Email]
           ,[Street]
           ,[Number]
		   ,[longitude]
           ,[latitude]
           ,[Locality_City]
           ,[Locality_PostalCode])
values(
	'http://www.beauvallon.be/',
	null,
	'Hôpital psychiatrique du Beau-Vallon',
	'081721111',
	'081721120',
	null,
	'Rue de Bricgniot',
	'205',
	 4.826336,
	50.481864,
	'Saint-servais',
	5002
);
/*-----------------------------------Poste de garde-----------------------------*/
INSERT INTO [dbo].[Postguards]
           ([Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
		   ,[longitude]
           ,[latitude]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(
		'Poste médicale de garde',
		'1733',
		'rue Bourtonbourt',
		'6',
		 4.84097,50.46155,
		'Namur',
		5000
	);

INSERT INTO [dbo].[Doctors]
           ([Name]
           ,[LastName]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
		   ,[longitude]
           ,[latitude]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(
		'François',
		'Paul',
		'081222771',
		'Rue Pépin',
		'15',
		4.86817,
		50.46544
		'Namur',
		5000
	 );

INSERT INTO [dbo].[Doctors]
           ([Name]
           ,[LastName]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
		   ,[longitude]
           ,[latitude]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(
		'Eric',
		'Cornet D''elzius De Peissant',
		'081228542',
		'Rue des Croisiers',
		'31',
		4.86355,
		50.4673,
		'Namur',
		5000
		);
INSERT INTO [dbo].[Doctors]
           ([Name]
           ,[LastName]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
		   ,[longitude]
           ,[latitude]
           ,[Locality_City]
           ,[Locality_PostalCode])
	VALUES(
		'Anne-Catherine',
		'Millet',
		'081260933',
		'Place Mgr. Heylen',
		'15',
		4.86681,
		50.47145, 
		'Namur',
		5000
	);

	/*INSERT INTO [dbo].[Doctors]
           ([Name]
           ,[LastName]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
	VALUES(
		'Jean-Claude',
		'Lambotte',
		'081304701',
		'Rue des Fossés Fleuris',
		'26',
		'Namur',
		5000
	);

	INSERT INTO [dbo].[Doctors]
           ([Name]
           ,[LastName]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
	VALUES(
		'Françoise',
		'Lebon',
		'081222771',
		'Rue pépin',
		'15',
		'Namur',
		5000
	);

	INSERT INTO [dbo].[Doctors]
           ([Name]
           ,[LastName]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
	VALUES(
		'Jean-Baptiste',
		'Lafontaine',
		'081224072',
		'Chaussée de Dinant',
		'115',
		'Namur',
		5000
	);

	INSERT INTO [dbo].[Doctors]
           ([Name]
           ,[LastName]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
	VALUES(
		'kashama',
		'kasongo',
		'081736121',
		'Rue julien colson',
		'29',
		'Namur',
		5000
	);

	INSERT INTO [dbo].[Doctors]
           ([Name]
           ,[LastName]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
	VALUES(
		'michel',
		'navez',
		'081230933',
		'Rue saint-nicolas',
		'61/59',
		'Namur',
		5000
	);



	/*Pharmacies*/
	*/
	INSERT INTO [dbo].[Drugstores]
           ([Watch]
           ,[URLWebSite]
           ,[Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
		   ,[longitude]
           ,[latitude]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(
		0,
		null,
		'Delcourt J.',
		'081226077',
		'Rue de Namur',
		'51',
		4.91651,
		50.46731,
		'Beez',
		5000	 
	 );
	 /*
	 INSERT INTO [dbo].[Drugstores]
           ([Watch]
           ,[URLWebSite]
           ,[Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(
		0,
		'http://www.multipharma.be',
		'Multipharma',
		'081226869',
		'Rue des Croisiers ',
		'29',
		'Namur',
		5000
	 );

	 INSERT INTO [dbo].[Drugstores]
           ([Watch]
           ,[URLWebSite]
           ,[Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(
		0,
		' http://www.superphar.com ',
		'Superphar',
		'081735565',
		'Rue des Echasseurs',
		'2',
		'Namur',
		5000
	 );

	 INSERT INTO [dbo].[Drugstores]
           ([Watch]
           ,[URLWebSite]
           ,[Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(
		0,
		'http://www.pharmacieservais.be',
		'Pharmacie Servais Saint-Remy',
		'081220512',
		' Marché Saint-Remy ',
		'14',
		'Namur',
		5000
	 );

	INSERT INTO [dbo].[Drugstores]
           ([Watch]
           ,[URLWebSite]
           ,[Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(
		0,
		'http://www.epc-familia.be ',
		'Familia',
		'081220064',
		'Rue de l’Ange',
		'41',
		'Namur',
		5000
	 );

	 INSERT INTO [dbo].[Drugstores]
           ([Watch]
           ,[URLWebSite]
           ,[Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(
		0,
		'http://www.pharmaciedes4coins.be',
		'Pharmacie des quatre coins',
		'081223909',
		'Rue Emile Cuvelier',
		'61',
		'Namur',
		5000	 
	 );

	 INSERT INTO [dbo].[Drugstores]
           ([Watch]
           ,[URLWebSite]
           ,[Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(
		0,
		null,
		'Allard Bernadette',
		'081221132',
		'Rue Jean-Baptiste Brabant',
		'9',
		'Namur',
		5000
	 );

	 INSERT INTO [dbo].[Drugstores]
           ([Watch]
           ,[URLWebSite]
           ,[Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(
		0,
		'http://www.pharmacieservais.be ',
		'Pharmacie servais',
		'081223080',
		'Place de la station',
		'17',
		'Namur',
		5000
	 );
	
	INSERT INTO [dbo].[Drugstores]
           ([Watch]
           ,[URLWebSite]
           ,[Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(
		0,
		null,
		'A-L Sprumont',
		'081737529',
		'Rue Patenier',
		'67',
		'Salzinnes',
		5000
	 );

	 INSERT INTO [dbo].[Drugstores]
           ([Watch]
           ,[URLWebSite]
           ,[Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(
		 0,
		' http://www.epc-familia.be',
		'Familia',
		'081736820',
		'Avenue du cardinal mercier',
		'4-6',
		'Salzinnes',
		5000
	 );

	 INSERT INTO [dbo].[Drugstores]
           ([Watch]
           ,[URLWebSite]
           ,[Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(
		 0,
		 null,
		'Mareschal A.',
		'081738556',
		'Rue de Patenier',
		'15',
		'Beez',
		5000
	 );

	 INSERT INTO [dbo].[Drugstores]
           ([Watch]
           ,[URLWebSite]
           ,[Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(

	 INSERT INTO [dbo].[Drugstores]
           ([Watch]
           ,[URLWebSite]
           ,[Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(

	 INSERT INTO [dbo].[Drugstores]
           ([Watch]
           ,[URLWebSite]
           ,[Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(

	 INSERT INTO [dbo].[Drugstores]
           ([Watch]
           ,[URLWebSite]
           ,[Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(

	 INSERT INTO [dbo].[Drugstores]
           ([Watch]
           ,[URLWebSite]
           ,[Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(

	 INSERT INTO [dbo].[Drugstores]
           ([Watch]
           ,[URLWebSite]
           ,[Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(

	 INSERT INTO [dbo].[Drugstores]
           ([Watch]
           ,[URLWebSite]
           ,[Name]
           ,[PhoneNumber]
           ,[Street]
           ,[Number]
           ,[Locality_City]
           ,[Locality_PostalCode])
     VALUES(*/