import java.math.BigInteger;
import java.rmi.*;
import java.rmi.server.*;

// aici pun toate metodele calculatorului

public class Calculator extends UnicastRemoteObject implements ICalculator {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private int nr_ordine;
	private double result;
	private double mem;

	public Calculator(double rez, int id) throws RemoteException {
		result = rez;
		nr_ordine = id;
	}

	@Override
	public String doCommunicate(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return "\nServer say hello " + name + "\n";
		// System.out.println("\nServer say hello " + name);
	}

	@Override
	public Double aduna(Double a, Double b) throws RemoteException {
		// TODO Auto-generated method stub
		result = a + b;
		return result;
	}

	@Override
	public Double scade(Double a, Double b) throws RemoteException {
		// TODO Auto-generated method stub
		result = a - b;
		return result;
	}

	@Override
	public Double produs(Double a, Double b) throws RemoteException {
		// TODO Auto-generated method stub
		result = a * b;
		return result;
	}

	@Override
	public String cat(Double a, Double b) throws RemoteException {
		// TODO Auto-generated method stub
		if (b == 0) {
			result = 0.0;
			return "Divide by 0";
		} else {
			result = a / b;
			return Double.toString(result);
		}
	}

	@Override
	public String inversare(Double a) throws RemoteException {
		Double rez = 1 / a;
		return Double.toString(rez);
	}

	@Override
	public Double pow(Double a, Double b) throws RemoteException {
		result = Math.pow(a, b);
		return result;
	}

	@Override
	public String fact(Double a) throws RemoteException {
		if(a < 0) return "Numarul nu este natural";
		int fl = (int) Math.floor(a);
		if (a - fl == 0) {
			if (fl == 0)
				return "1";
			else {
				BigInteger rez = BigInteger.ONE;
				while (fl > 0) {
					BigInteger R = new BigInteger(Integer.toString(fl));
					rez = rez.multiply(R);
					fl--;
				}
				String REZ = rez.toString();
				return REZ;
			}

		}
		return "Numarul nu este natural";
	}

	@Override
	public String rad(Double a) throws RemoteException {
		if(a < 0) {result = 0; return "NaN";}
		else {
			result = Math.sqrt(a);
			return ((Double) result).toString();
		}
	}

	@Override
	public Double citire() throws RemoteException {
		return mem;
	}

	@Override
	public void stergere() throws RemoteException {
		mem = (double) 0;

	}

	@Override
	public boolean isZero() throws RemoteException {
		if (result == 0)
			return true;
		return false;
	}

	@Override
	public double getResult() throws RemoteException {
		return result;
	}

	@Override
	public void setResult() throws RemoteException {
		result = 0.0;
	}

	@Override
	public double getMem() throws RemoteException {
		return mem;
	}

	@Override
	public void maduna(double a) throws RemoteException {
		mem += a;

	}

	@Override
	public void mscade(double a) throws RemoteException {
		mem -= a;

	}

	@Override
	public void memClr() throws RemoteException {
		mem = 0.0;
	}

}
