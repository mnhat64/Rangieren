import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Eingabeklasse zeigt wie das Programm
 * die Eingabe von dem Nutezer interpretiert werden sollen.
 *
 * @author Minh Nhat Phan
 * @version 1
 */

public class Eingabe {
    private Random random = new Random();

    /**
     * Der Nutzer tippt eine Kette von Integerwerten, die als ein String von dem Programm als ein String angenommen werden.
     * @return Eine Integerliste mit allen eingegebenen Werten
     */

    public int[] waggonInput(){
        System.out.println("Type in a list of numbered Waggons");
        System.out.println("The list should only contains numbers and they are seperated with a space");
        while(true){
            Scanner numberInput = new Scanner(System.in);
            String inputList = numberInput.nextLine();
            String splitList[] = inputList.split(" ");
            int[] numberedWaggons = new int[splitList.length];
            boolean invaldInput = false;

            for (int i = 0; i < splitList.length; i++){
                try {
                    numberedWaggons[i] = Integer.parseInt(splitList[i]);
                } catch (Exception e){
                    System.out.println("You should only type in numbers, please try again");
                    invaldInput = true;
                    break;
                }
                if(i== splitList.length -1 && !invaldInput){
                    return numberedWaggons;
                }
            }
        }
    }
    /**
     * Die Waggons werden zufällig gestellt und die Menge davon wird von dem Nutzer bestimmt.
     * @return Eine Liste von Integerwerten.
     */
    public int[] randomInput(){

        int menge = 0;
        System.out.println("How many waggons do you want to be added?");
        while(true){
            try{
                Scanner numberInput = new Scanner(System.in);
                menge = numberInput.nextInt();
                if(menge < 1){
                    System.out.println("There would have to be more than one waggon");
                    continue;
                }
                break;
            }catch(InputMismatchException e){
                System.out.println("Please type in a number");
            }
        }
        int[] inputList = new int[menge];
        for (int i = 0; i < menge; i++){
            inputList[i] = random.nextInt(100);
        }
        return inputList;
    }
    /**
     * Die Methode fragt, ob der Nutzer die Liste selbst eintippen oder die zufällig erstellt lassen will.
     * @return Wahrheitswert
     */
    public boolean runRandom(){
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to type in the list yourself?");
        System.out.println("Type in 1 if you want to create a list yourself \nType in 2 if you want a random list");
        int numberInput = input.nextInt();
        if(numberInput == 2){
            return true;
        } return false;
    }

    /**
     * die Methode fragt, ob der Nutzer die Simulation nochmal laufen lassen will-
     * @return Wahrheitswert
     */

    public boolean runAgain(){


        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to run the simulation again?");
        System.out.println("If yes, type 1 in \nIf no, type 2 in");
        int numberInput = input.nextInt();
        if(numberInput == 1){
            return true;
        } return false;
    }

}
