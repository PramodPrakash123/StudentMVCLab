package com.greateleraning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatelearning.dao.StudentDAO;
import com.greatelearning.dao.StudentDAOimpl;
import com.greatelerning.entity.Student;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	StudentDAO studentDAOImp;
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentDAOImp.findAll();
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return studentDAOImp.findById(id);
	}

	@Override
	public void save(Student student) {
		studentDAOImp.save(student);
		
	}

	@Override
	public void deleteById(int id) {
		studentDAOImp.deleteById(id);
		
	}

	
}
