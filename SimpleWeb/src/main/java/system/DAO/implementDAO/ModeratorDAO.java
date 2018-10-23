package system.DAO.implementDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import system.DAO.interfaceDAO.InterfaceModeratorDAO;
import system.model.Moderator;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("ModeratorDAO")
public class ModeratorDAO implements InterfaceModeratorDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public ModeratorDAO(){}

    @Override
    public void insertModerator(Moderator moderator){
        String sql = "insert into moderators (login, nickname, email,"+
        " name, surname, middleName, telephone, password, vacation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[] {
                moderator.getLogin(),
                moderator.getNickname(),
                moderator.getEmail(),
                moderator.getName(),
                moderator.getSurname(),
                moderator.getMiddleName(),
                moderator.getTelephone(),
                moderator.getPassword(),
                moderator.getVacation()
        });
    }

    @Override
    public void deleteModerator(Moderator moderator) {
        deleteModeratorById(moderator.getIdModerator());
    }

    @Override
    public void deleteModeratorById(int id) {
        String sql ="delete from moderators where idModerator=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Moderator getModeratorById(int id) {
        if(id == 0) return null;

        String sql = "select * from moderators where idModerator=?";
        List<Moderator> moderators = jdbcTemplate.query(sql, new ModeratorRowMapper(),id);

        if(moderators.size() != 0)
            return moderators.get(0);
        else
            return null;

    }

    @Override
    public Moderator getModeratorByLogin(String login){
        if(login == null) return null;

        String sql = "select * from moderators where login=?";
        List<Moderator> moderators = jdbcTemplate.query(sql, new ModeratorRowMapper(),login);

        if(moderators.size() != 0)
            return moderators.get(0);
        else
            return null;
    }

    @Override
    public Moderator getModeratorByEmail(String email){
        if(email == null) return null;

        String sql = "select * from moderators where email=?";
        List<Moderator> moderators = jdbcTemplate.query(sql, new ModeratorRowMapper(),email);

        if(moderators.size() != 0)
            return moderators.get(0);
        else
            return null;
    }

    @Override
    public List<Moderator> getAllModerators() {
        String sql = "select * from moderators";
        List<Moderator> moderators = jdbcTemplate.query(sql, new ModeratorRowMapper());
        if(moderators==null)
            return null;
        else
            return moderators;
    }

    private static final class ModeratorRowMapper implements RowMapper<Moderator> {

        @Override
        public Moderator mapRow(ResultSet rs, int rowNum) throws SQLException {
            Moderator moderator = new Moderator();
            moderator.setIdModerator(rs.getInt("idModerator"));
            moderator.setLogin(rs.getString("login"));
            moderator.setNickname(rs.getString("nickname"));
            moderator.setEmail(rs.getString("email"));
            moderator.setName(rs.getString("name"));
            moderator.setSurname(rs.getString("surname"));
            moderator.setMiddleName(rs.getString("middleName"));
            moderator.setTelephone(rs.getString("telephone"));
            moderator.setPassword(rs.getString("password"));
            moderator.setVacation(rs.getBoolean("vacation"));
            return moderator;
        }

    }

}
