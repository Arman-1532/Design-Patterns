package learning.composite;

public class Main {
    public static void main(String[] args) {
        Course course = new Course();
        course.addComponent(new Quiz(10));
        course.addComponent(new Lesson(20));
        course.addComponent(new Project(45));
        course.addComponent(new Lesson(20));

        System.out.println("Total Course Duration: " + course.computeDuration() + " minutes");
    }
}
