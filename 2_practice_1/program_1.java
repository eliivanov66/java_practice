
public class program_1 {
    public static void main(String[] args) {

        String varString = "Monkey";
        String[] varArray = {"Monkeyzas", "Monke", "Mok", "eMonkey", "Monkey"};
        for (int index = 0; index < varArray.length; index++) {
            
            int out_value = varArray[index].compareToIgnoreCase(varString);
            if (out_value == 0){
                ;
            }

        }

    }
}
