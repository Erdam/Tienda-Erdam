package erdam.ej7.tienda.interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Panel con la imagen del banner.
 */
@SuppressWarnings("serial")
public class PanelBanner extends JPanel {

	//------- A T R I B U T O S -------//
	private JLabel contenedor;
	private ImageIcon imagen;
	
	//----- C O N S T R U C T O R  -----//
	/**
	 * Constructor del Panel <br>
	 * <b>post:</b> El panel quedó iniciado
	 */
	public PanelBanner()
	{
		contenedor = new JLabel("");
		imagen = new ImageIcon("data/imagenes/Encabezado.png");
		contenedor.setIcon(imagen);
		add(contenedor);
		
	}

}
