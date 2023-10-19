package com.languagesApp.Business;

import com.languagesApp.DataAccess.EnglishRepository;
import com.languagesApp.Entities.concretes.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class EnglishService {

    @Autowired
    private EnglishRepository englishRepository;


    public Optional<Word> findById(Long id) {
        return englishRepository.findById(id);
    }
    
    public Optional<Word> getByWord(String englishWord) {
        return englishRepository.findByEnglishWord(englishWord);
    }


    public Optional<Word> findByName(String word) {
        return englishRepository.findByEnglishWord(word);
    }

    public Word findByEnglishWord(String englishWord) {
       return englishRepository.findByEnglishWord(englishWord).get();
    }
}
