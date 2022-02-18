package erdam.ej7.tienda.interfaz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import erdam.ej7.tienda.mundo.Producto;

/**
 * Panel que muestra la información de un producto.
 */
@SuppressWarnings("serial")
public class PanelProducto extends JPanel implements ActionListener {
	// ------- C O N S T A N T E S -------//
	/**
	 * Comando para abastecer producto.
	 */
	private static final String ABASTECER = "Abastecer";
	/*
	 * Comando para vender un producto.
	 */
	private static final String VENDER = "Vender";
	/**
	 * Comando para acceder a un dialogo el cual tiene todas las opciones .
	 */
	private static final String CAMBIAR = "Cambiar";
	// ------- A T R I B U T O S -------//
	/**
	 * Ventana principal de la aplicación.
	 */
	private InterfazTienda 			principal;
	/**
	 * producto del panel.
	 */
	private Producto 				producto;

	/**
	 * Etiqueta tipo de producto.
	 */
	private JLabel 					lblTipo;
	/**
	 * Etiqueta Cantidad en bodega.
	 */
	private JLabel 					lblCantidadEnBodega;
	/**
	 * Etiqueta precio unitario.
	 */
	private JLabel 					lblPrecioUnitario;
	/**
	 * Etiqueta cantidad de productos vendidos.
	 */
	private JLabel 					lblCantidadVendida;
	/**
	 * Etiqueta cantidad mínima en bodega.
	 */
	private JLabel 					lblCantidadMinima;
	/**
	 * Etiqueta contenedora de la imágen del producto.
	 */
	private JLabel 					lblImagen;
	/**
	 * Campo de texto que nos da el tipo (droguería, supermercado, papelaría )
	 */
	private JTextField 				txtTipo;
	/**
	 * Campo de texto que nos muestra cantidad que hay en bodega.
	 */
	private JTextField 				txtCantidadEnBodega;
	/**
	 * Campo de texto que muestra el precio unitario del producto.
	 */
	private JTextField 				txtPrecioUnitario;
	/**
	 * Campo de texto que muestra la cantidad de producto vendido.
	 */
	private JTextField 				txtCantidadVendida;
	/**
	 * Campo de texto que muestra la cantidad mínima que debe haber en bodega.
	 */
	private JTextField 				txtCantidadMinima;
	/**
	 * Botón para abastecer un producto.
	 */
	private JButton 				btnAbastecer;
	/**
	 * Botón para dar vender un producto.
	 */
	private JButton 				btnVender;
	/**
	 * Botón para cambiar un producto, éste botón abre un dialogo con las opciones
	 * de modificación.
	 */
	private JButton 				btnCambiar;

	// ----- C O N S T R U C T O R -----//
	/**
	 * Construye el panel con la información del producto.
	 * @param pPrincipal Ventana principal de la aplicación. pPrincipal!=null.
	 */
	public PanelProducto(InterfazTienda pPrincipal) {
		principal = pPrincipal;

		setLayout(new BorderLayout());
		JPanel panelPrincipal 					= new JPanel();
		JPanel panelBotones 					= new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBorder(new TitledBorder("Producto"));
		panelPrincipal.setLayout(new GridLayout(5, 1, 0, 5));
		panelBotones.setLayout(new GridLayout(1, 3));
		lblTipo 								= new JLabel("Tipo: ");
		lblCantidadEnBodega 					= new JLabel("Cantidad en bodega: ");
		lblPrecioUnitario 						= new JLabel("Precio unitario: ");
		lblCantidadMinima 						= new JLabel("Cantidad Mínima: ");
		lblCantidadVendida						= new JLabel("Cantidad Vendidas: ");
		lblImagen 								= new JLabel(new ImageIcon("data/imagenes/pan.png"));
		txtTipo 								= new JTextField(15);
		txtTipo.setEditable(false);
		txtCantidadEnBodega 					= new JTextField(15);
		txtCantidadEnBodega.setEditable(false);
		txtPrecioUnitario 						= new JTextField(15);
		txtPrecioUnitario.setEditable(false);
		txtCantidadVendida 						= new JTextField(15);
		txtCantidadVendida.setEditable(false);
		txtCantidadMinima 						= new JTextField(15);
		txtCantidadMinima.setEditable(false);
		btnAbastecer 							= new JButton(ABASTECER);
		btnAbastecer.setActionCommand(ABASTECER);
		btnAbastecer.addActionListener(this);
		btnVender = new JButton(VENDER);
		btnVender.setActionCommand(VENDER);
		btnVender.addActionListener(this);
		btnCambiar = new JButton(CAMBIAR);
		btnCambiar.setActionCommand(CAMBIAR);
		btnCambiar.addActionListener(this);
		panelPrincipal.add(lblTipo);
		panelPrincipal.add(txtTipo);
		panelPrincipal.add(lblCantidadEnBodega);
		panelPrincipal.add(txtCantidadEnBodega);
		panelPrincipal.add(lblPrecioUnitario);
		panelPrincipal.add(txtPrecioUnitario);
		panelPrincipal.add(lblCantidadVendida);
		panelPrincipal.add(txtCantidadVendida);
		panelPrincipal.add(lblCantidadMinima);
		panelPrincipal.add(txtCantidadMinima);
		panelBotones.add(btnAbastecer);
		panelBotones.add(btnVender);
		panelBotones.add(btnCambiar);
		add(panelPrincipal, BorderLayout.CENTER);
		add(lblImagen, BorderLayout.WEST);
		add(panelBotones, BorderLayout.SOUTH);

	}
	// --------- M É T O D O S ----------//

	// ---------------------------------------------------//
	/**
	 * Actualiza los campos del panel con la información.
	 * 
	 * @param pProducto Producto que se va a actualizar. pProducto != null.
	 */
	public void actualizar(Producto pProducto) {
		producto = pProducto;
		setBorder(new TitledBorder(producto.getNombre()));
		lblImagen.setIcon(new ImageIcon("data/imagenes/" + producto.getImagenProducto()));
		txtTipo.setHorizontalAlignment(JTextField.CENTER);
		txtTipo.setText(producto.getTipo().toString());
		txtTipo.setBackground(Color.WHITE);
		txtCantidadEnBodega.setHorizontalAlignment(JTextField.CENTER);
		txtCantidadEnBodega.setText(Integer.toString(producto.getCantidadEnBodega()));
		txtCantidadEnBodega.setBackground(Color.WHITE);
		txtPrecioUnitario.setHorizontalAlignment(JTextField.CENTER);
		txtPrecioUnitario.setText("$ " + producto.getPrecioUnitario());
		txtPrecioUnitario.setBackground(Color.WHITE);
		txtCantidadVendida.setHorizontalAlignment(JTextField.CENTER);
		txtCantidadVendida.setText(Integer.toString(producto.getCantidadUnidadesVendidas()));
		txtCantidadVendida.setBackground(Color.WHITE);
		txtCantidadMinima.setHorizontalAlignment(JTextField.CENTER);
		txtCantidadMinima.setText(Integer.toString(producto.getCantidadMinima()));
		txtCantidadMinima.setBackground(Color.WHITE);
		if (producto.getCantidadEnBodega() <= producto.getCantidadMinima()) {
			txtCantidadEnBodega.setForeground(Color.RED);
		} else {
			txtCantidadEnBodega.setForeground(Color.BLACK);
		}
	}

	// ---------------------------------------------------//
	/**
	 * Manejo de los eventos de los botones.
	 * 
	 * @param pEvento Evento de click sobre un botón. pEvento != null.
	 */
	@Override
	public void actionPerformed(ActionEvent pEvento) {
		try {
			String command = pEvento.getActionCommand();
			switch (command) {
			case ABASTECER:

				principal.abastecerProducto(producto.getNombre());
				break;
			case VENDER:
				principal.venderProducto(producto.getNombre());
				break;
			case CAMBIAR:
				principal.DialogoCambiarProducto(producto.getNombre(), producto.getImagenProducto());
				break;

			}
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}

	}

}
