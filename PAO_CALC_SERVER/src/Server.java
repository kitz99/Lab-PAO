import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) throws Exception {
		Generator Ob = new Generator();
		Registry reg = LocateRegistry.createRegistry(1099);
		reg.bind("Calculator", Ob);
		System.out.println("Serverul a pornit");
	}
}
