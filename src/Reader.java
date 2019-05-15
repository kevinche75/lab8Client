import java.lang.reflect.Type;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Reader {



    static public String justReadFile(String path)throws FileNotFoundException{
        return readFile(path);
    }

    static private void checkFile(File file) throws FileNotFoundException {
        if(!file.exists()) throw new FileNotFoundException(TextType.FILE_NOT_EXIST.name());
        if(!file.isFile()) throw new FileNotFoundException(TextType.IS_NOT_FILE.name());
        if(!file.canRead()) throw new SecurityException(TextType.CANNOT_READ.name());
    }

   static private String readFile(String path) throws FileNotFoundException{
        StringBuilder readablestring = new StringBuilder();
        int stringChar;
        File file = new File(path);
        checkFile(file);
        return readJsonFromFile(file);
    }

   static private String readJsonFromFile(File file) throws FileNotFoundException{
        StringBuilder line = new StringBuilder();
        int stringChar;
        try(FileReader reader = new FileReader(file)){
            while((stringChar=reader.read())!=-1){
                line.append((char) stringChar);
            }
        } catch (IOException e){
            throw new FileNotFoundException(TextType.CANNOT_READ.name());
        }
        return line.toString();
    }

//   static private CopyOnWriteArrayList<Alice> jsonToLinkedList(String rawJson) throws JsonSyntaxException{
//        Gson gson = new Gson();
//        Type type = new TypeToken<CopyOnWriteArrayList<Alice>>(){}.getType();
//        CopyOnWriteArrayList <Alice> linkedalices = gson.fromJson(rawJson, type);
//        linkedalices.sort(Comparator.naturalOrder());
//        System.out.println("===\nЭлементов было считано: "+linkedalices.size());
//        return linkedalices;
//    }
}
