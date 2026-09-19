package pl.kimorsolutions.smarthome.homemanagement.protocol.model;

import java.io.IOException;
import java.net.Socket;

public abstract class IDevice implements Device{

    protected Socket socketConnection = null;

    protected String ipv4, mac, name,  description;
    protected int port;
    protected DeviceType deviceType;

    protected String getIpv4() {
        return ipv4;
    }

    protected String getMac() {
        return mac;
    }

    protected String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    @Override
    public int getPort() {
        return port;
    }
    protected void disconnectIfConnected() throws IOException {
        if (isConnected()) socketConnection.close();
    }

    protected boolean isConnected(){
        if (socketConnection == null) return false;
        return socketConnection.isConnected();
    }
    protected boolean deviceIsOnline() {
        if (isConnected()) return true;
        else {
            try {
                Socket status = new Socket(ipv4,port);
                status.setSoTimeout(5000);
                return true;
            } catch (IOException e){
                return false;
            }
        }
    }

    public IDevice(String ipv4, int port, String mac, String name, String description, DeviceType deviceType){
        this.ipv4=ipv4;
        this.mac=mac;
        this.port=port;
        this.name=name;
        this.description=description;
        this.deviceType=deviceType;
    }
}
