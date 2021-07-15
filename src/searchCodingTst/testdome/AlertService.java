package searchCodingTst.testdome;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
//Refactor the AlertService and MapAlertDAO classes:
//
//Create a new package-private interface, named AlertDAO, that contains the same methods as MapAlertDAO.
//MapAlertDAO should implement the AlertDAO interface.
//AlertService should have a constructor that accepts AlertDAO.
//The raiseAlert and getAlertTime methods should use the object passed through the constructor.
interface AlertDAO {
    UUID addAlert(Date time);
    Date getAlert(UUID id);
}

class AlertService {
    //private final MapAlertDAO storage = new MapAlertDAO();
	private AlertDAO storage; 
    public AlertService(AlertDAO storage) {
    	this.storage = storage;
    }
    public UUID raiseAlert() {
        return this.storage.addAlert(new Date());
    }
	
    public Date getAlertTime(UUID id) {
        return this.storage.getAlert(id);
    }	
}

class MapAlertDAO implements AlertDAO {
    private final Map<UUID, Date> alerts = new HashMap<UUID, Date>();
	
    public UUID addAlert(Date time) {
    	UUID id = UUID.randomUUID();
        this.alerts.put(id, time);
        return id;
    }
	
    public Date getAlert(UUID id) {
        return this.alerts.get(id);
    }	
}
