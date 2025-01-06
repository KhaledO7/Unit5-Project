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
      System.out.print("Enter Opponents name: (or type 'stop' to name add game): ");
      inputs = input.nextLine();
      if (inputs.equalsIgnoreCase("stop")){
        break;
      }
      name.add(inputs);
      
    }




    Random random = new Random();
    double health = 50 + random.nextInt(151); // Random health between 50 and 200
    double damage = 30 + random.nextInt(50);


    int opponentType = random.nextInt(name.toArray().length); // Randomly select 0, 1, or 2

    Avatar opponent = null;
    if (opponentType == 0){
      opponent = new Mage(name.getFirst(), health, "Ice Eruption", "My heart is cold to the touch.",200);}
    else if (opponentType == 1){
      opponent = new Fighter(name.get(1), health,"Crescent Chop", "My chop splits time and earth.", "Thats impossible, you killed me....");
    }
    else if (opponentType == 2){
      opponent = new Avatar(name.get(2),health,"S","Strong Right","No one can withstand my Strong Right!", 1.1,1.2,true, damage, "And I'm dead...");
    }
    else{
      opponent = new Avatar(name.get(opponentType), health, "A", "Stab", "Surrender", .9, 1.1, true, damage, "XD");
    }


    System.out.println(Arrays.toString(name.toArray()));
    System.out.println();
    Avatar chosenAvatar = null;

    while(isStart){
      Scanner input = new Scanner(System.in);
      System.out.print("Would you like pre-made Avatars");
      String yesNo = input.nextLine().toLowerCase();
      if(yesNo.equals("yes")){
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

      if(yesNo.equals("no")){
        System.out.print("What Avatar would you like (Fighter or Mage) ");
        String avatarType = input.nextLine().toLowerCase();

        if (avatarType.equals("fighter")){
          System.out.print("Name:");
          String player = input.nextLine();
          System.out.print("Health:");
          int h = Integer.parseInt(input.nextLine());
          System.out.print("Ability:");
          String ability = input.nextLine();
          System.out.print("Voice Line:");
          String vl = input.nextLine();
          System.out.print("Death Sound:");
          String death = input.nextLine();
          if(h > 200) {
            System.out.println("Max Health Allowed is 500");
            h = 500;
          }
          chosenAvatar = new Fighter(player, h, ability, vl, death);
          break;
          //add fighter class constructor thing
        }
        if (avatarType.equals("mage")){
          System.out.print("Name:");
          String player = input.nextLine();
          System.out.print("Health:");
          int h = Integer.parseInt(input.nextLine());
          System.out.print("Ability:");
          String ability = input.nextLine();
          System.out.print("Voice Line:");
          String vl = input.nextLine();
          System.out.print("Mana:");
          int m = Integer.parseInt(input.nextLine());
          if(h > 200 || m > 200){
            System.out.println("Max Health or Mana Allowed is 200");
            if (h > 200) {
              h = 200;
            }
            if(m > 200){
              m = 200;
            }
          }
          chosenAvatar = new Mage(player, h, ability, vl, m);}
        break;

      }



    }
    System.out.println("--- Battle Start ---");
    System.out.println("You have chosen " + chosenAvatar.getName() + "\n" + "Type: " + chosenAvatar.getType());
    chosenAvatar.voiceline();

    while (chosenAvatar.getHealth() > 0 && opponent.getHealth() > 0) {
      System.out.println("Your turn!");

      System.out.println(chosenAvatar.getName() + " uses " + chosenAvatar.getAbility() + "!");
      opponent.takeDamage(chosenAvatar.getAbDmg());

      if (opponent.getHealth() <= 0) {
        System.out.println(opponent.getName() + " has been defeated!");
        isStart = false;
      }

      System.out.println("Opponent's turn!");
      System.out.println(opponent.getName() + " uses " + opponent.getAbility() + "!");
      chosenAvatar.takeDamage(opponent.getAbDmg());

      if (chosenAvatar.getHealth() <= 0) {
        System.out.println(chosenAvatar.getName() + " has been defeated!");
        chosenAvatar.deathSound();
        isStart = false;
      }
    }
    Avatar bob = new Avatar();

  }

  
}

