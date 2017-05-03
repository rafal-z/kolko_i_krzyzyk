package kolko.i.krzyzyk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Rafał.
 */
public class Gra {
    private Plansza plansza;
    private KiKFrame ramka;
    private Stan znakG1, znakG2;
    private int ktoZaczyna;

    public Gra(Plansza plansza, KiKFrame ramka){
        this.plansza = plansza;
        this.ramka = ramka;
        this.znakG1 = Stan.KOLKO;
        this.znakG2 = Stan.KRZYZYK;
        this.ktoZaczyna = 1;
    }

    public boolean ruchG1(int x, int y) {
        if (!koniecGry() && !czyWygrana(znakG1) && !czyWygrana(znakG2)) {
            while(true) {
                if (plansza.zwrocStan(x, y) == Stan.PUSTY) {
                    plansza.wykonajRuch(x, y, znakG1);
                    dajKomunikat();
                    return true;
                } else {
                    ramka.getLabel().setText("Wybierz inne pole!");
                    return false;
                }
            }
        }
        return false;
    }

    public void ruchG2() {
        if(!koniecGry() && !czyWygrana(znakG1) && !czyWygrana(znakG2)) {
            Random generator = new Random();
            while(true) {
                int x = generator.nextInt(3);
                int y = generator.nextInt(3);

                if (plansza.zwrocStan(x, y) == Stan.PUSTY) {
                    plansza.wykonajRuch(x, y, znakG2);
                    ramka.getLabel().setText("Gracz2 wybrał pole ["+x+", "+y+"]");
                    break;
                }
            }
        }
        dajKomunikat();
    }

    private void dajKomunikat(){
        if(koniecGry() || czyWygrana(znakG1) || czyWygrana(znakG2))
            if(czyWygrana(znakG1))
                ramka.getLabel().setText("Koniec gry! WYGRAŁEŚ!!!");
            else if(czyWygrana(znakG2))
                ramka.getLabel().setText("Koniec gry! Wygrał Gracz2");
            else
                ramka.getLabel().setText("Koniec gry! Remis");
    }

    public boolean koniecGry(){
        List<List<ElementPlanszy>> elementyPlanszy = new ArrayList<List<ElementPlanszy>>();
        elementyPlanszy = plansza.getElementyPlanszy();

        for(int i=0; i<plansza.getRozmiar(); i++){
            for(int j=0; j<plansza.getRozmiar(); j++){
                if(elementyPlanszy.get(i).get(j).getStan() == Stan.PUSTY)
                    return false;
            }
        }
        return true;
    }

    public boolean czyWygrana(Stan stan){
        List<List<ElementPlanszy>> elementyPlanszy = new ArrayList<List<ElementPlanszy>>();
        elementyPlanszy = plansza.getElementyPlanszy();

        return (elementyPlanszy.get(0).get(0).getStan() == stan && elementyPlanszy.get(0).get(1).getStan() == stan && elementyPlanszy.get(0).get(2).getStan() == stan) ||
                (elementyPlanszy.get(1).get(0).getStan() == stan && elementyPlanszy.get(1).get(1).getStan() == stan && elementyPlanszy.get(1).get(2).getStan() == stan) ||
                (elementyPlanszy.get(2).get(0).getStan() == stan && elementyPlanszy.get(2).get(1).getStan() == stan && elementyPlanszy.get(2).get(2).getStan() == stan) ||
                (elementyPlanszy.get(0).get(0).getStan() == stan && elementyPlanszy.get(1).get(0).getStan() == stan && elementyPlanszy.get(2).get(0).getStan() == stan) ||
                (elementyPlanszy.get(0).get(1).getStan() == stan && elementyPlanszy.get(1).get(1).getStan() == stan && elementyPlanszy.get(2).get(1).getStan() == stan) ||
                (elementyPlanszy.get(0).get(2).getStan() == stan && elementyPlanszy.get(1).get(2).getStan() == stan && elementyPlanszy.get(2).get(2).getStan() == stan) ||
                (elementyPlanszy.get(0).get(0).getStan() == stan && elementyPlanszy.get(1).get(1).getStan() == stan && elementyPlanszy.get(2).get(2).getStan() == stan) ||
                (elementyPlanszy.get(2).get(0).getStan() == stan && elementyPlanszy.get(1).get(1).getStan() == stan && elementyPlanszy.get(0).get(2).getStan() == stan);
    }

    public Plansza getPlansza() {
        return plansza;
    }

    public int getKtoZaczyna() {
        return ktoZaczyna;
    }

    public void setKtoZaczyna(int ktoZaczyna) {
        this.ktoZaczyna = ktoZaczyna;
    }

    public Stan getZnakG1() {
        return znakG1;
    }

    public void setZnakG1(Stan znakG1) {
        this.znakG1 = znakG1;
    }

    public Stan getZnakG2() {
        return znakG2;
    }

    public void setZnakG2(Stan znakG2) {
        this.znakG2 = znakG2;
    }
}
