package resurces;

public class classFighter extends hero implements actionMeleeAttack, actionRangedAttack {
    public classFighter(String name) {
        this.name = name;

        this.avaiblePoints = 27;
        
        this.strenght = this.dice.nextInt(12, 13 + this.avaiblePoints);
        this.avaiblePoints -= this.strenght;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;

        this.stamina = this.dice.nextInt(12, 13 + this.avaiblePoints);
        avaiblePoints -= this.stamina;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        
        this.dexteny = this.dice.nextInt(8, 9 + this.avaiblePoints);
        avaiblePoints -= this.dexteny;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        
        this.intellect = this.dice.nextInt(4, 5 + this.avaiblePoints);
        avaiblePoints -= this.intellect;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        
        this.charisma = this.dice.nextInt(4, 5 + this.avaiblePoints);
        avaiblePoints -= this.charisma;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        
        this.wisdom = this.dice.nextInt(4, 5 + this.avaiblePoints);
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
        System.out.printf("Персонаж %s наносит урон ближним боем %d\n", this.name, temp );
        return temp; 
    }
    @Override
    public int rangedAttack(hero arg) {
        int temp =  (this.dexteny/4) * this.dice.nextInt(0,7);
        System.out.printf("Персонаж %s наносит урон дальним боем %d\n", this.name, temp );
        return temp; 
    }
}
