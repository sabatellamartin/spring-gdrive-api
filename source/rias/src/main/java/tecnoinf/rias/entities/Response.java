package tecnoinf.rias.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

	private String kind;
	
	private String nextPageToken;
	
	private Boolean incompleteSearch;

	private List<File> files;
	
	public Response() {}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getNextPageToken() {
		return nextPageToken;
	}

	public void setNextPageToken(String nextPageToken) {
		this.nextPageToken = nextPageToken;
	}

	public Boolean getIncompleteSearch() {
		return incompleteSearch;
	}

	public void setIncompleteSearch(Boolean incompleteSearch) {
		this.incompleteSearch = incompleteSearch;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

}
