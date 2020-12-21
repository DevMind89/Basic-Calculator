import javax.swing.JFrame;

class FrameCalculator extends JFrame {

	public FrameCalculator() {
		setTitle("Calculator");
		setSize(300, 400);
		setLocationRelativeTo(null);
		add(new PanelCalculator());
	}
}
