package com.example.koltin.demo.model

import jakarta.persistence.*

@Entity
@Table(name = "journal_entry")
data class JournalEntry(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var title: String,
    var content: String
)

