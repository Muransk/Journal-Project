package com.journal.demojournal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journal.demojournal.Models.Student;
import com.journal.demojournal.repositories.StudentRepository; 

@Service
@Transactional(readOnly = true)
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findOne(int id){
        Optional<Student> foundStudent = studentRepository.findById(id); 
        return foundStudent.orElse(null);
    }
    

   
    
    @Transactional
    public void save(Student student){
        studentRepository.save(student);
    }

    @Transactional
    public void update(int id, Student updatedStudent){
        updatedStudent.setId(id);
        updatedStudent.setTotalSeminarsMark();//добавлено чтобы пересчитывало общую оценку
        studentRepository.save(updatedStudent);
    }

    @Transactional
    public void delete(int id){
        studentRepository.deleteById(id);
    }
}
