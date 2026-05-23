package MyProjects.MayinTarlasi;

import java.util.InputMismatchException;
import java.util.Scanner;

import utils.ConsolUtils;



public class Minesweeper implements Games{
    Scanner input=new Scanner(System.in);
    private boolean isGameOver;
    private Board board;


    private static void question(){
        System.out.println("1-)raise or remove flag\n2-)Open a cell\n3-)Quit");
        System.out.print("Choose an option:");
    }
    private static void askingRow(){
        System.out.print("Enter row:");
    }
    private static void askingCol(){
        System.out.print("Enter col:");
    }
    

    Minesweeper(Difficulty difficulty){
        board=new Board(difficulty);
        isGameOver=false;
    }
    private String minesweeperPicture(){
        String st=" __  __ _              ____                                   \n" + //
                        "|  \\/  (_)_ __   ___  / ___|_      _____  ___ _ __   ___ _ __ \n" + //
                        "| |\\/| | | '_ \\ / _ \\ \\___ \\ \\ /\\ / / _ \\/ _ \\ '_ \\ / _ \\ '__|\n" + //
                        "| |  | | | | | |  __/  ___) \\ V  V /  __/  __/ |_) |  __/ |   \n" + //
                        "|_|  |_|_|_| |_|\\___| |____/ \\_/\\_/ \\___|\\___| .__/ \\___|_|   \n" + //
                        "                                             |_|              ";
        return st;
    }


    @Override
    public void play(){
        System.out.println(ConsolUtils.colorize(minesweeperPicture(),ConsolUtils.ANSI_GREEN));
        System.out.println("\n\nHave fun Good luck :)\n");

        board.drawBoard();
        while (!isGameOver) {
            question();
            try{
                int decide=input.nextInt();
                if(!(decide==1 || decide==2 || decide==3)){
                    throw new InvalidScannerException();
                }
                switch (decide) {
                    case 1:{
                        int row=0,col=0;
                        askingRow();
                        row=input.nextInt();
                        askingCol();
                        col=input.nextInt();
                        board.changeFlag(row,col);
                        board.drawBoard();
                        break;
                    }
                    case 2:{
                        int row=0,col=0;
                        askingRow();
                        row=input.nextInt();
                        askingCol();
                        col=input.nextInt();
                        if(board.isMoveSafe(row, col)){
                            board.openCell(row, col);
                        }
                        else{
                            System.out.println(ConsolUtils.colorize("You hit a mine. Game over.",ConsolUtils.ANSI_RED));
                            input.close();
                            isGameOver=true;
                            return;
                        }
                        board.drawBoard();
                        break;
                    }
                    case 3:{
                        System.out.println(ConsolUtils.colorize("Goodbye :)",ConsolUtils.ANSI_CYAN));
                        input.close();
                        return;
                    }
                }
                if(board.isWin()){
                    System.out.println(ConsolUtils.colorize("Congratulations you won",ConsolUtils.ANSI_YELLOW));
                    input.close();
                    return;
                }


            }
            catch(InputMismatchException exception){
                System.out.println("Please enter a valid argument");
                input.nextLine(); // clear the scanner
                continue;
            }
            catch(InvalidScannerException exception){
                System.out.println(exception.getMessage());
                input.nextLine(); // clear the scanner
                continue;
            }
            
        }
    }
    public static void main(String[] args) {
        Minesweeper minesweeper=new Minesweeper(Difficulty.EASY);
        minesweeper.play();
    }

}
