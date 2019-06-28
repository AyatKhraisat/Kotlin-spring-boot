package com.auth0.samples.kotlinspringboot.execptions

import com.auth0.samples.kotlinspringboot.model.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
@RestController
class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

	@ExceptionHandler(value = [CustomException::class])
	fun handleNotFoundException(ex: CustomException, request: WebRequest): ResponseEntity<ApiResponse> {
		var errorDetails = ApiResponse(false,ex.message)

		return ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}
}
