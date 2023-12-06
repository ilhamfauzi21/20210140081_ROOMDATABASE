package com.example.roomsiswaa.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomsiswab.data.Siswa
import com.example.roomsiswab.data.SiswaDao

@Database(entities = [Siswa::class],version = 1, exportSchema = false)
abstract class DatabaseSiswa : RoomDatabase(){
    abstract fun siswaDao() : SiswaDao

    companion object{
        @Volatile
        private var Instance: DatabaseSiswa? = null

        fun getDatabase(context: Context): DatabaseSiswa{
            return (Instance?: synchronized(this){
                Room.databaseBuilder(context,
                    DatabaseSiswa::class.java,"siswa_database")
                    .build().also { Instance = it }
            })
        }
    }
}