package erdam.ej7.tienda.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import erdam.ej7.tienda.mundo.Tienda;
import erdam.ej7.tienda.mundo.Tipo;
/**
 * Ventana principal de la aplicaci�n.
 */

@SuppressWarnings("serial")
public class InterfazTienda extends JFrame {
	// ------- A T R I B U T O S -------//
	/**
	 * Clase principal del mundo.
	 */
	private Tienda tienda;
	/**
	* Panel del banner.
	*/
	private PanelBanner banner;
	/**
	 * Panel de opciones.
	 */
	private PanelOpcion opciones;
	/**
	 * Panel con el producto1.
	 */
	private PanelProducto producto1;
	/**
	 * Panel con el producto2.
	 */
	private PanelProducto producto2;
	/**
	 * Panel con el producto3.
	 */
	private PanelProducto producto3;
	/**
	 * Panel con el producto4.
	 */
	private PanelProducto producto4;

	// ----- C O N S T R U C T O R -----/
	/**
	 * Constructor de la interfaz. <br>
	 * <b>post:</b> se inicializ� la interfaz inicial y todo sus paneles.<br>
	 */
	public InterfazTienda() {
		setSize(800, 800);
		setTitle("Tienda de Erdam");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		banner = new PanelBanner();
		tienda = new Tienda();
		opciones = new PanelOpcion(this);
		producto1 = new PanelProducto(this);
		producto2 = new PanelProducto(this);
		producto3 = new PanelProducto(this);
		producto4 = new PanelProducto(this);
		setLayout(new BorderLayout());
		add(banner, BorderLayout.NORTH);
		JPanel centro = new JPanel();
		centro.setLayout(new GridLayout(2, 2));
		centro.add(producto1);
		centro.add(producto2);
		centro.add(producto3);
		centro.add(producto4);
		add(centro, BorderLayout.CENTER);
		add(opciones, BorderLayout.SOUTH);
		actualizarPaneles();
	}

	// --------- M � T O D O S ----------//
	// ---------------------------------------------------//
	/**
	 * Actualiza la visualizaci�n de la interfaz. <br>
     * <b>post: </b> Se actualiz� la informaci�n de la interfaz.<br> 
	 */
	private void actualizarPaneles() {
		producto1.actualizar(tienda.getProducto1());
		producto2.actualizar(tienda.getProducto2());
		producto3.actualizar(tienda.getProducto3());
		producto4.actualizar(tienda.getProducto4());
	}

	// ---------------------------------------------------//
	/**
	 * Vender una cantidad de producto con el nombre dado en el parametro.
	 * @param pNombreProducto Nombre del producto. pNombreProducto!=null && pNombreProducto!="".
	 */
	public void venderProducto(String pNombreProducto) {
		String pCantidad = JOptionPane.showInputDialog(this, "Cantidad de unidades a vender:", "Vender producto",
				JOptionPane.INFORMATION_MESSAGE);
		if (pCantidad != null) {
			try {
				int cantidad = Integer.parseInt(pCantidad);
				if (cantidad > 0) {
					int venta = tienda.venderProducto(pNombreProducto, cantidad);
					if (venta > 0) {
						JOptionPane.showMessageDialog(this, "Fueron vendidas " + venta + " unidades.",
								"Vender producto", JOptionPane.INFORMATION_MESSAGE);
						actualizarPaneles();
					} else {
						JOptionPane.showMessageDialog(this, "El producto no tiene unidades para realizar la venta.",
								"Vender producto", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(this, "La cantidad ingresada debe ser mayor a cero.",
							"Vender producto", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "El valor ingresado debe ser un valor num�rico.", "Vender producto",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// ---------------------------------------------------//
	/**
	 * Abastecer una cantidad de producto con el nombre dado en le parametro.
	 * @param pNombreProducto Nombre del producto. pNombreProducto!=null && pNombreProducto!="".
	 */
	public void abastecerProducto(String pNombreProducto) {
		String pCantidad = JOptionPane.showInputDialog(this, "Cantidad de unidades a ingresar en la tienda:",
				"Vender producto", JOptionPane.INFORMATION_MESSAGE);
		if (pCantidad != null) {
			try {
				int cantidad = Integer.parseInt(pCantidad);
				if (cantidad > 0) {
					boolean abastecio = tienda.abastecerProducto(pNombreProducto, cantidad);
					if (abastecio) {
						JOptionPane.showMessageDialog(this, "Fueron abastecidas " + cantidad + " unidades a la tienda.",
								"Abastecer producto", JOptionPane.INFORMATION_MESSAGE);
						actualizarPaneles();
					} else {
						JOptionPane.showMessageDialog(this, "No se pudo abastecer la tienda.", "Abastecer producto",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(this, "La cantidad ingresada debe ser mayor a cero.", "Abastecer",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "El valor ingresado debe ser un valor num�rico.", "Abastecer",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// ---------------------------------------------------//
	/**
	 * Cambia un producto actual pasando los valores por parametro.
	 * @param pNombreActual Nombre del producto que existe en la memoria. pNombreActual!=null && pNombreActual!="".
	 * @param pNombreNuevo Nombre nuevo que se le va a dar al producto. pNombreNuevo!=null && pNombreNuevo!="".
	 * @param pTipo Categor�a que se le da al producto. pTipo! = null. 
	 * @param pCantidadEnBodega Cantidad que hay en bodega. pCantidadEnBodega >=0.
	 * @param pCantidadMInima Cantidad m�nima para rec�en poder abastecer. pCantidadMInima >=0.
	 * @param pPrecioUnitario Precio unitario del producto. pPrecioUnitario >= 0.
	 * @param pImagenProducto Imagen con la que se muestra al peoducto. pImagenProducto!= "" && pImagenProducto!=null. 
	 */
	public void cambiarProducto(String pNombreActual, String pNombreNuevo, Tipo pTipo, int pCantidadEnBodega,
			int pCantidadMInima, double pPrecioUnitario, String pImagenProducto) {
		boolean cambio = tienda.cambiarProducto(pNombreActual, pNombreNuevo, pTipo, pCantidadEnBodega, pCantidadMInima,
				pPrecioUnitario, pImagenProducto);
		if (!cambio) {
			JOptionPane.showMessageDialog(this, "Ya existe un producto con el nombre " + pNombreNuevo + ".",
					"Cambiar producto", JOptionPane.ERROR_MESSAGE);
		} else {
			actualizarPaneles();
		}
	}
	// ---------------------------------------------------//
	/**
	 * Ventana emergente para cambiar un producto actual pasando los valores por parametro.
	 * @param pNombreProducto Nombre del producto. pNombreProducto!=null && pNombreProducto!="".
	 * @param pRutaFoto Ruta que tiene ese producto. pRutaFoto!=null && pRutaFoto!="". 
	 */

	public void DialogoCambiarProducto(String pNombreProducto, String pRutaFoto) {
		DialogoCambiarProducto dialogo = new DialogoCambiarProducto(this, pNombreProducto, pRutaFoto);
		dialogo.setVisible(true);
	}
	// ---------------------------------------------------//
	/**
	 * Muestra el producto m�s vendido.
	 */
	public void getProductoMasVendido()
	{
		if(tienda.darProductoMasVendido()!=null) 
		{
			JOptionPane.showMessageDialog( this, "El producto m�s vendido es: " + tienda.darProductoMasVendido().getNombre( ) + 
					                       " con "+ tienda.darProductoMasVendido().getCantidadUnidadesVendidas()+ " Unidades", 
					                       "Producto m�s vendido", JOptionPane.INFORMATION_MESSAGE );
		}else
		{

            JOptionPane.showMessageDialog( this, "Ning�n produto tiene unidades vendidas.", "Producto m�s vendido", JOptionPane.ERROR_MESSAGE );
		}
        
	}
	// ---------------------------------------------------//
	/**
	 * Muestra el producto menos vendidos.
	 */
	public void getProductoMenosVendido()
	{
		if(tienda.darProductoMasVendido()!=null) 
		{
			JOptionPane.showMessageDialog( this, "El producto menos vendido es: " + tienda.darProductoMenosVendido().getNombre( ) + 
					                       " con "+ tienda.darProductoMenosVendido().getCantidadUnidadesVendidas()+ " Unidades", 
					                       "Producto menos vendido", JOptionPane.INFORMATION_MESSAGE );
		}else
		{

            JOptionPane.showMessageDialog( this, "Ning�n produto tiene unidades vendidas.", "Producto m�s vendido", JOptionPane.ERROR_MESSAGE );
		}
        
	}
	// ---------------------------------------------------//
    /**
     * Muestra el promedio de las ventas.
     */
	public void getPromedioVenta()
	{
		if(tienda.darPromedioVentas()!=0.0) {
		   JOptionPane.showMessageDialog( this, "El promedio es: " + tienda.darPromedioVentas(), "Promedio de ventas", JOptionPane.INFORMATION_MESSAGE );
		}
		else
		{
			JOptionPane.showMessageDialog( this, "A�n no haly productos vendidos", "Promedio de ventas", JOptionPane.ERROR_MESSAGE );
		}
	}
	// ---------------------------------------------------//
	/**
	 * Muestra el dinero que hay en caja.
	 */
	public void getDineroEnCaja()
	{
		if(tienda.getDineroEnCaja()!=0.0) {
		   JOptionPane.showMessageDialog( this, "La cantidad de dinero en caja es : $" + tienda.getDineroEnCaja(), "Dinero en caja", JOptionPane.INFORMATION_MESSAGE );
		}
		else
		{
			JOptionPane.showMessageDialog( this, "A�n no tiene dinero en caja", "Dinero en caja", JOptionPane.ERROR_MESSAGE );
		}
	}
	// ---------------------------------------------------//
	/**
     * Ejecuta la aplicaci�n.
     * @param pArgs Par�metros de la ejecuci�n. No son necesarios.
	 */
	public static void main(String[] pArgs) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			InterfazTienda inicio = new InterfazTienda();
			inicio.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
