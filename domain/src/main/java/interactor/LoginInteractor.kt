package interactor

import model.UserLogin

interface LoginInteractor {
    suspend fun userLogin(userLogin: UserLogin): String? // Возвращает токен или null если ошибка
}
