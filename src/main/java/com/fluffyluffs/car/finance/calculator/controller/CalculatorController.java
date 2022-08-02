/*
MIT License

Copyright (c) 2022 Chris Luff

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package com.fluffyluffs.car.finance.calculator.controller;

import com.fluffyluffs.car.finance.calculator.controller.impl.Calculator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/** CalculatorController */
public class CalculatorController implements Initializable {

  @FXML private Label monthly;
  @FXML private TextField carValue;
  @FXML private TextField termMths;
  @FXML private TextField deposit;
  @FXML private TextField dealerContrib;
  @FXML private TextField residual;
  @FXML private TextField interestRate;
  @FXML private Button clearCtl;
  @FXML private Button calculateCtl;

  /** Initializes the controller class. */
  @Override
  public void initialize(URL url, ResourceBundle rb) {

    //carValue.getProperties().put("vkType", "numeric");
    
    calculateCtl.setOnAction(eh -> process());
    clearCtl.setOnAction(eh -> clearControls());
  }

  private void process() {
    monthly.setText(
        "Monthly payment: "
            + new Calculator(
                    Double.valueOf(interestRate.getText()),
                    Double.valueOf(carValue.getText()),
                    Integer.valueOf(termMths.getText()),
                    Double.valueOf(deposit.getText()) + Double.valueOf(dealerContrib.getText()),
                    Double.valueOf(residual.getText()))
                .getMonthly());
  }
  
  private void clearControls() {
    carValue.clear();
    termMths.clear();
    deposit.clear();
    dealerContrib.clear();
    residual.clear();
    interestRate.clear();
  }
}
