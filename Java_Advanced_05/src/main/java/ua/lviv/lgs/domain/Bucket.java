package ua.lviv.lgs.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bucket")
public class Bucket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;
	
	@Column(name = "dateOfPurchase")
	private LocalDateTime dateOfPurchase;
	
	public Bucket() {}

	public Bucket(User user, Product product, LocalDateTime dateOfPurchase) {
		this.user = user;
		this.product = product;
		this.dateOfPurchase = dateOfPurchase;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public LocalDateTime getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDateTime dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfPurchase == null) ? 0 : dateOfPurchase.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bucket other = (Bucket) obj;
		if (dateOfPurchase == null) {
			if (other.dateOfPurchase != null)
				return false;
		} else if (!dateOfPurchase.equals(other.dateOfPurchase))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bucket [id=" + id + ", user=" + user + ", product=" + product + ", dateOfPurchase=" + dateOfPurchase
				+ "]";
	}
	
//	public Bucket(Integer user_id, Integer product_id, LocalDateTime dateOfPurchase) {
//		this.user_id = user_id;
//		this.product_id = product_id;
//		this.dateOfPurchase = dateOfPurchase;
//	}
//
//	public Bucket(Integer id, Integer user_id, Integer product_id, LocalDateTime dateOfPurchase) {
//		this.id = id;
//		this.user_id = user_id;
//		this.product_id = product_id;	
//		this.dateOfPurchase = dateOfPurchase;
//	}

	

	
	
	
	
	
	
}
