package com.auth0.samples.kotlinspringboot.model

class LoginResponse( isSuccess:Boolean,  message: String?,val token:String): ApiResponse(isSuccess,message)
