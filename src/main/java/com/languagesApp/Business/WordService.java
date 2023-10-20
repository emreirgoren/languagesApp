package com.languagesApp.Business;

import com.languagesApp.DataAccess.WordRepository;
import com.languagesApp.Entities.concretes.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;


    public Optional<Word> findById(Long id) {
        return wordRepository.findById(id);
    }

    public Optional<Word> getByWord(String englishWord) {
        return wordRepository.findByEnglishWord(englishWord);
    }


    public Optional<Word> findByName(String word) {
        return wordRepository.findByEnglishWord(word);
    }


    public Optional<Word> findByEnglishWord(String englishWord) {
        return wordRepository.findByEnglishWord(englishWord);
    }
}
