package IT16304.ASM.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "create_date")
	// xác định độ chính xác về thời gian
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@Column(name = "avaliable")
	private int avaliable;
	
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category_id;
	
}
