import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Stream;

public class Main{

    public static void main(String[] args) {
        Random rand = new Random();
        new ArrayList<Integer>();
        //Создать список из 1_000 рандомных чисел от 1 до 1_000_000
        List<Integer> list = Stream.generate(() -> rand.nextInt(0, 1_000_000)).limit(1000).toList();
        //Найти максимальное
        System.out.print("Максимальное число: ");
        System.out.println(list.stream().max(Comparator.naturalOrder()));
        //Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
        System.out.print("Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать: ");
        System.out.println(list.stream().filter(i-> Integer.compare(i, 500_000)>0).map(i -> (i * 5 - 150)).mapToLong(i -> i).sum());
        //Найти количество чисел, квадрат которых меньше, чем 100_000
        System.out.print("Найти количество чисел, квадрат которых меньше, чем 100_000: ");
        System.out.println(list.stream().filter(i->Integer.compare(i, 100_000)<0).count());

        //Создать список из 10-20 сотрудников
        ArrayList<Employee> listEmployees = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listEmployees.add(new Employee());
        }
        //Вывести список всех различных отделов (department) по списку сотрудников
        System.out.println("Список всех отделов: ");
        listEmployees.stream().map(i -> i.department).distinct().sorted().forEach(System.out::println);
        //Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
        System.out.println("Следующие сотрудники имеют зарплату меньше 10_000: ");
        listEmployees.stream().filter(i -> Double.compare(i.salary, 10000.0)<0).forEach(System.out::println);
        System.out.println("Следующим сотрудникам повышена зарплата: ");
        listEmployees.stream().filter(i -> Double.compare(i.salary, 10000.0)<0).map(i -> new Employee(i.name, i.age, 1.2 * i.salary, i.department ) ).forEach(System.out::println);
        //Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
        HashMap<String, List<Employee>> mapEmployees = new HashMap<>();
        listEmployees.stream().map(i -> i.department).distinct().sorted().forEach(i -> mapEmployees.put(i, new ArrayList<Employee>())); 
        listEmployees.stream().forEach(i -> mapEmployees.replace(i.department, myAdd(mapEmployees.get(i.department), i)));
        
        System.out.println("Список сотрудников по отделам: ");
        for (Entry<String, List<Employee>> employee : mapEmployees.entrySet()) {
            System.out.println("Ключ: " + employee.getKey());
            for (Employee element : employee.getValue()) {
                System.out.println("Значение: " + element.toString());
            }
        }
        
        //Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
        HashMap<String, Double> mapSalarys = new HashMap<>();
        listEmployees.stream().map(i -> i.department).distinct().sorted().forEach(i -> mapSalarys.put(i, 0.0));
        listEmployees.stream().forEach(i -> mapSalarys.replace(i.department, (mapSalarys.get(i.department) + i.salary) / mapEmployees.get(i.department).size() ));
        
        System.out.println("Список средних запрал по отделам: ");
        for (Entry<String, Double> employee : mapSalarys.entrySet()) {
            System.out.println("Ключ: " + employee.getKey());
            System.out.println("Среднее значение: " + employee.getValue());
        }
    }


    static List<Employee> myAdd(List<Employee> arg, Employee value){
        if (arg != null) {
            arg.add(value);
        }
        return arg;
    }
}