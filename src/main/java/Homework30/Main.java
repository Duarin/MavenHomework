package Homework30;
public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        Student student = new Student("John", "Doe", "john@example.com");
        studentDao.save(student);

        System.out.println(studentDao.findAll());
    }
}
