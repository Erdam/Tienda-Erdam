package erdam.ej7.tienda.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import erdam.ej7.tienda.mundo.Tipo;

import java.io.File;

/**
 * Dialogo que se muestra cuando se quiere cambiar un producto.
 */
@SuppressWarnings("serial")
public class DialogoCambiarProducto extends JDialog implements ActionListener {

	// ------- C O N S T A N T E S -------//
	/**
	 * Comando para seleccionar la imágen.
	 */
	private static final String SELECCIONAR_IMAGEN = "Imagen";
	/**
	 * Comando para aceptar los cambios.
	 */
	private static final String ACEPTAR = "Aceptar";
	/**
	 * Comando para cancelar las modificaciones.
	 */
	private static final String CANCELAR = "Cancelar";
	// ------- A T R I B U T O S -------//
	/**
	 * Ventana principal de la aplicación.
	 */
	private InterfazTienda principal;
	/**
	 * Etiqueta contenedora de Imágen.
	 */
	private JLabel lblBanner;
	/**
	 * Etiqueta nombre actual del producto
	 */
	private JLabel lblNombreActual;
	/**
	 * Etiqueta nombre nuevo del producto
	 */
	private JLabel lblNombreNuevo;
	/**
	 * Etiqueta tipo.
	 */
	private JLabel lblTipo;
	/**
	 * Etiqueta Cantidad en bodega.
	 */
	private JLabel lblCantidadEnBodega;
	/**
	 * Etiqueta Precio unitario.
	 */
	private JLabel lblPrecioUnitario;

	/**
	 * Etiqueta Cantidad mínima en bodega.
	 */
	private JLabel lblCantidadMinima;
	/**
	 * Etiqueta contenedora la etiqueta imágen.
	 */
	private JLabel lblImagen;
	/**
	 * Combo box con el tipo.
	 */
	private JComboBox<String> cbTipo;
	/**
	 * Campo de texto que muestra el nombre actual del producto
	 */
	private JTextField txtNombreActual;
	/**
	 * Campo de texto que musetra el nombre nuevo del producto.
	 */
	private JTextField txtNombreNuevo;
	/**
	 * Campo de texto que muestra la cantidad que hay en bodega.
	 */
	private JTextField txtCantidadEnBodega;
	/**
	 * Campo de texto que mustra el valor unitario del producto.
	 */
	private JTextField txtPrecioUnitario;
	/**
	 * Campo de texto que muestra la cantidad mínima para poder abastecer.
	 */
	private JTextField txtCantidadMinima;
	/**
	 * Texto con el nombre de la imágen.
	 */
	private JTextField txtImagen;

	/**
	 * Botón que activa la selección de imágen.
	 */
	private JButton btnSeleccionarImagen;
	/**
	 * Botón que activa que se aceptan los cambios hechos.
	 */
	private JButton btnAceptar;
	/**
	 * Botón que activa la acancelación de los cambios hechos.
	 */
	private JButton btnCancelar;

	// ----- C O N S T R U C T O R -----//
	/**
	 * Crea el diálogo para consultar ventas
	 * 
	 * @param pPrincipal      Ventana principal de la aplicación. pPrincipal!= null.
	 * @param pNombreProducto Nombre actual del producto. pNombreProducto != null.
	 * 
	 */
	public DialogoCambiarProducto(InterfazTienda pPrincipal, String pNombreProducto, String pRutaImagen) {
		principal = pPrincipal;
		setSize(500, 500);
		setTitle("Cambiar producto");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		lblNombreActual = new JLabel();

		setModal(true);
		setLocationRelativeTo(pPrincipal);
		setResizable(false);

		JPanel banner = new JPanel();
		JPanel body = new JPanel();
		JPanel footer = new JPanel();
		btnSeleccionarImagen = new JButton(SELECCIONAR_IMAGEN);
		btnSeleccionarImagen.setActionCommand(SELECCIONAR_IMAGEN);
		btnSeleccionarImagen.addActionListener(this);
		btnAceptar = new JButton(ACEPTAR);
		btnAceptar.setActionCommand(ACEPTAR);
		btnAceptar.addActionListener(this);
		btnCancelar = new JButton(CANCELAR);
		btnCancelar.setActionCommand(CANCELAR);
		btnCancelar.addActionListener(this);

		lblBanner = new JLabel(new ImageIcon("data/imagenes/EncabezadoCambiar.png"));
		lblNombreActual = new JLabel(" Nombre actual:");
		txtNombreActual = new JTextField(pNombreProducto);
		txtNombreActual.setEditable(false);
		lblNombreNuevo = new JLabel(" Nombre nuevo:");
		txtNombreNuevo = new JTextField(15);
		lblPrecioUnitario = new JLabel(" Precio unitario:");
		txtPrecioUnitario = new JTextField(15);
		lblTipo = new JLabel(" Tipo:");
		cbTipo = new JComboBox<String>();
		cbTipo.addItem("Papelería");
		cbTipo.addItem("Supermercado");
		cbTipo.addItem("Droguería");
		lblCantidadEnBodega = new JLabel(" Cantidad en bodega:");
		txtCantidadEnBodega = new JTextField(15);
		lblCantidadMinima = new JLabel(" Cantidad Mínima:");
		txtCantidadMinima = new JTextField(7);
		lblImagen = new JLabel();
		lblImagen.setIcon(new ImageIcon("data/imagenes/" + pRutaImagen));
		txtImagen = new JTextField(pRutaImagen.replace(".png", ""));
		txtImagen.setHorizontalAlignment(JTextField.CENTER);
		txtImagen.setEditable(false);
        setLayout(new BorderLayout());
		banner.add(lblBanner);
		body.setLayout(new GridLayout(7, 2, 0, 10));
		body.add(lblNombreActual);
		body.add(txtNombreActual);
		body.add(lblNombreNuevo);
		body.add(txtNombreNuevo);
		body.add(lblPrecioUnitario);
		body.add(txtPrecioUnitario);
		body.add(lblTipo);
		body.add(cbTipo);
		body.add(lblCantidadEnBodega);
		body.add(txtCantidadEnBodega);
		body.add(lblCantidadMinima);
		body.add(txtCantidadMinima);
		body.add(new JLabel());
		body.add(new JLabel());
		add(lblImagen, BorderLayout.WEST );
		footer.setLayout(new GridLayout(1, 3, 5, 5));
		footer.add(btnSeleccionarImagen);
		footer.add(btnAceptar);
		footer.add(btnCancelar);
		add(banner, BorderLayout.NORTH);
		add(body, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);

	}

	// --------- M É T O D O S ----------//
	// ---------------------------------------------------//
	/**
	 * Manejo de los eventos de los botones.
	 * @param pEvento Evento de click sobre un botón. pEvento != null.
	 */
	@Override
	public void actionPerformed(ActionEvent pEvento) {
		try {
			String command = pEvento.getActionCommand();
			switch (command) {
			case SELECCIONAR_IMAGEN:
				JFileChooser jfc = new JFileChooser("data/imagenes/");
				int resultado = jfc.showOpenDialog(this);
				if (resultado == JFileChooser.APPROVE_OPTION) {
					File archivo = jfc.getSelectedFile();
					txtImagen.setText(archivo.getName());
					lblImagen.setIcon(new ImageIcon("data/imagenes/" + archivo.getName()));
				}

				break;
			case ACEPTAR:
				String nombreNuevo = txtNombreNuevo.getText();
				String tipoStr = (String) cbTipo.getSelectedItem();
				String valorStr = txtPrecioUnitario.getText();
				String cantBodegStr = txtCantidadEnBodega.getText();
				String cantMinStr = txtCantidadMinima.getText();
				String imagenStr = txtImagen.getText();

				if (nombreNuevo.equals("") || tipoStr.equals("") || valorStr.equals("") || cantBodegStr.equals("")
						|| cantMinStr.equals("") || imagenStr.equals("")) {
					JOptionPane.showMessageDialog(this, "Debe llenar todos los campos.", "Cambiar producto",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						double precioUnitario = Double.parseDouble(valorStr);
						int cantidadBodega = Integer.parseInt(cantBodegStr);
						int cantidadMinima = Integer.parseInt(cantMinStr);

						if (cantidadBodega < 0 || cantidadMinima < 0 || precioUnitario < 0) {
							JOptionPane.showMessageDialog(this,
									"La cantidad en bodega, cantidad mínima y valor unitario no pueden ser valores negativos.",
									"Cambiar producto", JOptionPane.ERROR_MESSAGE);
						} else {
							Tipo tipo = Tipo.PAPELERIA;
							if (tipoStr.equals("Droguería")) {
								tipo = Tipo.DROGUERIA;
							} else if (tipoStr.equals("Supermercado")) {
								tipo = Tipo.SUPERMERCADO;
							}

							principal.cambiarProducto(txtNombreActual.getText(), nombreNuevo, tipo, cantidadBodega,
									cantidadMinima, precioUnitario, txtImagen.getText());
							dispose();
						}

					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(this,
								"El valor unitario, cantidad en bodega, cantidad mínima deben ser valores numéricos.",
								"Cambiar producto", JOptionPane.ERROR_MESSAGE);
					}

				}

				break;
			case CANCELAR:
				dispose();// Libera todos los recursos de pantalla nativos utilizados por esta ventana.
				break;

			}
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}

	}

}
