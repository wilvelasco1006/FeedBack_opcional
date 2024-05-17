/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import modelo.Curso;
import modelo.ProgramaAcademico;
import vista.VistaCurso;

/**
 *
 * @author wilme
 */
public class ControlVistaCurso implements ActionListener {

    //atributos 
    private Curso unCurso;
    private VistaCurso view;
    private List<Curso> listaCursos = new ArrayList<>();
    private int indice = -1;
    private ControlDocente unDocente;
    private ControlVistaProgramaAcademico unPrograma;
    private List<ProgramaAcademico> listaProgramas = new ArrayList<>();


    //contructor
    public ControlVistaCurso() {
        this.view = new VistaCurso();
        this.view.setVisible(true);
        //añadir los escuchas
        this.view.btn_agregarCurso.addActionListener(this);
        this.view.btn_buscarCurso.addActionListener(this);
        this.view.btn_actualizarCurso.addActionListener(this);
        this.view.btn_borrarCurso.addActionListener(this);
        this.view.btn_atras.addActionListener(this);
    }

    //limpiar los texfield
    public void Limpiartexfield() {
        this.view.jtf_codigoCurso.setText("");
        this.view.jtf_nombreCurso.setText("");
        this.view.jtf_programaAcademico.setText("");
        this.view.jtf_docente.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // boton agregar
        if (e.getSource() == this.view.jtf_codigoCurso) {
            unCurso = new Curso();
            unCurso.setCodigo(Integer.parseInt(this.view.jtf_codigoCurso.getText()));
            unCurso.setNombre(this.view.jtf_nombreCurso.getText());
            for (int i = 0; i < this.unDocente.getListaDocentes().size(); i++) {
                if (this.unDocente.getListaDocentes().get(i).getCodigo() == Integer.parseInt(this.view.jtf_docente.getText())) {
                    unCurso.setProfesor(this.unDocente.getListaDocentes().get(i));
                    break;
                }
            }
            for (int i = 0; i < this.unPrograma.getListaPrograma().size(); i++) {
                if (this.unPrograma.getListaPrograma().get(i).getCodigo() == Integer.parseInt(this.view.jtf_programaAcademico.getText())) {
                    unCurso.setProgra_aca(this.unPrograma.getListaPrograma().get(i));
                    break;
                }

            }
            this.listaCursos.add(unCurso);
        }
        // boton buscar
        if (e.getSource() == this.view.btn_buscarCurso) {
            //algoritmo para buscar
            for (int i = 0; i < this.listaCursos.size(); i++) {
                if (this.listaCursos.get(i).getCodigo() == Integer.parseInt(this.view.jtf_codigoCurso.getText())) {
                    this.view.jtf_nombreCurso.setText(this.listaCursos.get(i).getNombre());
                    javax.swing.JOptionPane.showMessageDialog(view, "Se encontro el Curso", "BUSQUEDA", 1);
                    this.indice = i;
                    break;
                } else {
                    javax.swing.JOptionPane.showMessageDialog(view, "No se encontro el Curso", "BUSQUEDA", 1);
                }

            }

        }
        // boton actualizar
        if (e.getSource() == this.view.btn_actualizarCurso) {
            if (indice != -1) {
                this.listaCursos.get(indice).setCodigo(Integer.parseInt(this.view.jtf_codigoCurso.getText()));
                this.listaCursos.get(indice).setNombre(this.view.jtf_nombreCurso.getText());
                for (int i = 0; i < this.unDocente.getListaDocentes().size(); i++) {
                    if (this.unDocente.getListaDocentes().get(i).getCodigo() == Integer.parseInt(this.view.jtf_docente.getText())) {
                        unCurso.setProfesor(this.unDocente.getListaDocentes().get(i));
                        break;
                    }
                }
                for (int i = 0; i < this.unPrograma.getListaPrograma().size(); i++) {
                    if (this.unPrograma.getListaPrograma().get(i).getCodigo() == Integer.parseInt(this.view.jtf_programaAcademico.getText())) {
                        unCurso.setProgra_aca(this.unPrograma.getListaPrograma().get(i));
                        break;
                    }

                }
            }
            javax.swing.JOptionPane.showMessageDialog(view, "CURSO ACTUALIZADO", "NOTIFICACION DE ACTUALIZACION", 1);

        } else {
            javax.swing.JOptionPane.showMessageDialog(view, "CURSO NO ACTUALIZADO", "NOTIFICACION DE ACTUALIZACION", 1);
        }
        Limpiartexfield();
        //boton borrar
        if (e.getSource() == this.view.btn_borrarCurso) {
            if (indice != -1) {
                this.listaCursos.remove(indice);
                javax.swing.JOptionPane.showMessageDialog(this.view, "Programa eliminado", "Resultado", 1);
                Limpiartexfield();

            } else {
                javax.swing.JOptionPane.showMessageDialog(this.view, "El codigo no existe", "Resultado", 1);
            }

        }
        // boton atras
        if (e.getSource()== this.view.btn_atras) {
            this.view.setVisible(false);
        }

    }
    //geter and seter
    public Curso getUnCurso() {
        return unCurso;
    }

    public void setUnCurso(Curso unCurso) {
        this.unCurso = unCurso;
    }

    public VistaCurso getView() {
        return view;
    }

    public void setView(VistaCurso view) {
        this.view = view;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public ControlDocente getUnDocente() {
        return unDocente;
    }

    public void setUnDocente(ControlDocente unDocente) {
        this.unDocente = unDocente;
    }

    public ControlVistaProgramaAcademico getUnPrograma() {
        return unPrograma;
    }

    public void setUnPrograma(ControlVistaProgramaAcademico unPrograma) {
        this.unPrograma = unPrograma;
    }

    public List<ProgramaAcademico> getListaProgramas() {
        return listaProgramas;
    }

    public void setListaProgramas(List<ProgramaAcademico> listaProgramas) {
        this.listaProgramas = listaProgramas;
    }
    

}
