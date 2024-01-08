package com.web.jpa.webjpa.controller;

import com.web.jpa.webjpa.entity.Contact;
import com.web.jpa.webjpa.entity.Laptop;
import com.web.jpa.webjpa.entity.Role;
import com.web.jpa.webjpa.entity.Student;
import com.web.jpa.webjpa.repository.ContactRepository;
import com.web.jpa.webjpa.repository.LaptopRepository;
import com.web.jpa.webjpa.repository.RoleRepository;
import com.web.jpa.webjpa.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mapping")
public class MappingController {

    private final StudentRepository studentRepository;

    private final LaptopRepository laptopRepository;

    private final ContactRepository contactRepository;

    private final RoleRepository roleRepository;
    public MappingController(StudentRepository studentRepository, LaptopRepository laptopRepository, ContactRepository contactRepository, RoleRepository roleRepository) {
        this.studentRepository = studentRepository;
        this.laptopRepository = laptopRepository;
        this.contactRepository = contactRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/student")
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{studentId}")
    public Optional<Student> getStudentById(@PathVariable Integer studentId) {
        Optional<Student> student = studentRepository.findById(studentId);

        System.out.println(student.get().getLaptop());
        return student;

//        return studentRepository.findStudentWithDetails(studentId);
    }
    @PostMapping("/student")
    public Student addNewStudent(@RequestBody Student student) {
//        Laptop laptop = student.getLaptop();
//        student.setLaptop(null);
//        laptop.setStudent(student);

//        Student obj = new Student();
//        obj.setName(student.getName());
//        obj.setAbout(student.getAbout());
//        obj.setStudentId(student.getStudentId());
//
//        Laptop laptop = new Laptop();
//        laptop.setLaptopId(student.getLaptop().getLaptopId());
//        laptop.setModel(student.getLaptop().getModel());
//        laptop.setBrand(student.getLaptop().getBrand());
//
//        laptop.setStudent(student);
//        obj.setLaptop(laptop);
        return studentRepository.save(student);
    }

    @GetMapping("/laptop")
    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    @GetMapping("/laptop/{laptopId}")
    public Optional<Laptop> getLaptopById(@PathVariable Integer laptopId) {
        return laptopRepository.findById(laptopId);
    }

    @PostMapping("/laptop")
    public Laptop saveLaptop(@RequestBody Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    @GetMapping("/contact")
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @GetMapping("/contact/{contactId}")
    public Optional<Contact> getByContactByContactId(@PathVariable Integer contactId) {
        return contactRepository.findById(contactId);
    }

    @GetMapping("/role")
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @GetMapping("/role/{roleId}")
    public Optional<Role> getByRoleId(@PathVariable Integer roleId) {
        return roleRepository.findById(roleId);
    }
}
