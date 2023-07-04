package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Faculty;
import net.javaguides.sms.service.FacultyService;


@Controller
public class FacultyController {
	
	private FacultyService facultyService;

	public FacultyController(FacultyService facultyService) {
		super();
		this.facultyService = facultyService;
	}
	
	@GetMapping("/faculty")
	public String listFaculty(Model model) {
		model.addAttribute("faculty", facultyService.getAllFaculty());
		return "faculty";
	}
	
	@GetMapping("/faculty/new")
	public String createFacultyForm(Model model) {
		
		Faculty faculty = new Faculty();
		model.addAttribute("faculty", faculty);
		return "create_faculty";
		
	}
	
	@PostMapping("/faculty")
	public String saveFaculty(@ModelAttribute("faculty") Faculty faculty) {
		facultyService.saveFaculty(faculty);
		return "redirect:/faculty";
	}
	
	@GetMapping("/faculty/edit/{id}")
	public String editFacultyForm(@PathVariable Long id, Model model) {
		model.addAttribute("faculty", facultyService.getFacultyById(id));
		return "edit_faculty";
	}

	@PostMapping("/faculty/{id}")
	public String updateFaculty(@PathVariable Long id,
			@ModelAttribute("faculty") Faculty faculty,
			Model model) {
		
		Faculty existingFaculty = facultyService.getFacultyById(id);
		existingFaculty.setId(id);
		existingFaculty.setFirstName(faculty.getFirstName());
		existingFaculty.setLastName(faculty.getLastName());
		existingFaculty.setEmail(faculty.getEmail());
		
		facultyService.updateFaculty(existingFaculty);
		return "redirect:/faculty";		
	}
	
	@GetMapping("/faculty/{id}")
	public String deleteFaculty(@PathVariable Long id) {
		facultyService.deleteFacultyById(id);
		return "redirect:/faculty";
	}
	
}
