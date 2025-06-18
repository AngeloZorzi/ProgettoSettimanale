package it.epicode.ProgettoSettimanale.repository;

import it.epicode.ProgettoSettimanale.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
