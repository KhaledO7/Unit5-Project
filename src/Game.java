import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Game {
  public static void main(String args[]){
    ArrayList<String> name = new ArrayList<>();
    boolean isStart = true;
    while(isStart){

      String inputs;
      Scanner input = new Scanner(System.in);
      System.out.print("Enter Opponents name: ");
      inputs = input.nextLine();
      if (inputs.equalsIgnoreCase("stop")){
        break;
      }
      name.add(inputs);
      
    }
    System.out.println(Arrays.toString(name.toArray()));
    System.out.println();
    while(isStart){
      Scanner input = new Scanner(System.in);
      System.out.print("What Avatar would you like (Fighter,Mage, Basic");
      if (input.nextLine() == "Fighter"){
        //add fighter class constructor thing
      }
      if (input.nextLine() == "Basic"){
        //add basic class constructor thing
      }
      if (input.nextLine() == "Mage"){
        //add mage class constructor thing
      }

    }

    Avatar bob = new Avatar();

  }

  
}

