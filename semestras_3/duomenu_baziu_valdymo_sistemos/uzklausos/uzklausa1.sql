SELECT nr, paimta, grazinti, (grazinti - paimta) AS dienos
FROM Stud.Egzempliorius
WHERE
	(grazinti - paimta) > 26
	AND
	(EXTRACT(MONTH FROM paimta) = EXTRACT(MONTH FROM CURRENT_DATE));

--egzempliorius paimtas si menesi


--(make_date(2021, 12, 10) - paimta) > 50;
