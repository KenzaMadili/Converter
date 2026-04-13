# 📱 ConvertTabs App

## 📌 Description

**ConvertTabs** est une application Android simple et intuitive permettant de réaliser des conversions entre différentes unités.

Actuellement, l’application propose :

* 🌡️ Conversion de température (**Celsius ↔ Fahrenheit**)
* 📏 Conversion de distance (**Kilomètres ↔ Miles**)

L’interface est organisée sous forme de **tabs (onglets)** pour une navigation fluide.

---

## 🚀 Fonctionnalités

* Interface utilisateur simple et moderne
* Navigation par onglets (TabLayout + ViewPager)
* Conversion en temps réel via un bouton
* Gestion des erreurs (champ vide ou valeur invalide)
* Affichage formaté des résultats

---

## 🛠️ Technologies utilisées

* **Java**
* **Android SDK**
* **Fragments**
* **ViewPager2**
* **TabLayout (Material Design)**

---

## 📂 Structure du projet

```
com.example.converttabsjava
│
├── MainActivity.java
├── ViewPagerAdapter.java
│
├── TempFragment.java        → Conversion température
├── DistanceFragment.java    → Conversion distance
│
res/
├── layout/
│   ├── fragment_temp.xml
│   ├── fragment_distance.xml
│   └── activity_main.xml
```

---

## ⚙️ Fonctionnement

### 🌡️ Température

* Celsius → Fahrenheit :
  `F = (1.8 × C) + 32`
* Fahrenheit → Celsius :
  `C = (F - 32) / 1.8`

### 📏 Distance

* Kilomètres → Miles :
  `Miles = Km × 0.6214`
* Miles → Kilomètres :
  `Km = Miles / 0.6214`

---

## 📸 Aperçu (optionnel)

1.Convertir C-F : 
[](screenshots/temp1.jpeg)
[](screenshots/temp2.jpeg)

2.Convertir km-miles :
[](screenshots/d1.jpeg)
[](screenshots/d2.jpeg)
## ▶️ Installation

1. Cloner le projet :

```bash
git clone https://github.com/ton-repo/converttabs.git
```

2. Ouvrir avec **Android Studio**

3. Lancer l’application sur un émulateur ou un appareil réel

---

## 💡 Améliorations possibles

* Ajouter d’autres conversions (poids, temps, volume…)
* Utiliser **Kotlin**
* Implémenter **MVVM architecture**
* Ajouter un mode sombre 🌙
* Sauvegarder l’historique des conversions

---

## 👩‍💻 Auteur

Projet réalisé dans le cadre d’apprentissage Android.

---

## 📄 Licence

Ce projet est libre d’utilisation à des fins éducatives.
