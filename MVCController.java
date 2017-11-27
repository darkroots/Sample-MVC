package MVC;

import java.awt.event.*;

public class MVCController {
	// Then controller needs to interact with both the Model and View
	private MVCModel m_model;
	private MVCView m_view;
	
	public MVCController(MVCModel model, MVCView view){
		m_model = model;
		m_view = view;
		
		// add listeners to the view
		view.addMultiplyListener(new MultiplyListener());
		view.addClearListener(new ClearListener());
	}
	
	// 1. Get the user input from the view
	// 2. Call the model to multiply by this number
	// 3. Get the result from the Model
	// 4. Tell the View to display the result

	class MultiplyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String userInput = "";
			try{
				userInput = m_view.getUserInput();
				m_model.multiplyBy(userInput);
				m_view.setTotal(m_model.getValue());
			}catch(NumberFormatException num){
				m_view.showError("Please enter another number '" + userInput + "'");
			}
		}
	}
	
	// 1. Reset model.
	// 2. Reset View.
	
	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			m_model.reset();
			m_view.reset();
		}
	}
}
