import java.util.ArrayList;

public class User {
    private String firstName;
    private int scores;
    private ArrayList<String> words;
    // private int place;

    public User(String name) {
        this.firstName = name;
    }
    public User(String name, int score, String answer) {
        this.firstName = name;
        this.scores = score;
        ArrayList<String> answers = new ArrayList<>();
        answers.add(answer);
        this.words = answers;
        //this.place=place;
    }

    public String getFirstName() {
        return firstName;
    }
    public int getScores() {
        return scores;
    }

    public String getWords () {
        for (int i = 0; i < words.size(); i++) {
                return words.get(i);
        }
        return null;
    }
    public void moveScore (int score,String word) {
        if (score!=0) {
            scores += score;
            words.add(word);
        }
    }
    public boolean checkWord (String word) {
        if (words.contains(word)) {
            return true;
        }else return false;
    }

}

