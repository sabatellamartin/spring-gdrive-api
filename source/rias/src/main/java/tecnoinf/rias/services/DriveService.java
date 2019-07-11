package tecnoinf.rias.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tecnoinf.rias.entities.File;
import tecnoinf.rias.entities.Folder;
import tecnoinf.rias.entities.Response;
import tecnoinf.rias.repositories.DriveRepository;
import tecnoinf.rias.services.iservices.IDriveService;

@Service
public class DriveService implements IDriveService {
	
	@Autowired
    private final DriveRepository driveRepository;

	private String folderMimeType;
	
    public DriveService(DriveRepository driveRepository) {
        this.driveRepository = driveRepository;
        this.folderMimeType = "application/vnd.google-apps.folder";
    }

	public Response getFiles(String authToken) {
		return driveRepository.getFiles(authToken);
	}

	public File getFile(String authToken, String fileId) {
		return driveRepository.getFile(authToken, fileId);
	}

	public List<Folder> getFolders(String authToken) {
		Folder folder = null;
		List<Folder> folders =  new ArrayList<Folder>();
		Response response = driveRepository.getFiles(authToken);
		for (File file : response.getFiles()) {
			if (file.getMimeType().compareToIgnoreCase(this.folderMimeType)==0) {
				folder = new Folder();
				folder.setId(file.getId());
				folder.setName(file.getName());
				folders.add(folder);
			}
		}
		return folders;
	}
	
	public List<Folder> getChildFolders(String authToken, String fileId) {
		Folder folder = null;
		List<Folder> folders =  new ArrayList<Folder>();
		Response response = driveRepository.getChildFiles(authToken, fileId);
		for (File file : response.getFiles()) {
			if (file.getMimeType().compareToIgnoreCase(this.folderMimeType)==0) {
				folder = new Folder();
				folder.setId(file.getId());
				folder.setName(file.getName());
				folders.add(folder);
			}
		}
		return folders;
	}

	public List<Folder> getFoldersByTerm(String authToken, String term) {
		Folder folder = null;
		List<Folder> folders =  new ArrayList<Folder>();
		Response response = driveRepository.getFiles(authToken);
		for (File file : response.getFiles()) {
			if (file.getMimeType().compareToIgnoreCase(this.folderMimeType)==0) {
				if (file.getName().toLowerCase().contains(term.toLowerCase())) {
					folder = new Folder();
					folder.setId(file.getId());
					folder.setName(file.getName());
					folders.add(folder);
				}
			}
		}
		return folders;
	}
	
}
