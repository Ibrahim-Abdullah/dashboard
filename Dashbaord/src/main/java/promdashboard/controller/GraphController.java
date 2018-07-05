/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promdashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import promdashboard.dao.GraphDAO;

/**
 *
 * @author AMRE
 */
@Controller
@RequestMapping("/graph")
public class GraphController {

    @Autowired
    private GraphDAO graphDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String showGraphs(Model model) {

        model.addAttribute("countrychart", graphDAO.getTalentCategoryPieData());
        

        return "graphs";
    }

}
