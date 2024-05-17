/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaMenu;

/**
 *
 * @author wilme
 */
public class ControlVistaMenu implements ActionListener {

    //atributos 
    private VistaMenu view;
    private ControlDocente unDocente;
    private ControlVistaProgramaAcademico unPrograma;
    private ControlVistaCurso unCurso;

    public ControlVistaMenu() {
        this.view = new VistaMenu();
        unDocente = new ControlDocente();
        unDocente.getVista().setVisible(false);
        unPrograma = new ControlVistaProgramaAcademico();
        unPrograma.getVista().setVisible(false);
        unCurso = new ControlVistaCurso();
        unCurso.getView().setVisible(false);
        // escuchas 
        this.view.btn_docente.addActionListener(this);
        this.view.btn_programa.addActionListener(this);
        this.view.btn_curso.addActionListener(this);
        this.view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.view.btn_docente) {
            unDocente.getVista().setVisible(true);
        }
        if (e.getSource()== this.view.btn_programa) {
            unPrograma.getVista().setVisible(true);
        }
        if (e.getSource()==this.view.btn_curso) {
            unCurso.getView().setVisible(true);
            unCurso.setUnDocente(unDocente);
            unCurso.setListaProgramas(unPrograma.getListaPrograma());
        }
        
    }

}
