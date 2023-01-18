package resources;

import java.io.IOException;

public class Logic {
    public static void gameLogic(GameData argGame, UI argUI, BaseFileHandler argStorage) throws IOException{
        
        StringBuilder out = new StringBuilder();
            
        while (argGame.getCandyCount() > 0) {
            if (argGame.getMove() == 1) {
                out = new StringBuilder();
                out.append(String.format("===========================================\n"));
                out.append(String.format("На столе находится %d конфеты\n", argGame.getCandyCount()));
                out.append(String.format("У Вас %d конфеты \n", argGame.getHumanCount()));
                out.append(String.format("У компьютера %d конфеты \n", argGame.getAiCount()));
                argGame.generateAIchoise();
                out.append(String.format("Ход компьютера, компьютер взял со стола %d конфеты\n", argGame.getAiChoise()));
                argGame.setCandyCount(argGame.getCandyCount() - argGame.getAiChoise());
                argGame.setAiCount(argGame.getAiCount() + argGame.getAiChoise());
                out.append(String.format("У вас %d конфеты \n", argGame.getHumanCount()));
                out.append(String.format("У компьютера %d конфеты \n", argGame.getAiCount()));
                argGame.setMove(0);
                argUI.userOut(out.toString());
                //сохранение данных
                argStorage.Edit(1, argStorage.formData(argGame));
            }
            else {
                out = new StringBuilder();
                out.append(String.format("===========================================\n"));
                out.append(String.format("На столе находится %d конфеты\n", argGame.getCandyCount()));
                out.append(String.format("У Вас %d конфеты \n", argGame.getHumanCount()));
                out.append(String.format("У компьютера %d конфеты \n", argGame.getAiCount()));
                argUI.userOut(out.toString());

                int tempMaxCount;
                if (argGame.getCandyCount() > argGame.getMaxChoise()) {
                    tempMaxCount = argGame.getMaxChoise();
                } else {
                    tempMaxCount = argGame.getCandyCount();
                }
                //сохранение данных
                argStorage.Edit(1, argStorage.formData(argGame));
                
                out = new StringBuilder();
                argGame.setHumanChoise(argUI.userInputInt("Ваш ход, Вы хотите взять со стола: ", argGame.getMinChoise(), tempMaxCount));
                argGame.setCandyCount(argGame.getCandyCount() - argGame.getHumanChoise());
                argGame.setHumanCount(argGame.getHumanCount() + argGame.getHumanChoise());
                
                out.append(String.format("У Вас %d конфеты \n", argGame.getHumanCount()));
                out.append(String.format("У компьютера %d конфеты \n", argGame.getAiCount()));

                argGame.setMove(1);
                argUI.userOut(out.toString());
                
                //сохранение данных
                argStorage.Edit(1, argStorage.formData(argGame));
            }

            if (argGame.getCandyCount() <= 0) {
                out = new StringBuilder();
                out.append(String.format("===========================================\n"));
                if (argGame.getMove() == 0) {
                    out.append(String.format("ВЫ ПРОИГРАЛИ, Компьютер последним взял конфеты и победил\n"));
                } else {
                    out.append(String.format("ВЫ ПОБЕДИЛИ, Вы последним взяли конфеты со стола\n"));
                }
                argUI.userOut(out.toString());
            }
        }
    }
}
