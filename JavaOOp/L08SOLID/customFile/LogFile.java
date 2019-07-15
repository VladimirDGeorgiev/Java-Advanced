package JavaOOP.L08SOLID.customFile;

import JavaOOP.L08SOLID.customFile.interfaces.File;

import java.io.FileWriter;
import java.io.IOException;


public class LogFile implements File {
    private StringBuilder builder;
    private FileWriter fileWriter;

    public LogFile() throws IOException {
        this.builder = new StringBuilder();
        this.setFileWriter(System.getProperty("user.dir")+"\\output.txt");
    }

    @Override
    public void write(String string) {
        builder.append(string);
        try {
            this.setFileWriter(System.getProperty("user.dir")+"\\output.txt");
            this.fileWriter.append(this.builder.toString());
            this.builder.append(System.lineSeparator());
            this.fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //this.builder = new StringBuilder();
    }

    @Override
    public int size() {
        return builder.toString().chars().filter(Character::isLetter).sum();
    }

    public void setFileWriter(String path) throws IOException {
        this.fileWriter = new FileWriter(path);
    }
}
