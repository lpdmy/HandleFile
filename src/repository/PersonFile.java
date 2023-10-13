package repository;

import dataAccess.PersonDao;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import model.Person;

public class PersonFile implements IPersonFile{
    
    @Override
    public void readFile(ArrayList<Person> personList, String path) {
        PersonDao.Instance().readFile(personList, path);
    }
    

    @Override
    public boolean writeFile(ArrayList<Person> personList, String path) {
        return PersonDao.Instance().saveFile(personList, path);
    }

    @Override
    public void display(ArrayList<Person> persons, double minValue) {
        double max, min;
        System.out.println("------------Result-----------");
        System.out.println("Name\tAddress\tMoney");
        for (Person person : persons) {
            if (person.getSalary()>minValue) {
                System.out.println(person);
                
            }
        }
    }

    
 
}
