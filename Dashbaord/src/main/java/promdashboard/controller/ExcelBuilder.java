/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promdashboard.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import promdashboard.model.Person;

/**
 *
 * @author AMRE
 */
public class ExcelBuilder extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> map, org.apache.poi.ss.usermodel.Workbook workbook,
            HttpServletRequest htttpRequest, HttpServletResponse httpResponse) throws Exception {

        httpResponse.setHeader("Content-Disposition", "attachment;filename=\"promytheus.xls\"");

        List<Person> persons = (List<Person>) map.get("persons");

        //Create excel sheet
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date currentDate = new Date();
        Sheet sheet = workbook.createSheet("promytheus Data");
        
        //header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Firstname");
        header.createCell(1).setCellValue("Lastname");
        header.createCell(2).setCellValue("Talent Score");
        header.createCell(3).setCellValue("Promytheus Score");
        header.createCell(4).setCellValue("Country");
        header.createCell(5).setCellValue("Talent Category");

        //Create sheet content from the list of persons and their talent
        int rowNumber = 1;
       
        for (Person person : persons) {

            Row row = sheet.createRow(rowNumber++);
            row.createCell(0).setCellValue(person.getTalent().getFirstname());
            row.createCell(1).setCellValue(person.getTalent().getLastname());
            row.createCell(2).setCellValue(person.getTalent().getScorefinal());
            row.createCell(3).setCellValue(person.getTalent().getScorefinal());
            row.createCell(4).setCellValue(person.getTalent().getCountry());
            row.createCell(5).setCellValue(person.getTalentCategoryName());
        }

    }

}
