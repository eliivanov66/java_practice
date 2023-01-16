package resources;

import java.io.IOException;
import java.util.ArrayList;

public class CSVfileHander extends BaseFileHandler{

    public CSVfileHander(String argFilePath) throws IOException {
        super(argFilePath, "'CSV'", "'/CSV");
    }
    
    public String formData(Contact argIn){
        StringBuilder data = new StringBuilder();
        data.append(String.format("%s;", argIn.getID()));
        data.append(String.format("%s;", argIn.getSecondName()));
        data.append(String.format("%s;", argIn.getFirstName()));
        data.append(String.format("%s;", argIn.getCommentary()));
        for (int i = 0; i < argIn.getPhones().size(); i++) {
            data.append(String.format("%d;", argIn.getPhones().get(i)));
        }
        return data.toString();
    }

    public Contact extractData(String argIn){

        String tempID;
        String tempSecondName;
        String tempFirstName;
        ArrayList<Integer> tempPhones = new ArrayList<>();
        String tempCommentary;

        
        String[] tempArgIn = argIn.split(";");
        tempID = tempArgIn[0];
        tempSecondName = tempArgIn[1];
        tempFirstName = tempArgIn[2];
        tempCommentary = tempArgIn[3];
        
        for (int i = 4; i < tempArgIn.length; i++) {
            tempPhones.add(Integer.valueOf(tempArgIn[i]));
        }

        Contact data = new Contact(tempID, tempFirstName, tempSecondName, tempPhones, tempCommentary);
        return data;
    } 
}
