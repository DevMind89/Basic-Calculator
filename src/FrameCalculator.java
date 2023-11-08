import javax.swing.JFrame;

class FrameCalculator extends JFrame {
	private static final long serialVersionUID = -1439801078773875396L;

	public FrameCalculator() {
		setTitle("Calculator");
		setSize(300, 400);
		setLocationRelativeTo(null);
		add(new PanelCalculator());
	}
}
