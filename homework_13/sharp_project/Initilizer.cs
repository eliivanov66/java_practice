public class Initilizer {   
    public static void InitDB(int argSize, BaseFileHandler argHandler){
        argHandler.Clear();
        List<Contact> DB = new List<Contact>();
        Random myRand = new Random();
        string tempID;
        string tempSecondName;
        string tempFirstName;
        string tempCommentary;
        int tempPhonesCount;
        int tempPhone;
        List<int> tempPhones = new List<int>();
        bool tempSex;


        if (argSize > 0) {
            for (int i = 0; i < argSize; i++) {
                tempPhones = new List<int>();
                tempID = String.Format("contact#{0}", i);
                tempSex = Convert.ToBoolean(myRand.NextInt64(0,2));
                if (tempSex) {
                    tempSecondName = HumanNames.maleSecondNames.ElementAt(myRand.Next(0, HumanNames.maleSecondNames.Count));
                    tempFirstName = HumanNames.maleFirstNames.ElementAt(myRand.Next(HumanNames.maleFirstNames.Count));
                } else {
                    tempSecondName = HumanNames.femaleSecondNames.ElementAt(myRand.Next(HumanNames.femaleSecondNames.Count));
                    tempFirstName = HumanNames.femaleFirstNames.ElementAt(myRand.Next(HumanNames.femaleFirstNames.Count));  
                }
                tempCommentary = String.Format("commentary for contact#{0}", i);

                tempPhonesCount = myRand.Next(1, 5);

                for (int j = 0; j < tempPhonesCount; j++) {
                    tempPhone = myRand.Next(30000, 32000);
                    tempPhones.Add(tempPhone);
                }
                DB.Add(new Contact(tempID, tempFirstName, tempSecondName, tempPhones, tempCommentary));
            }
        }
        foreach (Contact contact in DB) {
            argHandler.Insert(argHandler.Size(), argHandler.formData(contact));
        } 
    }
}
