package pl.kimorsolutions.smarthome.homemanagement.protocol.packets;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Packet {

    int header;
    protected float[] content;

    public Packet(int header, float[] content){
        this.header=header;
        this.content=content;
    }

    public int getHeader() {
        return header;
    }

    public float[] getContent() {
        return content;
    }

    public Packet sendTo(String ipv4, int port) throws IOException {
        Socket socket = new Socket(ipv4,port);
        socket.getOutputStream().write(this.toRawByteArray());
        Packet response = readFromInputstream(socket.getInputStream());
        if (response == null){
            return null;
        }
        socket.close();
        return response;
    }

    public static Packet fromByteArray(byte[] bytes, int offset, int length){
        ByteBuffer decodedPacket = ByteBuffer.wrap(bytes,0,length).order(ByteOrder.LITTLE_ENDIAN);

        int header = decodedPacket.getInt();
        float[] data = new float[32];
        for(int i=0; i<8;){
            data[i]=decodedPacket.getFloat();
            i++;
        }
        return new Packet(header,data);
    }
    public static Packet readFromInputstream(InputStream in) throws IOException {
        byte[] bytes = new byte[1024];
        int length = in.read(bytes);
        Packet recvPacket = Packet.fromByteArray(bytes,0,length);
        if (recvPacket.header!=0x100){
            //niepoprawny nagłówek
            System.out.println("Błąd! Nagłowek: "+Integer.toHexString(recvPacket.header));
            return null;
        }
        return recvPacket;
    }
    public byte[] toRawByteArray(){
        ByteBuffer buffer = ByteBuffer.allocate(36).order(ByteOrder.LITTLE_ENDIAN);
        buffer.putInt(header);
        for(int i=0; i<content.length; ) {
            buffer.putFloat(content[i]);
            i++;
        }
        return buffer.array();
    }
    public void describe(){
        System.out.println("[HEADER]");
        System.out.println(Integer.toHexString(this.header));
        System.out.println("[DATA]");
        for(int i=0; i<8;){
            System.out.println(" - " + String.format("%.10f%n", this.content[i]));
            i++;
        }
    }
}
