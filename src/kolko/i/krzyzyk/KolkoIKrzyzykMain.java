package kolko.i.krzyzyk;

import javax.swing.*;
import java.awt.EventQueue;

/**
 * Created by Rafał.
 */
public class KolkoIKrzyzykMain {
    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                KiKFrame frame = new KiKFrame();
            }
        });
    }
}
