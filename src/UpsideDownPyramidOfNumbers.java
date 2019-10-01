import java.util.*;
import java.lang.Math;


public class UpsideDownPyramidOfNumbers.java{


    static int randomizer(int a,int b)
    {
        Random rand=new Random();
        return a+Math.abs(rand.nextInt()%(b-a));
    }

    static void initialise(int [] array)
    {
        for(int i=0;i<100;i++)
        {
            array[i]=randomizer(20,50);
        }
    }


    


   static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> map) 
    { 
        
        List<Map.Entry<Integer, Integer> > list = 
               new LinkedList<Map.Entry<Integer, Integer> >(map.entrySet()); 
  
        
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o1,  
                               Map.Entry<Integer, Integer> o2) 
            { 
               
                return (o2.getValue()).compareTo (o1.getValue()); 
            } 
        }); 
        
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
        for (Map.Entry<Integer, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 
    public static void main(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int [] array=new int[100];
        initialise(array);
        int []freq=new int[31];

            for(int i=0;i<100;i++)
            {
                System.out.print(array[i]+" ");
            }

        for(int i=0;i<100;i++)
        {
            freq[(array[i]-20)]++;
        }

       for(int i=0;i<100;i++)
       map.put(array[i],freq[array[i]-20]);
        System.out.println(" ");

System.out.println("Unsorted Map:\n");
       System.out.println(map);

        Map<Integer,Integer> sorted_map=new HashMap<Integer,Integer>();
        sorted_map=sortByValue(map);

        System.out.println(" ");
        System.out.println("Sorted Map: \n");
        System.out.println(sorted_map);
      
      for(  HashMap.Entry<Integer,Integer> entry : sorted_map.entrySet())
      {
          int k=entry.getValue();
          for(int i=0;i<k;i++)
          {
          System.out.print(entry.getKey()+" ");
          }
            System.out.println(" ");
      }

        

        




    }

}