
package airlines;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Airlines {
    public static void main(String[] args) {
        
        ArrayList<Airports> airports=new ArrayList<>();   // because of object type as Airports now different data types list, can be worked upon 
    try{
        Scanner a=new Scanner (new File("airports_mod.dat"));
        
        while(a.hasNext()){
           String [] data=a.nextLine().split(",");    
           Airports air=new Airports();
           
           if(data.length==12){
           air.setAirpID(Integer.parseInt(data[0]));
           air.setAirpname(data[1]);
           air.setCity(data[2]);
           air.setCountry(data[3]);
           air.setIATA(data[4]);
           air.setICAO(data[5]);
           air.setLatitude(Double.parseDouble(data[6])); 
           air.setLongtitude(Double.parseDouble(data[7]));
           air.setAltitude(Integer.parseInt(data[8]));
           air.setTimezh(Float.parseFloat(data[9]));
           air.setDST(data[10]+data[11]);
            
            airports.add(air);
            }
        }
        
       
     //1. airports operating in contry India
     
        List<Airports> l=airports.stream().filter(b->b.getCountry().equalsIgnoreCase("India")).collect(Collectors.toList());
        
        for(Airports c:l)
            System.out.println(c.getAirpname());
        
        System.out.println("----------------------------------------------------------\n");
        
      //4.country with highest no. of airports
      
       Iterator<Airports> l1=airports.iterator();
       ArrayList<String> t=new ArrayList<>();
       while(l1.hasNext()){
           
           
           Airports element=l1.next();
           String s=element.getCountry();
           
           t.add(s);
           
       }
        Collections.sort(t);
        String s=""; 
        Long count=0L;
        
        Map<String,Long> m=airports.stream().collect(Collectors.groupingBy(p->p.getCountry(),Collectors.counting()));
        
      for(Map.Entry<String,Long> k:m.entrySet()){
          
         Long i=k.getValue();
       
        if(i>count)
        {count=i;
        s=k.getKey();}
       
      }
        System.out.println(s+" "+count);
                    
        
        
    }catch(Exception e)
    {
}
    }}