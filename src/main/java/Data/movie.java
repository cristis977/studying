package Data;

public class movie {
	String moviecode;
	String title;
	String release;
	String production;
	String film_rating;
	String runningtime;
	String director;
	String genre;
	String leading_role;
	String isplaying;
	public movie(String moviecode, String title, String release, String production, String film_rating,
			String runningtime, String director, String genre, String leading_role, String isplaying) {
		super();
		this.moviecode = moviecode;
		this.title = title;
		this.release = release;
		this.production = production;
		this.film_rating = film_rating;
		this.runningtime = runningtime;
		this.director = director;
		this.genre = genre;
		this.leading_role = leading_role;
		this.isplaying = isplaying;
	}
	public String getMoviecode() {
		return moviecode;
	}
	public String getTitle() {
		return title;
	}
	public String getRelease() {
		return release;
	}
	public String getProduction() {
		return production;
	}
	public String getFilm_rating() {
		return film_rating;
	}
	public String getRunningtime() {
		return runningtime;
	}
	public String getDirector() {
		return director;
	}
	public String getGenre() {
		return genre;
	}
	public String getLeading_role() {
		return leading_role;
	}
	public String getIsplaying() {
		return isplaying;
	}
	
}
