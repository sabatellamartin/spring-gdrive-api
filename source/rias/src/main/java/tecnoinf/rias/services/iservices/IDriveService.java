package tecnoinf.rias.services.iservices;

import java.util.List;

import tecnoinf.rias.entities.File;
import tecnoinf.rias.entities.Folder;
import tecnoinf.rias.entities.Response;

public interface IDriveService {

    public Response getFiles(String authToken);
    
    public File getFile(String authToken, String fileId);
    
    public List<Folder> getFolders(String authToken);
    
    public List<Folder> getChildFolders(String authToken, String fileId);
    
    public List<Folder> getFoldersByTerm(String authToken, String term);
}
