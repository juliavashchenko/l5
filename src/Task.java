import java.util.ArrayList;

abstract class Task {
    String name;
    String answer;

    ArrayList<Task> subtasks = new ArrayList<Task>();


    public Task() {
        this.name = AddTextOfTask();
        this.answer = answer();
        this.subtasks = new ArrayList<>();
    }

    public Task(String name, String answer) {
        this.name = name;
        this.answer = answer;
        this.subtasks = new ArrayList<>();
    }

    public static String AddTextOfTask(){
        System.out.println("Опишіть завдання: ");
        return System.console().readLine();
    }

    abstract String answer();

    public static void addTask(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            add_task_ask_of_type(tasks);
            return;
        }

        int ch = Menu.get_int_in_range("""
            
            1) Додати головне завдання.
            2) Додати підзавдання.
            
            Оберіть опцію:""", 1, 2);

        switch (ch) {
            case 1:
                add_task_ask_of_type(tasks);
                break;
            case 2:
                display(tasks);
                int ts = Menu.get_int_in_range("Уведіть номер завдання, до якого хочете додати підзавдання: ", 0, tasks.size());
                addTask(tasks.get(ts - 1).subtasks);
                break;
        }

    }
    public static void removeTask(ArrayList<Task> tasks) {
        int number_of_maintask;
        if (tasks.isEmpty()) {
            System.out.println("Список завдань порожній. Немає чого видаляти.");
            return;
        }

        display(tasks);

        int ch = Menu.get_int_in_range("""
                
                1. Видалити головне завдання.
                2. Видалити підзавдання.
                
                Оберіть опцію:""", 1, 2);

        number_of_maintask = Menu.get_int_in_range("\nВиберіть завдання: ", 0, tasks.size());
        switch (ch) {
            case 1:
                tasks.remove(number_of_maintask- 1);
                break;
            case 2:
                removeTask(tasks.get(number_of_maintask-1).subtasks);
                break;
        }

    }

public static void add_task_ask_of_type(ArrayList<Task> tasks){
    int tp = Menu.getTaskType();
    switch (tp){
        case 1:
            Task test_task = new TestTask();
            tasks.add(test_task);
            break;
        case 2:
            Task short_answer_task  = new ShortAnswerTask();
            tasks.add(short_answer_task );
            break;
        case 3:
            Task long_answer_task  = new LongAnswerTask();
            tasks.add(long_answer_task );
            break;
    }
}

    public static void display(ArrayList<Task> tasks) {
        display(tasks, 0);
    }

    private static void display(ArrayList<Task> tasks, int num){
        if (tasks.isEmpty() && num == 0) {
            System.out.println("Список завдань порожній.");
        } else if (!tasks.isEmpty()){
            for (Task task : tasks){
                System.out.println( ("\t".repeat(num)) + (tasks.indexOf(task)+1) + ". "  + task.name);
                if (!task.subtasks.isEmpty()){
                    display(task.subtasks, num +1);
                }
            }
        }

    }



}
