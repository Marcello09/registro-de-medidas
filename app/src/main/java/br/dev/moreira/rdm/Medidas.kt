package br.dev.moreira.rdm

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Medidas(
    @PrimaryKey val timestamp: Long,
    @ColumnInfo(name = "chest") val chest: Float,
    @ColumnInfo(name = "right_biceps") val right_biceps: Float,
    @ColumnInfo(name = "left_biceps") val left_biceps: Float,
    @ColumnInfo(name = "right_forearm") val right_forearm: Float,
    @ColumnInfo(name = "left_forearm") val left_forearm: Float,
    @ColumnInfo(name = "waist") val waist: Float,
    @ColumnInfo(name = "hips") val hips: Float,
    @ColumnInfo(name = "right_thigh") val right_thigh: Float,
    @ColumnInfo(name = "left_thigh") val left_thigh: Float,
    @ColumnInfo(name = "right_calf") val right_calf: Float,
    @ColumnInfo(name = "left_calf") val left_calf: Float,
    @ColumnInfo(name = "weight") val weight: Float
    )