package put.io.patterns.implement;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class SystemMonitor {

    private List<SystemStateObserver> observers = new ArrayList<SystemStateObserver>();

//    public void addSystemStateObserver(SystemStateObserver observer){
//
//    }
//
//    public void removeSystemStateObserver(SystemStateObserver observer){
//
//    }

    private SystemInfo si;

    private HardwareAbstractionLayer hal;

    private OperatingSystem os;

    private SystemState lastSystemState = null;

    public SystemMonitor(){
        si = new SystemInfo();
        hal = si.getHardware();
        os = si.getOperatingSystem();

    }

    public void notifyObservers(){
        for(SystemStateObserver observer : this.observers){
            observer.update(this);
        }
    }





    public SystemState getLastSystemState() {
        return lastSystemState;
    }
}
