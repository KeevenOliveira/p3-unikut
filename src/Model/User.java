package Model;

public class User extends Account{

    private int age;
    private String gender;
    private float hight;

    public User(String login, String name, String password, int age, String gender, float hight) {
        super(login, name, password);
        this.age = age;
        this.gender = gender;
        this.hight = hight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getHight() {
        return hight;
    }

    public void setHight(float hight) {
        this.hight = hight;
    }
}