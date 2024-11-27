package casdevlabs.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="students")

public class Students {
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    @Id

    private Long id;
    @Column(name="student_major")
    private String major;
    @Column(name="student_name")
    private String name;
    @Column(name="student_surname")
    private String surname;

}
