package it.epicode.ProgettoSettimanale.controller;

import it.epicode.ProgettoSettimanale.dto.EmployeeDto;
import it.epicode.ProgettoSettimanale.model.Employee;
import it.epicode.ProgettoSettimanale.service.EmployeeService;
import it.epicode.ProgettoSettimanale.service.ImageUploadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ImageUploadService imageUploadService;

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody @Valid EmployeeDto dto) {
        Employee saved = employeeService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        Employee employee = employeeService.getById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody @Valid EmployeeDto dto) {
        Employee updated = employeeService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/upload-profile-image")
    public ResponseEntity<?> uploadProfileImage(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) throws IOException {


        String imageUrl = imageUploadService.uploadImage(file);
        employeeService.updateProfileImage(id, imageUrl);
        return ResponseEntity.ok(Map.of("imageUrl", imageUrl));
    }

}