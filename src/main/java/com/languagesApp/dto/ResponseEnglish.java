package com.languagesApp.dto;

import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.awt.*;

@Data
public class ResponseEnglish {
    private String englishWord;
    private String turkishWord;
    private byte[] image;
}
