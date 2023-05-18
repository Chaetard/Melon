/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
public class ControladorVistaVentas implements MouseListener, KeyListener {

    public boolean estado = false;
    
    public boolean g = false;
    public boolean a = false;
    public boolean el = false;
    public boolean b = false;

    VistaVentas VV;
    ModeloVenta ModeloVenta;
    ConsultaVenta ConsultaVenta = new ConsultaVenta();

    int tami2 = 30;

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
        VV.BtnBuscar.addMouseListener(this);

        VV.searchL.addMouseListener(this);
        VV.logoutVentasL.addMouseListener(this);
        VV.crossL.addMouseListener(this);
        VV.plusL.addMouseListener(this);
        VV.changesL.addMouseListener(this);

        VV.busquedaL.addMouseListener(this);

        VV.power1L.addMouseListener(this);
        VV.power2L.addMouseListener(this);

        VV.idEmp.addKeyListener(this);
        VV.idVenta.addKeyListener(this);
        VV.cliente.addKeyListener(this);
        VV.estado.addKeyListener(this);
        VV.descuento.addKeyListener(this);
        VV.metodoPag.addKeyListener(this);
        VV.total.addKeyListener(this);
        VV.idEmp.addKeyListener(this);

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

        if (e.getSource() == VV.power2L) {
            VV.power1L.setVisible(true);
            VV.power2L.setVisible(false);
            iconsEstilo2();

        }
        if (e.getSource() == VV.power1L) {
            VV.power1L.setVisible(false);
            VV.power2L.setVisible(true);
            iconsEstilo1();
        }
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

            g = false;
            b = true;
            a = false;
            el = false;
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

            g = false;
            b = false;
            a = true;
            el = false;
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

            g = false;
            b = false;
            a = false;
            el = true;
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

            g = true;
            b = false;
            a = false;
            el = false;
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

            if (comprovarCampos() == true) {
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
        if (estadoi == true) {

        } else {
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
        Toolkit.getDefaultToolkit().beep();

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
    public boolean estadoi = false;

    private void iconsEstilo1() {
        ImageIcon search = new ImageIcon(getClass().getResource("/imagenes/search_1.png"));
        ImageIcon searchTam2 = new ImageIcon(search.getImage().getScaledInstance(tami2, tami2, Image.SCALE_DEFAULT));
        ImageIcon searchTam3 = new ImageIcon(search.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        ImageIcon upload = new ImageIcon(getClass().getResource("/imagenes/upload.png"));
        ImageIcon uploadTam2 = new ImageIcon(upload.getImage().getScaledInstance(tami2, tami2, Image.SCALE_DEFAULT));
        ImageIcon uploadTam3 = new ImageIcon(upload.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        ImageIcon save = new ImageIcon(getClass().getResource("/imagenes/save.png"));
        ImageIcon saveTam2 = new ImageIcon(save.getImage().getScaledInstance(tami2, tami2, Image.SCALE_DEFAULT));
        ImageIcon saveTam3 = new ImageIcon(save.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        ImageIcon cancel = new ImageIcon(getClass().getResource("/imagenes/cancel.png"));
        ImageIcon cancelTam2 = new ImageIcon(cancel.getImage().getScaledInstance(tami2, tami2, Image.SCALE_DEFAULT));
        ImageIcon cancelTam3 = new ImageIcon(cancel.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        ImageIcon logout = new ImageIcon(getClass().getResource("/imagenes/log-out.png"));
        ImageIcon logoutTam2 = new ImageIcon(logout.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        VV.BtnActualizar.setIcon(uploadTam2);

        VV.BtnBuscar.setIcon(searchTam2);

        VV.BtnEliminar.setIcon(cancelTam2);

        VV.BtnGuardar.setIcon(saveTam2);

        VV.plusL.setIcon(saveTam3);

        VV.searchL.setIcon(searchTam3);

        VV.changesL.setIcon(uploadTam3);

        VV.crossL.setIcon(cancelTam3);

        VV.logoutVentasL.setIcon(logoutTam2);

        VV.getContentPane().setBackground(new java.awt.Color(27, 27, 27));

        estadoi = true;

        VV.idVenta.setBackground(new java.awt.Color(17, 42, 56));
        VV.cliente.setBackground(new java.awt.Color(17, 42, 56));
        VV.estado.setBackground(new java.awt.Color(17, 42, 56));
        VV.descuento.setBackground(new java.awt.Color(17, 42, 56));
        VV.metodoPag.setBackground(new java.awt.Color(17, 42, 56));
        VV.idEmp.setBackground(new java.awt.Color(17, 42, 56));
        VV.total.setBackground(new java.awt.Color(17, 42, 56));

        VV.idVenta.setForeground(Color.WHITE);
        VV.cliente.setForeground(Color.WHITE);
        VV.estado.setForeground(Color.WHITE);
        VV.descuento.setForeground(Color.WHITE);
        VV.metodoPag.setForeground(Color.WHITE);
        VV.idEmp.setForeground(Color.WHITE);
        VV.total.setForeground(Color.WHITE);

        VV.idVenta.setCaretColor(Color.WHITE);
        VV.cliente.setCaretColor(Color.WHITE);
        VV.estado.setCaretColor(Color.WHITE);
        VV.descuento.setCaretColor(Color.WHITE);
        VV.metodoPag.setCaretColor(Color.WHITE);
        VV.idEmp.setCaretColor(Color.WHITE);
        VV.total.setCaretColor(Color.WHITE);

        VV.titulo.setForeground(Color.WHITE);
        VV.parrafo.setForeground(Color.WHITE);
        VV.idVentaL.setForeground(Color.WHITE);
        VV.clienteL.setForeground(Color.WHITE);
        VV.estadoL.setForeground(Color.WHITE);
        VV.descuentoL.setForeground(Color.WHITE);
        VV.metodoPagL.setForeground(Color.WHITE);
        VV.idEmpL.setForeground(Color.WHITE);
        VV.totalL.setForeground(Color.WHITE);

        VV.LchangesL.setForeground(Color.WHITE);
        VV.LcrossL.setForeground(Color.WHITE);
        VV.LlogoutVentasL.setForeground(Color.WHITE);
        VV.LplusL.setForeground(Color.WHITE);
        VV.LsearchL.setForeground(Color.WHITE);
    }

    private void iconsEstilo2() {

        ImageIcon plus = new ImageIcon(getClass().getResource("/imagenes/plus.png"));
        ImageIcon plusTam2 = new ImageIcon(plus.getImage().getScaledInstance(tami2, tami2, Image.SCALE_DEFAULT));

        ImageIcon search = new ImageIcon(getClass().getResource("/imagenes/search.png"));
        ImageIcon searchTam2 = new ImageIcon(search.getImage().getScaledInstance(tami2, tami2, Image.SCALE_DEFAULT));

        ImageIcon changes = new ImageIcon(getClass().getResource("/imagenes/changes.png"));
        ImageIcon changesTam2 = new ImageIcon(changes.getImage().getScaledInstance(tami2, tami2, Image.SCALE_DEFAULT));

        ImageIcon cross = new ImageIcon(getClass().getResource("/imagenes/cross.png"));
        ImageIcon crossTam2 = new ImageIcon(cross.getImage().getScaledInstance(tami2, tami2, Image.SCALE_DEFAULT));

        VV.BtnActualizar.setIcon(changesTam2);

        VV.BtnBuscar.setIcon(searchTam2);

        VV.BtnEliminar.setIcon(crossTam2);

        VV.BtnGuardar.setIcon(plusTam2);

        ImageIcon plusTam = new ImageIcon(plus.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        VV.plusL.setIcon(plusTam);

        estadoi = false;
        if (estado == true) {
            posisionarItems();
        } else {
            ImageIcon searchTam = new ImageIcon(search.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
            VV.searchL.setIcon(searchTam);

            ImageIcon changesTam = new ImageIcon(changes.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
            VV.changesL.setIcon(changesTam);

            ImageIcon crossTam = new ImageIcon(cross.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
            VV.crossL.setIcon(crossTam);

            ImageIcon logout = new ImageIcon(getClass().getResource("/imagenes/logoutVentas.png"));
            ImageIcon logoutTam = new ImageIcon(logout.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
            VV.logoutVentasL.setIcon(logoutTam);
        }
        VV.getContentPane().setBackground(new java.awt.Color(241, 195, 91));
        VV.titulo.setForeground(Color.BLACK);
        VV.parrafo.setForeground(Color.BLACK);
        VV.idVentaL.setForeground(Color.BLACK);
        VV.clienteL.setForeground(Color.BLACK);
        VV.estadoL.setForeground(Color.BLACK);
        VV.descuentoL.setForeground(Color.BLACK);
        VV.metodoPagL.setForeground(Color.BLACK);
        VV.idEmpL.setForeground(Color.BLACK);
        VV.totalL.setForeground(Color.BLACK);

        VV.LchangesL.setForeground(Color.BLACK);
        VV.LcrossL.setForeground(Color.BLACK);
        VV.LlogoutVentasL.setForeground(Color.BLACK);
        VV.LplusL.setForeground(Color.BLACK);
        VV.LsearchL.setForeground(Color.BLACK);

        VV.idVenta.setBackground(Color.WHITE);
        VV.cliente.setBackground(Color.WHITE);
        VV.estado.setBackground(Color.WHITE);
        VV.descuento.setBackground(Color.WHITE);
        VV.metodoPag.setBackground(Color.WHITE);
        VV.idEmp.setBackground(Color.WHITE);
        VV.total.setBackground(Color.WHITE);

        VV.idVenta.setForeground(Color.BLACK);
        VV.cliente.setForeground(Color.BLACK);
        VV.estado.setForeground(Color.BLACK);
        VV.descuento.setForeground(Color.BLACK);
        VV.metodoPag.setForeground(Color.BLACK);
        VV.idEmp.setForeground(Color.BLACK);
        VV.total.setForeground(Color.BLACK);

        VV.idVenta.setCaretColor(Color.BLACK);
        VV.cliente.setCaretColor(Color.BLACK);
        VV.estado.setCaretColor(Color.BLACK);
        VV.descuento.setCaretColor(Color.BLACK);
        VV.metodoPag.setCaretColor(Color.BLACK);
        VV.idEmp.setCaretColor(Color.BLACK);
        VV.total.setCaretColor(Color.BLACK);

    }

    private boolean validaCampoEntero(String Cadena, int longitud, JTextField jtf) {
        if (Cadena.matches("[0-9,.]+") && Cadena.length() < longitud + 1) {
            return true;
        } else {
            JOptionPane.showMessageDialog(VV, "Solo Numeros validos con una longitud no mayor a: " + longitud);
            jtf.setBackground(new java.awt.Color(255, 26, 26));

            return false;
        }
    }

    private boolean campoVacio(String Cadena, String Tipo, JTextField tipode) {
        if (Cadena.isEmpty()) {
            JOptionPane.showMessageDialog(VV, "Debes Ingresar Datos en el Campo" + Tipo);
            tipode.setBackground(new java.awt.Color(255, 26, 26));
            return false;
        } else {
            return true;
        }
    }

    private boolean validarLongitud(String Cadena, int longitud, JTextField jtf) {
        if (Cadena.length() < longitud - 1) {
            return true;
        } else {
            JOptionPane.showMessageDialog(VV, "Solo una longitud no mayor a: " + longitud);
            jtf.setBackground(new java.awt.Color(255, 26, 26));

            return false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (estadoi == true) {
            if (e.getSource() == VV.idVenta || e.getSource() == VV.cliente || e.getSource() == VV.estado || e.getSource() == VV.descuento || e.getSource() == VV.metodoPag || e.getSource() == VV.total || e.getSource() == VV.idEmp) {
                VV.idVenta.setBackground(new java.awt.Color(17, 42, 56));
                VV.cliente.setBackground(new java.awt.Color(17, 42, 56));
                VV.estado.setBackground(new java.awt.Color(17, 42, 56));
                VV.descuento.setBackground(new java.awt.Color(17, 42, 56));
                VV.metodoPag.setBackground(new java.awt.Color(17, 42, 56));
                VV.idEmp.setBackground(new java.awt.Color(17, 42, 56));
                VV.total.setBackground(new java.awt.Color(17, 42, 56));
            }
        } else {
            if (e.getSource() == VV.idVenta || e.getSource() == VV.cliente || e.getSource() == VV.estado || e.getSource() == VV.descuento || e.getSource() == VV.metodoPag || e.getSource() == VV.total || e.getSource() == VV.idEmp) {
                VV.idVenta.setBackground(Color.WHITE);
                VV.cliente.setBackground(Color.WHITE);
                VV.estado.setBackground(Color.WHITE);
                VV.descuento.setBackground(Color.WHITE);
                VV.metodoPag.setBackground(Color.WHITE);
                VV.idEmp.setBackground(Color.WHITE);
                VV.total.setBackground(Color.WHITE);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() == VV.idVenta) {
                if (campoVacio(VV.idVenta.getText(), " ID", VV.idVenta) == false) {

                } else {
                    if (validaCampoEntero(VV.idVenta.getText(), 11, VV.idVenta) == true) {
                        if (b == true) {
                            BuscarDatosVenta();
                        } else if (el == true) {
                            EliminarDatosVenta();
                        }
                        VV.cliente.requestFocus();
                    }
                }
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() == VV.cliente) {
                if (campoVacio(VV.cliente.getText(), " ID CLIENTE", VV.cliente) == false) {
                } else {
                    if (validaCampoEntero(VV.cliente.getText(), 11, VV.cliente) == true) {
                        VV.estado.requestFocus();
                    }
                }
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() == VV.estado) {
                if (campoVacio(VV.estado.getText(), " ESTADO", VV.estado) == false) {
                } else {
                    if (validarLongitud(VV.estado.getText(), 20, VV.estado) == true) {
                        VV.descuento.requestFocus();
                    }
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() == VV.descuento) {
                if (campoVacio(VV.descuento.getText(), " DESCUENTO", VV.descuento) == false) {
                } else {
                    if (validaCampoEntero(VV.descuento.getText(), 16, VV.descuento) == true) {
                        VV.metodoPag.requestFocus();
                    }
                }
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() == VV.metodoPag) {
                if (campoVacio(VV.metodoPag.getText(), " METODO DE PAGO", VV.metodoPag) == false) {
                } else {
                    if (validarLongitud(VV.metodoPag.getText(), 40, VV.metodoPag) == true) {
                        VV.total.requestFocus();
                    }
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() == VV.total) {
                if (campoVacio(VV.total.getText(), " TOTAL", VV.total) == false) {
                } else {
                    if (validaCampoEntero(VV.total.getText(), 16, VV.total) == true) {
                        VV.idEmp.requestFocus();
                    }
                }
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() == VV.idEmp) {
                if (a == true) {
                    if (campoVacio(VV.idEmp.getText(), " ID EMPLEADO", VV.idEmp) == false) {
                    } else {
                        if (validaCampoEntero(VV.idEmp.getText(), 16, VV.idEmp) == true) {
                            if (a == true) {
                                InsertarDatosActualizar();
                                a = false;
                            }
                        }
                    }
                }
                if (g == true) {
                    if (campoVacio(VV.idEmp.getText(), " ID EMPLEADO", VV.idEmp) == false) {
                    } else {
                        if (validaCampoEntero(VV.idEmp.getText(), 16, VV.idEmp) == true) {
                            if (g == true) {
                                InsertarDatosVenta();
                                g = false;
                            }
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }

}
