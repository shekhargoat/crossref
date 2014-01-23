package elancesmk.crossref.dao;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class CrossRefReportDOI {
	
	private List<String> authors;
	private String title;
	private String yearOfPublication;
	private String publisherName;
	private String url;
	private String doi;
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYearOfPublication() {
		return yearOfPublication;
	}
	public void setYearOfPublication(String yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	
	public void addAuthor(String author){
		if(authors==null)authors=new ArrayList<String>();
		authors.add(author);
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
}
