public class Fighter extends Avatar {
    private boolean isProtected;


    public Fighter(String name, double health, String ability, String vl, String deathSound){
        this.name = name;
        this.health = health;
        this.type = "fighter";
        this.ability = ability;
        this.vl = vl;
        this.dm = 1.40;
        this.rm = .9;
        isProtected = false;
        this.deathSound = deathSound;
    }

    public void voiceLine(){
        System.out.println("I am protected by my shield \n" + vl) ;
    }
    public void deathSound(){ System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA \n " + deathSound);

    }

    public void setProtect(Boolean protect) {
        isProtected = protect;
    }

    public void gainResistance(){
        int decrease = (int) (Math.random()*21)+1;
        this.rm = this.rm - (int) (Math.random()/4);
        this.health = health - decrease;
    }
    public void gainHealth(){
        int increase = (int) (Math.random()*20)+5;
        this.health = health + increase;
        System.out.println("I salute you Fighter.... you healed yourself! " + "You now have " + health + " health!");

    }
    @Override
    public void damageBuff(){
        int randomEvent = (int) (Math.random()*4) + 1;
        int buff = (int) (Math.random()*30)+ 15;
        int nerf = (int) (Math.random()*95)+ 35;
        this.abDmg = this.abDmg + buff;

        if (health <= nerf) {
            System.out.println("You do not have enough HP to use this ability. You are now at " + health + " HP!");

        }
        else if ( health > nerf) {
            System.out.println("you buffed your damage! Your damage is increased by  " + buff + " points!" + " Your damage is now " + abDmg + "!");
            System.out.println(name + " uses " + ability + "!");
            this.health = health - nerf;
            System.out.println("You lost " + nerf + " HP!");
            System.out.println("Your HP is now: ");
            System.out.println(health);

        }

        if (abDmg > 80 && randomEvent > 2) {
            System.out.println("you buffed your damage! Your damage is increased by  " + buff + " points!" + " Your damage is now " + abDmg + "!");
            System.out.println("You've grown too strong. It looks like I'll have to kill you myself...");
            this.health = 0;
            System.exit(0);
        }
    }
}
