import java.rmi.*;
import java.util.*;

public class Client {
	public static void menu() {
		System.out.println("Comenzi: ");
		System.out.println("\taduna");
		System.out.println("\tscade");
		System.out.println("\tprodus");
		System.out.println("\tcat");
		System.out.println("\tinvers");
		System.out.println("\tpow");
		System.out.println("\tfact");
		System.out.println("\tsqrt");
		System.out.println("\tmaduna");
		System.out.println("\tmscade");
		System.out.println("\tcitire");
		System.out.println("\tsterge");
		System.out.println("\tclear");
		System.out.println("\tshow");
		System.out.println("\tsalut");
		System.out.println("\t\\quit");
	}

	static Double a = 0.0, b = 0.0;

	static boolean validData(Scanner sc) {
		try {
			System.out.print("a=");
			a = sc.nextDouble();
			System.out.print("b=");
			b = sc.nextDouble();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	static boolean valid1Data(Scanner sc) {
		try {
			System.out.print("b=");
			b = sc.nextDouble();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static void main(String[] args) throws RemoteException {
		IGenerator Ob = null;
		ICalculator serv = null;
		String url = "rmi://localhost:1099/Calculator";
		try {
			Ob = (IGenerator) Naming.lookup(url);
		} catch (Exception e) {
			System.out.println("Conectare esuata");
			System.exit(0);
		}

		try {
			serv = Ob.server_propriu();
		} catch (Exception e) {
		}
		menu();
		String command = "";
		Scanner sc = new Scanner(System.in);
		while (!command.equals("\\quit")) {
			command = sc.nextLine();
			boolean B = false;
			// <clear>
			if (command.equals("clear")) {
				B = true;
				serv.setResult();
				System.out.println("Alta comanda: ");
			}
			// </clear>
			// <show>
			if (command.equals("show")) {
				B = true;
				System.out.println(serv.getResult() + "\nAlta comanda: ");
			}
			// </show>

			// <aduna>
			if (command.equals("aduna")) {
				B = true;
				if (!serv.isZero()) {
					if (valid1Data(sc)) {
						double result = serv.aduna(b, serv.getResult());
						System.out.println(result);
						System.out.println("Alta comanda: ");
					} else {
						System.out.println("Numai numere\nAlta comanda: ");
					}
				} else {
					if (validData(sc)) {
						double result = serv.aduna(a, b);
						System.out.println(result);
						System.out.println("Alta comanda: ");
					} else {
						System.out.println("Numai numere\nAlta comanda: ");
					}
				}
			}
			// </aduna>

			// <scade>
			if (command.equals("scade")) {
				B = true;
				if (!serv.isZero()) {
					if (valid1Data(sc)) {
						double result = serv.scade(serv.getResult(), b);
						System.out.println(result);
						System.out.println("Alta comanda: ");
					} else {
						System.out.println("Numai numere\nAlta comanda: ");
					}
				} else {
					if (validData(sc)) {
						double result = serv.scade(a, b);
						System.out.println(result);
						System.out.println("Alta comanda: ");
					} else {
						System.out.println("Numai numere\nAlta comanda: ");
					}
				}
			}
			// </scade>

			// <produs>
			if (command.equals("produs")) {
				B = true;
				if (!serv.isZero()) {
					if (valid1Data(sc)) {
						double result = serv.produs(b, serv.getResult());
						System.out.println(result);
						System.out.println("Alta comanda: ");
					} else {
						System.out.println("Numai numere\nAlta comanda: ");
					}
				} else {
					if (validData(sc)) {
						double result = serv.produs(a, b);
						System.out.println(result);
						System.out.println("Alta comanda: ");
					} else {
						System.out.println("Numai numere\nAlta comanda: ");
					}
				}
			}
			// </produs>

			// <cat>
			if (command.equals("cat")) {
				B = true;
				if (!serv.isZero()) {
					if (valid1Data(sc)) {
						String R = serv.cat(serv.getResult(), b);
						if (R.equals("Divide by 0")) {
							System.out.println(R);
						} else {
							double result = Double.parseDouble(R);
							System.out.println(result);
							System.out.println("Alta comanda: ");
						}

					} else {
						System.out.println("Numai numere\nAlta comanda: ");
					}
				} else {
					if (validData(sc)) {
						String R = serv.cat(a, b);
						if (R.equals("Divide by 0")) {
							System.out.println(R);
						} else {
							double result = Double.parseDouble(R);
							System.out.println(result);
							System.out.println("Alta comanda: ");
						}
					} else {
						System.out.println("Numai numere\nAlta comanda");
					}
				}
			}
			// </cat>

			// <invers>
			if (command.equals("invers")) {
				B = true;
				if (!serv.isZero()) {
					String R = serv.cat(1.0, serv.getResult());
					double result = Double.parseDouble(R);
					System.out.println(result);
					System.out.println("Alta comanda: ");
				} else {
					if (valid1Data(sc)) {
						String R = serv.cat(1.00, b);
						if (R.equals("Divide by 0")) {
							System.out.println(R + "\nAlta comanda: ");
						} else {
							double result = Double.parseDouble(R);
							System.out.println(result);
							System.out.println("Alta comanda: ");
						}
					} else {
						System.out.println("Numai numere\nAlta comanda: ");
					}
				}
			}
			// </invers>

			// <pow>
			if (command.equals("pow")) {
				B = true;
				if (!serv.isZero()) {
					if (valid1Data(sc)) {
						double result = serv.pow(serv.getResult(), b);
						System.out.println(result);
						System.out.println("Alta comanda: ");
					} else {
						System.out.println("Numai numere\nAlta comanda: ");
					}
				} else {
					if (validData(sc)) {
						double result = serv.pow(a, b);
						System.out.println(result);
						System.out.println("Alta comanda: ");
					} else {
						System.out.println("Numai numere\nAlta comanda: ");
					}
				}
			}
			// </pow>

			// <fact>
			if (command.equals("fact")) {
				B = true;
				if (!serv.isZero()) {
					System.out.println(serv.fact(serv.getResult()));
					System.out.println("Alta comanda: ");
				} else {
					if (valid1Data(sc)) {
						System.out.println(serv.fact(b));
						serv.setResult();
						System.out.println("Alta comanda: ");
					} else {
						System.out.println("Numai numere\nAlta comanda: ");
					}
				}
			}
			// </fact>

			// <sqrt>
			if (command.equals("sqrt")) {
				B = true;
				if (!serv.isZero()) {
					String R = serv.rad(serv.getResult());
					if (R.equals("NaN")) {
						System.out.println(R);
					} else {
						double result = Double.parseDouble(R);
						System.out.println(result);
					}
					System.out.println("Alta comanda: ");
				} else {
					if (valid1Data(sc)) {
						String R = serv.rad(b);
						if (R.equals("NaN")) {
							System.out.println(R);
						} else {
							double result = Double.parseDouble(R);
							System.out.println(result);
						}
						System.out.println("Alta comanda: ");
					} else {
						System.out.println("Numai numere\nAlta comanda: ");
					}
				}
			}
			// </sqrt>

			// <maduna>
			if (command.equals("maduna")) {
				B = true;
				if (!serv.isZero()) {
					serv.maduna(serv.getResult());
					System.out
							.println("Operatie cu memoria reusita\nAlta comanda: ");
				} else {
					if (valid1Data(sc)) {
						serv.maduna(b);
						System.out
								.println("Operatie cu memoria reusita\nAlta comanda: ");
					} else {
						System.out.println("Numai numere\nAlta comanda: ");
					}
				}
			}
			// </maduna>

			// <mscade>
			if (command.equals("mscade")) {
				B = true;
				if (!serv.isZero()) {
					serv.mscade(serv.getResult());
					System.out
							.println("Operatie cu memoria reusita\nAlta comanda: ");
				} else {
					if (valid1Data(sc)) {
						serv.mscade(b);
						System.out
								.println("Operatie cu memoria reusita\nAlta comanda: ");
					} else {
						System.out.println("Numai numere\nAlta comanda: ");
					}
				}
			}
			// </mscade>

			// <citire memorie>
			if (command.equals("citire")) {
				B = true;
				System.out.println("mem = " + serv.getMem());
				System.out.println("Alta comanda: ");
			}
			// </citire memorie>

			// <stergere memorie>
			if (command.equals("sterge")) {
				B = true;
				serv.memClr();
				System.out
						.println("Operatie cu memoria reusita.\nAlta comanda: ");
			}
			// </stergere memorie>
			if (command.equals("salut")) {
				B = true;
				System.out.print("Nume: ");
				String serverReply = serv.doCommunicate(sc.nextLine());
				System.out.println("Server replay: " + serverReply);
				System.out.println("Alta comanda: ");
			}
			if (B == false && (!command.equals(""))) {
				if (command.equals("\\quit")) {
					System.exit(0);
				}
				System.out.println("Comanda invalida\nAlta comanda: ");
			}
		}
		sc.close();
	}
}
