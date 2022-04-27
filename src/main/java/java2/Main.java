package java2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> people = new ArrayList<String>();
        people.add("Tom");
        people.add("Alice");
        people.add("Tom");
        people.add("Alice");
        people.add("Sam");
        people.add("Alice");

        Map<String, Integer> names = new HashMap<String, Integer>();
        Map<String, Integer> surnames = new HashMap<String, Integer>();

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Akhmedov", "78967");
        phoneBook.add("Akhmedov", "999999");
        phoneBook.add("Simpsons", "654");
        ArrayList phones = new ArrayList<String>();
        phones.add("555");
        phones.add("789");
        phoneBook.add("Akhmedova", phones);
        phoneBook.get();
        for(String person : people){
            int k = 1, j = 0, i = 0;
            for (String person1: people) {
                if (person == person1) {
                    names.put (person1, k++);
                }
                i++;
            }
            j++;
        }
        for (Map.Entry<String, Integer> item : names.entrySet()){
            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
        }

    }
}
