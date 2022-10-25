import java.io.InputStream;
import java.util.Properties;

public class ConfiguracionesIniciales {
    private Properties propiedades;

    public ConfiguracionesIniciales() {
        try (InputStream fichero = ConfiguracionesIniciales.class.getClassLoader().getResourceAsStream("config.properties");) {
            propiedades = new Properties();
            propiedades.load(fichero);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPropiedad(String clave) {
        return propiedades.getProperty(clave);
    }

    public Properties getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(Properties propiedades) {
        this.propiedades = propiedades;
    }
}
