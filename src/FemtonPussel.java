import javax.swing.*;
import java.awt.*;

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

            }

        }

        mainPanel.add(rutNät, BorderLayout.CENTER);
        mainPanel.add(shuffleKnapp, BorderLayout.SOUTH);
        mainPanel.add(statusBanner, BorderLayout.NORTH);

        add(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    static void main(){
        System.out.println("hej");
        new FemtonPussel();
    }


}
