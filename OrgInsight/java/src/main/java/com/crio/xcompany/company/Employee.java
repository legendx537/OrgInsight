package com.crio.xcompany.company;
import java.util.List;
import java.util.ArrayList;

public class Employee {
    private String name;
    private Gender gender;
    

       // List of child
       private List<Employee> directReportees;


       //List of Teammates
       private List<Employee> teamMates;

    public Employee(String name, Gender gender) {
        this.name=name;
        this.gender=gender;

        this.directReportees = new ArrayList<>();
        this.teamMates = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    // TODO: CRIO_TASK_MODULE_XCOMPANY
    // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone before implementing the logic.
    // This will ensure that the project can be compiled successfully.
    public void assignManager(Employee employee){
        employee.directReportees.add(this);
        this.teamMates.add(employee);
        this.teamMates.addAll(employee.directReportees);
    }

    public List<Employee> getDirectReporties(){
        return directReportees;
    }

    public List<Employee> getTeamMates(){
        return teamMates;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", gender=" + gender + "]";
    }   
}
