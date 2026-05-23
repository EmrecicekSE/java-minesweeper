package MyProjects.MayinTarlasi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo {
   
    
    public static void main(String[] args) {
        Difficulty selectedDifficulty=Difficulty.EASY;
        Scanner input=new Scanner(System.in);
        boolean isValid=false;


        System.out.println("Welcome to play minesweeper");
        System.out.println("Choose a difficulty level");
        System.out.println("1-) Easy (9X9 BOARD 10 MINES)");
        System.out.println("2-) Normal (12X12 BOARD 25 MINES)");
        System.out.println("3-) Hard (16X16 BOARD 40 MINES)");
        
        while(!isValid){
            try{
                System.out.print("Choose an option:");
                int option=input.nextInt();
                if(!(option==1 || option==2 || option==3)){throw new InvalidScannerException();}
                switch (option){
                    case 1:{selectedDifficulty=Difficulty.EASY; isValid=true; break;}
                    case 2:{selectedDifficulty=Difficulty.NORMAL; isValid=true; break;}
                    case 3:{selectedDifficulty=Difficulty.HARD; isValid=true; break;}
                        
                }
                        
                    }
            catch(InputMismatchException exception){
                System.out.println("Please enter a valid argument");
                input.nextLine(); 
                continue;
            }
            catch(InvalidScannerException exception){
                System.out.println(exception.getMessage());
                input.nextLine();
                continue;
            }
            
        }
        Games minesweeper=new Minesweeper(selectedDifficulty);
        minesweeper.play();
    }
}
