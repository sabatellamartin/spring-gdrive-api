/*
 * Google OAuth playgrount
 * 
 * https://developers.google.com/oauthplayground/
 * 
 * Google drive Mimetypes
 * https://developers.google.com/drive/api/v3/mime-types
 */
package tecnoinf.rias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tecnoinf.rias.entities.File;
import tecnoinf.rias.entities.Folder;
import tecnoinf.rias.entities.Response;
import tecnoinf.rias.services.iservices.IDriveService;

@CrossOrigin(origins = "http://localhost:80")
@RestController
@RequestMapping("/drive")
public class DriveRestController{

	@Autowired
	private IDriveService driveService;
	
	@RequestMapping(value = "/files", method = RequestMethod.GET)
	public ResponseEntity<?> getFiles(@RequestHeader("Authorization") String authToken) throws JsonProcessingException {
		Response files = driveService.getFiles(authToken);
		ObjectMapper objectMapper = new ObjectMapper();
		return new ResponseEntity<String>(objectMapper.writeValueAsString(files), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/files/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getFile(@RequestHeader("Authorization") String authToken, @PathVariable("id") String fileId) throws JsonProcessingException {
		File file = driveService.getFile(authToken, fileId);
		ObjectMapper objectMapper = new ObjectMapper();
        return new ResponseEntity<String>(objectMapper.writeValueAsString(file), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/folders", method = RequestMethod.GET)
	public ResponseEntity<String> getFolders(@RequestHeader("Authorization") String authToken) throws JsonProcessingException {
		List<Folder> folders = driveService.getFolders(authToken);
		ObjectMapper objectMapper = new ObjectMapper();
        return new ResponseEntity<String>(objectMapper.writeValueAsString(folders), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/folders/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getChildFolders(@RequestHeader("Authorization") String authToken, @PathVariable("id") String fileId) throws JsonProcessingException {
		List<Folder> folders = driveService.getChildFolders(authToken, fileId);
		ObjectMapper objectMapper = new ObjectMapper();
        return new ResponseEntity<String>(objectMapper.writeValueAsString(folders), HttpStatus.OK);
	}

	@RequestMapping(value = "/folders/search/{term}", method = RequestMethod.GET)
	public ResponseEntity<String> getFoldersByTerm(@RequestHeader("Authorization") String authToken, @PathVariable("term") String term) throws JsonProcessingException {
		List<Folder> folders = driveService.getFoldersByTerm(authToken, term);
		ObjectMapper objectMapper = new ObjectMapper();
        return new ResponseEntity<String>(objectMapper.writeValueAsString(folders), HttpStatus.OK);
	}
	
}
