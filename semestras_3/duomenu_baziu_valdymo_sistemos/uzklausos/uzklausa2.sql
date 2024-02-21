SELECT stud.egzempliorius.nr, skaitytojas, stud.skaitytojas.pavarde, metai,
(EXTRACT(YEAR FROM CURRENT_DATE) - Stud.Knyga.metai) AS metu_skirtumas
FROM Stud.Egzempliorius, Stud.Knyga, Stud.Skaitytojas
WHERE Stud.Knyga.Pavadinimas = 'Duomenu bazes'
	AND Stud.Egzempliorius.ISBN = Stud.Knyga.ISBN
	AND Stud.Egzempliorius.Skaitytojas IS NOT NULL
	AND Stud.Egzempliorius.Skaitytojas = Stud.Skaitytojas.nr;
	
	--skaitytojas | pavarde | metai
