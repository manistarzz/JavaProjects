import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener{

    Random random=new Random();
    JFrame frame=new JFrame();
    JPanel title_panel=new JPanel();
    JPanel button_panel=new JPanel();
    JLabel textfield= new JLabel();
    JButton[] buttons=new JButton[9];
    boolean player1_turn;
    
   
    TicTacToe(){
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(800,800);
         frame.getContentPane().setBackground(Color.LIGHT_GRAY);
         frame.setLayout(new BorderLayout());
         frame.setVisible(true);

         textfield.setBackground(Color.BLUE);
         textfield.setForeground(Color.BLACK);
         textfield.setFont(new Font("Ink Free",Font.BOLD,75));
         textfield.setHorizontalAlignment(0);
         textfield.setText("Tic-Tac-Toe");
         textfield.setOpaque(true);

         title_panel.setLayout((new BorderLayout()));
         title_panel.setBounds(0,0,800,100);
         
         button_panel.setLayout(new GridLayout(3,3));
         button_panel.setBackground(Color.gray);
         frame.add(button_panel);

        for (int i=0;i<9;i++)
        {
            buttons[i]=new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

         title_panel.add(textfield);
         frame.add(title_panel,BorderLayout.NORTH);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        checkmate();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(Color.GREEN);
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        checkmate();
                    }
                }
            }
        }
    }
       
    

    //create a method to randomly oick if x or o goes first
    public void firstTurn(){
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
            if(random.nextInt(2)==0){
            player1_turn=true;
            textfield.setText("X turn");
        }

        else{
             player1_turn=false;
            textfield.setText("O turn");
        }
        }
        

    //a method to see if  a player has won
    public void checkmate(){
        if((buttons[0].getText()=="X")&&
            (buttons[1].getText()=="X")&&
            (buttons[2].getText()=="X")){
                textfield.setText("X Wins");
                xWin(1,2,3);
            }
            
            else if((buttons[3].getText()=="X")&&
            (buttons[4].getText()=="X")&&
            (buttons[5].getText()=="X")){
                textfield.setText("X Wins");
                xWin(3,4,5);
            }
            else if((buttons[6].getText()=="X")&&
            (buttons[7].getText()=="X")&&
            (buttons[8].getText()=="X")){
                textfield.setText("X Wins");
                xWin(6,7,8);
            }
            else if((buttons[0].getText()=="X")&&
            (buttons[4].getText()=="X")&&
            (buttons[8].getText()=="X")){
                textfield.setText("X Wins");
                xWin(0,4,8);
            }
            else if((buttons[2].getText()=="X")&&
            (buttons[4].getText()=="X")&&
            (buttons[6].getText()=="X")){
                textfield.setText("X Wins");
                xWin(2,4,6);
            }
            else if((buttons[0].getText()=="X")&&
            (buttons[3].getText()=="X")&&
            (buttons[6].getText()=="X")){
                textfield.setText("X Wins");
                xWin(0,3,6);
            }
            else if((buttons[1].getText()=="X")&&
            (buttons[4].getText()=="X")&&
            (buttons[7].getText()=="X")){
                textfield.setText("X Wins");
                xWin(1,4,7);
            }
            else if((buttons[2].getText()=="X")&&
            (buttons[5].getText()=="X")&&
            (buttons[8].getText()=="X")){
                textfield.setText("X Wins");
                xWin(2,5,8);
            }

            if((buttons[0].getText()=="O")&&
            (buttons[1].getText()=="O")&&
            (buttons[2].getText()=="O")){
                textfield.setText("O Wins");
                oWin(1,2,3);
            }
            
            else if((buttons[3].getText()=="O")&&
            (buttons[4].getText()=="O")&&
            (buttons[5].getText()=="O")){
                textfield.setText("O Wins");
                oWin(3,4,5);
            }
            else if((buttons[6].getText()=="O")&&
            (buttons[7].getText()=="O")&&
            (buttons[8].getText()=="O")){
                textfield.setText("O Wins");
                oWin(6,7,8);
            }
            else if((buttons[0].getText()=="O")&&
            (buttons[4].getText()=="O")&&
            (buttons[8].getText()=="O")){
                textfield.setText("O Wins");
                oWin(0,4,8);
            }
            else if((buttons[2].getText()=="O")&&
            (buttons[4].getText()=="O")&&
            (buttons[6].getText()=="O")){
                textfield.setText("O Wins");
                oWin(2,4,6);
            }
            else if((buttons[0].getText()=="O")&&
            (buttons[3].getText()=="O")&&
            (buttons[6].getText()=="O")){
                textfield.setText("O Wins");
                oWin(0,3,6);
            }
            else if((buttons[1].getText()=="O")&&
            (buttons[4].getText()=="O")&&
            (buttons[7].getText()=="O")){
                textfield.setText("O Wins");
                oWin(1,4,7);
            }
            else if((buttons[2].getText()=="O")&&
            (buttons[5].getText()=="O")&&
            (buttons[8].getText()=="O")){
                textfield.setText("O Wins");
                oWin(2,5,8);
            }
    }

    //check to see if x wins
    public void xWin(int a,int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
    }

    //checl to see if o wins
    public void oWin(int a,int b, int c){
         buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
    }
    


    
}
