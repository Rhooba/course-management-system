public class User {
    protected String username;
    protected String name;
    protected String email;
    protected int PhoneNumber;

    public User(String username, String name, String email, int PhoneNumber) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.PhoneNumber = PhoneNumber;
    }

    public void enterUsername(String username) {
        this.username = username;
    }

    public void enterName (String name) {
        this.name = name;
    }

    public void enterEmail(String email) {
        this.email = email;
    }

    public void enterPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getName () {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int PhoneNumber() {
        return PhoneNumber;
    }

}