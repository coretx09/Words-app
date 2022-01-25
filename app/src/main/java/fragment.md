#FRAGMENT:
Un fragment est simplement un élément réutilisable de l'interface utilisateur de votre application.
Comme les activity, les fragments ont un lifecycle et peuvent répondre aux entrées de l'utilisateur
En raison de l'accent mis sur la réutilisabilité et la modularité, il est même possible que plusieurs
fragments soient hébergés simultanément par une seule activité. 
_Chaque fragment gère son propre lifecycle séparé_.

#FRAGMENT LIFECYCLE:
Comme les activités, les fragments peuvent être initialisés et supprimés de la mémoire, et tout au 
long de leur existence, apparaître, disparaître et réapparaître à l'écran.
[FLC comporte 5 States](https://developer.android.com/reference/kotlin/androidx/lifecycle/.State)
similaire aux activités, la Fragment class fournit de nombreuses méthodes que vous pouvez remplacer
pour répondre aux événements LC. Cependant, gardez à l'esprit la différence avec la onCreate()méthode.

#onCreate(): 
Avec les activités, vous utiliseriez cette méthode pour gonfler la mise en page et lier les vues.
Cependant, dans le FLC , [onCreate()] est appelé avant la création de la vue, vous ne pouvez donc pas gonfler
la disposition ici. Au lieu de cela, vous le faites dans [onCreateView()].
Ensuite, une fois la vue créée, la [onViewCreated()] est appelée, où vous pouvez ensuite lier des propriétés à des vues spécifiques.


## Create Fragment and layout Files
Comme pour les activity, chaque fragment que vous ajoutez sera composé de deux fichiers :
un fichier XML pour la mise en page et une classe Kotlin pour afficher les données et gérer les interactions des utilisateurs. 

