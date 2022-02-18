package erdam.ej7.tienda.mundo;
/**
 * Producto de la tienda.
 *
 */
public class Producto {
	// ------- C O N S T A N T E S -------//
    /**
     * Representa el impuesto asociado al tipo PAPELERIA.
     */
	private static final Double PAPELERIA_IVA = .16;
	/**
	 * Representa el impuesto asociado al tipo SUPERMERCADO.
	 */
	private static final Double SUPERMERCADO_IVA = .04;
	/**
	 * Representa el impuesto asociado al tipo DROGUERIA.
	 */
	private static final Double DROGUERIA_IVA = .12;
	//------- A T R I B U T O S -------//
	/**
	 * Representa el nombre del producto.
	 */
	private String nombre;
	/**
	 * Representa la categoría de los productos .
	 */
	private Tipo tipo;
	/**
	 * Representa la cantidad que se tiene del producto.
	 */
	private int cantidadEnBodega;
	/**
	 * Representa las unidades mínima que debe haber en bodega para poder hacer un pedido.
	 */
	private int cantidadMinima;
	/**
	 * Representa el precio unitario del producto.
	 */
	private double precioUnitario;
	/**
	 * Representa la imagen que tiene cada producto.
	 */
	private String imagenProducto;
	/**
	 * Representa las cantidad de unidades vendidas del producto.
	 */
	private int cantidadUnidadesVendidas;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Creo un producto con los valores pasados por parametros<br>
	 * <b> post: </b> El tipo, nombre, precio unitario, cantidad en bodega, cantidad mínima y ruta imagen fueron inicializados con los valores dado por parámetro.
	 * @param pNombre Nombre del producto. pNombre != null && pNombre != "".
	 * @param pTipo Tipo del producto. pTipo!=null.
	 * @param pCantidadEnBodega Cantidad que hay en bodega. pCantidadEnBodega >=0.
	 * @param pCantidadMInima Cantidad mínima que debe haber en bodega. pCantidadMInima >=0.
	 * @param pPrecioUnitario Precio unitario del producto. pPrecioUnitario >=0.
	 * @param pImagenProducto Imagen del producto. pImagenProducto!=null && pImagenProducto=="".
	 */
	public Producto(String pNombre, Tipo pTipo, int pCantidadEnBodega, int pCantidadMInima, double pPrecioUnitario, String pImagenProducto )
	{
		nombre			 													= pNombre;
		tipo 																= pTipo;
		cantidadEnBodega 													= pCantidadEnBodega;
		cantidadMinima 														= pCantidadMInima;
		precioUnitario 														= pPrecioUnitario;
		imagenProducto 														= pImagenProducto;
		cantidadUnidadesVendidas                                            = 0;
		
	}
	//--------- M É T O D O S ----------//
	/**
	 * Retorna el nombre del producto.<br>
	 * @return Nombre del poducto.
	 */
	public String getNombre() 
	{
		return nombre;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el tipo de producto.<br>
	 * @return Tipo de producto.
	 */
	public Tipo getTipo() 
	{
		return tipo;
	}
	//---------------------------------------------------//
	/**
	 * Retorna la cantidade que hay en bodega.<br>
	 * @return cantidad en bodega.
	 */
	public int getCantidadEnBodega() 
	{
		return cantidadEnBodega;
	}
	//---------------------------------------------------//
	/**
	 * Retorna la cantidad mínima que debe haber en bodega.<br>
	 * @return cantidad mínima.
	 */
	public int getCantidadMinima()
	{
		return cantidadMinima;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el precio unitario del producto.<br>
	 * @return precio unitario dle producto.
	 */
	public double getPrecioUnitario()
	{
		return precioUnitario;
	}
	//---------------------------------------------------//
	/**
	 * Retorna la ruta de imagen del producto.<br>
	 * @return ruta de imagen del producto.
	 */
	public String getImagenProducto()
	{
		return imagenProducto;
	}
	//---------------------------------------------------//
	/**
	 * Retorna la cantidad de unidades vendidas.<br>
	 * @return cantidad de unidades vendidas.
	 */
	public int getCantidadUnidadesVendidas() 
	{
		return cantidadUnidadesVendidas;
	}
	
	//---------------------------------------------------//
	/**
	 * Vende la cantidad pasada por parámetros.<br>
	 * <b>post: </b> Disminuye la cantidad de unidades en bodega del producto.
	 * @param pCantidad Cantidad de producto a vender. pCantidad >0. 
	 * @return Cantidad que realmente fue vendida, según la disponibilidad en la bodega.
	 */
	public int vender(int pCantidad)
	{
		int cantidadVendidas=0;
		if(pCantidad > cantidadEnBodega)
		{
			cantidadVendidas = cantidadEnBodega;
			cantidadEnBodega = 0;
		} 
		else
		{
			cantidadEnBodega-=pCantidad;
			cantidadVendidas =pCantidad;
		}
		cantidadUnidadesVendidas+=cantidadVendidas;
		return cantidadVendidas;
	}
	//---------------------------------------------------//
	/**
	 * Abastece la cantidad de unidades dada por parámetro. <br>
	 * <b>post: </b> Aumenta la cantidad de unidades en bodega del producto.
	 * @param pCantidad La cantidad que se agrega a la bodega. pCantidad>0.
	 */
	public void abastecer(int pCantidad)
	{
		cantidadEnBodega += pCantidad;
		
	}
	//---------------------------------------------------//
    /**
     * Indica si se puede abastecer las unidades del producto.
     * @return True si la cantidad en la bodega es menor que la mínima, false en caso contrario.
     */
	public boolean puedeAbastecer()
	{
		boolean respuesta = false;
		if(cantidadEnBodega<cantidadMinima)
		{
			respuesta = true;
		}
		return respuesta;
	}
	//---------------------------------------------------//
    /**
     * Calcula el valor final del producto, incluyendo los impuestos.
     * @return Precio de venta de una unidad incluyendo el IVA.
     */
	public double calcularPrecioFinal() 
	{
		
	
		return precioUnitario + precioUnitario * darIVA();
	}
	//---------------------------------------------------//
    /**
     * Retorna el IVA correspondiente al producto.
     * @return IVA.
     */
	private double darIVA() {
		double iva = 0;
		switch (tipo) {
		case PAPELERIA:
			iva += PAPELERIA_IVA;
			break;

		case SUPERMERCADO:
			iva += SUPERMERCADO_IVA;
			break;

		case DROGUERIA:
			iva += DROGUERIA_IVA;
			break;
		}

		return iva;
	}
}
