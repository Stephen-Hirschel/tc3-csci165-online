import java.lang.Math;

public class ElectionResults2016 {
	private double demVotes;
	private double gopVotes;
	private double totalVotes;
	private double percentDem;
	private double percentGOP;
	private String StateAbbreviation;
	private String county;
	private int fips;
	
	// no argument constructor
	public ElectionResults2016() {
		
	}
	
	// overloaded constructor
	public ElectionResults2016(double demVotes, double gopVotes, double totalVotes, double percentDem, double percentGOP, String StateAbbreviation, String county, int fips) 
	{
		this.demVotes = demVotes;
		this.gopVotes = gopVotes;
		this.totalVotes = totalVotes;
		this.percentDem = percentDem;
		this.percentGOP = percentGOP;
		this.StateAbbreviation = StateAbbreviation;
		this.county = county;
		this.fips = fips;
	}
	
	public void setTotalVotes(double d) {
		totalVotes = d;
	}
	
	public double getTotalVotes() {
		return totalVotes;
	}
	
	public void setDemVotes(double d) {
		demVotes = d;
	}
	
	public double getDemVotes() {
		return demVotes;
	}
	
	public void setGOPVotes(double d) {
		gopVotes = d;
	}
	
	public double getGOPVotes() {
		return gopVotes;
	}
	public void setDemPercent(double d) {
		double rnd = Math.round(d * 100) / 100.0;
		percentDem = rnd;
			}
	public double getDemPercent() {
		return percentDem;
	}
	
	public void setGOPPercent(double d) {
		double rnd = Math.round(d * 100) / 100.0;
		percentGOP = rnd;
	}
	
	public double getGOPPercent() {
		return percentGOP;
	}
	//public double getPercentDifference() {
	//	double pctDiff;
	//	getTotalVotes();
	//	getDemVotes();
	//	getGOPVotes();
	//	return ;
//	}
	
	public void setState(String s) {
		StateAbbreviation = s;
	}
	public String getState() {
		return StateAbbreviation;
	}
	
	public void setCounty(String s) {
		county = s;
	}
	
	public String getCounty() {
		return county;
	}
	
	public void setFips(int i) {
		fips = i;
	}
	
	public String toString() {
		return demVotes + ", " + gopVotes + ", " + totalVotes + ", " + percentDem + ", " + percentGOP +
				", " + StateAbbreviation + ", " + county + ", " + fips;
	}
	public boolean equals(ElectionResults2016 e) {
		return this.StateAbbreviation == e.StateAbbreviation;
	}
	public static void main(String[] args) {
		

	}

}
