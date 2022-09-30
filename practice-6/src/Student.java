public class Student implements Comparable<Student>{
    private String name;
    private int id;
    private int gradePoints;

    @Override
    public int compareTo(Student o) {
        return this.getId() - o.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGradePoints() {
        return gradePoints;
    }

    public void setGradePoints(int gradePoints) {
        this.gradePoints = gradePoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(String name, int id, int gradePoints) {
        this.name = name;
        this.id = id;
        this.gradePoints = gradePoints;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", gradePoints=" + gradePoints +
                '}';
    }
}
