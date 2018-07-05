/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promdashboard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import promdashboard.model.Person;
import promdashboard.model.Talent;

/**
 *
 * @author braim
 */
@Service
public class PersonDaoImp implements PersonDao {

    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public PersonDaoImp(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Person get(int contactId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> listAll() {
        String sql = "SELECT t.id, t.firstname, t.lastname, t.scorefinal, t.country, c.name FROM talent as t, category as c WHERE t.categoryid = c.id";
        List<Person> persons = jdbcTemplate.query(sql, new RowMapper<Person>() {

            @Override
            public Person mapRow(ResultSet rs, int i) throws SQLException {
                Person person = new Person();
                Talent talent = new Talent();

                //Retrive query set data
                talent.setId(rs.getInt("id"));
                talent.setFirstname(rs.getString("firstname"));
                talent.setLastname(rs.getString("lastname"));
                talent.setScorefinal(rs.getDouble("scorefinal"));
                talent.setCountry(rs.getString("country"));
                //create person object
                person.setTalentCategoryName(rs.getString("name"));
                person.setTalent(talent);

                return person;

            }

        });

        return persons;
    }

    @Override
    public List<Person> search(String tableName, String columnName, String text) {

        String sql;
        if (tableName.equalsIgnoreCase("talent")) {
            sql = "SELECT t.id, t.firstname, t.lastname, t.scorefinal, t.country, c.name FROM talent as t, category as c "
                    + "WHERE t." + columnName + "= '" + text + "' AND t.categoryid = c.id";
        } else {
            columnName = "name";
            sql = "SELECT t.id, t.firstname, t.lastname, t.scorefinal, t.country, c.name FROM talent as t, category as c "
                    + "WHERE c." + columnName + "= '" + text + "' AND t.categoryid = c.id";
        }
        List<Person> persons = jdbcTemplate.query(sql, new RowMapper<Person>() {

            @Override
            public Person mapRow(ResultSet rs, int i) throws SQLException {
                Person person = new Person();
                Talent talent = new Talent();

                //Retrive query set data
                talent.setId(rs.getInt("id"));
                talent.setFirstname(rs.getString("firstname"));
                talent.setLastname(rs.getString("lastname"));
                talent.setScorefinal(rs.getDouble("scorefinal"));
                talent.setCountry(rs.getString("country"));
                //create person object
                person.setTalentCategoryName(rs.getString("name"));
                person.setTalent(talent);

                return person;

            }

        });

        return persons;

    }

    @Override
    public List<String> getCountries() {
        String sql = "SELECT DISTINCT t.country FROM talent as t";
        List<String> countries = jdbcTemplate.query(sql, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int i) throws SQLException {
                String country = "";
                //Retrive query set data
                country = rs.getString("country");

                return country;
            }

        });
        return countries;
    }

    @Override
    public List<String> getTalentCategories() {
        String sql = "SELECT DISTINCT c.name FROM category as c";
        List<String> talentCategories = jdbcTemplate.query(sql, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int i) throws SQLException {
                String talentName = "";
                //Retrive query set data
                talentName = rs.getString("name");

                return talentName;
            }

        });
        return talentCategories;
    }

    @Override
    public List<Person> search(Map<String, String> params) {

        if (params.containsKey("talent")) {
            return searchWithTalentParam(params);
        } else if (!(params.containsKey("talent"))) {
            return searchWithoutTalentParam(params);
        }
        return null;
    }

    private List<Person> searchWithTalentParam(Map<String, String> params) {

        StringBuilder query = new StringBuilder("SELECT t.id, t.firstname, t.lastname, t.scorefinal, t.country, c.name FROM talent as t, category as c  WHERE ");

        //Build qquery with columns in the talent table
        String t = "";
        for (Map.Entry<String, String> entry : params.entrySet()) {

            if (!entry.getKey().equalsIgnoreCase("talent")) {
                String nt = "t." + entry.getKey() + "='" + entry.getValue() + "' AND ";
                query.append(nt);
            } else {
                t = "c.name='" + entry.getValue() + "' AND t.categoryid = c.id";
            }
        }
        query.append(t);

        List<Person> persons = jdbcTemplate.query(query.toString(), new RowMapper<Person>() {

            @Override
            public Person mapRow(ResultSet rs, int i) throws SQLException {
                Person person = new Person();
                Talent talent = new Talent();

                //Retrive query set data
                talent.setId(rs.getInt("id"));
                talent.setFirstname(rs.getString("firstname"));
                talent.setLastname(rs.getString("lastname"));
                talent.setScorefinal(rs.getDouble("scorefinal"));
                talent.setCountry(rs.getString("country"));
                //create person object
                person.setTalentCategoryName(rs.getString("name"));
                person.setTalent(talent);

                return person;

            }

        });

        return persons;
    }

    
    /**
     * 
     * @param params
     * @return 
     */
    private List<Person> searchWithoutTalentParam(Map<String, String> params) {

        StringBuilder query = new StringBuilder("SELECT t.id, t.firstname, t.lastname, t.scorefinal, t.country, c.name FROM talent as t, category as c  WHERE ");

        //Build qquery with columns in the talent table
        String t = "t.categoryid = c.id";
        for (Map.Entry<String, String> entry : params.entrySet()) {

            if (!entry.getKey().equalsIgnoreCase("talent")) {
                String nt = "t." + entry.getKey() + "='" + entry.getValue() + "' AND ";
                query.append(nt);
            }
        }
        query.append(t);

        List<Person> persons = jdbcTemplate.query(query.toString(), new RowMapper<Person>() {

            @Override
            public Person mapRow(ResultSet rs, int i) throws SQLException {
                Person person = new Person();
                Talent talent = new Talent();

                //Retrive query set data
                talent.setId(rs.getInt("id"));
                talent.setFirstname(rs.getString("firstname"));
                talent.setLastname(rs.getString("lastname"));
                talent.setScorefinal(rs.getDouble("scorefinal"));
                talent.setCountry(rs.getString("country"));
                //create person object
                person.setTalentCategoryName(rs.getString("name"));
                person.setTalent(talent);

                return person;

            }

        });

        return persons;
    }

}
