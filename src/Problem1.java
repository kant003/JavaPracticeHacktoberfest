import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1 {


	public static void main(String [] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String testLine =reader.readLine();
		int numberTests=Integer.parseInt(testLine);
		for(int count=0;count<numberTests;count++) {
			System.out.print("Case #"+(count+1));
			int numberBus=Integer.parseInt(reader.readLine());
			String citiesServedString =reader.readLine();
			String data[]=citiesServedString.split(" ");
			int numCities=Integer.parseInt(reader.readLine());
			String targets=reader.readLine();
			while(!targets.equals("\n")){
				int inRange=0;
				if(targets.equals("")) {
					break;
				}
				int targ=Integer.parseInt(targets);
				
				for(int c=0;c<data.length-1;c+=2) {
					if(Integer.parseInt(data[c])<=targ&&Integer.parseInt(data[c+1])>=targ)   {
						inRange++;
					}else if(Integer.parseInt(data[c])>=targ&&Integer.parseInt(data[c+1])<=targ){
						inRange++;
					}
				}
				System.out.print(" "+(inRange));
				targets=reader.readLine();
				
			}
			System.out.println("");
		}
	}
	
	
	
}
/*
Data for testing
2
4
15 25 30 35 45 50 10 20
2
15
25

10
10 15 5 12 40 55 1 10 25 35 45 50 20 28 27 35 15 40 4 5
3
5
10
27
 */
