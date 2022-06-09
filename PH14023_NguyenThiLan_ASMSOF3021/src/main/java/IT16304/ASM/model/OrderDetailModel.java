package IT16304.ASM.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import IT16304.ASM.entity.Order;
import IT16304.ASM.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailModel {
	private int id;
	private Order order;
	private Product product;
	
	@NotNull(message = "Price không được để trống")
	private double price;
	
	@NotNull(message = "Quantity không được để trống")
	private int quantity;
}
