/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Person;

import BusinessReliefPortal.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author ankitgoyal
 */
public class PersonDirectory {
    public ArrayList<Person> personDir;

    public PersonDirectory() {
        personDir = new ArrayList<>();
    }

    public ArrayList<Person> getPersonDir() {
        return personDir;
    }

    public void setPersonDir(ArrayList<Person> personDir) {
        this.personDir = personDir;
    }
    
//    public Person addPerson(){
//        Person person = new Person();
//        personDir.add(person);
//        return person;
//    }
    
    public Person addPerson(Person person){
        personDir.add(person);
        return person;
    }
    
    public Person addPerson(String name, String email, String profilePic, String activeStatus){
        Person person = new Person( name,  email,  profilePic,  activeStatus);
        personDir.add(person);
        return person;
    }
    
    
    
}
