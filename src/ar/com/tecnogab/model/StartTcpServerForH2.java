package ar.com.tecnogab.model;

import org.h2.tools.Server;

public class StartTcpServerForH2 {

	public StartTcpServerForH2() {
	}

	static Server server;
	private static final String SERVER_PORT = "9092";

	public static void start() {

		try {
			server = Server.createTcpServer(new String[] { "-tcpPort", SERVER_PORT, "-tcpAllowOthers" }).start();
			server = Server.createWebServer("-trace").start();
			System.out.println(server.getStatus());
		} catch (Exception p_exception) {
			System.out.println("Error with Server: " + p_exception.getMessage());
		}
	}
	
	public static void stop(){
		server.stop();
		server.shutdown();
		System.out.println(server.getStatus());
	}

}
