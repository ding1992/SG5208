package sg.edu.nus.iss.vmcs.system;
import java.util.Properties;
import java.io.IOException;

public interface LoadPropertyStrategy{
	public Properties loadProperties(String name)  throws IOException ;
}
