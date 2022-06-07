package IT16304.ASM.model;



import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// class này dùng bóc dữu liệu trong form gửi lên
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {
	private int id;
	
	@NotBlank(message = "Fullname không được để trống")
	private String fullname;
	
	@NotBlank(message = "Email không được để trống")
	@Email(message = "Email không đúng định dạng")
	private String email;
	
	@NotBlank(message = "Username không được để trống")
	private String username;
	
	@NotBlank(message = "Password không được để trống")
	@Min(value = 8,message = "Password lớn hơn 6")
	private String password;
	
	@NotBlank(message = "Photo không được để trống")
	private String photo;
	
	@NotNull(message = "Admin không được để trống")
	private int admin;
	
	private Boolean isEdit = false;
}
