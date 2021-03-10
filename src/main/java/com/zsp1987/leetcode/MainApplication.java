package com.zsp1987.leetcode;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.LoggerFormat;
import io.vertx.ext.web.handler.LoggerHandler;
import lombok.Data;

public class MainApplication {

	public static void main(String[] args) {
		LoggerHandler.create(false, LoggerFormat.DEFAULT);
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new MainVerticle());
	}
}

class MainVerticle extends AbstractVerticle {
	@Override
	public void start() throws Exception {
		HttpServer server = vertx.createHttpServer();

		Router router = Router.router(vertx);

		Person p = new Person();
		p.setAge(10);
		p.setName("Li Feng");

		router.get("/").respond(ctx -> {
			throw new RuntimeException("test");
		});

		server.requestHandler(router).listen(8080);
	}
}

@Data
class Person {
	private String name;
	private int age;

}