package org.example;

import org.example.calculate.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomWebApplicationServer {
    private final int port;
    //3번째 단계 Thread Pool 적용하기
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try(ServerSocket socket = new ServerSocket(port)){
            logger.info("[CustomWebApplicationServer] started {} port.", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client");

            /**
             * 1. 메인쓰레드에서 사용자의 요청을 처리한다.
             * 2. 사용자 요청이 들어올 때마다 Thread를 새로 생성하여 사용자의 요청을 처리한다.
             * 3. Thraed Pool을 구현하여 좀 더 안정적인 구조로 변화시킨다.
             * */
            while((clientSocket = socket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected!");
                //클라이언트가 들어올때마다 별도의 쓰레드를 생성하여 처리함.
                // 사용자 요청이 들어올때마다 쓰레드가 생성됨
                //  > 쓰레드 생성시 메모리 할당작업이 많아지므로 성능이 떨어지게된다.
                //  > cpu-context-switch 횟수가 많아짐
                //  > cpu와 memory 사용량이 급격히 증가함.
                //  > 최악의 경우 서버가 다운될 수 있음.
                // 해결책 : 쓰레드를 미리 생성해놓고 생성되어 있는 쓰레드를 사용하는 Thread Pool 방식을 사용해야함.
                //new Thread(new ClientRequestHandler(clientSocket)).start();  > 2번째 단계

                //3번째 단계 Thread Pool 적용하기
                executorService.execute(new ClientRequestHandler(clientSocket));



            }
        }
    }
}
