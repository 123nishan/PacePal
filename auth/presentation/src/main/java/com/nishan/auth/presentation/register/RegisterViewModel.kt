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
                val isValidEmail = userDataValidator.isValidEmail(it.toString())
                    state = state.copy(
                        isEmailValid = isValidEmail,
                        canRegister = isValidEmail && state.passwordValidationState.isValidPassword
                                && !state.isRegistering
                    )
            }
            .launchIn(
                viewModelScope
            )

        state.password.run {
            snapshotFlow { this }
        }
            .onEach {
                val passwordValidationState = userDataValidator.validatePassword(it.toString())
                state = state.copy(
                    passwordValidationState = passwordValidationState,
                    canRegister = state.isEmailValid && state.passwordValidationState.isValidPassword
                            && !state.isRegistering
                )
            }
            .launchIn(
                viewModelScope
            )
    }
    fun onAction(actionLRegisterAction: RegisterAction) {

    }


}