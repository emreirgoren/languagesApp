package com.languagesApp.Api.controllers;

import com.languagesApp.Business.WordService;
import com.languagesApp.Entities.concretes.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.IMAGE_JPEG;

@RestController
@RequestMapping("/api/v1")
public class WordControllers {

    @Autowired
    private WordService wordService;




    @GetMapping("/english/{id}")
    public ResponseEntity<byte[]> resimGoruntule(@PathVariable Long id) {
        Optional<Word> resim = wordService.findById(id);
        if (resim.isPresent()) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(IMAGE_JPEG);
            return new ResponseEntity<>(resim.get().getImage(), headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/english")
    public Optional<Word> getWord(@RequestParam String englishWord){
        return wordService.findByEnglishWord(englishWord);
    }

}
