
public class Main {
        public static void main(String[] args) {
            Project project = new Project();

            int ch;

            do {

                ch = Menu.get_int_in_range(""" 
                
                 1. Додати завдання до проєкту.
                 2. Видалити завдання.
                 3. Вивести завдання проєкту.
                 
                 0. Завершити виконання програми.
                 Введіть число:""", 0, 4 );

                switch (ch) {
                    case 1:
                        Task.addTask(project.tasks);
                        break;

                    case 2:
                        Task.removeTask(project.tasks);
                        break;

                    case 3:
                        project.display_project();
                        break;
                }

            } while (ch != 0);
        }
    }


