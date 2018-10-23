package system.DAO.implementDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import system.DAO.interfaceDAO.InterfaceAdminDAO;
import system.model.Admin;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("AdminDAO")
public class AdminDAO implements InterfaceAdminDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    AdminDAO(){}

    @Override
    public Admin getAdmin() {
        String sql = "select * from administrator";
        List<Admin> admins = jdbcTemplate.query(sql,new AdminRowMapper());



        if(admins.size() != 0)
            return admins.get(0);
        else
            return null;
    }

    private static final class AdminRowMapper implements RowMapper<Admin> {

        @Override
        public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
            Admin admin = new Admin();
            admin.setLogin(rs.getString("login"));
            admin.setPassword(rs.getString("password"));
            admin.setEmail(rs.getString("email"));
            return admin;
        }

    }
}
