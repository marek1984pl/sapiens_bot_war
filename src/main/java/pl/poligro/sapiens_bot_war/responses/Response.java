/*
 * Copyright 2019 Marek Morawiec
 * User: marek
 * Date: 19.09.2019
 * Time: 18:35
 */

package pl.poligro.sapiens_bot_war.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.poligro.sapiens_bot_war.enums.Action;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private Action action;

    public String getAction() {
        return action.toString().toLowerCase();
    }
}
