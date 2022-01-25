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

## Implement Fragment
Comme pour les activity, vous devez gonfler la mise en page et lier les vues individuelles.
Il n'y a que quelques différences mineures lorsque vous travaillez avec le cycle de vie des fragments.
#1  Gardez également à l'esprit que les vues des fragments peuvent être créées et détruites plusieurs
fois tout au long du cycle de vie du fragment. Pour cette raison, vous devez également réinitialiser
la valeur dans une autre méthode de cycle de vie, [onDestroyView()].

  #Parce qu'il est [NULLABLE], chaque fois que vous accédez à une propriété de _binding, (par exemple _binding?.someView), vous devez inclure la ?sécurité for null.
  Si vous êtes certain qu'une valeur ne sera pas nulle lorsque vous y accéderez, vous pouvez ajouter [!!] à son nom de type.
  Ensuite, vous pouvez y accéder comme n'importe quelle autre propriété, sans  [?] opérateur.
  Accéder à une valeur nullable de cette manière est dangereux et peut entraîner des plantages, donc utilisez-le avec parcimonie, voire pas du tout.
  
  
  #Noms de propriété précédés d'un trait de soulignement
  Cela signifie généralement que la propriété n'est pas destinée à être accessible directement.

## Menu Fragment:
La seule autre chose à noter est qu'il existe quelques différences subtiles avec la [onCreateOptionsMenu()]méthode
lorsque vous travaillez avec des fragments. Alors que la Activity classe a une propriété globale appelée [menuInflater],
Fragment n'a pas cette propriété. Le gonfleur de menu est plutôt passé dans [onCreateOptionsMenu()]. 
Notez également que la [onCreateOptionsMenu()] utilisée avec les fragments ne nécessite pas d'instruction de [return]. 
  