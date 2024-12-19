import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class ProjectTest {

    @Test
    public void testAddTasksToProject() {
        // Create a new Project instance
        Project project = new Project();

        // Create two tasks and add them to the project
        Task task1 = new TestTask("Task 1", "dgsg");
        Task task2 = new ShortAnswerTask("Task 2", "Short Answer");
        project.tasks.add(task1);
        project.tasks.add(task2);

        // Assert that the size of the task list is correct
        assertEquals(2, project.tasks.size(), "The number of tasks should be 2");

        // Assert that the names of the tasks are correct
        assertEquals("Task 1", project.tasks.get(0).name, "The first task should be 'Task 1'");
        assertEquals("Task 2", project.tasks.get(1).name, "The second task should be 'Task 2'");
    }

    @Test
    public void testDisplayProject() {
        // Create a new Project instance
        Project project = new Project();

        // Add tasks to the project
        Task task1 = new TestTask("Task 1", "dgsg");
        Task task2 = new ShortAnswerTask("Task 2", "Short Answer");

        project.tasks.add(task1);
        project.tasks.add(task2);

        // Capture console output
        var outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));

        // Call the display_project() method
        project.display_project();

        // Assert that the output contains the task names
        String output = outputStream.toString();
        assertTrue(output.contains("Task 1"), "Output should contain 'Task 1'");
        assertTrue(output.contains("Task 2"), "Output should contain 'Task 2'");

        // Reset the console output
        System.setOut(System.out);
    }
}