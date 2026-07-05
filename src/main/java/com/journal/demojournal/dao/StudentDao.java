package com.journal.demojournal.dao;

//import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.hibernate.SessionFactory;
//import org.hibernate.Session;

//import com.journal.demojournal.Models.Student;

//import jakarta.transaction.Transactional;

@Component
public class StudentDao 
{
  /*   //private final JdbcTemplate jdbcTemplate;
    private final SessionFactory sessionFactory;
    @Autowired
    public StudentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    

    //@Autowired
    //public StudentDao(JdbcTemplate jdbcTemplate) {
   //     this.jdbcTemplate = jdbcTemplate;
    //}

    @Transactional
    public List<Student> studentsIndex(){
        //return jdbcTemplate.query("SELECT * FROM student",new BeanPropertyRowMapper<>(Student.class));
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("SELECT s FROM Student s", Student.class).getResultList();

        

    }
    @Transactional(readOnly = true)
    public Student showStudent(int id)
    {
        //return jdbcTemplate.query("SELECT * FROM student WHERE id=?", new Object[]{id},new BeanPropertyRowMapper<>(Student.class)).stream().findAny().orElse(null);
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    
    } //почему get зачеркнут?

    @Transactional
     public void save(Student student)
     {
        //jdbcTemplate.update("INSERT INTO student(name, surname) VALUES(?,?)",student.getName(),student.getSureName());
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Transactional
     public void update(int id, Student updatedStudent){
        //jdbcTemplate.update("UPDATE student SET name=?, surname=? WHERE id=?",updatedStudent.getName(),updatedStudent.getSureName(),id);
        Session session = sessionFactory.getCurrentSession();

        Student studentToBeUpdated = session.get(Student.class, id);

        studentToBeUpdated.setName(updatedStudent.getName());
        studentToBeUpdated.setSureName(updatedStudent.getSureName());
    }

    @Transactional
     public void delete(int id){
       // jdbcTemplate.update("DELETE FROM student WHERE id=?",id);  
       Session session = sessionFactory.getCurrentSession(); 
       session.remove(session.get(Student.class, id));   
       
    }*/


    //=============================================================================
    /*private static final String URL = "jdbc:postgresql://localhost:5432/Journalbd";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "sastp31256*@1wsq";

    

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Student> studentsIndex() 
    {
        List<Student> students = new ArrayList<>();
          try {
        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM Student";
        ResultSet resultSet= statement.executeQuery(SQL);
        while(resultSet.next())
        {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setSureName(resultSet.getString("sureName"));
        }

          } catch (SQLException throwables) 
          {
            throwables.printStackTrace();
          }
          return students;
    }  
    public Student showStudent(int id)
    {
        return null;
    }



    public void save (Student student) 
    {

    
    }

    public void update(int id, Student updatedStudent) 
    {

    
    }

    public void delete(int id) 
    {

    
    }*/
}
