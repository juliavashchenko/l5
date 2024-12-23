 class LongAnswerTask extends TestTask {
     public LongAnswerTask() {
         super();
     }

     public LongAnswerTask(String name, String answer) {
         super(name, answer);
     }
     @Override
     public String answer() {
         System.out.println("Введіть примітку до завдання(крапку, якщо приміток немає): ");
         return System.console().readLine();

     }
 }
