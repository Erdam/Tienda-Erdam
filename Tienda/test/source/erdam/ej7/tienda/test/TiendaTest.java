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
 * Clase usada para verificar que los m�todos de la clase Tienda est�n correctamente implementados.
 */
public class TiendaTest {
	
	//------- A T R I B U T O S -------//
    /**
     * Clase donde se har�n las pruebas.
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
	//--------- M � T O D O S  D E  P R U E B A ----------//
	/**
     * Prueba 1: Verifica el m�todo constructor.<br>
     * <b> M�todos a probar: </b> <br>
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
    	assertNotNull( "Deber�a existir el producto 1.", tienda.getProducto1( ) );
    	assertEquals("El nomber del producto deber�a ser " ,"L�piz", tienda.getProducto1().getNombre());
    	assertNotNull(" Deber�a existir el producto 2", tienda.getProducto2( ) );
    	assertEquals("El nomber del producto deber�a ser " ,"Aspirina", tienda.getProducto2().getNombre());
    	assertNotNull( "Deber�a existir el producto 3.", tienda.getProducto3( ) );
    	assertEquals("El nomber del producto deber�a ser " ,"Goma", tienda.getProducto3().getNombre());
    	assertNotNull(" Deber�a existir el producto 4", tienda.getProducto4( ) );
    	assertEquals("El nomber del producto deber�a ser " ,"Pan", tienda.getProducto4().getNombre());
    	assertEquals( "No deber�a haber dinero en caja.", 0.0, tienda.getDineroEnCaja(), 0.0 );

    }
    /**
     * Prueba 2: Verifica el m�todo venderProducto.<br>
     * <b> M�todos a probar: </b> <br>
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
    	assertEquals("La cantidad vendida es de 10 unidades", 10, tienda.venderProducto("L�piz", 10));
    	//( 10*50)*.16 =50
    	//80+70.8= 150,8
    	assertEquals("La plata que hay en caja es de $150.8", 150.8, tienda.getDineroEnCaja(), 0.0 );
	
    }
    /**
     * Prueba 3: Verifica el m�todo abastecerProducto.<br>
     * <b> M�todos a probar: </b> <br>
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
        assertFalse( "No deber�a poder abastecer.", tienda.abastecerProducto( "L�piz", 10 ) );
        tienda.venderProducto( "L�piz", 15 );
        System.out.println( "La cantidad en bodega es : " + tienda.getProducto1().getCantidadEnBodega() );
        assertTrue( "Deber�a poder abastecer.", tienda.abastecerProducto( "L�piz", 20 ) );
        System.out.println( "La cantidad en bodega es : " + tienda.getProducto1().getCantidadEnBodega() );

    }
    /**
     * Prueba 4: Verifica el m�todo darProductoMasVendido.<br>
     * <b> M�todos a probar: </b> <br>
     * getProductoMasVendido<br>
     * venderProducto<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ning�n producto tiene ventas.<br>
     * 2. Todos los productos tienen ventas.
     */
    @Test
    public void testGetProductoMasVendido()
    {
     	setupEscenario();
     	assertEquals("La cantidad vendida es de 5 unidades", 5, tienda.venderProducto("Aspirina", 5));
    	assertEquals("La cantidad vendida es de 10 unidades", 10, tienda.venderProducto("L�piz", 10));
    	assertEquals("La cantidad vendida es de 12 unidades", 12, tienda.venderProducto("Goma",12));
    	assertEquals("La cantidad vendida es de 1 unidades", 1, tienda.venderProducto("Pan", 1));
    	System.out.println( "el producto m�s vendido es : " + tienda.darProductoMasVendido().getNombre() );
    	assertEquals("El producto m�s vendido deber�a ser Goma", "Goma", tienda.darProductoMasVendido().getNombre() );
     	
    }
    /**
     * Prueba 5: Verifica el m�todo getProductoMenosVendido.<br>
     * <b> M�todos a probar: </b> <br>
     * getProductoMenosVendido<br>
     * vender<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ning�n producto tiene ventas.<br>
     * 2. Todos los productos tienen ventas.
     */
    @Test
    public void testGetProductoMenosVendido()
    {
    	setupEscenario();
     	assertEquals("La cantidad vendida es de 5 unidades", 5, tienda.venderProducto("Aspirina", 5));
    	assertEquals("La cantidad vendida es de 10 unidades", 10, tienda.venderProducto("L�piz", 10));
    	assertEquals("La cantidad vendida es de 12 unidades", 12, tienda.venderProducto("Goma",12));
    	assertEquals("La cantidad vendida es de 1 unidades", 1, tienda.venderProducto("Pan", 1));
    	System.out.println( "el producto menos vendido es : " + tienda.darProductoMenosVendido().getNombre() );
    	assertEquals("El producto m�s vendido deber�a ser Goma", "Pan", tienda.darProductoMenosVendido().getNombre() );
    }
    /**
     * Prueba 6: Verifica el m�todo getPromedioVentas.<br>
     * <b> M�todos a probar: </b> <br>
     * getPromedioVentas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ning�n producto tiene ventas.<br>
     * 2. Todos los productos tienen ventas.
     */
    @Test
    public void testGetPromedioDeVentas()
    {
    	 setupEscenario( );
         assertNull( "No deber�a haber ning�n producto con ventas.", tienda.darProductoMasVendido( ) );
         tienda.venderProducto( "L�piz", 5 );
         tienda.venderProducto( "Pan", 6 );
         tienda.venderProducto( "Aspirina", 15 );
         tienda.venderProducto( "Goma", 10 );
         System.out.println( "el dinero en caja es : " + tienda.getDineroEnCaja());
         assertNotNull( "Deber�a existir al menos un producto con ventas.", tienda.darProductoMasVendido( ) );
         assertEquals("La cantidad vendida es de 5 unidades", tienda.getDineroEnCaja()/ 36, tienda.darPromedioVentas(),0.1);
         assertEquals( "El nombre del producto m�s vendido no corresponde.", "Aspirina", tienda.darProductoMasVendido( ).getNombre( ) );

    }
    /**
     * Prueba 7: Verifica el m�todo cambiarProducto.<br>
     * <b> M�todos a probar: </b> <br>
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

        boolean cambio = tienda.cambiarProducto( "L�piz", "L�piz", Tipo.PAPELERIA, 11, 8, 2000, "lapiz.jpg" );
        assertTrue( "Deber�a haber cambiado el producto.", cambio );
        Producto p = tienda.buscarProducto( "L�piz" );
        System.out.println(tienda.getProducto1().getNombre());
        assertNotNull( "El producto deber�a existir", p );
        assertEquals( "El valor unitario no es el esperado.", 2000, p.getPrecioUnitario(), 0.01 );
        assertEquals( "La cantidad en bodega no es la esperada", 11, p.getCantidadEnBodega() );
        assertEquals( "La cantidad m�nima no es la esperada", 8, p.getCantidadMinima() );
      
    }

  }
    

