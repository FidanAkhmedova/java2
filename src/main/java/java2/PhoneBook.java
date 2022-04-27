package java2;import java.util.ArrayList;
import java.util.*;
public class PhoneBook {

    private Map<String, ArrayList> people;

    public PhoneBook(){
         people = new HashMap<String, ArrayList>();
    }

    public void add(String surname, ArrayList<String> phones){
        if (people.containsKey(surname)){
            people.get(surname).addAll(phones);
        }
        else{
            people.put(surname, phones);
        }
    }

    public void add(String surname, String phone){
        if (people.containsKey(surname)){
            people.get(surname).add(phone);
        }
        else{
            ArrayList<String> phones = new ArrayList<String>();
            phones.add(phone);
            people.put(surname, phones);
        }
    }

    public void get(){
        for (Map.Entry<String, ArrayList> item : people.entrySet()){
            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
        }
    }
}
