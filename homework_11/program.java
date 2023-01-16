import java.io.IOException;
import resources.Contact;
import resources.UI;
import resources.XMLfileHander;
import resources.HTMLfileHander;
import resources.Storage;
import resources.CSVfileHander;

public class program {
    
    public static void main(String[] args) throws IOException {
        //обработчик ввода-вывода для пользователя
        UI myUI = new UI();
        //обработчик файлов по-умолчанию
        CSVfileHander DB = new CSVfileHander("DataFile.csv");
        //инициализация хранилища, заполняется случайным образом
        Storage myStorage = new Storage(10, DB); 
        //оброботчики для импорта-экспорта
        XMLfileHander fileXML = new XMLfileHander("DataFile.xml");
        HTMLfileHander fileHTML = new HTMLfileHander("DataFile.html");
       

        StringBuilder menu = new StringBuilder();
        Integer userChoice = -1;
        Contact userContact; 
        while (userChoice != 0){
            switch (userChoice) {
                case -1:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("1 - показать существующие контакты\n");
                    menu.append("2 - создать новый контакт\n");
                    menu.append("3 - редактирование существующих контактов\n");
                    menu.append("4 - удаление существующих контактов\n");
                    menu.append("5 - экспорт базы в HTML\n");
                    menu.append("6 - экспорт базы в XML\n");
                    menu.append("7 - импорт базы из HTML\n");
                    menu.append("8 - импорт базы из XML\n");
                    menu.append("0 - Выйти из приложения\n");
                    myUI.userOut(menu.toString());
                    userChoice = myUI.userInputInt("Ваш выбор: ");
                    break;
                case 1:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Существующие контакты в CSV: \n");
                    for (int i = 2; i < DB.Size(); i++) {
                        menu.append(String.format(" %d - %s\n", i - 1, DB.extractData(DB.Read(i)).toString() ));
                    }    
                    myUI.userOut(menu.toString());

                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Существующие контакты в HTML: \n");
                    for (int i = 2; i < fileHTML.Size(); i++) {
                        menu.append(String.format(" %d - %s\n", i - 1, fileHTML.extractData(fileHTML.Read(i)).toString() ));
                    }    
                    myUI.userOut(menu.toString());

                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Существующие контакты в XML: \n");
                    for (int i = 2; i < fileXML.Size(); i++) {
                        menu.append(String.format(" %d - %s\n", i - 1, fileXML.extractData(fileXML.Read(i)).toString() ));
                    }    
                    myUI.userOut(menu.toString());

                    userChoice = -1;
                    break;
                case 2:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Создание нового контакта: \n");
                    userContact = new Contact(myUI.userInputStringAck("Введите название контакта"), 
                                              myUI.userInputStringAck("Введите имя контакта"),
                                              myUI.userInputStringAck("Введите фамилию контакта"),
                                              myUI.userInputIntAck("Введите телефон контакта"),
                                              myUI.userInputStringAck("Введите комментарий к контакту"));
                    DB.Insert(DB.Size() - 1, DB.formData(userContact));
                    userChoice = -1;
                    break;
                case 3:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Выберите контакт для редактирования: \n");
                    for (int i = 2; i < DB.Size(); i++) {
                        menu.append(String.format(" %d - %s\n", i - 1, DB.extractData(DB.Read(i)).toString() ));
                    }
                    menu.append(String.format(" 0 - назад\n"));    
                    myUI.userOut(menu.toString());
                    userChoice = -1;
                    while (userChoice != 0) {
                        userChoice = myUI.userInputInt("Ваш выбор: ");
                        if ((userChoice > 0) && (userChoice < DB.Size())) {
                            menu = new StringBuilder();
                            menu.append("================================================\n");
                            menu.append(String.format("Редактирование контакта %s: \n", DB.Read(userChoice + 1)));
                            myUI.userOut(menu.toString());
                            userContact = new Contact(DB.extractData(DB.Read(userChoice + 1)).getID(), 
                                                      myUI.userInputStringAck("Введите имя контакта"),
                                                      myUI.userInputStringAck("Введите фамилию контакта"),
                                                      myUI.userInputIntAck("Введите телефон контакта"),
                                                      myUI.userInputStringAck("Введите комментарий к контакту"));
                            DB.Edit(userChoice + 1, DB.formData(userContact));
                            userChoice = 0; 
                        }
                    }
                    userChoice = -1;
                    break;
                case 4:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Выберите контакт для удаления: \n");
                    for (int i = 2; i < DB.Size(); i++) {
                        menu.append(String.format(" %d - %s\n", i - 1, DB.extractData(DB.Read(i)).toString() ));
                    }
                    menu.append(String.format(" 0 - назад\n"));    
                    myUI.userOut(menu.toString());
                    userChoice = -1;
                    while (userChoice != 0) {
                        userChoice = myUI.userInputInt("Ваш выбор: ");
                        if ((userChoice > 0) && (userChoice < DB.Size())) {
                            menu = new StringBuilder();
                            menu.append("================================================\n");
                            menu.append(String.format("Удаление контакта %s: \n", DB.Read(userChoice + 1)));
                            myUI.userOut(menu.toString());
                            DB.Delete(userChoice + 1);
                            userChoice = 0; 
                        }
                    }
                    userChoice = -1;
                    break;

                case 5:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Экспорт данных в HTML \n");    
                    myUI.userOut(menu.toString());
                    //копирование данных
                    fileHTML.Copy(DB);

                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Экспорт данных в HTML завершён \n");    
                    myUI.userOut(menu.toString());

                    userChoice = -1;
                    break;

                case 6:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Экспорт данных в XML \n");    
                    myUI.userOut(menu.toString());
                    //копирование данных
                    fileXML.Copy(DB);

                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Экспорт данных в XML завершён \n");    
                    myUI.userOut(menu.toString());

                    userChoice = -1;
                    break;
                case 7:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Импорт данных из HTML \n");    
                    myUI.userOut(menu.toString());
                    //копирование данных
                    DB.Copy(fileHTML);

                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Импорт данных из HTML завершён \n");    
                    myUI.userOut(menu.toString());

                    userChoice = -1;
                    break;
                case 8:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Импорт данных из XML \n");    
                    myUI.userOut(menu.toString());
                    //копирование данных
                    DB.Copy(fileXML);

                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Импорт данных из XML завершён \n");    
                    myUI.userOut(menu.toString());

                    userChoice = -1;
                    break;
            }
        }
    }
}
