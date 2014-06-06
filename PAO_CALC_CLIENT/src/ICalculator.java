import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculator extends Remote {
	public String doCommunicate(String name) throws RemoteException;

	public Double aduna(Double a, Double b) throws RemoteException;

	public Double scade(Double a, Double b) throws RemoteException;

	public Double produs(Double a, Double b) throws RemoteException;

	public String cat(Double a, Double b) throws RemoteException;

	public String inversare(Double a) throws RemoteException;

	public Double pow(Double a, Double b) throws RemoteException;

	public String fact(Double a) throws RemoteException;

	public String rad(Double a) throws RemoteException;

	public Double citire() throws RemoteException;

	public void stergere() throws RemoteException;

	public boolean isZero() throws RemoteException;

	public double getResult() throws RemoteException;

	public void setResult() throws RemoteException;

	public double getMem() throws RemoteException;

	public void maduna(double a) throws RemoteException;

	public void mscade(double a) throws RemoteException;

	public void memClr() throws RemoteException;
}
