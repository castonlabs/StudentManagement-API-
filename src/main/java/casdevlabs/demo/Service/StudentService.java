package casdevlabs.demo.Service;
import casdevlabs.demo.Entity.Students;
import casdevlabs.demo.Repository.Studentrepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

    @Service
    public class StudentService {

        @Autowired
        private Studentrepository studentrepository;

        // Retrieve all students
        public List<Students> getAllStudents() {
            return studentrepository.findAll();
        }

        // Retrieve a student by ID
        public Students getStudentById(Long id) {
            return studentrepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
        }


        // Add a new student
        public void addStudent(Students student) {

            studentrepository.save(student);
        }

        // You can add more methods for updating or deleting students if needed
        // In the StudentService class
        public Students updateStudent(Long id, Students updatedStudent) {
            // Find the existing student by ID
            Students existingStudent = studentrepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));

            // Update the fields of the existing student
            existingStudent.setName(updatedStudent.getName());

            existingStudent.setMajor(updatedStudent.getMajor());

            existingStudent.setSurname(updatedStudent.getSurname());

            // Save the updated student back to the database
            return studentrepository.save(existingStudent);
        }
        // In the StudentService class
        public void deleteStudentById(Long id) {
            // Check if the student exists by ID
            if (!studentrepository.existsById(id)) {
                throw new RuntimeException("Student not found with ID: " + id);
            }

            // Delete the student if they exist
            studentrepository.deleteById(id);
        }


    }

