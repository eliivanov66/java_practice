import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class program {
    public static void main(String[] args) {
        treeUI myTreeUI = new treeUI();
        StringBuilder myBuilder = new StringBuilder();
        Integer userChoice = -1;
        HashSet<Integer> rightChoise = new HashSet<Integer>(); 
        HashMap<Integer, person> humankind = new HashMap<Integer, person>();
        
        while (userChoice != 0){
            myBuilder = new StringBuilder();
            myBuilder.append("================================================\n");
            myBuilder.append("1 - создать человека\n");
            myBuilder.append("2 - формировать родственные связи для существующих людей\n");
            myBuilder.append("3 - показать общее древо созданных людей\n");
            myBuilder.append("4 - показать древо для выбранного человека\n");
            myBuilder.append("0 - Выйти из приложения\n");
            myTreeUI.dataOut(myBuilder.toString());
            userChoice = myTreeUI.dataForm("Ваш выбор: ", Integer.class);
            switch (userChoice) {
                case 1:
                    myTreeUI.dataOut(String.format("========== Создание новой персоны, следуйте диалогу =========="));
                    person tempPerson = myTreeUI.newPersonInput();
                    humankind.put(humankind.size(), tempPerson);
                    break;
                case 2:
                    userChoice = -1;
                    while (userChoice != 0) {
                        myTreeUI.dataOut(String.format("========== Создание родственных связей =========="));
                        for (Entry<Integer, person> element : humankind.entrySet()) {
                            myTreeUI.dataOut(String.format("%d - %s", element.getKey() + 1, element.getValue().getInfo("-->")));
                        }
                        myTreeUI.dataOut("0 - НАЗАД\n");
                        userChoice = myTreeUI.dataForm("Ваш выбор: ", Integer.class);
                        if (humankind.keySet().contains(userChoice - 1)) {
                            int chosenPerson = userChoice - 1;
                            userChoice = -1;
                            myBuilder = new StringBuilder();
                            myBuilder.append(String.format("========== Создание семейных связей, персона %s ==========\n", humankind.get(chosenPerson).getInfo()));
                            myBuilder.append("1 - указать отца\n");
                            myBuilder.append("2 - указать мать\n");
                            myBuilder.append("3 - указать сына\n");
                            myBuilder.append("4 - указать дочь\n");
                            myBuilder.append("0 - НАЗАД\n");
                            myTreeUI.dataOut(myBuilder.toString());
                            while (userChoice != 0) {
                                userChoice = myTreeUI.dataForm("Ваш выбор: ", Integer.class);
                                switch (userChoice) {
                                    case 1:
                                        myTreeUI.dataOut(String.format("========== Выберите отца =========="));
                                        rightChoise = new HashSet<Integer>();
                                        for (Entry<Integer, person> element : humankind.entrySet()) {
                                            if ((element.getKey() != chosenPerson) && 
                                                (humankind.get(element.getKey()).getSex()) && //мужского пола
                                                (! humankind.get(element.getKey()).inRelation(humankind.get(chosenPerson)))) { //не братья/сестры
                                                    myTreeUI.dataOut(String.format("%d - %s", element.getKey() + 1, element.getValue().getInfo("-->")));
                                                    rightChoise.add(element.getKey() + 1);
                                                }

                                        }
                                        myTreeUI.dataOut("0 - НАЗАД\n");
                                        userChoice = myTreeUI.dataForm("Ваш выбор: ", Integer.class);
                                        if (rightChoise.contains(userChoice)) {
                                            humankind.get(chosenPerson).SetFather(humankind.get(userChoice - 1));
                                            humankind.get(userChoice - 1).SetChildren(humankind.get(chosenPerson));
                                            //если уже есть дети у родителя, то они братья
                                            if (! humankind.get(userChoice - 1).getChildren().isEmpty()) { 
                                                for (person child : humankind.get(userChoice - 1).getChildren()) {
                                                    humankind.get(chosenPerson).SetSublings(child);
                                                    child.SetSublings(humankind.get(chosenPerson));
                                                }
                                            }
                                        }
                                        userChoice = 0;
                                        break;
                                    case 2:
                                        myTreeUI.dataOut(String.format("========== Выберите мать =========="));
                                        rightChoise = new HashSet<Integer>();
                                        for (Entry<Integer, person> element : humankind.entrySet()) {
                                            if ((element.getKey() != chosenPerson) && 
                                                (! humankind.get(element.getKey()).getSex()) && //женского пола
                                                (! humankind.get(element.getKey()).inRelation(humankind.get(chosenPerson)))) { //не братья/сестры
                                                    myTreeUI.dataOut(String.format("%d - %s", element.getKey() + 1, element.getValue().getInfo("-->")));
                                                    rightChoise.add(element.getKey() + 1);
                                                }

                                        }
                                        myTreeUI.dataOut("0 - НАЗАД\n");
                                        userChoice = myTreeUI.dataForm("Ваш выбор: ", Integer.class);
                                        if (rightChoise.contains(userChoice)) {
                                            humankind.get(chosenPerson).SetMother(humankind.get(userChoice - 1));
                                            humankind.get(userChoice - 1).SetChildren(humankind.get(chosenPerson));
                                            //если уже есть дети у родителя, то они братья
                                            if (! humankind.get(userChoice - 1).getChildren().isEmpty()) { 
                                                for (person child : humankind.get(userChoice - 1).getChildren()) {
                                                    humankind.get(chosenPerson).SetSublings(child);
                                                    child.SetSublings(humankind.get(chosenPerson));
                                                }
                                            }
                                        }
                                        userChoice = 0;
                                        break;
                                    case 3:
                                        myTreeUI.dataOut(String.format("========== Выберите сына =========="));
                                        rightChoise = new HashSet<Integer>();
                                        for (Entry<Integer, person> element : humankind.entrySet()) {
                                            if ((element.getKey() != chosenPerson) && 
                                                (humankind.get(element.getKey()).getSex()) && //женского пола
                                                (! humankind.get(element.getKey()).inRelation(humankind.get(chosenPerson)))) { //не братья/сестры
                                                    myTreeUI.dataOut(String.format("%d - %s", element.getKey() + 1, element.getValue().getInfo("-->")));
                                                    rightChoise.add(element.getKey() + 1);
                                                }

                                        }
                                        myTreeUI.dataOut("0 - НАЗАД\n");
                                        userChoice = myTreeUI.dataForm("Ваш выбор: ", Integer.class);
                                        if (rightChoise.contains(userChoice)) {
                                            humankind.get(userChoice - 1).SetFather(humankind.get(chosenPerson));
                                            humankind.get(chosenPerson).SetChildren(humankind.get(userChoice - 1));
                                            //если уже есть дети у родителя, то они братья
                                            if (! humankind.get(chosenPerson).getChildren().isEmpty()) { 
                                                for (person child : humankind.get(chosenPerson).getChildren()) {
                                                    humankind.get(userChoice - 1).SetSublings(child);
                                                    child.SetSublings(humankind.get(userChoice - 1));
                                                }
                                            } 
                                        }
                                        userChoice = 0;
                                        break;
                                    case 4:
                                        myTreeUI.dataOut(String.format("========== Выберите дочь =========="));
                                        rightChoise = new HashSet<Integer>();
                                        for (Entry<Integer, person> element : humankind.entrySet()) {
                                            if ((element.getKey() != chosenPerson) && 
                                                (! humankind.get(element.getKey()).getSex()) && //женского пола
                                                (! humankind.get(element.getKey()).inRelation(humankind.get(chosenPerson)))) { //не братья/сестры
                                                    myTreeUI.dataOut(String.format("%d - %s", element.getKey() + 1, element.getValue().getInfo("-->")));
                                                    rightChoise.add(element.getKey() + 1);
                                                }

                                        }
                                        myTreeUI.dataOut("0 - НАЗАД\n");
                                        userChoice = myTreeUI.dataForm("Ваш выбор: ", Integer.class);
                                        if (rightChoise.contains(userChoice)) {
                                            humankind.get(userChoice - 1).SetMother(humankind.get(chosenPerson));
                                            humankind.get(chosenPerson).SetChildren(humankind.get(userChoice - 1));
                                            //если уже есть дети у родителя, то они братья
                                            if (! humankind.get(chosenPerson).getChildren().isEmpty()) { 
                                                for (person child : humankind.get(chosenPerson).getChildren()) {
                                                    humankind.get(userChoice - 1).SetSublings(child);
                                                    child.SetSublings(humankind.get(userChoice - 1));
                                                }
                                            } 
                                        }
                                        userChoice = 0;
                                        break;
                                }
                            }  
                        }
                    }
                    userChoice = -1;
                    break;
                case 3:
                    myTreeUI.dataOut(String.format("========== Список существующих персон =========="));
                    for (Entry<Integer, person> element : humankind.entrySet()) {
                        myTreeUI.dataOut(String.format("Персона %d - %s", element.getKey(), element.getValue().getInfo("-->")));
                    }
                    break;
                case 4:
                    userChoice = -1;
                    while (userChoice != 0) {
                        myTreeUI.dataOut(String.format("========== Выберите персону для построения его древа =========="));
                        for (Entry<Integer, person> element : humankind.entrySet()) {
                            myTreeUI.dataOut(String.format("%d - %s", element.getKey() + 1, element.getValue().getInfo()));
                        }
                        myTreeUI.dataOut("0 - НАЗАД\n");
                        userChoice = myTreeUI.dataForm("Ваш выбор: ", Integer.class);
                        if (humankind.keySet().contains(userChoice - 1)) {
                            myTreeUI.dataOut(humankind.get(userChoice - 1).getInfo("-->"));
                            userChoice = 0;
                        }

                    }
                    userChoice = -1;
                    break;
            }
        }



    }
}
