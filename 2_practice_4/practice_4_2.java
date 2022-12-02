
// Принимает от пользователя строку вида 
// text~num
// Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
// Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.




import java.util.LinkedList;
import java.util.Scanner;
public class practice_4_2 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Введите строку вида text~num: ");
        String userData = userInput.nextLine();
        LinkedList<String> userLinkedList = new LinkedList<>();
        while (! userData.contains("exit") ) {
            String[] tempData = userData.split("~");
            if (! tempData[0].toLowerCase().contains("print") && userLinkedList.size() >= Integer.valueOf(tempData[1])) { //если у нас нет слова print
                userLinkedList.add(Integer.valueOf(tempData[1]), tempData[0]); //добавление значение в связанный список
            }
            if (tempData[0].toLowerCase().contains("print") && userLinkedList.size() >= Integer.valueOf(tempData[1]))  {
                
                userLinkedList.remove( Integer.parseInt(tempData[1]) );
                
            }
            System.out.println("Текущее состояние LinkedList: ");
            System.out.println(userLinkedList.toString());
            userData = userInput.nextLine();
        }
        userInput.close();


    }
}
