package payroll;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
class Employee{


    private @Id @GeneratedValue Long id;
    private String name;
    private String role;

        /**
         *    Define constructor
         */
        Employee(){}

        /**
         * Define custom constructor
         */
        Employee(String name,String role){
            this.name=name;
            this.role=role;
        }

        /**
         * get value
         */
        public Long getId(){
            return this.id;
        }
        public String getName(){
            return this.name;
        }
        public String getRole(){
            return this.role;
        }

        /**
         *  set value with input value and no return type
         */
        public void setId(Long id){
            this.id = id;
        }
        public void setName(String name){
            this.name = name;
        }
        public void setRole(String role){
            this.role = role;
        }

        /**
         * Compare this object and new object
         */
        @Override
        public boolean equals(Object input){
            if (this == input){
                return true;
            }
            if (!(input instanceof Employee)){
                return false;
            }
            //Type casting switch type Object input to Employee input
            Employee employee = (Employee) input;
            return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
                    && Objects.equals(this.role, employee.role);
        }

        /**
         * use hashCode to create a unique id for this object (class Employee)
         */
        @Override
        public int hashCode(){
            return Objects.hash(this.id, this.name, this.role);
        }

        /**
         * returns the value given to it in string format.
         */
        @Override
        public String toString(){
            return "Employee{" + "id=" + this.id
                    + ", name= '" + this.name + '\''
                    + ", role=' " + this.role + '\'' + '}';
        }

}