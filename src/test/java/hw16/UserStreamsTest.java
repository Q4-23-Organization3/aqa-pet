package hw16;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class UserStreamsTest {

    private static ArrayList<User> users = new ArrayList<>();
    private static UserStreams streams;

    @BeforeAll
    static void setUp() {
        streams = new UserStreams();
    }

    @BeforeEach
    void prepareData() {
        users.add(new User("Andrii", "Shevchenko", 10));
        users.add(new User("Artem", "Shevchenko", 12));
        users.add(new User("Boris", "Sirko", 24));
        users.add(new User("Bohdan", "Arik", 9));
    }

    @AfterEach
    void cleanUp() {
        users.clear();
    }

    @Test
    void sortByAgeTest() {
        ArrayList<User> expected = new ArrayList<>();
        expected.add(new User("Bohdan", "Arik", 9));
        expected.add(new User("Andrii", "Shevchenko", 10));
        expected.add(new User("Artem", "Shevchenko", 12));
        expected.add(new User("Boris", "Sirko", 24));
        ArrayList<User> actual = streams.sortByAge(users);
        for (int i = 0; i < actual.size(); i++) {
            Assertions.assertEquals(actual.get(i).getAge(), expected.get(i).getAge());
        }
    }

    @Test
    void sortByAgeTestWithAdd() {
        ArrayList<User> expected = new ArrayList<>();
        expected.add(new User("Oleg", "Jonson", 8));
        expected.add(new User("Bohdan", "Arik", 9));
        expected.add(new User("Andrii", "Shevchenko", 10));
        expected.add(new User("Artem", "Shevchenko", 12));
        expected.add(new User("Boris", "Sirko", 24));

        users.add(new User("Oleg", "Jonson", 8));

        ArrayList<User> actual = streams.sortByAge(users);
        for (int i = 0; i < actual.size(); i++) {
            Assertions.assertEquals(actual.get(i).getAge(), expected.get(i).getAge());
        }
    }

    @Test
    void calculateAverageAgeTest() {
        int expected = 13;
        int actual = streams.calculateAverageAge(users);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void calculateAverageAgeNotZeroTest() {
        int actual = streams.calculateAverageAge(users);
        Assertions.assertTrue(actual > 0);
    }

    @Test
    void sortByNameAndAgeTest() {
        ArrayList<User> expected = new ArrayList<>();
        expected.add(new User("Bohdan", "Arik", 9));
        expected.add(new User("Andrii", "Shevchenko", 10));
        expected.add(new User("Artem", "Shevchenko", 12));
        expected.add(new User("Boris", "Sirko", 24));
        List<User> actual = streams.sortByFirstNameAndAge(users);
        for (int i = 0; i < actual.size(); i++) {
            Assertions.assertEquals(actual.get(i).getAge(), expected.get(i).getAge());
            Assertions.assertEquals(actual.get(i).getFirstName(), expected.get(i).getFirstName());
        }
    }

    @Test
    void sortByNameAndAgeSameNamesTest() {
        ArrayList<User> expected = new ArrayList<>();
        expected.add(new User("Bohdan", "Arik", 9));
        expected.add(new User("Andrii", "Shevchenko", 10));
        expected.add(new User("Boris", "Fork", 11));
        expected.add(new User("Artem", "Shevchenko", 12));
        expected.add(new User("Boris", "Sirko", 24));
        users.add(new User("Boris", "Fork", 11));
        List<User> actual = streams.sortByFirstNameAndAge(users);
        for (int i = 0; i < actual.size(); i++) {
            Assertions.assertEquals(actual.get(i).getAge(), expected.get(i).getAge());
            Assertions.assertEquals(actual.get(i).getFirstName(), expected.get(i).getFirstName());
        }
    }

    @ParameterizedTest
    @MethodSource("listProviderFactory")
    void searchByLastNameFirstLetterTest(ArrayList<User> list) {
        Assertions.assertTrue(streams.searchByLastNameFirstLetter(list));
    }

    @Test
    void searchByLastNameFirstLetterWithoutATest() {
        users.remove(users.size() - 1);
        Assertions.assertTrue(streams.searchByLastNameFirstLetter(users));
    }
    @Test
    void searchByLastNameFirstLetterTest() {
        ArrayList<User> expected = new ArrayList<>();
        expected.add(new User("Bohdan", "Kovs", 18));
        expected.add(new User("Andrii", "Lutko", 19));
        Assertions.assertFalse(streams.searchByLastNameFirstLetter(expected));
    }

    @Test
    void checkIsAdultTest() {
        ArrayList<User> expected = new ArrayList<>();
        expected.add(new User("Bohdan", "Arik", 18));
        expected.add(new User("Andrii", "Shevchenko", 19));
        expected.add(new User("Boris", "Fork", 22));
        expected.add(new User("Artem", "Shevchenko", 37));
        expected.add(new User("Boris", "Sirko", 54));
        boolean actual = streams.checkIsAdult(expected);
        Assertions.assertTrue(actual);
    }
    @Test
    void checkIsMinorTest() {
        boolean actual = streams.checkIsAdult(users);
        Assertions.assertFalse(actual);
    }

    static Stream<ArrayList<User>> listProviderFactory() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("Bohdan", "Arik", 9));
        list.add(new User("Andrii", "Shevchenko", 10));
        list.add(new User("Artem", "Shevchenko", 12));
        list.add(new User("Boris", "Sirko", 24));
        return Stream.of(users, list);
    }
}