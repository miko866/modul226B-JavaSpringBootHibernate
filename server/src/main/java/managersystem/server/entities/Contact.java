package managersystem.server.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@NotNull
	private String name;

	@NotNull
	private String type;

	@NotNull
	private String sort;

	@NotNull
	private String value;

	@NotNull
	private int client_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	@Override
	public String toString() {
		return "Contact{" +
			"id=" + id +
			", name='" + name + '\'' +
			", type='" + type + '\'' +
			", sort='" + sort + '\'' +
			", value='" + value + '\'' +
			", client_id=" + client_id +
			'}';
	}
}
