package com.auth0.samples.kotlinspringboot.controller

import com.auth0.samples.kotlinspringboot.execptions.CustomException
import com.auth0.samples.kotlinspringboot.model.AddCandyResponse
import com.auth0.samples.kotlinspringboot.model.ApiResponse
import com.auth0.samples.kotlinspringboot.model.Candy
import com.auth0.samples.kotlinspringboot.persistence.CandyRepository
import org.springframework.web.bind.annotation.*




@RestController
@RequestMapping("/candy")
class CandyController(val repository: CandyRepository) {


	@GetMapping
	fun findAll() = repository.findAll()

	@PostMapping
	fun addCandy(@RequestBody candy: Candy): AddCandyResponse {
		 repository.save(candy)
		return AddCandyResponse(candy, true, "Candy Added Successfully")
	}

	@PutMapping("/{id}")
	fun updateCandy(@PathVariable id: Long, @RequestBody candy: Candy): ApiResponse {
		assert(candy.id == id)
		repository.save(candy)
		return ApiResponse(true, "Candy Deleted Successfully")
	}

	@DeleteMapping("/{id}")
	fun removeCandy(@PathVariable id: Long): ApiResponse {
		repository.delete(id)
		return ApiResponse(true, "Candy Deleted Successfully")
	}

	@GetMapping("/{id}")
	fun getById(@PathVariable id: Long): Candy {
		val candy = repository.findOne(id)
		if (candy != null)
			return candy
		else throw CustomException("candy not found!!");

	}
}
