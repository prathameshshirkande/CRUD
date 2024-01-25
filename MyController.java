package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.StudentRepository;
import com.example.demo.Entity.Student;


@RestController
public class MyController {
	@Autowired
	private StudentRepository studentRepo;

	
	
	@GetMapping("/get")
	public List<Student> findByAll(){
		return studentRepo.findAll();	
		}
	
	@PostMapping("/add")
	public Student add(@RequestBody Student student) {
		return studentRepo.save(student);
	}

	@PutMapping("/update{id}")
	public Student update(@RequestBody Student student,@PathVariable int id) {
			Student stu=studentRepo.getById(id);
			stu.setFname(student.getFname());
			stu.setLname(student.getLname());
			return studentRepo.save(stu);
	}
	
	@DeleteMapping("/delete{id}")
	public boolean delete(@PathVariable int id) {
		studentRepo.deleteById(id);
		return true;
	}
}
