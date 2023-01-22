using System.Text;
public class CSVfileHander: BaseFileHandler{

    public CSVfileHander(string argFilePath): base(argFilePath, "CSV", "/CSV", "CSV файл") {
    }
    
    public override string formData(Contact argIn){
        StringBuilder data = new StringBuilder();
        data.Append(String.Format("{0};", argIn.getID()));
        data.Append(String.Format("{0};", argIn.getSecondName()));
        data.Append(String.Format("{0};", argIn.getFirstName()));
        data.Append(String.Format("{0};", argIn.getCommentary()));
        for (int i = 0; i < argIn.getPhones().Count; i++) {
            data.Append(String.Format("{0};", argIn.getPhones().ElementAt(i)));
        }
        return data.ToString();
    }

    public override Contact extractData(string argIn){

        string tempID;
        string tempSecondName;
        string tempFirstName;
        List<int> tempPhones = new List<int>();
        string tempCommentary;

        string[] tempArgIn = argIn.Split(";");
        tempID = tempArgIn[0];
        tempSecondName = tempArgIn[1];
        tempFirstName = tempArgIn[2];
        tempCommentary = tempArgIn[3];
        
        for (int i = 4; i < tempArgIn.Length; i++) {
            if (tempArgIn[i].Length > 0) tempPhones.Add(Convert.ToInt32(tempArgIn[i]));
        }

        Contact data = new Contact(tempID, tempFirstName, tempSecondName, tempPhones, tempCommentary);
        return data;
    } 
}
