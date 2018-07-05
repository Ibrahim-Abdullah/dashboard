/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promdashboard.dao;

import java.util.List;
import java.util.Map;

/**
 *
 * @author AMRE
 */
public interface GraphDAO {
    
    public List<List<Map<Object,Object>>> getTalentCategoryPieData();
    
}
