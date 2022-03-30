package arif.demiryas.myapplication1

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_hosgeldiniz.*
import java.util.prefs.AbstractPreferences

class MainHosgeldiniz : AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hosgeldiniz)

        preferences = getSharedPreferences("ProfilBilgileri", MODE_PRIVATE)
        var kayitliKullanicii = preferences.getString("adSoyad","")
        var kayitlisifreee = preferences.getString("sifree","")
        kullaniciAdi.text = "Kullanıcı Adı :"+kayitliKullanicii.toString()
        kullaniciSifre.text = "Kullanıcı Şifresi :"+kayitlisifreee.toString()

        btnCikisYap.setOnClickListener {
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}