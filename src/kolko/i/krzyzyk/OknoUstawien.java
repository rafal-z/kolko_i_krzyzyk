package kolko.i.krzyzyk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rafał.
 */
public class OknoUstawien extends JFrame {
    private JRadioButton[] radioButtom;
    private ButtonGroup RadioButtonGroup1, RadioButtonGroup2;
    private JPanel panel1, panel2;
    private GridLayout LayoutGrid1, LayoutGrid2;

    public OknoUstawien(KiKFrame ramka){
        setTitle("Ustawienia");
        this.setLocationRelativeTo(ramka);

        RadioButtonGroup1 = new ButtonGroup();
        RadioButtonGroup2 = new ButtonGroup();
        radioButtom = new JRadioButton[4];
        radioButtom[0] = new JRadioButton("Kółko", true);
        radioButtom[1] = new JRadioButton("Krzyżyk", false);
        radioButtom[2] = new JRadioButton("Pierwszy", true);
        radioButtom[3] = new JRadioButton("Drugi", false);
        LayoutGrid1 = new GridLayout(0,2);
        LayoutGrid2 = new GridLayout(0,2);
        panel1 = new JPanel();
        panel2 = new JPanel();

        RadioButtonGroup1.add(radioButtom[0]);
        RadioButtonGroup1.add(radioButtom[1]);
        RadioButtonGroup2.add(radioButtom[2]);
        RadioButtonGroup2.add(radioButtom[3]);

        panel1.setBorder(BorderFactory.createTitledBorder("Kółko czy krzyżyk?"));
        panel1.setPreferredSize(new Dimension(250, 50));
        panel1.setLayout(LayoutGrid1);
        panel1.add(radioButtom[0]);
        panel1.add(radioButtom[1]);
        panel2.setBorder(BorderFactory.createTitledBorder("Zaczynasz jako:"));
        panel2.setPreferredSize(new Dimension(250, 50));
        panel2.setLayout(LayoutGrid2);
        panel2.add(radioButtom[2]);
        panel2.add(radioButtom[3]);

        radioButtom[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButtom[0].setSelected(true);
                ramka.getGra().setZnakG1(Stan.KOLKO);
                ramka.getGra().setZnakG2(Stan.KRZYZYK);
                ramka.getGra().getPlansza().wyczyscPlansze();
                if(ramka.getGra().getKtoZaczyna() == 2)
                    ramka.getGra().ruchG2();
                ramka.repaint();
            }
        });

        radioButtom[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButtom[1].setSelected(true);
                ramka.getGra().setZnakG1(Stan.KRZYZYK);
                ramka.getGra().setZnakG2(Stan.KOLKO);
                ramka.getGra().getPlansza().wyczyscPlansze();
                if(ramka.getGra().getKtoZaczyna() == 2)
                    ramka.getGra().ruchG2();
                ramka.repaint();
            }
        });

        radioButtom[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButtom[2].setSelected(true);
                ramka.getGra().setKtoZaczyna(1);
                ramka.getGra().getPlansza().wyczyscPlansze();
                ramka.repaint();
            }
        });

        radioButtom[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButtom[3].setSelected(true);
                ramka.getGra().setKtoZaczyna(2);
                ramka.getGra().getPlansza().wyczyscPlansze();
                ramka.getGra().ruchG2();
                ramka.repaint();
            }
        });

        this.add(panel1, BorderLayout.PAGE_START);
        this.add(panel2, BorderLayout.PAGE_END);
        pack();
    }
}
