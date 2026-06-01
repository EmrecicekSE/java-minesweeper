package myWork.MayinTarlasi;

public class Cell {
    
    private boolean isMine,isOpened,isFlagged;
    private int neighborMineCount;

    Cell(){
        isFlagged=false;
        isOpened=false;
        neighborMineCount=0;
        isMine=false;
        
    }
    

    public boolean isMine() {return isMine;}

    public boolean isOpened() {return isOpened;}

    public boolean isFlagged() {return isFlagged;}

    public int getNeighborMineCount() {return neighborMineCount;}

    public void setNeighborMineCount(int neighborMineCount) {this.neighborMineCount = neighborMineCount;}

    void placeMine(){isMine=true;}

    public void open(){isOpened=true;}

    public void toggleFlag(){isFlagged=!isFlagged;}

    public void increaseNeighborMineCount() {neighborMineCount++;}

    @Override
    public String toString() {
        if(!isOpened && isFlagged){return "F";}
        return isOpened ? neighborMineCount+"":"X";
}
public static void main(String[] args) {
    Cell cell=new Cell();
    cell.toggleFlag();
    System.out.println(cell.toString());
}

}
