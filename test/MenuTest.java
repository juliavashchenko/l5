import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

public class MenuTest {

    @Test
    void get_int_in_range() {
        // Введення валідного значення
        ByteArrayInputStream goodInput = new ByteArrayInputStream("5\n".getBytes());
        System.setIn(goodInput);
        assertEquals(5, Menu.get_int_in_range("", 1, 10));

        // Введення невалідних і валідного значень
        ByteArrayInputStream inputs = new ByteArrayInputStream(
                ("""
                0
                11
                invalid
                2
                """).getBytes());

        System.setIn(inputs);
        assertEquals(2, Menu.get_int_in_range("", 1, 10));

        // Відновлення стандартного введення
        System.setIn(System.in);
    }

    @Test
    void getTaskType() {
        // Введення валідного типу завдання
        ByteArrayInputStream input = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(input);
        assertEquals(2, Menu.getTaskType());

        System.setIn(System.in);
    }

    @Test
    void singleWordCheck() {
        // Введення валідного слова
        ByteArrayInputStream validInput = new ByteArrayInputStream("Word\n".getBytes());
        System.setIn(validInput);
        assertEquals("Word", Menu.SingleWordCheck("Enter a single word: "));

        // Введення невалідного слова і повторної спроби
        ByteArrayInputStream invalidInput = new ByteArrayInputStream(
                ("""
            Multiple Words
            ValidWord
            """).getBytes());
        System.setIn(invalidInput);
        assertEquals("ValidWord", Menu.SingleWordCheck("Enter a single word: "));

        System.setIn(System.in);
    }

    @Test
    void singleLetterCheck() {
        // Введення валідної літери
        ByteArrayInputStream validInput = new ByteArrayInputStream("A\n".getBytes());
        System.setIn(validInput);
        assertEquals("A", Menu.SingLetterCheck("Enter a single letter: "));

        // Введення невалідного символу і повторної спроби
        ByteArrayInputStream invalidInput = new ByteArrayInputStream(
                ("""
                AB
                C
                """).getBytes());
        System.setIn(invalidInput);
        assertEquals("C", Menu.SingLetterCheck("Enter a single letter: "));

        System.setIn(System.in);
    }
}
