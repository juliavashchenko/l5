class TestTask extends Task{
    public TestTask() {
        super();
    }

    public TestTask(String name, String answer) {
        super(name, answer);
    }

    @Override
    protected String answer() {
        return Menu.SingLetterCheck("Уведіть літеру, що позначає правильний результат: ");
    }
}
