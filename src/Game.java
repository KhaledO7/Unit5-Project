import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class Game {
  public static void main(String args[]){
    ArrayList<String> name = new ArrayList<>();
    boolean isStart = true;
    String inputs = "";
    while(isStart){

      Scanner input = new Scanner(System.in);
      System.out.print("Enter Opponents name: (or type 'stop' to end game): ");
      inputs = input.nextLine();
      if (inputs.equalsIgnoreCase("stop")){
        break;
      }
      name.add(inputs);
      
    }




    Random random = new Random();
    double health = 50 + random.nextInt(151); // Random health between 50 and 200
    double damage = 30 + random.nextInt(50);


    int opponentType = random.nextInt(3); // Randomly select 0, 1, or 2

    Avatar opponent = null;
    if (opponentType == 0){
      opponent = new Mage(inputs, health, "Ice Eruption", "My heart is cold to the touch.",200);}
    else if (opponentType == 1){
      opponent = new Fighter(inputs,health,"Crescent Chop", "My chop splits time and earth.", "Thats impossible, you killed me....");
    }
    else if (opponentType == 2){
      opponent = new Avatar(inputs,health,"S","Strong Right","No one can withstand my Strong Right!", 1.0,1.0,true, damage, "And I'm dead...");
    }


    System.out.println(Arrays.toString(name.toArray()));
    System.out.println();
    Avatar chosenAvatar = null;
    while(isStart){
      Scanner input = new Scanner(System.in);
      System.out.print("What Avatar would you like (Fighter,Mage, Basic) ");
      String avatarType = input.nextLine().toLowerCase();
      if (avatarType.equals("fighter")){
        chosenAvatar = new Fighter("Warrior", 200, "Smash", "Defeat is not an option.", "WTH, IM DEAD? SCREW U PLAYER");
        break;
        //add fighter class constructor thing
      }
      if (avatarType.equals("basic")){
        chosenAvatar = new Avatar();
        break;
        //add basic class constructor thing
      }
      if (avatarType.equals("mage")){
        chosenAvatar = new Mage("Gandalf", 120, "Fireball", "You shall not pass!", 100);}
        break;

    }
    System.out.println("--- Battle Start ---");
    while (chosenAvatar.getHealth() > 0 && opponent.getHealth() > 0) {
      System.out.println("Your turn!");
      System.out.println(chosenAvatar.getName() + " uses " + chosenAvatar.getAbility() + "!");
      opponent.takeDamage(chosenAvatar.getAbDmg());

      if (opponent.getHealth() <= 0) {
        System.out.println(opponent.getName() + " has been defeated!");
        break;
      }

      System.out.println("Opponent's turn!");
      System.out.println(opponent.getName() + " uses " + opponent.getAbility() + "!");
      chosenAvatar.takeDamage(opponent.getAbDmg());

      if (chosenAvatar.getHealth() <= 0) {
        System.out.println(chosenAvatar.getName() + " has been defeated!");
        break;
      }
    }
    Avatar bob = new Avatar();

  }

  
}

