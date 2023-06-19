package Classes;

public class News {
	private String jourNews,textNews,moisNews;
    private int dateNews;
	public News(String jourNews, String textNews, String moisNews, int dateNews) {
		super();
		this.jourNews = jourNews;
		this.textNews = textNews;
		this.moisNews = moisNews;
		this.dateNews = dateNews;
	}
	public String getJourNews() {
		return jourNews;
	}
	public void setJourNews(String jourNews) {
		this.jourNews = jourNews;
	}
	public String getTextNews() {
		return textNews;
	}
	public void setTextNews(String textNews) {
		this.textNews = textNews;
	}
	public String getMoisNews() {
		return moisNews;
	}
	public void setMoisNews(String moisNews) {
		this.moisNews = moisNews;
	}
	public int getDateNews() {
		return dateNews;
	}
	public void setDateNews(int dateNews) {
		this.dateNews = dateNews;
	}
    
    
}
