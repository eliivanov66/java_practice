import java.util.Scanner;

public class treeUI implements ui {
    static int levelUI = 0; 

    public person newPersonInput(){
        String tempSurname = dataForm("Введите фамилию человека:", String.class);
        String tempName  = dataForm("Введите имя человека:", String.class);
        Boolean tempSex= dataForm("Введите пол человека:\n1-мужской\n0-женский", Boolean.class);
        person tempPerson = new person(tempName, tempSurname, tempSex);
        return tempPerson;
    }

    @Override
    public <T> T dataForm(String msg, Class<T> typeRetValue) {
        boolean badDataIn = true;
        T retValue = null;
        while (badDataIn) {
            badDataIn = false;
            dataOut(msg);
            Scanner data = new Scanner(System.in);
            try {
                data = new Scanner(System.in);
                if (typeRetValue == Boolean.class) {
                    String temp = data.nextLine().toLowerCase();
                    if (! (temp.equals("1") || 
                       temp.equals("0") ||
                       temp.equals("true") || 
                       temp.equals("false"))) {
                        badDataIn = true;
                    }
                    temp = temp.replace("1", "true");
                    temp = temp.replace("0", "false");
                    retValue = (T)Boolean.valueOf(temp);
                } else if (typeRetValue == Integer.class) {
                    retValue = (T)Integer.valueOf(data.nextLine().toLowerCase());
                }
                else {
                    retValue = (T)((data.nextLine()).toLowerCase());
                }
            } catch (Exception e) {
                badDataIn = true;
            }

            if (badDataIn) {
                dataOut(String.format("Некорректное значение"));
            }
        }
        return retValue;
    }

    @Override
    public void dataOut(String Data) {
        System.out.println(Data);
        
    }
    
}
