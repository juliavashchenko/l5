
import java.util.Scanner;

public interface Menu {

         static int get_int_in_range(String prompt, int min, int max) {
            int x;
            Scanner sc = new Scanner(System.in);

            while (true)
                try {
                    System.out.print(prompt);
                    x = Integer.parseInt(sc.nextLine().trim());

                    if ((x < min) || (x > max)) {
                        System.out.printf("\nБудь ласка, уведіть число в межах від %d до %d!\n\n", min, max);
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Неправильне введення! Спробуйте ще раз: ");
                }

            return x;
        }
     static int getTaskType(){
        int tptsk = Menu.get_int_in_range("""
                Оберіть тип завдання, яке ви хочете додати:
                
                1. Тестове завдання
                2. Завдання з короткою відповіддю
                3. Завдання з розгорнутою відповіддю
                
                Введіть опцію:
                """, 1, 3);
         return tptsk;
     }

    static String SingleWordCheck(String prompt) {
        String input;
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);

        while (true) {
            try {
                input = scanner.nextLine().trim();

                String[] words = input.split("\\s+");
                if (words.length == 1) {
                    return input;
                } else {
                    System.out.println("Рядок містить більше ніж одне слово. Спробуйте ще раз.");
                }
            } catch (Exception e) {
                System.out.println("Помилка введення! Будь ласка, спробуйте ще раз.");
            }
        }
    }

    static String SingLetterCheck(String prompt) {
        String l;
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {

                l = sc.nextLine().trim();
                l = l.trim();
                if (l.length() == 1) {
                    return l; //Якщо одна літера, повертаємо результат
                } else {
                    System.out.println("Введено більше ніж одна літера! Спробуйте ще раз.");
                }
            } catch (NullPointerException e) {
                System.out.println("Помилка введення! Будь ласка, спробуйте ще раз.");
            }
        }
    }

    }

