package com.greatelerning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greateleraning.service.StudentService;
import com.greatelerning.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentServiceImpl;

	@RequestMapping("/list")
	public String listStudnt(Model model) {

		List<Student> students = studentServiceImpl.findAll();
		model.addAttribute("students", students);

		return "listStudent";

	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		Student student = new Student();
		model.addAttribute("student", student);
		return "addStudent";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {

		Student student = studentServiceImpl.findById(id);
		model.addAttribute("student", student);
		return "addStudent";

	}

	@PostMapping("/save")
	public String save(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {
		Student student;
		if (id != 0) {

			student = studentServiceImpl.findById(id);

		} else {
			student = new Student(name, department, country);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		}
		studentServiceImpl.save(student);
		return "redirect:/student/list";
	}
	
    @RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		studentServiceImpl.deleteById(id);

		return "redirect:/student/list";

	}
}
