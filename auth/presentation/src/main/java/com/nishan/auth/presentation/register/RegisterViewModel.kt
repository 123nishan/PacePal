package com.nishan.auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nishan.auth.domain.UserDataValidator
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class RegisterViewModel(
    private val userDataValidator: UserDataValidator
): ViewModel() {
    var state by mutableStateOf(RegisterState())
    private set
    init {
        state.email.run {
            snapshotFlow { this }
        }
            .onEach {
                    state = state.copy(
                        isEmailValid = userDataValidator.isValidEmail(it.toString())
                    )
            }
            .launchIn(
                viewModelScope
            )

        state.password.run {
            snapshotFlow { this }
        }
            .onEach {
                state = state.copy(
                    passwordValidationState = userDataValidator.validatePassword(it.toString())
                )
            }
            .launchIn(
                viewModelScope
            )
    }
    fun onAction(actionLRegisterAction: RegisterAction) {

    }


}