package MVC;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MVCView extends JFrame {
	private static final String INITIAL_VALUE = "1";
	private JTextField m_userInputTf = new JTextField(5);
	private JTextField m_totalTf = new JTextField(20);
	private JButton m_multiplyBtn = new JButton("Multiply");
	private JButton m_clearBtn = new JButton("Clear");
	private MVCModel m_model;
	
	MVCView(MVCModel model){
		m_model = model;
		m_model.setValue(INITIAL_VALUE);
		
		// initialize components
		m_totalTf.setText(m_model.getValue());
		m_totalTf.setEditable(false);
		
		// Layout the components
		JPanel content = new JPanel();
		content.setLayout(new FlowLayout());
		content.add(new JLabel("Input"));
		content.add(m_userInputTf);
		content.add(m_multiplyBtn);
		content.add(new JLabel("Total"));
		content.add(m_totalTf);
		content.add(m_clearBtn);
		
		// finalize layout
		this.setContentPane(content);
		this.pack();
		
		this.setTitle("Simple MVC - Calculator");
	}
	
	void reset(){
		m_totalTf.setText(INITIAL_VALUE);
	}
	
	String getUserInput(){
		return m_userInputTf.getText();
	}
	
	void setTotal(String newTotal){
		m_totalTf.setText(newTotal);
	}
	
	void showError(String errMsg){
		JOptionPane.showMessageDialog(this, errMsg);
	}
	
	// event your passing from the ActionListener 
	// must have distinct parameter names.
	void addMultiplyListener(ActionListener f){
		m_multiplyBtn.addActionListener(f);
	}
	
	void addClearListener(ActionListener e){
		m_clearBtn.addActionListener(e);
	}
}
