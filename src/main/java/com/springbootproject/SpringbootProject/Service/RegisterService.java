package com.springbootproject.SpringbootProject.Service;


import com.springbootproject.SpringbootProject.Dto.LoginDTO;
import com.springbootproject.SpringbootProject.Dto.RegisterDTO;
import com.springbootproject.SpringbootProject.Response.LoginResponse;

public interface RegisterService {

	String addDetails(RegisterDTO registerDTO);
	
	LoginResponse loginEmployee(LoginDTO loginDTO);
}
