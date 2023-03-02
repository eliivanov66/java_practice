import java.io.IOException;

public class Menu {
    public void logic(Toyshop argToyshop, BaseFileHandler argResults, Game argGame) throws IOException{
        StringBuilder menu = new StringBuilder();
        Integer userChoice = -1;
        UI menuUI = new UI();
        while (userChoice != 0){
            switch (userChoice) {
                case -1:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Магазин игрушек\n");
                    menu.append("1 - показать существующие игрушки в магазине \n");
                    menu.append("2 - добавить новую игрушку в магазин\n");
                    menu.append("3 - редактирование игрушек в магазине\n");
                    menu.append("4 - удаление существующих игрушек\n");
                    menu.append("5 - устроить розыгрыш игрушек\n");
                    menu.append("6 - посмотреть результаты всех розыграшей\n");
                    menu.append("7 - очистить результаты всех розыграшей\n");
                    menu.append("0 - Выйти из приложения\n");
                    menuUI.userOut(menu.toString());
                    userChoice = menuUI.userInputInt("Ваш выбор: ");
                    break;
                case 1:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Магазин игрушек/существующие игрушки в магазине: \n");
                    for (Toy item : argToyshop.getToys()) {
                        menu.append(String.format(" %d - %s\n", argToyshop.getIndex(item) + 1 , item.getInfo()));
                    }
                    menuUI.userOut(menu.toString());
                    userChoice = -1;
                    break;
                case 2:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Магазин игрушек/добавление новой игрушки в магазин: \n");
                    Toy userToy = new Toy(
                        menuUI.userInputStringAck("введите имя игрушки"),
                        menuUI.userInputIntAck("введите вероятность выпадания игрушки (0-100)"));
                    argToyshop.addToy(userToy);
                    userChoice = -1;
                    break;
                case 3:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Магазин игрушек/редактирование игрушки в магазине: \n");
                    for (Toy item : argToyshop.getToys()) {
                        menu.append(String.format(" %d - %s\n", argToyshop.getIndex(item) + 1 , item.getInfo()));
                    }
                    menu.append(String.format(" 0 - назад\n"));    
                    menuUI.userOut(menu.toString());
                    userChoice = -1;
                    while (userChoice != 0) {
                        userChoice = menuUI.userInputInt("Ваш выбор: ");
                        if ((userChoice - 1 >= 0) && (userChoice - 1 < argToyshop.Size())) {
                            menu = new StringBuilder();
                            menu.append("================================================\n");
                            menu.append(String.format("Редактирование игрушки %s: \n", argToyshop.getToy(userChoice - 1).getInfo()));
                            menuUI.userOut(menu.toString());
                            userToy = new Toy(
                                userChoice - 1,
                                menuUI.userInputStringAck("введите имя игрушки"),
                                menuUI.userInputIntAck("введите вероятность выпадания игрушки (0-100)"));
                            argToyshop.replaceToy(userChoice - 1, userToy);
                            userChoice = 0; 
                        }
                    }
                    userChoice = -1;
                    break;
                case 4:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Магазин игрушек/удаление игрушки в магазине: \n");
                    for (Toy item : argToyshop.getToys()) {
                        menu.append(String.format(" %d - %s\n", argToyshop.getIndex(item) + 1 , item.getInfo()));
                    }
                    menu.append(String.format(" 0 - назад\n"));    
                    menuUI.userOut(menu.toString());
                    userChoice = -1;
                    while (userChoice != 0) {
                        userChoice = menuUI.userInputInt("Ваш выбор: ");
                        if ((userChoice - 1 >= 0) && (userChoice - 1 < argToyshop.Size())) {
                            menu = new StringBuilder();
                            menu.append("================================================\n");
                            menu.append(String.format("Удаление игрушки %s: \n", argToyshop.getToy(userChoice - 1).getInfo()));
                            menuUI.userOut(menu.toString());
                            argToyshop.removeToy(argToyshop.getToy(userChoice - 1));
                            userChoice = 0; 
                        }
                    }
                    userChoice = -1;
                    break;
                case 5:
                    if (argToyshop.Size() > 0 ){
                        Toy gameResult = argGame.roll(argToyshop);
                        menu = new StringBuilder();
                        menu.append("================================================\n");
                        menu.append("Магазин игрушек/розыгрыш игрушки: \n");
                        if (gameResult != null) {
                            menu.append(String.format("Вы выиграли игрушку: %s\n", gameResult.getInfo()));
                            argToyshop.removeToy(gameResult);
                            argResults.Write(argResults.formData(gameResult));
                        } else {
                            menu.append("Вы ничего не выиграли \n");
                        }
                        menuUI.userOut(menu.toString());
                    }
                    userChoice = -1;
                    break;
                case 6:
                    menu = new StringBuilder();
                    menu.append("================================================\n");
                    menu.append("Магазин игрушек/результаты выиграшей игрушки: \n");
                    for (int i = 0; i < argResults.Size(); i++) {
                        menu.append(String.format("%d - %s \n", i + 1, argResults.extractData(argResults.Read(i + 1)).getInfo()));
                    }
                    menuUI.userOut(menu.toString());
                    userChoice = -1;
                    break;
                case 7:
                    menu = new StringBuilder();
                    argResults.Clear();
                    menu.append("================================================\n");
                    menu.append("Результаты очищены \n");
                    menuUI.userOut(menu.toString());
                    userChoice = -1;
                    break;
            }
        }
    }
}
