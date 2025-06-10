package io.omoto.fms.utils;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class.getName());

    private FileUtils() {
    }

    /**
     * @param file of type CSV.
     * @return list of headers
     * @throws IOException when produced by failed or interrupted I/O operations.
     * @implSpec Requires multipart file.
     */
    public static List<String> getHeaders(MultipartFile file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        List<String> headers = bufferedReader
                .lines()
                .findFirst()
                .map(line -> Arrays.asList(line.replace("\"", "").split(","))).orElse(null);
        bufferedReader.close();
        return headers;
    }

    /**
     * This used convert csv file to json array.
     *
     * @param file to be converted into json array.
     * @return json array.
     * @throws IOException
     * @throws JSONException
     * @uses org.json.CDL library
     */
    public static JSONArray csvToJson(MultipartFile file) throws IOException, JSONException {
        String csvString = new String(file.getBytes());
        return CDL.toJSONArray(csvString);
    }


    public static void deleteFile(String filePath) {
        try {
            LOGGER.info("Deleting the file : {} ", filePath);
            Files.delete(Paths.get(filePath));
            LOGGER.info("File deleted successfully");
        } catch (IOException e) {
            LOGGER.error("Unable to delete the file from the machine : {} ", e);
        }
    }

}
