#TEST 
Create the tests directories 
Créez une nouvelle classe appelée NavigationTests.kt dans le dossier androidTest .

#Ajoutez les dépendances nécessaires
[androidTestImplementation 'com.android.support.test.espresso:espresso-contrib:3.0.2'
androidTestImplementation 'androidx.navigation:navigation-testing:2.3.5'
debugImplementation 'androidx.fragment:fragment-testing:1.3.6']

#ActivityScenarioRule
peut être utilisé pour isoler un fragment à tester,
