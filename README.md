# Minesweeper GUI - Java Swing

This is a GUI version of my Minesweeper game built with **Java Swing**.
The project was first developed as a console-based game, then redesigned with a simple **MVC-style structure** to separate the game logic, user interface, and user interactions.

## Screenshot

![Minesweeper GUI]<img width="982" height="787" alt="image" src="https://github.com/user-attachments/assets/f777bc80-b14b-40cb-ba7a-bb9c013214da" />


## Features

* Java Swing graphical user interface
* Easy, Normal, and Hard difficulty options
* Left click to open a cell
* Right click to place or remove a flag
* Different colors for opened, closed, and flagged cells
* Recursive opening for empty cells
* Win and lose detection
* Simple MVC-style project structure

## Technologies Used

* Java
* Java Swing
* Object-Oriented Programming
* Event Handling
* MVC-style design

## Project Structure

```text
src/
└── myWork/
    └── MayinTarlasi/
        ├── Board.java
        ├── Cell.java
        ├── Difficulty.java
        ├── Main.java
        ├── MinesweeperController.java
        └── MinesweeperView.java
```

## How to Run

Run the `Main.java` file.

When the game starts, you can choose one of the difficulty levels:

* Easy
* Normal
* Hard

After selecting the difficulty, the Minesweeper board will open.

## Controls

* **Left click:** Open a cell
* **Right click:** Place or remove a flag

## What I Learned

While building this project, I practiced:

* Creating a GUI with Java Swing
* Using `JFrame`, `JPanel`, `JButton`, `GridLayout`, and `JOptionPane`
* Handling mouse events with `MouseListener`
* Managing a 2D array of buttons
* Separating the game logic from the user interface
* Using recursion to open empty cells
* Applying a basic MVC-style structure

## Notes

This project was created as a learning project to improve my Java, Swing, and object-oriented programming skills.
