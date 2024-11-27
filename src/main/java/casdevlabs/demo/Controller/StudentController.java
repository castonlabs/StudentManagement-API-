package casdevlabs.demo.Controller;

import casdevlabs.demo.Entity.Students;
import casdevlabs.demo.Repository.Studentrepository;
import casdevlabs.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Students> findAll() {
        List<Students> students = studentService.getAllStudents();
        return students;
    }

    @GetMapping("/students/{id}")
    public Students fingById(@PathVariable Long id) {
        Students students = studentService.getStudentById(id);

        return students;
    }

    //localhost:/students/ass
    @PostMapping("/students/add")
    public void addStudent(@RequestBody Students students) {
        studentService.addStudent(students);

    }


    // Method to delete all students
    @DeleteMapping("/deleteAll")
    public String deleteAllStudents() {
        // Call the service to delete all students
//            studentService.deleteAllStudents();
        return "All students have been deleted successfully.";

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
        try {
            studentService.deleteStudentById(id);
            return ResponseEntity.ok("Student with ID " + id + " has been deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Failed to delete student: " + e.getMessage());
        }

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStudent (@PathVariable Long id, @RequestBody Students updatedStudent){
        try {
            Students student = studentService.updateStudent(id, updatedStudent);
            return ResponseEntity.ok("Student with ID " + id + " has been updated successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Failed to update student: " + e.getMessage());

        }
    }
}









