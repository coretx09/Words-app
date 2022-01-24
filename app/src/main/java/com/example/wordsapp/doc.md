#CONTEXT
Interface vers des informations globales sur un environnement applicatif. Il s'agit d'une classe abstraite
dont l'implémentation est fournie par le système Android. Il permet _d'accéder à des ressources_ et à 
des _classes spécifiques à l'application_, ainsi qu'à des appels pour des opérations au niveau de l'application 
telles que le _lancement d'activités_, _les intentions de diffusion et de réception_, etc.

#URI( Uniform Resource Identifier )
Une _URL(Uniform Resource Locator_ , est une chaîne qui pointe vers une page Web. Un URI est un terme plus général pour le format.
Toutes les URL sont des URI, mais tous les URI ne sont pas des URL.
D'autres URI, par exemple une adresse pour un numéro de téléphone, commenceraient par tel:,
mais cela est considéré comme un _URN(Uniform Resource Name)_


# INTENTS
Une _intentS_ est un objet représentant une action à effectuer, simplement un ensemble d'instructions
L'utilisation la plus courante,  mais certainement pas la seule, d'une intention est de *_lancer une activité_*.
Il existe deux types d'intentions : _implicit_ et _explicits_ .

 ## INTENTS EXPLICIT:
Est très spécifique, où vous connaissez l'activité exacte à lancer, souvent un écran dans votre propre application.
 Intent(Context, Class)
 Executed in an Activity, so 'this' is the Context

 ## INTENTS IMPLICIT:
Est un peu plus abstraite, lorsque vous indiquez au système le type d'action, comme _ouvrir un lien_,
_rédiger un e-mail_ ou passer un _appel téléphonique_, et le système est chargé de déterminer comment répondre à la demande.

## EXTRA
un extra est une donnée, telle qu'un nombre ou une chaîne, qui reçoit un nom pour être récupéré plus tard.
putExtra('name', value)
  ##extra-property 
La property extras est de type Bundle, fournit un moyen d'accéder à tous les extras transmis à l'Intent.

## Type d'action Intents:
Au lieu de transmettre un context et une activity (EXPLICIT)
vous passez :
### Intent.ACTION_VIEW:
est une intent generic qui prend un URI

### Intent.CATEGORY_APP_MAPS:
lancer l'application de cartes

### Intent.CATEGORY_APP_EMAIL:
lancer l'application de messagerie

### Intent.CATEGORY_APP_GALLERY:
lancement de l'application galerie (photos)

### Intent.ACTION_SET_ALARM: 
régler une alarme en arrière-plan

### Intent.ACTION_DIAL:
lancer un appel téléphonique

## Pour exécuter une intention :
1. Obtenez une référence au contexte.
2. Créez un Intent objet fournissant un type d'activité ou d'intention (selon qu'il est explicite ou implicite).
3. Transmettez toutes les données nécessaires en appelant putExtra().
4. Appel startActivity() passant dans l' intent objet.



# SET UP MENU AND ICONS
Les options de menu vous permettent d'ajouter des boutons et des menus à la barre d'applications.
Définissez le type de ressource sur Menu et le nom de fichier sur layout_menu.



