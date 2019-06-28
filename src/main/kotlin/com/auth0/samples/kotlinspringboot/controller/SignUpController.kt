package com.auth0.samples.kotlinspringboot.controller

import com.auth0.samples.kotlinspringboot.model.ApiResponse
import com.auth0.samples.kotlinspringboot.model.ApplicationUser
import com.auth0.samples.kotlinspringboot.persistence.ApplicationUserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sign-up")
class SignUpController(val applicationUserRepository: ApplicationUserRepository,
					   val bCryptPasswordEncoder: BCryptPasswordEncoder) {

	@PostMapping
	fun signUp(@RequestBody applicationUser: ApplicationUser): ResponseEntity<ApiResponse> {
		applicationUser.password = bCryptPasswordEncoder.encode(applicationUser.password)
	val userName =	applicationUserRepository.findByUsername(applicationUser.username)
		if(userName==null){
			applicationUserRepository.save(applicationUser)
		return ResponseEntity( ApiResponse(true, "Sign up Successful")
				,HttpStatus.OK)}
		return  ResponseEntity( ApiResponse(false, "username already exist")
				,HttpStatus.OK)
	}

}
