package com.journal.demojournal.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.journal.demojournal.Models.Student;
import com.journal.demojournal.services.StudentService;

import jakarta.validation.Valid;
//             .\mvnw.cmd spring-boot:run
@Controller
@RequestMapping("/students")
public class StudentController 
{


    //private final StudentDao studentDao;

    private final StudentService studentService;

     public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
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
}
}
