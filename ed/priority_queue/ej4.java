package priority_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ej4 {
    public static void main(String[] args) {
        Selection s0 = new Selection(
                new ArrayList<>(
                        List.of(
                                new Student("a", 1, 100),
                                new Student("a", 1, 120),
                                new Student("a", 1, 130)
                        )
                ),
                new ArrayList<>(
                        List.of(
                                new Course(2, new ArrayList<>()),
                                new Course(3, new ArrayList<>()),
                                new Course(1, new ArrayList<>())
                        )
                )
        );

        s0.register(new Student("b", 1, 120));
        s0.register(new Student("c", 1, 90));
        s0.register(new Student("d", 1, 150));
        s0.register(new Student("e", 1, 80));
        s0.register(new Student("f", 1, 110));
    }
}

class Selection {
    protected List<Student> friends;
    protected List<Course> courses;

    public Selection(List<Student> friends, List<Course> courses) {
        this.friends = friends;
        this.courses = courses;
    }

    public void register(Student e) {
        PriorityQueue<Course> courseWithPriority = new PriorityQueue<>(courses);
        Course course = courseWithPriority.poll();
        assert course != null;
        course.enrolled.add(e);
    }

//    public List<Course> selectedCourses() {
//        PriorityQueue<Course> courseWithPriority = new PriorityQueue<>(courses);
//
//        for (Student friend : friends) {
//            Course c1 = courseWithPriority.poll();
//            Course c2 = courseWithPriority.poll();
//            Course c3 = courseWithPriority.poll();
//
//            c1.enrolled.add(friend);
//            c2.enrolled.add(friend);
//            c3.enrolled.add(friend);
//
//            courseWithPriority.add(c1);
//            courseWithPriority.add(c2);
//            courseWithPriority.add(c3);
//        }
//    }
}


class Student {
    protected String name;
    protected int age;
    protected int IQ;

    public Student(String name, int age, int IQ) {
        this.name = name;
        this.age = age;
        this.IQ = IQ;
    }
}

class Course implements Comparable<Course> {
    protected int ID;
    protected List<Student> enrolled;

    public Course(int ID, List<Student> enrolled) {
        this.ID = ID;
        this.enrolled = enrolled;
    }

    private int calculateScore(Course course) {
        int size = course.enrolled.size();

        int lastIQ = size - 1 > 0
                ? course.enrolled.get(size - 1).IQ
                : 0;
        int previousIQ = size - 2 > 0
                ? course.enrolled.get(size - 2).IQ
                : 0;

        return size * (previousIQ + lastIQ);
    }

    @Override
    public int compareTo(Course course) {
        int score1 = calculateScore(this);
        int score2 = calculateScore(course);

        return score1 != score2
                ? score1 - score2
                : this.ID - course.ID;
    }
}




