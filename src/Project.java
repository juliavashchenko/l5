import java.util.ArrayList;


public class Project {
    ArrayList<Task> tasks = new ArrayList<Task>();

    public Project() {
        this.tasks = new ArrayList<>();
    }


    public void display_project(){
        System.out.println("\nСписок завдань у проєкті:");
        Task.display(tasks);

    }


}


