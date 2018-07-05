/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promdashboard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class GraphDAOImpl implements GraphDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GraphDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<List<Map<Object, Object>>> getTalentCategoryPieData() {

        String sql = "SELECT COUNT(t.id) as numberOfTalent, t.country FROM  talent as t, category as c WHERE t.categoryid=c.id GROUP BY t.country";

        List<Map<Object, Object>> dataPoints = jdbcTemplate.query(sql, new RowMapper<Map<Object, Object>>() {
            @Override
            public Map<Object, Object> mapRow(ResultSet rs, int i) throws SQLException {

                Map<Object, Object> data = new HashMap<Object, Object>();
                data.put("name", rs.getString("country"));
                data.put("y", rs.getInt("numberOfTalent"));

                return data;
            }

        });

        List<List<Map<Object, Object>>> data = new ArrayList<List<Map<Object, Object>>>();
        data.add(dataPoints);

        return data;
    }
}
