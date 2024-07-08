package academy.prog;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter your login: ");
			String login = scanner.nextLine();
	
			Thread th = new Thread(new GetThread(login));
			th.setDaemon(true);
			th.start();

            System.out.println("Enter your message: ");
			while (true) {
				String text = scanner.nextLine();
				String receiver = null;
				if (text.isEmpty()) break;
				if (text.startsWith("@")) {
					int lastIndex = text.indexOf(" ");
					receiver = text.substring(1, lastIndex);
					text = text.substring(lastIndex + 1);
				}
				Message m = new Message(login, text, receiver);
                int res = m.send(Utils.getURL() + "/add");

				if (res != 200) { // 200 OK
					System.out.println("HTTP error occurred: " + res);
					return;
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
