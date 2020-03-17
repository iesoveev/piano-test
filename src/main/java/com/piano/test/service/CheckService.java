package com.piano.test.service;

import com.piano.test.dto.UserCheckDto;
import com.piano.test.exception.ErrorMessage;
import com.piano.test.exception.UnsupportedUserOperationException;
import com.piano.test.exception.UserNotFoundException;
import com.piano.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckService {

    private static final Logger log = LogManager.getLogger(CheckService.class);

    private final UserRepository userRepository;

    public UserCheckDto checkUser(final Integer roomId,
                                  final Boolean entrance,
                                  final Long keyId) {
        final var user = userRepository.findById(keyId)
                .orElseThrow(UserNotFoundException::new);

        if (entrance && (user.getEntrance() || keyId % roomId != 0)) {
            log.warn("Пользователь - " + keyId + " попытался войти в комнату - " + roomId);
            throw new UnsupportedUserOperationException(ErrorMessage.UNSUPPORTED_OPERATION);
        }

        user.setEntrance(entrance);
        userRepository.save(user);
        final String msg = entrance ? " вошел в комнату - " : " вышел из комнаты - ";
        log.info("Пользователь - " + keyId + msg + roomId);
        return new UserCheckDto(keyId);
    }
}
