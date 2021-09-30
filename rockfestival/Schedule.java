package rockFestival;

public class Schedule {
	
	private String band, country, scene, start, finish, date;
	
	public Schedule(String band, String country, String scene, String start, String finish, String date) {
		this.band = band;
		this.country = country;
		this.scene = scene;
		this.start = start;
		this.finish = finish;
		this.date = date;
	}
	
	public String getBand () {
		return band;
	}
	
	public String getCountry () {
		return country;
	}
	
	public String getScene () {
		return scene;
	}
	
	public String getStart () {
		return start;
	}
	
	public String getFinish() {
		return finish;
	}
	
	public String getDate() {
		return date;
	}
	
}
