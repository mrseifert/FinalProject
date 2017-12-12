package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtSaveEachMonth;
	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtAnnualReturnWorking;
	@FXML
	private TextField txtNeedToSave;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnualReturnRetired;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;

	

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {

		System.out.println("Clear pressed");
		
		txtSaveEachMonth.clear();
		
		txtYearsToWork.clear();
		
		txtAnnualReturnWorking.clear();
		
		txtNeedToSave.clear();
		
		txtYearsRetired.clear();
		
		txtAnnualReturnRetired.clear();
		
		txtRequiredIncome.clear();
		
		txtMonthlySSI.clear();


	}
	
	
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		if(isInputValid()) {
			
			
			Retirement r = new Retirement(
					
					
				(int) Integer.valueOf(txtYearsToWork.getText()),
				
				(double) Double.valueOf(txtAnnualReturnWorking.getText()),
				
				(int) Integer.valueOf(txtYearsRetired.getText()),
				
				(double) Double.valueOf(txtAnnualReturnRetired.getText()),
				
				(double) Double.valueOf(txtRequiredIncome.getText()), 
				
				(double) Double.valueOf(txtMonthlySSI.getText()));
			
			double needSavedTotal = r.TotalAmountSaved();
		
			double needSavedMonthly = r.AmountToSave();
			
			txtNeedToSave.setText(Double.toString(needSavedTotal));
			
			txtSaveEachMonth.setText(Double.toString(needSavedMonthly));
		
	
			}
		
		

		
	}
	
	
	
	/**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
	

    private boolean isInputValid() {
        String errorMessage = "";

        if (txtYearsToWork.getText() == null || txtYearsToWork.getText().length() == 0) {
            errorMessage += "No valid Years To Work!\n"; 
        } else {
            // try to parse the YearsToWork into an int.
            try {
                Integer.parseInt(txtYearsToWork.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid Years To Work (must be an integer)!\n"; 
            }
        }
        
        
        if (txtAnnualReturnWorking.getText() == null || txtAnnualReturnWorking.getText().length() == 0) {
            errorMessage += "No valid Working Annual Return!\n"; 
        } else {
            // try to parse the AnnualReturnWorking into a double.
            try {
                Double.parseDouble(txtAnnualReturnWorking.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid Working Annual Return (must be a double)!\n"; 
            }
        }
        
        

        if (txtYearsRetired.getText() == null || txtYearsRetired.getText().length() == 0) {
            errorMessage += "No valid Years Retired!\n"; 
        } else {
            // try to parse the YearsRetired into an int.
            try {
                Integer.parseInt(txtYearsRetired.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid Years Retired (must be an integer)!\n"; 
            }
        }
        
        
        if (txtAnnualReturnRetired.getText() == null || txtAnnualReturnRetired.getText().length() == 0) {
            errorMessage += "No valid Retired Annual Return!\n"; 
        } else {
            // try to parse the AnnualReturnRetired into a double.
            try {
                Double.parseDouble(txtAnnualReturnRetired.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid Retired Annual Return (must be an double)!\n"; 
            }
        }
        
        
        if (txtRequiredIncome.getText() == null || txtRequiredIncome.getText().length() == 0) {
            errorMessage += "No valid Required Income!\n"; 
        } else {
            // try to parse the RequiredIncome into a double.
            try {
            	 Double.parseDouble(txtRequiredIncome.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid Required Income (must be an double)!\n"; 
            }
        }
        
        
        if (txtMonthlySSI.getText() == null || txtMonthlySSI.getText().length() == 0) {
            errorMessage += "No valid Monthly SSI!\n"; 
        }else {
            // try to parse the MonthlySSI into an double.
            try {
            	 Double.parseDouble(txtMonthlySSI.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid Monthly SSI (must be an double)!\n"; 
            }
        
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
	

