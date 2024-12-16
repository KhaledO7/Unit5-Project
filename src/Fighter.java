public class Fighter extends Avatar {


    public Fighter(String name, double health){
        this.name = name;
        this.health = health;
        this.type = "Fighter";
        this.ability = "Charge";
        this.vl = "AHHHHH!";
        this.dm = 1.25;
        this.rm = 0.75;
    }

    public void gainResistance(){
        int decrease = (int) (Math.random()*11)+1;
        this.rm = this.rm - (int) (Math.random()/4);
        this.health = health - decrease; 
    }
}
