package pl.kimorsolutions.smarthome.homemanagement.protocol.devices;

import pl.kimorsolutions.smarthome.homemanagement.protocol.model.Device;
import pl.kimorsolutions.smarthome.homemanagement.protocol.model.DeviceType;
import pl.kimorsolutions.smarthome.homemanagement.protocol.model.IDevice;
import pl.kimorsolutions.smarthome.homemanagement.protocol.packets.Packet;

public class MovementSensorDevice extends IDevice {


    public MovementSensorDevice(String ipv4, int port, String mac, String name, String description, DeviceType deviceType) {
        super(ipv4, port, mac, name, description, deviceType);
    }

    @Override
    public DeviceType getType() {
        return DeviceType.MOVEMENT_SENSOR;
    }

    @Override
    public String getCustomName() {
        return this.name;
    }

    @Override
    public String getIpv4Address() {
        return this.ipv4;
    }

    @Override
    public String getMacAddress() {
        return mac;
    }
    @Override
    public void connect() {

    }

    @Override
    public void handshake() {

    }

    @Override
    public void disconnect() {

    }

    @Override
    public void writePacket(Packet packet) {

    }

    @Override
    public void readPacket() {

    }

    @Override
    public float[] readBasicDeviceInformation() {
        return new float[8];
    }
}
