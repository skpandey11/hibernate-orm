//$Id$
package org.hibernate.test.annotations.manytomany.defaults;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Emmanuel Bernard
 */
@Entity
@Table(name = "tbl_city")
public class City {
	private Integer id;
	private String name;
	private Set<Item> stolenItems;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	@ManyToMany
	public Set<Item> getStolenItems() {
		return stolenItems;
	}

	public void setStolenItems(Set<Item> stolenItems) {
		this.stolenItems = stolenItems;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
