package IT16304.ASM.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private double price;
	private int quantity;
}
