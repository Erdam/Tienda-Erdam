package erdam.ej7.tienda.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.Console;

import org.junit.jupiter.api.Test;

import erdam.ej7.tienda.mundo.Producto;
import erdam.ej7.tienda.mundo.Tienda;
import erdam.ej7.tienda.mundo.Tipo;
import junit.framework.TestCase;
/**
 * Clase usada para verificar que los métodos de la clase Tienda estén correctamente implementados.
 */
public class TiendaTest {
	
	//------- A T R I B U T O S -------//
    /**
     * Clase donde se harán las pruebas.
     */
	private Tienda tienda;
	//--------- E S C E N A R I O S ----------//
    /**
     * Crea una tienda con cuatro producto, dos de ellos de DROGUERIA, uno de PAPELERIA y uno de SUPERMERCADO.
     */
	private void setupEscenario()
	{
		tienda = new Tienda();
	}
	//--------- M É T O D O S  D E  P R U E B A ----------//
	/**
     * Prueba 1: Verifica el método constructor.<br>
     * <b> Métodos a probar: </b> <br>
     * Tienda<br>
     * getProducto1<br>
     * getProducto2<br>
     * getProducto3<br>
     * getProducto4<br>
     * getNombre<br>
     * getDineroEnCaja<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los valores de los atributos corresponden.
     */
    @Test
    public void testTienda( )
    {
    	setupEscenario();
    	assertNotNull( "Debería existir el producto 1.", tienda.getProducto1( ) );
    	assertEquals("El nomber del producto debería ser " ,"Lápiz", tienda.getProducto1().getNombre());
    	assertNotNull(" Debería existir el producto 2", tienda.getProducto2( ) );
    	assertEquals("El nomber del producto debería ser " ,"Aspirina", tienda.getProducto2().getNombre());
    	assertNotNull( "Debería existir el producto 3.", tienda.getProducto3( ) );
    	assertEquals("El nomber del producto debería ser " ,"Goma", tienda.getProducto3().getNombre());
    	assertNotNull(" Debería existir el producto 4", tienda.getProducto4( ) );
    	assertEquals("El nomber del producto debería ser " ,"Pan", tienda.getProducto4().getNombre());
    	assertEquals( "No debería haber dinero en caja.", 0.0, tienda.getDineroEnCaja(), 0.0 );

    }
    /**
     * Prueba 2: Verifica el método venderProducto.<br>
     * <b> Métodos a probar: </b> <br>
     * venderProducto<br>
     * getDineroEnCaja<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se venden todas las unidades.<br>
     * 2. Se venden menos unidades porque no hay suficiente en bodega.
     */
    @Test
    public void testVenderProducto()
    {
    	setupEscenario();
    	assertEquals("La cantidad vendida es de 5 unidades", 5, tienda.venderProducto("Aspirina", 5));
    	//( 5*118)*.12 =70.8
    	assertEquals("La plata que hay en caja es de $70.8", 70.8, tienda.getDineroEnCaja(), 0.0 );
    	assertEquals("La cantidad vendida es de 10 unidades", 10, tienda.venderProducto("Lápiz", 10));
    	//( 10*50)*.16 =50
    	//80+70.8= 150,8
    	assertEquals("La plata que hay en caja es de $150.8", 150.8, tienda.getDineroEnCaja(), 0.0 );
	
    }
    /**
     * Prueba 3: Verifica el método abastecerProducto.<br>
     * <b> Métodos a probar: </b> <br>
     * abastecer<br>
     * vender<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se puede abastecer.<br>
     * 2. No se puede abastecer.
     */
    @Test
    public void testAbastecerProducto()
    {
     	setupEscenario();
     	System.out.println( "La cantidad en bodega es : " + tienda.getProducto1().getCantidadEnBodega() );
        assertFalse( "No debería poder abastecer.", tienda.abastecerProducto( "Lápiz", 10 ) );
        tienda.venderProducto( "Lápiz", 15 );
        System.out.println( "La cantidad en bodega es : " + tienda.getProducto1().getCantidadEnBodega() );
        assertTrue( "Debería poder abastecer.", tienda.abastecerProducto( "Lápiz", 20 ) );
        System.out.println( "La cantidad en bodega es : " + tienda.getProducto1().getCantidadEnBodega() );

    }
    /**
     * Prueba 4: Verifica el método darProductoMasVendido.<br>
     * <b> Métodos a probar: </b> <br>
     * getProductoMasVendido<br>
     * venderProducto<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ningún producto tiene ventas.<br>
     * 2. Todos los productos tienen ventas.
     */
    @Test
    public void testGetProductoMasVendido()
    {
     	setupEscenario();
     	assertEquals("La cantidad vendida es de 5 unidades", 5, tienda.venderProducto("Aspirina", 5));
    	assertEquals("La cantidad vendida es de 10 unidades", 10, tienda.venderProducto("Lápiz", 10));
    	assertEquals("La cantidad vendida es de 12 unidades", 12, tienda.venderProducto("Goma",12));
    	assertEquals("La cantidad vendida es de 1 unidades", 1, tienda.venderProducto("Pan", 1));
    	System.out.println( "el producto más vendido es : " + tienda.darProductoMasVendido().getNombre() );
    	assertEquals("El producto más vendido debería ser Goma", "Goma", tienda.darProductoMasVendido().getNombre() );
     	
    }
    /**
     * Prueba 5: Verifica el método getProductoMenosVendido.<br>
     * <b> Métodos a probar: </b> <br>
     * getProductoMenosVendido<br>
     * vender<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ningún producto tiene ventas.<br>
     * 2. Todos los productos tienen ventas.
     */
    @Test
    public void testGetProductoMenosVendido()
    {
    	setupEscenario();
     	assertEquals("La cantidad vendida es de 5 unidades", 5, tienda.venderProducto("Aspirina", 5));
    	assertEquals("La cantidad vendida es de 10 unidades", 10, tienda.venderProducto("Lápiz", 10));
    	assertEquals("La cantidad vendida es de 12 unidades", 12, tienda.venderProducto("Goma",12));
    	assertEquals("La cantidad vendida es de 1 unidades", 1, tienda.venderProducto("Pan", 1));
    	System.out.println( "el producto menos vendido es : " + tienda.darProductoMenosVendido().getNombre() );
    	assertEquals("El producto más vendido debería ser Goma", "Pan", tienda.darProductoMenosVendido().getNombre() );
    }
    /**
     * Prueba 6: Verifica el método getPromedioVentas.<br>
     * <b> Métodos a probar: </b> <br>
     * getPromedioVentas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ningún producto tiene ventas.<br>
     * 2. Todos los productos tienen ventas.
     */
    @Test
    public void testGetPromedioDeVentas()
    {
    	 setupEscenario( );
         assertNull( "No debería haber ningún producto con ventas.", tienda.darProductoMasVendido( ) );
         tienda.venderProducto( "Lápiz", 5 );
         tienda.venderProducto( "Pan", 6 );
         tienda.venderProducto( "Aspirina", 15 );
         tienda.venderProducto( "Goma", 10 );
         System.out.println( "el dinero en caja es : " + tienda.getDineroEnCaja());
         assertNotNull( "Debería existir al menos un producto con ventas.", tienda.darProductoMasVendido( ) );
         assertEquals("La cantidad vendida es de 5 unidades", tienda.getDineroEnCaja()/ 36, tienda.darPromedioVentas(),0.1);
         assertEquals( "El nombre del producto más vendido no corresponde.", "Aspirina", tienda.darProductoMasVendido( ).getNombre( ) );

    }
    /**
     * Prueba 7: Verifica el método cambiarProducto.<br>
     * <b> Métodos a probar: </b> <br>
     * cambiarProducto<br>
     * getProducto<br>
     * <b> Casos de prueba: </b> <br>
     * 1. No se cambia el nombre del producto.<br>
     * 2. Se cambia el nombre del producto y no existe un producto con ese nombre.<br>
     * 3. Existe otro producto con el mismo nombre.<br>
     */
    @Test
    public void testCambiaarProducto()
    {
     	setupEscenario( );

        boolean cambio = tienda.cambiarProducto( "Lápiz", "Lápiz", Tipo.PAPELERIA, 11, 8, 2000, "lapiz.jpg" );
        assertTrue( "Debería haber cambiado el producto.", cambio );
        Producto p = tienda.buscarProducto( "Lápiz" );
        System.out.println(tienda.getProducto1().getNombre());
        assertNotNull( "El producto debería existir", p );
        assertEquals( "El valor unitario no es el esperado.", 2000, p.getPrecioUnitario(), 0.01 );
        assertEquals( "La cantidad en bodega no es la esperada", 11, p.getCantidadEnBodega() );
        assertEquals( "La cantidad mínima no es la esperada", 8, p.getCantidadMinima() );
      
    }

  }
    

