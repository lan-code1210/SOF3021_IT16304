package IT16304.ASM.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// class này dùng bóc dữu liệu trong form gửi lên
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {
	private int id;
	@NotBlank
	private String fullname;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String username;
	
	@NotBlank
	@Max(value = 8)
	private String password;
	
	@NotBlank
	private String photo;
	
	@NotEmpty
	private int admin;
	
	private Boolean isEdit = false;
}
