import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Game {
  static Boolean isStart = true;

  public static void OpponentMove(Random random, Avatar opponent, Avatar chosenAvatar){
    int moveRandom = random.nextInt(90);
    System.out.println("---" + opponent.name + "'s turn! ---");
    if (chosenAvatar.getHealth() <= 0) {
      System.out.println(chosenAvatar.getName() + " has been defeated!");
      if (chosenAvatar.name.equals("Chris"))
      System.out.println("You lost!");
      else
      {chosenAvatar.deathSound();
      }
      System.out.println();
      System.out.println("At least you tried!");
      isStart = false;
    }
    else if (opponent.getHealth() <= 0) {
      System.out.println(opponent.getName() + " has been defeated!");
      opponent.deathSound();
      System.out.println();
      System.out.println("You won!");
      isStart = false;}

    else if (moveRandom > 79) {
      System.out.println(opponent.name + " ran away! You Win!");
    } else if (moveRandom > 55) {
      System.out.println(opponent.name + " healed themselves!");
      opponent.gainHealth();
    } else if (moveRandom > 1) {
      System.out.println(opponent.getName() + " uses " + opponent.getAbility() + "!");
      System.out.println();
      System.out.println("You:");
      chosenAvatar.takeDamage(opponent.getAbDmg());
    }

    System.out.println();
  }
  public static void main(String args[]) {
    ArrayList<String> name = new ArrayList<>();
    boolean powerUpCooldown = true;
    boolean isStart = true;
    String inputs = "";
    while (isStart) {

      Scanner input = new Scanner(System.in);
      System.out.print("Enter Opponents name: (or type 'stop' to name add game): ");
      inputs = input.nextLine();
      if (inputs.equalsIgnoreCase("stop")) {
        break;
      }
      name.add(inputs);

    }


    Random random = new Random();
    double health = 50 + random.nextInt(151); // Random health between 50 and 200
    double damage = 30 + random.nextInt(50);


    int opponentType = random.nextInt(3); // Randomly select 0, 1, or 2

    Avatar opponent = null;
    if (opponentType == 0) {
      opponent = new Mage(name.get(0), health, "Ice Eruption", "My heart is cold to the touch.", 200);
    } else if (opponentType == 1) {
      opponent = new Fighter(name.get(0), health, "Crescent Chop", "My chop splits time and earth.", "Thats impossible, you killed me....");
    } else if (opponentType == 2) {
      opponent = new Avatar(name.get(0), health, "S", "Strong Right", "No one can withstand my Strong Right!", 1.4, 1.2, true, damage, "And I'm dead...");
    } else {
      opponent = new Avatar(name.get(opponentType), health, "A", "Stab", "Surrender", .9, 1.1, true, damage, "XD");
    }


    System.out.println(Arrays.toString(name.toArray()));
    System.out.println();
    Avatar chosenAvatar = null;

    while (isStart) {
      Scanner input = new Scanner(System.in);
      System.out.print("Would you like pre-made Avatars ");
      String yesNo = input.nextLine().toLowerCase();
      if (yesNo.equals("yes")) {
        System.out.print("What Avatar would you like (Fighter,Mage, Basic) ");
        String avatarType = input.nextLine().toLowerCase();

        if (avatarType.equals("fighter")) {
          chosenAvatar = new Fighter("Warrior", 200, "Smash", "Defeat is not an option.", "WTH, IM DEAD? SCREW U PLAYER");
          break;
          //add fighter class constructor thing
        }
        if (avatarType.equals("basic")) {
          chosenAvatar = new Avatar();
          break;
          //add basic class constructor thing
        }
        if (avatarType.equals("mage")) {
          chosenAvatar = new Mage("Gandalf", 120, "Fireball", "You shall not pass!", 100);
        }
        break;
      }

      if (yesNo.equals("no")) {
        System.out.print("What Avatar would you like (Fighter or Mage) ");
        String avatarType = input.nextLine().toLowerCase();

        if (avatarType.equals("fighter")) {
          System.out.print("Name: ");
          String player = input.nextLine();
          System.out.print("Health: ");
          int h = Integer.parseInt(input.nextLine());
          System.out.print("Ability: ");
          String ability = input.nextLine();
          System.out.print("Voice Line: ");
          String vl = input.nextLine();
          System.out.print("Death Sound: ");
          String death = input.nextLine();
          if (h > 200) {
            System.out.println("Max Health Allowed is 500");
            h = 500;
          }
          chosenAvatar = new Fighter(player, h, ability, vl, death);
          break;
          //add fighter class constructor thing
        }
        if (avatarType.equals("mage")) {
          System.out.print("Name: ");
          String player = input.nextLine();
          System.out.print("Health: ");
          int h = Integer.parseInt(input.nextLine());
          System.out.print("Ability: ");
          String ability = input.nextLine();
          System.out.print("Voice Line: ");
          String vl = input.nextLine();
          System.out.print("Mana: ");
          int m = Integer.parseInt(input.nextLine());
          System.out.println(m);
          if (h > 200 || m > 200) {
            System.out.println("Max Health or Mana Allowed is 200");
            if (h > 200) {
              h = 200;
            }
            if (m > 200) {
              m = 200;
            }
          }
          chosenAvatar = new Mage(player, h, ability, vl, m);
        }
        break;

      }

  
    }
    

    System.out.println("--- Battle Start ---");
    System.out.println();
    System.out.println("You have chosen " + chosenAvatar.getName() + "\n" + "Type: " + chosenAvatar.getType().toUpperCase());
    System.out.println();
    chosenAvatar.voiceLine();


    while (chosenAvatar.getHealth() > 0 && opponent.getHealth() > 0) {
      System.out.println();
      System.out.println("--- Your turn! ---");
      Scanner input = new Scanner(System.in);
      System.out.print(" [D] Damage/ [R] Run / [H] Heal/ [P] Power-up ");

      String yesNo = input.nextLine().toLowerCase();
      if (yesNo.equals("d")) {
        System.out.println();
        System.out.println(chosenAvatar.getName() + " uses " + chosenAvatar.getAbility() + "!");
        System.out.println();
        System.out.println("Opponent:");
        opponent.takeDamage(chosenAvatar.getAbDmg());
       // System.out.println();
       // System.out.println("--- Opponent's turn! ---");
       // System.out.println(opponent.getName() + " uses " + opponent.getAbility() + "!");
       // System.out.println();
       // System.out.println("You:");
        //chosenAvatar.takeDamage(opponent.getAbDmg());

        OpponentMove(random, opponent, chosenAvatar);      }
      if (yesNo.equals("r")) {
        System.out.println("You ran away.");
        isStart = false;
      }
      if (yesNo.equals("h")) {
        chosenAvatar.gainHealth();
        OpponentMove(random, opponent, chosenAvatar);      }
      else if (yesNo.equals("p")) {
        if (chosenAvatar.getHealth() < 50 && powerUpCooldown) {
           powerUpCooldown = false;
           System.out.println("Dangerous times calls for dangerous measures. Pick a name for your powerup: ");
           String powerUpName = input.nextLine();
           chosenAvatar.customizePowerUp(powerUpName);
          System.out.println(chosenAvatar.getName() + " uses their power-up: " + chosenAvatar.getPowerUpName());
          opponent.takeDamage(chosenAvatar.getPowerUpDamage());
          OpponentMove(random, opponent, chosenAvatar);        }
        else if (!powerUpCooldown) {
          System.out.println("You already used this move!");
        }
        else if (chosenAvatar.getHealth() >= 50) {
          System.out.println("You aren't worthy of this yet...");
        }


       // if (opponent.getHealth() <= 0) {
          //System.out.println(opponent.getName() + " has been defeated!");
         // opponent.deathSound();
          //System.out.println();
          //System.out.println("You won!");
         // isStart = false;
         // break;
        //}


        if (chosenAvatar.getHealth() <= 0) {
          System.out.println(chosenAvatar.getName() + " has been defeated!");
          chosenAvatar.deathSound();
          System.out.println();
          System.out.println("At least you tried!");
          isStart = false;
          break;
        }
      }


    }


  }
}

