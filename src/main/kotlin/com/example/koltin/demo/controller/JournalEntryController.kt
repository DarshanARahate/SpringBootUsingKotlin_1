package com.example.koltin.demo.controller

import com.example.koltin.demo.model.JournalEntry
import com.example.koltin.demo.service.JournalEntryService
import org.springframework.beans.factory.annotation.Autowired
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

    private val journalEntries = HashMap<Long, JournalEntry>()

    @Autowired
    lateinit var journalEntryService: JournalEntryService


    @GetMapping
    public fun getAll(): List<JournalEntry> {
        return journalEntries.values.toList()
    }

    @PostMapping
    public fun createEntry(@RequestBody entry: JournalEntry): Boolean {
        journalEntryService.saveEntry(entry)
        return true
    }

    @GetMapping("id/{myId}")
    public fun getJournalEntryById(@PathVariable myId: Long): JournalEntry? {
        return journalEntries.get(myId)
    }

    @DeleteMapping("id/{myId}")
    public fun deleteJournalEntryById(@PathVariable myId: Long): JournalEntry? {
        return journalEntries.remove(myId)
    }

    @PutMapping("id/{myId}")
    public fun updateJournalById(
        @PathVariable myId: Long,
        @RequestBody entry: JournalEntry
    ): JournalEntry? {
        return journalEntries.put(myId, entry)
    }
}