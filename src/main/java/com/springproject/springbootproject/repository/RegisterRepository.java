package com.springproject.springbootproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.springproject.springbootproject.model.Register;


@EnableJpaRepositories
@Repository
public interface RegisterRepository extends JpaRepository<Register,Long>{
	Optional<Register> findOneByEmailAndPassword(String email, String password);
    Register findByEmail(String email);
	
}
