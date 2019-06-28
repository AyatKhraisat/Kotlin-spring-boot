package com.auth0.samples.kotlinspringboot.model

class JwtResponse(var token: String) {
	val type: String = "Bearer"
}
