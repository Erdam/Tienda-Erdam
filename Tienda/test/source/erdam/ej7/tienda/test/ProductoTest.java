package erdam.ej7.tienda.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jfree.util.PublicCloneable;
import org.junit.jupiter.api.Test;

import erdam.ej7.tienda.mundo.Producto;
import erdam.ej7.tienda.mundo.Tipo;
import junit.framework.TestCase;

public class  ProductoTest{
	
	//------- A T R I B U T O S -------//
	private Producto producto;

	//--------- E S C E N A R I O S ----------//
    /**
     * Escenario 1: Crea un nuevo producto sin unidades vendidas.
     */
	private void setupEscenario()
	{
		producto = new Producto("ASPIRINA 20 COMPRIMIDOS", Tipo.DROGUERIA, 100, 15, 129, "aspirina.jpg");
	}
	
	//--------- M É T O D O S  D E  P R U E B A ----------//
	/**
     * Prueba 1: Verifica el método constructor.<br>
     * <b> Métodos a probar: </b> <br>
     * Producto<br>
     * getTipo<br>
     * getNombre<br>
     * getPrecioUnitario<br>
     * getCantidadEnBodega()<br>
     * getCantidadMinima()<br>
     * getCantidadUnidadesVendidas<br>
     * getImagenProducto<br>
     * calcularPrecioFinal<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los valores de los atributos corresponden.
     */
	@Test
	public void testProducto()
	{
		 setupEscenario();
		 System.out.println( "Precio con iva: " + producto.calcularPrecioFinal( ) );
		 assertEquals( "El nombre no corresponde.", "ASPIRINA 20 COMPRIMIDOS", producto.getNombre() );
	     assertTrue( "El tipo no corresponde.", Tipo.DROGUERIA == producto.getTipo( ) );
	     assertEquals( "El valor unitario no corresponde.", 129, producto.getPrecioUnitario(), 0.01 );
	     assertEquals( "La cantidad mínima no corresponde.", 15, producto.getCantidadMinima());
	     assertEquals( "La cantidad en bodega no corresponde.", 100, producto.getCantidadEnBodega() );
	     assertEquals( "La ruta de la imagen no corresponde.", "aspirina.jpg", producto.getImagenProducto() );
	     assertEquals( "La cantidad de vendidas no corresponde.", 0, producto.getCantidadUnidadesVendidas() );
	     assertEquals( "El precio final no corresponde.", (producto.getPrecioUnitario()*.12), producto.calcularPrecioFinal( ), 0.01 );
	}
	 /**
     * Prueba 2: Verifica el método vender.<br>
     * <b> Métodos a probar: </b> <br>
     * vender<br>
     * getCantidadEnBodeg<br>
     * getCantidadUnidadesVendidas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Logra vender todas las unidades. <br>
     * 2. No logra vender todas las unidades.
     */


	@Test
	public void testVender()
	{
		setupEscenario();
        assertEquals( "Debería realizar la venta de 40.", 40, producto.vender( 40 ) );
		assertEquals("La cantidad que tiene que quedar en bodega es 60", 60, producto.getCantidadEnBodega());
		assertEquals("La cantidad vendida es 40", 40, producto.getCantidadUnidadesVendidas());
		assertEquals( "Debería realizar la venta de 60.", 60, producto.vender( 60 ) );
		assertEquals("La cantidad que tiene que quedar en bodega es 0", 0, producto.getCantidadEnBodega());
		assertEquals("La cantidad vendida es 100", 100, producto.getCantidadUnidadesVendidas());
		 
	}
	/**
     * Prueba 3: Verifica el método abastecer.<br>
     * <b> Métodos a probar: </b> <br>
     * getCantidadEnBodeg<br>
     * abastecer<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Logra abastecer las unidades.
     */

	@Test
	public void testAbastecer()
	{
		setupEscenario();
		producto.abastecer(52);
		assertEquals("La cantidad que tiene eb bodega es 152", 152, producto.getCantidadEnBodega());
		
	}
}
