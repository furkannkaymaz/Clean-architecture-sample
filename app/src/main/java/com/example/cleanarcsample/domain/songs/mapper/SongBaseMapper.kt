package com.example.cleanarcsample.domain.songs.mapper

interface SongBaseMapper<I, O> {
    fun map(input: I): O
}
