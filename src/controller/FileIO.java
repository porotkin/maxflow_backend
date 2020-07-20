package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    public static final String CATALINA_HOME = System.getenv("CATALINA_HOME") + "\\graphdata\\";

    public static <T> ArrayList<T> getDataFromFile(String filename, Class<T> c) throws FileNotFoundException {
        ArrayList<T> result;
        Gson gson = new Gson();
        FileReader fileReader = new FileReader(filename);
        Scanner scanner = new Scanner(fileReader);
        result = gson.fromJson(scanner.nextLine(), TypeToken.getParameterized(ArrayList.class, c).getType());
        scanner.close();
        return result;
    }

    public static <T> void writeDataToFile(String filename, T data) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        Gson gson = new Gson();
        fileWriter.write(gson.toJson(data));
        fileWriter.close();
    }
}
