import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class ElectionDriver {
	ElectionResults2016 voters = new ElectionResults2016();
	private  ArrayList<ElectionResults2016> results = new ArrayList<ElectionResults2016>();
	private void fillList() {
		
		
		try {
			File file = new File("2016_US_County_Level_Presidential_Results.csv");
			Scanner scanner = new Scanner(file);
			scanner.nextLine();
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] values = line.split(",");
				
				//System.out.println(Arrays.toString(values));
				//int val = Integer.parseInt(values[0]);
				double dem = Double.parseDouble(values[1]);
				voters.setDemVotes(dem);
				double gop = Double.parseDouble(values[2]);
				voters.setGOPVotes(gop);		
				double tot = Double.parseDouble(values[3]);
				voters.setTotalVotes(tot);
				double perd = Double.parseDouble(values[4]);
				voters.setDemPercent(perd);			
				double perg = Double.parseDouble(values[5]);
				voters.setGOPPercent(perg);
				String state = values[7];
				voters.setState(state);			
				String county = values[8];
				voters.setCounty(county);
				int fips = Integer.parseInt(values[9]);
				voters.setFips(fips);
				
				ElectionResults2016 er = new ElectionResults2016 (dem, gop, tot, perd, perg, state, county, fips);
				results.add(er);
				System.out.println(er);
			}
			scanner.close();
		}
		catch(IOException e) {
			System.out.println("IO Exception, Ooops!");
		}
		
	}
	
	public ElectionResults2016 findLargestMargin() {
	
		double demV;
		double gopV;
		double maxDiff = 0;
		int instance = 0;
		double diff = 0;
		for(int i = 0; i < results.size(); i++) {
			ElectionResults2016 voters = results.get(i);
			String p = voters.toString();
			String[] q = p.split(",");
			double d = Double.parseDouble(q[0]);
			voters.setDemVotes(d);
			double r = Double.parseDouble(q[1]);
			voters.setGOPVotes(r);
			
			demV = voters.getDemVotes();
			gopV = voters.getGOPVotes();
			
			if(demV > gopV) {
				diff = demV - gopV;
				}
				else if(demV < gopV) {
				diff = gopV - demV;
				}
			
			if(diff > maxDiff) {
				maxDiff = diff;
				instance = i;
			}
			}
		System.out.println("\nThe instance with the largest margin with: " + maxDiff + " is: " + results.get(instance).toString());	
		return results.get(instance);
		}
	public ElectionResults2016 findLargestMargin(String state) {
		double demV;
		double gopV;
		String stateAbv;
		double maxDiff = 0;
		int instance = 0;
		double diff = 0;
		for(int i = 0; i < results.size(); i++) {
			
			ElectionResults2016 voters = results.get(i);
			String p = voters.toString();
			String[] q = p.split(",");
			
			double d = Double.parseDouble(q[0]);
			voters.setDemVotes(d);
			double r = Double.parseDouble(q[1]);
			voters.setGOPVotes(r);
			String st = q[5];
			voters.setState(st);

			demV = voters.getDemVotes();
			gopV = voters.getGOPVotes();
			stateAbv = voters.getState();
			if(state.equals(stateAbv)) {
				if(demV > gopV) {
					diff = demV - gopV;
					}
					else if(demV < gopV) {
						diff = gopV - demV;
					}
			
				if(diff > maxDiff) {
					maxDiff = diff;
					instance = i;
				}	
			}
		}
		return results.get(instance);
	}
	
	public static void main(String[] args) {
		ElectionDriver ed = new ElectionDriver();
		ed.fillList();
		ed.findLargestMargin();
		ed.findLargestMargin("AL");
		//System.out.println(ed.results);
		//Object r = results.get(600);
		//String s = r.toString();
		//ElectionResults2016.setDemVotes(r);
		//double d = ElectionResults2016.getDemVotes();
		//System.out.println(d);
		
	}

}
