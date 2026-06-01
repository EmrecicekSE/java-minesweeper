package myWork.MayinTarlasi;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.Font;

public class MinesweeperView extends JFrame{
    private JPanel boardPanel;
    private JButton[][] buttons;
    private Board board;
    


    MinesweeperView(Board board){
        this.setTitle("Minesweeper");
        this.setSize(1000,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.board=board;
        buttons=new JButton[board.getSize()][board.getSize()];
        createPanel();
        setLayout();
        createButtons();
        addButtonsToPanel();
        colorOfPanel(new Color(24, 28, 36)); 
        colorOfButtons(new Color(40, 46, 58), Color.WHITE); 
        updateBoard();
        
        setVisible(true);
    }

    private void createPanel(){
        boardPanel=new JPanel();
    }

    private void setLayout(){
        boardPanel.setLayout(new GridLayout(board.getSize(),board.getSize(),10,10));
        boardPanel.setVisible(true);
        this.add(boardPanel);
    }

    private JButton createButton(){
        JButton btn=new JButton();
        btn.setFont(new Font("Courier New", Font.BOLD, 22));  
        return btn;
    }

    private void createButtons(){
        for(int row=0;row<board.getSize();row++){
            for(int col=0;col<board.getSize();col++){
                buttons[row][col]=createButton();
                
            }
        }
    }
    private void addButtonsToPanel(){
        for(int row=0;row<board.getSize();row++){
            for(int col=0;col<board.getSize();col++){
                boardPanel.add(buttons[row][col]);
            }
        }
    }

    private void colorOfButtons(Color backGround,Color foreGround){
        for(int row=0;row<buttons.length;row++){
            for(int col=0;col<buttons[row].length;col++){
                buttons[row][col].setBackground(backGround);
                buttons[row][col].setForeground(foreGround);
                buttons[row][col].setFocusPainted(false);
                buttons[row][col].setBorderPainted(false);
                buttons[row][col].setOpaque(true);
            }
        }
    }
    private void colorOfButton(Color backGround,Color foreGround,int row,int col){
                buttons[row][col].setBackground(backGround);
                buttons[row][col].setForeground(foreGround);
    }

    private void colorOfPanel(Color backGround){
        boardPanel.setBackground(backGround);
    }

    public void updateBoard(){
        for(int row=0;row<buttons.length;row++){
            for(int col=0;col<buttons[row].length;col++){
                buttons[row][col].setText(board.getCellText(row, col));
                if(board.isFlagged(row, col)){
                    colorOfButton(new Color(150, 83, 79), Color.WHITE, row, col);
                }
                if(board.isOpened(row, col)){
                    colorOfButton(new Color(57, 83, 79), Color.WHITE, row, col);
                }
                if(!board.isOpened(row, col) && !board.isFlagged(row, col)){
                    colorOfButton(new Color(40, 46, 58),Color.WHITE , row, col);
                }
            }
        }
    }

    public void addMouseListenerToButtons(MouseListener listener){
        for(int row=0;row<buttons.length;row++){
            for(int col=0;col<buttons[row].length;col++){
                buttons[row][col].addMouseListener(listener);
            }
        }
    }
    public JButton getButton(int row,int col) {
        return buttons[row][col];
    }

    public void showWinResult(){
        JOptionPane.showMessageDialog(this,"Congratulations You Won!");
    }
    public void showLoseResult(){
        JOptionPane.showMessageDialog(this,"You hit a mine. Game over.");
    }

    public void disableAllButtons(){
        for(int i=0;i<buttons.length;i++){
            for(int j=0;j<buttons[i].length;j++){
                buttons[i][j].setEnabled(false);
            }
        }
    }



}





    

