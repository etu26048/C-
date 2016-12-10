CREATE TABLE MagicKey (
    cle VARCHAR(10) PRIMARY KEY
);

insert into MagicKey values("1");
insert into MagicKey values("2");
insert into MagicKey values("3");
insert into MagicKey values("4");
insert into MagicKey values("5");

CREATE TABLE User (
    nom VARCHAR(30) PRIMARY KEY,
    age INT(3),
    male BIT,
    hobby VARCHAR(50)
);