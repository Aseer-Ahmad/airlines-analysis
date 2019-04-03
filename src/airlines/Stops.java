
package airlines;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Stops {
    public static void main(String...args){
        
      ArrayList<Routes> a=new ArrayList<>();
      ArrayList<lineData> b=new ArrayList<>();
        try{
            
            Scanner s=new Scanner(new File("routes.dat"));
            
            while(s.hasNext()){
                
             String []data=s.nextLine().split(",");
             Routes r=new Routes();
             if(data.length==9){
                 
                        r.setAirlC(data[0]);
                        r.setAirlID(data[1]);
                        r.setSairpC(data[2]);
                        r.setSairpID(data[3]);
                        r.setDairpC(data[4]);
                        r.setDairpID(data[5]);
                        r.setCodeshare(data[6]);
                        r.setStop(Integer.parseInt(data[7]));
                        r.setEquip(data[8]);
                 
                 a.add(r);
                 
             }
                  
            }
         
            
            Scanner s1=new Scanner(new File("Final_Airlines"));
             
            while(s1.hasNext()){
                
                String []data=s1.nextLine().split(",");
                lineData l=new lineData();
                
                   
                
                        l.setAirlID(data[0]);
                        l.setAirname(data[1]);
                        l.setAlias(data[2]);
                        l.setIATA(data[3]);
                        l.setICAO(data[4]);
                        l.setCallsign(data[5]);
                        l.setCountry(data[6]);
                        l.setActive(data[7]);
                    
                    b.add(l);
                 
            }
        //2. for airlines having zero stops 
            
            String k="";
          List<Routes> l=a.stream().filter(c->c.getStop()==0).collect(Collectors.toList());
           
            for(Routes r:l){
                String c=r.getAirlID();
                
                 if(!(k.equals(c))){
                     
                          List<lineData> l1=b.stream().filter(d->d.getAirlID().equals(c)).collect(Collectors.toList());
                          for(lineData t:l1)
                                System.out.println(t.getAirname());      
               
                 }
                 k=c;
            }
            System.out.println("--------------------------------------------------------\n");
                 
            //3. for airlines operating with codeshare
            
            List<Routes> l2=a.stream().filter(e->e.getCodeshare().equals("Y")).collect(Collectors.toList());
            k="";
            for(Routes r:l2){
                String c=r.getAirlID();
                 if(!(k.equals(c))){
                 List<lineData> l1=b.stream().filter(d->d.getAirlID().equals(c)).collect(Collectors.toList());
                          for(lineData t:l1)
                                System.out.println(t.getAirname());      
                     }
            k=c;
            }
                 
            System.out.println("---------------------------------------------------------\n");
           
            //5. airlines active in united state
            
            List<lineData> l3=b.stream().filter(e->e.getActive().equals("Y") && e.getCountry().equals("United States")).collect(Collectors.toList());
            
            for(lineData l1:l3){
                
                System.out.println(l1.getAirname());
                
            }
            
       }catch(Exception e){
          
      e.printStackTrace();
      
      }
             
    }
    
}
