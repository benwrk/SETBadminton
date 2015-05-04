package a_unused;

import java.util.ArrayList;

import appengine_classes.Time;

public class CourtInfo{
	private int numberOfPeriod;
	private Time openTime;
	private Time closeTime;
	private ArrayList<String>period = new ArrayList<String>();

	public CourtInfo(Time openTime, Time closeTime) {
		this.openTime = openTime;
		this.closeTime = closeTime;
	}
	
	public int getNumberOfPeriod() {
		return numberOfPeriod;
	}

	public Time getOpenTime() {
		return openTime;
	}
	
	public Time getCloseTime() {
		return closeTime;
	}
	
	public void setNumberOfPeriod(int numberOfPeriod) {
		this.numberOfPeriod = numberOfPeriod;
	}

	public void setStartTime(Time startTime) {
		this.openTime = startTime;
	}

	public void setStopTime(Time stopTime) {
		this.closeTime = stopTime;
	}

	public void createNumberOfPeriod()
	{
		this.numberOfPeriod = (closeTime.getDuration()-openTime.getDuration())/3600;
	}
	
	public void createPeriod()
	{
		int lastTime = 0;
		for(int i=0; i<numberOfPeriod-1 ;i++)
		{
			if(i==0)
			{
				period.add(String.valueOf(openTime.getDuration()/3600)+"-"+String.valueOf((openTime.getDuration()/3600)+1));
				lastTime = (openTime.getDuration()/3600)+1;
			}
			else
			{
			    period.add(String.valueOf(lastTime)+"-"+String.valueOf(lastTime+1));
			    lastTime++;
			}
		}
		period.add(String.valueOf(closeTime.getDuration()/3600)+"-"+String.valueOf((closeTime.getDuration()/3600)+1));
	}
	
	public void removePeriod(int index)
	{
		period.remove(index);
	}
	
	public void addPeriod()
	{
		period.add(String.valueOf(closeTime.getDuration()/3600)+"-"+String.valueOf((closeTime.getDuration()/3600)+1));
	}
	
	public String getPeriod(int index)
	{
		return period.get(index);
	}
	
	public String toString() {
		String sent = "";	
		for(int i=0; i<numberOfPeriod-1 ;i++)
		{
		    sent += period.get(i);
		    sent += "\n";
		}
		sent += period.get(numberOfPeriod);
		return sent;
	}
	
	
	
}
