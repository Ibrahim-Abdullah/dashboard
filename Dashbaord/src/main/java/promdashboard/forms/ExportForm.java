/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promdashboard.forms;

import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

/**
 *
 * @author AMRE
 */

@Component
public class ExportForm {
    
    @NotNull
    private String fileType;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    
    
}
