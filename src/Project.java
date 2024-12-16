import java.util.ArrayList;

public class Project {
    public ArrayList<Task> tasks;

    public Project() {
        this.tasks = new ArrayList<>();
    }

    public Project(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void addTask() {

    }

    public void Grade() {
    }

    public void removeTask() {
    }
}