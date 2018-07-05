/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promdashboard.forms;

import promdashboard.model.FilterCategory;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

/**
 *
 * @author AMRE
 */
@Component
public class FilterForm {

    @NotNull
    private FilterCategory category;
    @NotNull
    private String text;

    public FilterCategory getCategory() {
        return category;
    }

    public void setCategory(FilterCategory category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
     
}
