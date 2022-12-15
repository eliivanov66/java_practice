import java.util.Scanner;

public class logic {
    public static void main(String[] args) {
        filmsBD myFilmsDB = new filmsBD(); //создание базы фильмов
        Scanner UI;
        String userInput = "";
        int results = 0;
        while (! userInput.toLowerCase().equals("exit")){
            results = 0;
            System.out.println("Введите название фильма для поиска, введите EXIT - для завершения работы: ");
            UI = new Scanner(System.in);
            userInput = UI.nextLine();
            for (film element : myFilmsDB.films) {
                if (element.getArgName().toLowerCase().contains(userInput)) {
                    System.out.println(element.Getinfo());
                    results++;  
                }
            }
            if ((results == 0) && (! userInput.toLowerCase().equals("exit")) ) {
                System.out.printf("Запрашиваемый фильм - не найден\n", userInput);
            }
        }

    }

    
}
