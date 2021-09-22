/**
 * Die Rangieren-Klasse
 * @author Minh Nhat Phan
 * @version 1.0
 *
 */
public class Rangieren {
    /**
     * hier wird ein Gleis erstellt und werden alle Werte zugeordnet
     */
    public void rangieren(){
        Eingabe e = new Eingabe();
        boolean runRandom = e.runRandom();
        int[] numbers;
        Gleis g;
        if(!runRandom)numbers = e.waggonInput();
        else numbers = e.randomInput();

        g = new Gleis(numbers, runRandom);
        g.start();
    }
}
