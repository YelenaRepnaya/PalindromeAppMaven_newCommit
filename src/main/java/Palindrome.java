import java.io.InputStream;

public class Palindrome {

    public int scorePalindrom(String word){
        int score=0;
        word = word.toLowerCase();
        char[] charMas = word.toCharArray();//-добавить проверку на пустую строку при вводе!!!
        if(charMas.length%2 == 0){
            for(int i = 0; i <= charMas.length/2-1; i++){
                if(charMas[i] != charMas[charMas.length-i-1]){
                    return 0;
                }else{
                    score = i+1;
                }
            }
            score = score*2;
        }else{
            for(int i = 0; i <= (charMas.length-1)/2-1; i++){
                if(charMas[i] != charMas[charMas.length-i-1]){
                    return 0;
                }else{
                    score = i+1;
                }
            }
            score = score*2+1;
        }
        return score;
    }
}
