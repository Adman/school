DROP TABLE IF EXISTS vysledok CASCADE;
DROP TABLE IF EXISTS pridelenie CASCADE;
DROP TABLE IF EXISTS otazka_test CASCADE;
DROP TABLE IF EXISTS test CASCADE;
DROP TABLE IF EXISTS otazka CASCADE;
DROP TABLE IF EXISTS odpoved CASCADE;
DROP TABLE IF EXISTS ucitel CASCADE;
DROP TABLE IF EXISTS student CASCADE;


CREATE TABLE student (
	id serial NOT NULL primary key,
	meno varchar(20) NOT NULL,
	priezvisko varchar(20) NOT NULL

);
CREATE TABLE ucitel (
	id serial NOT NULL primary key,
	meno varchar(20) NOT NULL,
	priezvisko varchar(20) NOT NULL
);
CREATE TABLE otazka (
	id serial NOT NULL primary key,
	text varchar(255) NOT NULL,
	spravne varchar(1) NOT NULL,
	nespravne1 varchar(1) NOT NULL,
	nespravne2 varchar(1) NOT NULL,
	nespravne3 varchar(1) NOT NULL
);
CREATE TABLE test (
	id serial NOT NULL primary key,
	nazov varchar(50),
	ucitel_id integer NOT NULL,
	FOREIGN KEY (ucitel_id) REFERENCES ucitel (id)
		ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE otazka_test (
	id serial NOT NULL primary key,
	otazka_id integer NOT NULL,
	test_id integer NOT NULL,
	FOREIGN KEY (otazka_id) REFERENCES otazka (id)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (test_id) REFERENCES test (id)
		ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE pridelenie (
	id serial NOT NULL primary key,
	ucitel_id integer NOT NULL,
	student_id integer NOT NULL,
	test_id integer NOT NULL,
	FOREIGN KEY (ucitel_id) REFERENCES ucitel (id)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (student_id) REFERENCES student (id)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (test_id) REFERENCES test (id)
		ON DELETE CASCADE ON UPDATE CASCADE,
	cas timestamp
);
CREATE TABLE odpoved (
	id serial NOT NULL primary key,	
	text varchar(1) NOT NULL,
	pridelenie_id integer NOT NULL,
	otazka_test_id integer NOT NULL,
	FOREIGN KEY (pridelenie_id) REFERENCES pridelenie (id)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (otazka_test_id) REFERENCES otazka_test (id)
		ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE vysledok (
	id serial NOT NULL primary key,
	cas timestamp,
	skore real CHECK (skore >= 0 AND skore <= 100),
	pridelenie_id integer NOT NULL,
	FOREIGN KEY (pridelenie_id) REFERENCES pridelenie (id)
		ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO student(meno, priezvisko)
VALUES
('Fero', 'Taraba'),
('Jozef', 'Mrkva'),
('Janko', 'Hrasko'),
('Stefan', 'Vesely'),
('Vinco', 'Smutny');

INSERT INTO ucitel(meno, priezvisko)
VALUES
('Feroslav', 'Gurmansky'),
('Blabol', 'Spekulant'),
('Dobrak', 'Ucitel'),
('Zlo', 'Ucitel'),
('Jozko', 'Novak');

INSERT INTO otazka(text, spravne, nespravne1, nespravne2, nespravne3)
VALUES
('Kolko je 1+0?', 'A', 'B', 'C', 'D'),
('Ktore zviera je najvacsie?', 'D', 'A', 'B', 'C'),
('Ktory dopravny prostriedok ma 4 kolesa?', 'C', 'A', 'B', 'D'),
('V ktorom sporte sa pouziva palka?', 'A', 'B', 'C', 'D'),
('Ktora fakulta je najlepsia?', 'B', 'A', 'C', 'D');

INSERT INTO test(nazov, ucitel_id)
VALUES
('Skuskovy test', 1),
('Mala pisomka', 1),
('Zapocet', 2),
('Rozcvicka', 3),
('Previerka', 4);

INSERT INTO otazka_test(otazka_id, test_id)
VALUES
(1, 1),(2, 1),(4, 1),
(1, 2),(3, 2),
(2, 3),(4, 3),(5, 3),
(1, 4),
(1, 5);

INSERT INTO pridelenie(ucitel_id, student_id, test_id, cas)
VALUES
(1, 1, 1, '1999-09-08 17:00:00'),
(1, 2, 1, '1999-09-08 17:00:00'),
(1, 3, 1, '1999-10-09 08:00:00'),
(1, 1, 2, '1999-11-08 12:00:00'),
(1, 4, 5, '1999-12-08 14:30:00'),
(2, 2, 4, '1999-01-08 08:20:00'),
(2, 3, 4, '2000-01-08 08:10:00'),
(3, 3, 3, '2000-01-08 15:00:00'),
(3, 4, 3, '2000-01-08 10:00:00'),
(3, 5, 3, '2000-01-08 20:00:00');

INSERT INTO odpoved(text, pridelenie_id, otazka_test_id)
VALUES
('A', 1, 1),('D', 1, 2),/*('A', 1, 3),*/
('C', 2, 1),('B', 2, 2),('A', 2, 3),
('A', 3, 1),('D', 3, 2),('A', 3, 3),
('C', 4, 4),('D', 4, 5),
('A', 5, 10),
('A', 6, 9),
('A', 7, 9),
('A', 8, 6),('B', 8, 7),('C', 8, 8),
('B', 9, 6),('B', 9, 7),('C', 9, 8);

INSERT INTO vysledok(cas, skore, pridelenie_id)
VALUES
('1999-09-08 18:20:06', 74, 1),
('1999-09-10 20:00:00', 95, 1),
('1999-09-08 18:27:06', 30, 2),
('1999-10-09 10:05:06', 100, 3),
('1999-11-08 14:05:06', 1, 4),
('1999-12-08 17:05:06', 85, 5),
('2000-01-08 10:05:06', 49, 6),
('2000-01-08 09:05:06', 89, 7),
('2000-01-08 16:05:06', 79, 8),
('2000-01-08 12:05:06', 23, 9);

UPDATE test SET ucitel_id=5 WHERE ucitel_id=1;

DELETE FROM test WHERE id=2;

ALTER TABLE pridelenie ADD COLUMN deadline timestamp;

SELECT s.meno, s.priezvisko, t.nazov AS NazovTestu,
       p.cas AS CasPridelenia, MAX(v.cas) AS CasVypracovania
FROM student s, test t,
     pridelenie p LEFT JOIN vysledok v ON p.id=v.pridelenie_id
WHERE s.id=p.student_id AND p.test_id=t.id
GROUP BY p.id, s.meno, s.priezvisko, t.nazov, p.cas
ORDER BY p.cas DESC;


WITH max_vysledok AS (
	SELECT MAX(v.cas) AS cas, v.pridelenie_id
	FROM vysledok v
	GROUP BY v.pridelenie_id
)
SELECT s.meno, s.priezvisko, t.nazov AS NazovTestu, p.cas AS CasPridelenia,
       mv.cas AS CasVypracovania, v.skore AS VysledokPercenta
FROM student s, test t,
     (pridelenie p LEFT JOIN max_vysledok mv ON p.id=mv.pridelenie_id) LEFT JOIN
	vysledok v ON (v.pridelenie_id=p.id AND v.cas=mv.cas)
WHERE s.id=p.student_id AND p.test_id=t.id
ORDER BY p.cas DESC;


WITH odpovedal AS (
	SELECT p.id AS pridelenie_id, o.otazka_test_id
	FROM pridelenie p, otazka_test ot, odpoved o
	WHERE p.test_id=ot.test_id AND p.id=o.pridelenie_id
),
nedokoncil AS (
	SELECT DISTINCT p.id AS pridelenie_id
	FROM pridelenie p, otazka_test ot
	WHERE p.test_id=ot.test_id AND
	    NOT EXISTS (SELECT * FROM odpovedal o
			WHERE o.pridelenie_id=p.id AND o.otazka_test_id=ot.id)
),
max_vysledok AS (
	SELECT MAX(v.cas) AS cas, v.pridelenie_id
	FROM vysledok v
	GROUP BY v.pridelenie_id
)
SELECT s.meno, s.priezvisko, t.nazov AS NazovTestu,
       p.cas AS CasPridelenia, v.skore AS VysledokPercenta,
       CASE
           WHEN (n.pridelenie_id IS NULL) THEN 'ano'
           ELSE 'nie'
       END AS dokoncil
FROM student s, test t,
     pridelenie p LEFT JOIN max_vysledok mv ON p.id=mv.pridelenie_id
         LEFT JOIN nedokoncil n ON n.pridelenie_id=p.id
	 LEFT JOIN vysledok v ON (v.pridelenie_id=p.id AND v.cas=mv.cas)
WHERE s.id=p.student_id AND p.test_id=t.id
ORDER BY p.cas DESC;


WITH failed AS (
	SELECT o.id AS otazka_id
	FROM otazka o, otazka_test ot, odpoved od
	WHERE o.id=ot.otazka_id AND ot.id=od.otazka_test_id AND o.spravne != od.text
)
SELECT o.text, o.spravne
FROM otazka o
WHERE NOT EXISTS (SELECT * FROM failed f WHERE f.otazka_id=o.id);
