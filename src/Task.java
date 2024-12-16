import java.util.ArrayList;
import java.util.List;

public class Task {
    String name;
    Integer number;
    Integer grade;

    List<Task> tasks = new ArrayList<Task>();

    public Task(String text, int number, int grade) {
        this.name = text;
        this.number = number;
        this.grade = grade;
    }

    public void addTask(){
        //додавання завдання залежно від його типу
    }

    public void removeTask(){
        //видалення завдання за його номером
    }

    public void Grade(){
        //оцінювання завдання
    }

}
