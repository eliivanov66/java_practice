/* Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"} */


//WHERE name = "Ivanov" AND

public class homework_2_task1 {
    public static void main(String[] args) {
        System.out.print("SELECT * from students ");
        System.out.println(homework_2_libr.sqlFilterFormer("{name:Ivanov, country:Russia, city:Moscow, age:null}"));
        System.out.print("SELECT * from students ");
        System.out.println(homework_2_libr.sqlFilterFormer("{name:Petrov, country:null, city:S.Peterburg, age:25}"));
    }



}
