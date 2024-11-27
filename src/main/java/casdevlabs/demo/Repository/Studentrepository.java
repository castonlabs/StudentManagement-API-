package casdevlabs.demo.Repository;

import casdevlabs.demo.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Studentrepository extends JpaRepository<Students,Long> {
}
