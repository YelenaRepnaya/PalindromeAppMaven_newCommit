import java.awt.List;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static java.lang.System.*;


public class Main {
    static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e2.getValue().compareTo(e1.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );

        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    public static void main(String[] args) throws IOException {
        Map<String, Integer> rating = new TreeMap<String, Integer>();
        Map<String, User> users = new HashMap<String, User>();
        boolean stop;
        boolean kill = false;
        boolean changeUser;
        String stopApp = "стоп";
        String change = "user";
        String killApp = "kill";
        while (!kill) {
            stop = true;
            changeUser = true;
            System.out.println("Введите имя пользователя: ");
                Scanner sc = new Scanner(System.in);
                String name = sc.nextLine().replaceAll("\\s+", "");
                if (name.equals(killApp))
                    System.exit(0);
                else {
                    while (changeUser) {
                        stop = true;
                        changeUser = true; //kill = false;
                        if (!name.equals(change)) {
                            if (name.length() != 0) {

                                    Palindrome app = new Palindrome();
                                    while (stop) {
                                        String word = "";
                                        if (users.containsKey(name)) {
                                            System.out.println("Введите слово: ");
                                            Scanner scan = new Scanner(System.in);
                                            word = scan.nextLine().replaceAll("\\s+", "");
                                            if (!word.equals(change)) {
                                                if (!word.equals(stopApp) && !word.equals(killApp)) {
                                                    if (word.length() > 2) {
                                                        if (!users.get(name).checkWord(word)) {
                                                            int score = app.scorePalindrom(word);
                                                            users.get(name).moveScore(score, word);
                                                            rating.put(name, users.get(name).getScores());

                                                            System.out.println("Ваш результат:" + users.get(name).getFirstName() + ":" + "Баллы- " + users.get(name).getScores());
                                                            System.out.println("Топ 5 рейтинга:");
                                                            System.out.println(entriesSortedByValues(rating));
                                                            System.out.println("Чтобы закончить игру введите: стоп");
                                                            System.out.println("Выйти: kill");
                                                        } else {
                                                            System.out.println("Такое слово уже было!");
                                                            System.out.println("Чтобы закончить игру введите: стоп");
                                                            System.out.println("Выйти: kill");
                                                        }
                                                    } else {
                                                        System.out.println("Ошибка! Введите слово");
                                                        System.out.println("Чтобы закончить игру введите: стоп");
                                                        System.out.println("Выйти: kill");
                                                    }
                                                } else {
                                                    if (word.equals(stopApp)) {
                                                        stop = false;
                                                        System.out.println("Игра закончена.");
                                                        System.out.println("Выйти: kill");
                                                        changeUser = false;
                                                    } else {
                                                        stop = false;
                                                        kill = true;
                                                        System.exit(0);
                                                    }
                                                }
                                            } else {
                                                stop = false;
                                                changeUser = false;
                                            }
                                        } else {
                                            users.put(name, new User(name, 0, ""));
                                            System.out.println("Мы вас не узнали! Пользователь " + name + " зарегистрирован.");
                                            rating.put(name, 0);
                                            System.out.println();
                                            System.out.println("Чтобы закончить игру введите: стоп");
                                        }
                                        System.out.println("Сменить пользователя введите: user");
                                    }

                            } else System.out.println("Ошибка! Введите имя");
                        } else {
                            changeUser = false;
                            System.out.println("Игра закончена.");
                        }
                    }
                }
        }
    }
}
