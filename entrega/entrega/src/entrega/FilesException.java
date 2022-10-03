package entrega;

public class FilesException extends Exception{
    private String aux;

    public boolean UnsupportedMediaException(String word){

        if (word.length() > 4) {
            aux = word.substring(word.length() - 3);
        }else {
            throw new IllegalArgumentException();
        }
        if(aux.equals("txt")){
            return false;
        }else{
            System.out.println("El archivo no existe");
            return true;
        }
        
    }
}