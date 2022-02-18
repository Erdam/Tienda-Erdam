package erdam.ej7.tienda.mundo;
/**
 * Tienda que maneja 4 productos.
 */
public class Tienda {
	//------- A T R I B U T O S -------//
	/**
	 * Producto 1 de la tienda. 
	 */
	private Producto producto1;
	/**
	 * Producto 2 de la tienda. 
	 */
	private Producto producto2;
	/**
	 * Producto 3 de la tienda. 
	 */
	private Producto producto3;
	/**
	 * Producto 4 de la tienda. 
	 */
	private Producto producto4;
	/**
	 * Dinero total recibido por las ventas.
	 */
	private double dineroEnCaja;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Inicializa la tienda con sus 4 productos. <br>
	 * <b>post:</b> el dinero en caja fue inicializado en 0.<br>
	 * Los 4 productos fueron inicializados con los siguientes valores.<br>
	 * Producto 1 - Nombre: lápiz, Tipo: PAPELERIA, Cantidad en bodega: 500, Cantidad mínima: 18, Precio unitario: $50, Ruta de Imagen: lapiz.png.<br>
	 * Producto 2 - Nombre: Aspirina, Tipo: DROGERIA, Cantidad en bodega: 109, Cantidad mínima: 25, Precio unitario: $118, Ruta de Imagen: aspirina.png.<br>
	 * Producto 3 - Nombre: borrador, Tipo: PAPELERIA, Cantidad en bodega: 207, Cantidad mínima: 5, Precio unitario: $69, Ruta de Imagen: borrador.png.<br>
	 * Producto 4 - Pan: lápiz, Tipo: SUPERMERCADO, Cantidad en bodega: 150, Cantidad mínima: 15, Precio unitario: $70, Ruta de Imagen: pan.png. 
	 */
	public Tienda() {
		producto1 				= new Producto("Lápiz", Tipo.PAPELERIA,
												18 , 5, 50, "lapiz.png");
		producto2 				= new Producto("Aspirina", Tipo.DROGUERIA, 
												109 , 25, 118, "aspirina.png");
		producto3 				= new Producto("Goma", Tipo.PAPELERIA,
												207 , 5, 69, "borrador.png");
		producto4				= new Producto("Pan", Tipo.SUPERMERCADO, 
												150, 15, 70, "pan.png");
		dineroEnCaja 			= 0;
	}
	//--------- M É T O D O S ----------//
	/**
	 * Retorna el producto 1.
	 * @return producto 1 de la tienda.
	 */
	public Producto getProducto1() {
		return producto1;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el producto 2.
	 * @return producto 2 de la tienda.
	 */
	public Producto getProducto2() {
		return producto2;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el producto 3.
	 * @return producto 3 de la tienda.
	 */
	public Producto getProducto3() {
		return producto3;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el producto 4.
	 * @return producto 4 de la tienda.
	 */
	public Producto getProducto4() {
		return producto4;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el dinero en caja.
	 * @return Dinero en caja.
	 */
	public double getDineroEnCaja() {
		return dineroEnCaja;
	}
	
	//---------------------------------------------------//

	/**
	 * Retorna el producto con el nombre dado por parámetro.
	 * @param pNombre Nombre del producto buscado. pNombre !=null && pNombre !="".
	 * @return Producto con el nombre dado por parámetro, null si no lo encuentra.
	 */
	public Producto buscarProducto(String pNombre)
	{
		Producto buscado = null;
		
		if(producto1.getNombre().equals(pNombre))
		{
			buscado = producto1;
		}
		else if(producto2.getNombre().equals(pNombre))
		{
			buscado = producto2;
		}
		else if(producto3.getNombre().equals(pNombre))
		{
			buscado = producto3;
		}
		else if(producto4.getNombre().equals(pNombre))
		{
			buscado = producto4;
		}

		return buscado;
	}
	//---------------------------------------------------//
    /**
     * Retorna el promedio de las ventas.
     * @return Dinero promedio obtenido por unidad de producto vendida.
     */
	public double darPromedioVentas() {
		double promedio =0;
		int totalVendidas = 
				producto1.getCantidadUnidadesVendidas()+
				producto2.getCantidadUnidadesVendidas()+ 
				producto3.getCantidadUnidadesVendidas()+ 
				producto4.getCantidadUnidadesVendidas();
		if(totalVendidas>0)
		{
			promedio = dineroEnCaja /totalVendidas;
		}
		return promedio;
	}
	//---------------------------------------------------//
    /**
     * Retorna el producto con más unidades vendidas.
     * @return Producto con más unidades vendidas. Null si ningún producto tiene unidades vendidas.
     */
	public  Producto darProductoMasVendido()
	{
	    {
	        int venta1 = producto1.getCantidadUnidadesVendidas();
	        int venta2 = producto2.getCantidadUnidadesVendidas();
	        int venta3 = producto3.getCantidadUnidadesVendidas();
	        int venta4 = producto4.getCantidadUnidadesVendidas();

	        Producto masVendido = null;
	        int mayorCantidad = 0;

	        if( venta1 > mayorCantidad )
	        {
	            masVendido = producto1;
	            mayorCantidad = venta1;
	        }
	        if( venta2 > mayorCantidad )
	        {
	            masVendido = producto2;
	            mayorCantidad = venta2;
	        }
	        if( venta3 > mayorCantidad )
	        {
	            masVendido = producto3;
	            mayorCantidad = venta3;
	        }
	        if( venta4 > mayorCantidad )
	        {
	            masVendido = producto4;
	        }

	        return masVendido;
	    }
	}
	//---------------------------------------------------//
    /**
     * Retorna el producto con menos unidades vendidas.
     * @return Producto con menos unidades vendidas. Null si ningún producto tiene unidades vendidas.
     */
	public  Producto darProductoMenosVendido()
    {
		 int venta1 = producto1.getCantidadUnidadesVendidas();
	     int venta2 = producto2.getCantidadUnidadesVendidas();
	     int venta3 = producto3.getCantidadUnidadesVendidas();
	     int venta4 = producto4.getCantidadUnidadesVendidas();

	        Producto menosVendido = null;

	        if( venta1 > 0 || venta2 > 0 || venta3 > 0 || venta4 > 0 )
	        {
	            if( venta1 <= venta2 && venta1 <= venta3 && venta1 <= venta4 )
	            {
	                menosVendido = producto1;
	            }
	            else if( venta2 <= venta1 && venta2 <= venta3 && venta2 <= venta4 )
	            {
	                menosVendido = producto2;
	            }
	            else if( venta3 <= venta2 && venta3 <= venta1 && venta3 <= venta4 )
	            {
	                menosVendido = producto3;
	            }
	            else
	            {
	                menosVendido = producto4;
	            }
	        }

	        return menosVendido;

    }
	//---------------------------------------------------//
	/**
	 * Vende una cantidad de unidades de producto de la tienda, dado su nombre por parámetro. <br>
	 * <b>post: </b> Disminuyó la cantidad de unidades del producto dado y se actualizó el dinero de la caja.
	 * @param pNombreProducto Nombre del producto a vender. pNombreProduct != null && pNombreProduct != "".
	 * @param pCantidad Cantidad de unidades del producto a vender. pCantidad > 0.
	 * @return Cantidad que fue efectivamente vendida.
	 */
	public int venderProducto(String pNombreProducto, int pCantidad )
	{
		int cantidadVendida=0;
		Producto producto = buscarProducto(pNombreProducto);
		cantidadVendida=  producto.vender(pCantidad);
		dineroEnCaja += cantidadVendida * producto.calcularPrecioFinal();
		
		return cantidadVendida;
	}
	//---------------------------------------------------//
    /**
     * Abastece un producto dado su nombre, con la cantidad de unidades dadas. <br>
     * <b>post: </b> Aumentó la cantidad de unidades en bodega del producto dado.
     * @param pNombreProducto Nombre del producto a abastecer. pNombreProducto != null && pNombreProducto != "".
     * @param pCantidad La cantidad de unidades a abastecer. cantidad >= 0.
     * @return Retorna true si se pudo efectuar el abastecimiento, false en caso contrario.
     */
    public boolean abastecerProducto(String pNombreProducto, int pCantidad)
    {
        boolean abastece = false;
        Producto producto = buscarProducto(pNombreProducto);

        if( producto.puedeAbastecer( ))
        {
            producto.abastecer( pCantidad );
            abastece = true;
        }

        return abastece;
    }
  //---------------------------------------------------//
	/**
	 * Cambia el producto que tiene el nombre actual con los nuevos valores dados por parámetro. <br>
     * <b>post: </b> El nombre, tipo, valor unitario, cantidad en bodega y cantidad mínima fueron cambiados con los valores dados por parámetro.
	 * @param pNombreActual Nombre actual del producto. pNombreActual! = null.
	 * @param pNombreNuevo Nombre nuevo del producto. pNombreNuevo != null.
	 * @param pTipo Tipo del producto.  pTipo != null.
	 * @param pCantidadEnBodega Cantidad en bodega del producto. pCantidadEnBodega > 0.
	 * @param pCantidadMInima Cantidad mínima en bodega para hacer un pedido del producto. pCantidadMInima > 0.
	 * @param pPrecioUnitario Precio unitario del producto.  pPrecioUnitario > 0.
	 * @param pImagenProducto Ruta de la imagen del producto. pImagenProducto != null && pImagenProducto!=""
	 * @return Retorna true si cambió la información del producto, false si ya existía un producto diferente con el nuevo nombre.
	 */

    public boolean cambiarProducto( String pNombreActual, String pNombreNuevo,  Tipo pTipo, int pCantidadEnBodega, int pCantidadMInima, double pPrecioUnitario, String pImagenProducto )
    {
        boolean cambio = false;
        if( pNombreActual.equals( pNombreNuevo ) || buscarProducto( pNombreNuevo ) == null )
        {

            if( producto1.getNombre( ).equals( pNombreActual ) )
            {
                producto1 = new Producto(pNombreNuevo,pTipo, pCantidadEnBodega, pCantidadMInima, pPrecioUnitario, pImagenProducto);
            }
            else if( producto2.getNombre( ).equals( pNombreActual ) )
            {
                producto2 =  new Producto(pNombreNuevo,pTipo, pCantidadEnBodega, pCantidadMInima, pPrecioUnitario, pImagenProducto);
            }
            else if( producto3.getNombre( ).equals( pNombreActual ) )
            {
                producto3 =  new Producto(pNombreNuevo,pTipo, pCantidadEnBodega, pCantidadMInima, pPrecioUnitario, pImagenProducto);
            }
            else if( producto4.getNombre( ).equals( pNombreActual ) )
            {
                producto4 =  new Producto(pNombreNuevo,pTipo, pCantidadEnBodega, pCantidadMInima, pPrecioUnitario, pImagenProducto);
            }
            cambio = true;
        }
        return cambio;
    }
	
}
