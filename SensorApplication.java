package sensor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class SensorApplication extends JFrame {
	
	public SensorApplication() {
		setTitle("Sensor Tracker");
		setLayout(new GridLayout(3,1));
		
        Sensor[] sensors = {
        		new PressureSensorAdapter(new PressureSensor()),
                new RadiationSensorAdapter(new RadiationSensor()),
                new TemperatureSensorAdapter(new TemperatureSensor())
        };
        
        for (Sensor sensor : sensors) {
    		JPanel sensorPnl = new JPanel();
    		sensorPnl.setBorder(new TitledBorder(sensor.getName()));
    		double value = sensor.getValue();
    		String report = sensor.getReport();
    		JTextArea colorTextArea = this.getColorComponent(report);
    		JLabel reportValueLbl = new JLabel(report + " --> " + String.valueOf(value));    		
    		sensorPnl.add(colorTextArea);
    		sensorPnl.add(reportValueLbl);
    		add(sensorPnl);
        }
		
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}
	
	JTextArea getColorComponent(String status) {
		JTextArea  colorTextArea = new JTextArea(2, 0);
		colorTextArea.setEnabled(false);
		Color c = colorTextArea.getBackground();
		switch (status) {
		case "OK":
			c = Color.GREEN;
			colorTextArea.setColumns(1);
			break;
		case "CRITICAL":
			c = Color.YELLOW;
			colorTextArea.setColumns(2);
			break;
		case "DANGER":
			c = Color.RED;
			colorTextArea.setColumns(8);
			break;
		}
		
		colorTextArea.setBackground(c);		
		return colorTextArea;
	}

	public static void main(String[] args) {
		SensorApplication app = new SensorApplication();
	}
}
