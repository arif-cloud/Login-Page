package arif.demiryas.myapplication1

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preferences = getSharedPreferences("ProfilBilgileri", MODE_PRIVATE)

        btnGirisYap.setOnClickListener {
            var kayitliKullanici = preferences.getString("adSoyad","")
            var kayitliSifre = preferences.getString("sifree","")

            var girisKullanici = girisKullaniciAdi.text.toString()
            var girisSifree = girisSifre.text.toString()

            if ((kayitliKullanici == girisKullanici) && (kayitliSifre == girisSifree)){
                intent = Intent(applicationContext,MainHosgeldiniz::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(applicationContext,"Giriş Bilgileri Hatalı !",Toast.LENGTH_LONG).show()
            }
        }
        btnKayitOl.setOnClickListener {
            intent = Intent(applicationContext,MainKayitOl::class.java)
            startActivity(intent)
        }

    }
}