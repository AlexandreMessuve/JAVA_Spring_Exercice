package com.example.exercice03.service;

import com.example.exercice03.dto.employee.EmployeeDtoGet;
import com.example.exercice03.dto.employee.EmployeeDtoPost;
import com.example.exercice03.entity.Employee;
import com.example.exercice03.exception.NotFoundException;
import com.example.exercice03.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements BaseService<EmployeeDtoGet, EmployeeDtoPost> {

    private final EmployeeRepository employeeRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    @Override
    public EmployeeDtoGet create(EmployeeDtoPost employeeDtoPost) {
        Employee employee = Employee.builder()
                .firstname(employeeDtoPost.getFirstname())
                .lastname(employeeDtoPost.getLastname())
                .address(employeeDtoPost.getAddress())
                .birthday(LocalDate.parse(employeeDtoPost.getBirthdayStr(), formatter))
                .salary(employeeDtoPost.getSalary())
                .phone(employeeDtoPost.getPhone())
                .email(employeeDtoPost.getEmail())
                .password(employeeDtoPost.getPassword())
                .admin(employeeDtoPost.isAdmin())
                .contractStart(LocalDate.parse(employeeDtoPost.getContractStartStr(), formatter))
                .contractEnd(LocalDate.parse(employeeDtoPost.getContractEndStr(), formatter))
                .occupation(employeeDtoPost.getOccupation())
                .observation(employeeDtoPost.getObservation())
                .build();
        employeeRepository.save(employee);
        return employeeToEmployeeDtoGet(employee);
    }

    @Override
    public EmployeeDtoGet update(int id, EmployeeDtoPost employeeDtoPost) {
        Employee employee = getById(id);
        employee.setFirstname(employeeDtoPost.getFirstname());
        employee.setLastname(employeeDtoPost.getLastname());
        employee.setEmail(employeeDtoPost.getEmail());
        employee.setPassword(employeeDtoPost.getPassword());
        employee.setPhone(employeeDtoPost.getPhone());
        employee.setAddress(employeeDtoPost.getAddress());
        employee.setSalary(employeeDtoPost.getSalary());
        employee.setBirthday(LocalDate.parse(employeeDtoPost.getBirthdayStr(), formatter));
        employee.setContractStart(LocalDate.parse(employeeDtoPost.getContractStartStr(), formatter));
        employee.setContractEnd(LocalDate.parse(employeeDtoPost.getContractEndStr(), formatter));
        employee.setOccupation(employeeDtoPost.getOccupation());
        employee.setObservation(employeeDtoPost.getObservation());
        employeeRepository.save(employee);
        return employeeToEmployeeDtoGet(employee);
    }

    @Override
    public boolean delete(int id) {
        employeeRepository.delete(getById(id));
        return true;
    }

    @Override
    public EmployeeDtoGet findById(int id) {
        return employeeToEmployeeDtoGet(getById(id));
    }

    @Override
    public List<EmployeeDtoGet> findAll() {
        return employeeListToEmployeeDtoGetList(employeeRepository.findAll());
    }

    public Employee getById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException(id.toString()));
    }
    public EmployeeDtoGet employeeToEmployeeDtoGet(Employee employee) {
        return EmployeeDtoGet.builder()
                .id(employee.getId())
                .firstname(employee.getFirstname())
                .lastname(employee.getLastname())
                .email(employee.getEmail())
                .address(employee.getAddress())
                .birthday(employee.getBirthday())
                .admin(employee.isAdmin())
                .contractStart(employee.getContractStart())
                .contractEnd(employee.getContractEnd())
                .phone(employee.getPhone())
                .observation(employee.getObservation())
                .occupation(employee.getOccupation())
                .salary(employee.getSalary())
                .build();
    }

    public List<EmployeeDtoGet> employeeListToEmployeeDtoGetList(List<Employee> employees) {
        return employees.stream().map(this::employeeToEmployeeDtoGet).collect(Collectors.toList());
    }
}
