
public class Controller {
	
	private static Controller control = new Controller();
	private ServiceSelector serviceSelector = new ServiceSelector();
	
	public static Controller getInstance(){
		return control;
	}
	
	public void execute(String reqCode, Object reqDataJsonObject) {
		Service service = serviceSelector.getService(reqCode);
		service.run(reqDataJsonObject);
	}
}
