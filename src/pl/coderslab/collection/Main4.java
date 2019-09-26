package pl.coderslab.collection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

public class Main4 {

    public static void main(String[] args) {

        try {
            List<Person> data = readDataFromCSV("src/pl/coderslab/collection/people.csv");

            //print all the person read from CSV file
        for (Person person : data) {
            System.out.println(person);
        }

            Map<Integer, List<Person>> peopleByAge = getMap(data);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No such file or path not correct");
        }



    }

    private static List<Person> readDataFromCSV(String fileName) throws IOException {
        List<Person> persons = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        for(String line: Files.readAllLines(pathToFile)) {

            String[] data = line.split("\\s*,\\s*");
            //\s* means “match any white space zero or more times”.
            // We look for this before and after the comma

            boolean email = false;
            boolean firstName = false;
            boolean lastName = false;
            boolean age = false;
            boolean city = false;

            String emailPattern = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}";
            String pattern = "[a-zA-Z]+";
            String agePattern = "([0-9]|[1-9][0-9]| 1[01][0-9])";

            if(data.length == 5) {
               email = data[0].matches(emailPattern);
               firstName = data[1].matches(pattern);
               lastName = data[2].matches(pattern);
               age = data[3].matches(agePattern);
               city = data[4].matches(pattern);
            }

            if(email&&firstName&&lastName&&age&&city) {
                Integer personAge = Integer.parseInt(data[3]);
                Person person = new Person(data[1], data[2], personAge, data[4]);
                persons.add(person);
            }
        }
        return persons;
    }

    public static Map<Integer, List<Person>> getMap (List<Person> list) {

        Map<Integer, List<Person>> peopleByAge = new HashMap<>();//utworzenie mapy


        for(int i=0; i<list.size(); i++) {
            Person person = list.get(i);
            System.out.println(person);
            if(!peopleByAge.containsKey(person.getAge())) {
                peopleByAge.put(person.getAge(), new ArrayList<>());
            }

            peopleByAge.get(person.getAge()).add(person);
        }
//Iterując po liście z zadania 4 umieść dane w powyższej mapie:
//kluczem ma być wiek,
//wartością - lista osób w wieku takim jak wartość zapisana jako klucz.

        for (Map.Entry<Integer, List<Person>> entry : peopleByAge.entrySet()) {
            Integer key = entry.getKey();
            List<Person> value = entry.getValue();
            System.out.println(key + ": " + value);
        }


        return peopleByAge;
    }

}
