/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promdashboard.converters;

import promdashboard.model.FilterCategory;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author AMRE
 */
public class SearchCategoryConverter extends PropertyEditorSupport{
        //This will be called when user HTTP Post to server a field bound to DepartmentVO
    @Override
    public void setAsText(String searchCategoryId) {
        FilterCategory filterCategory;
        switch (Integer.parseInt(searchCategoryId)) {
            case 1:
                filterCategory = new FilterCategory(1, "country");
                break;
            case 2:
                filterCategory = new FilterCategory(2, "talent");
                break;
            case 3:
                filterCategory = new FilterCategory(3, "interest level");
                break;
            default:
                filterCategory = null;
        }

        this.setValue(filterCategory);
    }
    
}
