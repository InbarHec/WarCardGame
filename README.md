# War Card Game (Java)

## Overview
This project is a **Java implementation** of the classic **War card game**. The game is played between two players, each drawing a card from their deck, with the higher value card winning the round. In case of a tie, a "war" occurs, where additional cards are drawn until a winner is determined.

## Features
- **Object-Oriented Design:** Uses separate classes for **Card, DeckOfCards, and GameManager**.
- **Deck Management:** Implements shuffling, dealing, and tracking of cards.
- **Automated Gameplay:** Simulates rounds of play and war scenarios.
- **Graphical User Interface (Swing):** Displays game progress through interactive dialogs.
- **Randomized Shuffling:** Uses **SecureRandom** to ensure fair distribution.

## How to Run
### Prerequisites
- **Java Development Kit (JDK) 8+** installed on your system.

### Running the Program
1. **Compile the Java files**:
   ```sh
   javac Card.java DeckOfCards.java GameManager.java
   ```
2. **Run the game**:
   ```sh
   java GameManager
   ```

## Technologies Used
- **Language:** Java
- **GUI Framework:** Swing (for game notifications)
- **Randomization:** SecureRandom (for fair shuffling)

## Future Improvements
- Implement a **full GUI-based version** for a better user experience.
- Add a **multiplayer mode** for real-time gameplay.
- Improve game logic to allow **custom deck sizes and rule variations**.

## Credits
Developed by Inbar Hecht as a learning project in Java.

