package com.albertomagalhaes.doggos.data.internal.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.albertomagalhaes.doggos.commons.extensions.Identifiable
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
@Entity(tableName = "table_breed")
data class BreedModel(
    @PrimaryKey
    override val id: String = UUID.randomUUID().toString(),
    val name: String,
    val subBreads: List<String>?,
    val picturesURL: List<String>?,
    var isFavorite: Boolean = false
) : Parcelable, Identifiable<String>