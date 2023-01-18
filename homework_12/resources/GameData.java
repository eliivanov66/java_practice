package resources;

import java.util.Random;

public class GameData {
    private int candyCount;
    private int humanCount;
    private int humanChoise;
    private int aiCount;
    private int aiChoise;
    private int minChoise;
    private int maxChoise;
    private int move;

    public GameData(
        int argCandyCount,
        int argHumanCount,
        int argHumanChoise,
        int argAiCount,
        int argAiChoise,
        int argMinChoise,
        int argMaxChoise,
        int argMove){
        
        this.candyCount = argCandyCount;
        this.humanCount = argHumanCount;
        this.humanChoise = argHumanChoise;
        this.aiCount = argAiCount;
        this.aiChoise = argAiChoise;
        this.minChoise = argMinChoise;
        this.maxChoise = argMaxChoise; 
        this.move = argMove;
    }

    public GameData(){
        Reinit();
    }

    public void Reinit(){
        Random rand = new Random();
        this.candyCount = rand.nextInt(100,200);
        this.humanCount = 0;
        this.humanChoise = 0;
        this.aiCount = 0;
        this.aiChoise = 0;
        this.minChoise = 1;
        this.maxChoise = 28; 
        this.move = rand.nextInt(0, 1);
    }

    public void generateAIchoise(){
        if ((this.candyCount - this.maxChoise) >= this.maxChoise) {
            this.aiChoise = this.maxChoise;
        }  else {
            this.aiChoise = this.minChoise;
        }
        if (this.candyCount < this.maxChoise) {
            this.aiChoise = this.candyCount;
        }
    }

    public int getCandyCount(){ 
        return this.candyCount;
    }
    public int getHumanCount(){ 
        return this.humanCount;
    }
    public int getHumanChoise(){ 
        return this.humanChoise;
    }
    public int getAiCount(){ 
        return this.aiCount;
    }
    public int getAiChoise(){ 
        return this.aiChoise;
    }
    public int getMinChoise(){ 
        return this.minChoise;
    }
    public int getMaxChoise(){ 
        return this.maxChoise;
    }
    public int getMove(){ 
        return this.move;
    }


    public void setMove(int argIn){
        this.move = argIn;
    }

    public void setCandyCount(int argIn){ 
        this.candyCount = argIn;
    }
    public void setHumanCount(int argIn){ 
        this.humanCount = argIn;
    }
    public void setHumanChoise(int argIn){ 
        this.humanChoise = argIn;
    }
    public void setAiCount(int argIn){ 
        this.aiCount = argIn;
    }

}
