package com.atticpic.myapplication.presentation.screen.login

import androidx.lifecycle.viewModelScope
import com.atticpic.myapplication.presentation.base.BaseViewModel
import com.atticpic.myapplication.presentation.screen.login.model.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import interactor.LoginInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.UserLogin
import javax.inject.Inject

private const val LOGIN_ERROR = "Ошибка входа! Проверьте email и пароль"
private const val NETWORK_ERROR = "Ошибка получения данных из сети"

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginInteractor: LoginInteractor
) : BaseViewModel<LoginState, Throwable>() {

    fun userLogin(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                setLoading(null)
                val token = loginInteractor.userLogin(UserLogin(email, password))
                token?.let {
                    setSuccessful(
                        LoginState(
                            email,
                            password,
                            token
                        )
                    )
                }
                    ?: setError(Throwable(LOGIN_ERROR))
            } catch (e: Exception) {
                setError(Throwable(Throwable(NETWORK_ERROR)))
            }
        }
    }
}
