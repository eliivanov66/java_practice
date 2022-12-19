package resurces;

public class classCleric extends hero implements actionMeleeAttack, actionMagicAttack, actionHeal {
    public classCleric(String name) {
        this.name = name;

        this.avaiblePoints = 22;
        
        this.charisma = this.dice.nextInt(12, 13 + this.avaiblePoints);
        avaiblePoints -= this.charisma;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        
        this.wisdom = this.dice.nextInt(12, 13 + this.avaiblePoints);
        avaiblePoints -= this.wisdom;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;

        this.intellect = this.dice.nextInt(8, 9 + this.avaiblePoints);
        avaiblePoints -= this.intellect;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;

        this.strenght = this.dice.nextInt(4, 5 + this.avaiblePoints);
        this.avaiblePoints -= this.strenght;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;

        this.stamina = this.dice.nextInt(4, 5 + this.avaiblePoints);
        avaiblePoints -= this.stamina;
        if (this.avaiblePoints<0) this.avaiblePoints = 0;
        
        this.dexteny = this.dice.nextInt(4, 5 + this.avaiblePoints);
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
        System.out.printf("Персонаж %s наносит урон ближним боем %d\n", this.name, temp );
        return temp; 
    }

    @Override
    public int magicAttack(hero arg) {
        int temp = (this.intellect/4) * this.dice.nextInt(0,7); 
        System.out.printf("Персонаж %s наносит магией %d\n", this.name, temp );
        return temp; 
    }

    @Override
    public int heal(hero arg) {
        int temp =  (this.charisma/4) * this.dice.nextInt(0,7);
        System.out.printf("Персонаж %s исцеляет магией %d\n", this.name, temp );
        return temp;  
    }
}

