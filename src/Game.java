import java.util.Scanner;
import java.util.ArrayList;
public class Game {
  public static void main(String args[]){
    boolean isStart = true;
    while(isStart){
      ArrayList<String> name = new ArrayList<>();
      String inputs;
      Scanner input = new Scanner(System.in);
      System.out.print("Enter Avatar name: ");
      inputs = input.nextLine();
      if (inputs.equalsIgnoreCase("stop")){
        break;
      }
      name.add(inputs);
      
    }
    System.out.println(name.toString());
    

    Avatar bob = new Avatar();

  }

  
}

