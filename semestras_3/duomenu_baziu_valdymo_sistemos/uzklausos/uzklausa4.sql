-- SELECT DISTINCT A.Pavadinimas, A.isbn, COUNT(B.isbn) AS egzemplioriu_skaicius
-- FROM Stud.Knyga A, Stud.Egzempliorius B
-- WHERE A.isbn = B.isbn
-- GROUP BY A.Pavadinimas, A.isbn

-- SELECT A.Pavadinimas, A.egzemplioriu_skaicius,
	   -- A.egzemplioriu_skaicius * B.verte AS egzemplioriu_verte
-- FROM Stud.Knyga AS B,
	 -- (
		-- SELECT DISTINCT A.Pavadinimas, A.isbn, COUNT(B.isbn) AS egzemplioriu_skaicius
		-- FROM Stud.Knyga A, Stud.Egzempliorius B
		-- WHERE A.isbn = B.isbn
		-- GROUP BY A.Pavadinimas, A.isbn
	 -- ) AS A
-- WHERE A.isbn = B.isbn

-- WITH B AS(
	-- WITH A AS(
			-- SELECT A.Pavadinimas, A.isbn, COUNT(B.isbn) AS egzemplioriu_skaicius
			-- FROM Stud.Knyga A, Stud.Egzempliorius B
			-- WHERE A.isbn = B.isbn
			-- GROUP BY A.Pavadinimas, A.isbn
		-- )
	-- SELECT A.Pavadinimas, A.egzemplioriu_skaicius, 
		-- COALESCE(B.verte, 15.00) AS egzemplioriu_verte
	-- FROM Stud.Knyga AS B, A
	-- WHERE A.isbn = B.isbn
	     -- )
-- SELECT AVG(egzemplioriu_verte)
-- FROM B

-- WITH B AS (
	-- WITH A AS (
		-- SELECT B.isbn, COALESCE(A.verte, 15.00) AS verte
		-- FROM Stud.Knyga A, Stud.Egzempliorius B
		-- WHERE A.isbn = B.isbn
			  -- )
	-- SELECT AVG(A.verte) AS vertes_vidurkis
	-- FROM A
		   -- )
		   -- SELECT *
			-- FROM B
-- SELECT pavadinimas, COALESCE(C.verte, 15.00) AS knygos_verte
-- FROM Stud.knyga AS C, B
-- WHERE COALESCE(C.verte, 15.00) < B.vertes_vidurkis



--Pavadinimai knygų, kurioms visų egzempliorių bendra vertė yra mažesnė
--už visų knygų egzempliorių bendrų verčių vidurkį. 
--Jei knygos vertė nenurodyta, laikyti, kad ji lygi 15.

--papild.: vertes vidurkiui palikti du skaicius po kablelio

WITH A AS (
	SELECT B.pavadinimas, SUM( COALESCE(B.verte, 15.01) ) AS verte
	FROM Stud.Egzempliorius A, Stud.Knyga B
	WHERE A.isbn = B.isbn
	GROUP BY B.pavadinimas
		  ),
B AS (
	SELECT TRUNC(AVG(verte), 2) AS vertes_vidurkis
	FROM A
	 )
SELECT A.pavadinimas, A.verte, B.vertes_vidurkis
FROM A, B
WHERE A.verte < B.vertes_vidurkis
