package interactor

import android.accounts.NetworkErrorException
import model.UserLogin
import java.util.Random

class LoginInteractorImpl : LoginInteractor {

    @Throws(Exception::class)
    override suspend fun userLogin(userLogin: UserLogin): String? {
        Thread.sleep(1000L) // моделируем задерку загрузки
        if (Random().nextBoolean()) throw NetworkErrorException() // моделируем возможную ошибку сети
        Thread.sleep(1000L) // моделируем задерку загрузки
        return if (Random().nextBoolean()) "OK" else null // Случайный возврат результата
    }
}
