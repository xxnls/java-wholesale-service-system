package interfaces;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public interface Export {
    static void exportToText(Object obj) {
        File file = new File("export1.txt");
        int fileCounter = 1;

        while(file.exists()){
            fileCounter++;
            file = new File("export" + fileCounter + ".txt");
        }

        if(!file.exists())
            try {
            file.createNewFile();
            FileWriter export = new FileWriter(file.getAbsoluteFile());
            export.write(obj.toString());
            export.close();
            } catch(IOException e) {
                System.out.println("Error while exporting data.");
                e.printStackTrace();
            }
    }

    static void exportAllToText(ArrayList<?> list) {
        File file = new File("export1.txt");
        int fileCounter = 1;

        while(file.exists()){
            fileCounter++;
            file = new File("export" + fileCounter + ".txt");
        }

        if(!file.exists())
            try {
                file.createNewFile();
                FileWriter export = new FileWriter(file.getAbsoluteFile());
                for(Object obj : list) {
                    export.write(obj.toString());
                    export.write("\n");
                }
                export.close();
            } catch(IOException e) {
                System.out.println("Error while exporting data.");
            }
    }
}

