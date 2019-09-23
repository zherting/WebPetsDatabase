package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ownerinfo")
public class TableOwnerinfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "NAME")
	private String name;
	@Column(name = "OWNER")
	private String owner;

	public TableOwnerinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TableOwnerinfo(String type, String name, String owner) {
		super();
		this.type = type;
		this.name = name;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String returnOwnerDetails() {
		return name + ": " + type + " - " + owner;
	}
}
