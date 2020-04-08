import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;
    private String location;

    public Person(String name, int age, String location) {
        this.name = name;
        this.age = age;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\":\"" + name + '\"' +
                ", \"age\":" + age +
                ", \"location\":\"" + location + '\"' +
                '}';
    }
}
