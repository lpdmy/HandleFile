package controller;

import common.Library;
import java.util.ArrayList;
import model.Person;
import repository.PersonFile;
import view.Menu;

public class PersonController extends Menu<String>{
    Library lib = new Library();
    ArrayList<Person> perList = new ArrayList<>();
    PersonFile personFile = new PersonFile();
    static String[] mc = {"Find person info", "Copy Text to new file", "Exit"}; 
    public PersonController() {
        super("==========FILE PROCESSING==========", mc);
    }
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                perList.clear();
                String path = lib.getString("Enter path");
                double minValue = lib.getDouble("Enter Money", 0, Double.MAX_VALUE);
                personFile.readFile(perList, path);
                personFile.display(perList, minValue);
                break;
                
            case 2:
                perList.clear();
                String path1 = lib.getString("Enter source");
                String path2 = lib.getString("Copy text to new file");
                personFile.readFile(perList, path1);
                if (personFile.writeFile(perList, path2)) System.err.println("Copy done..");;
            case 3:
                System.exit(0);
        }
    }
    

}
