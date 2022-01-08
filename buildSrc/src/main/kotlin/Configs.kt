import org.gradle.api.JavaVersion

object AppConfig {
    const val applicationId = "com.atticpic.myapplication"
    const val minSdk = 23
    const val completeSdk = 31
    const val targetSdk = 31
    const val jvmTarget = "1.8"
    val javaVersion = JavaVersion.VERSION_1_8
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Modules {
    const val app = ":app"
    const val data = ":data"
    const val domain = ":domain"
}
