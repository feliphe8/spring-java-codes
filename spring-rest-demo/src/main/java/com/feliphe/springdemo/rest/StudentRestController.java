package com.feliphe.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feliphe.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	private List<Student> students;

	public StudentRestController() {
		loadData();
	}

	// @PostConstruct
	public void loadData() {
		students = new ArrayList<>();

		students.add(new Student("Feliphe", "Simoes"));
		students.add(new Student("Irelia", "Evergreen"));
		students.add(new Student("Lydia", "Evergreen"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable int id) {

		return students.get(id);
	}
}
