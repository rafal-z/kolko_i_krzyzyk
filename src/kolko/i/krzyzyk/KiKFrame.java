package kolko.i.krzyzyk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Rafał.
 */
public class KiKFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 320;
    private static final int DEFAULT_HEIGHT = 395;
    private Plansza plansza;
    private Gra gra;
    private Siatka siatka;
    private JFrame oknoUstawien;

    private JLabel label;
    private JMenuBar menuBar;
    private JMenu menuPlik;
    private JMenuItem menuNowaGra, menuUstawienia, menuZamknij;

    public KiKFrame(){
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        this.setTitle("Kółko i krzyżyk");

        plansza = new Plansza();
        gra = new Gra(plansza,this);
        siatka = new Siatka(plansza);
        oknoUstawien =  new OknoUstawien(this);
        label = new JLabel("Witaj w grze - Kółko i krzyżyk");
        menuBar = new JMenuBar();
        menuPlik = new JMenu("Plik");
        menuNowaGra = new JMenuItem("Nowa Gra");
        menuUstawienia = new JMenuItem("Ustawienia");
        menuZamknij = new JMenuItem("Zamknij");

        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        menuBar.add(menuPlik);
        menuPlik.add(menuNowaGra);
        menuPlik.add(menuUstawienia);
        menuPlik.addSeparator();
        menuPlik.add(menuZamknij);

        menuNowaGra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plansza.wyczyscPlansze();
                label.setText(" ");
                if(gra.getKtoZaczyna() == 2)
                    gra.ruchG2();
                repaint();
            }
        });

        menuUstawienia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oknoUstawien.setVisible(true);
            }
        });

        menuZamknij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        siatka.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int mouseX = e.getX()/100;
                int mouseY = e.getY()/100;

                if (gra.ruchG1(mouseY, mouseX))
                    gra.ruchG2();

                repaint();
            }
        });

        this.add(siatka);
        this.add(label, BorderLayout.PAGE_END);
        this.setJMenuBar(menuBar);

        if(gra.getKtoZaczyna() == 2) {
            gra.ruchG2();
            repaint();
        }
    }

    public JLabel getLabel() {
        return label;
    }

    public Gra getGra() { return gra; }
}
