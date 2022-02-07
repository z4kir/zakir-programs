package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    private long Number1 = 0;
    private String Operator = "";
    private boolean Start = true;
    @FXML
    Label result;

    public float model(long number1, long number2, String operator) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0) {
                    return 0;
                } else {
                    return number1 / number2;
                }
            default:
                return 0;
        }


    }

    @FXML
    public void processNumber(ActionEvent event) {
        if (Start) {
            result.setText("");
            Start = false;
        }
        String value = ((Button) event.getSource()).getText();
        result.setText(result.getText() + value);

    }

    @FXML
    public void processOperation(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if (!value.equals("=")) {
            if (!Operator.isEmpty()) {
                return;
            }
            Operator = value;
            Number1 = Long.valueOf(result.getText());
            result.setText("");

        } else {
            if (Operator.isEmpty()) {
                return;
            }
            long Number2 = Long.parseLong(result.getText());
            float ans = model(Number1, Number2, Operator);
            result.setText(String.valueOf(ans));
            Operator = "";
            Start = true;

        }


    }
}
