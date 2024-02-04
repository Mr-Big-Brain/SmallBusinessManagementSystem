-- 1. Uncoment persistence.xml code to generate whole DB and add admin for a first time
-- 2. Uncoment persistence code to generate whole DB and add admin for a first time

INSERT INTO vartotojotipas(id, finansai, klientai, konfiguracija, pardavimai, sandelis, statistika, pavadinimas)
VALUES
    (2, 0, 0, 0, 1, 1, 0, "Pardavėjas"),
    (3, 1, 0, 0, 0, 0, 1, "Buhalteris"),
    (4, 0, 0, 0, 0, 1, 0, "Sandėlininkas");

INSERT INTO vartotojas(id, apibrezimas, pavarde, prisijungimoVardas, slaptazodis, telefonas, vardas, vartotojoTipas_id)
VALUES
    (2, "Pardavėjas Tomas, g. m. 1998-02-03, tarnavo armijoje", "Petkus", "tomas1", "1fb231672bf08f7e652ab4cbc62e3b1e", "+37086123464", "Tomas", 2),
    (3, "Buhalterė", "Puodžiukas", "gintare1", "c0e519db7e23e0f1daea5cc62804c96d", "860123465", "Gintarė", 3),
    (4, "Pardavėjas", "Kairys", "jonas1", "f6550b1675f141df1a2924e95ed38b20", "+37086123457", "Jonas", 2),
    (5, "Dizaineris ir pardavėjas", "Kolas", "petras1", "bc93b048fe090d5f856716e75e30bf57", "860123456", "Petras", 2),
    (6, "Vyriausias sandėlininkas", "Michailov", "giedrius123", "3662a2fdf85b8e15a6b08bcf3e2d6223", "+37086123458", "Giedrius", 4),
    (7, "Buhalterė internas", "Glikman", "laura13", "4db0f491b6c44d1d9e7e3e02c19fb404", "860123459", "Laura", 3),
    (8, "Sandėlininkė", "Andruškevič", "jurga14", "9ef4aacbb390b92a96ad7a78c2efbd19", "+37086123460", "Jurga", 4),
    (9, "Administratorius", "Volkovas", "admin1", "e00cf25ad42683b3df678c61f42c6bda", "860123461", "Rokas", 1),
    (10, "Pardavėja", "Kondratavičienė", "eglee", "92d27cd7fdcdc4842d49be7c370273d2", "+37086123462", "Eglė", 2),
    (11, "Buhalterė", "Domarkienė", "doma123", "7b4786b0558a99e5e9106395d59ca8b0", "860123463", "Rita", 3);

INSERT INTO produktas(id, pavadinimas, pirkimoKaina, rekomenduojamaKaina, apibrezimas)
VALUES
       (1, "AEG L9WBCN61B Skalbimo mašina", 950, 1084.99,"Didžiausia skalbinių talpa: 10kg
Matmanys: 87x59.7x63.6
Energijos klasė A
Džiovinimas: Yra"),
       (2, "Samsung WW60A3120WE/ LE Skalbimo mašina", 299, 327.45,"Didžiausia skalbinių talpa: 6kg
Energijos klasė: C
Skalbinių džiovinimas: nėra"),
       (3, "Samsung WW60A3120BE/ LE Skalbimo mašina", 246.55, 300.87,"Didžiausia skalbinių talpa: 6kg
Matmenys: 85x60x42cm
Energijos klasė: C
Skalbinių džiovinimas: nėra"),
       (4, "Šaldytuvas Hisense RR58D4AWF", 80.55, 96.7,"Tipas: vienos kameros šaldytuvas
Matmenys: 50x44.5x46.8cm"),
       (5, "Šaldytuvas Samsung RB38A7B4EB1/ EF", 447, 513.28,"Matmenys: 203x59.5x65.8"),
       (6, "Įmontuojama mikrobangų krosnelė AEG MBB1756SEB", 302.56, 349.99,"Visiškai inregruojama mikrobangų krosnelė
Durų atidarymo mechanizmas: Elektroninis
Gaminimo režimai: Mikro bangos
Mikrobangų krosnelės galia: 800 W, 5 lygiai
Spartaus paleidimo funkcija visu pajėgumu su 30 sek. intervalais"),
       (7, "Sharp R200BKW mikrobangų krosnelė", 54.25, 65.49,"Talpa: 20l
Grilis: ne
Galia: 800 W"),
       (8, "Sharp R-242WW mikrobangų krosnelė", 33.24, 57.99,"Talpa: 20l
Grilis: ne
Galia: 800 W"),
       (9, "Beko MOC20100BFB mikrobangų krosnelė", 48.65, 66,"Talpa: 20l
Grilis: ne
Galia: 700 W");


INSERT INTO zyme(id, pavadinimas, tipas)
VALUES
    (1, "BEKO", 1),
    (2, "SAMSUNG", 1),
    (3, "AEG", 1),
    (4, "HISENSE", 1),
    (5, "SHARP", 1),
    (6, "MIKROBANGIŲ KROSNELĖ", 1),
    (7, "ŠALDYTUVAS", 1),
    (8, "SKALBIMO MAŠINA", 1),
    (9, "ALGA", 0),
    (10, "PIRKIMAI", 0),
    (11, "DRAUDIMAS", 0),
    (12, "INVESTICIJOS", 0);

INSERT INTO produktas_zyme(Produktas_id, zymes_id)
VALUES
    (1, 3),
    (1, 8),
    (2, 2),
    (2, 8),
    (3, 2),
    (3, 8),
    (4, 4),
    (4, 7),
    (5, 2),
    (5, 7),
    (6, 6),
    (6, 3),
    (7, 6),
    (7, 5),
    (8, 6),
    (8, 5),
    (9, 6),
    (9, 1);

INSERT INTO klientas(id, imone, pastas, pavarde, telefonas, vardas)
VALUES
    (1, "UAB PELNAS", "eligijus.milosas@gmail.com", "Milošas", "+37058954231", "Eligijus"),
    (2, "UAB GIRTEKA", "benediktas.vanagas@girteka.lt", "Vanagas", "+4586213549", "Benediktas"),
    (3, "UAB PELNAS", "eligijus.milosas@gmail.com", "Milošas", "+37058954231", "Eligijus"),
    (4, "UAB GIRTEKA", "pavzone@gmail.com", "Petkov", "+3702588954", "Algirdas"),
    (5, "", "pavzone@gmail.com", "Petkov", "+3702588954", "Algirdas"),
    (6, "", "tomas.jankauskas@techvilnius.com", "Jankauskas", "+37061234567", "Tomas"),
    (7, "AB PREKYBA", "giedre.rutkauskiene@prekyba.lt", "Rutkauskienė", "+37051234567", "Giedrė"),
    (8, "", "edvardas.cepulis@logistika.lt", "Čepulis", "+37069874563", "Edvardas"),
    (9, "", "aurelija.jonusiene@energija.lt", "Jonišienė", "+37069874123", "Aurelija"),
    (10, "UAB KURJERIS", "vaidas.brazauskas@kurjeris.lt", "Brazauskas", "+37069874123", "Vaidas"),
    (11, "", "diana.sakalauskaite@statyba.lt", "Sakalauskaitė", "+37069874563", "Diana"),
    (12, "AB TECHNO", "linas.jonuska@techno.lt", "Jonuska", "+37069874563", "Linas"),
    (13, "AB ELEKTRA", "rimgaudas.kazlauskas@elektra.lt", "Kazlauskas", "+37069874123", "Rimgaudas"),
    (14, "", "gabija.mikalauskaite@medis.lt", "Mikalauskaitė", "+37069874123", "Gabija"),
    (15, "AB AUTO", "algimantas.pavardenis@auto.lt", "Pavardenis", "+37069874563", "Algimantas"),
    (16, "UAB KOMPAS", "simona.varnelyte@kompas.lt", "Varnelytė", "+37069874123", "Simona"),
    (17, "UAB VERSLAS", "robertas.zubrickas@verslas.lt", "Žubrickas", "+37069874123", "Robertas"),
    (18, "UAB KREDITAS", "vaida.pociute@kreditas.lt", "Pociūtė", "+37069874563", "Vaida"),
    (19, "", "tomas.teatrauskas@teatras.lt", "Teatrauskas", "+37069874563", "Tomas"),
    (20, "", "dainius.jankauskas@baltija.lt", "Jankauskas", "+37069874123", "Dainius"),
    (21, "", "renata.bernotiene@spedition.lt", "Bernotienė", "+37069874123", "Renata"),
    (22, "UAB EKSPERTAS", "laurynas.gedminas@ekspertas.lt", "Gedminas", "+37069874563", "Laurynas"),
    (23, "AB SVEIKATA", "zivile.sveikata@uab.lt", "Sveikata", "+37069874123", "Živilė"),
    (24, "", "mantas.ekonomika@uab.lt", "Ekonomika", "+37069874563", "Mantas"),
    (25, "UAB FERMA", "dainius.ferma@uab.lt", "Ferma", "+37069874123", "Dainius");

insert into komunikacija(id, pavadinimas, apibrezimas, data, klientas_id, produktas_id)
VALUES
    (1, "Domėjosi preke", "Domėjosi skalbimo mašina, bet jos nebuvo", "2024-02-04", 1, 3),
    (2, "Paprašė pranešti", "Paprašė pranešti kai atsiras šaldytuvai, įsigis 4", "2024-02-04", 1, 4),
    (3, "Paprašė pranešti", "Paprašė pranešti kai atsiras indaplovės", "2024-02-03", 2, NULL);

insert into sandeliopreke(id, kiekis, produktas_id)
VALUES
    (1,23,1),
    (2,16,2),
    (3,54,3),
    (4,33,4),
    (5,14,5),
    (6,21,6),
    (7,20,7),
    (8,36,8),
    (9,43,9);