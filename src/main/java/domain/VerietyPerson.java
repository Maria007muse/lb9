package domain;

public class VerietyPerson {
	
	// Идентификатор должности
	private Long id;
	// Наименование должности
	private String nameveriety;
	public VerietyPerson() {
	}
	public VerietyPerson(String nameveriety) {
	this.nameveriety = nameveriety;
	}
	public VerietyPerson(Long id, String nameveriety) {
	this.id = id;
	this.nameveriety = nameveriety;
	}
	public Long getId() {
	return id;
	}
	public void setId(Long id) {
	this.id = id;
	}
	public String getNameveriety() {
	return nameveriety;
	}
	public void setNameveriety(String nameveriety) {
	this.nameveriety = nameveriety;
	}
	@Override
	public String toString() {
	return "VerietyPerson {" + "Id = " + id + ", NameVeriety = " + nameveriety
	+ "}";
	}
}


