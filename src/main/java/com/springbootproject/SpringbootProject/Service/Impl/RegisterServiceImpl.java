package com.springbootproject.SpringbootProject.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.springbootproject.SpringbootProject.Dto.LoginDTO;
import com.springbootproject.SpringbootProject.Dto.RegisterDTO;
import com.springbootproject.SpringbootProject.Response.LoginResponse;
import com.springbootproject.SpringbootProject.Service.RegisterService;
import com.springproject.springbootproject.model.Register;
import com.springproject.springbootproject.repository.RegisterRepository;

import java.util.Optional;

@Service
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	private RegisterRepository registerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String addDetails(RegisterDTO registerDTO)
	{
		Register register=new Register(
				registerDTO.getId(),
				registerDTO.getName(),
				registerDTO.getEmail(),
				this.passwordEncoder.encode(registerDTO.getPassword()));
		
		registerRepository.save(register);
		return register.getName();
	}
	RegisterDTO registerDTO;

	@Override
	public LoginResponse loginEmployee(LoginDTO loginDTO) {
		
		String msg="";
		Register register1=registerRepository.findByEmail(loginDTO.getEmail());
		
		if(register1!= null) {
			String password=loginDTO.getPassword();
			String encodedPassword=register1.getPassword();
			Boolean isPwdRight=passwordEncoder.matches(password, encodedPassword);
			if(isPwdRight) {
				Optional<Register> register= registerRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
			
				if (register.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
 
                return new LoginResponse("Email or Password Not Match", false);
            }
        }else {
            return new LoginResponse("Email or Password not exits", false);
        }
			
		}
}