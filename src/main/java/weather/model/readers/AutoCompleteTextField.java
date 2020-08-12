package weather.model.readers;

import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;

import java.util.Map;
import java.util.stream.Collectors;

public class AutoCompleteTextField extends TextField {

    public static void autoComplete(TextField textField, Map<String, Integer> map) {
        TextFields.bindAutoCompletion(textField, t -> map.keySet().stream().filter(elem -> elem.toLowerCase().startsWith(t.getUserText().toLowerCase())).collect(Collectors.toList()));
    }
}