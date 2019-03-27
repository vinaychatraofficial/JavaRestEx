package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.db.model.Laptop;
import com.db.model.Student;

public class StudentMain {

	public static void main(String[] args) {
		getStudent();
	}
	
	private static void getStudent() {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Student student = (Student)session.get(Student.class, 100);
		for(Laptop l:student.getLaptop())
			System.out.println(l.getLname());
	}

	private static void createStudent() {
		Student student = new Student();
		student.setMarks(90);
		student.setName("Vinay");
		student.setRollno(100);
		
		Laptop laptop1 = new Laptop();
		laptop1.setLid(1);
		laptop1.setLname("Dell");
		laptop1.setStudent(student);
		//laptop1.getStudent().add(student);
		
		Laptop laptop2 = new Laptop();
		laptop2.setLid(2);
		laptop2.setLname("HP");
		laptop2.setStudent(student);
		//laptop2.getStudent().add(student);
		
		student.getLaptop().add(laptop1);
		student.getLaptop().add(laptop2);
		
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(laptop1);
		session.save(laptop2);
		session.save(student);
		
		tx.commit();
	}

}
