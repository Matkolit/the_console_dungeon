# 📘 Project Documentation  
## **"Legends of Java: The Console Dungeon"**

---

## 1. 🎯 Project Description

**Goal:**  
To create a turn-based RPG game running in the console (with an optional GUI extension), demonstrating key object-oriented programming paradigms in Java.

**Story:**  
The player becomes a hero exploring the dungeons known as **"The Java Heap"** to defeat the ultimate foe — the **Garbage Collector**. Along the way, the player fights smaller monsters (Bugs) and collects items.

---

## 2. 🎮 Game Mechanics (Features)

### ➤ Exploration
- The player moves through a map composed of connected rooms (N, S, E, W).

### ➤ Combat
- Turn-based battle system.
- Actions available: *Attack*, *Defend*, *Use Item*, *Run*.
- The enemy responds with their own action.

### ➤ Character Progression
- Defeating enemies grants XP.
- Leveling up increases stats (HP, Strength).

### ➤ Inventory
- Collecting potions, weapons, and loot.

### ➤ Win Condition
- Defeating the Boss on the final level.

### ➤ Lose Condition
- The player’s HP reaches 0 or below.

---

## 3. 🏗 Technical Architecture

The project fulfills OOP requirements through the following structure:

---

### **A. Class Hierarchy (Inheritance & Polymorphism)**

The common base is an abstract class:

#### `abstract class Creature`
**Fields:**
- `name`
- `health`
- `strength`
- `level`

**Methods:**
- `attack()`
- `takeDamage()`
- `isAlive()`

#### `class Player extends Creature`
Additional fields: `experience`, `Inventory`, `profession`.

#### `class Monster extends Creature`
Field: `lootDropChance`.

#### `class Boss extends Monster`
Additional method: `specialAttack()`.

---

### **B. Interfaces**

#### `interface Lootable`
- Implemented by chests and monsters.  
- Method: `getLoot()`.

#### `interface Consumable`
- For potions and one-time-use items.  
- Method: `consume(Player p)`.

#### `interface Saveable`
- For objects that must be saved as part of the game state.

---

### **C. Design Patterns**

#### **Singleton – `GameEngine`**
- Ensures only one instance that manages the entire game.

#### **Factory Method – `MonsterFactory`**
Example use:  
`MonsterFactory.createRandomMonster(level)`  
- Improves scalability and readability.

#### **State Pattern (optional)**
- Example states: `ExplorationState`, `CombatState`, `MenuState`.

---

## 4. 👥 Team Task Distribution (3 Members)

---

### 🧩 **Person A: "Engine & Architecture" – *The Architect***
**Main responsibility:** Core game logic and overall project structure.

**Tasks:**
- Implement `GameEngine` + Singleton pattern.
- Handle input/output (Scanner).
- Game saving/loading system.
- Manage the Git repository and resolve merge conflicts.

---

### ⚔️ **Person B: "Combat & Characters" – *The Warrior***
**Main responsibility:** Combat mechanics and creature classes.

**Tasks:**
- Implement the hierarchy: `Creature`, `Player`, `Monster`.
- Turn system, damage, critical hits, evasion.
- MonsterFactory implementation.
- Level-up and stat system.

---

### 🌍 **Person C: "World, Items & GUI" – *The World Builder***
**Main responsibility:** Map, items, and optional GUI.

**Tasks:**
- Implement `Room` class and map generation.
- Inventory system (`Inventory`).
- Item hierarchy (`Item`, `Weapon`, `Potion`).
- Interfaces: `Consumable`, `Lootable`.
- Optional GUI using Swing / JavaFX.

---

## 5. 📊 Class Diagram (Simplified)


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

