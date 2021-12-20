package removekFromList;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class AlertService {
    AlertDAO alertDao;

    public AlertService(AlertDAO alertDao) {
        this.alertDao = alertDao;
    }

    private final MapAlertDAO storage = new MapAlertDAO();

    public UUID raiseAlert() {
        return alertDao.addAlert(new Date());
    }

    public Date getAlertTime(UUID id) {
        return alertDao.getAlert(id);
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

interface AlertDAO {
    public UUID addAlert(Date time);
    public Date getAlert(UUID id);
}

