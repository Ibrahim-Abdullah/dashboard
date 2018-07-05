/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promdashboard.model;

/**
 *
 * @author braim
 */
public class Person {
    private Talent talent;
    private String talentCategoryName;

    public Person(){
        
    }
    public Person(Talent talent, String talentCategoryName) {
        this.talent = talent;
        this.talentCategoryName = talentCategoryName;
    }

    public Talent getTalent() {
        return talent;
    }

    public void setTalent(Talent talent) {
        this.talent = talent;
    }

    public String getTalentCategoryName() {
        return talentCategoryName;
    }

    public void setTalentCategoryName(String talentCategoryName) {
        this.talentCategoryName = talentCategoryName;
    }

    @Override
    public String toString() {
        return "Person{" + "talent=" + talent.toString() + ", talentCategoryName=" + talentCategoryName + '}';
    }
    
    
}
