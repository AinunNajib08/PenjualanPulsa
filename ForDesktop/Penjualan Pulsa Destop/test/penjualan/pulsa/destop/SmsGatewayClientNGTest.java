/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.pulsa.destop;

import org.java_websocket.handshake.ServerHandshake;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Ardiyan
 */
public class SmsGatewayClientNGTest {
    
    public SmsGatewayClientNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of onOpen method, of class SmsGatewayClient.
     */
    @Test
    public void testOnOpen() {
        System.out.println("onOpen");
        ServerHandshake handshakedata = null;
        SmsGatewayClient instance = null;
        instance.onOpen(handshakedata);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onMessage method, of class SmsGatewayClient.
     */
    @Test
    public void testOnMessage() {
        System.out.println("onMessage");
        String message = "";
        SmsGatewayClient instance = null;
        instance.onMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onClose method, of class SmsGatewayClient.
     */
    @Test
    public void testOnClose() {
        System.out.println("onClose");
        int code = 0;
        String reason = "";
        boolean remote = false;
        SmsGatewayClient instance = null;
        instance.onClose(code, reason, remote);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onError method, of class SmsGatewayClient.
     */
    @Test
    public void testOnError() {
        System.out.println("onError");
        Exception ex = null;
        SmsGatewayClient instance = null;
        instance.onError(ex);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
