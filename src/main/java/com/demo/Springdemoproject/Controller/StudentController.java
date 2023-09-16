package com.demo.Springdemoproject.Controller;

import com.demo.Springdemoproject.Pojo.Student;
import com.demo.Springdemoproject.Service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/students")
    public String getAllStudents(Model model){
        model.addAttribute("students" , studentService.getAllStudents());
        return "students";
    }

    @GetMapping(path = "/students/new")
    public String createStudentForm(Model model){
        //create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping(path="students/edit/{id}")
    public String editStudentForm(@PathVariable Integer id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        System.out.println(studentService.getStudentById(id).getFirstName());
        return "edit_student";
    }

    @PostMapping(path = "/students/{id}")
    public String updateStudent(@PathVariable Integer id, @ModelAttribute("student") Student student, Model model) {
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setCgpa(student.getCgpa());

        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping (path = "/students/delete/{id}")
    public String deleteStudentRequest(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

}
