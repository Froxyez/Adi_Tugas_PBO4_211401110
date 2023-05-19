import java.util.ArrayList;
import java.util.List;

interface Folder {
    String getNama();
    void addFile(File file);
    void removeFile(File file);
    void displayFiles();
}


abstract class AbstractFolder implements Folder {
    protected String nama;
    protected List<File> files;

    public AbstractFolder(String nama) {
        this.nama = nama;
        this.files = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public void displayFiles() {
        System.out.println("Isi folder " + nama + ":");
        for (File file : files) {
            System.out.println(file.getNama());
        }
    }
}


class InnerFolder extends AbstractFolder {
    private List<AbstractFolder> subFolders;

    public InnerFolder(String nama) {
        super(nama);
        this.subFolders = new ArrayList<>();
    }

    public void addSubFolder(AbstractFolder folder) {
        subFolders.add(folder);
    }

    public void removeSubFolder(AbstractFolder folder) {
        subFolders.remove(folder);
    }

    public void displaySubFolders() {
        System.out.println("Subfolder dari " + nama + ":");
        for (AbstractFolder folder : subFolders) {
            System.out.println(folder.getNama());
        }
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void removeFile(File file) {
        files.remove(file);
    }
}


class File {
    private String nama;

    public File(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }
}

public class Main {
    public static void main(String[] args) {
       
        InnerFolder folder1 = new InnerFolder("Folder 1");
        InnerFolder folder2 = new InnerFolder("Folder 2");

        File file1 = new File("File 1");
        File file2 = new File("File 2");
        File file3 = new File("File 3");

        
        folder1.addSubFolder(folder2);
        folder1.addFile(file1);
        folder1.addFile(file2);
        folder2.addFile(file3);

        
        folder1.displayFiles();
        folder1.displaySubFolders();

        folder2.displayFiles();
    }
}
