class ShortAnswerTask extends Task {
    public ShortAnswerTask() {
        super();
    }

    public ShortAnswerTask(String name, String answer) {
        super(name, answer);
    }


    @Override
    protected String answer(){
        return Menu.SingleWordCheck("Введіть правильну відповідь (не більше ніж одне слово: ");
    }


}
