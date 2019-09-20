/*
 * Copyright 2019 Marek Morawiec
 * User: marek
 * Date: 19.09.2019
 * Time: 18:12
 */

package pl.poligro.sapiens_bot_war.requests;

import lombok.Data;

@Data
public class Request {
    String playerAction;
    Integer playerLife;
    String opponentAction;
    Integer opponentLife;
    String result;
}
