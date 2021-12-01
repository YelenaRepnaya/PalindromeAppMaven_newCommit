import java.util.LinkedList;

public class User {
    LinkedList <Integer> user = new LinkedList<>();
    public LinkedList<Integer> createUser(int id, int score) {
        //LinkedList <Integer> user = new LinkedList<>();
        user.add(id,score);
        //list.add(user);
        return null;
    }
    public void moveScore ( int id,int score) {
        user.set(id,user.get(id)+score);
    }
    public int checkScore (int id){
        return user.get(id);
    }
}
