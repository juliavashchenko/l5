public class Main {
    public static void main(String[] args) {
        //задання початкових завдань для проєкту
        Task task1 = new Task("Дослідження властивостей води", 0, 1);
        Task task2 = new Task("Дослідження властивостей металу", 0, 1);
        Task task3= new Task("Дослідження властивостей скла", 0, 1);
        //створення проєкту, який складається з деяких завдань

        Project project = new Project();
        project.addTask(task1);
        project.addTask(task2);
        project.addTask(task3);

        //вибір користувачем, яку треба зробити з проєктом
        int ch = Menu.ActionSelection();

        switch (ch) {
            //додавання завдання до проєкту
            case 1: project.addTask();
                break;
            //видалення завдання за його номером
            case 2: project.removeTask();
                break;
            //оцінювання проєкту
            case 3: project.Grade();
                break;
            case 0:
        }



    }
}