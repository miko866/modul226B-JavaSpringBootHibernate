package managersystem.server.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@NotNull
	private String street;

	private String street_number;

	@NotNull
	private int zip;

	@NotNull
	private String city;

	@NotNull
	private int client_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet_number() {
		return street_number;
	}

	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	@Override
	public String toString() {
		return "Address{" +
			"id=" + id +
			", street='" + street + '\'' +
			", street_number='" + street_number + '\'' +
			", zip=" + zip +
			", city='" + city + '\'' +
			", client_id=" + client_id +
			'}';
	}
}
