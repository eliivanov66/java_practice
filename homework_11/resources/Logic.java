package resources;

import java.io.IOException;

public class Logic {
    public static void Contoller(UI argUI, BaseFileHandler argDB, BaseFileHandler argBackUp1, BaseFileHandler argBackUp2) throws IOException {
        StringBuilder menu = new StringBuilder();
        Integer userChoice = -1;
        while (userChoice != 0){
            switch (userChoice) {
                case -1:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append(String.format("1 - показать существующие контакты в %sе \n", argDB.Info()));
                    menu.append("2 - создать новый контакт\n");
                    menu.append("3 - редактирование существующих контактов\n");
                    menu.append("4 - удаление существующих контактов\n");
                    menu.append(String.format("5 - экспорт базы в %s \n", argBackUp1.Info()));
                    menu.append(String.format("6 - экспорт базы в %s \n", argBackUp2.Info()));
                    menu.append(String.format("7 - импорт базы из %sа \n", argBackUp1.Info()));
                    menu.append(String.format("8 - импорт базы из %sа \n", argBackUp2.Info()));
                    menu.append("0 - Выйти из приложения\n");
                    argUI.userOut(menu.toString());
                    userChoice = argUI.userInputInt("Ваш выбор: ");
                    break;
                case 1:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append(String.format("Существующие контакты в %sе: \n", argDB.Info()));
                    for (int i = 2; i < argDB.Size(); i++) {
                        menu.append(String.format(" %d - %s\n", i - 1, argDB.extractData(argDB.Read(i)).toString() ));
                    }    
                    argUI.userOut(menu.toString());
                    userChoice = -1;
                    break;
                case 2:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Создание нового контакта: \n");
                    Contact userContact = new Contact(argUI.userInputStringAck("Введите название контакта"), 
                                              argUI.userInputStringAck("Введите имя контакта"),
                                              argUI.userInputStringAck("Введите фамилию контакта"),
                                              argUI.userInputIntAck("Введите телефон контакта"),
                                              argUI.userInputStringAck("Введите комментарий к контакту"));
                    argDB.Insert(argDB.Size() - 1, argDB.formData(userContact));
                    userChoice = -1;
                    break;
                case 3:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Выберите контакт для редактирования: \n");
                    for (int i = 2; i < argDB.Size(); i++) {
                        menu.append(String.format(" %d - %s\n", i - 1, argDB.extractData(argDB.Read(i)).toString() ));
                    }
                    menu.append(String.format(" 0 - назад\n"));    
                    argUI.userOut(menu.toString());
                    userChoice = -1;
                    while (userChoice != 0) {
                        userChoice = argUI.userInputInt("Ваш выбор: ");
                        if ((userChoice > 0) && (userChoice < argDB.Size() - 1)) {
                            menu = new StringBuilder();
                            menu.append("================================================\n");
                            menu.append(String.format("Редактирование контакта %s: \n", argDB.Read(userChoice + 1)));
                            argUI.userOut(menu.toString());
                            userContact = new Contact(argDB.extractData(argDB.Read(userChoice + 1)).getID(), 
                                                      argUI.userInputStringAck("Введите имя контакта"),
                                                      argUI.userInputStringAck("Введите фамилию контакта"),
                                                      argUI.userInputIntAck("Введите телефон контакта"),
                                                      argUI.userInputStringAck("Введите комментарий к контакту"));
                            argDB.Edit(userChoice + 1, argDB.formData(userContact));
                            userChoice = 0; 
                        }
                    }
                    userChoice = -1;
                    break;
                case 4:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Выберите контакт для удаления: \n");
                    for (int i = 2; i < argDB.Size(); i++) {
                        menu.append(String.format(" %d - %s\n", i - 1, argDB.extractData(argDB.Read(i)).toString() ));
                    }
                    menu.append(String.format(" 0 - назад\n"));    
                    argUI.userOut(menu.toString());
                    userChoice = -1;
                    while (userChoice != 0) {
                        userChoice = argUI.userInputInt("Ваш выбор: ");
                        if ((userChoice > 0) && (userChoice < argDB.Size() - 1)) {
                            menu = new StringBuilder();
                            menu.append("================================================\n");
                            menu.append(String.format("Удаление контакта %s: \n", argDB.Read(userChoice + 1)));
                            argUI.userOut(menu.toString());
                            argDB.Delete(userChoice + 1);
                            userChoice = 0; 
                        }
                    }
                    userChoice = -1;
                    break;

                case 5:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append(String.format("Экспорт данных в %s \n", argBackUp1.Info()));    
                    argUI.userOut(menu.toString());
                    //копирование данных
                    argBackUp1.Copy(argDB);

                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append(String.format("Экспорт данных в %s завершён\n", argBackUp1.Info()));     
                    argUI.userOut(menu.toString());

                    userChoice = -1;
                    break;

                case 6:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append(String.format("Экспорт данных в %s \n", argBackUp2.Info()));    
                    argUI.userOut(menu.toString());
                    //копирование данных
                    argBackUp2.Copy(argDB);

                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append(String.format("Экспорт данных в %s завершён\n", argBackUp2.Info()));     
                    argUI.userOut(menu.toString());

                    userChoice = -1;
                    break;
                case 7:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append(String.format("Импорт данных из %sа \n", argBackUp1.Info()));    
                    argUI.userOut(menu.toString());
                    //копирование данных
                    argDB.Copy(argBackUp1);

                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append(String.format("Импорт данных из %sа завершён\n", argBackUp1.Info()));     
                    argUI.userOut(menu.toString());

                    userChoice = -1;
                    break;
                case 8:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append(String.format("Импорт данных из %sа \n", argBackUp2.Info()));    
                    argUI.userOut(menu.toString());
                    //копирование данных
                    argDB.Copy(argBackUp2);

                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append(String.format("Импорт данных из %sа завершён\n", argBackUp2.Info()));     
                    argUI.userOut(menu.toString());

                    userChoice = -1;
                    break;
            }
        }
    }
}
