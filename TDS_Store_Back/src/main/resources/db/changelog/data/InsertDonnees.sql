INSERT INTO "produit" ("id", "creation_date", "modification_date", "nom", "prix", "prix_achat") VALUES (NEXTVAL('produit_seq'), '2020-04-15 17:06:46.691', '2020-04-15 17:06:46.691', 'Voiture', 100000, 500);
INSERT INTO "produit" ("id", "creation_date", "modification_date", "nom", "prix", "prix_achat") VALUES (NEXTVAL('produit_seq'), '2020-04-15 17:06:46.691', '2020-04-15 17:06:46.691', 'Vélo', 350, 100);

-- Mise à jour du numéro de la séquence
--SELECT setval('produit_seq', COALESCE((SELECT MAX(id)+1 FROM produit),1),false);