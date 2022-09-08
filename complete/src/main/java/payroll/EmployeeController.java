package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    /**
     * Define repository variable with EmployeeRepository type
     */
    private final EmployeeRepository repository;

    /**
     * EmployeeRepository is injected by constructor into the controller
     * @param repository
     */
    EmployeeController(EmployeeRepository repository){
        this.repository = repository;
    }

    /**
     * To get all list employee
     * @return list with type employee
     */
    @GetMapping("/employees")
    List<Employee> all(){
        return repository.findAll();
    }

    /**
     * Post from web client to this server
     */
    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee){
        this.log.info(newEmployee.toString());
        return repository.save(newEmployee);
    }

    /**
     *
     */
    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id){

        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    /**
     *
     */
    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id){

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                //Define empty method orElseGet. It require a inline function
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }
    /**
     *
     */
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id){
        repository.deleteById(id);
    }

}