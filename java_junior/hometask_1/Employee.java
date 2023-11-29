    //Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department

import java.util.Random;

public class Employee{
        private static int counter = 0;
        private static Random rand = new Random(); 
        String name;
        int age;
        double salary;
        String department;

        public Employee(){
            counter++;
            this.name = "Employee " + counter;
            this.age = rand.nextInt(18,65);
            this.salary = rand.nextDouble(5_000, 100_000);
            this.department = "Department #" + rand.nextInt(1,4);
        }

        public Employee(String name, int age, double salary, String department){
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.department = department;
        }

        @Override
        public String toString() {
            return String.format("Имя: %s/ Возраст: %d/ Зарплата: %f/ Отдел: %s", this.name, this.age, this.salary, this.department);
        }
    } 
