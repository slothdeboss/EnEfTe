package com.slothdeboss.enefte.ui.screens.setupProfile

sealed interface SetupProfileEvent {

    data object NavigateBack : SetupProfileEvent

    data object ValidateData : SetupProfileEvent

    data class UpdateField(
        val value: String,
        val type: FieldType
    ) : SetupProfileEvent {

        enum class FieldType {
            NAME, EMAIL, BIO, IMAGE
        }

        companion object {

            fun updateImage(value: String) = UpdateField(value = value, type = FieldType.IMAGE)
            fun updateName(value: String) = UpdateField(value = value, type = FieldType.NAME)
            fun updateEmail(value: String) = UpdateField(value = value, type = FieldType.EMAIL)
            fun updateBio(value: String) = UpdateField(value = value, type = FieldType.BIO)
        }
    }
}


