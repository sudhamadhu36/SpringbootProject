package com.springproject.springbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.SpringbootProject.Response.LoginResponse;
import com.springbootproject.SpringbootProject.Dto.LoginDTO;
import com.springbootproject.SpringbootProject.Dto.RegisterDTO;
import com.springbootproject.SpringbootProject.Service.RegisterService;


@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/register")
public class RegistrationController {
	
	@Autowired
	private RegisterService registerService;
	
	@PostMapping(path="/save")
	public String saveEmployee(@RequestBody RegisterDTO registerDTO) {
		String id=registerService.addDetails(registerDTO);
		return id;
	}
	
	@PostMapping(path="/login")
	public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
	{
		LoginResponse loginResponse = registerService.loginEmployee(loginDTO);
		return ResponseEntity.ok(loginResponse);
	}
}
