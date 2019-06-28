package com.auth0.samples.kotlinspringboot

import com.auth0.samples.kotlinspringboot.model.ApplicationUser
import com.auth0.samples.kotlinspringboot.persistence.ApplicationUserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
open class UserDetailsServiceImpl(val userRepository: ApplicationUserRepository) : UserDetailsService {
	@Transactional(readOnly = true)
	@Throws(UsernameNotFoundException::class)
	override fun loadUserByUsername(username: String): UserDetails {
		val user = userRepository.findByUsername(username) ?: throw UsernameNotFoundException(username)
		return User(user.username, user.password, emptyList())
	}

	fun save(user: ApplicationUser) {
		userRepository.save(user)
	}
}
