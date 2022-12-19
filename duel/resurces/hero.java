package resurces;
import java.util.Random;

public abstract class hero implements actionDefence, actionDying, actionHealing{
    String name; //имя персонажа
    int HP; //количество жизней 
    int MP; //количество маны
    int maxHP; //максимальное количество жизней
    int strenght; //от него зависит урон в рукопашной
    int stamina;  //от него зависит количество HP
    int dexteny;  //от него зависит урон в дистанции
    int intellect; //от него зависит урон от магии
    int charisma; //от него зависит лечение
    int wisdom; //от него зависит количество MP
    int level; //уровень персонажа
    int XP; //опыт
    boolean isDead = false;
    Random dice = new Random();
    int avaiblePoints = 21;
    public hero(String argName, int HP, int MP){
        this.level = 1;
        this.name = argName;
        this.HP = HP;
        this.MP = MP;
        this.XP = 0;
        this.maxHP = this.HP;
    }
    public hero(){
        this("герой", 10, 5);
    }

    abstract void hpForm();
    abstract void mpForm();

    @Override
    public void defence(hero arg, int value) {
        arg.HP -= value;
        System.out.printf("Персонаж %s получает урон %d\n", this.name, value);
        info();
        if (arg.HP <=0) {
            dying(this);
        }
    }

    @Override
    public void dying(hero arg) {
        System.out.printf("Персонаж %s умирает\n", this.name);
        isDead = true;;
    }
    
    @Override
    public void healing(hero arg, int value) {
        arg.HP += value;
        if (arg.HP > arg.maxHP) arg.HP = arg.maxHP;
        System.out.printf("Персонаж %s получает лечение %d\n", this.name, value);
        info();
    }

    public void info(){
        System.out.printf("Персонаж %s состояние %d/%d \n", this.name, this.HP, this.maxHP);
    }

    public boolean dead(){
        return this.isDead;
    }
}