import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelCalculator extends JPanel {

	private JPanel panelButtons;
	private JButton screen;
	private boolean check_0 = true;
	private double resultOperations = 0;
	private String lastOperation = "=";

	public PanelCalculator() {
		setLayout(new BorderLayout());

		screen = new JButton("0");
		screen.setFont(new Font("Arial", Font.PLAIN, 38));
		screen.setEnabled(false);
		add(screen, BorderLayout.CENTER);

		panelButtons = new JPanel();
		panelButtons.setLayout(new GridLayout(4, 4));

		ActionListener actionNumber = new ActionNumbers();
		ActionListener actionOperation = new ActionOperations();

		putButtons("7", actionNumber);
		putButtons("8", actionNumber);
		putButtons("9", actionNumber);
		putButtons("/", actionOperation);

		putButtons("4", actionNumber);
		putButtons("5", actionNumber);
		putButtons("6", actionNumber);
		putButtons("*", actionOperation);

		putButtons("1", actionNumber);
		putButtons("2", actionNumber);
		putButtons("3", actionNumber);
		putButtons("-", actionOperation);

		putButtons("0", actionNumber);
		putButtons(".", actionNumber);
		putButtons("=", actionOperation);
		putButtons("+", actionOperation);

		add(panelButtons, BorderLayout.SOUTH);
	}

	private void putButtons(String label, ActionListener actionNumber) {
		JButton buttons = new JButton(label);
		buttons.setBackground(Color.black);
		buttons.setForeground(Color.white);
		buttons.addActionListener(actionNumber);
		panelButtons.add(buttons);
	}

	private class ActionNumbers implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String number = e.getActionCommand();

			if (check_0) {
				screen.setText("");
				check_0 = false;
			}

			screen.setText(screen.getText() + number);
		}
	}

	private class ActionOperations implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String operation = e.getActionCommand();
			calculateOperations(Double.parseDouble((screen.getText())));
			lastOperation = operation;
			check_0 = true;
		}

		private void calculateOperations(double x) {
			
		
			if (lastOperation.equals("+")) {
				resultOperations += x;
			} else if (lastOperation.equals("-")) {
				resultOperations -= x;
			} else if (lastOperation.equals("*")) {
				resultOperations *= x;
			} else if (lastOperation.equals("/")) {
				resultOperations /= x;
			} else if (lastOperation.equals("=")) {
				resultOperations = x;
			}

			if (resultOperations % 1 == 0) { // Mostrar decimales si los tiene
				screen.setText("" + (int) resultOperations);
			} else {
				screen.setText("" + resultOperations);
			}
		}
	}
}