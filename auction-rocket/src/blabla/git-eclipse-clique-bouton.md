# Utiliser Git sur Eclipse (en clique-bouton)

> Il y a moults façons d'arriver au même résultat. Les indications ci-dessous sont quelques-unes des possibilités qui existent.

## Pull

Action pour récupérer les modifications potentielles qui ont été faites par les collègues.

Perspective Git > Clique-droit dans la fenêtre Git Repositories > Pull

Une fenêtre apparait :

1.  _Everything is up to date_ : tout est à jour, rien n'a été modifié
2. _fze_ : la liste des fichiers mis à jour est indiquée, il n'y a pas eu de problèmes lors de la mise à jour
3. _merge_ : il y a un conflit entre les fichiers sur le gitHub et les fichiers en local, la mise à jour n'a pas été possible ! Il faut gérer ce conflit.

## Faire un commit

Faire ses modifications (ajout de packages, classes, jsp...) normalement.

Une fois satisfait.e de l'état du projet, on veut sauvegarder les nouveautés et potentiellement les partager avec ses collègues : c'est le moment de faire un commit.

Perspective Git > Onglet Git Staging :  
Il y a trois rectangles :

- _Unstaged Changes_ : contient les fichiers qui ont été modifié depuis le dernier _Pull_ mais qui __ne sont pas__ sélectionnés pour être envoyé au dépôt lors du commit
- _Staged Changes_ : contient les fichiers qui ont été modifié depuis le dernier _Pull_ mais qui __sont sélectionnés__ pour être envoyé au dépôt lors du commit ; seuls ces fichiers seront mis à jour dans le dépôt
- _Commit Message_ : un commit doit avoir un message explicatif, clair et concis, qui explique les modifications qui sont apportées au projet

Dans _Unstaged Changes_ > Sélectionner les fichiers à commiter > Appuyer sur le `+` (Add selected files to the index) > Ecrire le message du commit > `Commit` ou `Commit and Push`

> `Commit` enregistre les modifications en local uniquement, utile pour sauvegarder un état (un screenshot) du projet à un moment donné.  
`Commit and Push` enregistre les modifications en local ET les envoie sur le dépôt gitHub, ce qui les rend disponibles à tous les membres du projet.

## Push

Action pour envoyer les modifications accumulées en local sous forme de _commits_ au dépôt gitHub, ce qui les rend disponibles à tous les membres du projet.

Perspective Git > Clique-droit dans la fenêtre Git Repositories > Push : on peut laisser par défaut > Push
