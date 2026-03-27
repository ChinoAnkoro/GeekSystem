package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import lombok.Data;

@Data
public class AdminDTO implements Serializable{
	public Long id;
	
	@NotBlank(message = "姓は必須です")
	public String lastName;
	
	@NotBlank(message = "名は必須です")
	public String firstName;
	
	@Email(message="メール形式で入力してください")
	@NotBlank(message="メールは必須です")
	public String email;
	
	@NotEmpty(message = "権限を1つ以上選択してください")
	public String post;
	
	@NotBlank(message = "役職を選択してください")
	public List<String> authority;
	
	@Pattern(regexp = "^[0-9]{10,11}$", message = "電話番号は10〜11桁の数字で入力してください")
	public String phone_number;
	
	public String password;
	
	public LocalDateTime createdAt;
	
	public LocalDateTime updatedAt;
	
	public String getFullName() {
		return lastName + " " + firstName;
	}
}