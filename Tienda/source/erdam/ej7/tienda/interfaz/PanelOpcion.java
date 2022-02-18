package erdam.ej7.tienda.interfaz;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel para las opciones.
 */
@SuppressWarnings("serial")
public class PanelOpcion extends JPanel implements ActionListener {

	// ------- C O N S T A N T E S -------//
	/**
	 * Comando para mostrar los productos más vendidos.
	 */
	private static final String PRODUCTOS_MAS_VENDICOS 	 		= "Productos más vendidos";
	/**
	 * Comando para mostrar los productos menso vendidos.
	 */
	private static final String PRODUCTOS_MENOS_VENDIDOS        = "Productos menos vendidos";
	/**
	 * Comando para mostrar el promedio de ventas.
	 */
	private static final String PROMEDIO_VENTAS	 				= "Promedio ventas";
	/**
	 * Comando para mostrar el dinero que hay en caja.
	 */
	private static final String DINERO_EN_CAJA	 				= "Dinero en caja";
	//------- A T R I B U T O S -------//
	/**
	 * Ventana principal de la aplicación.
	 */
	private InterfazTienda                      principal;
	/**
	 * Botón para mostrar los productos más vendidos.
	 */
	private JButton                             btnMasVendidos;
	/**
	 * Botón para mostrar los productos menos vendidos.
	 */
	private JButton                             btnMenosVendidos;
	/**
	 * Botón para mostrar el promedio de ventas.
	 */
	private JButton                             btnPromedio;
	/**
	 * Botón para mostrar la caja.
	 */
	private JButton                             btnCaja;

	//----- C O N S T R U C T O R  -----//
	/**
	 * Construye el panel con los botones Dinero en caja, promedio de ventas,<br>
	 * productos menos vendidos y productos más vendidos.
	 * @param pPrincipal Ventana principal de la aplicación pPrincipal!=null.
	 */
	public PanelOpcion(InterfazTienda pPrincipal) {
		principal= pPrincipal;
		
		setLayout(new GridLayout(1,4,5,5));
		
		setBorder(new TitledBorder( "Opciones" ) );
		btnMasVendidos 						= new JButton(PRODUCTOS_MAS_VENDICOS);
		btnMasVendidos.setActionCommand(PRODUCTOS_MAS_VENDICOS);
		btnMasVendidos.addActionListener(this);
		btnMasVendidos.setBackground(Color.GRAY);
		btnMasVendidos.setForeground(Color.WHITE);

		btnMenosVendidos                          	= new JButton(PRODUCTOS_MENOS_VENDIDOS);
		btnMenosVendidos.setActionCommand(PRODUCTOS_MENOS_VENDIDOS);
		btnMenosVendidos.addActionListener(this);
		btnMenosVendidos.setBackground(Color.GRAY);
		btnMenosVendidos.setForeground(Color.WHITE);
		
		btnPromedio                          = new JButton(PROMEDIO_VENTAS);
		btnPromedio.setActionCommand(PROMEDIO_VENTAS);
		btnPromedio.addActionListener(this);
		btnPromedio.setBackground(Color.GRAY);
		btnPromedio.setForeground(Color.WHITE);
	
		btnCaja                          = new JButton(DINERO_EN_CAJA);
		btnCaja.setActionCommand(DINERO_EN_CAJA);
		btnCaja.addActionListener(this);
		btnCaja.setBackground(Color.GRAY);
		btnCaja.setForeground(Color.WHITE);
	
		setLayout(new GridLayout(1,4,20,10));
		add(btnMasVendidos);
		add(btnMenosVendidos);
		add(btnPromedio);
		add(btnCaja);
	}
	//--------- M É T O D O S ----------//
	//---------------------------------------------------//
	/**
	 * Manejo de los eventos de los botones.
     * @param pEvento Evento de click sobre un botón. pEvento != null.
	 */
	@Override
	public void actionPerformed(ActionEvent pEvento) {
		try {
			String command = pEvento.getActionCommand();
			switch(command) {
				case PRODUCTOS_MAS_VENDICOS:
					 principal.getProductoMasVendido();
				break;
				case PRODUCTOS_MENOS_VENDIDOS :
					 principal.getProductoMenosVendido();
				break;
				case PROMEDIO_VENTAS:
					 principal.getPromedioVenta();
				break;
				case DINERO_EN_CAJA:
					 principal.getDineroEnCaja();
				break;
				
			}
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
		
		
	}

}
