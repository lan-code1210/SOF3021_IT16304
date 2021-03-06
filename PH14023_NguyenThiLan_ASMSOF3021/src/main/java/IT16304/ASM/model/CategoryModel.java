package IT16304.ASM.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryModel {
	private Long id;
	
	@NotBlank(message = "Name không được để trống")
	private String name;
	
	private Boolean isEdit = false;
}
