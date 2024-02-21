--kiekvienas stulpelio tipas
-------------------------------------
-- SELECT data_type
-- FROM INFORMATION_SCHEMA.COLUMNS
-- GROUP BY data_type


--lenteles
-------------------------------------
-- SELECT Table_name
-- FROM INFORMATION_SCHEMA.TABLES
-- GROUP BY Table_name
 
 

 -- Kiekvienam stulpelio tipui skaičius lentelių, 
 -- neturinčių nė vieno tokio tipo stulpelio.
 
 --skaiciuoti lenteles, o ne pavadinimus

WITH A AS (
		SELECT COUNT(Table_name) AS lenteliu_skaicius
		FROM INFORMATION_SCHEMA.TABLES
	)
SELECT data_type,
	A.lenteliu_skaicius - COUNT (DISTINCT(Table_schema || Table_name)) AS skaicius
FROM A, INFORMATION_SCHEMA.COLUMNS
GROUP BY data_type, A.lenteliu_skaicius

