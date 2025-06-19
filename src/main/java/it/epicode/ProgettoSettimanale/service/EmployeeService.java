package it.epicode.ProgettoSettimanale.service;

import it.epicode.ProgettoSettimanale.dto.EmployeeDto;
import it.epicode.ProgettoSettimanale.model.Employee;
import it.epicode.ProgettoSettimanale.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee create(EmployeeDto dto) {
        Employee employee = Employee.builder()
                .username(dto.getUsername())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .build();
        return employeeRepository.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
    }

    public Employee update(Long id, EmployeeDto dto) {
        Employee employee = getById(id);
        employee.setUsername(dto.getUsername());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        return employeeRepository.save(employee);
    }

    public void delete(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EntityNotFoundException("Employee not found");
        }
        employeeRepository.deleteById(id);
    }
    public Employee updateProfileImage(Long id, String imageUrl) {
        Employee employee = getById(id);
        employee.setProfileImagePath(imageUrl);
        return employeeRepository.save(employee);
    }
}
