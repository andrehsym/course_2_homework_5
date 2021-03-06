package pro.sky.java.homeworks.course2.homework5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.homeworks.course2.homework5.data.Employee;
import pro.sky.java.homeworks.course2.homework5.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        Employee newbie = employeeService.addNew(firstName, lastName);
        return "Сотрудник " + newbie.getFirstName() + " " + newbie.getLastName() + " успешно создан";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        Employee deleted = employeeService.remove(firstName, lastName);
        return "Сотрудник " + deleted.getFirstName() + " " + deleted.getLastName() + " удален";
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        return employeeService.find(firstName, lastName);
    }
}
