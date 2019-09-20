/*
 * Copyright 2019 Marek Morawiec
 * User: marek
 * Date: 19.09.2019
 * Time: 16:55
 */

package pl.poligro.sapiens_bot_war.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.poligro.sapiens_bot_war.enums.Action;
import pl.poligro.sapiens_bot_war.requests.Request;
import pl.poligro.sapiens_bot_war.responses.Response;

import java.util.Random;

@RestController
public class BotRestController {

    private Random random;
    private Response response;

    @Autowired
    public void setRandom(Random random) {
        this.random = random;
    }

    @Autowired
    public void setResponse(Response response) {
        this.response = response;
    }

    @GetMapping("/bot")
    public ResponseEntity<String> botError(@RequestBody String request) {
        //todo check this in browser http://localhost:8080/bot
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @PostMapping("/bot")
    public ResponseEntity<Response> bot(@RequestBody String request) {
        JSONObject jsonObject = new JSONObject(request);
        Response response = null;
        Request req = new Request();
        if (jsonObject.has("game")) {
            response = handleGameCommand(jsonObject.get("game").toString());
        } else {
            parseRequest(jsonObject, req);
            response = nextMove(req);
        }
        return ResponseEntity.ok(response);
    }

    private void parseRequest(JSONObject jsonObject, Request req) {
        req.setOpponentAction(jsonObject.get("opponentAction").toString());
        req.setOpponentLife((Integer) jsonObject.get("opponentLife"));
        req.setPlayerAction(jsonObject.get("playerAction").toString());
        req.setPlayerLife((Integer) jsonObject.get("playerLife"));
        req.setResult(jsonObject.get("result").toString());
    }

    private Response nextMove(Request req) {
        Response response;
        int rand = random.nextInt() % 3;
        switch (rand) {
            case 0:
                response = new Response(Action.SHOOT);
                break;
            case 1:
                response = new Response(Action.BLOCK);
                break;
            case 2:
                response = new Response(Action.RELOAD);
                break;
            default:
                response = new Response(Action.BLOCK);
        }
        System.out.println("New move: " + response.getAction());
        return response;
    }

    private Response createNewResponse(Action action) {
        response.setAction(action);
        return response;
    }

    private Response handleGameCommand(String gameCommand) {

        switch (gameCommand) {
            case "begin":
                System.out.println("Game begins...");
                return createNewResponse(Action.SHOOT);
            case "winner":
                System.out.println("You won!");
                break;
            case "game over":
                System.out.println("You lose!");
                break;
            default:
                throw new RuntimeException("Unknown game command... : " + gameCommand);
        }
        return null;
    }
}
