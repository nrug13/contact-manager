package entity;


public class Contact {
    private String name;
    private String surname;
    private int id;
    private String number;
    private String email;

    // get-set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /// constructors

    public Contact() {

    }

    public Contact(int id, String name, String number) {
        this.name = name;
        this.id = id;
        this.number = number;
    }

    public Contact(String name, String surname, int id, String number, String email) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.number = number;
        this.email = email;
    }

    @Override
    public String toString() {

        return "\n" + "id " + id + "\n" + "number " + number + "\n" + "name " + name + "\n" + "_________________";
    }

}
