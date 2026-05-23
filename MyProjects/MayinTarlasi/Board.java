package MyProjects.MayinTarlasi;
import java.util.Random;

import utils.ConsolUtils;
public class Board {
    private Cell[][] board;
    private Difficulty difficulty;
    Board(Difficulty difficulty){
        this.difficulty=difficulty;
        board=new Cell[difficulty.getBoardSize()][difficulty.getBoardSize()];
        createBoard();
        plantMines(difficulty);
        countTheNumberOfMine();
    }
    private void createBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j]=new Cell();
            }
        }
    }

    private void countTheNumberOfMine(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(!board[i][j].isMine()){
                    int m=check(i, j);
                    board[i][j].setNeighborMineCount(m);
                }
            }
        }
    }

    private int check(int i,int j){
        int countBomb=0;
        for (int r = i-1; r <=i+1; r++) {
            for (int c = j-1; c <= j+1; c++) {
                if(r<0 || c<0 || r>=board.length || c>=board.length ||(r==i && c==j)){
                    continue;
                }
                if(board[r][c].isMine()){
                    countBomb++;
                }
            }
        }
        return countBomb;
    }


    private void plantMines(Difficulty difficulty){
        Random rng=new Random();
        int stop=0;
        while (stop<difficulty.getMineCount()) {
            int i=rng.nextInt(board.length);
            int j=rng.nextInt(board.length);
            if(!board[i][j].isMine()){
                board[i][j].placeMine();
                stop++;
            }
        }
    }


    boolean isCoordinateTrue(int i,int j){
        return (i<board.length && j<board.length && i>=0 &&j>=0) ? true:false;
    }

    boolean isMoveSafe(int i,int j){
        if(isCoordinateTrue(i, j)&&!board[i][j].isFlagged()&&!board[i][j].isOpened()){
            return (board[i][j].isMine()) ? false:true;
        }
        return true;
    }
    void openCell(int i,int j){
        if(isCoordinateTrue(i, j)&&!board[i][j].isOpened()&&!board[i][j].isFlagged()){
            board[i][j].open();
            if(board[i][j].getNeighborMineCount()==0){
                recursiveOpen(i, j);
            }
        }
    }

    void changeFlag(int i,int j){
        if(isCoordinateTrue(i, j)&&!board[i][j].isOpened()){
            board[i][j].toggleFlag();
        }
    }
    boolean isWin(){
        int win=(board.length*board.length)-difficulty.getMineCount();
        int count=0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j].isOpened() && !board[i][j].isMine()){
                    count++;
                }
            }
        }
        return (count==win) ? true : false;
    }
    private void recursiveOpen(int i,int j){
        for(int row=i-1;row<=i+1;row++){
            for(int col=j-1;col<=j+1;col++){
                if(isCoordinateTrue(row, col)&&!board[row][col].isFlagged()&&!board[row][col].isOpened()&&!board[row][col].isMine()){
                    openCell(row,col);
                }
            }
        }
    }
    private void title(){
        System.out.print(ConsolUtils.colorize("   |", ConsolUtils.ANSI_BLUE));
        for (int i = 0; i < board.length; i++) {
            if(i<=9){System.out.print(ConsolUtils.ANSI_YELLOW+" "+i+" "+ConsolUtils.ANSI_RESET);}
            else{System.out.print(ConsolUtils.ANSI_YELLOW+" "+i+ConsolUtils.ANSI_RESET);}
            System.out.print(ConsolUtils.colorize("|",ConsolUtils.ANSI_BLUE));
        }
        System.out.println();
    }
    void drawBoard(){
        title();
        drawHorizontalLine();
        for (int row = 0; row < board.length; row++) {
            drawRows(row);
            drawHorizontalLine();
        }
        

    }

    private void drawHorizontalLine(){
        String st="";
        for (int i = 0; i < (board.length*4)+1; i++) {
            st+="-";
        }
        System.out.println(ConsolUtils.ANSI_BLUE+"   "+st+ConsolUtils.ANSI_RESET);
    }

    private void drawRows(int row){
        if(row<=9){
            System.out.print(" "+ConsolUtils.ANSI_YELLOW+row+ConsolUtils.ANSI_RESET+ConsolUtils.colorize(" |", ConsolUtils.ANSI_BLUE));
        }
        else{System.out.print(" "+ConsolUtils.ANSI_YELLOW+row+ConsolUtils.ANSI_RESET+ConsolUtils.colorize("|", ConsolUtils.ANSI_BLUE));}
        
        for (int col = 0; col < board.length; col++) {
            if(board[row][col].isFlagged()){
                System.out.print(ConsolUtils.ANSI_RED+" "+board[row][col]+" "+ConsolUtils.ANSI_RESET);
            }
            else{
                System.out.print(" "+board[row][col]+" ");
            }
            System.out.print(ConsolUtils.colorize("|",ConsolUtils.ANSI_BLUE));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Difficulty easy=Difficulty.EASY;
        Difficulty normal=Difficulty.NORMAL;
        Difficulty hard=Difficulty.HARD;

        Board br1=new Board(easy);
        Board br2=new Board(normal);
        Board br3=new Board(hard);
        br1.drawBoard();
        System.out.println();
        
        System.out.println();
        br2.drawBoard();
        System.out.println();
        
        System.out.println();
        br3.drawBoard();
        System.out.println();
        
        System.out.println();

    }
}
