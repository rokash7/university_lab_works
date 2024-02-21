SELECT A.Pavarde, COUNT(DISTINCT A.Vardas)-1 AS bendrapavardziu_skaicius,
	   SUM(B.Puslapiai) AS bendras_puslapiu_skaicius,
	   COUNT(A.isbn) AS knygu_skaicius
FROM Stud.Autorius A, Stud.Knyga B
WHERE A.isbn = B.isbn
GROUP BY A.Pavarde HAVING COUNT(A.isbn)>1
ORDER BY bendrapavardziu_skaicius
--pridetas knygu skaicius
--istrinta DISTINCT pirmoje eiluteje: SELECT [DISTINCT] A.Pavarde
