package DBclass;

public class Movie {
	private String moviecode;
	private String title;
	private String release;
	private String production;
	private String film_rating;
	private int runningtime;
	private String director;
	private String genre;
	private String leading_role;
	
	public Movie(String moviecode, String title, String release, String production, String flim_rating, int runningtime,
			String director, String genre, String leading_role) {
		super();
		this.moviecode = moviecode;
		this.title = title;
		this.release = release.substring(0,10);
		//this.release = release.substring(0,4)+"년 "+release.substring(5,7)+"월 "+release.substring(8,10)+"일";
		this.production = production;
		this.film_rating = flim_rating;
		this.runningtime = runningtime;
		this.director = director;
		this.genre = genre;
		this.leading_role = leading_role;
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

	public String getYear() {
		return release.substring(0,4);
	}

	public String getMonth() {
		return release.substring(5,7);
	}
	
	public String getDate() {
		return release.substring(8,10);
	}

	public String getProduction() {
		return production;
	}

	public String getFilm_rating() {
		return film_rating;
	}

	public int getRunningtime() {
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

	@Override
	public String toString() {
		return "movie [moviecode=" + moviecode + ", title=" + title + ", release=" + release + ", production="
				+ production + ", flim_rating=" + film_rating + ", runningtime=" + runningtime + ", director="
				+ director + ", genre=" + genre + ", leading_role=" + leading_role + "]";
	}
}
