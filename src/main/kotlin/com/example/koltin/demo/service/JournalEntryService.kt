package com.example.koltin.demo.service

import com.example.koltin.demo.model.JournalEntry
import com.example.koltin.demo.repository.JournalEntryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class JournalEntryService {

    @Autowired
    lateinit var journalEntryRepository: JournalEntryRepository

    fun saveEntry(journalEntry: JournalEntry) {
        journalEntryRepository.save(journalEntry)
    }

}