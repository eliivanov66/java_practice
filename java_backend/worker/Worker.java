import java.util.Random;

public class Worker implements Comparable{
    static private Integer UID = 0;
    private Integer id;
    private String firstName;
    private String secondName;
    private String thirdName;
    private Integer age;
    private String phone;
    private boolean gender;
    private Double salary;
    private String addInfo;
    static private Random random = new Random();

    Worker(String firstName, String secondName, String thirdName, Integer age, boolean gender, String phone, Double salary) {
        UID++;
        id = UID;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.salary = salary;
        this.addInfo = "";
    }

    Worker(){
        this("Имя " + (UID + 1), 
            "Фамилия " + (UID + 1), 
            "Отчество" +(UID + 1), 
            random.nextInt(18, 66), 
            random.nextBoolean(), 
            String.valueOf(random.nextLong(8_000_00_00, 8_999_99_99)),
            Double.valueOf(random.nextLong(50000, 100000)));
    }

    public void setAddInfo(String arg) {
        this.addInfo = arg;
    }

    public String getAddInfo() {
        return this.addInfo;
    }

    public void setID(Integer arg) {
        this.id = arg;
    }

    public void setFirstName(String arg) {
        this.firstName = arg;
    }

    public void setSecondName(String arg) {
        this.secondName = arg;
    }

    public void setThirdName(String arg) {
        this.thirdName = arg;
    }

    public void setAge(Integer arg) {
        this.age = arg;
    }

    public void setGender(boolean arg) {
        this.gender = arg;
    }

    public void setPhone(String arg) {
        this.phone = arg;
    }


    public void setSalary(Double arg) {
        this.salary = arg;
    }

    public Integer getID() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public String getThirdName() {
        return this.thirdName;
    }

    public Integer getAge() {
        return this.age;
    }

    public boolean getGender() {
        return this.gender;
    }

    public String getPhone() {
        return this.phone;
    }

    public Double getSalary() {
        return this.salary;
	}

    public Integer getUID(){
        return UID;
    }

    public String getInfo() {
        StringBuilder temp = new StringBuilder();
        temp.append("имя: "); temp.append(this.firstName); temp.append("/");
        temp.append(" фамилия: "); temp.append(this.secondName); temp.append("/");
        temp.append(" отчество: "); temp.append(this.thirdName); temp.append("/");
        temp.append(" возраст: "); temp.append(this.age.toString()); temp.append("/");
        if (this.gender) {
            temp.append(" пол: мужской"); temp.append(this.age.toString()); temp.append("/");
        } else {
            temp.append(" пол: женский"); temp.append(this.age.toString()); temp.append("/");
        }
        
        temp.append(" телефон: "); temp.append(this.age.toString()); temp.append("/");
        temp.append(" оклад: "); temp.append(this.salary.toString()); temp.append("/");
        temp.append(" доп. комментарий: "); temp.append(this.addInfo);
        return temp.toString();
    }

    @Override
    public int compareTo(Object o) {
        if (this.age > ((Worker) o).age) return 1;
        if (this.age < ((Worker) o).age) return -1;
        return 0;
    }
}

