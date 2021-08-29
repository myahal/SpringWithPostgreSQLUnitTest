package com.example.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class MessageServiceTest {
    @InjectMocks
    MessageService messageService;
    @Mock
    MessageSource messageSource;

    @Test
    public void testGetMessage() {
        Mockito.doReturn("Hello").when(messageSource).getMessage("greeting", null, Locale.getDefault());

        String actualMessage = messageService.getMessageByCode("greeting");
        assertEquals("Hello", actualMessage);
    }
}