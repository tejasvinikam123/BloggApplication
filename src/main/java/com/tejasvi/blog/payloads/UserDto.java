package com.tejasvi.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

	private int id;
	@NotEmpty
	@Size(min=4,message="name must be min 4 characters")
	private String name;
	@Email(message="email address is not vaid")
	private String email;
	@NotEmpty
	@Size(min=4,max=10,message="password must be min 4 chars and maximum 10 chars")
	private String password;
	@NotEmpty
	private String about;
}
