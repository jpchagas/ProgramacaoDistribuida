/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.distribuida.ct.game;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author joao
 */
public class ChungToiServer {

	public static void main(String[] args) {
		try {
			java.rmi.registry.LocateRegistry.createRegistry(1099);
			System.out.println("RMI registry ready.");
		} catch (RemoteException e) {
			System.out.println("RMI registry already running.");
		}
		try {
			Naming.rebind ("ChungToi", (Remote) new ChungToiImpl());
			System.out.println ("ChungToi is ready.");
		} catch (Exception e) {
			System.out.println ("ChungToi failed:");
			e.printStackTrace();
		}
	}

}