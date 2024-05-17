/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author wilme
 */
public class Curso {
    //atributos
    private int codigo;
    private String nombre;
    private ProgramaAcademico progra_aca;
    private Docente profesor;
    //constructor vacio
    public Curso() {
    }
    
    //geter y seter
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ProgramaAcademico getProgra_aca() {
        return progra_aca;
    }

    public void setProgra_aca(ProgramaAcademico progra_aca) {
        this.progra_aca = progra_aca;
    }

    public Docente getProfesor() {
        return profesor;
    }

    public void setProfesor(Docente profesor) {
        this.profesor = profesor;
    }
    
}
