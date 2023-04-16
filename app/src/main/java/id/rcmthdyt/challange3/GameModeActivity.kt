package id.rcmthdyt.challange3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import id.rcmthdyt.challange3.databinding.ActivityGameModeBinding
import id.rcmthdyt.challange3.landingpage.LandingPageThree

class GameModeActivity : AppCompatActivity() {
    private var _binding: ActivityGameModeBinding? = null
    private var gameModeId = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_mode)

        _binding = ActivityGameModeBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        val playerName = intent.getStringExtra(LandingPageThree.PLAYER_NAME)

        _binding?.gameModeTxtVsPlayer?.text = "$playerName vs Pemain2"
        _binding?.gameModeTxtVsCom?.text = "$playerName vs CPU"
        val view: LinearLayout = _binding?.root as LinearLayout

        val snackbar =
            Snackbar.make(this, view, "Selamat Datang $playerName", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("Tutup") { snackbar.dismiss() }
        snackbar.show()


        _binding?.gameModeImgVsPlayer?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            gameModeId = 1
            intent.putExtra(GAME_MODE_ID, gameModeId)
            intent.putExtra(LandingPageThree.PLAYER_NAME, playerName)
            Log.d("game mode", gameModeId.toString())
            startActivity(intent)
        }

        _binding?.gameModeImgVsCom?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            gameModeId = 2
            intent.putExtra(GAME_MODE_ID, gameModeId)
            intent.putExtra(LandingPageThree.PLAYER_NAME, playerName)
            Log.d("game mode", gameModeId.toString())
            startActivity(intent)
        }

    }

    companion object {
        const val GAME_MODE_ID = "id"
    }
}