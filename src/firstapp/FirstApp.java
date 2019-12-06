/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstapp;

import Config.DBConnection;
import java.sql.Connection;

/**
 *
 * @author mahmoudgabr
 */
public class FirstApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBConnection dbConnect = new DBConnection();
        Connection connect = dbConnect.getConnection();
        new Register(connect).setVisible(true);
    }
    
}
