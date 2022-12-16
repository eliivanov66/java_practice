package java_practice.duel;
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
    Random dice = new Random();
    int avaiblePoints = 21;
    public hero(String argName, int HP, int MP){
        this.level = 1;
        this.name = argName;
        this.HP = HP;
        this.MP = MP;
        this.XP = 0;
    }
    public hero(){
        this("герой", 10, 5);
    }

    abstract void hpForm();
    abstract void mpForm();

    @Override
    public void defence(hero arg, int value) {
        arg.HP -= value;
        System.out.printf("Персонаж %s получает урон %d", this.name, value);
        if (arg.HP <=0) {
            dying(this);
        }
    }

    @Override
    public void dying(hero arg) {
        System.out.printf("Персонаж %s умирает", this.name);
        arg = null;
    }
    
    @Override
    public void healing(hero arg, int value) {
        arg.HP += value;
        System.out.printf("Персонаж %s получает лечение %d", this.name, value);
        if (arg.HP > arg.maxHP) arg.HP = arg.maxHP;
    }

    public void info(){
        System.out.printf("Персонаж %s состояние %d/%d", this.name, this.HP, this.maxHP);
    }
}