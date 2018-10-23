package system.DAO.implementDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import system.DAO.interfaceDAO.InterfaceUserDAO;
import system.model.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

@Component("UserDAO")
public class UserDAO implements InterfaceUserDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public UserDAO() {
    }

    @Override
    public void insertUser(User user) {

        String sql = "insert into users (login, nameAndMiddleName, password, email) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[] {
                user.getLogin(),
                user.getNameAndMiddleName(),
                user.getPassword(),
                user.getEmail()
        });

    }

    @Override
    public void deleteUser(User user){
        deleteUserById(user.getIdUser());
    }

    @Override
    public void deleteUserById(int id){
        String sql ="delete from users where idUser=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public User getUserById(int id){

        if(id == 0) return null;

        String sql = "select * from users where idUser=?";
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper(),id);

        if(users.size() != 0)
            return users.get(0);
        else
            return null;
    }

    @Override
    public User getUserByLogin(String login) {
        if(login == null) return null;

        String sql = "select * from users where login=?";
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper(),login);

        if(users.size() != 0)
            return users.get(0);
        else
            return null;
    }

    @Override
    public User getUserByEmail(String email) {
        if(email == null) return null;

        String sql = "select * from users where email=?";
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper(),email);

        if(users.size() != 0)
            return users.get(0);
        else
            return null;

    }

    @Override
    public void updateUser(User user) {
        String sql = "update users set login=?, nameAndMiddleName=?, password=?, email=? where idUser=?";
        jdbcTemplate.update(sql, new Object[]{
                user.getLogin(),
                user.getNameAndMiddleName(),
                user.getPassword(),
                user.getEmail(),
                user.getIdUser()
        });
    }

    private static final class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setIdUser(rs.getInt("idUser"));
            user.setLogin(rs.getString("login"));
            user.setNameAndMiddleName(rs.getString("nameAndMiddleName"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            return user;
        }

    }

}