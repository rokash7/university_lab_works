CREATE INDEX IF NOT EXISTS seanso_info
ON seansas (Diena, Laikas, Sales_Nr);

CREATE UNIQUE INDEX IF NOT EXISTS raktas_pavadinimas
ON filmas (Pavadinimas);

-- CREATE VIEW tuscios_sales (sales_nr) AS
-- SELECT sale.Nr
-- FROM sale, seansas
-- WHERE sale.Vietu_skaicius = seansas.Laisvu_vietu_skaicius;

CREATE VIEW geri_filmai (pavadinimas, balai) AS
SELECT filmas.pavadinimas, filmas.Vertinimas
FROM filmas
WHERE Vertinimas >= 70
ORDER BY Vertinimas;

CREATE VIEW parduoti_bilietai (seanso_nr, bilietu_sk) AS
SELECT bilietas.Seanso_Nr, COUNT(bilietas.Nr)
FROM bilietas
GROUP BY bilietas.Seanso_Nr;

-- CREATE VIEW Laisvu_vietu_skaicius (seansas, vietu_skaicius) AS
-- SELECT DISTINCT seansas.Nr, (sale.vietu_skaicius - parduoti_bilietai.bilietu_sk)
-- FROM parduoti_bilietai, sale, seansas
-- WHERE seansas.sales_nr = sale.Nr
-- GROUP BY seansas.nr, sale.vietu_skaicius, parduoti_bilietai.bilietu_sk;

-- CREATE VIEW Laisvu_vietu_skaicius_ (vietu_skaicius) AS
-- SELECT vietu_skaicius
-- FROM Laisvu_vietu_skaicius, seansas
-- WHERE Laisvu_vietu_skaicius.seansas = seansas.Nr;

CREATE MATERIALIZED VIEW rodoma_siandien (pavadinimas, laikas) AS
SELECT seansas.Filmo_Pavadinimas, seansas.Laikas
FROM seansas
WHERE seansas.Diena = current_date
WITH DATA;

REFRESH MATERIALIZED VIEW rodoma_siandien;
