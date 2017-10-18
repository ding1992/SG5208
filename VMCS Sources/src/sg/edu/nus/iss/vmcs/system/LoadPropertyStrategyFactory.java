package sg.edu.nus.iss.vmcs.system;

public class LoadPropertyStrategyFactory {
	public LoadPropertyStrategy createStrategy(String type) {
		switch (type) {
		case "TEXT":
			return new TextLoaderStrategy();
		case "XML":
			return new XmlLoaderStrategy();
		case "DB":
			return new MySqlLoaderStrategy();
		}
		return null;
	}
}
