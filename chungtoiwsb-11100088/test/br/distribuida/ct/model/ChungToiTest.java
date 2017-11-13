/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.distribuida.ct.model;

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


public class ChungToiTest {
    
    public ChungToiTest() {
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
     * Test of verificaPlayer method, of class ChungToi.
     
    @Test
    public void testVerificaPlayer() {
        System.out.println("verificaPlayer");
        int id = 0;
        
        ChungToi instance = new ChungToi();
        int expResult = 0;
        int result = instance.verificaPlayer(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of inicializaMovimentos method, of class ChungToi.
     x
    
    @Test
    public void testInicializaMovimentos() {
        System.out.println("inicializaMovimentos");
        ChungToi instance = new ChungToi();
        instance.inicializaMovimentos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * /
    /**
     * Test of getMyPlayer method, of class ChungToi.
     
    @Test
    public void testGetMyPlayer() {
        System.out.println("getMyPlayer");
        int id = 0;
        ChungToi instance = new ChungToi();
        Player expResult = null;
        Player result = instance.getMyPlayer(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of retornaPecaLinear method, of class ChungToi.
     
    @Test
    public void testRetornaPecaLinear() {
        System.out.println("retornaPecaLinear");
        int id = 0;
        ChungToi instance = new ChungToi();
        String expResult = "";
        String result = instance.retornaPecaLinear(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of retornaPecaDiagonal method, of class ChungToi.
     
    @Test
    public void testRetornaPecaDiagonal() {
        System.out.println("retornaPecaDiagonal");
        int id = 0;
        ChungToi instance = new ChungToi();
        String expResult = "";
        String result = instance.retornaPecaDiagonal(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of defineNewPos method, of class ChungToi.
     
    @Test
    public void testDefineNewPos() {
        System.out.println("defineNewPos");
        int pos = 0;
        int sent = 0;
        int numCasas = 0;
        ChungToi instance = new ChungToi();
        int expResult = 0;
        int result = instance.defineNewPos(pos, sent, numCasas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of move method, of class ChungToi.
     
    @Test
    public void testMove() {
        System.out.println("move");
        int id = 0;
        int pos = 0;
        int sent = 0;
        int numCasas = 0;
        int orient = 0;
        ChungToi instance = new ChungToi();
        instance.move(id, pos, sent, numCasas, orient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of posiciona method, of class ChungToi.
     
    @Test
    public void testPosiciona() {
        System.out.println("posiciona");
        int pos = 0;
        int orient = 0;
        int player = 0;
        ChungToi instance = new ChungToi();
        instance.posiciona(pos, orient, player);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of minhaVez method, of class ChungToi.
     
    @Test
    public void testMinhaVez() {
        System.out.println("minhaVez");
        int id = 0;
        ChungToi instance = new ChungToi();
        boolean expResult = false;
        boolean result = instance.minhaVez(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of oponente method, of class ChungToi.
     
    @Test
    public void testOponente() {
        System.out.println("oponente");
        int id = 0;
        ChungToi instance = new ChungToi();
        String expResult = "";
        String result = instance.oponente(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of minhaPeca method, of class ChungToi.
     
    @Test
    public void testMinhaPeca() {
        System.out.println("minhaPeca");
        ChungToi instance = new ChungToi();
        instance.minhaPeca();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of validaPosicao method, of class ChungToi.
     
    @Test
    public void testValidaPosicao() {
        System.out.println("validaPosicao");
        int pos = 0;
        int orient = 0;
        ChungToi instance = new ChungToi();
        boolean expResult = false;
        boolean result = instance.validaPosicao(pos, orient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of validaMovimento method, of class ChungToi.
     
    @Test
    public void testValidaMovimento() {
        System.out.println("validaMovimento");
        int id = 0;
        int pos = 0;
        int sent = 0;
        int numCasas = 0;
        int orient = 0;
        ChungToi instance = new ChungToi();
        boolean expResult = false;
        boolean result = instance.validaMovimento(id, pos, sent, numCasas, orient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of trocaTurno method, of class ChungToi.
     
    @Test
    public void testTrocaTurno() {
        System.out.println("trocaTurno");
        ChungToi instance = new ChungToi();
        instance.trocaTurno();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of vencedor method, of class ChungToi.
     
    @Test
    public void testVencedor() {
        System.out.println("vencedor");
        ChungToi instance = new ChungToi();
        instance.vencedor();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of getNumJogadores method, of class ChungToi.
     
    @Test
    public void testGetNumJogadores() {
        System.out.println("getNumJogadores");
        ChungToi instance = new ChungToi();
        int expResult = 0;
        int result = instance.getNumJogadores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of setNumJogadores method, of class ChungToi.
     
    @Test
    public void testSetNumJogadores() {
        System.out.println("setNumJogadores");
        int num = 0;
        ChungToi instance = new ChungToi();
        instance.setNumJogadores(num);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of getP1 method, of class ChungToi.
     
    @Test
    public void testGetP1() {
        System.out.println("getP1");
        ChungToi instance = new ChungToi();
        Player expResult = null;
        Player result = instance.getP1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of setP1 method, of class ChungToi.
     
    @Test
    public void testSetP1() {
        System.out.println("setP1");
        Player p1 = null;
        ChungToi instance = new ChungToi();
        instance.setP1(p1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of getP2 method, of class ChungToi.
     
    @Test
    public void testGetP2() {
        System.out.println("getP2");
        ChungToi instance = new ChungToi();
        Player expResult = null;
        Player result = instance.getP2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of setP2 method, of class ChungToi.
     
    @Test
    public void testSetP2() {
        System.out.println("setP2");
        Player p2 = null;
        ChungToi instance = new ChungToi();
        instance.setP2(p2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of getBoard method, of class ChungToi.
     
    @Test
    public void testGetBoard() {
        System.out.println("getBoard");
        ChungToi instance = new ChungToi();
        String[] expResult = null;
        String[] result = instance.getBoard();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of printaTabuleiro method, of class ChungToi.
     
    @Test
    public void testPrintaTabuleiro() {
        System.out.println("printaTabuleiro");
        ChungToi instance = new ChungToi();
        String expResult = "";
        String result = instance.printaTabuleiro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of getTurno method, of class ChungToi.
     
    @Test
    public void testGetTurno() {
        System.out.println("getTurno");
        ChungToi instance = new ChungToi();
        int expResult = 0;
        int result = instance.getTurno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of isStatusPartida method, of class ChungToi.
     
    @Test
    public void testIsStatusPartida() {
        System.out.println("isStatusPartida");
        ChungToi instance = new ChungToi();
        boolean expResult = false;
        boolean result = instance.isStatusPartida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of setStatusPartida method, of class ChungToi.
     
    @Test
    public void testSetStatusPartida() {
        System.out.println("setStatusPartida");
        boolean statusPartida = false;
        ChungToi instance = new ChungToi();
        instance.setStatusPartida(statusPartida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of setTurno method, of class ChungToi.
     
    @Test
    public void testSetTurno() {
        System.out.println("setTurno");
        int turno = 0;
        ChungToi instance = new ChungToi();
        instance.setTurno(turno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of getVencedor method, of class ChungToi.
     
    @Test
    public void testGetVencedor() {
        System.out.println("getVencedor");
        ChungToi instance = new ChungToi();
        int expResult = 0;
        int result = instance.getVencedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of setVencedor method, of class ChungToi.
     
    @Test
    public void testSetVencedor() {
        System.out.println("setVencedor");
        int vencedor = 0;
        ChungToi instance = new ChungToi();
        instance.setVencedor(vencedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */

    /**
     * Test of toString method, of class ChungToi.
     
    @Test
    public void testToString() {
        System.out.println("toString");
        ChungToi instance = new ChungToi();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */
    
}
