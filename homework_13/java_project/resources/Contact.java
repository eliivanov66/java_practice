package resources;

import java.util.ArrayList;
import java.util.Arrays;

//_i_phone#2;_f_borisov;_n_boris;_p_320010;_d_user borisov b.;
public class Contact {
    private String iD;
    private String firstName;
    private String secondName;
    private ArrayList<Integer> phones = new ArrayList<>();
    private String commentary;
    
    public Contact(String argID, String argFirstName, String argSecondName, ArrayList<Integer> argPhones, String argCommentary) {
        this.iD = argID;
        this.firstName = argFirstName;
        this.secondName = argSecondName;
        this.phones = argPhones;
        this.commentary = argCommentary;
    }

    public Contact(String argID, String argFirstName, String argSecondName, int argPhone, String argCommentary) {
        this.iD = argID;
        this.firstName = argFirstName;
        this.secondName = argSecondName;
        this.phones.add(argPhone);
        this.commentary = argCommentary;
    }
    
    public Contact(String argID, Integer argPhone) {
        this(argID, "", "", new ArrayList<Integer>(Arrays.asList(argPhone)), String.format("Contact %s", argID));
    }

    public String getID(){
        return this.iD;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getSecondName(){
        return this.secondName;
    }

    public ArrayList<Integer> getPhones(){
        return this.phones;
    }

    public String getCommentary(){
        return this.commentary;
    }

    @Override
    public String toString() {
        return String.format("Контакт %s/ фамилия %s/ имя %s/ номер %s/ %s", 
                            this.iD, this.secondName, this.firstName, this.phones.toString(), this.commentary);
    }
}
