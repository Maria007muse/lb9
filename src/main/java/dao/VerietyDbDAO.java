package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import domain.VerietyPerson;

/**
* Класс реализации функций взаимодействия с базой данных для таблицы
roles
* (Должности)
*/
public class VerietyDbDAO implements RepositoryDAO<VerietyPerson> {
public VerietyDbDAO() {
// TODO Auto-generated constructor stub
}
// SQL-запросы к таблице roles базы данных
private static final String select_all_role = "SELECT id, verietyname FROM verieties ORDER BY verietyname ASC";
private static final String select_role_ById = "SELECT id, verietyname FROM verieties WHERE id = ?";
private static final String insert_role = "INSERT INTO verieties(verietyname) VALUES(?)";
private static final String edit_role = "UPDATE verieties SET verietyname = ? WHERE id = ?";
private static final String delete_role = "DELETE FROM verieties WHERE id = ?";
// Создание соединения с базой данных
Connection connection = DbConnectionBuilder.getConnection();
// Добавление новой должности
@Override
public Long insert (VerietyPerson veriety) throws Exception {
try (
PreparedStatement pst = connection.prepareStatement(insert_role, new String[] { "id" })) {
Long Id = -1L;
pst.setString(1, veriety.getNameveriety());
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
// Редактирование должности
@Override
public void update(VerietyPerson veriety) throws Exception {
try (PreparedStatement pst = connection.prepareStatement(edit_role)) {
pst.setString(1, veriety.getNameveriety());
pst.setLong(2, veriety.getId());
pst.executeUpdate();
} catch (SQLException e) {
throw new Exception(e);
}
}
// Удаление должности
@Override
public void delete(Long Id) throws Exception {
try (PreparedStatement pst = connection.prepareStatement(delete_role)) {
pst.setLong(1, Id);
pst.executeUpdate();
} catch (SQLException e) {
throw new Exception(e);
}
}
// Поиск должности по Id
@Override
public VerietyPerson findById(Long Id) throws Exception {
	VerietyPerson veriety = null;
try (
PreparedStatement pst = connection.prepareStatement(select_role_ById)){
pst.setLong(1, Id);
ResultSet rs = pst.executeQuery();
if (rs.next()) {
	veriety = fillVerietyPerson(rs);
}
rs.close();
pst.close();
} catch (SQLException e) {
throw new Exception(e);
}
return veriety;
}
// Формирование списка всех должностей
@Override
public List<VerietyPerson> findAll() throws Exception {
List<VerietyPerson> list = new LinkedList<>();
try (
PreparedStatement pst = connection.prepareStatement(select_all_role);
ResultSet rs = pst.executeQuery()) {
while (rs.next()) {
list.add(fillVerietyPerson(rs));
}
rs.close();
} catch (SQLException e) {
throw new Exception(e);
}
return list;
}
// Формирование класса Должности по результатам запроса к БД
private VerietyPerson fillVerietyPerson(ResultSet rs) throws SQLException {
	VerietyPerson veriety = new VerietyPerson();
	veriety.setId(rs.getLong("id"));
	veriety.setNameveriety(rs.getString("verietyname"));
return veriety;
}
// Поиск должности по id из списка должностей
public VerietyPerson FindById(Long id, List<VerietyPerson> verieties) {
if (verieties != null) {
for (VerietyPerson r : verieties) {
if ((r.getId()).equals(id)) {
return r;
}
}
} else {
return null;
}
return null;
}
}
