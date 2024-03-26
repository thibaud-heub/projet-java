# Polytech 4A Informatique - 2022/2023

## Apprentissage automatique

### Examen (durée : 2 heures)

#### 1. Un problème de régression

On s'intéresse ici à la régression linéaire. On souhaite tester des algorithmes de régression linéaire basés sur le critère de moindres carrés.

1. Définissez la fonction coût de moindres carrés. Quel est l'intérêt de minimiser une fonction coût pour un problème d'apprentissage ? Y a-t-il des inconvénients à cette approche ?

2. Apprenez une fonction de régression linéaire par moindres carrés (`LinearRegression()`) de `sklearn.linear_model` sur le jeu de données réel diabetes qui est disponible dans `sklearn.datasets`. Calculez l'erreur de prédiction sur le jeu de données d'apprentissage utilisant la méthode `mean_squared_error` de la classe `sklearn.metrics`.

3. La régression Ridge et Lasso sont deux variantes de la régression linéaire par moindres carrés. Donnez un avantage de ces méthodes de régression comparé à la régression linéaire standard. Appliquez la régression Ridge et la régression Lasso sur le jeu de données diabetes avec `alpha = 1.0`. Les deux fonctions Ridge et Lasso se trouvent dans `sklearn.linear_model`. Affichez et comparez les deux solutions obtenues.

4. Calculez les erreurs de prédiction sur les données d'apprentissage obtenues avec les régressions Ridge et Lasso. Comparez les résultats avec ceux obtenus par la régression par moindres carrés et commentez-les.

#### 2. Un problème de classification

##### 2.1 sur un premier jeu de données simulé

Soit `S = {(xi, yi) ∈ ℝ² x {-1,1}, i = 1, ..., 20}` un ensemble de jeu de données d'apprentissage généré à partir des lignes de code suivantes :

```python
np.random.seed(1)
X = np.random.randn(20, 2)
y = np.repeat([1, -1], 10)
X[y == -1] = X[y == -1] + 3

La matrice X contient les données d entrée et le vecteur y contient les étiquettes associées. 

1. Affichez les données d entrée sur un graphique utilisant deux couleurs différentes pour distinguer les classes (utilisez la méthode scatter de `matplotlib.pyplot`). Que remarquez-vous ?

2. On va considérer le classifieur Perceptron de la classe `sklearn.linear_model`. Apprenez un perceptron sur le jeu de données simulé `S`. Dessinez le classifieur obtenu sur le même graphique contenant les données.

On désire maintenant comparer le résultat obtenu par le classifieur Perceptron avec celui d un SVM (séparateur à vaste marge connu sous le nom "Support Vector Machines").

3. Apprenez un classifieur SVM sur le même jeu de données `S`. Pour déclarer un SVM, utilisez la commande suivante : `clf = SVC(C=1, kernel='linear')` (`SVC` est contenu dans le package `class sklearn.svm`). Affichez sur le graphique précédent le classifieur linéaire appris par la méthode SVM. Comparez les deux résultats (les attributs `coef_` et `intercept_` vous seront utiles).

#### 2.2 sur un deuxième jeu de données simulé

Créez un jeu de données d apprentissage simulé utilisant les commandes suivantes : 
from sklearn.datasets import make_circles
X, y = make_circles(n_samples = 20, random_state = 123, noise = 0.1, factor = 0.2)
4. Affichez les données d entrée sur un graphique utilisant deux couleurs différentes pour distinguer les classes. Que remarquez vous ?

5. Ecrire une fonction phi qui permet de transformer les données d apprentissage x<sub>i</sub> = (x<sub>i</sub><sup>(1)</sup> -> x<sub>i</sub><sup>(2)</sup>), i=1...=20, en z<sub>i</sub> = (z<sub>i</sub><sup>(1)</sup>, z<sub>i</sub><sup>(2)</sup>,z<sub>i</sub><sup>(3)</sup>) avec z<sub>i</sub><sup>(1)</sup> = (x<sub>i</sub><sup>(1)</sup>)<sup>2</sup>, z<sub>i</sub><sup>(2)</sup> = (x<sub>i</sub><sup>(2)</sup>)<sup>2</sup> et z<sub>i</sub><sup>(3)</sup> = 2*x<sub>i</sub><sup>(1)</sup>*x<sub>i</sub><sup>(2)</sup>
Afficher les données (z<sub>i</sub>)<sup>n</sup><sub>i=1</sub> sur un graphe 3D (vous pouvez utiliser la commande plt3d = plt.figure().gca(projection="3d")pour configurer un affichage 3d). Qu est-ce que vous remarquez ?

6.Apprenez deux perceptrons utilisant respectivement  les données x<sub>i</sub> et z<sub>i</sub> i=1,...,20. Calculez l erreur de prédiction de ces deux perceptrons sur les données d apprentissage utilisées pour les apprendre. Comparez les résultats.

7. Serait-il possible d utiliser un perceptron pour classer correctement les données (x<sub>i</sub>)<sup>20</sup><sub>i=1</sub> sans forcément connaitre le mapping phi ? Expliquez ?

#### 2.2 sur un jeu de données réel

On va maintenant tester l algorithme du perceptron sur un jeu de données réel. On va considérer le jeu de données de classification binaire load_breast_cancer. Pour le charger en Python, vous pourrez utiliser le code suivant : 

from sklearn.datasets import load_breast_cancer
data = load_breast_cancer()
X = data.data
y = data.target


8. Réservez 50% des exemples pour le test et 50% pour l apprentissage. Apprenez un perceptron sur les données  d apprentissage et fixez le nombre d itération maximal à 50 (n_iter = 50). Calculez le taux de précision du classifieur sur les données test utilisant la méthode accuracy_score de la classe sklearn.metrics.
9. L algorithme de régression linéaire peut être adapté pour traiter un problème de classification. une fois la fonction de régression apprise, l idée est d utilisr un seuil sur les sorties prédites afin de mettre à 1 toutes les valeurs positives et à 0 toutes les valeurs négatives. Apprenez un algorithme de régression linéaire (LinearRegression() de sklearn.linear_model) sur le même jeu de données de la question précédente. Calculez la précision sur la prédiction sur les données test et comparez le résultat avec celui obtenu par l algorithme du perceptron.
