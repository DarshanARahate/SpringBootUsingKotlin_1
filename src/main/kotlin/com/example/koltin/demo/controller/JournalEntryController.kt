package com.example.koltin.demo.controller

import com.example.koltin.demo.model.JournalEntry
import com.example.koltin.demo.service.JournalEntryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/journal")
class JournalEntryController {

    @Autowired
    lateinit var journalEntryService: JournalEntryService

    @GetMapping
    public fun getAll(): ResponseEntity<List<JournalEntry>> {
        val list = journalEntryService.getAllEntries()
        if (list.isNotEmpty()) {
            return ResponseEntity(list, HttpStatus.OK)
        } else {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping
    public fun createEntry(@RequestBody entry: JournalEntry): ResponseEntity<JournalEntry> {
        try {
            journalEntryService.saveEntry(entry)
            return ResponseEntity(entry, HttpStatus.CREATED)
        } catch (e: Exception) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping("id/{myId}")
    public fun getJournalEntryById(@PathVariable myId: Long): ResponseEntity<JournalEntry> {
        val journalEntry = journalEntryService.findEntry(myId)
        if (journalEntry.isPresent) {
            return ResponseEntity(journalEntry.get(), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("id/{myId}")
    public fun deleteJournalEntryById(@PathVariable myId: Long): ResponseEntity<JournalEntry> {
        journalEntryService.removeEntry(myId)
        return ResponseEntity<JournalEntry>(HttpStatus.NO_CONTENT)
    }

    @PutMapping("id/{myId}")
    public fun updateJournalById(
        @PathVariable myId: Long,
        @RequestBody entry: JournalEntry
    ): ResponseEntity<JournalEntry> {

        var journalEntry = journalEntryService.findEntry(myId)
        if (journalEntry.isPresent) {
            var oldEntry: JournalEntry = journalEntry.get()
            oldEntry.title = entry.title
            oldEntry.content = entry.content
            journalEntryService.updateJournalEntryById(oldEntry)
            return ResponseEntity(oldEntry, HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }
}