package pl.kimorsolutions.smarthome.homemanagement.protocol.model;

public enum DeviceType {

    THERMOSTAT(0,"Grzejnik elektryczny"),
    AIR_PARAMETER_READER(0,"Czytnik parametrów powietrza"),
    LED_STRIP(0,"Taśma LED"),
    ELECTRICITY_METER(0,"Miernik zużycia prądu"),
    MOVEMENT_SENSOR(0,"Czujnik ruchu");

    private int icon;
    private String name;

    DeviceType(int icon, String name){
        this.icon=icon;
        this.name=name;
    }

}
