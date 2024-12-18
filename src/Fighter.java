public class Fighter extends Avatar {
    private boolean isProtected;


    public Fighter(String name, double health, String ability, String vl){
        this.name = name;
        this.health = health;
        this.type = "Fighter";
        this.ability = ability;
        this.vl = vl;
        this.dm = 1.25;
        this.rm = .9;
        isProtected = false;
    }

    public void voiceLine(){
        System.out.println("I am shielded");
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
    }
}
