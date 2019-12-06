package services;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author mahmoudgabr
 */
public class AppService {

    protected Connection connect;
    protected PreparedStatement st;

    public AppService(Connection connect) {
        this.connect = connect;
    }

}
