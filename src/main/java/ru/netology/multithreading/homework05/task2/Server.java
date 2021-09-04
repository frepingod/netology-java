package ru.netology.multithreading.homework05.task2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress("localhost", 8080));

        while (true) {
            try (SocketChannel socketChannel = serverChannel.accept()) {
                final ByteBuffer inputBuffer = ByteBuffer.allocate(2 << 10);

                while (socketChannel.isConnected()) {
                    int bytesCount = socketChannel.read(inputBuffer);

                    if (bytesCount == -1) {
                        break;
                    }

                    final String msg = new String(inputBuffer.array(), 0, bytesCount, StandardCharsets.UTF_8);
                    final String msgWithoutSpaces = removeSpaces(msg);
                    inputBuffer.clear();
                    System.out.println("Received a message from a client: " + msg);

                    socketChannel.write(ByteBuffer.wrap(("Message without spaces: " + msgWithoutSpaces).getBytes(StandardCharsets.UTF_8)));
                }
            }
        }
    }

    private static String removeSpaces(String msg) {
        return msg.replaceAll(" ", "");
    }
}