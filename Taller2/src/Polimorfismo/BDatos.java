package Polimorfismo;

public abstract class BDatos {

    private String nombre;

    public BDatos(String nombreBD) {
        this.nombre = nombreBD;
    }

    public void imprimir(){
        System.out.println("Hola desde la clase abstracta BDatos.class");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract void actualizarBD();
}
