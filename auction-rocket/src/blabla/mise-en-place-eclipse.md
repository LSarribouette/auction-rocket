# Mise en place du projet sur Eclipse

1. Création d'un Dynamic Web Project

Perspective JEE > New > Dynamic Web Project

2. Création d'un dépôt git local

Perspective Git > Clone a repository : url (https://github.com/LSarribouette/auction-rocket), token dans le user (à storer au choix) -- le reste par défaut > Finish

> Attention à ne pas enregistrer les deux au même endroit en local.

> Pour que Eclipse mémorise le token sur le long terme : indiquer son user ou email avec le token en password et cocher _Store in Secure Store_.

3. Lier le projet et le dépôt

Perspective JEE > Clique-droit sur le projet > Team > Share project : choix du dépôt > Finish

4. Si début du projet, configurer le .gitignore

Sur ce site : https://www.toptal.com/developers/gitignore, choisir _Java_ et _Eclipse_ et créer le .gitignore.

Copier-coller le contenu dans le .gitignore du projet. Décommenter la ligne avec `.project` (ligne 64 au moment de l'écriture du tuto) et ajouter une ligne juste après avec `.classpath`.

5. Si début du projet, ajout des dossiers à l'index

On ne veut pas tout partager dans le dépôt. On veut : _src_ et _build_ (et leurs descendants), .gitgnore.

Perspective JEE ou Git > Clique-droit sur le dossier ou fichier à ajouter > Team > Add to index