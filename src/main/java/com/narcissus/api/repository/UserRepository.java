package com.narcissus.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.narcissus.api.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>  {
 
	@Query("SELECT u FROM tb_usuario u WHERE u.email = :email")
	UserEntity findByEmail(@Param("email") String email);
	
	@Query("SELECT u FROM tb_usuario u WHERE u.cpf = :cpf")
	UserEntity findByCpf(@Param("cpf") String cpf);
	
	@Query("SELECT u FROM tb_usuario u WHERE u.email = :email and u.key = :password")
	UserEntity findByEmailAndPassword(
		@Param("email") String email, 
		@Param("password") String password
	);
}
