import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class FileTask {
    private ArrayList<File> list;

    FileTask(String path) {
        this.list = new ArrayList<>();
        File file = new File(path);

        File[] fileList = file.listFiles();

        int i = 0;
        assert fileList != null;
        list.addAll(Arrays.asList(fileList));
    }

    public ArrayList<File> getList(){
        return this.list;
    }

    public File at(int index){
        return list.get(index);
    }

    public void write(String path) throws IOException{
        System.out.println(path);

        byte [] info;
        try (FileOutputStream outfile = new FileOutputStream(path)){

            for(File f: list){
                info = (f.getCanonicalPath() + System.getProperty("line.separator")).getBytes();
                outfile.write(info);
            }
        }
    }

    public void ReadFile (String path) throws IOException{
        System.out.println("<" + path + ">");
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            int i = 0;
            String line;
            while (((line = reader.readLine()) != null) && i < 5) {
                i++;
                System.out.println(line);
            };
        }

    }

}
