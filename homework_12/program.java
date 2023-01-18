import java.io.IOException;
import resources.GameData;
import resources.Logic;
import resources.SAVEfileHander;
import resources.UI;

public class program {
    
    public static void main(String[] args) throws IOException {
        //обработчик ввода-вывода
        UI gameUI = new UI();
        //обработчик файлов
        SAVEfileHander gameSave = new SAVEfileHander("GameSave.save");
        //инициализация данных
        GameData gameData;
        if ((gameSave.Size() == 0) || (gameSave.Size() > 1)) {
            //создание новых данных
            gameSave.Clear();
            gameData = new GameData();
            //сохранение их навсякий случай
            gameSave.Write(gameSave.formData(gameData));
        } else {
            //чтение данных из файла
            gameData = gameSave.extractData(gameSave.Read(1));
            //реинициализация и сохранение данных
            if (gameData.getCandyCount() <= 0) gameData.Reinit(); gameSave.Edit(1, gameSave.formData(gameData));
        }
        //обработчик логики игры
        Logic.gameLogic(gameData, gameUI, gameSave);

    }
}
