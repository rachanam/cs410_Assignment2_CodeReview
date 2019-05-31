package sensor;

public class PressureSensorAdapter implements Sensor {

    private PressureSensor adaptee;

    public PressureSensorAdapter(PressureSensor pressureSensor) {
        this.adaptee = pressureSensor;
    }

    @Override
    public double getValue() {
        return adaptee.readValue();
    }

	@Override
	public String getReport() {
		return adaptee.getReport();
	}

	@Override
	public String getName() {
		return adaptee.getSensorName();
	}

}
