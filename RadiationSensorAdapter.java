package sensor;

public class RadiationSensorAdapter implements Sensor {
    private RadiationSensor adaptee;

    public RadiationSensorAdapter(RadiationSensor radiationSensor) {
        this.adaptee = radiationSensor;
    }

    @Override
    public double getValue() {
        return adaptee.getRadiationValue();
    }

	@Override
	public String getReport() {
		return adaptee.getStatusInfo();
	}

	@Override
	public String getName() {
		return adaptee.getName();
	}

}
