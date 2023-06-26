public class Custumer implements Comparable<Custumer> {
    private static Integer IDCount = 0;
    private Integer ID;
    private String firstName = "";
    private String secondName = "";
    private String thirdName= "";
    private Integer age = 0;
    private String phone = "";
    private boolean gender = true;

    public Custumer(String firstName, String secondName, String thirdName, Integer age, String phone, boolean gender){
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
        IDCount ++;
        this.ID = IDCount;
    } 

    public Custumer(){
        IDCount ++;
        this.ID = IDCount;  
    }

    public Integer getID() {
        return this.ID;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getSecondName(){
        return this.secondName;
    }

    public String getThirdName(){
        return this.thirdName;
    }

    public Integer getAge(){
        return this.age;
    }

    public String getPhone(){
        return this.phone;

    }

    public boolean getGender(){
        return this.gender;
    }

    public void setFirstName(String arg){
        this.firstName = arg;
    }

    public void setSecondName(String arg){
        this.secondName = arg;
    }

    public void setThirdName(String arg){
        this.thirdName = arg;
    }

    public void setAge(Integer arg){
        this.age = arg;
    }

    public void setPhone(String arg){
        this.phone = arg;
    }

    public void setGender(boolean arg){
        this.gender = arg;
    }

    public String getInfo(){
        StringBuilder temp = new StringBuilder();
        temp.append(" Фамилия: "); temp.append(firstName);
        temp.append(" Имя: "); temp.append(secondName);
        temp.append(" Отчество: "); temp.append(thirdName);
        temp.append(" Возраст: "); temp.append(age);
        temp.append(" Телефон: "); temp.append(phone);
        if (this.gender) {
            temp.append(" Пол: М");
        } else {
            temp.append(" Пол: Ж");
        }
        return temp.toString();
    }

    @Override
    public int compareTo(Custumer o) {
        if ( o.firstName.toLowerCase().equals(this.firstName.toLowerCase()) && 
             o.secondName.toLowerCase().equals(this.secondName.toLowerCase()) && 
             o.thirdName.toLowerCase().equals(this.thirdName.toLowerCase()) &&
             o.age == this.age ) {
                return 0;
        } else {
            return -1;
        }
    }
}
