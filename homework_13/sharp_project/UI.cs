
public class UI{
    public void userOut(String argMsg) {
        Console.WriteLine(argMsg);
    }

    public int userInputIntAck(String argMsg){
        bool valueBad = true;
        int tempOut = 0;
        string input;
        string key = "";
        while (valueBad){
            this.userOut(argMsg);
            input = $"{Console.ReadLine()}";
            try {
                tempOut = Convert.ToInt32(input);
                valueBad = false;
            } catch (Exception) {
                valueBad = true;
                this.userOut("Некорректный ввод");
            }

            if (!valueBad) {
                key = "";
                while (! key.ToLower().Equals("n") && ! key.ToLower().Equals("y")) {
                    this.userOut(argMsg);
                    this.userOut(String.Format("Вы ввели {0}, скорректировать ввод?\nY/N ?", tempOut));
                    key = $"{Console.ReadLine()}";
                    if (key.ToLower().Equals("y")) valueBad = true;
                }
            }

        }
        return tempOut;
    }

    public int userInputInt(String argMsg){
        bool valueBad = true;
        int tempOut = 0;
        string input;
        while (valueBad){
            this.userOut(argMsg);
            input = $"{Console.ReadLine()}";
            try {
                tempOut = Convert.ToInt32(input);
                valueBad = false;
            } catch (Exception) {
                valueBad = true;
                this.userOut("Некорректный ввод");
            }
        }
        return tempOut;
    }

    public String userInputStringAck(String argMsg){
        bool valueBad = true;
        string tempOut = "";
        string key = "";
        while (valueBad){
            this.userOut(argMsg);
            tempOut = $"{Console.ReadLine()}";
            valueBad = false;

            if (!valueBad) {
                key = "";
                while (! key.ToLower().Equals("n") && ! key.ToLower().Equals("y")) {
                    this.userOut(argMsg);
                    this.userOut(String.Format("Вы ввели {0}, скорректировать ввод?\nY/N ?", tempOut));
                    key = $"{Console.ReadLine()}";
                    if (key.ToLower().Equals("y")) valueBad = true;
                }
            }

        }
        return tempOut;
    }

}
