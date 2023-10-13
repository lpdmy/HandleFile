/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import model.Person;

/**
 *
 * @author lpdie
 */
public interface IPersonFile {
    public void readFile(ArrayList<Person> personList,String path);
    public boolean writeFile(ArrayList<Person> personList, String path);
    public void display(ArrayList<Person> persons, double minValue);
}
