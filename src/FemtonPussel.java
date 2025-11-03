import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FemtonPussel extends JFrame {
    private JButton[][] knappar = new JButton[4][4];
    private int tomRad = 3;
    private int tomColumn = 3;
    private JLabel statusBanner;

    public FemtonPussel(){
        setTitle("15 pussel");
        setSize(400, 400);
        setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel rutNät = new JPanel(new GridLayout(4, 4));
        JButton shuffleKnapp = new JButton("Shuffle");
        statusBanner = new JLabel("Spel pågår. ");
        int nummerPåKnapp = 1;

        for (int rad = 0; rad < 4; rad++) {
            for (int column = 0; column < 4; column++) {
                JButton knapp;
                if (rad == 3 && column == 3){
                    knapp = new JButton("");
                }else {
                    knapp = new JButton(String.valueOf(nummerPåKnapp));
                    nummerPåKnapp++;
                }
                knappar[rad][column] = knapp;
                rutNät.add(knapp);
                knapp.addActionListener(new MoveTileListener(rad, column));

            }

        }

        mainPanel.add(rutNät, BorderLayout.CENTER);
        mainPanel.add(shuffleKnapp, BorderLayout.SOUTH);
        mainPanel.add(statusBanner, BorderLayout.NORTH);
        shuffleKnapp.addActionListener(e -> shuffleTiles());

        add(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public class MoveTileListener implements ActionListener{
        private int rad;
        private int column;

        MoveTileListener(int rad, int column){
            this.rad = rad;
            this.column = column;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (isNextToEmpty(rad, column)){
                knappar[tomRad][tomColumn].setText(knappar[rad][column].getText());
                knappar[rad][column].setText("");

                tomRad = rad;
                tomColumn = column;

            }

        }
    }

    public boolean isNextToEmpty(int rad, int column){
        if (rad == tomRad - 1 && column ==tomColumn){
            return true;
        } else if (rad == tomRad + 1 && column == tomColumn) {
            return true;
        } else if (rad == tomRad && column == tomColumn -1) {
            return true;
        } else if (rad == tomRad && column == tomColumn +1){
            return true;
        }
        return false;
    }
    public void shuffleTiles(){
        Random random = new Random();
        for (int i = 0; i < 999; i++) {
            int rad = random.nextInt(4);
            int column = random.nextInt(4);

            if (isNextToEmpty(rad, column)){
                knappar[tomRad][tomColumn].setText(knappar[rad][column].getText());
                knappar[rad][column].setText("");
                tomRad = rad;
                tomColumn = column;

            }
        }
    }

    static void main(){
        new FemtonPussel();
    }


}
