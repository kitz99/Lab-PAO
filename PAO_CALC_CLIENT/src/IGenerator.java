import java.rmi.Remote;

public interface IGenerator extends Remote {
  ICalculator server_propriu() throws Exception;
}
