/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promdashboard.dao;

import java.util.List;
import java.util.Map;
import promdashboard.model.Person;
import promdashboard.model.Talent;

/**
 *
 * @author braim
 */
public interface PersonDao {

    public Person get(int contactId);

    public List<Person> listAll();
    
    public List<Person> search(String tableName,String columnName, String text);
    
    public List<String> getCountries();
    
    public List<String> getTalentCategories();
    
    public List<Person> search(Map<String,String> params);
}
