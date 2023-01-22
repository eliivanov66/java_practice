using System.Text;
public class XMLfileHander: BaseFileHandler{

    public XMLfileHander(string argFilePath): base(argFilePath, "<xml>", "</xml>", "XML файл") {
    }
    
    public override string formData(Contact argIn){
        StringBuilder data = new StringBuilder();
        data.Append(String.Format("<Contact>{0}</Contact>", argIn.getID()));
        data.Append(String.Format("<SecondName>{0}</SecondName>", argIn.getSecondName()));
        data.Append(String.Format("<FirstName>{0}</FirstName>", argIn.getFirstName()));
        data.Append(String.Format("<Comment>{0}</Comment>", argIn.getCommentary()));
        for (int i = 0; i < argIn.getPhones().Count; i++) {
            data.Append(String.Format("<Phone>{0}</Phone>", argIn.getPhones().ElementAt(i)));
        }
        return data.ToString();
    }

    public override Contact extractData(string argIn){

        string tempID;
        string tempSecondName;
        string tempFirstName;
        List<int> tempPhones = new List<int>();
        string tempCommentary;
        argIn = argIn.Replace("<Contact>","");
        argIn = argIn.Replace("<SecondName>","");
        argIn = argIn.Replace("<FirstName>","");
        argIn = argIn.Replace("<Phone>","");
        argIn = argIn.Replace("<Comment>","");
        
        string[] tempArgIn = argIn.Split("</Contact>");
        tempID = tempArgIn[0];
        argIn = tempArgIn[1];
        
        tempArgIn = argIn.Split("</SecondName>");
        tempSecondName = tempArgIn[0];
        argIn = tempArgIn[1];
        
        tempArgIn = argIn.Split("</FirstName>");
        tempFirstName = tempArgIn[0];
        argIn = tempArgIn[1];

        tempArgIn = argIn.Split("</Comment>");
        tempCommentary = tempArgIn[0];
        argIn = tempArgIn[1];

        tempArgIn = argIn.Split("</Phone>");
        foreach (string i in tempArgIn) {
            if (i.Length > 0) tempPhones.Add(Convert.ToInt32(i));
        }

        Contact data = new Contact(tempID, tempFirstName, tempSecondName, tempPhones, tempCommentary);
        return data;
    } 
}
