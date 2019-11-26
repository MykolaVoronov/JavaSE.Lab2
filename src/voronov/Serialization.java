package voronov;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Serialization {

    public void SaveToJSON(Students students, String fileName) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter(fileName);
        writer.write(gson.toJson(students));
        writer.close();
    }
    public Students ReadFromJSON(String fileName) throws FileNotFoundException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(fileName));
        return gson.fromJson(bufferedReader, Students.class);
    }
}
