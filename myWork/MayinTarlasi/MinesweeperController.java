package myWork.MayinTarlasi;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.SwingUtilities;
public class MinesweeperController implements MouseListener{
    private Board mBoard;
    private MinesweeperView mView;
    private int realRow,realCol;

    MinesweeperController(Board mBoard,MinesweeperView mView){
        this.mBoard=mBoard;
        this.mView=mView;
        mView.addMouseListenerToButtons(this);
    }



    @Override
    public void mouseReleased(MouseEvent e) {
        
        toFindRealRowAndColumn(e);


        if(SwingUtilities.isLeftMouseButton(e)){
            if(mBoard.isMoveSafe(realRow, realCol)){
                mBoard.openCell(realRow, realCol);
                mView.updateBoard();
                
            }
            else{
                mView.showLoseResult();
                mView.disableAllButtons();
            }
        }
        

        else if(SwingUtilities.isRightMouseButton(e)){
            if(mBoard.isCoordinateTrue(realRow, realCol) && !mBoard.isOpened(realRow, realCol)){
                mBoard.changeFlag(realRow, realCol);
                mView.updateBoard();
            }
        }


        if(mBoard.isWin()){
            mView.showWinResult();
            mView.disableAllButtons();
        }

        
    }

    private void toFindRealRowAndColumn(MouseEvent e){
        for(int row=0;row<mBoard.getSize();row++){
                    for(int col=0;col<mBoard.getSize();col++){
                        if(e.getSource()==mView.getButton(row, col)){   
                            realRow=row;
                            realCol=col;
                        }
                    }
                }
    }






    @Override
    public void mouseClicked(MouseEvent e) {

    }


    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
