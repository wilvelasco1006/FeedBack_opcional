/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Docente;
import vista.VistaDocente;

public class ControlDocente implements ActionListener {

    //atributos
    private Docente unDocente;
    private VistaDocente vista;
    private List<Docente> listaDocentes = new ArrayList<>();
    private int indice = -1;

    // constructor 
    public ControlDocente() {
        this.vista = new VistaDocente();
        this.vista.setVisible(true);
        //agrgar los listeners a los botones
        this.vista.btn_guardarprofe.addActionListener(this);
        this.vista.btn_buscar.addActionListener(this);
        this.vista.btn_actualizar.addActionListener(this);
        this.vista.btn_borrar.addActionListener(this);
        this.vista.btn_atras.addActionListener(this);
    }

    //funcion limpiar campos
    public void LimpiarCampos() {

        this.vista.jtf_numcedula.setText("");
        this.vista.jtf_nombres.setText("");
        this.vista.jtf_apellidos.setText("");
        this.vista.jtf_profesion.setText("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ///boton guardar
        if (e.getSource() == this.vista.btn_guardarprofe) {
            unDocente = new Docente();
            unDocente.setNombre(this.vista.jtf_nombres.getText());
            unDocente.setApellido(this.vista.jtf_apellidos.getText());
            unDocente.setProfesion(this.vista.jtf_profesion.getText());
            unDocente.setCodigo(Integer.parseInt(this.vista.jtf_numcedula.getText()));
            //añadir a la lista 
            this.listaDocentes.add(unDocente);
            //mensajito
            javax.swing.JOptionPane.showMessageDialog(this.vista, "Se ingreso el docente correctamente", "Registro", 1);
            this.vista.jtf_numcedula.setText("");
            this.vista.jtf_nombres.setText("");
            this.vista.jtf_apellidos.setText("");
            this.vista.jtf_profesion.setText("");
        }
        //boton buscar
        if (e.getSource() == this.vista.btn_buscar) {
            //algoritmo para buscar
            for (int i = 0; i < this.listaDocentes.size(); i++) {

                if (this.listaDocentes.get(i).getCodigo() == Integer.parseInt(this.vista.jtf_numcedula.getText())) {
                    this.vista.jtf_nombres.setText(this.listaDocentes.get(i).getNombre());
                    this.vista.jtf_apellidos.setText(this.listaDocentes.get(i).getApellido());
                    this.vista.jtf_profesion.setText(this.listaDocentes.get(i).getProfesion());
                    this.indice = i;
                    break;
                }
            }
            javax.swing.JOptionPane.showMessageDialog(this.vista, "NUMERO DE CEDULANO NO ENCONTRADO", "RESULTADO", 1);

        }
        //boton actualizar
        if (e.getSource() == this.vista.btn_actualizar) {

            if (indice != -1) {
                this.listaDocentes.get(indice).setCodigo(Integer.parseInt(this.vista.jtf_numcedula.getText()));
                this.listaDocentes.get(indice).setNombre(this.vista.jtf_nombres.getText());
                this.listaDocentes.get(indice).setApellido(this.vista.jtf_apellidos.getText());
                this.listaDocentes.get(indice).setProfesion(this.vista.jtf_profesion.getText());

            } else {
                javax.swing.JOptionPane.showMessageDialog(this.vista, "Numero de cedula no encontrado", "Resultado", 1);
            }
            LimpiarCampos();
        }
        //boton borrar
        if (e.getSource() == this.vista.btn_borrar) {
            if (indice != -1) {
                this.listaDocentes.remove(indice);
                javax.swing.JOptionPane.showMessageDialog(this.vista, "Docente eliminado", "Resultado", 1);
                LimpiarCampos();

            } else {
                javax.swing.JOptionPane.showMessageDialog(this.vista, "Numero de cedula no existe", "Resultado", 1);

            }
        }
        //boton atras
        if (e.getSource()== this.vista.btn_atras) {
            this.vista.setVisible(false);
        }

    }
    //metodos geter y setter
    public Docente getUnDocente() {
        return unDocente;
    }

    public void setUnDocente(Docente unDocente) {
        this.unDocente = unDocente;
    }

    public VistaDocente getVista() {
        return vista;
    }

    public void setVista(VistaDocente vista) {
        this.vista = vista;
    }

    public List<Docente> getListaDocentes() {
        return listaDocentes;
    }

    public void setListaDocentes(List<Docente> listaDocentes) {
        this.listaDocentes = listaDocentes;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    

}

