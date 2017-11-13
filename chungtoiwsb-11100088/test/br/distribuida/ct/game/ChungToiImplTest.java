/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.distribuida.ct.game;

import java.rmi.RemoteException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joao
 */
public class ChungToiImplTest {
    ChungToiImpl instance;
    public ChungToiImplTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of preRegistro method, of class ChungToiImpl.
     */
    @Test
    public void testPreRegistro() throws Exception {
        System.out.println("preRegistro");
        int id1 = 1;
        String nome1 = "jogador1";
        int id2 = 2;
        String nome2 = "jogador2";
        instance = new ChungToiImpl();
        int expResult = 0;
        int result = instance.preRegistro(id1, nome1, id2, nome2);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of registraJogador method, of class ChungToiImpl.
    */ 
    @Test
    public void testRegistraJogador() throws Exception {
        System.out.println("registraJogador");
        String nome = "nomeTeste";
        instance = new ChungToiImpl();
        int result = instance.registraJogador(nome);
        assertTrue(result>0);
    }

    
    /**
     * Test of temPartida method, of class ChungToiImpl.
    */
    @Test
    public void testTemPartida() throws Exception {
        System.out.println("temPartida");
        int id = 0;
        ChungToiImpl instance = new ChungToiImpl();
        int expResult = 0;
        int result = instance.temPartida(id);
        assertTrue(result == 1 || result == 2);
    }

    /**
     * Test of ehMinhaVez method, of class ChungToiImpl.
     
    @Test
    public void testEhMinhaVez() throws Exception {
        System.out.println("ehMinhaVez");
        int id = 0;
        ChungToiImpl instance = new ChungToiImpl();
        int expResult = 0;
        int result = instance.ehMinhaVez(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of obtemOponente method, of class ChungToiImpl.
     
    @Test
    public void testObtemOponente() throws Exception {
        System.out.println("obtemOponente");
        int id = 0;
        ChungToiImpl instance = new ChungToiImpl();
        String expResult = "";
        String result = instance.obtemOponente(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of obtemTabuleiro method, of class ChungToiImpl.
     
    @Test
    public void testObtemTabuleiro() throws Exception {
        System.out.println("obtemTabuleiro");
        int id = 0;
        ChungToiImpl instance = new ChungToiImpl();
        String expResult = "";
        String result = instance.obtemTabuleiro(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of posicionaPeca method, of class ChungToiImpl.
     
    @Test
    public void testPosicionaPeca() throws Exception {
        System.out.println("posicionaPeca");
        int id = 0;
        int pos = 0;
        int orient = 0;
        ChungToiImpl instance = new ChungToiImpl();
        int expResult = 0;
        int result = instance.posicionaPeca(id, pos, orient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of movePeca method, of class ChungToiImpl.
     
    @Test
    public void testMovePeca() throws Exception {
        System.out.println("movePeca");
        int id = 0;
        int pos = 0;
        int sent = 0;
        int numCasas = 0;
        int orient = 0;
        ChungToiImpl instance = new ChungToiImpl();
        int expResult = 0;
        int result = instance.movePeca(id, pos, sent, numCasas, orient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of encerraPartida method, of class ChungToiImpl.
     
    @Test
    public void testEncerraPartida() throws Exception {
        System.out.println("encerraPartida");
        int id = 0;
        ChungToiImpl instance = new ChungToiImpl();
        int expResult = 0;
        int result = instance.encerraPartida(id);
        assertEquals(expResult, result);

    }
    */
}
