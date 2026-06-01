package myWork.MayinTarlasi;

import java.util.Random;

//import utils.ConsolUtils;
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

    

    public String getCellText(int row,int column){
        return board[row][column].toString();
    }


    public int getSize(){
        return difficulty.getBoardSize();
    }
    public int getMine(){
        return difficulty.getMineCount();
    }

    public boolean isOpened(int row,int col){
        if(isCoordinateTrue(row, col))
            return board[row][col].isOpened();
        throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException");
    }
    public boolean isFlagged(int row,int col){
        if(isCoordinateTrue(row, col))
            return board[row][col].isFlagged();
        throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException");
    }
    public boolean isMine(int row, int col){
        if(isCoordinateTrue(row, col))
            return board[row][col].isMine();
        throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException");

    }
    public int getNeighborMineCount(int row, int col){
        if(isCoordinateTrue(row, col))
            return board[row][col].getNeighborMineCount();
        throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException");
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


    public boolean isCoordinateTrue(int i,int j){
        return (i<board.length && j<board.length && i>=0 &&j>=0) ? true:false;
    }

    public boolean isMoveSafe(int i,int j){
        if(isCoordinateTrue(i, j)&&!board[i][j].isFlagged()&&!board[i][j].isOpened()){
            return (board[i][j].isMine()) ? false:true;
        }
        return true;
    }
    public void openCell(int i,int j){
        if(isCoordinateTrue(i, j)&&!board[i][j].isOpened()&&!board[i][j].isFlagged()){
            board[i][j].open();
            if(board[i][j].getNeighborMineCount()==0){
                recursiveOpen(i, j);
            }
        }
    }

    public void changeFlag(int i,int j){
        if(isCoordinateTrue(i, j)&&!board[i][j].isOpened()){
            board[i][j].toggleFlag();
        }
    }
    public boolean isWin(){
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
   
    
        

}

    

    


