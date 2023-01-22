package resources;

import java.io.IOException;
import java.util.ArrayList;

public class XMLfileHander extends BaseFileHandler{

    public XMLfileHander(String argFilePath) throws IOException {
        super(argFilePath, "<xml>", "</xml>", "XML файл");
    }
    
    public String formData(Contact argIn){
        StringBuilder data = new StringBuilder();
        data.append(String.format("<Contact>%s</Contact>", argIn.getID()));
        data.append(String.format("<SecondName>%s</SecondName>", argIn.getSecondName()));
        data.append(String.format("<FirstName>%s</FirstName>", argIn.getFirstName()));
        data.append(String.format("<Comment>%s</Comment>", argIn.getCommentary()));
        for (int i = 0; i < argIn.getPhones().size(); i++) {
            data.append(String.format("<Phone>%d</Phone>", argIn.getPhones().get(i)));
        }
        return data.toString();
    }

    public Contact extractData(String argIn){

        String tempID;
        String tempSecondName;
        String tempFirstName;
        ArrayList<Integer> tempPhones = new ArrayList<>();
        String tempCommentary;
        argIn = argIn.replace("<Contact>","");
        argIn = argIn.replace("<SecondName>","");
        argIn = argIn.replace("<FirstName>","");
        argIn = argIn.replace("<Phone>","");
        argIn = argIn.replace("<Comment>","");
        
        String[] tempArgIn = argIn.split("</Contact>");
        tempID = tempArgIn[0];
        argIn = tempArgIn[1];
        
        tempArgIn = argIn.split("</SecondName>");
        tempSecondName = tempArgIn[0];
        argIn = tempArgIn[1];
        
        tempArgIn = argIn.split("</FirstName>");
        tempFirstName = tempArgIn[0];
        argIn = tempArgIn[1];

        tempArgIn = argIn.split("</Comment>");
        tempCommentary = tempArgIn[0];
        argIn = tempArgIn[1];

        tempArgIn = argIn.split("</Phone>");
        for (int i = 0; i < tempArgIn.length; i++) {
            tempPhones.add(Integer.valueOf(tempArgIn[i]));
        }

        Contact data = new Contact(tempID, tempFirstName, tempSecondName, tempPhones, tempCommentary);
        return data;
    } 
}
