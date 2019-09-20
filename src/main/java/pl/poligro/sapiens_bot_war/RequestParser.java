/*
 * Copyright 2019 Marek Morawiec
 * User: marek
 * Date: 20.09.2019
 * Time: 08:05
 */

package pl.poligro.sapiens_bot_war;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.poligro.sapiens_bot_war.responses.Response;

@Component
public class RequestParser {

    private Response response;

    @Autowired
    public void setResponse(Response response) {
        this.response = response;
    }

    public Response parse(String request) {

        //todo parsing implementation

        return response;
    }
}
