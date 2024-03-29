import java.io.IOException;

import resources.CSVfileHander;
import resources.HTMLfileHander;
import resources.Initilizer;
import resources.UI;
import resources.XMLfileHander;
import resources.Logic;

public class program {
    
    public static void main(String[] args) throws IOException {
        //обработчик ввода-вывода для пользователя
        UI ui = new UI();
        //обработчик файлов по-умолчанию
        HTMLfileHander db = new HTMLfileHander("DataFile.html");
        //оброботчики для импорта-экспорта
        CSVfileHander backUp1 = new CSVfileHander("DataFile.csv");
        XMLfileHander backUp2 = new XMLfileHander("DataFile.xml");
        //инициализация хранилища, заполняется случайным образом
        Initilizer.InitDB(10, db); 
        //логика работы через меню
        Logic.Contoller(ui, db, backUp1, backUp2);

    }
}
