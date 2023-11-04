package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import domain.Person;
/**
* Класс реализации функций взаимодействия с базой данных для таблицы
persons
* (Сотрудники)
*/
public class PersonDbDAO implements RepositoryDAO<Person> {
// SQL-запросы к таблице persons базы данных
private static final String select_all_person = "SELECT id, firstName, lastname, email, phone, inn, verietyid FROM persons ORDER BY lastname ASC";
private static final String select_person_ById = "SELECT id, verietyid, firstname, lastname, phone, email, inn FROM persons WHERE id = ?";
private static final String insert_person = "INSERT INTO persons(verietyid, firstname, lastname, phone, email , inn) VALUES(?,?,?,?,?)";
private static final String edit_person = "UPDATE persons SET verietyid = ?, firstname = ?, lastname = ?, phone = ?, email = ?, inn = ? WHERE id = ?";
private static final String delete_person = "DELETE FROM persons WHERE id = ?";
// Создание соединения с базой данных
Connection connection = DbConnectionBuilder.getConnection();

VerietyDbDAO dao = new VerietyDbDAO();
public PersonDbDAO() {
// TODO Auto-generated constructor stub
}
@Override
public Long insert (Person person) throws Exception {
try (
PreparedStatement pst = connection.prepareStatement(insert_person, new String[] { "id" })) {
Long Id = -1L;
pst.setString(1, person.getFirstName());
pst.setString(2, person.getLastName());
pst.setString(3, person.getVeriety());
pst.setString(4, person.getPhone());
pst.setString(5, person.getEmail());
pst.setInt(6, person.getInn());
pst.executeUpdate();
ResultSet gk = pst.getGeneratedKeys();
if (gk.next()) {
Id = gk.getLong("id");
}
gk.close();
return Id;
} catch (SQLException e) {
throw new Exception(e);
}
}
@Override
public void update(Person person) throws Exception {
try (PreparedStatement pst = connection.prepareStatement(edit_person)) {
pst.setString(1, person.getFirstName());
pst.setString(2, person.getLastName());
pst.setString(3, person.getVeriety());
pst.setString(4, person.getPhone());
pst.setString(5, person.getEmail());
pst.setInt(6, person.getInn());
pst.executeUpdate();
} catch (SQLException e) {
throw new Exception(e);
}
}
@Override
public void delete(Long Id) throws Exception {
try (PreparedStatement pst = connection.prepareStatement(delete_person)) {
pst.setLong(1, Id);
pst.executeUpdate();
} catch (SQLException e) {
throw new Exception(e);
}
}
@Override
public Person findById(Long Id) throws Exception {
Person person = null;
try (
PreparedStatement pst = connection.prepareStatement(select_person_ById)){
pst.setLong(1, Id);
ResultSet rs = pst.executeQuery();
if (rs.next()) {
person = fillPerson(rs);
}
rs.close();
pst.close();
} catch (SQLException e) {
throw new Exception(e);
}
return person;
}
@Override
public List<Person> findAll() throws Exception {
List<Person> list = new LinkedList<>();
try (
PreparedStatement pst = connection.prepareStatement(select_all_person);
ResultSet rs = pst.executeQuery()) {
while (rs.next()) {
list.add(fillPerson(rs));
}
rs.close();
} catch (SQLException e) {
throw new Exception(e);
}
return list;
}
private Person fillPerson(ResultSet rs) throws SQLException, Exception {
Long idVeriety = rs.getLong("verietyid");
Person person = new Person();
person.setId(rs.getLong("id"));
person.setFirstName(rs.getString("firstname"));
person.setLastName(rs.getString("lastname"));
person.setPhone(rs.getString("phone"));
person.setEmail(rs.getString("email"));
person.setInn(rs.getInt("inn"));
person.setIdRole(idVeriety);
return person;
}
}

