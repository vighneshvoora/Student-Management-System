package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Faculty;
import net.javaguides.sms.repository.FacultyRepository;
import net.javaguides.sms.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService{

	private FacultyRepository facultyRepository;
	
	public FacultyServiceImpl(FacultyRepository facultyRepository) {
		super();
		this.facultyRepository = facultyRepository;
	}

	@Override
	public List<Faculty> getAllFaculty() {
		return facultyRepository.findAll();
	}

	@Override
	public Faculty saveFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}
    @Override
	public Faculty getFacultyById(Long id) {
		return facultyRepository.findById(id).get();
	}

	@Override
	public Faculty updateFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	@Override
	public void deleteFacultyById(Long id) {
		facultyRepository.deleteById(id);	
	}

}
