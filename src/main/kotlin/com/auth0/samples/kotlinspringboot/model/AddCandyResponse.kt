package com.auth0.samples.kotlinspringboot.model

class AddCandyResponse(val candy: Candy,isSuccess: Boolean, message: String)
	: ApiResponse(isSuccess, message)
