import java.util.List;

public class Simulator {
    Ports ports=new Ports();
    Capsule capsule=new Capsule();
    String capsulename;
    List<Ports> portsin;
    List<Ports> portsout;

    public void getCapsule(){
        capsulename=capsule.getName();
    }
    public List<String> getPortIn(){
       return capsule.getIn();
    }
    public List<String> getPortOut(){
        return capsule.getOut();
    }

    public static void checkTypePortsIn(){

    }
    public static void main(String[] args){
        checkTypePortsIn();
    }
}
