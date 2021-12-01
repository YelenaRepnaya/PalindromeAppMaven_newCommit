import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import static java.lang.System.*;


public class Main {
    public static void main(String[] args) throws IOException {

        User user = new User();
        /*LinkedList <Integer> userApp = new LinkedList<>();
        userApp = user.createUser(0,0);*/

        Palindrome app = new Palindrome();
         String word = System.in.toString();
         word = "fggf";
        if (word.length() > 2) {
            user.moveScore(0,app.scorePalindrom(word));
            System.out.println(user.checkScore(0));
        }
        else System.out.println ("Ошибка! Введите слово");
    }


}
