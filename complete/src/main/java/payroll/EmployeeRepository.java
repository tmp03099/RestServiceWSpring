package payroll;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Declare an interface which extends Spring Data JPA
 */
interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
