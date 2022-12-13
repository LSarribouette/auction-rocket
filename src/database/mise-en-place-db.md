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

-- DROP TABLE IF EXISTS public.encheres;

CREATE TABLE IF NOT EXISTS public.encheres (
    no_enchere 			INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (INCREMENT BY 1),
    no_utilisateur 	INTEGER NOT NULL,
    no_article 			INTEGER NOT NULL,
    date_enchere 		TIMESTAMP NOT NULL,
    montant_enchere 	INTEGER NOT NULL
);

ALTER TABLE encheres ADD constraint enchere_pk PRIMARY KEY (no_enchere);

-- DROP TABLE IF EXISTS public.retraits;

CREATE TABLE retraits (
	 no_article       INTEGER NOT NULL,
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(15) NOT NULL,
    ville            VARCHAR(30) NOT NULL
);

ALTER TABLE retraits ADD constraint retrait_pk PRIMARY KEY  (no_article);

-- DROP TABLE IF EXISTS public.utilisateurs;

CREATE TABLE utilisateurs (
    no_utilisateur   INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (INCREMENT BY 1),
    pseudo           VARCHAR(30) NOT NULL,
    nom              VARCHAR(30) NOT NULL,
    prenom           VARCHAR(30) NOT NULL,
    email            VARCHAR(20) NOT NULL,
    telephone        VARCHAR(15),
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(10) NOT NULL,
    ville            VARCHAR(30) NOT NULL,
    mot_de_passe     VARCHAR(30) NOT NULL,
    credit           INTEGER NOT NULL,
    administrateur   BIT NOT NULL
);

ALTER TABLE utilisateurs ADD constraint utilisateur_pk PRIMARY KEY (no_utilisateur);*
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
    no_categorie                  INTEGER NOT NULL
);

ALTER TABLE articles ADD constraint articles_pk PRIMARY KEY (no_article);

-- contraintes entre tables :

-- DROP TABLE articles, categories, encheres, retraits, utilisateurs CASCADE;

ALTER TABLE articles
    ADD CONSTRAINT encheres_utilisateur_fk FOREIGN KEY ( no_utilisateur ) REFERENCES utilisateurs ( no_utilisateur )
		ON DELETE NO ACTION 
    	ON UPDATE NO ACTION;
    	
ALTER TABLE encheres
    ADD CONSTRAINT encheres_articles_fk FOREIGN KEY ( no_article ) REFERENCES articles ( no_article )
		ON DELETE NO ACTION 
    	ON UPDATE NO ACTION;
    	
ALTER TABLE retraits
    ADD CONSTRAINT retraits_articles_fk FOREIGN KEY ( no_article ) REFERENCES articles ( no_article )
		ON DELETE NO ACTION 
    	ON UPDATE NO ACTION;
    	
ALTER TABLE articles
    ADD CONSTRAINT articles_categories_fk FOREIGN KEY ( no_categorie ) REFERENCES categories ( no_categorie )
		ON DELETE NO ACTION 
    	ON UPDATE NO ACTION;
    	
ALTER TABLE articles
    ADD CONSTRAINT ventes_utilisateur_fk FOREIGN KEY ( no_utilisateur ) REFERENCES utilisateurs ( no_utilisateur )
		ON DELETE NO ACTION 
    	ON UPDATE NO ACTION;
```

> En PostgreSQL, `GENERATED ALWAYS AS IDENTITY (INCREMENT BY 1)` est l'équivalent de `IDENTITY(1,1)` de SQL Server.

> Choix d'avoir un `timestamp` pour les variables concernant les dates.

Afficher les tables :

```
SELECT no_categorie, libelle FROM public.categories;

SELECT no_enchere, no_utilisateur, no_article, date_enchere, montant_enchere FROM public.encheres;

SELECT no_article, rue, code_postal, ville FROM public.retraits;

SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM public.utilisateurs;

SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM public.articles;
```

