/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promdashboard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import promdashboard.converters.FiletypeConverter;
import promdashboard.converters.SearchCategoryConverter;
import promdashboard.dao.PersonDao;
import promdashboard.forms.ExportForm;
import promdashboard.model.Filetypes;
import promdashboard.model.Person;
import promdashboard.model.FilterCategory;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import promdashboard.forms.SearchForm;
import promdashboard.model.CSVRecordClass;

/**
 *
 * @author braim
 */
@Controller
//@RequestMapping(value = "/dashboard")
public class DashboardController {

    @Autowired
    private PersonDao personDao;

    private List<Person> currentSearchResult = new ArrayList<>();

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Filetypes.class, new FiletypeConverter());
        binder.registerCustomEditor(FilterCategory.class, new SearchCategoryConverter());
    }

    /**
     * Handles request using the root url promyTheus/
     *
     * @param model Model object
     * @return The view to shows
     */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String showDashBoard(Model model) {

        //Build list items tom show on the dashboard
        this.currentSearchResult = personDao.listAll();
        List<String> countries = personDao.getCountries();
        List<String> talents = personDao.getTalentCategories();
        countries.add(0, "Select Country");
        talents.add(0, "Select Talent Category");

        //Build model attributes for display on the dashboard
        model.addAttribute("persons", this.currentSearchResult);
        model.addAttribute("fileTypes", this.getFileType());
        model.addAttribute("fileTypeForm", new ExportForm());
        model.addAttribute("searchForm", new SearchForm());
        model.addAttribute("countries", countries);
        model.addAttribute("talents", talents);

        return "dashboard";
    }

    /**
     * Handles post request from the dashboard to perform search.
     *
     * @param model Model object
     * @param searchForm SearchForm object
     * @param bindingResult Binding result object for validating form field
     * @return the view to show on the dashboard
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(Model model, @Valid SearchForm searchForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            //display dashbaord with a notification of incorrect search terms 
            //and display all the data 
        }

        //Build search parameters for query
        Map<String, String> params = new HashMap<String, String>();

        if ((searchForm.getFirstname() != null) && (searchForm.getFirstname() != "")) {
            params.put("firstname", searchForm.getFirstname());
        }
        if ((searchForm.getLastname() != null) && (searchForm.getLastname() != "")) {
            params.put("lastname", searchForm.getLastname());
        }
        if (!searchForm.getCountry().equalsIgnoreCase("Select Country")) {
            params.put("country", searchForm.getCountry());
        }
        if (!(searchForm.getTalent().equalsIgnoreCase("Select Talent Category"))) {
            params.put("talent", searchForm.getTalent());
        }

        //send query to DAO to seearch database
        this.currentSearchResult = personDao.search(params);
        List<String> countries = personDao.getCountries();
        List<String> talents = personDao.getTalentCategories();
        countries.add(0, "Select Country");
        talents.add(0, "Select Talent Category");

        //Build model attribute to show in on the dashbaord
        model.addAttribute("persons", this.currentSearchResult);
        model.addAttribute("fileTypes", this.getFileType());
        model.addAttribute("fileTypeForm", new ExportForm());
        model.addAttribute("searchForm", new SearchForm());
        model.addAttribute("countries", countries);
        model.addAttribute("talents", talents);

        //return dashbaord view
        return "dashboard";
    }

    /**
     * Handle request to export data into excel, CSV and PDF format
     *
     * @param model Model object
     * @param exportForm Export data form
     * @param response HttpServletResponse object
     * @return The view to show
     * @throws Exception
     */
    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public ModelAndView exportData(Model model, @Valid ExportForm exportForm,
            HttpServletResponse response) throws Exception {

        if (exportForm.getFileType().equalsIgnoreCase("excel")) {

            System.out.println("Downloading excel data");
            return new ModelAndView(new ExcelBuilder(), "persons", this.currentSearchResult);
        } else if (exportForm.getFileType().equalsIgnoreCase("csv")) {
            this.generateCSVDataFile(response);
        }

        return new ModelAndView(new ExcelBuilder(), "persons", this.currentSearchResult);
    }

    /**
     * Build search file types for display in the drop down in the search form
     *
     * @return List of file types
     */
    private List<Filetypes> getFileType() {
        List<Filetypes> filetypes = new ArrayList<Filetypes>();
        filetypes.add(new Filetypes(-1, "Select File Types"));
        filetypes.add(new Filetypes(1, "Excel"));
        filetypes.add(new Filetypes(2, "CSV"));
        filetypes.add(new Filetypes(3, "PDF"));

        return filetypes;
    }

    /**
     * Generate CSV data from current showing data on the dashboard
     *
     * @param response HttpServeletResponse object
     * @throws Exception
     */
    private void generateCSVDataFile(HttpServletResponse response) throws Exception {

        String filename = "promytheus.csv";
        response.setHeader("Content-Disposition", "attachment;filename=\"promytheus.csv\"");

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        String[] header = {"Firstname", "Lastname", "Talent", "TalentScore", "PromytheusScore", "Country"};
        csvWriter.writeHeader(header);

        for (Person person : this.currentSearchResult) {
            csvWriter.write(new CSVRecordClass(person), header);
        }
        csvWriter.close();
    }
}
