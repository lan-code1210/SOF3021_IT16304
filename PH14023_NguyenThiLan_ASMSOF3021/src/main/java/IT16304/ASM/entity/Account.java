package IT16304.ASM.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

// class này dùng để ánh sạ đến db
@Data
@Entity
@Table(name = "accounts")
@NamedQueries(
		@NamedQuery(name="Account.findByEmail", query="SELECT o FROM Account o WHERE email = :email")
	)
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "activated")
	private int activated;
	
	@Column(name = "admin")
	private int admin;
}
