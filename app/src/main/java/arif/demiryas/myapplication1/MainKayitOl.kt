package arif.demiryas.myapplication1

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_kayit_ol.*

class MainKayitOl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kayit_ol)

        btnGeriDon.setOnClickListener {
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
        var sharedPre = this.getSharedPreferences("ProfilBilgileri", MODE_PRIVATE)
        btnKaydet.setOnClickListener {
            if (kayitKullaniciAdi.text.isNotEmpty() && kayitSifre.text.isNotEmpty()){
            var adiSoyadi = kayitKullaniciAdi.text.toString()
            var sifre = kayitSifre.text.toString()
            sharedPre.edit().putString("adSoyad",adiSoyadi).apply()
            sharedPre.edit().putString("sifree",sifre).apply()
            Toast.makeText(applicationContext,"Kayıt Başarılı",Toast.LENGTH_LONG).show()
            kayitKullaniciAdi.text.clear()
            kayitSifre.text.clear()
            }
            else{
                Toast.makeText(applicationContext,"Bilgilerinizi Giriniz",Toast.LENGTH_LONG).show()
            }
        }
    }
}