/**
 * Die Waggon-Klasse
 * @author Minh Nhat Phan
 * @version 1.0
 *
 */

public class Waggon{
    private int number;

    /**
     * Der Konstruktor für alle Objekte der Klasse
     * @param number der Nummer am Waggon
     */

    public Waggon(int number){
        this.number = number;
    }

    /**
     * Die Methode gibt den Nummer von einem Waggon züruck
     * @return number
     */
    public int getNumber(){
        return number;
    }

    /**
     * Die Methode wandelt den Nummer in String um
     * @return ein umgewandelter String
     */

    public String toString(){

        return String.format("%d", number);
    }
}