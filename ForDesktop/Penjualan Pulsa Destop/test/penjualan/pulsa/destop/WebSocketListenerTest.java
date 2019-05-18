/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.pulsa.destop;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ardiyan
 */
public class WebSocketListenerTest {
    
    public WebSocketListenerTest() {
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
     * Test of onOpen method, of class WebSocketListener.
     */
    @Test
    public void testOnOpen() {
        System.out.println("onOpen");
        WebSocketListener instance = new WebSocketListenerImpl();
        instance.onOpen();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onClose method, of class WebSocketListener.
     */
    @Test
    public void testOnClose() {
        System.out.println("onClose");
        WebSocketListener instance = new WebSocketListenerImpl();
        instance.onClose();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onError method, of class WebSocketListener.
     */
    @Test
    public void testOnError() {
        System.out.println("onError");
        WebSocketListener instance = new WebSocketListenerImpl();
        instance.onError();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onMessage method, of class WebSocketListener.
     */
    @Test
    public void testOnMessage() {
        System.out.println("onMessage");
        String message = "";
        WebSocketListener instance = new WebSocketListenerImpl();
        instance.onMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class WebSocketListenerImpl implements WebSocketListener {

        @Override
        public void onOpen() {
        }

        @Override
        public void onClose() {
        }

        @Override
        public void onError() {
        }

        @Override
        public void onMessage(String message) {
        }
    }
    
}
