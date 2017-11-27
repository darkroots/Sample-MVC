package MVC;

import javax.swing.JFrame;

public class MVC {
	
		// Create model, view, and controller. They are
		// created once here and passed to the parts that
		// need them so there is only one copy of each.
		public static void main(String[] args){
			
			MVCModel model = new MVCModel();
			MVCView view = new MVCView(model);
			MVCController controller = new MVCController(model, view);
			
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.setVisible(true);
		}
}
