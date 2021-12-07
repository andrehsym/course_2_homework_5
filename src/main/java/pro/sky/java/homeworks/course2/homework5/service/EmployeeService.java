package pro.sky.java.homeworks.course2.homework5.service;

import pro.sky.java.homeworks.course2.homework5.data.Employee;

public interface EmployeeService {
    Employee addNew(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

}
