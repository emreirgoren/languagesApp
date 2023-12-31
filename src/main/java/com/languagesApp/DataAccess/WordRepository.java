package com.languagesApp.DataAccess;


import com.languagesApp.Entities.concretes.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WordRepository extends JpaRepository<Word, Long> {
    Optional<Word> findByEnglishWord(String englishWord);
}
