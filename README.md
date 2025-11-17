# LAB 5 : Application *Recettes de Pizza* 🍕

---

## Réalisé par

**Abla MARGHOUB**

## Encadré par

**Pr. Mohamed LACHGAR**

## Module

**Techniques de Programmation Avancée**

## Établissement

**École Normale Supérieure - Université Cadi Ayyad**

---

## 1.  Objectif du TP

* d’afficher une liste de pizzas avec nom, prix, durée, image ;
* de consulter un détail complet de chaque recette ;
* d’utiliser un **Splash Screen animé** ;
* de mettre en œuvre un **adapter personnalisé** pour une ListView ;
* de manipuler un **modèle de données orienté objet** ;
* de structurer un projet Android selon des **packages logiques** (classes, dao, service, adapter, ui).

---

## 2.  Description des interfaces et classes

| Package / Classe              | Type                | Description                                     | Principales Méthodes / Champs                                                                                                   |
| ----------------------------- | ------------------- | ----------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| `classes/Produit.java`        | Classe              | Représente une pizza avec tous ses attributs    | `id`, `nom`, `prix`, `imageRes`, `duree`, `ingredients`, `description`, `etapes` <br> Méthodes : getters, setters, `toString()` |
| `dao/IDao.java`               | Interface générique | Contrat CRUD pour objets métier                 | `create(T t)`, `update(T t)`, `delete(long id)`, `findById(long id)`, `findAll()`                                               |
| `service/ProduitService.java` | Classe Singleton    | Service en mémoire simulant une base de données | `getInstance()`, `seed()`, implémentation CRUD via `IDao<Produit>`                                                              |
| `adapter/PizzaAdapter.java`   | Adapter             | Relie les objets `Produit` à la ListView        | `getCount()`, `getItem()`, `getItemId()`, `getView()`                                                                           |
| `ui/SplashActivity.java`      | Activité            | Écran de démarrage avec animation               | `onCreate()` avec Thread de 2 secondes et `startActivity()`                                                                     |
| `ui/ListPizzaActivity.java`   | Activité            | Affiche la liste des pizzas                     | `onCreate()`, ListView + `PizzaAdapter`, `setOnItemClickListener()`                                                             |
| `ui/PizzaDetailActivity.java` | Activité            | Affiche le détail complet d’une pizza           | `onCreate()`, récupération pizza par `id`, remplissage des vues (ImageView, TextViews)                                          |

---

## 3.  Fonctionnement global de l’application

1. **Splash Screen** (2s) → animé avec un logo.

<img width="936" height="858" alt="image" src="https://github.com/user-attachments/assets/9f851406-3fa0-4777-abc8-3e67454e7ac0" />

2. Ouverture de **ListPizzaActivity** :

   * récupération de la liste des pizzas via `ProduitService.getInstance().findAll()`
   * affichage dans une ListView via `ProduitAdapter`.
  
     <img width="961" height="870" alt="image" src="https://github.com/user-attachments/assets/f1c42733-af3a-488f-a800-138cd54c949b" />

3. Lorsqu’une pizza est sélectionnée :

   * passage de données via `Intent.putExtra`.
4. **DetailPizzaActivity** affiche :

   * image
   * nom
   * prix
   * durée
   * ingrédients
   * description
   * étapes de préparation.
     
<img width="890" height="871" alt="image" src="https://github.com/user-attachments/assets/f75d793f-ac5e-4a9b-b7b8-dc23c5b3423c" />

---

## 4. Architecture technique

### **4.1 Stack technologique**

| Composant        | Technologie                       |
| ---------------- | --------------------------------- |
| Langage          | Java                              |
| Framework mobile | Android SDK                       |
| Minimum SDK      | API 24 (Android 7.0)              |
| Outils           | Android Studio                    |
| Design           | XML Layouts                       |
| Gestion données  | Service interne + DAO générique   |
| UI Components    | ListView, ImageView, LinearLayout |
| Navigation       | Intents explicites                |

---

### **4.2 Structure du projet**

<img width="487" height="936" alt="image" src="https://github.com/user-attachments/assets/ebfd3819-44f0-428c-9c03-3fc3f41a2d62" />

<img width="498" height="960" alt="image" src="https://github.com/user-attachments/assets/70652fa5-9fb4-4979-a81a-d622c74cae8f" />

---

## 5. Demonstration


https://github.com/user-attachments/assets/09dd773b-2ae2-4e17-b5c2-7ead80685199


