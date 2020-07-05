INSERT INTO "smer"("id", "naziv","oznaka")
VALUES(nextval('smer_seq'), 'Inzenjerski menadzment', 'IM');
INSERT INTO "smer"("id", "naziv","oznaka")
VALUES(nextval('smer_seq'), 'Industrijsko inzenjerstvo', 'II');
INSERT INTO "smer"("id", "naziv","oznaka")
VALUES(nextval('smer_seq'), 'Primenjeno softversko inzenjerstvo', 'IS');
INSERT INTO "smer"("id", "naziv","oznaka")
VALUES(nextval('smer_seq'), 'Merenje i regulacija', 'MR');

INSERT INTO "grupa"("id", "oznaka","smer")
VALUES(nextval('grupa_seq'), 'IM', '1');
INSERT INTO "grupa"("id", "oznaka","smer")
VALUES(nextval('grupa_seq'), 'II', '2');
INSERT INTO "grupa"("id", "oznaka","smer")
VALUES(nextval('grupa_seq'), 'IT', '3');
INSERT INTO "grupa"("id", "oznaka","smer")
VALUES(nextval('grupa_seq'), 'IS', '4');

INSERT INTO "projekat"("id", "naziv","oznaka","opis")
VALUES(nextval('projekat_seq'), 'Razvoj programskih proizvoda', 'IM','Projektovanje softvera');
INSERT INTO "projekat"("id", "naziv","oznaka","opis")
VALUES(nextval('projekat_seq'), 'Razvoj programskih proizvoda', 'II','Projektovanje softvera');
INSERT INTO "projekat"("id", "naziv","oznaka","opis")
VALUES(nextval('projekat_seq'), 'Projektovanje baze podataka', 'IM','Kompletan prikaz projektovanja jedne baze podataka');
INSERT INTO "projekat"("id", "naziv","oznaka","opis")
VALUES(nextval('projekat_seq'), 'Razvoj programskih proizvoda', 'II','Projektovanje softvera');
INSERT INTO "projekat"("id", "naziv","oznaka","opis")
VALUES(nextval('projekat_seq'), 'Strateski menadzment', 'IM','Razvijanje strategije poslovanja');
INSERT INTO "projekat"("id", "naziv","oznaka","opis")
VALUES(nextval('projekat_seq'), 'Arhitektura informacionih sistema i racunarskih mreza', 'IM','Projektovanje softvera');

INSERT INTO "student"("id", "ime","prezime","broj_indeksa","grupa","projekat")
VALUES(nextval('student_seq'), 'Marko', 'Markovic','IM 1/2016','1 ', '1');
INSERT INTO "student"("id", "ime","prezime","broj_indeksa","grupa","projekat")
VALUES(nextval('student_seq'), 'Pera', 'Peric','IM 2/2016','3', '2');
INSERT INTO "student"("id", "ime","prezime","broj_indeksa","grupa","projekat")
VALUES(nextval('student_seq'), 'Ana', 'Ilic','II 1/2016','1 ', '3');
INSERT INTO "student"("id", "ime","prezime","broj_indeksa","grupa","projekat")
VALUES(nextval('student_seq'), 'Tamara', 'Pavlovic','IM 3/2016','1 ', '4');
