package appengine_classes;

//elab-source: Time.java
public class Time {
	private int epoch;
	public Time(int hour, int minute, int second) {
		this.epoch = hour * 3600 + minute * 60 + second;
	}
	public Time(int duration) {
		this.epoch = duration;
	}
	public int getHour() {
		return epoch / 3600;
	}
	public int getMinute() {
		return epoch % 3600 / 60;
	}
	public int getSecond() {
		return epoch % 60;
	}
	public int getDuration() {
		return epoch;
	}
	public void setHour(int hour) {
		epoch = new Time(hour, this.getMinute(), this.getSecond()).getDuration();
	}
	public void setMinute(int minute) {
		epoch = new Time(this.getHour(), minute, this.getSecond()).getDuration();
	}
	public void setSecond(int second) {
		epoch = new Time(this.getHour(), this.getMinute(), second).getDuration();
	}
	public Time add(Time other) {
		return new Time(this.getDuration() + other.getDuration());
	}
	public int subtract(Time other) {
		if (this.getDuration() >= other.getDuration()) {
			return this.getDuration() - other.getDuration();
		}
		else {
			return this.getDuration() - other.getDuration() + 86400;
		}
	}
	public boolean equals(Time other) {
		if (this.getDuration() == other.getDuration()) {
			return true;
		}
		else {
			return false;
		}
	}
	public String toString() {
		return String.format("%02d:%02d:%02d", this.getHour(), this.getMinute(), this.getSecond());
	}
}
