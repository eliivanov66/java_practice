package resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Map.Entry;

public class Initilizer {   
    public static void InitDB(int argSize, BaseFileHandler argHandler) throws IOException {
        argHandler.Clear();
        HashMap<Integer, Contact> DB = new HashMap<Integer, Contact>();
        Random myRand = new Random();
        Contact tempContact;
        String tempID;
        String tempSecondName;
        String tempFirstName;
        String tempCommentary;
        int tempPhonesCount;
        int tempPhone;
        ArrayList<Integer> tempPhones = new ArrayList<>();
        boolean tempSex;

        if (argSize > 0) {
            for (int i = 0; i < argSize; i++) {
                tempPhones = new ArrayList<>();
                tempID = String.format("contact#%d", i);
                tempSex = myRand.nextBoolean();
                if (tempSex) {
                    tempSecondName = HumanNames.maleSecondNames.get(myRand.nextInt(HumanNames.maleSecondNames.size()));
                    tempFirstName = HumanNames.maleFirstNames.get(myRand.nextInt(HumanNames.maleFirstNames.size()));
                } else {
                    tempSecondName = HumanNames.femaleSecondNames.get(myRand.nextInt(HumanNames.femaleSecondNames.size()));
                    tempFirstName = HumanNames.femaleFirstNames.get(myRand.nextInt(HumanNames.femaleFirstNames.size()));  
                }
                tempCommentary = String.format("commentary for contact#%d", i);

                tempPhonesCount = myRand.nextInt(1, 5);

                for (int j = 0; j < tempPhonesCount; j++) {
                    tempPhone = myRand.nextInt(89000000, 89999999);
                    tempPhones.add(tempPhone);
                }
                tempContact = new Contact(tempID, tempFirstName, tempSecondName, tempPhones, tempCommentary);
                DB.put(i, tempContact);
            }
        }
        for (Entry<Integer,Contact> tempSet : DB.entrySet()) {
            argHandler.Insert(argHandler.Size() - 1, argHandler.formData(tempSet.getValue()));
        } 
    }
}
