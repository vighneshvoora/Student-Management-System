package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.Faculty;

public interface FacultyService {
	List<Faculty> getAllFaculty();
	
	Faculty saveFaculty(Faculty faculty);
	
	Faculty getFacultyById(Long id);
	
	Faculty updateFaculty(Faculty faculty);
	
	void deleteFacultyById(Long id);
}
