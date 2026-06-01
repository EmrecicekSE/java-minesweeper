package myWork.MayinTarlasi;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

       
        String[] options = {"Easy", "Normal", "Hard"};

        
        int choice = JOptionPane.showOptionDialog(null,
                "Please choose the level of the game:",
                "Minesweeper - Choosing level",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]); 

        
        Difficulty selectedDifficulty;
        switch (choice) {
            case 1:
                selectedDifficulty = Difficulty.NORMAL;
                break;
            case 2:
                selectedDifficulty = Difficulty.HARD;
                break;
            default:
                selectedDifficulty = Difficulty.EASY; 
                break;
        }
       


        Board board=new Board(selectedDifficulty);
        MinesweeperView vMinesweeperView=new MinesweeperView(board);
        MinesweeperController mController=new MinesweeperController(board, vMinesweeperView);
    }
}
