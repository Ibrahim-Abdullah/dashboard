/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promdashboard.model;

/**
 *
 * @author AMRE
 */
public class CSVRecordClass {
    
    private String firstName;
    private String lastName;
    private String talent;
    private String talentScore;
    private String promytheusScore;
    private String country;

    public CSVRecordClass(Person person) {
        this.firstName = person.getTalent().getFirstname();
        this.lastName = person.getTalent().getLastname();
        this.talent = person.getTalentCategoryName();
        this.talentScore = person.getTalent().getScorefinal().toString();
        this.promytheusScore = person.getTalent().getScorefinal().toString();
        this.country = person.getTalent().getCountry();
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTalent() {
        return talent;
    }

    public void setTalent(String talent) {
        this.talent = talent;
    }

    public String getTalentScore() {
        return talentScore;
    }

    public void setTalentScore(String talentScore) {
        this.talentScore = talentScore;
    }

    public String getPromytheusScore() {
        return promytheusScore;
    }

    public void setPromytheusScore(String promytheusScore) {
        this.promytheusScore = promytheusScore;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
}
