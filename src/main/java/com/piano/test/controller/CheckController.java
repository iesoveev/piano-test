package com.piano.test.controller;

import com.piano.test.dto.UserCheckDto;
import com.piano.test.service.CheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/check", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CheckController {

    private final CheckService checkService;

    @GetMapping
    public UserCheckDto checkUser(@RequestParam Integer roomId,
                                  @RequestParam Boolean entrance,
                                  @RequestParam Long keyId) {

        return checkService.checkUser(roomId, entrance, keyId);
    }
}
