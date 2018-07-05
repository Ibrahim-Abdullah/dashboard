/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promdashboard.converters;

import promdashboard.model.Filetypes;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author AMRE
 */
public class FiletypeConverter extends PropertyEditorSupport {
    //This will be called when user HTTP Post to server a field bound to DepartmentVO

    @Override
    public void setAsText(String filetypesId) {
        Filetypes filetypes;
        switch (Integer.parseInt(filetypesId)) {
            case 1:
                filetypes = new Filetypes(1, "Excel");
                break;
            case 2:
                filetypes = new Filetypes(2, "CSV");
                break;
            case 3:
                filetypes = new Filetypes(3, "PDF");
                break;
            default:
                filetypes = null;
        }

        this.setValue(filetypes);
    }
}
