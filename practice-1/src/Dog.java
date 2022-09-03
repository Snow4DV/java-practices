public class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog(String name) {
        this.name = name;
        this.age = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if(age < this.age || age < 0) {
            throw new IllegalArgumentException();
        }
        this.age = age;
    }

    public int getHumanizedAge() {
        return age*7;
    }

    @Override
    public String toString() {
        return "<Dog>\n" +
                "Name: " + name + '\n' +
                "Age: " + age + '\n';
    }
}
