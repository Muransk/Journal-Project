package com.journal.demojournal.Controllers;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journal.demojournal.Models.Student;
import com.journal.demojournal.dto.StudentDTO;
import com.journal.demojournal.services.StudentService;
import com.journal.demojournal.util.StudentErrorResponse;
import com.journal.demojournal.util.StudentNotCreatedException;
import com.journal.demojournal.util.StudentNotFoundException;

import jakarta.validation.Valid;


//             .\mvnw.cmd spring-boot:run
@RestController
@RequestMapping("/students")
public class StudentController 
{

     private final StudentService studentService;
     private final ModelMapper modelMapper;


    //рест хрень


    @Autowired
     public StudentController(StudentService studentService, ModelMapper modelMapper) {
        this.studentService = studentService;
        this.modelMapper = modelMapper;
    }


    @GetMapping()
    public List<StudentDTO> studentsIndex()
    {
        return studentService.findAll().stream().map(this::convertToStudentDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public StudentDTO showStudent(@PathVariable("id") int id)
    {
        return convertToStudentDTO(studentService.findOne(id));
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> create (@RequestBody @Valid StudentDTO studentDTO, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors){
                errorMessage.append(error.getField()).append(" - ")
                .append(error.getDefaultMessage())
                .append(" ; ");
            }
            throw new StudentNotCreatedException(errorMessage.toString());
        }
        
        studentService.save(convertToStudent(studentDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    // Обновление студена 

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> edit (@RequestBody @Valid StudentDTO studentDTO, BindingResult bindingResult,  @PathVariable("id") int id)
    {
        if (bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors){
                errorMessage.append(error.getField()).append(" - ")
                .append(error.getDefaultMessage())
                .append(" ; ");
            }
            throw new StudentNotCreatedException(errorMessage.toString());
        }
        
        studentService.update(id, convertToStudent(studentDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }


    

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){

        StudentErrorResponse response =  new StudentErrorResponse("Student not found!", 
        System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);//404

     

    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotCreatedException e){

        StudentErrorResponse response =  new StudentErrorResponse(e.getMessage(), 
        System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);//400
    }

    private Student convertToStudent (StudentDTO studentDTO){
        

        Student student = modelMapper.map(studentDTO, Student.class);


        return student;
    }


    private StudentDTO convertToStudentDTO(Student student){

        return modelMapper.map(student, StudentDTO.class);
    }

    
    // mvc хрень


   /*  
    @GetMapping()
    public String studentsIndex(Model model) 
    {
model.addAttribute("students", studentService.findAll());
        return "views/studentsIndex"; //как StudentIndex только вьюс
    }

    @GetMapping("/{id}")
    public String showStudent(@PathVariable("id") int id,Model model)
{
    model.addAttribute("student", studentService.findOne(id));
    return "views/studentDetails"; //StudentDetails = show
}
 

@GetMapping("/add") // new student
public String addStudent(@ModelAttribute("student") Student student)
{

    return "views/new";
}


@PostMapping()// для создания студента пост запрос
public String create(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult  )
{ if (bindingResult.hasErrors()) {
    return "views/new";
}
studentService.save(student);

return "redirect:/students";
}

@GetMapping("/{id}/edit")
public String edit(@PathVariable("id") int id, Model model)
{
    model.addAttribute("student", studentService.findOne(id));
    return "views/editStudent";
    
    
}

@PostMapping("/{id}")//раньше было PatchMapping, но не работает, поэтому сделал Пост
public String update(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult, @PathVariable("id") int id)
{
     if (bindingResult.hasErrors())
    {
        return "views/editStudent";
    }
   studentService.update(id, student);
   return "redirect:/students";
} 

@DeleteMapping("/{id}")
public String delete(@PathVariable("id") int id)
{
    studentService.delete(id);
    return "redirect:/students";
}*/
}
