package java_practice.duel;

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
