# Jetpack Navigation Component
Android Jetpack fournit le Navigation Component pour vous aider à gérer toute implémentation de 
navigation, simple ou complexe, dans votre application. 

# Navigation Graph:
Un fichier XML qui fournit une représentation visuelle de la navigation dans votre application.
Le fichier se compose de [destinations] qui correspondent à des [activities] individuelles et à des
[fragments] ainsi qu'à des actions entre elles qui peuvent être utilisées dans le code pour naviguer d'une destination à une autre. 

# NavHOst:
Permet d'afficher des [destinations] à partir d'un navigation graph au sein d'une activité.
Lorsque vous naviguez entre les fragments, la destination affichée dans le NavHost est mise à jour.
Vous utiliserez une implémentation intégrée, appelée [NavHostFragment], dans votre fichier MainActivity.

# NavController: 
permet de contrôler la navigation entre les destinations affichées dans le NavHost.
Lorsque vous travailliez avec des [intents], vous deviez appeler [startActivity] pour accéder à un nouvel écran.
Avec le Navigation component, vous pouvez appeler la méthode NavController's [navigate()] pour échanger le fragment affiché.
Le NavController vous aide également à gérer des tâches courantes telles que répondre au bouton "haut" du système pour revenir au fragment précédemment affiché.

# Dépendance de la navigation
[1.]Dans le fichier au niveau du projet build.gradle, dans buildscript > ext , material_version définissez ci-dessous la valeur 
   nav_version = 2.3.1.

[2.] implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
     implementation "androidx.navigation:navigation-ui-ktx:$nav_version"
 
# Safe Args Plugin
un plugin Gradle qui vous aidera avec la sécurité de type lors de la transmission de données entre [fragments].
[1.] build.gradle, dans buildscript > dependencies , ajoutez: (existe deja)
   classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
   
[2.] build.gradle, plugins> , ajoutez:
   androidx.navigation.safeargs.kotlin

# Using the Navigation Graph
Navigation Component fait simplement référence à l'ensemble des outils permettant de mettre en œuvre la navigation, notamment entre fragment.
 
#FragmentContainerView 
[app:defaultNavHost="true"] attribut, Cela permet au container de fragments d'interagir avec la hiérarchie de navigation.

 #Configuration NavGraph 
Ajoutez un fichier graphique de navigation ( Fichier > Nouveau > Fichier de ressources Android )
[1. Nom de fichier] : (nav_graph.xml) il s'agit du même nom que celui que vous avez défini pour [app:navGraph] attribut.
[2.Resource Type]: (navigation)  Le nom du répertoire doit alors automatiquement passer à la navigation. Un nouveau dossier de ressources appelé "navigation" sera créé.

#Create a navigation action
passez votre souris sur la [letterListFragment] destination et faites glisser le cercle qui apparaît à droite sur la [wordListFragment] destination.

# Argument Destination
Sélectionnez une [destination] (WordListFragment ) et dans le volet des attributs, sous [Arguments] , cliquez sur le bouton plus pour créer un nouvel argument.
L'argument doit être appelé [letter] et le type doit être [String]. C'est là qu'intervient le [plug-in Safe Args] que vous avez ajouté précédemment.
La spécification de cet argument sous forme de chaîne garantit qu'un String sera attendu lorsque votre action de navigation sera effectuée dans le code.

# Définition start destination
En sélectionnant destination, en cliquant sur le bouton Attribuer start destination .

Dans Android Studio, sélectionnez [Build > Rebuild Project] dans la barre de menus.
Cela générera du code basé sur votre graphique de navigation afin que vous puissiez utiliser l'action de navigation que vous venez de créer.

# Effectuer a navigation action
C'est là qu'intervient le plug-in Safe Args que vous avez ajouté à la première étape : les actions créées sur le NavGraph sont transformées 
en code que vous pouvez utiliser. Les noms, cependant, devraient être assez intuitifs.
[LetterListFragmentDirections] permet de se référer à tous les chemins de navigation possibles à partir du [letterListFragment]
[actionLetterListFragmentToWordListFragment()] est l'action spécifique pour naviguer vers le [wordListFragment].

#Configure MainActivity
Créer une [navController] propriété. Ceci est marqué comme lateinit car il sera défini dans onCreate.
Récupérez une référence à [nav_host_fragment](c'est l'ID de votre FragmentContainerView) et attribuez-la à votre [navController]propriété.
Puis dans onCreate(), appelez [setupActionBarWithNavController()], en passant navController.
Enfin, implémentez [onSupportNavigateUp()]. Outre la définition [defaultNavHost true] dans le XML, cette méthode vous permet de gérer le bouton vers le haut .
 (étant donné que la navigateUp()fonction peut échouer, elle renvoie un Booleansi elle réussit ou non. )

#Arguments
il sont defois facultatifs
Obtenir la chaîne à partir d'arguments lorsque vous travaillez avec des fragments fonctionne exactement de la même manière que [intent?.extras?.getString()]
# Bundle:
 Considérez-le comme une paire [key-value] utilisée pour transmettre des données entre des classes, telles que des activités et des fragments. 