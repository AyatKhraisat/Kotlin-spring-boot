package com.auth0.samples.kotlinspringboot.persistence

import com.auth0.samples.kotlinspringboot.model.Candy
import org.springframework.data.repository.CrudRepository

interface CandyRepository : CrudRepository<Candy,Long>
