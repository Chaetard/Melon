/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.ConsultaVenta;
import modelo.ModeloTablaVentas;
import modelo.ModeloVenta;
import vista.DoneVista;
import vista.VistaBusqueda;
import vista.VistaVentas;

/**
 *
 * @author Jesus Santos 221341606
 */
public class ControladorVistaVentas implements MouseListener {

    public boolean estado = false;

    VistaVentas VV;
    ModeloVenta ModeloVenta;
    ConsultaVenta ConsultaVenta = new ConsultaVenta();

    public ControladorVistaVentas(VistaVentas VV, ModeloVenta ModeloVenta) {

        this.VV = VV;
        this.ModeloVenta = ModeloVenta;
        this.VV.setVisible(true);
        oyentes();

    }

    private void oyentes() {
        VV.BtnGuardar.addMouseListener(this);
        VV.BtnActualizar.addMouseListener(this);
        VV.BtnEliminar.addMouseListener(this);
        VV.searchL.addMouseListener(this);
        VV.logoutVentasL.addMouseListener(this);
        VV.crossL.addMouseListener(this);
        VV.plusL.addMouseListener(this);
        VV.changesL.addMouseListener(this);
        VV.BtnBuscar.addMouseListener(this);
        VV.busquedaL.addMouseListener(this);

    }

    public boolean comprovarCampos() {

        if (VV.idVenta.getText().isEmpty() || VV.cliente.getText().isEmpty()
                || VV.estado.getText().isEmpty() || VV.descuento.getText().isEmpty()
                || VV.metodoPag.getText().isEmpty() || VV.total.getText().isEmpty()
                || VV.idEmp.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private boolean comprovarCampoId() {
        if (VV.idVenta.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void limpiarCampos() {
        VV.idVenta.setText("");
        VV.cliente.setText("");
        VV.estado.setText("");
        VV.descuento.setText("");
        VV.metodoPag.setText("");
        VV.total.setText("");
        VV.idEmp.setText("");
    }

    private void llenarModeloCampos() {
        String id_venta = VV.idVenta.getText();
        int ventas = Integer.parseInt(id_venta);
        ModeloVenta.setid_Venta(ventas);

        String id_cliente = VV.cliente.getText();
        int cliente = Integer.parseInt(id_cliente);
        ModeloVenta.setId_cliente(cliente);

        ModeloVenta.setEstado(VV.estado.getText());

        String descuentoi = VV.descuento.getText();
        double descuento = Double.parseDouble(descuentoi);
        ModeloVenta.setDescuento(descuento);

        ModeloVenta.setMetodo_pago(VV.metodoPag.getText());

        String totali = VV.total.getText();
        double total = Double.parseDouble(totali);
        ModeloVenta.setTotal(total);

        String id_emp = VV.idEmp.getText();
        int id_empleado = Integer.parseInt(id_emp);
        ModeloVenta.setId_empleado(id_empleado);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == VV.busquedaL) {
            busqedaMVC();
        }
        if (e.getSource() == VV.searchL) {
            VV.BtnGuardar.setVisible(false);
            VV.BtnBuscar.setVisible(true);
            VV.BtnEliminar.setVisible(false);
            VV.BtnActualizar.setVisible(false);
            VV.idVentaL.setVisible(true);
            VV.idVenta.setVisible(true);

            VV.clienteL.setVisible(false);
            VV.cliente.setVisible(false);
            VV.estadoL.setVisible(false);
            VV.estado.setVisible(false);
            VV.descuentoL.setVisible(false);
            VV.descuento.setVisible(false);
            VV.metodoPagL.setVisible(false);
            VV.metodoPag.setVisible(false);
            VV.idEmpL.setVisible(false);
            VV.idEmp.setVisible(false);
            VV.totalL.setVisible(false);
            VV.total.setVisible(false);

            VV.parrafo.setText("Buscar Datos de La Venta: IDs Validas");
            VV.parrafo.setFont(new Font("Arial", Font.PLAIN, 25));
            Dimension parrafoSize = VV.parrafo.getPreferredSize();
            int parrafoX = (1280 - parrafoSize.width) / 2;
            int parrafoY = 75;
            VV.parrafo.setBounds(parrafoX, parrafoY, parrafoSize.width, parrafoSize.height);
            VV.BtnBuscar.setBounds(590, 585, 120, 60);
            posisionarItems();
            
        }
        if (e.getSource() == VV.changesL) {
            VV.BtnGuardar.setVisible(false);
            VV.BtnBuscar.setVisible(false);
            VV.BtnEliminar.setVisible(false);
            VV.BtnActualizar.setVisible(true);
            VV.idVentaL.setVisible(true);
            VV.idVenta.setVisible(true);
            VV.clienteL.setVisible(true);
            VV.cliente.setVisible(true);
            VV.estadoL.setVisible(true);
            VV.estado.setVisible(true);
            VV.descuentoL.setVisible(true);
            VV.descuento.setVisible(true);
            VV.metodoPagL.setVisible(true);
            VV.metodoPag.setVisible(true);
            VV.idEmpL.setVisible(true);
            VV.idEmp.setVisible(true);
            VV.totalL.setVisible(true);
            VV.total.setVisible(true);

            VV.parrafo.setText("Actualizar Datos de La Venta: IDs Validas");
            VV.parrafo.setFont(new Font("Arial", Font.PLAIN, 25));
            Dimension parrafoSize = VV.parrafo.getPreferredSize();
            int parrafoX = (1280 - parrafoSize.width) / 2;
            int parrafoY = 75;
            VV.parrafo.setBounds(parrafoX, parrafoY, parrafoSize.width, parrafoSize.height);
            VV.BtnActualizar.setBounds(590, 585, 120, 60);
            posisionarItems();
            
        }
        if (e.getSource() == VV.crossL) {
            VV.BtnGuardar.setVisible(false);
            VV.BtnBuscar.setVisible(false);
            VV.BtnEliminar.setVisible(true);
            VV.BtnActualizar.setVisible(false);
            VV.idVentaL.setVisible(true);
            VV.idVenta.setVisible(true);
            VV.clienteL.setVisible(false);
            VV.cliente.setVisible(false);
            VV.estadoL.setVisible(false);
            VV.estado.setVisible(false);
            VV.descuentoL.setVisible(false);
            VV.descuento.setVisible(false);
            VV.metodoPagL.setVisible(false);
            VV.metodoPag.setVisible(false);
            VV.idEmpL.setVisible(false);
            VV.idEmp.setVisible(false);
            VV.totalL.setVisible(false);
            VV.total.setVisible(false);

            VV.parrafo.setText("Eliminar Venta: Ingrese el ID de la venta");
            VV.parrafo.setFont(new Font("Arial", Font.PLAIN, 25));
            Dimension parrafoSize = VV.parrafo.getPreferredSize();
            int parrafoX = (1280 - parrafoSize.width) / 2;
            int parrafoY = 75;
            VV.parrafo.setBounds(parrafoX, parrafoY, parrafoSize.width, parrafoSize.height);
            VV.BtnEliminar.setBounds(590, 585, 120, 60);
            posisionarItems();
            
        }
        if (e.getSource() == VV.plusL) {
            VV.BtnGuardar.setVisible(true);
            VV.BtnBuscar.setVisible(false);
            VV.BtnEliminar.setVisible(false);
            VV.BtnActualizar.setVisible(false);
            VV.idVentaL.setVisible(true);
            VV.idVenta.setVisible(true);
            VV.clienteL.setVisible(true);
            VV.cliente.setVisible(true);
            VV.estadoL.setVisible(true);
            VV.estado.setVisible(true);
            VV.descuentoL.setVisible(true);
            VV.descuento.setVisible(true);
            VV.metodoPagL.setVisible(true);
            VV.metodoPag.setVisible(true);
            VV.idEmpL.setVisible(true);
            VV.idEmp.setVisible(true);
            VV.totalL.setVisible(true);
            VV.total.setVisible(true);
            VV.parrafo.setText("Guardar Una Venta");
            VV.parrafo.setFont(new Font("Arial", Font.PLAIN, 25));
            Dimension parrafoSize = VV.parrafo.getPreferredSize();
            int parrafoX = (1280 - parrafoSize.width) / 2;
            int parrafoY = 75;
            VV.parrafo.setBounds(parrafoX, parrafoY, parrafoSize.width, parrafoSize.height);
            VV.BtnGuardar.setBounds(590, 585, 120, 60);
            posisionarItems();
            limpiarCampos();

        }
        if (e.getSource() == VV.BtnBuscar) {
            if (comprovarCampoId() == true) {
                BuscarDatosVenta();
            } else {
                JOptionPane.showMessageDialog(VV, "Debes de Llenar Todos los Campos", "Alerta", 0);
            }
        }
        if (e.getSource() == VV.BtnEliminar) {
            if (comprovarCampoId() == true) {
                EliminarDatosVenta();
            } else {
                JOptionPane.showMessageDialog(VV, "Debes de Llenar Todos los Campos", "Alerta", 0);
            }

        }
        if (e.getSource() == VV.BtnGuardar) {

            if (comprovarCampoId() == true) {
                InsertarDatosVenta();
            } else {
                JOptionPane.showMessageDialog(VV, "Debes de Llenar Todos los Campos", "Alerta", 0);
            }

        }
        if (e.getSource() == VV.BtnActualizar) {
            if (comprovarCampos() == true) {
                InsertarDatosActualizar();
            } else {
                JOptionPane.showMessageDialog(VV, "Debes de Llenar Todos los Campos", "Alerta", 0);
            }
        }
        if (e.getSource() == VV.logoutVentasL) {
            int opcion = JOptionPane.showConfirmDialog(VV, "En verdad quieres salir", "Alerta", 0, 3);
            if (opcion == 0) {

                VV.dispose();
            }
        }

        if (e.getSource() == VV.plusL) {
            VV.BtnGuardar.setVisible(true);
        }
        if (e.getSource() == VV.crossL) {
            VV.BtnGuardar.setVisible(false);
        }
    }

    private void InsertarDatosVenta() {
        llenarModeloCampos();
        if (ConsultaVenta.insertar(ModeloVenta) == true) {
            done();
            limpiarCampos();
        } else {

        }

    }

    private void InsertarDatosActualizar() {
        llenarModeloCampos();
        if (ConsultaVenta.modificar(ModeloVenta) == true) {
            done();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(VV, "Ocurrio Un Error", "Error", 0);
        }
    }

    private void BuscarDatosVenta() {
        llenarModeloId();
        if (ConsultaVenta.buscar(ModeloVenta) == true) {
            done();
            VV.clienteL.setVisible(true);
            VV.cliente.setVisible(true);
            VV.estadoL.setVisible(true);
            VV.estado.setVisible(true);
            VV.descuentoL.setVisible(true);
            VV.descuento.setVisible(true);
            VV.metodoPagL.setVisible(true);
            VV.metodoPag.setVisible(true);
            VV.idEmpL.setVisible(true);
            VV.idEmp.setVisible(true);
            VV.totalL.setVisible(true);
            VV.total.setVisible(true);

            VV.cliente.setText(String.valueOf(ModeloVenta.getId_cliente()));
            VV.estado.setText(String.valueOf(ModeloVenta.getEstado()));
            VV.descuento.setText(String.valueOf(ModeloVenta.getDescuento()));
            VV.metodoPag.setText(String.valueOf(ModeloVenta.getMetodo_pago()));
            VV.total.setText(String.valueOf(ModeloVenta.getTotal()));
            VV.idEmp.setText(String.valueOf(ModeloVenta.getId_empleado()));
        } else {
            JOptionPane.showMessageDialog(VV, "No existe esa venta", "Error", 0);
        }
    }

    private void EliminarDatosVenta() {
        llenarModeloId();
        if (ConsultaVenta.eliminar(ModeloVenta) == true) {
            done();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(VV, "Ocurrio Un Error", "Error", 0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (estado == true) {

        } else {
            if (e.getSource() == VV.searchL) {
                VV.LsearchL.setText("Buscar");
                VV.LsearchL.setFont(new Font("Arial", Font.PLAIN, 25));
                Dimension LsearchLSize = VV.LsearchL.getPreferredSize();
                VV.LsearchL.setBounds(334, 400, LsearchLSize.width, LsearchLSize.height);
            }

            if (e.getSource() == VV.plusL) {
                VV.LplusL.setText("Guardar");
                VV.LplusL.setFont(new Font("Arial", Font.PLAIN, 25));
                Dimension LplusLSize = VV.LplusL.getPreferredSize();
                VV.LplusL.setBounds(78, 400, LplusLSize.width, LplusLSize.height);
            }
            if (e.getSource() == VV.changesL) {
                VV.LchangesL.setText("Actualizar");
                VV.LchangesL.setFont(new Font("Arial", Font.PLAIN, 25));
                Dimension LchangesLSize = VV.LchangesL.getPreferredSize();
                VV.LchangesL.setBounds(590, 400, LchangesLSize.width, LchangesLSize.height);
            }

            if (e.getSource() == VV.crossL) {
                VV.LcrossL.setText("Eliminar");
                VV.LcrossL.setFont(new Font("Arial", Font.PLAIN, 25));
                Dimension LcrossLSize = VV.LcrossL.getPreferredSize();
                VV.LcrossL.setBounds(846, 400, LcrossLSize.width, LcrossLSize.height);
            }

            if (e.getSource() == VV.logoutVentasL) {
                VV.LlogoutVentasL.setText("Salir");
                VV.LlogoutVentasL.setFont(new Font("Arial", Font.PLAIN, 25));
                Dimension LlogoutVentasLLSize = VV.LlogoutVentasL.getPreferredSize();
                VV.LlogoutVentasL.setBounds(1102, 400, LlogoutVentasLLSize.width, LlogoutVentasLLSize.height);
            }
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (e.getSource() == VV.searchL) {
            VV.LsearchL.setText("");
        }
        if (e.getSource() == VV.plusL) {
            VV.LplusL.setText("");
        }
        if (e.getSource() == VV.changesL) {
            VV.LchangesL.setText("");
        }
        if (e.getSource() == VV.crossL) {
            VV.LcrossL.setText("");
        }
        if (e.getSource() == VV.logoutVentasL) {
            VV.LlogoutVentasL.setText("");
        }
    }

    private void posisionarItems() {

        int tamanoComponente = 50;
        estado = true;

        ImageIcon plus = new ImageIcon(getClass().getResource("/imagenes/plus.png"));
        ImageIcon plusTam = new ImageIcon(plus.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        VV.plusL.setIcon(plusTam);

        ImageIcon search = new ImageIcon(getClass().getResource("/imagenes/search.png"));
        ImageIcon searchTam = new ImageIcon(search.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        VV.searchL.setIcon(searchTam);

        ImageIcon changes = new ImageIcon(getClass().getResource("/imagenes/changes.png"));
        ImageIcon changesTam = new ImageIcon(changes.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        VV.changesL.setIcon(changesTam);
        ImageIcon cross = new ImageIcon(getClass().getResource("/imagenes/cross.png"));
        ImageIcon crossTam = new ImageIcon(cross.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        VV.crossL.setIcon(crossTam);

        ImageIcon logout = new ImageIcon(getClass().getResource("/imagenes/logoutVentas.png"));
        ImageIcon logoutTam = new ImageIcon(logout.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        VV.logoutVentasL.setIcon(logoutTam);

        VV.plusL.setBounds(10, 100, tamanoComponente, tamanoComponente);

        VV.searchL.setBounds(10, 200, tamanoComponente, tamanoComponente);

        VV.changesL.setBounds(10, 300, tamanoComponente, tamanoComponente);

        VV.crossL.setBounds(10, 400, tamanoComponente, tamanoComponente);

        VV.logoutVentasL.setBounds(10, 500, tamanoComponente, tamanoComponente);

    }

    private void llenarModeloId() {
        String id_venta = VV.idVenta.getText();
        int ventas = Integer.parseInt(id_venta);
        ModeloVenta.setid_Venta(ventas);
    }

    private void done() {
        DoneVista doneVista = new DoneVista();
        ControladorDoneVista controladorDoneVista = new ControladorDoneVista(doneVista);
    }

    private void busqedaMVC() {
        ModeloTablaVentas ModeloTablaVentas = new ModeloTablaVentas();
        VistaBusqueda VistaBusqueda = new VistaBusqueda(new JFrame(), true);
        
        ControladorBusqueda ControladorBusqueda = new ControladorBusqueda(ModeloTablaVentas, ModeloVenta, VistaBusqueda);

        if (ControladorBusqueda.est == true) {
            llenarVistaModelo();
        }

    }

    private void llenarVistaModelo() {

        VV.BtnGuardar.setVisible(false);
        VV.BtnBuscar.setVisible(false);
        VV.BtnEliminar.setVisible(false);
        VV.BtnActualizar.setVisible(true);
        VV.idVentaL.setVisible(true);
        VV.idVenta.setVisible(true);
        VV.clienteL.setVisible(true);
        VV.cliente.setVisible(true);
        VV.estadoL.setVisible(true);
        VV.estado.setVisible(true);
        VV.descuentoL.setVisible(true);
        VV.descuento.setVisible(true);
        VV.metodoPagL.setVisible(true);
        VV.metodoPag.setVisible(true);
        VV.idEmpL.setVisible(true);
        VV.idEmp.setVisible(true);
        VV.totalL.setVisible(true);
        VV.total.setVisible(true);
        VV.parrafo.setText("Actualizar Datos de La Venta: IDs Validas");
        VV.parrafo.setFont(new Font("Arial", Font.PLAIN, 25));
        Dimension parrafoSize = VV.parrafo.getPreferredSize();
        int parrafoX = (1280 - parrafoSize.width) / 2;
        int parrafoY = 75;
        VV.parrafo.setBounds(parrafoX, parrafoY, parrafoSize.width, parrafoSize.height);
        VV.BtnActualizar.setBounds(590, 585, 120, 60);
        posisionarItems();
        limpiarCampos();

        VV.idVenta.setText(String.valueOf(ModeloVenta.getid_Venta()));
        VV.cliente.setText(String.valueOf(ModeloVenta.getId_cliente()));
        VV.estado.setText(String.valueOf(ModeloVenta.getEstado()));
        VV.descuento.setText(String.valueOf(ModeloVenta.getDescuento()));
        VV.metodoPag.setText(String.valueOf(ModeloVenta.getMetodo_pago()));
        VV.total.setText(String.valueOf(ModeloVenta.getTotal()));
        VV.idEmp.setText(String.valueOf(ModeloVenta.getId_empleado()));
    }

}
