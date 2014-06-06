import java.rmi.*; 
import java.rmi.server.*;

public class Generator extends UnicastRemoteObject implements IGenerator {
	private static final long serialVersionUID = 1L;
	static int contor;
	Generator() throws RemoteException {}
	
	public ICalculator server_propriu() throws  Exception {
		return new Calculator(0,contor++);
	}
}
