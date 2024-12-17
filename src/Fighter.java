public class Fighter extends Avatar {
    Boolean isProtected;


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
        System.out.println(name + " screams" + vl + " as they use their ability " + ability);;
    }

    public void setProtect(Boolean protect) {
        isProtected = protect;
    }

}
