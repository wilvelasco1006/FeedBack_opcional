/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import modelo.ProgramaAcademico;
import vista.VistaProgramaAcademico;

/**
 *
 * @author wilme
 */
public class ControlVistaProgramaAcademico implements ActionListener {

    //atributos
    private ProgramaAcademico unPrograma;
    private VistaProgramaAcademico vista;
    private List<ProgramaAcademico> listaPrograma = new ArrayList<>();
    private int indice = -1;

    //contructor
    public ControlVistaProgramaAcademico() {
        this.vista = new VistaProgramaAcademico();
        this.vista.setVisible(true);
        //añadir escuchas a los botones
        this.vista.btn_AgregarPrograma.addActionListener(this);
        this.vista.btn_buscarPrograma.addActionListener(this);
        this.vista.btn_actualizarPrograma.addActionListener(this);
        this.vista.btn_borrarPrograma.addActionListener(this);
        this.vista.btn_atras.addActionListener(this);
    }

    // metodo para limpiar los texfield
    public void LimpiarDatos() {
        this.vista.jtf_codigoProgramaA.setText("");
        this.vista.jtf_nombreProgramaA.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //boton agregar
        if (e.getSource() == this.vista.btn_AgregarPrograma) {
            unPrograma = new ProgramaAcademico();
            unPrograma.setCodigo(Integer.parseInt(this.vista.jtf_codigoProgramaA.getText()));
            unPrograma.setNombre(this.vista.jtf_nombreProgramaA.getText());
            //añadir a la lista
            this.listaPrograma.add(unPrograma);
            //mensajito
            javax.swing.JOptionPane.showMessageDialog(this.vista, "Se ingreso el Programa Academico correctamente", "Registro", 1);
            this.vista.jtf_codigoProgramaA.setText("");
            this.vista.jtf_nombreProgramaA.setText("");

        }
        //boton buscar
        if (e.getSource() == this.vista.btn_buscarPrograma) {
            //algoritmo para buscar
            for (int i = 0; i < this.listaPrograma.size(); i++) {
                if (this.listaPrograma.get(i).getCodigo() == Integer.parseInt(this.vista.jtf_codigoProgramaA.getText())) {
                    this.vista.jtf_nombreProgramaA.setText(this.listaPrograma.get(i).getNombre());
                    javax.swing.JOptionPane.showMessageDialog(vista, "Se encontro el programa", "BUSQUEDA", 1);
                    this.indice = i;
                    break;
                } else {
                    javax.swing.JOptionPane.showMessageDialog(vista, "No se encontro el programa", "BUSQUEDA", 1);
                }

            }
        }
        // boton actuslizar
        if (e.getSource() == this.vista.btn_actualizarPrograma) {
            if (indice != -1) {
                this.listaPrograma.get(indice).setCodigo(Integer.parseInt(this.vista.jtf_codigoProgramaA.getText()));
                this.listaPrograma.get(indice).setNombre(this.vista.jtf_nombreProgramaA.getText());
                javax.swing.JOptionPane.showMessageDialog(this.vista, "Codigo encontrado", "Resultado", 1);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this.vista, "Codigo no encontrado", "Resultado", 1);
            }
            LimpiarDatos();

        }
        //boton borrar
        if (e.getSource() == this.vista.btn_borrarPrograma) {
            if (indice != -1) {
                this.listaPrograma.remove(indice);
                javax.swing.JOptionPane.showMessageDialog(this.vista, "Programa eliminado", "Resultado", 1);
                LimpiarDatos();

            } else {
                javax.swing.JOptionPane.showMessageDialog(this.vista, "El coddigo no existe", "Resultado", 1);
            }

        }
        //boton atras
        if (e.getSource()== this.vista.btn_atras) {
            this.vista.setVisible(false);
            LimpiarDatos();
        }

    }

    //gettr y seter
    public ProgramaAcademico getUnPrograma() {
        return unPrograma;
    }

    public void setUnPrograma(ProgramaAcademico unPrograma) {
        this.unPrograma = unPrograma;
    }

    public VistaProgramaAcademico getVista() {
        return vista;
    }

    public void setVista(VistaProgramaAcademico vista) {
        this.vista = vista;
    }

    public List<ProgramaAcademico> getListaPrograma() {
        return listaPrograma;
    }

    public void setListaPrograma(List<ProgramaAcademico> listaPrograma) {
        this.listaPrograma = listaPrograma;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

}
