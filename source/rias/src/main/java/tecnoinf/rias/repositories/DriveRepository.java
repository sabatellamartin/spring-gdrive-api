package tecnoinf.rias.repositories;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import tecnoinf.rias.entities.File;
import tecnoinf.rias.entities.Response;

@Repository
public class DriveRepository {
	
	public DriveRepository() {} 
	
	private HttpHeaders getHeaders(String authToken) {
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Authorization", authToken);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	} 
	
	public Response getFiles(String authToken) {
		final String uri = "https://www.googleapis.com/drive/v3/files?pageSize=1000";
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", this.getHeaders(authToken));
	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<Response> result = restTemplate.exchange(uri, HttpMethod.GET, entity, Response.class);
	    return result.getBody();
	}
	
	public File getFile(String authToken, String fileId) {
		final String uri = "https://www.googleapis.com/drive/v3/files/" + fileId; 
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", this.getHeaders(authToken)); 
	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<File> result = restTemplate.exchange(uri, HttpMethod.GET, entity, File.class);
	    return result.getBody();
	}
	
	public Response getChildFiles(String authToken, String fileId) {
		final String uri = "https://www.googleapis.com/drive/v3/files?q='" + fileId 
					     + "'+in+parents"; 
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", this.getHeaders(authToken)); 
	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<Response> result = restTemplate.exchange(uri, HttpMethod.GET, entity, Response.class);
	    return result.getBody();
	}
	
}