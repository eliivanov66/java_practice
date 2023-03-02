import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Toyshop myToyShop = new Toyshop(10);
        BaseFileHandler myResult = new BaseFileHandler("gameResult.result");
        Menu myMenu = new Menu();
        Game myGame = new Game();

        myMenu.logic(myToyShop, myResult, myGame);
    }
}
