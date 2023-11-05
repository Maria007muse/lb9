package domain;

/**
* Класс для данных клиента
*/
public class Person {
// Идентификатор 
 private Long id;

 // Имя
 private String firstName;

 // Фамилия
 private String lastName;

 // Телефон
 private String phone;

 // email
 private String email;


 // Внешний ключ 
 private Long idVeriety;

 // Навигационное свойства - ссылка на должность
 private VerietyPerson veriety;
 public Person() {
}

 public Person(String firstName, String lastName, String phone,
 String email, VerietyPerson veriety) {
 this.firstName = firstName;
 this.lastName = lastName;
 this.email = email;
 this.phone = phone;
 this.veriety = veriety;
 }

 public Person(String firstName, String lastName, String phone,
 String email, Long idVeriety, VerietyPerson veriety) {
 this.firstName = firstName;
 this.lastName = lastName;
 this.email = email;
 this.phone = phone;
 this.veriety = veriety;
 this.idVeriety = idVeriety;
 }

 public Person(Long id, String firstName, String lastName, String
phone, String email, Long idVeriety, VerietyPerson veriety) {
 this.id = id;
 this.firstName = firstName;
 this.lastName = lastName;
 this.email = email;
 this.phone = phone;
 this.veriety = veriety;
 this.idVeriety = idVeriety;
 }


public String getFirstName() {
return firstName;
}
public void setFirstName(String firstName) {
this.firstName = firstName;
}

public String getLastName() {
return lastName;
}
public void setLastName(String lastName) {
this.lastName = lastName;
}
public String getPhone() {
return phone;
}
public void setPhone(String phone) {
this.phone = phone;
}
public VerietyPerson veriety () {
return veriety;
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}

public String getVeriety() {
return veriety.getNameveriety();
}
public void setVeriety(VerietyPerson veriety) {
this.veriety = veriety;
}
public Long getIdVeriety() {
return idVeriety;
}
public void setIdVeriety(Long idVeriety) {
this.idVeriety = idVeriety;
}
@Override
public String toString() {
return "VerietyPerson {" + "Id = " + id +
", firstName = " + firstName +
", lastName = " + lastName +
", email = " + email +
", phone = " + phone +
", nameveriety = " + getVeriety() +
"}";
}
}

