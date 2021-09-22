import java.util.Arrays;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Die Klasse enthaelt Methoden, die die Waggons von einem Gleis zu einem anderen bringen.
 *
 * @author Minh Phan
 * @version 1.0
 */



/**
 * Objektvariablen
 *
 * @param Aktion
 * die Anzahl der Aktien, die um 1 erhoeht, jedes Mal wenn ein Waggon zu einem neuen Gleis tranportiert wird.
 * @param randomWaggon
 * ein Wahrheitswert, ob der Nutzer die Liste eintippen will oder nicht.
 *
 */
public class Gleis {

    private int Aktion = 1;
    private ArrayList<Waggon> zuggleis = new ArrayList<Waggon>();
    private Stack<Waggon> abstellgleis = new Stack<Waggon>();
    private Stack<Waggon> rangiergleis = new Stack<Waggon>();
    private ArrayList<Integer> waggonSorted = new ArrayList<Integer>();
    private boolean randomWaggon;
    private Eingabe input = new Eingabe();
    private String ausgabeZ = new String();

    /**
     * Konstruktor fuer die Objekte der Klasse;
     * Jedes Waggon wird in dem abstellgleis Stack und in der Liste waggonSorted hinzugefuegt.
     * Die Waggons wird in der Liste waggonSorted sortiert.
     */

    public Gleis(int[] waggon, boolean randomWaggon){

        this.randomWaggon = randomWaggon;
        for(int i = waggon.length; i >= 1; i--){
            abstellgleis.push(new Waggon((waggon[i-1])));
            System.out.println(abstellgleis.peek().getNumber());
            waggonSorted.add(abstellgleis.peek().getNumber());
        }
        Collections.sort(waggonSorted);
    }

    /**
     * Die Methode nimmt das erste Waggon von dem Stack abstellgleis und bringt das zu dem Stack rangiergleis
     * Die Aktion wird danach um 1 erhöht
     */

    public void abstellRangier(){
        rangiergleis.push(abstellgleis.pop());
        System.out.println(String.format("%30d %30d %30s %30s %30s %30s %30s"
                , Aktion, rangiergleis.peek().getNumber(), "Abstellgleis", "Rangiergleis", ausgabeZ,
                Arrays.toString(rangiergleis.toArray()).replace("[","").replace("]",""),
                Arrays.toString(abstellgleis.toArray()).replace("[","").replace("]","")));
        this.Aktion += 1;
    }

    /**
     * Die Methode nimmt das erste Waggon von dem Stack abstellgleis und bringt das zu der Liste Zuggleis
     * Das Waggon wird von der List waggonSorted geloescht, weil das Waggon schon auf dem Zuggleis zugeordnet wird.
     * Die Aktion wird danach um 1 erhoeht
     */
    public void abstellZug(){
        ausgabeZ = ausgabeZ + " " + abstellgleis.peek().getNumber();
        System.out.println(String.format("%30d %30d %30s %30s %30s %30s %30s"
                , Aktion, abstellgleis.peek().getNumber(), "Abstellgleis", "Zuggleis", ausgabeZ,
                Arrays.toString(rangiergleis.toArray()).replace("[","").replace("]",""),
                Arrays.toString(abstellgleis.toArray()).replace("[","").replace("]","")));
        zuggleis.add(abstellgleis.pop());
        waggonSorted.remove(0);
        this.Aktion += 1;
    }

    /**
     * Die Methode nimmt das erste Waggon von dem Stack rangiergleis und bringt das zu der Liste Zuggleis
     * Das Waggon wird von der List waggonSorted geloescht, weil das Waggon schon auf dem Zuggleis zugeordnet wird.
     * Die Aktion wird danach um 1 erhoeht
     */
    public void rangierZug(){
        ausgabeZ = ausgabeZ + " " + rangiergleis.peek().getNumber();

        System.out.println(String.format("%30d %30d %30s %30s %30s %30s %30s"
                , Aktion, rangiergleis.peek().getNumber(), "Rangiergleis", "Zuggleis", ausgabeZ,
                Arrays.toString(rangiergleis.toArray()).replace("[","").replace("]",""),
                Arrays.toString(abstellgleis.toArray()).replace("[","").replace("]","")));
        zuggleis.add(rangiergleis.pop());
        waggonSorted.remove(0);
        this.Aktion += 1;
    }


    /**
     * Die Methode nimmt das erste Waggon von dem Stack rangiergleis und bringt das zu der Liste abstellgleis
     * Die Aktion wird danach um 1 erhoeht
     */

    public void rangierAbstell(){
        while(!rangiergleis.isEmpty()){
            if(rangiergleis.peek().getNumber() == waggonSorted.get(0)){
                rangierZug();
            } else{
                abstellgleis.push(rangiergleis.pop());
                System.out.println(String.format("%30d %30d %30s %30s %30s %30s %30s"
                        , Aktion, abstellgleis.peek().getNumber(), "Rangiergleis", "Abstellgleis", ausgabeZ,
                        Arrays.toString(rangiergleis.toArray()).replace("[","").replace("]",""),
                        Arrays.toString(abstellgleis.toArray()).replace("[","").replace("]","")));
                this.Aktion += 1;
            }
        }
    }
    /**
     * Die Methode startet die Simulation
     * Das Waggon wird zuerst mit dem ersten Element von der bereit sortierten Liste veglichen
     * Die Aktion wird danach um 1 erhoeht
     */

    public void start(){
        while(true){
            System.out.println(String.format("%30s %30s %30s %30s %30s %30s %30s", "Aktion",
                    "Waggon", "von", "nach", "Zuggleis" , "Rangiergleis", "Abstellgleis"));

            while(!(abstellgleis.empty() && rangiergleis.empty())){
                if(abstellgleis.peek().getNumber() == waggonSorted.get(0)){
                    abstellZug();
                    rangierAbstell();
                } else{
                    abstellRangier();
                }
            }
            if(randomWaggon == false){
                break;
            }
            reset();
            if(randomWaggon == false){
                break;
            }
        }
    }
    /**
     * Die Methode setzt die Simulation zueruck
     * Alle Liste werden erneut erstellt
     * Die Aktion wird auf 1 ersetzt
     */
    private void reset(){
        Aktion = 1;
        waggonSorted = new ArrayList<Integer>();
        zuggleis = new ArrayList<Waggon>();
        rangiergleis = new Stack<Waggon>();
        input = new Eingabe();
        randomWaggon = input.runAgain();
        ausgabeZ = new String();
        if(randomWaggon == true){
            int[] waggon = input.randomInput();
            for (int i = waggon.length; i >= 1; i--){
                abstellgleis.push(new Waggon(waggon[i-1]));
                System.out.println(abstellgleis.peek().getNumber());
                waggonSorted.add(abstellgleis.peek().getNumber());
            }
            Collections.sort(waggonSorted);
        }
    }






}
