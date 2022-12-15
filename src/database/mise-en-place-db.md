# Mise en place de la base de données

Pour le projet, choix d'une base de données PostgreSQL 15.1 gérée avec pgAdmin 4 v6.15.

## Création de la base de données 

```
-- DROP DATABASE IF EXISTS auction_rocket_db;

CREATE DATABASE auction_rocket_db
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
```

## Création d'un db_owner

```
CREATE ROLE auction_rocket_db_owner WITH
	LOGIN
	NOSUPERUSER
	NOCREATEDB
	NOCREATEROLE
	INHERIT
	NOREPLICATION
	CONNECTION LIMIT -1
	PASSWORD 'db_owner';
	
ALTER DATABASE auction_rocket_db OWNER TO auction_rocket_db_owner;
```

## Création des tables

```
-- Database: auction_rocket_db

-- DROP TABLE IF EXISTS public.categories;

CREATE TABLE IF NOT EXISTS public.categories (
	no_categorie   INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (INCREMENT BY 1),
	libelle        VARCHAR(30) NOT NULL
);

ALTER TABLE categories ADD constraint categorie_pk PRIMARY KEY (no_categorie);

-- DROP TABLE IF EXISTS public.retraits;

CREATE TABLE retraits (
	no_article       INTEGER NOT NULL,
	rue              VARCHAR(30) NOT NULL,
	code_postal      VARCHAR(15) NOT NULL,
	ville            VARCHAR(30) NOT NULL
);

ALTER TABLE retraits ADD constraint retrait_pk PRIMARY KEY  (no_article);


-- DROP TABLE IF EXISTS public.encheres;

CREATE TABLE IF NOT EXISTS public.encheres (
    no_enchere 			INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (INCREMENT BY 1),
    no_utilisateur 	INTEGER NOT NULL,
    no_article 			INTEGER NOT NULL,
    date_enchere 		TIMESTAMP NOT NULL,
    montant_enchere 	INTEGER NOT NULL
);

ALTER TABLE encheres ADD constraint enchere_pk PRIMARY KEY (no_enchere);
-- DROP TABLE IF EXISTS public.utilisateurs;

CREATE TABLE utilisateurs (
    no_utilisateur   INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (INCREMENT BY 1),
    pseudo           VARCHAR(30) NOT NULL,
    nom              VARCHAR(30) NOT NULL,
    prenom           VARCHAR(30) NOT NULL,
    email            VARCHAR(100) NOT NULL,
    telephone        VARCHAR(15),
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(10) NOT NULL,
    ville            VARCHAR(30) NOT NULL,
    mot_de_passe     VARCHAR(30) NOT NULL,
    credit           INTEGER NOT NULL DEFAULT 0,
    administrateur   BIT NOT NULL DEFAULT '0'
);

ALTER TABLE utilisateurs ADD constraint utilisateur_pk PRIMARY KEY (no_utilisateur);
ALTER TABLE utilisateurs ADD constraint utilisateur_u_pseudo UNIQUE (pseudo);
ALTER TABLE utilisateurs ADD constraint utilisateur_u_email UNIQUE (email);

-- DROP TABLE IF EXISTS public.articles;

CREATE TABLE articles (
    no_article                    INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (INCREMENT BY 1),
    nom_article                   VARCHAR(30) NOT NULL,
    description                   VARCHAR(300) NOT NULL,
	 date_debut_encheres           TIMESTAMP NOT NULL,
    date_fin_encheres             TIMESTAMP NOT NULL,
    prix_initial                  INTEGER,
    prix_vente                    INTEGER,
    no_utilisateur                INTEGER NOT NULL,
    no_categorie                  INTEGER NOT NULL,
	 etat_vente					 		VARCHAR(30) NOT NULL DEFAULT ('non débuté','en cours','vendu')
);

ALTER TABLE articles ADD constraint articles_pk PRIMARY KEY (no_article);

-- contraintes entre tables :

-- DROP TABLE articles, categories, encheres, retraits, utilisateurs CASCADE;

ALTER TABLE encheres
    ADD CONSTRAINT encheres_utilisateur_fk FOREIGN KEY ( no_utilisateur ) REFERENCES utilisateurs ( no_utilisateur )
		ON DELETE CASCADE 
    	ON UPDATE NO ACTION;
    	
ALTER TABLE encheres
    ADD CONSTRAINT encheres_articles_fk FOREIGN KEY ( no_article ) REFERENCES articles ( no_article )
		ON DELETE CASCADE 
    	ON UPDATE NO ACTION;
    	
ALTER TABLE retraits
    ADD CONSTRAINT retraits_articles_fk FOREIGN KEY ( no_article ) REFERENCES articles ( no_article )
		ON DELETE CASCADE 
    	ON UPDATE NO ACTION;
    	
ALTER TABLE articles
    ADD CONSTRAINT articles_categories_fk FOREIGN KEY ( no_categorie ) REFERENCES categories ( no_categorie )
		ON DELETE NO ACTION 
    	ON UPDATE NO ACTION;
    	
ALTER TABLE articles
    ADD CONSTRAINT articles_utilisateur_fk FOREIGN KEY ( no_utilisateur ) REFERENCES utilisateurs ( no_utilisateur )
		ON DELETE NO ACTION 
    	ON UPDATE NO ACTION;
```

> En PostgreSQL, `GENERATED ALWAYS AS IDENTITY (INCREMENT BY 1)` est l'équivalent de `IDENTITY(1,1)` de SQL Server.

Choix d'avoir un `timestamp` pour les variables concernant les dates.

Choix des états de vente : "non débuté", "en cours", "vendu"

  - si un article atteint la date de fin d'enchères sans être vendu, son état revient à "non débuté" et c'est à l'utilisateur de remettre une date ou de supprimer l'article
  - contrainte sur les valeurs par défaut

Choix pour les `ON DELETE CASCADE` :

  - quand un utilisateur est supprimé, ses enchères sont également supprimées
  - quand un article est supprimé, ses retraits sont également supprimés
  - quand un article est supprimé, ses enchères sont également supprimés

Choix de valeurs par défaut dans `utilisateurs` avec credit = 0 et administrateur = 0.

Choix de 100 caractères autorisés pour l'email d'un utilisateur.

## Affichage des tables

```
SELECT no_categorie, libelle FROM public.categories;

SELECT no_enchere, no_utilisateur, no_article, date_enchere, montant_enchere FROM public.encheres;

SELECT no_article, rue, code_postal, ville FROM public.retraits;

SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM public.utilisateurs;

SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente FROM public.articles;
```

## Ajout de données test

```
-- DELETE FROM public.categories;

INSERT INTO public.categories(libelle) VALUES ('Art');
INSERT INTO public.categories(libelle) VALUES ('Musique');
INSERT INTO public.categories(libelle) VALUES ('Littérature');
INSERT INTO public.categories(libelle) VALUES ('Jeux');
INSERT INTO public.categories(libelle) VALUES ('Electoménager');
INSERT INTO public.categories(libelle) VALUES ('Véhicules');
INSERT INTO public.categories(libelle) VALUES ('Vêtements');
INSERT INTO public.categories(libelle) VALUES ('Chaussures');
INSERT INTO public.categories(libelle) VALUES ('Bijoux');

-- DELETE FROM public.utilisateurs;

INSERT INTO public.utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES ('lolodu33', 'çariebouette', 'lorann', 'lorann@mail.fr', 'null', '12 rue des Marguerites', '33000', 'Bordeaux', 'mdp', 10000, '1');
INSERT INTO public.utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES ('tibtibdu38', 'riema', 'tibo', 'tibo@mail.fr', 'null', '852 rue des Pensées', '38000', 'Grenoble', 'mdp', 5000, '0');
INSERT INTO public.utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES ('foxyfox', 'Mulder', 'Fox', 'fox@mail.fr', 'null', '4 rue des Tulipes', '0123456789', 'Washington', 'mdp', 0, '0');

-- DELETE FROM public.articles;

INSERT INTO public.articles(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Bibelot moche mais ancien', 'Un bibelot qui est moche mais ancien donc cher', '01/12/2022  00:00:00', '24/12/2022  00:00:00', 500, 0, 3, 1, 'en cours');
INSERT INTO public.articles(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('CD Céline', 'TOUS les CD jamais sortis de Céline DION, la seule et unique', '05/12/2022  00:08:00', '24/12/2022  00:08:00', 65, 0, 3, 2, 'en cours');
INSERT INTO public.articles(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Collection HP', 'Collection de la saga Harry Potter', '13/12/2022  00:08:00', '24/12/2022  00:00:00', 37, 0, 3, 3, 'en cours');
INSERT INTO public.articles(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Minecraft', 'Jeu vidéo bac à sable sur PC', '11/12/2022  00:08:00', '24/12/2022  00:00:00', 12, 0, 3, 4, 'en cours');
INSERT INTO public.articles(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Cuisinière', 'Cuisinière à induction, 4 foyers', '11/11/2022  00:16:00', '18/11/2022  00:16:00', 250, 356, 1, 5, 'vendu');
INSERT INTO public.articles(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Vélo avec petites roulettes', 'Vélo pour enfants avec les petites roulettes, un peu vieillot mais fonctionnel', '08/10/2022  00:16:00', '23/10/2022  00:16:00', 8, 13, 1, 6, 'vendu');
INSERT INTO public.articles(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Vêtements confortables homme', 'Joggings, t-shirts, vestes et pulls de sport en taille L', '28/11/2022  00:16:00', '03/12/2022  00:16:00', 26, 48, 1, 7, 'vendu');
INSERT INTO public.articles(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Escarpins de torture', 'Escarpins de 14cm de talon, sans plateforme, servis une fois', '26/09/2022  00:16:00', '07/12/2022  00:16:00', 25, 27, 1, 8, 'vendu');
INSERT INTO public.articles(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Montre connectée pas cher', 'Montre de marque obscure, mais elle donne l heure, compte les pas et sert de minuteur', '01/01/2023  00:16:00', '05/01/2023  00:16:00', 23, 0, 1, 9, 'non débuté');
INSERT INTO public.articles(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) 
VALUES ('Une auction terminée', 'blop', '01/12/2022  00:00:00', '04/12/2022  00:00:00', 5, 8, 3, 1, 'vendu');
INSERT INTO public.articles(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) 
VALUES ('auction terminée', 'blop encore', '01/12/2022  00:00:00', '04/12/2022  00:00:00', 5, 8, 3, 1, 'vendu');
INSERT INTO public.articles(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) 
VALUES ('Une auction pas commencée', 'bibop', '25/12/2022  00:00:00', '29/12/2022  00:00:00', 5, 8, 3, 1, 'non débuté');
INSERT INTO public.articles(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) 
VALUES ('auction pas commencée', 'bibopbop', '25/12/2022  00:00:00', '29/12/2022  00:00:00', 5, 8, 3, 1, 'non débuté');

--encheres en cours lorann et tibo sur l'article de foxyfox
INSERT INTO public.encheres(no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (1, 2, '14/12/2022  00:08:00', 70);
INSERT INTO public.encheres(no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (2, 2, '14/12/2022  00:09:00', 75);
INSERT INTO public.encheres(no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (1, 2, '14/12/2022  00:10:00', 80);
--encheres remportées par lorann sur l'article de foxyfox
INSERT INTO public.encheres(no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (1, 13, '03/12/2022  00:09:00', 8);
```

## Filtres pour les articles

```
-- SELECT_ALL = 
		SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente FROM articles;

-- SELECT_ALL_AUCTIONS = 
		SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente FROM articles WHERE no_utilisateur !=?;

-- SELECT_ALL_ONGOING_AUCTIONS = 
		SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente FROM articles WHERE no_utilisateur !=?  AND etat_vente ='en cours';

-- SELECT_ONGOING_USER_AUCTIONS = 
		SELECT a.no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, a.no_utilisateur, no_categorie, etat_vente, u.pseudo FROM articles a INNER JOIN encheres e ON a.no_article = e.no_article INNER JOIN utilisateurs u ON e.no_utilisateur = u.no_utilisateur WHERE a.no_utilisateur !=? AND a.etat_vente ='en cours' AND e.no_utilisateur =?;

-- SELECT_WON_USER_AUCTIONS = 
		SELECT a.no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, a.no_utilisateur, no_categorie, etat_vente, u.pseudo FROM articles a INNER JOIN encheres e ON a.no_article = e.no_article INNER JOIN utilisateurs u ON e.no_utilisateur = u.no_utilisateur WHERE a.no_utilisateur !=? AND a.etat_vente ='vendu' AND e.no_utilisateur =?;

-- SELECT_ALL_SALES =
		SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente FROM articles WHERE no_utilisateur =?;

-- SELECT_ONGOING_USER_SALES = 
		SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente FROM articles WHERE no_utilisateur =? AND etat_vente ='en cours';

-- SELECT_UNSTARTED_USER_SALES = 
		SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente FROM articles WHERE no_utilisateur =? AND etat_vente ='non débuté';

-- SELECT_ENDED_USER_SALES = 
		SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente FROM articles WHERE no_utilisateur =? AND etat_vente ='vendu';

```

Choix de garder une clause `WHERE` redondante dans `SELECT_ONGOING_USER_AUCTIONS` et `SELECT_WON_USER_AUCTIONS` où on précise à la fois le nom de l'utilisateur qui vend l'article et celui qui choisit d'enchérir (ici, l'utilisateur connecté), ainsi que l'état de vente ('en cours' ou 'vendu').

Choix d'ajouter un attribut `utilisateurEcherisseur` à l'objet `Article` dans la BO : contournement de la difficulté de transformer la liaison de trois tables SQL.