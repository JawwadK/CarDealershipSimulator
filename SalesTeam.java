import java.util.*;
public class SalesTeam{
    private LinkedList<String> salesPeople = new LinkedList<String>();
    public SalesTeam(){
    salesPeople.add("Lisa");
    salesPeople.add("Mary");
    salesPeople.add("Monica");
    salesPeople.add("Sasha");
    salesPeople.add("Erica");
    salesPeople.add("Rita");
    }
    public String returnSalesPerson(){
        Random rnd = new Random();
        int ranindex = rnd.nextInt(5);
        int count = 0;
        Iterator itr = salesPeople.iterator();
        while(count < ranindex){
            itr.next();
            count++;
        }
        return (String)itr.next();
    }
}
