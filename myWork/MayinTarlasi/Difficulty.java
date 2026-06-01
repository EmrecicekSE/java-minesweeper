package myWork.MayinTarlasi;

public enum Difficulty {
    HARD,NORMAL,EASY;

    public int getMineCount(){
        switch (this) {
            case HARD:return 40;
            case NORMAL:return 25;
            default:return 10;
        }
    }
    public int getBoardSize(){
        switch (this) {
            case HARD:return 16;
            case NORMAL:return 12;
            default:return 9;
        }
    }

    
}
