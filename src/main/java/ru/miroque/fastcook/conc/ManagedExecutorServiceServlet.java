package ru.miroque.fastcook.conc;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/task")
public class ManagedExecutorServiceServlet extends HttpServlet {

	@Resource
	ManagedExecutorService executor;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Future<String> futureResult = executor.submit(new TransactionSupportCallableTask(new Random().nextInt(100)));
		while (!futureResult.isDone()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			response.getWriter()
					.write("Callable task has received message with following content '" + futureResult.get() + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
