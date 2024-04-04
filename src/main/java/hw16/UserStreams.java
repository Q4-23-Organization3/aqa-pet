package hw16;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class UserStreams {

    private final static String[] firstNames = {
            "Octavius", "Chase", "Jada", "Kennan", "Mari", "Whitney", "Guinevere",
            "Jenette", "Giacomo", "Stewart", "Eliana", "Kaye", "Lane", "Laith", "Jolene",
            "Kristen", "Iola", "Jesse", "Miriam", "Cleo", "Charissa", "Brian", "Joan",
            "Signe", "Cassandra", "Zenaida", "Randall", "Wayne", "Marvin", "Dorian",
            "Brock", "Lunea", "Arthur", "Kaitlin", "Maite", "Cheryl", "Griffin", "Medge",
            "Lenore", "Iliana", "Chase", "Pamela", "Stella", "Plato", "Wang", "Mary",
            "Clementine", "Serina", "Brock", "Stewart", "Alden", "Jesse", "Cara",
            "Kylan", "Yvette", "Brennan", "Basia", "Cheryl", "Joseph", "Avram",
            "Walter", "Mufutau", "Marvin", "Sade", "Jaime", "Dominic", "Eve",
            "Timon", "Garth", "Yael", "Dillon", "Hilel", "Bo", "Anastasia",
            "Tobias", "Harlan", "Alexa", "Jescie", "Hayden", "Jaime", "Wilma",
            "Jerry", "Henry", "Hedy", "Lacota", "Zelenia", "Ariana", "Sawyer"
    };
    private final static String[] secondNames = {
            "Riggs", "Mckenzie", "Robles", "Rosario", "Johnston",
            "Pierce", "Bridges", "Nelson", "Gonzalez", "Spence", "Armas",
            "Ochoa", "Small", "Archy"
    };

    public static void main(String[] args) {
        //a
        ArrayList<User> users = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int age = i + random.nextInt(70) + 1;
            String name = firstNames[random.nextInt(firstNames.length - 1)];
            String secondName = secondNames[random.nextInt(secondNames.length - 1)];
            users.add(new User(name, secondName, age));
        }
        System.out.println("Initial users list");
        System.out.println(users);
    }

    public ArrayList<User> sortByAge(ArrayList<User> users) {
        // b
        ArrayList<User> newUsers = new ArrayList<>(
                users.stream().sorted(Comparator.comparingInt(User::getAge)).toList()
        );
        System.out.println("Users sorted by age");
        System.out.println(newUsers);
        return newUsers;
    }

    public int calculateAverageAge(ArrayList<User> users) {
        // c
        int averageAge = (int) users.stream().mapMultiToInt(
                (user, consumer) -> consumer.accept(user.getAge())
        ).average().getAsDouble();
        System.out.println("Average age of users: " + averageAge);
        return averageAge;
    }

    public List<User> sortByFirstNameAndAge(ArrayList<User> users) {
        // d
        List<User> sortedUsers = users.stream()
                .sorted(Comparator.comparing(User::getFirstName))
                .sorted(Comparator.comparingInt(User::getAge))
                .toList();
        System.out.println("Users sorted by name and age");
        System.out.println(sortedUsers);
        return sortedUsers;
    }

    public boolean searchByLastNameFirstLetter(ArrayList<User> users) {
        // e
        boolean hasSecondNames = users.stream().anyMatch(
                user -> user.getSecondName().startsWith("S") ||
                        user.getSecondName().startsWith("A")
        );
        System.out.println("Any second name starts with A or S: " + hasSecondNames);
        return hasSecondNames;
    }

    public boolean checkIsAdult(ArrayList<User> users) {
        // f
        boolean isAllAdults = users.stream().allMatch(user -> user.getAge() >= 18);
        System.out.println("All users are adults: " + isAllAdults);
        return isAllAdults;
    }
}


