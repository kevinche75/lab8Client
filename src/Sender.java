

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sender {

    private DatagramChannel channel;
    private SocketAddress address;

    public Sender(DatagramChannel channel) {
        this.channel = channel;
        
    }

    public void setAddress(int port) {
      address = new InetSocketAddress("localhost", port);
    }

    public <T> void send(MessageType command, T argument, int token){
        ClientMessage message = new ClientMessage(command, argument, token);
        ByteArrayOutputStream sendedstreambuffer = new ByteArrayOutputStream();
        try (ObjectOutputStream sendedstream = new ObjectOutputStream(sendedstreambuffer)) {
            sendedstream.writeObject(message);
            sendedstream.flush();
            ByteBuffer buffer = ByteBuffer.wrap(sendedstreambuffer.toByteArray());
            channel.send(buffer, address);
            buffer.clear();
            System.out.println("===\nСообщение послано");
        } catch (IOException e) {
            System.out.println("===\nНепредвиденная ошибка");
        }
    }
}
