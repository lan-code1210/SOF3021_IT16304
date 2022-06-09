package IT16304.ASM.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import IT16304.ASM.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
	private int id;
	
	@NotBlank(message = "Name không được để trống")
	private String name;
	@NotBlank(message = "Image không được để trống")
	private String image;
	
	@NotNull(message = "Price không được để trống")
	private double price;
	private Date createDate;
	private int avaliable;
	private Category category_id;
	
}
