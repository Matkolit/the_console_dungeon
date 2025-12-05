# 📘 Dokumentacja Projektowa  
## **"Legends of Java: The Console Dungeon"**

---

## 1. 🎯 Opis Projektu

**Cel:**  
Stworzenie turowej gry RPG działającej w konsoli (z opcją rozbudowy o GUI), która demonstruje kluczowe paradygmaty programowania obiektowego w Javie.

**Fabuła:**  
Gracz wciela się w bohatera, który eksploruje lochy zwane **"The Java Heap"**, aby pokonać ostatecznego przeciwnika — **Garbage Collectora**. Po drodze mierzy się z mniejszymi potworami (Bugami) i zdobywa przedmioty.

---

## 2. 🎮 Zasady Gry (Funkcjonalności)

### ➤ Eksploracja
- Gracz porusza się po mapie złożonej z połączonych pokoi (N, S, E, W).

### ➤ Walka
- Turowy system walki.
- Dostępne akcje: *Atak*, *Obrona*, *Użycie przedmiotu*, *Ucieczka*.
- Przeciwnik odpowiada swoim ruchem.

### ➤ Rozwój Postaci
- Za pokonanie wrogów gracz zdobywa XP.
- Awans zwiększa statystyki (HP, Siła).

### ➤ Ekwipunek
- Zbieranie mikstur, broni oraz łupów.

### ➤ Warunek zwycięstwa
- Pokonanie Bossa na ostatnim poziomie.

### ➤ Warunek porażki
- HP gracza spada do 0 lub poniżej.

---

## 3. 🏗 Architektura Techniczna

Projekt realizuje wymagania z OOP poprzez poniższą strukturę:

---

### **A. Hierarchia Klas (Dziedziczenie i Polimorfizm)**

Wspólną bazą jest klasa abstrakcyjna:

#### `abstract class Creature`
**Pola:**
- `name`
- `health`
- `strength`
- `level`

**Metody:**
- `attack()`
- `takeDamage()`
- `isAlive()`

#### `class Player extends Creature`
- Dodatkowe pola: `experience`, `Inventory`, `profession`.

#### `class Monster extends Creature`
- Pole: `lootDropChance`.

#### `class Boss extends Monster`
- Dodatkowo: `specialAttack()` 

---

### **B. Interfejsy**

#### `interface Lootable`
- Implementowane przez skrzynie i potwory.  
- Metoda: `getLoot()`.

#### `interface Consumable`
- Dla mikstur i jednorazowych przedmiotów.  
- Metoda: `consume(Player p)`.

#### `interface Saveable`
- Dla elementów zapisywanych w stanie gry.

---

### **C. Wzorce Projektowe**

#### **Singleton – `GameEngine`**
- Gwarantuje istnienie tylko jednej instancji sterującej grą.

#### **Factory Method – `MonsterFactory`**
- Przykład:  
  `MonsterFactory.createRandomMonster(level)`  
- Ułatwia skalowanie gry.

#### **State Pattern (opcjonalnie)**
- Klasy: `ExplorationState`, `CombatState`, `MenuState`.

---

## 4. 👥 Podział Zadań (Zespół 3-osobowy)

---

### 🧩 **Osoba A: "Silnik i Architektura" – *The Architect***
**Główna odpowiedzialność:** całościowa logika gry i spójność projektu.

**Zadania:**
- Implementacja `GameEngine` + wzorca Singleton.
- Obsługa wejścia/wyjścia (Scanner).
- System zapisu/odczytu gry.
- Zarządzanie repo (Git), rozwiązywanie konfliktów.

---

### ⚔️ **Osoba B: "System Walki i Postacie" – *The Warrior***
**Główna odpowiedzialność:** mechanika walki i klasy Creature.

**Zadania:**
- Tworzenie hierarchii: `Creature`, `Player`, `Monster`.
- System tur, obrażeń, krytyków, uników.
- Fabryka potworów (`MonsterFactory`).
- System levelowania.

---

### 🌍 **Osoba C: "Świat, Przedmioty i GUI" – *The World Builder***
**Główna odpowiedzialność:** mapa, itemy i ewentualne GUI.

**Zadania:**
- Klasa `Room`, tworzenie mapy.
- System ekwipunku (`Inventory`).
- Tworzenie itemów (`Item`, `Weapon`, `Potion`).
- Interfejsy `Consumable`, `Lootable`.
- Opcjonalne GUI (Swing / JavaFX).

---

## 5. 📊 Diagram Klas (Uproszczony)

      +------------------+
      |    GameEngine    |  (Singleton)
      +------------------+
               |
               v
      +------------------+         +----------------+
      |       Map        | <-----> |      Room      |
      +------------------+         +----------------+
                                      | contains
                                      v
      +------------------+        +----------------+
      |     Creature     | <------|      Item      |
      +------------------+        +----------------+
         ^           ^               ^         ^
         |           |               |         |
    +----+-------+---+----+       +---+---+  +--+---+
    | Player     | Monster|       | Weapon|  |Potion|
    +------------+--------+       +-------+  +------+
                     ^
                     |
            +------------------+
            | MonsterFactory   |
            +------------------+

