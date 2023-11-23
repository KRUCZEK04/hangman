package wisielec;

public class Password implements WordProvider {
    private String value;

    public Password(String value) {
        this.value = value;
    }

    @Override
    public String getPassword() {
        //TODO: Get value from file
        return value;
    }

}
