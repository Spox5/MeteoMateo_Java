package weather.model.readers;

import com.google.gson.Gson;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;

import java.io.Reader;
import java.util.List;

public class AutoCompleteTextField extends TextField
{
    public static void autoComplete(TextField textField, String filePath) {

        Gson gson = new Gson();

        Reader fileWithCitiesNameReader = JsonFileReader.readJsonFile(filePath);

        List<String> listOfCitiesName = gson.fromJson(fileWithCitiesNameReader, List.class);
        TextFields.bindAutoCompletion(textField, listOfCitiesName);
    }
}