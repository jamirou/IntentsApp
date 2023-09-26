import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Routes(
    val icon: ImageVector,
    val title: String,
    val route: String
) {
    object PhoneView: Routes(Icons.Default.Phone, "Phone", "PhoneView")
    object SmsView: Routes(Icons.Default.Close, "SMS", "SmsView")
    object EmailView: Routes(Icons.Default.Email, "Email", "EmailView")
}
