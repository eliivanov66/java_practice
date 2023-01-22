using System.Text;
public class Contact {
    private string iD;
    private string firstName;
    private string secondName;
    private List<int> phones = new List<int>();
    private string commentary;
    
    public Contact(string argID, string argFirstName, string argSecondName, List<int> argPhones, string argCommentary) {
        this.iD = argID;
        this.firstName = argFirstName;
        this.secondName = argSecondName;
        this.phones = argPhones;
        this.commentary = argCommentary;
    }

    public Contact(string argID, string argFirstName, string argSecondName, int argPhone, string argCommentary) {
        this.iD = argID;
        this.firstName = argFirstName;
        this.secondName = argSecondName;
        this.phones = new List<int>();
        this.phones.Add(argPhone);
        this.commentary = argCommentary;
    }
    
    public Contact(string argID, int argPhone) {
        this.iD = argID;
        this.firstName = "";
        this.secondName = "";
        this.phones = new List<int>();
        this.phones.Add(argPhone);
        this.commentary = " ";
    }

    public string getID(){
        return this.iD;
    }

    public string getFirstName(){
        return this.firstName;
    }

    public string getSecondName(){
        return this.secondName;
    }

    public List<int> getPhones(){
        return this.phones;
    }

    public string getCommentary(){
        return this.commentary;
    }

    public string toString() {
        StringBuilder tempPhones = new StringBuilder();
        foreach (int phone in this.phones) {
            tempPhones.Append(Convert.ToString(String.Format("/номер {0}",phone)));
        }
        return String.Format("Контакт {0}/ фамилия: {1}/ имя {2} {3}/ коментарий {4}", 
                            this.iD, this.secondName, this.firstName, tempPhones.ToString(), this.commentary);
    }
}
