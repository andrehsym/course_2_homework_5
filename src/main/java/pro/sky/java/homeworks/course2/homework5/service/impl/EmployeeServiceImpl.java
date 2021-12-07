package pro.sky.java.homeworks.course2.homework5.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.homeworks.course2.homework5.data.Employee;
import pro.sky.java.homeworks.course2.homework5.exceptions.EmployeeBookOverflow;
import pro.sky.java.homeworks.course2.homework5.exceptions.EmployeeNotFound;
import pro.sky.java.homeworks.course2.homework5.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Employee[] employees = new Employee[10];

    @Override
    public Employee addNew(String firstName, String lastName) {
        Employee newbie = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newbie;
                return newbie;
            }
        }
        throw new EmployeeBookOverflow();
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                throw new EmployeeNotFound();
            } else if (employees[i].getFirstName().equals(firstName) && employees[i].getLastName().equals(lastName)) {
                employees[i] = null;
                return employees[i];
            }
        }
        throw new EmployeeNotFound();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFirstName().equals(firstName) && employees[i].getLastName().equals(lastName)) {
                return employees[i];
            }
        }
        throw new EmployeeNotFound();
    }

}
