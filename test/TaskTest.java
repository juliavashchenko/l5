import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    private ArrayList<Task> tasks;

    @BeforeEach
    void setUp() {
        tasks = new ArrayList<>();
    }

    private void provideInput(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }
    @Test
    void testAddMainTask() {
        Task testTask = new TestTask("Test Answer", "ghf");
        tasks.add(testTask);

        assertEquals(1, tasks.size());
        assertEquals("Test Answer", testTask.name);
        assertEquals("ghf", testTask.answer);
    }

    @Test
    void testAddSubtask() {
        Task mainTask = new TestTask("ffs", "dgsg");

        Task subTask = new ShortAnswerTask("sub", "Short Answer");

        mainTask.subtasks.add(subTask);

        assertEquals(1, mainTask.subtasks.size());
        assertEquals("Short Answer", subTask.answer);
        assertEquals("sub", subTask.name);
    }

    @Test
    void testRemoveMainTask() {
        Task task1 = new TestTask("ffs", "dgsg");
        Task task2 = new ShortAnswerTask("sub", "Short Answer");

        tasks.add(task1);
        tasks.add(task2);

        tasks.remove(0);

        assertEquals(1, tasks.size());
    }

    @Test
    void testMenuSingleWordCheck() {
        // Имитация ввода одного слова "Hello"
        provideInput("Hello\n");

        String result = Menu.SingleWordCheck("Введите одно слово: ");
        assertEquals("Hello", result);
    }

    @Test
    void testMenuSingleLetterCheck() {
        // Имитация ввода одной буквы "A"
        provideInput("A\n");

        String result = Menu.SingLetterCheck("Введите одну букву: ");
        assertEquals("A", result);
    }

    @Test
    void testDisplayNestedTasks() {
        Task mainTask = new TestTask("sub", "Short Answer");
        Task subTask1 = new ShortAnswerTask("sub", "Short Answer");
        Task subTask2 = new LongAnswerTask("sub", "Short Answer");

        mainTask.subtasks.add(subTask1);
        mainTask.subtasks.add(subTask2);
        tasks.add(mainTask);

        Task.display(tasks);

        assertEquals(1, tasks.size());
        assertEquals(2, tasks.get(0).subtasks.size());
    }

}
