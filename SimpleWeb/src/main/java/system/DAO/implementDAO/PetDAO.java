package system.DAO.implementDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import system.DAO.interfaceDAO.InterfacePetDAO;
import system.model.ParamPet;
import system.model.Pet;
import system.model.NoPublicPet;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Component("PetDAO")
public class PetDAO implements InterfacePetDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    PetDAO(){}

    @Override
    public void insertNoPublicPet(NoPublicPet noPublicPet) {
        String sql = "insert into noPublicPets (idPet, idModerator, countEdit, dateEditUser"+
                ", dateEditModerator, messageForUser) VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,new Object[]{
                noPublicPet.getIdPet(),
                noPublicPet.getIdModerator(),
                noPublicPet.getCountEdit(),
                noPublicPet.getDateEditUser(),
                0,
                null
        });
    }

    @Override
    public NoPublicPet getNoPublicPetById(int idPet){
        String sql = "select * from noPublicPets where idPet=?";
        List<NoPublicPet> pets = jdbcTemplate.query(sql,new NoPublicPetRowMapper(),idPet);
        if(pets.size()==0)
            return null;
        else
            return pets.get(0);
    }

    @Override
    public List<NoPublicPet> getNoPublicPetsByModeratorId(int idModerator) {
        String sql = "select * from noPublicPets where idModerator=?";
        List<NoPublicPet> pets = jdbcTemplate.query(sql,new NoPublicPetRowMapper(),idModerator);
        if(pets.size()==0)
            return null;
        else
            return pets;
    }

    @Override
    public void updateNoPublicPetByModerator(String message, int idPet) {
        String sql = "update noPublicPets set messageForUser=? where idPet=?";
        jdbcTemplate.update(sql, new Object[]{
                message,
                idPet
        });
    }

    @Override
    public void updateNoPublicPetByModerator(int count, long date, int idPet) {
        String sql = "update noPublicPets set countEdit=?, dateEditModerator=? where idPet=?";
        jdbcTemplate.update(sql, new Object[]{
                count,
                date,
                idPet
        });
    }

    @Override
    public void updateNoPublicPetByUser(long date, int idPet) {
        String str = "";
        String sql = "update noPublicPets set dateEditUser=?, messageForUser=? where idPet=?";
        int a =jdbcTemplate.update(sql, new Object[]{
                date,
                str,
                idPet
        });
        System.out.println(a);
    }

    @Override
    public void deleteNoPublicPetById(int idPet) {
        String sql ="delete from noPublicPets where idPet=?";
        jdbcTemplate.update(sql, idPet);
    }

    @Override
    public void insertPet(Pet pet) {
        final String sql = "insert into pets (idType, gender, age, idCharacter"+
                ", idTraining, idEyeColor, idColor, price, name, annotation"+
                ", about, idUser, passImg, isPublic) VALUES (?, ?, ?, ?, ?, ?, ?, ?"+
                ", ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[] {
                pet.getIdType(),
                pet.getGender(),
                pet.getAge(),
                pet.getIdCharacter(),
                pet.getIdTraining(),
                pet.getIdEyeColor(),
                pet.getIdColor(),
                pet.getPrice(),
                pet.getName(),
                pet.getAnnotation(),
                pet.getAbout(),
                pet.getIdUser(),
                pet.getPassImg(),
                pet.getIsPublic()
        });
    }

    @Override
    public void updatePet(Pet pet) {
        String sql = "update pets set idType=?, gender=?, age=?, idCharacter=?"+
                              ", idTraining=?, idEyeColor=?, idColor=?, price=?, name=?, annotation=?" +
                                ", about=?, passImg=? where idPet=?";
        jdbcTemplate.update(sql, new Object[]{
                pet.getIdType(),
                pet.getGender(),
                pet.getAge(),
                pet.getIdCharacter(),
                pet.getIdTraining(),
                pet.getIdEyeColor(),
                pet.getIdColor(),
                pet.getPrice(),
                pet.getName(),
                pet.getAnnotation(),
                pet.getAbout(),
                pet.getPassImg(),
                pet.getIdPet()
        });
    }

    @Override
    public void updatePublicPet(int idPet) {
        boolean isPublic = true;
        String sql = "update pets set isPublic=? where idPet=?";
        jdbcTemplate.update(sql, new Object[]{
                isPublic,
                idPet
        });
    }

    @Override
    public void deletePetById(int idPet) {
        String sql ="delete from pets where idPet=?";
        jdbcTemplate.update(sql, idPet);
    }

    public Pet getPetByPassImg(String passImg){
        String sql = "select * from pets where passImg=?";
        List<Pet> pets = jdbcTemplate.query(sql,new PetRowMapper(),passImg);
        if(pets.size()==0)
            return null;
        else
            return pets.get(0);
    }

    @Override
    public List<Pet> getPetsByPublic(Boolean isPublic) {
        String sql = "select * from pets where isPublic=?";
        List<Pet> pets = jdbcTemplate.query(sql,new PetRowMapper(),isPublic);
        if(pets.size()==0)
            return null;
        else
            return pets;
    }

    @Override
    public List<Pet> getPetsByUserId(int idUser){
        String sql = "select * from pets where idUser=?";
        List<Pet> pets = jdbcTemplate.query(sql,new PetRowMapper(),idUser);
        if(pets.size()==0)
            return null;
        else
            return pets;
    }

    @Override
    public Pet getPetById(int idPet) {
        if(idPet == 0) return null;

        String sql = "select * from pets where idPet=?";
        List<Pet> pets = jdbcTemplate.query(sql, new PetRowMapper(),idPet);

        if(pets.size() != 0)
            return pets.get(0);
        else
            return null;
    }

    @Override
    public ParamPet getTypePetById(int idType) {
        String tableName = "typesPet";
        return getParamPetById(idType,tableName);
    }

    @Override
    public List<ParamPet> getAllTypePet() {
        String tableName = "typesPet";
        return getAllParamPet(tableName);
    }

    @Override
    public ParamPet getCharacterPetById(int idCharacter) {
        String tableName = "charactersPet";
        return getParamPetById(idCharacter,tableName);
    }

    @Override
    public List<ParamPet> getAllCharacterPet() {
        String tableName = "charactersPet";
        return getAllParamPet(tableName);
    }

    @Override
    public ParamPet getTrainingPetById(int idTraining) {
        String tableName = "trainingsPet";
        return getParamPetById(idTraining,tableName);
    }

    @Override
    public List<ParamPet> getAllTrainingPet() {
        String tableName = "trainingsPet";
        return getAllParamPet(tableName);
    }

    @Override
    public ParamPet getEyeColorPetById(int idEyeColor) {
        String tableName = "eyeColorsPet";
        return getParamPetById(idEyeColor,tableName);
    }

    @Override
    public List<ParamPet> getAllEyeColorPet() {
        String tableName = "eyeColorsPet";
        return getAllParamPet(tableName);
    }

    @Override
    public ParamPet getColorPetById(int idColor) {
        String tableName = "colorsPet";
        return getParamPetById(idColor,tableName);
    }

    @Override
    public List<ParamPet> getAllColorPet() {
        String tableName = "colorsPet";
        return getAllParamPet(tableName);
    }

    @Override
    public List<Pet> getPetsByParam(String[] paramColumn, Integer[] paramValue) {

        int countParam = paramColumn.length;
        if(countParam<1)
            return null;

        String sql = "select * from pets where ("+paramColumn[0]+" like ?)";

        if (1<countParam)
            for(int i =1; i<paramColumn.length; i++){
                sql+=("and ("+paramColumn[i] + " like ?)");
            }

        List<Pet> result = jdbcTemplate.query(sql, new PetRowMapper(), paramValue);
        if(result.size()==0)
            return null;
        else
            return result;
    }

    private ParamPet getParamPetById(int idParam, String tableName) {

        if(idParam == 0) return new ParamPet();

        String sql = "select * from "+tableName+" where idParamPet=?";
        List<ParamPet> params = jdbcTemplate.query(sql, new ParamPetRowMapper(),idParam);

        if(params.size() != 0)
            return params.get(0);
        else
            return new ParamPet();
    }

    private List<ParamPet> getAllParamPet(String tableName){
        String sql = "select * from "+tableName;
        List<ParamPet> params = jdbcTemplate.query(sql, new ParamPetRowMapper());
        if(params.size()!=0)
            return params;
        else
            return null;
    }

    private static final class PetRowMapper implements RowMapper<Pet> {
        @Override
        public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
            Pet pet = new Pet();
            pet.setIdPet(rs.getInt("idPet"));
            pet.setIdType(rs.getInt("idType"));
            pet.setGender(rs.getString("gender"));
            pet.setAge(rs.getInt("age"));
            pet.setIdCharacter(rs.getInt("idCharacter"));
            pet.setIdTraining(rs.getInt("idTraining"));
            pet.setIdEyeColor(rs.getInt("idEyeColor"));
            pet.setIdColor(rs.getInt("idColor"));
            pet.setPrice(rs.getInt("price"));
            pet.setName(rs.getString("name"));
            pet.setAnnotation(rs.getString("annotation"));
            pet.setAbout(rs.getString("about"));
            pet.setIdUser(rs.getInt("idUser"));
            pet.setPassImg(rs.getString("passImg"));
            pet.setIsPublic(rs.getBoolean("isPublic"));
            return pet;
        }
    }

    private static final class ParamPetRowMapper implements RowMapper<ParamPet> {
        @Override
        public ParamPet mapRow(ResultSet rs, int rowNum) throws SQLException {
            ParamPet param = new ParamPet();
            param.setIdParamPet(rs.getInt("idParamPet"));
            param.setNameParamPet(rs.getString("nameParamPet"));
            return param;
        }
    }

    private static final class NoPublicPetRowMapper implements RowMapper<NoPublicPet> {
        @Override
        public NoPublicPet mapRow(ResultSet rs, int rowNum) throws SQLException {
            NoPublicPet noPublicPet = new NoPublicPet();
            noPublicPet.setIdPet(rs.getInt("idPet"));
            noPublicPet.setIdModerator(rs.getInt("idModerator"));
            noPublicPet.setCountEdit(rs.getInt("countEdit"));
            noPublicPet.setDateEditUser(rs.getLong("dateEditUser"));
            noPublicPet.setDateEditModerator(rs.getLong("dateEditModerator"));
            noPublicPet.setMessageForUser(rs.getString("messageForUser"));
            return noPublicPet;
        }
    }

}
