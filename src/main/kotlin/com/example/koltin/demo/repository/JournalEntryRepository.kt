package com.example.koltin.demo.repository

import com.example.koltin.demo.model.JournalEntry
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JournalEntryRepository : JpaRepository<JournalEntry, Int> {
}