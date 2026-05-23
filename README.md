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




Class Responsibilities
Cell.java

Represents a single cell on the Minesweeper board.

It stores information such as:

whether the cell is a mine
whether the cell is opened
whether the cell is flagged
how many mines are around it
Board.java

Manages the Minesweeper board.

Main responsibilities:

creating the board
placing mines randomly
counting neighboring mines
opening cells
changing flags
checking valid coordinates
checking win condition
recursively opening empty cells
drawing the board on the console
Difficulty.java

Stores difficulty settings.

Each difficulty level has:

board size
mine count
Minesweeper.java

Controls the main game flow.

Main responsibilities:

starting the game
asking the player for input
handling player choices
opening cells
placing or removing flags
checking win/loss situations
managing the game loop
Games.java

An interface that defines a playable game structure.

The Minesweeper class implements this interface.

InvalidScannerException.java

A custom exception class used for invalid menu selections.

ConsolUtils.java

A utility class used for console features such as:

colored text output
console styling
helper methods
What I Practiced

While developing this project, I practiced many important Java concepts.

Object-Oriented Programming

I separated the project into multiple classes, each with a clear responsibility. This helped me understand how to design a project instead of writing everything in one class.

Encapsulation

I used private fields and methods to protect data and control access through methods.

2D Arrays

The board is represented using a two-dimensional Cell[][] array. This helped me practice working with rows, columns, indexes, and boundary checks.

Recursion

I used recursion to open empty neighboring cells automatically when a cell has zero neighboring mines.

This was one of the most important parts of the project because it recreated a real Minesweeper mechanic.

Exception Handling

I used try-catch blocks to handle invalid user input.

I also created a custom exception class to handle invalid menu choices more clearly.

Interfaces

I created a Games interface and implemented it in the Minesweeper class. This helped me understand how interfaces can define common behavior.

Clean Code Thinking

I focused on separating responsibilities and writing methods with clear purposes, such as:

checking coordinates
opening cells
placing mines
changing flags
checking win condition
drawing the board
handling game flow
How to Run

Run the Demo.java file.

The game will first ask you to choose a difficulty level.

1 - Easy
2 - Normal
3 - Hard

After selecting the difficulty, the game starts in the console.

Game Controls

During the game:

1 - Place or remove a flag
2 - Open a cell
3 - Quit

The board shows row and column indexes, so the player can easily choose which cell to interact with.

Example Board Display

  | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
   -------------------------------------
 0 | 0 | 0 | 1 | X | X | X | X | X | X |
   -------------------------------------
 1 | 0 | 0 | 1 | X | X | X | X | X | X |
   -------------------------------------
 2 | 0 | 1 | 1 | X | X | X | X | X | X |
   -------------------------------------
 3 | 0 | 1 | X | X | X | X | X | X | X |
   -------------------------------------
 4 | 0 | 1 | X | X | X | X | X | X | X |
   -------------------------------------
 5 | 1 | 1 | X | X | F | X | X | X | X |
   -------------------------------------
 6 | X | X | X | X | X | X | X | X | X |
   -------------------------------------
 7 | X | X | X | X | X | X | X | X | X |
   -------------------------------------
 8 | X | X | X | X | X | X | X | X | X |
   -------------------------------------

Symbols:

X means closed cell
F means flagged cell
numbers show how many mines are around that cell
What I Learned

This project taught me that programming is not only about making the code work. It is also about designing the structure properly.

By refactoring Minesweeper into an object-oriented project, I improved my understanding of:

Java classes and objects
method design
encapsulation
arrays and 2D arrays
recursion
exception handling
custom exceptions
interfaces
console-based user interaction
project organization

This project was an important step in improving my Java and Object-Oriented Programming skills.

Future Improvements

In the future, I may improve this project by adding:

first-click safety
mine reveal after losing
timer
score system
save/load system
better input system
JavaFX or Swing GUI version
Author

Developed by Emre as a Java Object-Oriented Programming practice project

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


