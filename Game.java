import java.util.Random;
import java.util.Scanner;


public class Game {
    static final int BOMB=-1;   //define constant variable
    static final char BOMBFLAG='B'; //define constant variable
    static int safeblock=0; // it's accesible (we need this becasue of static function)
    //recursive function
    static void show(int r,int c,int[][]gameBoard,char[][] userBoard,int n){
        if(r<0 || c<0 || r>=n || c>=n){return;}

        if(userBoard[r][c]!='X'){return;}

        userBoard[r][c]=(char)(gameBoard[r][c]+'0');

        
        for(int row=r-1;row<=r+1;row++){
            for(int col=c-1;col<=c+1;col++){
                if(row<0 ||col<0 ||row>=n ||col>=n||(row==r && col==c)||userBoard[row][col]!='X'){continue;}
                if(gameBoard[row][col]==0){
                        show(row, col, gameBoard, userBoard, n);
                    }
                else if(gameBoard[row][col]>0 && gameBoard[row][col]<8){
                    userBoard[row][col]=(char)(gameBoard[row][col]+'0');
                    
                }
                    }
                    

                }
            
        }
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int n,bombblock=0;
        int user_row,user_col;
        System.out.print("Enter n value(to create n*n gameboard):"); 
        n=input.nextInt();
        if(n<0){
            System.out.println("You must enter a number that is more than zero");
            System.out.println("Run the program again...");
            input.close();
            return;          
        }
        char[][] userBoard=new char[n][n];
        int[][] gameBoard=new int[n][n];


        // userBoard created
        for(int r=0;r<userBoard.length;r++){
            for(int c=0;c<userBoard[r].length;c++){    
                userBoard[r][c]='X';   
            }
        }

        for(int r=0;r<gameBoard.length;r++){
            for(int c=0;c<gameBoard[r].length;c++){
                if(rand.nextInt(5)==0){
                    gameBoard[r][c]=BOMB; //bomb is planted with random 
                    bombblock++;
                }
                else{
                    gameBoard[r][c]=0;
                    
                }
            }
        }
        int win=n*n-bombblock; // Sum of real safe block
        
        //in gameBoard counts neighbours (count bomb)
        for(int rows=0;rows<gameBoard.length;rows++){
            for(int cols=0;cols<gameBoard[rows].length;cols++){
                if(gameBoard[rows][cols]!=BOMB){
                for(int r=rows-1;r<=rows+1;r++){
                    for(int c=cols-1;c<=cols+1;c++){
                        if(r<0 || c<0 || c>=n || r>=n ){
                            continue;
                        }
                        if(gameBoard[r][c]==BOMB){
                            gameBoard[rows][cols]++;
                        }
                    }
                }
                }
            }
        }

        

        boolean isGameOver=false;
        int flag=-1;
        

        while(!isGameOver){
            System.out.println("Safe block:"+safeblock);    // it shows safe block
            for(char[] rows:userBoard){
                for(char column : rows){
                    System.out.print(column+" ");
                }
                System.out.println();
            }
            System.out.print("Do you want to plant a flag\n1-)Yes\n2-)No\n3-)Replace flag\n4-)Quit");
            System.out.print("Choose an option:");
            flag=input.nextInt();
            switch(flag){
                case 1:{
                    System.out.print("Rows:");
                    user_row=input.nextInt();
                    System.out.print("Cols:");
                    user_col=input.nextInt();
                    if(user_row<0 || user_row>=n || user_col<0 || user_col>=n){System.out.println("Out of index error..."); continue;}
                    userBoard[user_row][user_col]=BOMBFLAG;
                    continue;
                }
                case 2:{
                    break;
                }
                case 3:{
                    System.out.print("Rows:");
                    user_row=input.nextInt();
                    System.out.print("Cols:");
                    user_col=input.nextInt();
                    if(user_row<0 || user_row>=n || user_col<0 || user_col>=n){System.out.println("Out of index error..."); continue;}
                    userBoard[user_row][user_col]='X';
                    continue;
                }
                case 4:{
                    System.out.println("Goodbye...");
                    return;
                }
            }
            System.out.println("=========");
            System.out.println("Choose a block");
            System.out.print("Rows:");
            user_row=input.nextInt();
            System.out.print("Cols:");
            user_col=input.nextInt();

            if(user_col>=n || user_col<0 ||user_row>=n  ||user_row<0){
                System.out.println("Out of index error\nPlease try again...");
                continue;
            }

            // if user lose the game 
            if(gameBoard[user_row][user_col]==BOMB){
                System.out.println("BOOM\nGame Over");
                for(int[] rows : gameBoard){
                    for(int co : rows){
                        System.out.print(co+" ");
                    }
                    System.out.println();
                }
                isGameOver=true;
                break;
            }

            
            if(userBoard[user_row][user_col]!='X'){
                System.out.println("You already tried this");
                continue;
            }
            else{
                if(gameBoard[user_row][user_col]==0){

                    int temp=0;
                    for(int i=0;i<userBoard.length;i++){
                        for(int j=0;j<userBoard[i].length;j++){
                            if(userBoard[i][j]!='X'){temp++;}
                        }
                    }
                    
                    // recursive function
                    show(user_row,user_col,gameBoard,userBoard,n);
                    for(int i=0;i<userBoard.length;i++){
                        for(int j=0;j<userBoard[i].length;j++){
                            if(userBoard[i][j]!='X'){
                                safeblock++;
                            }
                        }
                    }
                    safeblock=safeblock-temp;
                }
                else{
                    int x=gameBoard[user_row][user_col];
                    userBoard[user_row][user_col]=(char)(x+'0');
                    safeblock++;
                }
            }
            //if user win the game 
            if(win==safeblock){
                System.out.println("You won!");
                for(int[] rows:gameBoard){
                    for(int value : rows){
                        System.out.print(value+" ");
                    }
                    System.out.println();
                }
                break;
            }
            
        }
        input.close();

    }
}
