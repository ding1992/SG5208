package sg.edu.nus.iss.vmcs.system;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class XmlLoaderStrategy implements LoadPropertyStrategy {

	@Override
	public Properties loadProperties(String filename)  throws IOException {
		Properties prop = new Properties(System.getProperties());
		FileInputStream stream = new FileInputStream(filename);
		prop.loadFromXML(stream);
		stream.close();
		return prop;
	}

}
