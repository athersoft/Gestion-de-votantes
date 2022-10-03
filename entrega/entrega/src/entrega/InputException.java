package entrega;

public class InputException extends Exception {
    
    public boolean rutException(String a){
        a.length();
        if(!(a.length() <= 11 && a.length()>=6)){
            System.out.println("RUT no valido.\nIngrese rut nuevamente:");
            return true;
        }else{
            return false;
        }
    }

    public boolean regionException(int region){
        if(!(region >= 1 && region <= 16)){
            System.out.println("Region no existe\nIngrese nuevamente la region: ");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean edadException(int edad){

        if(edad <=17){
            System.out.println("Persona inhabilitada para votar: (menor de 18 años)\n");
            return true;
        }else{
            if(edad>= 175){
                System.out.println("Persona inhabilitada para votar: (Edad posiblemente falsa)\n");
                return true;
            }else{
                return false;
            }
        }
    }
}

