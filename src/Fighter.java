public class Fighter extends Avatar {
    private boolean isProtected;


    public Fighter(String name, double health, String ability, String vl, String deathSound){
        this.name = name;
        this.health = health;
        this.type = "Fighter";
        this.ability = ability;
        this.vl = vl;
        this.dm = 1.25;
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
        int increase = (int) (Math.random()*21)+1;
        this.health = health + increase;
        System.out.println("Health is: ");
        System.out.println(health);
    }
}
