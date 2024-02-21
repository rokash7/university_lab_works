INSERT INTO filmas VALUES('Schindler''s List', '03:15:00', 89);
INSERT INTO filmas VALUES('Pulp Fiction', '02:34:00', 89);
INSERT INTO filmas VALUES('Se7en', '02:07:00', 86);
INSERT INTO filmas VALUES('The Godfather', '02:55:00', 92);
INSERT INTO filmas VALUES('Venom: Let There Be Carnage', '01:37:00', 60);

INSERT INTO sale (Vietu_skaicius) VALUES(50);
INSERT INTO sale (Vietu_skaicius) VALUES(100);
INSERT INTO sale (Vietu_skaicius) VALUES(150);

INSERT INTO seansas VALUES(1, '2021-12-06', '18:30:00', 'Schindler''s List', 1);
INSERT INTO seansas VALUES(2, '2021-12-07', '19:00:00', 'Se7en', 1);
INSERT INTO seansas VALUES(3, '2021-12-07', '19:00:00', 'Schindler''s List', 2);
INSERT INTO seansas VALUES(4, '2021-12-08', '12:00:00', 'Se7en', 1);
INSERT INTO seansas VALUES(5, '2021-12-08', '12:00:00', 'Schindler''s List', 2);
INSERT INTO seansas VALUES(6, '2021-12-08', '12:00:00', 'Pulp Fiction', 3);
INSERT INTO seansas VALUES(7, '2021-12-08', '19:00:00', 'Se7en', 2);

INSERT INTO bilietas (Nr, Kaina, Seanso_Nr) VALUES(1, 6, 1);
INSERT INTO bilietas VALUES(2, 6, 'grynais', 1);
INSERT INTO bilietas VALUES(3, 6, 'grynais', 1);
INSERT INTO bilietas (Nr, Kaina, Seanso_Nr) VALUES(4, 6, 2);
INSERT INTO bilietas VALUES(5, 6, 'grynais', 1);
INSERT INTO bilietas VALUES(6, 6, 'grynais', 2);
INSERT INTO bilietas VALUES(7, 5, 'kortele', 3);
INSERT INTO bilietas (Nr, Kaina, Seanso_Nr) VALUES(8, 6, 2);
INSERT INTO bilietas VALUES(9, 5, 'kortele', 2);
INSERT INTO bilietas (Nr, Kaina, Seanso_Nr) VALUES(10, 6, 4);
INSERT INTO bilietas VALUES(11, 5, 'kortele', 1);
INSERT INTO bilietas VALUES(12, 5, 'kortele', 1);
INSERT INTO bilietas VALUES(13, 5, 'grynais', 6);
INSERT INTO bilietas VALUES(14, 5, 'kortele', 6);
INSERT INTO bilietas VALUES(15, 5, 'kortele', 5);
INSERT INTO bilietas VALUES(16, 5, 'kortele', 1);
INSERT INTO bilietas VALUES(17, 5, 'kortele', 1);
INSERT INTO bilietas VALUES(18, 5, 'kortele', 1);
INSERT INTO bilietas (Nr, Kaina, Seanso_Nr) VALUES(19, 6, 1);

