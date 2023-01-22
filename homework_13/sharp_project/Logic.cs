using System.Text;

public class Logic {
    public static void Contoller(UI argUI, BaseFileHandler argDB, BaseFileHandler argBackUp1, BaseFileHandler argBackUp2) {
        StringBuilder menu = new StringBuilder();
        int userChoice = -1;
        while (userChoice != 0){
            switch (userChoice) {
                case -1:
                    menu = new StringBuilder();
                    menu.Append("================================================\n");
                    menu.Append(String.Format("1 - показать существующие контакты в {0}е \n", argDB.Info()));
                    menu.Append("2 - создать новый контакт\n");
                    menu.Append("3 - редактирование существующих контактов\n");
                    menu.Append("4 - удаление существующих контактов\n");
                    menu.Append(String.Format("5 - экспорт базы в {0} \n", argBackUp1.Info()));
                    menu.Append(String.Format("6 - экспорт базы в {0} \n", argBackUp2.Info()));
                    menu.Append(String.Format("7 - импорт базы из {0}а \n", argBackUp1.Info()));
                    menu.Append(String.Format("8 - импорт базы из {0}а \n", argBackUp2.Info()));
                    menu.Append("0 - Выйти из приложения\n");
                    argUI.userOut(menu.ToString());
                    userChoice = argUI.userInputInt("Ваш выбор: ");
                    break;
                case 1:
                    menu = new StringBuilder();
                    menu.Append("================================================\n");
                    menu.Append(String.Format("Существующие контакты в {0}е: \n", argDB.Info()));
                    for (int i = 2; i < argDB.Size(); i++) {
                        menu.Append(String.Format(" {0} - {1}\n", i - 1, argDB.extractData(argDB.Read(i)).toString()));
                    }    
                    argUI.userOut(menu.ToString());
                    userChoice = -1;
                    break;
                case 2:
                    menu = new StringBuilder();
                    menu.Append("================================================\n");
                    menu.Append("Создание нового контакта: \n");
                    Contact userContact = new Contact(argUI.userInputStringAck("Введите название контакта"), 
                                              argUI.userInputStringAck("Введите имя контакта"),
                                              argUI.userInputStringAck("Введите фамилию контакта"),
                                              argUI.userInputIntAck("Введите телефон контакта"),
                                              argUI.userInputStringAck("Введите комментарий к контакту"));
                    argDB.Insert(argDB.Size(), argDB.formData(userContact));
                    userChoice = -1;
                    break;
                case 3:
                    menu = new StringBuilder();
                    menu.Append("================================================\n");
                    menu.Append("Выберите контакт для редактирования: \n");
                    for (int i = 2; i < argDB.Size(); i++) {
                        menu.Append(String.Format(" {0} - {1}\n", i - 1, argDB.extractData(argDB.Read(i)).toString() ));
                    }
                    menu.Append(String.Format(" 0 - назад\n"));    
                    argUI.userOut(menu.ToString());
                    userChoice = -1;
                    while (userChoice != 0) {
                        userChoice = argUI.userInputInt("Ваш выбор: ");
                        if ((userChoice > 0) && (userChoice < argDB.Size() - 1)) {
                            menu = new StringBuilder();
                            menu.Append("================================================\n");
                            menu.Append(String.Format("Редактирование контакта {0}: \n", argDB.Read(userChoice + 1)));
                            argUI.userOut(menu.ToString());
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
                    menu.Append("================================================\n");
                    menu.Append("Выберите контакт для удаления: \n");
                    for (int i = 2; i < argDB.Size(); i++) {
                        menu.Append(String.Format(" {0} - {1}\n", i - 1, argDB.extractData(argDB.Read(i)).toString() ));
                    }
                    menu.Append(String.Format(" 0 - назад\n"));    
                    argUI.userOut(menu.ToString());
                    userChoice = -1;
                    while (userChoice != 0) {
                        userChoice = argUI.userInputInt("Ваш выбор: ");
                        if ((userChoice > 0) && (userChoice < argDB.Size() - 1)) {
                            menu = new StringBuilder();
                            menu.Append("================================================\n");
                            menu.Append(String.Format("Удаление контакта {0}: \n", argDB.Read(userChoice + 1)));
                            argUI.userOut(menu.ToString());
                            argDB.Delete(userChoice + 1);
                            userChoice = 0; 
                        }
                    }
                    userChoice = -1;
                    break;

                case 5:
                    menu = new StringBuilder();
                    menu.Append("================================================\n");
                    menu.Append(String.Format("Экспорт данных в {0} \n", argBackUp1.Info()));    
                    argUI.userOut(menu.ToString());
                    //копирование данных
                    argBackUp1.Copy(argDB);

                    menu = new StringBuilder();
                    menu.Append("================================================\n");
                    menu.Append(String.Format("Экспорт данных в {0} завершён\n", argBackUp1.Info()));     
                    argUI.userOut(menu.ToString());

                    userChoice = -1;
                    break;

                case 6:
                    menu = new StringBuilder();
                    menu.Append("================================================\n");
                    menu.Append(String.Format("Экспорт данных в {0} \n", argBackUp2.Info()));    
                    argUI.userOut(menu.ToString());
                    //копирование данных
                    argBackUp2.Copy(argDB);

                    menu = new StringBuilder();
                    menu.Append("================================================\n");
                    menu.Append(String.Format("Экспорт данных в {0} завершён\n", argBackUp2.Info()));     
                    argUI.userOut(menu.ToString());

                    userChoice = -1;
                    break;
                case 7:
                    menu = new StringBuilder();
                    menu.Append("================================================\n");
                    menu.Append(String.Format("Импорт данных из {0}а \n", argBackUp1.Info()));    
                    argUI.userOut(menu.ToString());
                    //копирование данных
                    argDB.Copy(argBackUp1);

                    menu = new StringBuilder();
                    menu.Append("================================================\n");
                    menu.Append(String.Format("Импорт данных из {0}а завершён\n", argBackUp1.Info()));     
                    argUI.userOut(menu.ToString());

                    userChoice = -1;
                    break;
                case 8:
                    menu = new StringBuilder();
                    menu.Append("================================================\n");
                    menu.Append(String.Format("Импорт данных из {0}а \n", argBackUp2.Info()));    
                    argUI.userOut(menu.ToString());
                    //копирование данных
                    argDB.Copy(argBackUp2);

                    menu = new StringBuilder();
                    menu.Append("================================================\n");
                    menu.Append(String.Format("Импорт данных из {0}а завершён\n", argBackUp2.Info()));     
                    argUI.userOut(menu.ToString());

                    userChoice = -1;
                    break;
                default:
                    userChoice = -1;
                    break;
            }
        }
    }
}
