package com.languagesApp.core.utils;

import com.languagesApp.Business.WordService;
import com.languagesApp.Entities.concretes.Word;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageGenerate {

    @Autowired
    private WordService wordService;


    public byte[] generate(Word english) {
        byte[] image;
        Optional<Word> word = wordService.getByWord(english.getEnglishWord());
        if (word.isPresent()) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            image = word.get().getImage();
            return image;
        } else {
            return null;
        }

    }

    public ResponseEntity<byte[]> resimGoruntule(String word) {
        Optional<Word> resim = wordService.findByName(word);
        if (resim.isPresent()) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(resim.get().getImage(), headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public List<Object> liste(String englishWord) {
        List<Object> liste1 = new ArrayList<>();
        liste1.add(wordService.getByWord(englishWord).get().getEnglishWord());
        liste1.add(wordService.getByWord(englishWord).get().getTurkishWord());
        //liste1.add(generate(wordService.getByWord(englishWord).get()));
        liste1.add(resimGoruntule(englishWord));
        liste1.add(generate(wordService.getByWord(englishWord).get()));
        return liste1;
    }


}
