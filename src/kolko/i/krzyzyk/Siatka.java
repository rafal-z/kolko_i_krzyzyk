package kolko.i.krzyzyk;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by Rafał.
 */
public class Siatka extends JPanel {
    public static final int ROZ_KOMORKI = 100;
    public static final int DL_LINI = 300;
    public static final int GRUBOSC_LINI = 4;
    private Plansza plansza;
    java.util.List<java.util.List<ElementPlanszy>> elementyPlanszy = new ArrayList<java.util.List<ElementPlanszy>>();

    public Siatka(Plansza plansza){
        this.plansza = plansza;
        this.elementyPlanszy = plansza.getElementyPlanszy();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(125, 118, 116));
        setBackground(new Color(157, 158, 159));

        for(int i=1; i<plansza.getRozmiar(); i++)
            g.fillRoundRect(0,i*ROZ_KOMORKI - GRUBOSC_LINI,DL_LINI,GRUBOSC_LINI,GRUBOSC_LINI,GRUBOSC_LINI);
        for(int j=1; j<plansza.getRozmiar(); j++)
            g.fillRoundRect(j*ROZ_KOMORKI-GRUBOSC_LINI, 0,GRUBOSC_LINI,DL_LINI,GRUBOSC_LINI,GRUBOSC_LINI);

        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        for(int i=0; i<plansza.getRozmiar(); i++){
            for(int j=0; j<plansza.getRozmiar(); j++){
                int x1 = j*ROZ_KOMORKI+16;
                int y1 = i*ROZ_KOMORKI+16;
                if(elementyPlanszy.get(i).get(j).getStan() == Stan.KRZYZYK) {
                    g2d.setColor(Color.blue);
                    int x2 = (j+1)*ROZ_KOMORKI-16;
                    int y2 = (i+1)*ROZ_KOMORKI-16;
                    g2d.drawLine(x1,y1,x2,y2);
                    g2d.drawLine(x2,y1,x1,y2);
                }
                else if(elementyPlanszy.get(i).get(j).getStan() == Stan.KOLKO){
                    g2d.setColor(Color.red);
                    g2d.drawOval(x1, y1, ROZ_KOMORKI-16*2, ROZ_KOMORKI-16*2);
                }
            }
        }
    }
}