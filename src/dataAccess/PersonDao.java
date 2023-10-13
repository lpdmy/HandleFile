package dataAccess;

import common.Library;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import model.Person;
import validation.Validation;

public class PersonDao {

    Library lib = new Library();
    Validation val = new Validation();
    private static PersonDao instance = null;

    public static PersonDao Instance() {
        if (instance == null) {
            synchronized (PersonDao.class) {
                if (instance == null) {
                    instance = new PersonDao();
                }
            }
        }
        return instance;
    }

    public void readFile(ArrayList<Person> perList, String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String arr[] = line.split(";");
                int count =0 ;
                if (arr.length == 3) {
                    if (!arr[0].trim().isEmpty()) {
                    Person s = new Person(arr[0], arr[1], val.checkDoule(arr[2]));
                    for (Person person : perList) {
                        if (s.equals(perList)) count++;
                    }
                    if (count==0) perList.add(s);
                }}
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception e) {
            System.err.println("A exception occur: " + e.getMessage());
        }
    }
    
        //Write file
    public boolean saveFile(ArrayList<Person> perList,String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
                for (Person t : perList ) {
                String line = t.getName()+ ";" + t.getAddress()+ ";" + t.getSalary();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            osw.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
     public void display(ArrayList<Person> persons, double minValue) {
        double max = 0, min = Double.MAX_VALUE;
        Person maxPerson=null, minPerson=null;
        System.out.println("------------Result-----------");
        System.out.println("Name\tAddress\tMoney");
        for (Person person : persons) {
            if (person.getSalary()>minValue) {
                System.out.println(person);
                if (person.getSalary()>max) {max = person.getSalary(); maxPerson = person;}
                if (person.getSalary()<min) {min = person.getSalary(); minPerson = person;}
            }
            System.out.println("MAX: "+maxPerson.getName());
            System.out.println("MIN: "+minPerson.getName());
        }
    }
}
