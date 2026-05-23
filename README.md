# Minesweeper - Object Oriented Java Project

This project is a console-based Minesweeper game developed in Java.  
I first created a basic version of the game, then refactored it using Object-Oriented Programming principles to make the structure cleaner, more organized, and easier to improve.

## About the Project

The main goal of this project was not only to build a playable Minesweeper game, but also to practice important Java and OOP concepts in a real project.

The game allows the player to:

- Choose a difficulty level
- Open cells
- Place or remove flags
- Avoid mines
- Win by opening all safe cells
- Play on a console-based board with row and column indexes

## Features

- Console-based Minesweeper gameplay
- Different difficulty levels:
  - Easy: 9x9 board, 10 mines
  - Normal: 12x12 board, 25 mines
  - Hard: 16x16 board, 40 mines
- Random mine placement
- Neighbor mine counting
- Recursive opening for empty cells
- Flag system
- Win and lose conditions
- Input validation with exception handling
- Colored console output
- Clean board drawing with indexes

## What I Practiced

While developing this project, I practiced and applied many important Java concepts:

### Object-Oriented Programming

I divided the project into different classes, each with its own responsibility.

- `Cell` represents a single cell on the board.
- `Board` manages the game board, mines, flags, opening cells, and win control.
- `Difficulty` stores difficulty settings.
- `Minesweeper` controls the game flow.
- `Games` is an interface for playable games.
- `InvalidScannerException` is a custom exception for invalid menu input.

This helped me understand how to separate responsibilities between classes instead of writing everything in one file.

### Encapsulation

I used private fields and public methods to control access to the data.  
For example, the cell information such as mine status, opened status, flag status, and neighbor mine count is stored inside the `Cell` class.

### Arrays and 2D Arrays

The board is created using a two-dimensional `Cell[][]` array.  
This helped me practice working with rows, columns, indexes, and boundary checks.

### Recursion

I used recursion to open nearby empty cells automatically when the selected cell has zero neighboring mines.  
This is one of the most important parts of Minesweeper logic.

### Exception Handling

I used `try-catch` blocks to handle wrong user input.  
I also created a custom exception class to make invalid menu selections easier to manage.

### Interfaces

I created a `Games` interface and implemented it in the `Minesweeper` class.  
This helped me understand how interfaces can define common behavior for different types of games.

### Clean Code Thinking

During the project, I focused on making the code more readable by separating the game into meaningful methods such as:

- checking coordinates
- opening cells
- changing flags
- checking win condition
- drawing the board
- placing mines
- counting neighboring mines

## Project Structure

```text
MyProjects/
└── MayinTarlasi/
    ├── Board.java
    ├── Cell.java
    ├── Demo.java
    ├── Difficulty.java
    ├── Games.java
    ├── InvalidScannerException.java
    └── Minesweeper.java

utils/
└── ConsolUtils.java
