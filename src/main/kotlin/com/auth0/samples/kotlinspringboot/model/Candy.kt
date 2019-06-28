package com.auth0.samples.kotlinspringboot.model

import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class Candy(
		@Id @GeneratedValue(strategy = GenerationType.AUTO)
		var id: Long = 0,
		@NotNull
		var name: String = "",
		var description: String = ""
)
