package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.entities.Student;
import com.spring.jdbc.dao.StudentDao;


public class App 
{
    public static void main( String[] args )
    {
//        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao= context.getBean("studentDao",StudentDao.class);
       
//        Below code for insert the recored - start
        
//       Student student = new Student();
//       student.setId(2);
//       student.setName("Rohan");
//       student.setCity("Bangalore");
//       
//       int result = studentDao.insert(student);
//       System.out.println(result+" Recored inserted.... ");
        
//        Below code for insert the recored - end
        
//        Below code for update the recored - start
        
//        Student student = new Student();
//        student.setId(2);
//        student.setName("Ram");
//        student.setCity("Mumbai");
//        int result = studentDao.change(student);
//        System.out.println(result+" Recored updated...");
       
//        Below code for update the recored - end
        
//        Below code for delete the recored - start
        
//        Student student = new Student();
//        student.setId(2);
//        int result = studentDao.delete(student);
//        System.out.println(result+" Recored deleted...");
        
//        Below code for delete the recored - end
        
//        Below code for fetching single row the recored - start
        
//        Student student = studentDao.getStudent(1);
//        System.out.println(student);
        
//        Below code for fetching single row the recored - end
//        Below code for fetching multiple row the recored - start
        
        List<Student> student = studentDao.getAllStudent();
        
        for(Student s: student) {
        	System.out.println(s);
        }
        
//        Below code for fetching multiple row the recored - end
       
        
    }
}
