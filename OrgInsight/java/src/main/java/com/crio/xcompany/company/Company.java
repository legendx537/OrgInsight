package com.crio.xcompany.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Company{
    private String companyName;
    private Employee founder;
    private Map<String,Employee> employeeBook;

    private Map<Employee, List<Employee>> empManagerMap;
    

    private Company(String companyName, Employee founder) {
        this.companyName = companyName;
        this.founder = founder;
        employeeBook = new HashMap<String,Employee>();
        employeeBook.put(founder.getName(), founder);

        empManagerMap = new HashMap<>();
    }
    
    public void registerEmployee(String employeeName,Gender gender){
       Employee newEmployee=new Employee(employeeName , gender);
       employeeBook.put( newEmployee.getName() , newEmployee );
       System.out.println(" Employee registered successfully");
    }
    
    public Employee getEmployee(String employeeName){
        return employeeBook.get(employeeName);
    }

    public void deleteEmployee(String employeeName){
        employeeBook.remove(employeeName);
    }

    public void assignManager(String employeeName,String managerName){
        getEmployee(employeeName).assignManager( getEmployee(managerName) );
    }
    

    public List<Employee> getDirectReports(String managerName){
          return getEmployee(managerName).getDirectReporties();
    }

    public List<Employee> getTeamMates(String employeeName){
         return getEmployee(employeeName).getTeamMates();
    }
    

    public List<List<Employee>> getEmployeeHierarchy(String managerName){
        
     /*
       // have to figure out why it is not working 
       // work on this after the sprint
        
        List<List<Employee>> empHierarchyList=new ArrayList<>();

        Queue<Employee> queue=new LinkedList<>();
        
        queue.add(  getEmployee(managerName) );

        while( queue.isEmpty() )
        {
            Integer size = queue.size();

            List<Employee> currentEmployee=new ArrayList<>();

            for(int i=size; i > 0; i-- ){
                
                Employee emp =queue.poll();
                 currentEmployee.add(emp);

                 // add the neighbours 
                 //  means add the direct reporties
                 for(Employee E:emp.getDirectReporties() )
                   queue.add(E);
                      
            }

            empHierarchyList.add(currentEmployee);
        }

        return empHierarchyList; */

        Employee manager = getEmployee(managerName);

        List<List<Employee>> hierarchy = new ArrayList<List<Employee>>();
        List<Employee> curr = new ArrayList<Employee>();
        curr.add(manager);
        hierarchy.add(curr);


        int i = 0;
        while ( i < hierarchy.size() ) {
            for(Employee employee: hierarchy.get(i)) {
                curr = employee.getDirectReporties();

                if ( curr.size() > 0 ) {
                    hierarchy.add(curr);
                }
            }
            i++;
        }

        return hierarchy;

    }

    public static Company create(String companyName, Employee founder){
        return new Company(companyName,founder);
    } 

     
    public String getCompanyName() {
        return companyName;
    }

    // TODO: CRIO_TASK_MODULE_XCOMPANY
    // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone for each functionality before implementing the logic.
    // This will ensure that the project can be compiled successfully.

}
