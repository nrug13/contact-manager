package entity;

public class Contact {
    private String name;
    private int id;
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Contact() {

    }

    public Contact(int id, String name, String number) {
        this.name = name;
        this.id = id;
        this.number = number;
    }

    @Override
    public String toString() {

        return "\n" + "id " + id + "\n" + "number " + number + "\n" + "name " + name + "\n" + "_________________";
    }

}
