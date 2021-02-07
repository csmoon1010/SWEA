import java.util.Comparator;
import java.util.PriorityQueue;

class Student{
	String name;
	int grade;
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}
}

public class JavaQueue2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparator<Student> comp = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.grade - s2.grade;
			}
		};
		PriorityQueue<Student> pq = new PriorityQueue<>(comp);
		
		Student s1 = new Student("mhj", 90);
		Student s2 = new Student("kdy", 100);
		Student s3 = new Student("hrj", 50);
		Student s4 = new Student("mark", 70);
		
		pq.add(s1);
		pq.add(s2);
		pq.add(s3);
		pq.add(s4);
		for(Student s : pq) {
			System.out.println(s.name + " " + s.grade);
		}
	}

}
