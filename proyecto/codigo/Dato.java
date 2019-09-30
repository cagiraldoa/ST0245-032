
public class Dato 
{

    double ph;
    double soil_temperature;
    double soil_moisture;
    double illuminance;
    double env_temperature;
    double env_humidity;
    boolean label;

    public Dato(double ph, double soil_temperature, double soil_moisture, double illuminance, double env_temperature, double env_humidity, boolean label) {

        this.ph = ph;
        this.soil_temperature = soil_temperature;
        this.soil_moisture = soil_moisture;
        this.illuminance = illuminance;
        this.env_temperature = env_temperature;
        this.env_humidity = env_humidity;
        this.label = label;
        
    }

}
