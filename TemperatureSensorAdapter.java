package sensor;

public class TemperatureSensorAdapter implements Sensor {
    private TemperatureSensor adaptee;

    public TemperatureSensorAdapter(TemperatureSensor temperatureSensor) {
        this.adaptee = temperatureSensor;
    }

    @Override
    public double getValue() {
        return adaptee.senseTemperature();
    }

	@Override
	public String getReport() {
		return adaptee.getTempReport();
	}

	@Override
	public String getName() {
		return adaptee.getSensorType();
	}

}
