package kolko.i.krzyzyk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafał.
 */
public class Plansza {
    private static final int ROZMIAR = 3;
    private List<List<ElementPlanszy>> elementyPlanszy = new ArrayList<List<ElementPlanszy>>();

    public Plansza(){
        for(int i=0; i<ROZMIAR; i++){
            List<ElementPlanszy> wiersz = new ArrayList<ElementPlanszy>();
            for(int j=0; j<ROZMIAR; j++){
                wiersz.add(new ElementPlanszy(i,j));
            }
            elementyPlanszy.add(wiersz);
        }
    }

    void wyczyscPlansze(){
        for(int i=0; i<ROZMIAR; i++)
            for(int j=0; j<ROZMIAR; j++)
                elementyPlanszy.get(i).get(j).setStan(Stan.PUSTY);
    }

    public int getRozmiar(){
        return ROZMIAR;
    }

    public Stan zwrocStan(int x, int y){
        return elementyPlanszy.get(x).get(y).getStan();
    }

    public void wykonajRuch(int x, int y, Stan stan){
        this.elementyPlanszy.get(x).get(y).setStan(stan);
    }

    public List<List<ElementPlanszy>> getElementyPlanszy(){
        return elementyPlanszy;
    }

}
