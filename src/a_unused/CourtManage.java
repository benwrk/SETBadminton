package a_unused;

import java.util.ArrayList;

public class CourtManage{
	private int numberOfCourt;
	private ArrayList<CourtInfo> court = new ArrayList<CourtInfo>();
	
	public CourtManage(CourtInfo courtInfo,int numberOfCourt)
	{
		for(int i=0; i<numberOfCourt ;i++)
		{
			court.add(courtInfo);
		}
	}

	public int getNumberOfCourt() {
		return numberOfCourt;
	}

	public void setNumberOfCourt(int numberOfCourt) {
		this.numberOfCourt = numberOfCourt;
	}
	
	public void removeCourt(int index)
	{
		court.remove(index);
	}
	
	public void addCourt(CourtInfo courtInfo)
	{
		court.add(courtInfo);
	}
	
}