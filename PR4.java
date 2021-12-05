import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PR4 extends JFrame implements ActionListener{


    public static void main(String[] args) {
        PR4 tmep = new PR4();
    }


    private int Milan = 0;
    private int RM = 0;
    JButton MilanButton = new JButton("Milan");
    JButton RMButton = new JButton("RM");

    JLabel Score = new JLabel("Score " + Milan + " - " + RM);
    JLabel LastOneScored = new JLabel("LS: None");
    JLabel Winner = new JLabel("W: None");

    Font MilanFont = new Font("Times new roman", Font.ITALIC, 20);
    Font RMFont = new Font("Times new roman", Font.ITALIC, 20);

    PR4() {
        MilanButton.addActionListener(this);
        RMButton.addActionListener(this);

        MilanButton.setBackground(Color.white);
        MilanButton.setForeground(Color.BLACK);
        RMButton.setBackground(Color.white);
        RMButton.setForeground(Color.BLACK);

        MilanButton.setFont(MilanFont);
        RMButton.setFont(RMFont);

        this.setTitle("Practice - 4");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());

        this.add(MilanButton);
        this.add(RMButton);

        this.add(LastOneScored);
        this.add(Score);
        this.add(Winner);

        this.setVisible(true);
    };

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == MilanButton){
            Milan++;
            LastOneScored.setText("LS: MIlan");
        }
        else{
            RM++;
            LastOneScored.setText("LS: RM");
        };
        Score.setText("Score " + Milan + " - " + RM);
        if(Milan == RM) {
            Winner.setText("Winner: DRAW");
        }
        else if(Milan > RM) {
            Winner.setText("Побеждает: мелан");
        }
        else
            Winner.setText("Выигрышь забирает: настоящий модрид");
    };
};
