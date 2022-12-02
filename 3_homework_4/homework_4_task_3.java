import java.util.Scanner;
import java.util.Stack;

//В калькулятор добавьте возможность отменить последнюю операцию.

public class homework_4_task_3 {
    public static void main(String[] args) {
        double result = 0.0;
        Stack<Double> resultStack = new Stack<>();
        double userValue = 0.0;
        Scanner userInput = new Scanner(System.in);
        int userChoise = -1; //userInput.nextInt();
        
        while (userChoise != 0)
        {
            System.out.println(String.format("Сохранённые результаты %s", resultStack.toString()));
            System.out.println(String.format("Текущий результат: %f", result));
            System.out.println(String.format("1 '+' ", result));
            System.out.println(String.format("2 '-' ", result));
            System.out.println(String.format("3 '*' ", result));
            System.out.println(String.format("4 '/' ", result));
            System.out.println(String.format("9 'отменить последнюю операцию' ", result));
            System.out.println(String.format("0 'выйти из программы' ", result));
            Boolean badUserInput = true;
            while (badUserInput) {
                userInput = new Scanner(System.in);
                try {
                    userChoise = userInput.nextInt();
                    badUserInput = false;
                } catch (Exception e) {
                    badUserInput = true; 
                }

                if ((! badUserInput) && 
                    (userChoise != 1 && userChoise != 2 && userChoise != 3 && userChoise != 4 && userChoise != 9 && userChoise != 0)) {
                    badUserInput = true;
                }

                if (badUserInput)
                {
                    System.out.println(String.format("Некорректный выбор операции", result));
                }
                else {
                    //userInput.close();
                    userInput = new Scanner(System.in);
                    switch (userChoise) {
                        case 1:
                            badUserInput = true;
                            while (badUserInput) {
                                badUserInput = false;
                                System.out.println(String.format("Сложить %f с: ", result));
                                try {
                                    userValue = Double.valueOf(userInput.nextLine());
                                    badUserInput = false;
                                } catch (Exception e) {
                                    badUserInput = true;
                                }
                                
                                if (badUserInput) {
                                    System.out.println(String.format("Некорректный ввод числа", result));
                                } 
                                else {
                                    result = result + userValue;
                                    resultStack.push(result); //в стек
                                }
                            }
                            break;
                        case 2:
                            badUserInput = true;
                            while (badUserInput) {
                                badUserInput = false;
                                System.out.println(String.format("Из %f вычесть: ", result));
                                try {
                                    userValue = Double.valueOf(userInput.nextLine());
                                    badUserInput = false;
                                } catch (Exception e) {
                                    badUserInput = true;
                                }
                                
                                if (badUserInput) {
                                    System.out.println(String.format("Некорректный ввод числа", result));
                                } 
                                else {
                                    result = result - userValue;
                                    resultStack.push(result); //в стек
                                }
                            }
                            break;
                        case 3:
                            badUserInput = true;
                            while (badUserInput) {
                                badUserInput = false;
                                System.out.println(String.format("%f умножить на: ", result));
                                try {
                                    userValue = Double.valueOf(userInput.nextLine());
                                    badUserInput = false;
                                } catch (Exception e) {
                                    badUserInput = true;
                                }
                                
                                if (badUserInput) {
                                    System.out.println(String.format("Некорректный ввод числа", result));
                                } 
                                else {
                                    result = result * userValue;
                                    resultStack.push(result); //в стек
                                }
                            }
                            break;
                        case 4:
                            badUserInput = true;
                            while (badUserInput) {
                                badUserInput = false;
                                System.out.println(String.format("%f разделить на: ", result));
                                try {
                                    userValue = Double.valueOf(userInput.nextLine());
                                    badUserInput = false;
                                } catch (Exception e) {
                                    badUserInput = true;
                                }
                                if (userValue == 0.0) badUserInput = true;
                                if (badUserInput) {
                                    System.out.println(String.format("Некорректный ввод числа", result));
                                } 
                                else {
                                    result = result / userValue;
                                    resultStack.push(result); //в стек
                                }
                            }
                            break;
                        case 9:
                            try {
                                resultStack.pop(); //из стека
                                result = resultStack.peek();
                            } catch (Exception e) {
                            }
                            
                            break;
                    }
                }
            }        
        }
        userInput.close();
    }
}
