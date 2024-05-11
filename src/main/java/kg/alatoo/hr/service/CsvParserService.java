package kg.alatoo.hr.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvParserService {

    public <T> List<T> parseCsv(Reader reader, Class<T> clazz) throws IOException {
        List<T> objects = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(reader)) {
            List<String[]> records = csvReader.readAll();
            if (records.isEmpty()) {
                return objects;
            }
            // Skip header row (assuming first row contains headers)
            records.removeFirst();
            ObjectMapper objectMapper = new ObjectMapper();
            for (String[] record : records) {
                T object = objectMapper.readValue(String.join(",", record), clazz);
                objects.add(object);
            }
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
