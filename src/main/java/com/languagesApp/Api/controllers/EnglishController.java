package com.languagesApp.Api.controllers;

import com.languagesApp.Business.EnglishService;
import com.languagesApp.Entities.concretes.Word;
import com.languagesApp.core.ImageGenerate;
import com.languagesApp.dto.ResponseEnglish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.IMAGE_JPEG;

@RestController
@RequestMapping("/api/v1")
public class EnglishController {

    @Autowired
    private EnglishService englishService;

    @Autowired
    private ImageGenerate imageGenerate;


    @GetMapping("/english/{id}")
    public ResponseEntity<byte[]> resimGoruntule(@PathVariable Long id) {
        Optional<Word> resim = englishService.findById(id);
        if (resim.isPresent()) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(IMAGE_JPEG);
            return new ResponseEntity<>(resim.get().getImage(), headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/english")
    public ResponseEnglish  getWord(@RequestParam String englishWord) {
        Word byWordWord = englishService.findByEnglishWord(englishWord);
        ResponseEnglish responseEnglish = new ResponseEnglish();
        responseEnglish.setEnglishWord(byWordWord.getEnglishWord());
        responseEnglish.setTurkishWord(byWordWord.getTurkishWord());
        responseEnglish.setImage(byWordWord.getImage());
        return responseEnglish;
    }

}
