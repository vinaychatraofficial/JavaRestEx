package test;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.db.model.Laptop;
import com.db.model.Student;
import com.db.model.Student1;

public class StudentMain {

	public static void main(String[] args) {
		//createStudents1();
		getStudent1();
	}
	
	private static void getStudent1() {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Query q = session.createQuery("select rollno,name from Student1 where rollno=:a");
		q.setParameter("a", 2);
		/*List<Student1> list = q.list();
		for(Student1 s:list) {
			System.out.println(s);
		}*/
		/*List<Object[]> students = q.list();
		for(Object[] student:students)
			System.out.println(student[0]+","+student[1]);*/
		Object[] student = (Object[]) q.uniqueResult();
		System.out.println(student[0]+","+student[1]);
		
		SQLQuery query = session.createSQLQuery("select * from student where marks>60");
		query.addEntity(Student1.class);
		List<Student1> st = query.list();
		
		for(Student1 s:st)
			System.out.println(s);
		
		SQLQuery query1 = session.createSQLQuery("select name,marks from student where marks>60");
		query1.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List students = query1.list();
		for(Object o:students) {
			Map m = (Map)o;
			System.out.println(m.get("name")+","+m.get("marks"));
		}
			
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
	
	private static void createStudents() {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Random r = new Random();
		
		for(int i=1;i<=50;i++) {
			Student1 s = new Student1();
			s.setRollno(i);
			s.setName("name "+i);
			s.setMarks(r.nextInt(100));
			session.save(s);
		}
		
		tx.commit();
	}

}
