package com.narcissus.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narcissus.api.entity.UserEntity;
import com.narcissus.api.repository.UserRepository;
import com.narcissus.api.service.exception.CustomException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void save(UserEntity user) throws CustomException {
		
		if (!isUserExist(user)) {
			userRepository.save(user);
		}
	}
	
	public UserEntity login(String email, String password) throws CustomException {
		final UserEntity userLogin = userRepository.findByEmailAndPassword(email,password);
		if (userLogin == null) {
			throw new CustomException("Usuário ou senha inválido!!!");
		}
		
		return userLogin;
	}
	
	public Boolean isUserExist(UserEntity user) throws CustomException {
		
		final UserEntity userEmail = userRepository.findByEmail(user.getEmail());
		if (userEmail != null) {
			throw new CustomException("Já existe esse e-mail cadastrado!!!");
		}
		
		final UserEntity userCpf = userRepository.findByCpf(user.getCpf());
		if (userCpf != null) {
			throw new CustomException("Já existe esse cpf cadastrado!!!");
		}
		
		
		return false;
	}
}
