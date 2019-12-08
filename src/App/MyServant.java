/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyServant extends UnicastRemoteObject implements MyService {

    public MyServant() throws RemoteException {
        super();
    }

    @Override
    public String echo(String input) throws RemoteException {

        return "From server: " + input;

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
