package resources;

import java.io.IOException;

public class SAVEfileHander extends BaseFileHandler{

    public SAVEfileHander(String argFilePath) throws IOException {
        super(argFilePath);
    }
    
    public String formData(GameData argIn){
        StringBuilder data = new StringBuilder();
        data.append(String.format("%d;", argIn.getCandyCount())); //0
        data.append(String.format("%d;", argIn.getHumanCount())); //1
        data.append(String.format("%d;", argIn.getHumanChoise())); //2
        data.append(String.format("%d;", argIn.getAiCount())); //3
        data.append(String.format("%d;", argIn.getAiChoise())); //4
        data.append(String.format("%d;", argIn.getMinChoise())); //5
        data.append(String.format("%d;", argIn.getMaxChoise())); //6
        data.append(String.format("%d;", argIn.getMove())); //7
        return data.toString();
    }

    public GameData extractData(String argIn){

        String[] tempIn = argIn.split(";");     
        int[] valuesIn = new int[tempIn.length];
        for (int i = 0; i < tempIn.length; i++) {
            valuesIn[i] = Integer.valueOf(tempIn[i]); 
        }

        GameData data = new GameData(valuesIn[0], valuesIn[1], valuesIn[2], valuesIn[3], valuesIn[4],valuesIn[5],valuesIn[6],valuesIn[7]);
        return data;
    }
}
