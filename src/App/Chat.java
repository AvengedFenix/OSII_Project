/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

/**
 *
 * @author xioma
 */
import java.rmi.*;
import java.rmi.server.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class Chat extends UnicastRemoteObject implements ChatInterface {

    public String name;
    public Vector<ChatInterface> client = new Vector();
    public HashMap<String, ChatInterface> clientes = new HashMap();

    public Chat(String n) throws RemoteException {
        this.name = n;
    }

    public String getName() throws RemoteException {
        return this.name;
    }

    public void setClient(ChatInterface c) throws RemoteException {
        client.add(c);
    }

    public void setClient(String userName, ChatInterface c) throws RemoteException {
        this.setClient(c);
        clientes.put(userName, c);
    }

    public Vector<ChatInterface> getClient() {
        return client;
    }

    public void send(String s) throws RemoteException {
        System.out.println(s);
        Iterator<ChatInterface> it = this.client.iterator();
        while (it.hasNext()) {
            it.next().send(s);
        }
    }

    public void send(String s, String userName) throws RemoteException {
        this.clientes.get(userName).send(s);
    }
}
