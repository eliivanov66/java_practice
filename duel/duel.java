package java_practice.duel;
import java.util.Random;

public class logic {

    public static void main(String[] args) {
        Random rand = new Random();
        boolean phase = rand.nextBoolean();
        boolean gameOver = false;
        classFighter Player1 = new classFighter("Fighter");
        classRogue Player2 = new classRogue("Rogue");
        classCleric Player3 = new classCleric("Cleric");

        while (! gameOver) {
            if (phase) {
                if (Player1 != null) {
                    Player2.defence(Player2, Player1.meleeAttack(Player1));
                }
                else {
                    gameOver = true;
                }
                phase = false;
            }
            else {
                if (Player2 != null) {
                    Player1.defence(Player1, Player2.rangedAttack(Player2));
                }
                else {
                    gameOver = true;
                }
                phase = true;
            }
        }
    }
}

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

public class classFighter extends hero implements actionMeleeAttack, actionRangedAttack {
    public classFighter(String name) {
        this.name = name;

        this.avaiblePoints = 22;
        
        this.strenght = dice.nextInt(12, 12 + this.avaiblePoints);
        this.avaiblePoints -= this.strenght;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;

        this.stamina = dice.nextInt(12, 12 + this.avaiblePoints);
        avaiblePoints -= this.stamina;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        
        this.dexteny = dice.nextInt(8, 8 + this.avaiblePoints);
        avaiblePoints -= this.dexteny;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        
        this.intellect = dice.nextInt(4, 4 + this.avaiblePoints);
        avaiblePoints -= this.intellect;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        
        this.charisma = dice.nextInt(4, 4 + this.avaiblePoints);
        avaiblePoints -= this.charisma;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        
        this.wisdom = dice.nextInt(4, 4 + this.avaiblePoints);
        avaiblePoints -= this.wisdom;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;

        hpForm();
        mpForm();
        this.maxHP = this.HP;
    }

    @Override
    void hpForm() {
        this.HP = (int) (this.stamina * 2.0);
    }
    @Override
    void mpForm() {
        this.MP = (int) (this.wisdom * 1.0);   
    }

    @Override
    public int meleeAttack(hero arg) {
        int temp = (this.strenght/4) * this.dice.nextInt(0,7);
        System.out.printf("Персонаж %s наносит урон ближним боем %d", this.name, temp );
        return temp; 
    }
    @Override
    public int rangedAttack(hero arg) {
        int temp =  (this.dexteny/4) * this.dice.nextInt(0,7);
        System.out.printf("Персонаж %s наносит урон дальним боем %d", this.name, temp );
        return temp; 
    }
}

public class classRogue extends hero implements actionMeleeAttack, actionRangedAttack {
    public classRogue(String name) {
        this.name = name;
        
        this.avaiblePoints = 22;
        
        this.stamina = dice.nextInt(12, 12 + this.avaiblePoints);
        avaiblePoints -= this.stamina;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        
        this.dexteny = dice.nextInt(12, 12 + this.avaiblePoints);
        avaiblePoints -= this.dexteny;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;

        this.strenght = dice.nextInt(8, 8 + this.avaiblePoints);
        this.avaiblePoints -= this.strenght;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        
        this.intellect = dice.nextInt(4, 4 + this.avaiblePoints);
        avaiblePoints -= this.intellect;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        
        this.charisma = dice.nextInt(4, 4 + this.avaiblePoints);
        avaiblePoints -= this.charisma;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        
        this.wisdom = dice.nextInt(4, 4 + this.avaiblePoints);
        avaiblePoints -= this.wisdom;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;

        hpForm();
        mpForm();
    }

    @Override
    void hpForm() {
        this.HP = (int) (this.stamina * 1.5);
    }
    @Override
    void mpForm() {
        this.MP = (int) (this.wisdom * 1.0);   
    }

    @Override
    public int meleeAttack(hero arg) {
        int temp = (this.strenght/4) * this.dice.nextInt(0,7);
        System.out.printf("Персонаж %s наносит урон ближним боем %d", this.name, temp );
        return temp; 
    }
    @Override
    public int rangedAttack(hero arg) {
        int temp =  (this.dexteny/4) * this.dice.nextInt(0,7);
        System.out.printf("Персонаж %s наносит урон дальним боем %d", this.name, temp );
        return temp; 
    }
}

public class classMage extends hero implements actionMeleeAttack, actionMagicAttack {
    public classMage(String name) {
        this.name = name;

        this.avaiblePoints = 22;
        
        this.intellect = dice.nextInt(12, 12 + this.avaiblePoints);
        avaiblePoints -= this.intellect;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;

        this.wisdom = dice.nextInt(12, 12 + this.avaiblePoints);
        avaiblePoints -= this.wisdom;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        
        this.charisma = dice.nextInt(8, 4 + this.avaiblePoints);
        avaiblePoints -= this.charisma;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;

        this.strenght = dice.nextInt(4, 4 + this.avaiblePoints);
        this.avaiblePoints -= this.strenght;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;

        this.stamina = dice.nextInt(4, 4 + this.avaiblePoints);
        avaiblePoints -= this.stamina;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        
        this.dexteny = dice.nextInt(4, 4 + this.avaiblePoints);
        avaiblePoints -= this.dexteny;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        


        hpForm();
        mpForm();
    }

    @Override
    void hpForm() {
        this.HP = (int) (this.stamina * 1.0);
    }
    @Override
    void mpForm() {
        this.MP = (int) (this.wisdom * 2.0);   
    }

    @Override
    public int meleeAttack(hero arg) {
        int temp = (this.strenght/4) * this.dice.nextInt(0,7);
        System.out.printf("Персонаж %s наносит урон ближним боем %d", this.name, temp );
        return temp; 
    }

    @Override
    public int magicAttack(hero arg) {
        int temp = (this.intellect/4) * this.dice.nextInt(0,7); 
        System.out.printf("Персонаж %s наносит магией %d", this.name, temp );
        return temp; 
    }
}

public class classCleric extends hero implements actionMeleeAttack, actionMagicAttack, actionHeal {
    public classCleric(String name) {
        this.name = name;

        this.avaiblePoints = 22;
        
        this.charisma = dice.nextInt(12, 12 + this.avaiblePoints);
        avaiblePoints -= this.charisma;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        
        this.wisdom = dice.nextInt(12, 12 + this.avaiblePoints);
        avaiblePoints -= this.wisdom;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;

        this.intellect = dice.nextInt(8, 8 + this.avaiblePoints);
        avaiblePoints -= this.intellect;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;

        this.strenght = dice.nextInt(4, 4 + this.avaiblePoints);
        this.avaiblePoints -= this.strenght;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;

        this.stamina = dice.nextInt(4, 4 + this.avaiblePoints);
        avaiblePoints -= this.stamina;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        
        this.dexteny = dice.nextInt(4, 4 + this.avaiblePoints);
        avaiblePoints -= this.dexteny;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;

        hpForm();
        mpForm();
    }

    @Override
    void hpForm() {
        this.HP = (int) (this.stamina * 1.5);
    }
    @Override
    void mpForm() {
        this.MP = (int) (this.wisdom * 1.5);   
    }

    @Override
    public int meleeAttack(hero arg) {
        int temp = (this.strenght/4) * this.dice.nextInt(0,7);
        System.out.printf("Персонаж %s наносит урон ближним боем %d", this.name, temp );
        return temp; 
    }

    @Override
    public int magicAttack(hero arg) {
        int temp = (this.intellect/4) * this.dice.nextInt(0,7); 
        System.out.printf("Персонаж %s наносит магией %d", this.name, temp );
        return temp; 
    }

    @Override
    public int heal(hero arg) {
        int temp =  (this.charisma/4) * this.dice.nextInt(0,7);
        System.out.printf("Персонаж %s исцеляет магией %d", this.name, temp );
        return temp;  
    }
}

public interface actionDefence {
    abstract void defence(hero arg, int value);
}

public interface actionDying {
    abstract void dying(hero arg);
}

public interface actionHeal {
    abstract int heal(hero arg);
}

public interface actionHealing {
    abstract void healing(hero arg, int value);
}

public interface actionMagicAttack {
    abstract int magicAttack(hero arg);
}

public interface actionMeleeAttack {
    abstract int meleeAttack(hero arg);
}

public interface actionRangedAttack {
    abstract int rangedAttack(hero arg);
}