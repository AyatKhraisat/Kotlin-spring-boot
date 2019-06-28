package com.auth0.samples.kotlinspringboot.model

import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
class ApplicationUser(
		@Id @GeneratedValue(strategy = GenerationType.AUTO)
		var id: Long = 0,

		@NotNull
		@Column(unique=true)
		var username: String = "",
		@NotNull
		var password: String = ""
)
