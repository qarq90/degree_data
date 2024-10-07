import java.awt.*;

public class BasicCalculator {
    void Main(String[] args) {
        Frame f = new Frame("Basic Calculator");
        Button addButton = new Button("Add");
        Button subButton = new Button("Subtract");
        Button clearButton = new Button("Clear");
        f.setLayout(null);
        f.add(addButton);
        f.add(subButton);
        f.add(clearButton);
        f.setSize(200, 200);
        f.setVisible(true);
    }
}
