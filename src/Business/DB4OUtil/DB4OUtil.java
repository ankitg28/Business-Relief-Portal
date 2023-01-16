package Business.DB4OUtil;

import BusinessReliefPortal.BusinessReliefSystem;
import BusinessReliefPortal.ConfigureBusinessPortal;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;
import java.nio.file.Paths;

/**
 *
 * @author ritvikparamkusham
 */
public class DB4OUtil {

    private static final String FILENAME = Paths.get("Databank28.db4o").toAbsolutePath().toString();// path to the data store
    private static DB4OUtil dB4OUtil;
    //ObjectContainer conn = createConnection();
    public synchronized static DB4OUtil getInstance(){
        if (dB4OUtil == null){
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    protected synchronized static void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }

    private ObjectContainer createConnection() {
        try {
            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            ObjectContainer db = Db4oEmbedded.openFile(config, FILENAME);
            config.common().add(new TransparentPersistenceSupport());
            //Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //Controls the depth/level of updation of Object
            config.common().updateDepth(Integer.MAX_VALUE);
            //Register your top most Class here
            config.common().objectClass(BusinessReliefSystem.class).cascadeOnUpdate(true); // Change to the object you want to save
            return db;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }

    public synchronized void storeSystem(BusinessReliefSystem system) {
       ObjectContainer conn = createConnection();
       ObjectSet<BusinessReliefSystem> systems = conn.query(BusinessReliefSystem.class);
//       if(!systems.isEmpty()) {
//       conn.delete(new BusinessReliefSystem());
//       }
        conn.store(system);
        conn.commit();
        conn.close();
    }
    
    public BusinessReliefSystem retrieveSystem(){
      ObjectContainer conn = createConnection();
        ObjectSet<BusinessReliefSystem> systems = conn.query(BusinessReliefSystem.class); // Change to the object you want to save
        BusinessReliefSystem system;
        if (systems.isEmpty()) {
            system = ConfigureBusinessPortal.configure();  // If there's no System in the record, create a new one
        } else {
            system = systems.get(systems.size() - 1);
           
        }
        conn.close();
        return system;
    }
}